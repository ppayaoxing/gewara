package com.gewara.support.magent;

import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang.StringUtils;
import org.jivesoftware.smack.Chat;
import org.jivesoftware.smack.ChatManagerListener;
import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.ConnectionListener;
import org.jivesoftware.smack.MessageListener;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.Message.Type;
import org.jivesoftware.smack.packet.Presence;

import com.gewara.support.GewaExecutorThreadFactory;
import com.gewara.util.BeanUtil;
import com.gewara.util.GewaLogger;
import com.gewara.util.WebLogger;

public class SmackMonitorAgentClient {
	private static final transient GewaLogger dbLogger = WebLogger.getLogger(SmackMonitorAgentClient.class);
	private String hostname;	//机器名，不要用localhost
	private String username;
	private String password;
	private boolean available = false;
	private MessageCommandCenter resolver;
	private MessageListener listener;
	private XMPPConnection conn;
	private Map<String, Chat> chatMap = new ConcurrentHashMap<String, Chat>();
	private ThreadPoolExecutor executor;
	public SmackMonitorAgentClient(String hostname, String username, String password, MessageCommandCenter resolver){
		this.hostname = hostname;
		this.username = username;
		this.password = password;
		this.resolver = resolver;
		this.listener = new MonitorMessageListener();
		BlockingQueue<Runnable> taskQueue = new LinkedBlockingQueue<Runnable>();
		this.executor=  new ThreadPoolExecutor(10, 10, 0L, TimeUnit.SECONDS, taskQueue, new GewaExecutorThreadFactory("GWSmackMsgProcessor"));
		
	}
	public void init() {
		this.createConnect();		
		this.login();
	}
	public void sendMsg(String to, String msg){
		try {
			Chat chat = getOrCreateChat(to);
			chat.sendMessage(msg);
		} catch (Exception e) {
			dbLogger.warn(username, e);
		}
	}
	
	
	private Chat getOrCreateChat(String to){
		if(!StringUtils.contains(to, hostname)) {
			to += "@" + hostname;
		}
		Chat chat = chatMap.get(to);
		if(chat==null){
			synchronized(chatMap){
				chat = chatMap.get(to);
				if(chat==null){
					chat = conn.getChatManager().createChat(to, listener);
					chatMap.put(to, chat);
				}
			}
		}
		return chat;
	}
	private void createConnect() {
		try {
			ConnectionConfiguration config = new ConnectionConfiguration(hostname, 5222);
			conn = new XMPPConnection(config);
			conn.connect();
			conn.getChatManager().addChatListener(new ChatManagerListener(){
				@Override
				public void chatCreated(Chat chat, boolean createdLocally) {
					if(!createdLocally){
						chat.addMessageListener(listener);
					}
				}
			});
			conn.addConnectionListener(new ConnectionListener() {
				@Override
				public void connectionClosed() {
					available = false;
					dbLogger.warn("connectionClosed!");
				}

				@Override
				public void connectionClosedOnError(Exception e) {
					dbLogger.warn("connection closed error!", e);
				}

				@Override
				public void reconnectingIn(int seconds) {
					dbLogger.warn("reconnect in:" + seconds);
				}

				@Override
				public void reconnectionFailed(Exception e) {
					dbLogger.warn("reconnect failed!", e);
				}

				@Override
				public void reconnectionSuccessful() {
					dbLogger.warn("reconnect success!");
					available = true;
				}
			});
			available = true;
		} catch (Exception e) {
			dbLogger.warn(username, e);
		}
	}

	private void login() {
		try {
			conn.login(username, password);
			Presence presence = new Presence(Presence.Type.available);
			presence.setStatus("I am " + username);
			conn.sendPacket(presence);
		} catch (Exception e) {
			
			dbLogger.warn(username, e);
		}
	}
	public boolean isAvailable() {
		return available;
	}
	private class MonitorMessageListener implements MessageListener{
		private int replycount = 0;
		@Override
		public void processMessage(final Chat chat, final Message message) {
			executor.execute(new Runnable(){
				@Override
				public void run() {
					try{
						if(StringUtils.isNotBlank(message.getBody())){
							if(message.getType() == Type.chat || message.getType() == Type.normal || message.getType()==Type.groupchat){
								if(StringUtils.startsWith(message.getBody(), "reply") || StringUtils.equals(CommandProcessor.UNKNOWN, message.getBody())){
									replycount ++;
									if(replycount % 20 == 0){
										dbLogger.warn(message.getBody() + ",replycount:" + replycount);
									}
								}else{
									try {
										String reply = resolver.execCommand(message.getBody(), message.getFrom());
										if(StringUtils.equals(CommandProcessor.UNKNOWN, message.getBody())){
											reply = "reply:" + reply;
										}
										if(StringUtils.isNotBlank(reply) && !StringUtils.equals(CommandProcessor.SUCCESS, reply)){
											//成功的忽略回传消息
											chat.sendMessage(reply);
										}
									} catch (XMPPException e) {
										dbLogger.error("", e);
									}
								}
							}else{
								dbLogger.warn(chat.toString() + ":" + BeanUtil.getBeanMap(message));
							}
						}
					} catch (Throwable e){
						dbLogger.error("SMACKException", e);
					}
				}
			});
		}
	}
}
