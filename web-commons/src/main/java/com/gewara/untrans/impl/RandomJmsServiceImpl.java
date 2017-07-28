/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.untrans.impl;

import com.gewara.untrans.JmsService;
import com.gewara.untrans.impl.GewaJmsTemplate;
import com.gewara.util.Assert;
import com.gewara.util.GewaLogger;
import com.gewara.util.WebLogger;
import com.gewara.web.support.ResourceStatsUtil;
import com.gewara.web.support.DynamicStats.LogCounter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.jms.core.MessageCreator;
import org.springframework.jms.support.converter.MessageConversionException;
import org.springframework.util.ObjectUtils;

public class RandomJmsServiceImpl implements JmsService, InitializingBean {
	private final transient GewaLogger dbLogger = WebLogger.getLogger(this.getClass());
	private Map<String, String> queueMap = new HashMap();
	private List<GewaJmsTemplate> jmsTemplateList = new ArrayList();
	private String jmsServers;
	private long receiveTimeout = 20000L;
	private int count = 0;
	private int templateSize;

	public RandomJmsServiceImpl() {
	}

	public RandomJmsServiceImpl(Map<String, String> queueMap) {
		this.queueMap = queueMap;
	}

	public void setJmsServers(String jmsServers) {
		this.jmsServers = jmsServers;
	}

	public void afterPropertiesSet() {
		Assert.isTrue(StringUtils.isNotBlank(this.jmsServers), "jmsServers can\'t be null!!");
		int idx = this.jmsServers.indexOf(40);
		if (idx > 0) {
			int servers = this.jmsServers.indexOf(41);
			this.jmsServers = this.jmsServers.substring(idx + 1, servers);
		}

		ArrayList arg7 = new ArrayList();
		String[] arg2 = StringUtils.split(this.jmsServers, ",");
		int queue = arg2.length;

		String brokerURL;
		for (int list = 0; list < queue; ++list) {
			brokerURL = arg2[list];
			if (StringUtils.isNotBlank(brokerURL)) {
				arg7.add(brokerURL.trim());
			}
		}

		Iterator arg8 = arg7.iterator();

		String arg9;
		while (arg8.hasNext()) {
			arg9 = (String) arg8.next();
			ArrayList arg10 = new ArrayList(arg7);
			arg10.remove(arg9);
			arg10.add(arg9);
			brokerURL = "failover:(" + StringUtils.join(arg10, ",") + ")?randomize=false";
			GewaJmsTemplate template = new GewaJmsTemplate(brokerURL, this.receiveTimeout);
			template.setMessageIdEnabled(false);
			template.setMessageTimestampEnabled(false);
			this.jmsTemplateList.add(template);
		}

		arg8 = this.queueMap.keySet().iterator();

		while (arg8.hasNext()) {
			arg9 = (String) arg8.next();
			this.addQueue(arg9, StringUtils.equals((String) this.queueMap.get(arg9), "persist"), true);
		}

		this.addQueue("defaultMsgQueue", true, true);
		this.templateSize = this.jmsTemplateList.size();
	}

	public void stopAll() {
		Iterator arg0 = this.jmsTemplateList.iterator();

		while (arg0.hasNext()) {
			GewaJmsTemplate template = (GewaJmsTemplate) arg0.next();
			template.stop();
		}

	}

	private GewaJmsTemplate getTemplate() {
		++this.count;
		return (GewaJmsTemplate) this.jmsTemplateList.get(this.count % this.templateSize);
	}

	public void sendMsgToDst(String dst, String msgtag, String msg) {
		this.sendStringMsg(dst, msgtag, msg, (Long) null);
	}

	public void sendMsgToDst(String dst, String msgtag, Map msgMap) {
		this.sendMapMsg(dst, msgtag, msgMap, (Long) null);
	}

	public void sendMsgToDst(String dst, String msgtag, String keyList, Object... params) {
		this.sendMsg(dst, msgtag, keyList, params);
	}

	public void sendMsgToDstWithMultiHead(String queueName, final String msgtag, final Map msgMap,
			final Map<String, String> headMap) {
		long cur = System.currentTimeMillis();
		LogCounter counter = ResourceStatsUtil.getJmsStats().beforeProcess(queueName, cur);

		try {
			GewaJmsTemplate e = this.getTemplate();
			Destination dest = e.getDestination(queueName);
			e.send(dest, new MessageCreator() {
				public Message createMessage(Session session) throws JMSException {
					MapMessage message = session.createMapMessage();
					message.setStringProperty("msgtag", msgtag);
					Iterator arg2;
					if (headMap != null) {
						arg2 = headMap.entrySet().iterator();

						while (arg2.hasNext()) {
							Entry key = (Entry) arg2.next();
							if (StringUtils.isNotBlank((String) key.getKey())
									&& StringUtils.isNotBlank((String) key.getValue())) {
								message.setStringProperty((String) key.getKey(), (String) key.getValue());
							}
						}
					}

					arg2 = msgMap.keySet().iterator();

					while (arg2.hasNext()) {
						Object key1 = arg2.next();
						if (!(key1 instanceof String)) {
							throw new MessageConversionException("Cannot convert non-String key of type ["
									+ ObjectUtils.nullSafeClassName(key1) + "] to JMS MapMessage entry");
						}

						message.setObject((String) key1, msgMap.get(key1));
					}

					return message;
				}
			});
		} catch (Exception arg12) {
			this.dbLogger.warn(arg12, 20);
		} finally {
			ResourceStatsUtil.getJmsStats().afterProcess(counter, System.currentTimeMillis(), false);
		}

	}

