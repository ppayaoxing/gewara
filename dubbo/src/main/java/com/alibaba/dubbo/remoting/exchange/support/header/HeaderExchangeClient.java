/*
 * Copyright 1999-2011 Alibaba Group.
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *  
 *      http://www.apache.org/licenses/LICENSE-2.0
 *  
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alibaba.dubbo.remoting.exchange.support.header;

import java.net.InetSocketAddress;
import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.alibaba.dubbo.common.Constants;
import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.logger.Logger;
import com.alibaba.dubbo.common.logger.LoggerFactory;
import com.alibaba.dubbo.common.utils.NamedThreadFactory;
import com.alibaba.dubbo.remoting.Channel;
import com.alibaba.dubbo.remoting.ChannelHandler;
import com.alibaba.dubbo.remoting.Client;
import com.alibaba.dubbo.remoting.RemotingException;
import com.alibaba.dubbo.remoting.exchange.ExchangeChannel;
import com.alibaba.dubbo.remoting.exchange.ExchangeClient;
import com.alibaba.dubbo.remoting.exchange.ExchangeHandler;
import com.alibaba.dubbo.remoting.exchange.ResponseFuture;

/**
 * DefaultMessageClient
 * 
 * @author william.liangf
 * @author chao.liuc
 */
public class HeaderExchangeClient implements ExchangeClient {

    private static final Logger logger = LoggerFactory.getLogger( HeaderExchangeClient.class );

    private static final ScheduledThreadPoolExecutor scheduled = new ScheduledThreadPoolExecutor(2, new NamedThreadFactory("dubbo-remoting-client-heartbeat", true));

    // 锟斤拷锟斤拷锟斤拷时锟斤拷
    private ScheduledFuture<?> heatbeatTimer;

    // 锟斤拷锟斤拷锟斤拷时锟斤拷锟斤拷锟诫。缺省0锟斤拷锟斤拷锟斤拷执锟斤拷锟斤拷锟斤拷锟斤拷
    private int heartbeat;

    private int heartbeatTimeout;
    
    private final Client client;

    private final ExchangeChannel channel;

    public HeaderExchangeClient(Client client){
        if (client == null) {
            throw new IllegalArgumentException("client == null");
        }
        this.client = client;
        this.channel = new HeaderExchangeChannel(client);
        String dubbo = client.getUrl().getParameter(Constants.DUBBO_VERSION_KEY);
        this.heartbeat = client.getUrl().getParameter( Constants.HEARTBEAT_KEY, dubbo != null && dubbo.startsWith("1.0.") ? Constants.DEFAULT_HEARTBEAT : 0 );
        this.heartbeatTimeout = client.getUrl().getParameter( Constants.HEARTBEAT_TIMEOUT_KEY, heartbeat * 3 );
        if ( heartbeatTimeout < heartbeat * 2 ) {
            throw new IllegalStateException( "heartbeatTimeout < heartbeatInterval * 2" );
        }
        startHeatbeatTimer();
    }

    @Override
    public ResponseFuture request(Object request) throws RemotingException {
        return channel.request(request);
    }

    @Override
    public URL getUrl() {
        return channel.getUrl();
    }

    @Override
    public InetSocketAddress getRemoteAddress() {
        return channel.getRemoteAddress();
    }

    @Override
    public ResponseFuture request(Object request, int timeout) throws RemotingException {
        return channel.request(request, timeout);
    }

    @Override
    public ChannelHandler getChannelHandler() {
        return channel.getChannelHandler();
    }

    @Override
    public boolean isConnected() {
        return channel.isConnected();
    }

    @Override
    public InetSocketAddress getLocalAddress() {
        return channel.getLocalAddress();
    }

    @Override
    public ExchangeHandler getExchangeHandler() {
        return channel.getExchangeHandler();
    }
    
    @Override
    public void send(Object message) throws RemotingException {
        channel.send(message);
    }
    
    @Override
    public void send(Object message, boolean sent) throws RemotingException {
        channel.send(message, sent);
    }

    @Override
    public boolean isClosed() {
        return channel.isClosed();
    }

    @Override
    public void close() {
        doClose();
        channel.close();
    }

    @Override
    public void close(int timeout) {
        doClose();
        channel.close(timeout);
    }

    @Override
    public void reset(URL url) {
        client.reset(url);
    }
    
    @Override
    @Deprecated
    public void reset(com.alibaba.dubbo.common.Parameters parameters){
        reset(getUrl().addParameters(parameters.getParameters()));
    }

    @Override
    public void reconnect() throws RemotingException {
        client.reconnect();
    }

    @Override
    public Object getAttribute(String key) {
        return channel.getAttribute(key);
    }

    @Override
    public void setAttribute(String key, Object value) {
        channel.setAttribute(key, value);
    }

    @Override
    public void removeAttribute(String key) {
        channel.removeAttribute(key);
    }

    @Override
    public boolean hasAttribute(String key) {
        return channel.hasAttribute(key);
    }

    private void startHeatbeatTimer() {
        stopHeartbeatTimer();
        if ( heartbeat > 0 ) {
            heatbeatTimer = scheduled.scheduleWithFixedDelay(
                    new HeartBeatTask( new HeartBeatTask.ChannelProvider() {
                        @Override
                        public Collection<Channel> getChannels() {
                            return Collections.<Channel>singletonList( HeaderExchangeClient.this );
                        }
                    }, heartbeat, heartbeatTimeout),
                    heartbeat, heartbeat, TimeUnit.MILLISECONDS );
        }
    }

    private void stopHeartbeatTimer() {
        if (heatbeatTimer != null && ! heatbeatTimer.isCancelled()) {
            try {
                heatbeatTimer.cancel(true);
                scheduled.purge();
            } catch ( Throwable e ) {
                if (logger.isWarnEnabled()) {
                    logger.warn(e.getMessage(), e);
                }
            }
        }
        heatbeatTimer =null;
    }

    private void doClose() {
        stopHeartbeatTimer();
    }

	@Override
	public String toString() {
		return "HeaderExchangeClient [channel=" + channel + "]";
	}
}
