/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.untrans.impl;

import com.gewara.untrans.JmsService;
import com.gewara.util.BeanUtil;
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
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.jms.support.converter.MessageConversionException;
import org.springframework.util.ObjectUtils;

public class JmsServiceImpl extends JmsTemplate implements JmsService, InitializingBean {
	private final transient GewaLogger dbLogger = WebLogger.getLogger(this.getClass());
	private Map<String, String> queueMap = new HashMap();
	private Map<String, Destination> dstMap = new HashMap();
	private List<Destination> persistList = new ArrayList();

	public JmsServiceImpl() {
	}

	public JmsServiceImpl(Map<String, String> queueMap) {
		this.queueMap = queueMap;
	}

	public void sendMsgToDst(String dst, String msgtag, String msg) {
		Destination dest = (Destination) this.dstMap.get(dst);
		if (dest == null) {
			this.dbLogger.error("queue error:" + dst + ", using default!");
			dest = this.getDefaultDestination();
		}

		this.sendStringMsg(dest, msgtag, msg, (Long) null);
	}

	public void sendMsgToDst(String dst, String msgtag, Map msgMap) {
		Destination dest = (Destination) this.dstMap.get(dst);
		if (dest == null) {
			this.dbLogger.error("queue error:" + dst + ", using default!");
			dest = this.getDefaultDestination();
		}

		this.sendMapMsg(dest, msgtag, msgMap, (Long) null);
	}

	public void sendMsgToDst(String dst, String msgtag, String keyList, Object... params) {
		Destination dest = (Destination) this.dstMap.get(dst);
		if (dest == null) {
			this.dbLogger.error("queue error:" + dst + ", using default!");
			dest = this.getDefaultDestination();
		}

		this.sendMsg(dest, msgtag, keyList, params);
	}

	public void sendMsgToDstWithMultiHead(String queueName, final String msgtag, final Map msgMap,
			final Map<String, String> headMap) {
		Destination dest = (Destination) this.dstMap.get(queueName);
		if (dest == null) {
			this.dbLogger.error("queue error:" + queueName + ", using default!");
			dest = this.getDefaultDestination();
		}

		long cur = System.currentTimeMillis();
		LogCounter counter = ResourceStatsUtil.getJmsStats().beforeProcess(queueName, cur);

		try {
			this.send(dest, new MessageCreator() {
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

	private void sendMsg(Destination dst, String msgtag, String keyList, Object... params) {
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

	private void sendStringMsg(Destination dst, final String msgtag, final String msg, final Long delay) {
		long cur = System.currentTimeMillis();
		String name = "" + BeanUtil.get(dst, "qualifiedName");
		LogCounter counter = ResourceStatsUtil.getJmsStats().beforeProcess(name, cur);

		try {
			this.send(dst, new MessageCreator() {
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

	private void sendMapMsg(Destination dst, final String msgtag, final Map msgMap, final Long delay) {
		long cur = System.currentTimeMillis();
		String name = "" + BeanUtil.get(dst, "qualifiedName");
		LogCounter counter = ResourceStatsUtil.getJmsStats().beforeProcess(name, cur);

		try {
			this.send(dst, new MessageCreator() {
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

	protected void doSend(MessageProducer producer, Message message) throws JMSException {
		if (this.isExplicitQosEnabled()) {
			producer.send(message, this.getDeliveryMode(), this.getPriority(), this.getTimeToLive());
		} else {
			if (this.persistList.contains(producer.getDestination())) {
				producer.setDeliveryMode(2);
			} else {
				producer.setDeliveryMode(1);
			}

			producer.send(message);
		}

	}

	public void afterPropertiesSet() {
		super.afterPropertiesSet();
		long cur = System.currentTimeMillis();
		Iterator arg2 = this.queueMap.keySet().iterator();

		while (arg2.hasNext()) {
			String key = (String) arg2.next();
			ActiveMQQueue dst = new ActiveMQQueue(key);
			this.dstMap.put(key, dst);
			if (StringUtils.equals((String) this.queueMap.get(key), "persist")) {
				this.persistList.add(dst);
			}

			String name = "" + BeanUtil.get(dst, "qualifiedName");
			ResourceStatsUtil.getJmsStats().register(name, cur);
			this.dbLogger.warn("regester jms stats:" + name);
		}

		this.setMessageIdEnabled(false);
		this.setMessageTimestampEnabled(false);
	}

	public void addQueue(String queue, boolean persist, boolean override) {
		if (override || !this.dstMap.containsKey(queue)) {
			ActiveMQQueue dst = new ActiveMQQueue(queue);
			this.dstMap.put(queue, dst);
			if (persist) {
				this.persistList.add(dst);
			}

			String name = "" + BeanUtil.get(dst, "qualifiedName");
			long cur = System.currentTimeMillis();
			ResourceStatsUtil.getJmsStats().register(name, cur);
			this.dbLogger.warn("regester jms stats:" + name);
		}

	}

	public void delaySendMsgToDst(String dst, String tag, Map msgMap, long delay) {
		Destination dest = (Destination) this.dstMap.get(dst);
		if (dest == null) {
			this.dbLogger.error("queue error:" + dst + ", using default!");
			dest = this.getDefaultDestination();
		}

		this.sendMapMsg(dest, tag, msgMap, Long.valueOf(delay));
	}

	public void periodSendMsgToDst(String dst, final String tag, final Map msgMap, final long delay, final long period,
			final int repeatNum) {
		Destination dest = (Destination) this.dstMap.get(dst);
		if (dest == null) {
			this.dbLogger.error("queue error:" + dst + ", using default!");
			dest = this.getDefaultDestination();
		}

		long cur = System.currentTimeMillis();
		String name = "" + BeanUtil.get(dest, "qualifiedName");
		LogCounter counter = ResourceStatsUtil.getJmsStats().beforeProcess(name, cur);

		try {
			this.send(dst, new MessageCreator() {
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
		} catch (Exception arg17) {
			this.dbLogger.warn(arg17, 20);
		} finally {
			ResourceStatsUtil.getJmsStats().afterProcess(counter, System.currentTimeMillis(), false);
		}

	}

	public void delaySendMsgToDst(String dst, String tag, String msg, long delay) {
		Destination dest = (Destination) this.dstMap.get(dst);
		if (dest == null) {
			this.dbLogger.error("queue error:" + dst + ", using default!");
			dest = this.getDefaultDestination();
		}

		this.sendStringMsg(dest, tag, msg, Long.valueOf(delay));
	}
}