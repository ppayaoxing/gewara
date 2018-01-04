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
package com.alibaba.dubbo.rpc.protocol.dubbo;

import java.net.InetSocketAddress;

import com.alibaba.dubbo.common.Constants;
import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.remoting.Channel;
import com.alibaba.dubbo.remoting.ChannelHandler;
import com.alibaba.dubbo.remoting.RemotingException;
import com.alibaba.dubbo.remoting.TimeoutException;
import com.alibaba.dubbo.remoting.exchange.ExchangeClient;
import com.alibaba.dubbo.remoting.exchange.support.header.HeaderExchangeClient;
import com.alibaba.dubbo.remoting.transport.ClientDelegate;
import com.alibaba.dubbo.rpc.Invocation;
import com.alibaba.dubbo.rpc.Result;
import com.alibaba.dubbo.rpc.RpcException;
import com.alibaba.dubbo.rpc.RpcInvocation;
import com.alibaba.dubbo.rpc.RpcResult;
import com.alibaba.dubbo.rpc.protocol.AbstractInvoker;

/**
 * 锟斤拷锟斤拷锟斤拷锟斤拷channel锟斤拷invoker. 
 * 
 * @author chao.liuc
 */
class ChannelWrappedInvoker<T> extends AbstractInvoker<T> {

    private final Channel channel;
    private final String serviceKey ; 

    public ChannelWrappedInvoker(Class<T> serviceType, Channel channel, URL url, String serviceKey) {

        super(serviceType, url, new String[] { Constants.GROUP_KEY,
                Constants.TOKEN_KEY, Constants.TIMEOUT_KEY });
        this.channel = channel;
        this.serviceKey = serviceKey;
    }

    @Override
    protected Result doInvoke(Invocation invocation) throws Throwable {
        RpcInvocation inv = (RpcInvocation) invocation;
        //锟矫诧拷锟斤拷client锟斤拷export 锟斤拷service path.约锟斤拷为interface锟斤拷锟斤拷锟斤拷.
        inv.setAttachment(Constants.PATH_KEY, getInterface().getName());
        inv.setAttachment(Constants.CALLBACK_SERVICE_KEY, serviceKey);

        ExchangeClient currentClient = new HeaderExchangeClient(new ChannelWrapper(this.channel));

        try {
            if (getUrl().getMethodParameter(invocation.getMethodName(), Constants.ASYNC_KEY, false)) { // 锟斤拷锟缴匡拷锟届步
                currentClient.send(inv,getUrl().getMethodParameter(invocation.getMethodName(), Constants.SENT_KEY, false));
                return new RpcResult();
            }
            int timeout = getUrl().getMethodParameter(invocation.getMethodName(),
                    Constants.TIMEOUT_KEY, Constants.DEFAULT_TIMEOUT);
            if (timeout > 0) {
                return (Result) currentClient.request(inv, timeout).get();
            } else {
                return (Result) currentClient.request(inv).get();
            }
        } catch (RpcException e) {
            throw e;
        } catch (TimeoutException e) {
            throw new RpcException(RpcException.TIMEOUT_EXCEPTION, e.getMessage(), e);
        } catch (RemotingException e) {
            throw new RpcException(RpcException.NETWORK_EXCEPTION, e.getMessage(), e);
        } catch (Throwable e) { // here is non-biz exception, wrap it.
            throw new RpcException(e.getMessage(), e);
        }
    }

    public static class ChannelWrapper extends ClientDelegate {

        private final Channel channel;
        private final URL     url;

        public ChannelWrapper(Channel channel) {
            this.channel = channel;
            this.url = channel.getUrl().addParameter("codec", DubboCodec.NAME);
        }

        @Override
        public URL getUrl() {
            return url;
        }

        @Override
        public ChannelHandler getChannelHandler() {
            return channel.getChannelHandler();
        }

        @Override
        public InetSocketAddress getLocalAddress() {
            return channel.getLocalAddress();
        }

        @Override
        public void close() {
            channel.close();
        }

        @Override
        public boolean isClosed() {
            return channel == null ? true : channel.isClosed();
        }

        @Override
        public void reset(URL url) {
            throw new RpcException("ChannelInvoker can not reset.");
        }

        @Override
        public InetSocketAddress getRemoteAddress() {
            return channel.getLocalAddress();
        }

        @Override
        public boolean isConnected() {
            return channel == null ? false : channel.isConnected();
        }

        @Override
        public boolean hasAttribute(String key) {
            return channel.hasAttribute(key);
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
        public void reconnect() throws RemotingException {

        }

        @Override
        public void send(Object message) throws RemotingException {
            channel.send(message);
        }

        @Override
        public void send(Object message, boolean sent) throws RemotingException {
            channel.send(message, sent);
        }

    }

    @Override
    public void destroy() {
        //channel锟斤拷源锟斤拷锟斤拷锟斤拷锟絚hannel锟斤拷锟斤拷锟斤拷锟斤拷锟�.
//        super.destroy();
//        try {
//            channel.close();
//        } catch (Throwable t) {
//            logger.warn(t.getMessage(), t);
//        }
    }

}
