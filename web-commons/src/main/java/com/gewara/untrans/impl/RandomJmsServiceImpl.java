package com.gewara.untrans.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.Session;

import org.apache.activemq.ScheduledMessage;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.jms.core.MessageCreator;
import org.springframework.jms.support.converter.MessageConversionException;
import org.springframework.util.ObjectUtils;

import com.gewara.untrans.JmsService;
import com.gewara.util.Assert;
import com.gewara.util.GewaLogger;
import com.gewara.util.WebLogger;
import com.gewara.web.support.DynamicStats.LogCounter;
import com.gewara.web.support.ResourceStatsUtil;

/**
 * @author ge.biao
 * 多台jms服务器循环发送
 */
public class RandomJmsServiceImpl implements JmsService, InitializingBean{
	private final transient GewaLogger dbLogger = WebLogger.getLogger(getClass());
	private Map<String, String> queueMap = new HashMap<String, String>();
	private List<GewaJmsTemplate> jmsTemplateList = new ArrayList<GewaJmsTemplate>();
	private String jmsServers;//tcp://192.168.8.109:9521,tcp://192.168.8.108:9521
	private long receiveTimeout = 20000;
	private int count = 0;
	private int templateSize;
	public RandomJmsServiceImpl(){
	}
	public RandomJmsServiceImpl(Map<String, String> queueMap){
		this.queueMap = queueMap;
	}

	public void setJmsServers(String jmsServers) {
		this.jmsServers = jmsServers;
	}

	@Override
	public void afterPropertiesSet() {
		Assert.isTrue(StringUtils.isNotBlank(jmsServers), "jmsServers can't be null!!");
		//failover:(tcp://192.168.8.109:9521,tcp://192.168.8.108:9521)?randomize=false
		//0,去除failover
		int idx = jmsServers.indexOf('(');
		if(idx>0){
			int idx2 = jmsServers.indexOf(')');
			jmsServers = jmsServers.substring(idx + 1, idx2);
		}
		//1,整理
		List<String> servers = new ArrayList<String>();
		for(String server: StringUtils.split(jmsServers, ",")){
			if(StringUtils.isNotBlank(server)){
				servers.add(server.trim());
			}
		}
		//2,逐个
		for(String server: servers){
			List<String> list = new ArrayList<String>(servers);
			list.remove(server);
			list.add(server);
			//failover:(tcp://192.168.8.109:9521,tcp://192.168.8.108:9521)?randomize=false
			String brokerURL = "failover:(" + StringUtils.join(list, ",") + ")?randomize=false";
			GewaJmsTemplate template = new GewaJmsTemplate(brokerURL, receiveTimeout);
			template.setMessageIdEnabled(false);
			template.setMessageTimestampEnabled(false);
			jmsTemplateList.add(template);
		}
		//3,add queue
		for(String queue: queueMap.keySet()){
			addQueue(queue, StringUtils.equals(queueMap.get(queue), "persist"), true);
		}
		//4,default
		addQueue(GewaJmsTemplate.DEFALUT_DST, true, true);
		this.templateSize = jmsTemplateList.size();
		
	}
	public void stopAll(){
		for(GewaJmsTemplate template: jmsTemplateList){
			template.stop();
		}
	}
	
	private GewaJmsTemplate getTemplate(){
		count ++;
		return jmsTemplateList.get(count % templateSize);
	}
	
	@Override
	public void sendMsgToDst(String dst, String msgtag, String msg) {
		sendStringMsg(dst, msgtag, msg, null);
	}
	@Override
	public void sendMsgToDst(String dst, String msgtag, Map msgMap) {
		sendMapMsg(dst, msgtag, msgMap, null);
	}
	@Override
	public void sendMsgToDst(String dst, String msgtag, String keyList, Object...params) {
		sendMsg(dst, msgtag, keyList, params);
	}
	@Override
	public void sendMsgToDstWithMultiHead(String queueName, final String msgtag, final Map msgMap, final Map<String, String> headMap){
		long cur = System.currentTimeMillis();
		LogCounter counter = ResourceStatsUtil.getJmsStats().beforeProcess(queueName, cur);
		try{
			GewaJmsTemplate template = getTemplate();
			Destination dest = template.getDestination(queueName);
			template.send(dest, new MessageCreator(){
				@Override
				public Message createMessage(Session session) throws JMSException {
					MapMessage message = session.createMapMessage();
					message.setStringProperty("msgtag", msgtag);
					if(headMap!=null){
						for(Map.Entry<String, String> entry: headMap.entrySet()){
							if(StringUtils.isNotBlank(entry.getKey()) && StringUtils.isNotBlank(entry.getValue())){
								message.setStringProperty(entry.getKey(), entry.getValue());
							}
						}
					}
					for (Object key : msgMap.keySet()) {
						if (!(key instanceof String)) {
							throw new MessageConversionException("Cannot convert non-String key of type [" +
									ObjectUtils.nullSafeClassName(key) + "] to JMS MapMessage entry");
						}
						message.setObject((String) key, msgMap.get(key));
					}
					return message;
				}
			});
		}catch (Exception e){
			dbLogger.warn(e, 20);
		}finally{
			ResourceStatsUtil.getJmsStats().afterProcess(counter, System.currentTimeMillis(), false);
		}

	}
	private void sendMsg(String dst, String msgtag, String keyList, Object...params) {
		if(StringUtils.isBlank(keyList) || params==null) return;
		Map msgMap = new HashMap();
		String[] keys = keyList.split("[, ]+");
		for(int i=0, size=Math.min(keys.length, params.length);i<size;i++){
			msgMap.put(keys[i], params[i]);
		}
		sendMapMsg(dst, msgtag, msgMap, null);
	}
	
