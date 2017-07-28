package com.gewara.untrans.impl;
import com.gewara.Config;
import com.gewara.util.BeanUtil;
import com.gewara.util.GewaLogger;
import com.gewara.util.WebLogger;
import com.gewara.web.support.ResourceStatsUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.pool.PooledConnectionFactory;
import org.springframework.jms.core.JmsTemplate;

public class GewaJmsTemplate extends JmsTemplate {
	private static int JMSID = 1;
	public static final String DEFALUT_DST = "defaultMsgQueue";
	private final transient GewaLogger dbLogger = WebLogger.getLogger(this.getClass());
	private List<Destination> persistList = new ArrayList();
	private Map<String, Destination> dstMap = new HashMap();
	private int idleTimeout = 600000;
	private String clientIDPrefix;
	private String connectionIDPrefix;
	private int currId;

	public GewaJmsTemplate(String brokerURL, long receiveTimeout) {
		this.clientIDPrefix = Config.DEPLOYID;
		this.connectionIDPrefix = Config.DEPLOYID;
		this.setConnectionFactory(this.getConnectionFactory(brokerURL));
		this.setReceiveTimeout(receiveTimeout);
		this.dbLogger.warn("START(" + JMSID + "):" + brokerURL);
		this.currId = JMSID++;
	}

	private ConnectionFactory getConnectionFactory(String brokerURL) {
		ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory();
		factory.setClientIDPrefix(this.clientIDPrefix);
		factory.setConnectionIDPrefix(this.connectionIDPrefix);
		factory.setBrokerURL(brokerURL);
		PooledConnectionFactory poolFactory = new PooledConnectionFactory();
		poolFactory.setIdleTimeout(this.idleTimeout);
		poolFactory.setConnectionFactory(factory);
		return poolFactory;
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

	void addToQueue(String queue, boolean persist, boolean override) {
		if (override || !this.dstMap.containsKey(queue)) {
			ActiveMQQueue dst1 = new ActiveMQQueue(queue);
			this.dstMap.put(queue, dst1);
			if (persist) {
				this.persistList.add(dst1);
			}

			String name = "" + BeanUtil.get(dst1, "qualifiedName");
			long cur = System.currentTimeMillis();
			ResourceStatsUtil.getJmsStats().register(name, cur);
			this.dbLogger.warn("regester jms stats(" + this.currId + "):" + name);
		}

	}

	Destination getDestination(String dst) {
		Destination dest = (Destination) this.dstMap.get(dst);
		if (dest == null) {
			this.dbLogger.error("queue error:" + dst + "(" + this.currId + "), using default!");
			dest = (Destination) this.dstMap.get("defaultMsgQueue");
		}

		return dest;
	}

	void stop() {
		((PooledConnectionFactory) this.getConnectionFactory()).stop();
	}
}