	private void sendMsg(String dst, String msgtag, String keyList, Object... params) {
		if (!StringUtils.isBlank(keyList) && params != null) {
			HashMap msgMap = new HashMap();
			String[] keys = keyList.split("[, ]+");
			int i = 0;

			for (int size = Math.min(keys.length, params.length); i < size; ++i) {
				msgMap.put(keys[i], params[i]);
			}

			this.sendMapMsg(dst, msgtag, msgMap, (Long) null);
		}
	}

	private void sendStringMsg(String dst, final String msgtag, final String msg, final Long delay) {
		long cur = System.currentTimeMillis();
		LogCounter counter = ResourceStatsUtil.getJmsStats().beforeProcess(dst, cur);

		try {
			GewaJmsTemplate e = this.getTemplate();
			Destination dest = e.getDestination(dst);
			e.send(dest, new MessageCreator() {
				public Message createMessage(Session session) throws JMSException {
					TextMessage message = session.createTextMessage(msg);
					if (delay != null) {
						message.setLongProperty("AMQ_SCHEDULED_DELAY", delay.longValue());
					}

					message.setStringProperty("msgtag", msgtag);
					return message;
				}
			});
		} catch (Exception arg12) {
			this.dbLogger.warn(arg12, 20);
		} finally {
			ResourceStatsUtil.getJmsStats().afterProcess(counter, System.currentTimeMillis(), false);
		}

	}

	private void sendMapMsg(String dst, final String msgtag, final Map msgMap, final Long delay) {
		long cur = System.currentTimeMillis();
		LogCounter counter = ResourceStatsUtil.getJmsStats().beforeProcess(dst, cur);

		try {
			GewaJmsTemplate e = this.getTemplate();
			Destination dest = e.getDestination(dst);
			e.send(dest, new MessageCreator() {
				public Message createMessage(Session session) throws JMSException {
					MapMessage message = session.createMapMessage();
					if (delay != null) {
						message.setLongProperty("AMQ_SCHEDULED_DELAY", delay.longValue());
					}

					message.setStringProperty("msgtag", msgtag);
					Iterator arg2 = msgMap.keySet().iterator();

					while (arg2.hasNext()) {
						Object key = arg2.next();
						if (!(key instanceof String)) {
							throw new MessageConversionException("Cannot convert non-String key of type ["
									+ ObjectUtils.nullSafeClassName(key) + "] to JMS MapMessage entry");
						}

						message.setObject((String) key, msgMap.get(key));
					}

					return message;
				}
			});
		} catch (Exception arg12) {
			this.dbLogger.warn(arg12, 20);
		} finally {
			ResourceStatsUtil.getJmsStats().afterProcess(counter, System.currentTimeMillis(), false);
		}

	}

	public void setQueueMap(Map<String, String> queueMap) {
		this.queueMap = queueMap;
	}

	public void addQueue(String queue, boolean persist, boolean override) {
		Iterator arg3 = this.jmsTemplateList.iterator();

		while (arg3.hasNext()) {
			GewaJmsTemplate template = (GewaJmsTemplate) arg3.next();
			template.addToQueue(queue, persist, override);
		}

	}

	public void delaySendMsgToDst(String dst, String tag, Map msgMap, long delay) {
		this.sendMapMsg(dst, tag, msgMap, Long.valueOf(delay));
	}

	public void periodSendMsgToDst(String dst, final String tag, final Map msgMap, final long delay, final long period,
			final int repeatNum) {
		long cur = System.currentTimeMillis();
		LogCounter counter = ResourceStatsUtil.getJmsStats().beforeProcess(dst, cur);

		try {
			GewaJmsTemplate e = this.getTemplate();
			Destination dest = e.getDestination(dst);
			e.send(dest, new MessageCreator() {
				public Message createMessage(Session session) throws JMSException {
					MapMessage message = session.createMapMessage();
					message.setLongProperty("AMQ_SCHEDULED_DELAY", delay);
					if (repeatNum > 0) {
						message.setLongProperty("AMQ_SCHEDULED_PERIOD", period);
						message.setIntProperty("AMQ_SCHEDULED_REPEAT", repeatNum);
					}

					message.setStringProperty("msgtag", tag);
					Iterator arg2 = msgMap.keySet().iterator();

					while (arg2.hasNext()) {
						Object key = arg2.next();
						if (!(key instanceof String)) {
							throw new MessageConversionException("Cannot convert non-String key of type ["
									+ ObjectUtils.nullSafeClassName(key) + "] to JMS MapMessage entry");
						}

						message.setObject((String) key, msgMap.get(key));
					}

					return message;
				}
			});
		} catch (Exception arg16) {
			this.dbLogger.warn(arg16, 20);
		} finally {
			ResourceStatsUtil.getJmsStats().afterProcess(counter, System.currentTimeMillis(), false);
		}

	}

	public void delaySendMsgToDst(String dst, String tag, String msg, long delay) {
		this.sendStringMsg(dst, tag, msg, Long.valueOf(delay));
	}

	public void setReceiveTimeout(int receiveTimeout) {
		this.receiveTimeout = (long) receiveTimeout;
	}
}