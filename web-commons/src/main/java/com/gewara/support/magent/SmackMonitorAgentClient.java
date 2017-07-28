/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.support.magent;

import com.gewara.support.GewaExecutorThreadFactory;
import com.gewara.support.magent.MessageCommandCenter;
import com.gewara.util.BeanUtil;
import com.gewara.util.GewaLogger;
import com.gewara.util.WebLogger;
import java.util.Map;
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
import org.jivesoftware.smack.packet.Presence;
import org.jivesoftware.smack.packet.Presence.Type;

public class SmackMonitorAgentClient {
	private static final transient GewaLogger dbLogger = WebLogger.getLogger(SmackMonitorAgentClient.class);
	private String hostname;
	private String username;
	private String password;
	private boolean available = false;
	private MessageCommandCenter resolver;
	private MessageListener listener;
	private XMPPConnection conn;
	private Map<String, Chat> chatMap = new ConcurrentHashMap();
	private ThreadPoolExecutor executor;

	public SmackMonitorAgentClient(String hostname, String username, String password, MessageCommandCenter resolver) {
		this.hostname = hostname;
		this.username = username;
		this.password = password;
		this.resolver = resolver;
		this.listener = new SmackMonitorAgentClient.MonitorMessageListener(null);
		LinkedBlockingQueue taskQueue = new LinkedBlockingQueue();
		this.executor = new ThreadPoolExecutor(10, 10, 0L, TimeUnit.SECONDS, taskQueue,
				new GewaExecutorThreadFactory("GWSmackMsgProcessor"));
	}

	public void init() {
		this.createConnect();
		this.login();
	}

	public void sendMsg(String to, String msg) {
		try {
			Chat e = this.getOrCreateChat(to);
			e.sendMessage(msg);
		} catch (Exception arg3) {
			dbLogger.warn(this.username, arg3);
		}

	}

	private Chat getOrCreateChat(String to) {
		if (!StringUtils.contains(to, this.hostname)) {
			to = to + "@" + this.hostname;
		}

		Chat chat = (Chat) this.chatMap.get(to);
		if (chat == null) {
			Map arg2 = this.chatMap;
			synchronized (this.chatMap) {
				chat = (Chat) this.chatMap.get(to);
				if (chat == null) {
					chat = this.conn.getChatManager().createChat(to, this.listener);
					this.chatMap.put(to, chat);
				}
			}
		}

		return chat;
	}

	private void createConnect() {
		try {
			ConnectionConfiguration e = new ConnectionConfiguration(this.hostname, 5222);
			this.conn = new XMPPConnection(e);
			this.conn.connect();
			this.conn.getChatManager().addChatListener(new ChatManagerListener() {
				public void chatCreated(Chat chat, boolean createdLocally) {
					if (!createdLocally) {
						chat.addMessageListener(SmackMonitorAgentClient.this.listener);
					}

				}
			});
			this.conn.addConnectionListener(new ConnectionListener() {
				public void connectionClosed() {
					SmackMonitorAgentClient.this.available = false;
					SmackMonitorAgentClient.dbLogger.warn("connectionClosed!");
				}

				public void connectionClosedOnError(Exception e) {
					SmackMonitorAgentClient.dbLogger.warn("connection closed error!", e);
				}

				public void reconnectingIn(int seconds) {
					SmackMonitorAgentClient.dbLogger.warn("reconnect in:" + seconds);
				}

				public void reconnectionFailed(Exception e) {
					SmackMonitorAgentClient.dbLogger.warn("reconnect failed!", e);
				}

				public void reconnectionSuccessful() {
					SmackMonitorAgentClient.dbLogger.warn("reconnect success!");
					SmackMonitorAgentClient.this.available = true;
				}
			});
			this.available = true;
		} catch (Exception arg1) {
			dbLogger.warn(this.username, arg1);
		}

	}

	private void login() {
		try {
			this.conn.login(this.username, this.password);
			Presence e = new Presence(Type.available);
			e.setStatus("I am " + this.username);
			this.conn.sendPacket(e);
		} catch (Exception arg1) {
			dbLogger.warn(this.username, arg1);
		}

	}

	public boolean isAvailable() {
		return this.available;
	}

	private class MonitorMessageListener implements MessageListener {
		private int replycount;

		private MonitorMessageListener() {
			this.replycount = 0;
		}

		public void processMessage(final Chat chat, final Message message) {
			SmackMonitorAgentClient.this.executor.execute(new Runnable() {
				public void run() {
					try {
						if (StringUtils.isNotBlank(message.getBody())) {
							if (message.getType() != org.jivesoftware.smack.packet.Message.Type.chat
									&& message.getType() != org.jivesoftware.smack.packet.Message.Type.normal
									&& message.getType() != org.jivesoftware.smack.packet.Message.Type.groupchat) {
								SmackMonitorAgentClient.dbLogger
										.warn(chat.toString() + ":" + BeanUtil.getBeanMap(message));
							} else if (!StringUtils.startsWith(message.getBody(), "reply") && !StringUtils
									.equals("unknown command, please type “help” for help!", message.getBody())) {
								try {
									String e = SmackMonitorAgentClient.this.resolver.execCommand(message.getBody(),
											message.getFrom());
									if (StringUtils.equals("unknown command, please type “help” for help!",
											message.getBody())) {
										e = "reply:" + e;
									}

									if (StringUtils.isNotBlank(e) && !StringUtils.equals("reply:success", e)) {
										chat.sendMessage(e);
									}
								} catch (XMPPException arg1) {
									SmackMonitorAgentClient.dbLogger.error("", arg1);
								}
							} else {
								MonitorMessageListener.this.replycount++;
								if (MonitorMessageListener.this.replycount % 20 == 0) {
									SmackMonitorAgentClient.dbLogger.warn(message.getBody() + ",replycount:"
											+ MonitorMessageListener.this.replycount);
								}
							}
						}
					} catch (Throwable arg2) {
						SmackMonitorAgentClient.dbLogger.error("SMACKException", arg2);
					}

				}
			});
		}
	}
}