	private void sendStringMsg(String dst, final String msgtag, final String msg, final Long delay) {
		long cur = System.currentTimeMillis();
		LogCounter counter = ResourceStatsUtil.getJmsStats().beforeProcess(dst, cur);
		try{
			GewaJmsTemplate template = getTemplate();
			Destination dest = template.getDestination(dst);
			template.send(dest, new MessageCreator(){
				@Override
				public Message createMessage(Session session) throws JMSException {
					Message message = session.createTextMessage(msg);
					if(delay!=null){//延迟发送
						message.setLongProperty(ScheduledMessage.AMQ_SCHEDULED_DELAY, delay);
					}
					message.setStringProperty("msgtag", msgtag);
					return message;
				}
			});
		}catch (Exception e){
			dbLogger.warn(e, 20);
		}finally{
			ResourceStatsUtil.getJmsStats().afterProcess(counter, System.currentTimeMillis(), false);
		}
	}

	private void sendMapMsg(String dst, final String msgtag, final Map msgMap, final Long delay) {
		long cur = System.currentTimeMillis();
		LogCounter counter = ResourceStatsUtil.getJmsStats().beforeProcess(dst, cur);
		try{
			GewaJmsTemplate template = getTemplate();
			Destination dest = template.getDestination(dst);

			template.send(dest, new MessageCreator(){
				@Override
				public Message createMessage(Session session) throws JMSException {
					MapMessage message = session.createMapMessage();
					if(delay!=null){//延迟发送
						message.setLongProperty(ScheduledMessage.AMQ_SCHEDULED_DELAY, delay);
					}
					message.setStringProperty("msgtag", msgtag);
					for (Object key : msgMap.keySet()) {
						if (!(key instanceof String)) {
							throw new MessageConversionException("Cannot convert non-String key of type [" +
									ObjectUtils.nullSafeClassName(key) + "] to JMS MapMessage entry");
						}
						message.setObject((String) key, msgMap.get(key));
					}
					return message;
				}
			});
		}catch (Exception e){
			dbLogger.warn(e, 20);
		}finally{
			ResourceStatsUtil.getJmsStats().afterProcess(counter, System.currentTimeMillis(), false);
		}
	}
	public void setQueueMap(Map<String, String> queueMap) {
		this.queueMap = queueMap;
	}
	
	@Override
	public void addQueue(String queue, boolean persist, boolean override) {
		for(GewaJmsTemplate template: jmsTemplateList){
			template.addToQueue(queue, persist, override);
		}
	}
	@Override
	public void delaySendMsgToDst(String dst, String tag, Map msgMap, long delay) {
		sendMapMsg(dst, tag, msgMap, delay);
	}
	@Override
	public void periodSendMsgToDst(String dst, final String tag, final Map msgMap, final long delay, final long period, final int repeatNum){
		long cur = System.currentTimeMillis();
		LogCounter counter = ResourceStatsUtil.getJmsStats().beforeProcess(dst, cur);
		try{
			GewaJmsTemplate template = getTemplate();
			Destination dest = template.getDestination(dst);
			template.send(dest, new MessageCreator(){
				@Override
				public Message createMessage(Session session) throws JMSException {
					MapMessage message = session.createMapMessage();
					//String scheduleId, 
					message.setLongProperty(ScheduledMessage.AMQ_SCHEDULED_DELAY, delay);
					if(repeatNum>0){
						message.setLongProperty(ScheduledMessage.AMQ_SCHEDULED_PERIOD, period);
						message.setIntProperty(ScheduledMessage.AMQ_SCHEDULED_REPEAT, repeatNum);
					}
					message.setStringProperty("msgtag", tag);
					for (Object key : msgMap.keySet()) {
						if (!(key instanceof String)) {
							throw new MessageConversionException("Cannot convert non-String key of type [" +
									ObjectUtils.nullSafeClassName(key) + "] to JMS MapMessage entry");
						}
						message.setObject((String) key, msgMap.get(key));
					}
					return message;
				}
			});
		}catch (Exception e){
			dbLogger.warn(e, 20);
		}finally{
			ResourceStatsUtil.getJmsStats().afterProcess(counter, System.currentTimeMillis(), false);
		}
	}

	@Override
	public void delaySendMsgToDst(String dst, String tag, String msg, long delay) {
		sendStringMsg(dst, tag, msg, delay);
	}
	public void setReceiveTimeout(int receiveTimeout) {
		this.receiveTimeout = receiveTimeout;
	}
}
