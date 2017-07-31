package com.gewara.untrans.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.pool.PooledConnectionFactory;
import org.springframework.jms.core.JmsTemplate;

import com.gewara.util.BeanUtil;
import com.gewara.util.GewaLogger;
import com.gewara.util.WebLogger;
import com.gewara.web.support.ResourceStatsUtil;

public class GewaJmsTemplate extends JmsTemplate{
	private static int JMSID = 1;
	public static final String DEFALUT_DST = "defaultMsgQueue";
	private final transient GewaLogger dbLogger = WebLogger.getLogger(getClass());
	private List<Destination> persistList = new ArrayList<Destination>();
	private Map<String, Destination> dstMap = new HashMap<String, Destination>();
	private int idleTimeout = 600000;
	private String clientIDPrefix =  com.gewara.Config.DEPLOYID;
	private String connectionIDPrefix = com.gewara.Config.DEPLOYID;
	private int currId;
	public GewaJmsTemplate(String brokerURL, long receiveTimeout) {
		this.setConnectionFactory(getConnectionFactory(brokerURL));
		this.setReceiveTimeout(receiveTimeout);
		dbLogger.warn("START(" + JMSID + "):" + brokerURL);
		currId = JMSID;
		JMSID ++;
	}
	private ConnectionFactory getConnectionFactory(String brokerURL){
		ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory();
		factory.setClientIDPrefix(clientIDPrefix);
		factory.setConnectionIDPrefix(connectionIDPrefix);
		factory.setBrokerURL(brokerURL);

		PooledConnectionFactory poolFactory = new PooledConnectionFactory();
		poolFactory.setIdleTimeout(idleTimeout);

		poolFactory.setConnectionFactory(factory);
		return poolFactory;

	}
	@Override
	protected void doSend(MessageProducer producer, Message message) throws JMSException {
		if (isExplicitQosEnabled()) {
			producer.send(message, getDeliveryMode(), getPriority(), getTimeToLive());
		}else {
			if(persistList.contains(producer.getDestination())) {
				producer.setDeliveryMode(DeliveryMode.PERSISTENT);
			}else{
				producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
			}
			producer.send(message);
		}
	}
	void addToQueue(String queue, boolean persist, boolean override){
		if(override || !dstMap.containsKey(queue)){
			Destination dst1 = new ActiveMQQueue(queue);
			dstMap.put(queue, dst1);
			if(persist){
				persistList.add(dst1);
			}
			String name = "" + BeanUtil.get(dst1, "qualifiedName");
			long cur = System.currentTimeMillis();
			ResourceStatsUtil.getJmsStats().register(name, cur);
			dbLogger.warn("regester jms stats(" + currId + "):" + name);
		}

	}
	
	Destination getDestination(String dst){
		Destination dest = dstMap.get(dst);
		if(dest==null) {
			dbLogger.error("queue error:" + dst + "(" + currId + ")" + ", using default!");
			dest = dstMap.get(DEFALUT_DST);
		}
		return dest;
	}
	void stop(){
		((PooledConnectionFactory)this.getConnectionFactory()).stop();
	}
}
