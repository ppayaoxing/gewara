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
package com.alibaba.dubbo.registry.dubbo;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

import com.alibaba.dubbo.common.Constants;
import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.Version;
import com.alibaba.dubbo.common.logger.Logger;
import com.alibaba.dubbo.common.logger.LoggerFactory;
import com.alibaba.dubbo.common.utils.NamedThreadFactory;
import com.alibaba.dubbo.common.utils.NetUtils;
import com.alibaba.dubbo.registry.NotifyListener;
import com.alibaba.dubbo.registry.RegistryService;
import com.alibaba.dubbo.registry.support.FailbackRegistry;
import com.alibaba.dubbo.rpc.Invoker;

/**
 * DubboRegistry
 * 
 * @author william.liangf
 */
public class DubboRegistry extends FailbackRegistry {

    private final static Logger logger = LoggerFactory.getLogger(DubboRegistry.class); 

    // �����������3��(��λ����)
    private static final int RECONNECT_PERIOD_DEFAULT = 3 * 1000;
    
    // ��ʱ����ִ����
    private final ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1, new NamedThreadFactory("DubboRegistryReconnectTimer", true));

    // ������ʱ������ʱ��������Ƿ���ã�������ʱ�����޴�����
    private final ScheduledFuture<?> reconnectFuture;

    // �ͻ��˻�ȡ�������������ͻ���ʵ���Ĵ������̣���ֹ�ظ��Ŀͻ���
    private final ReentrantLock clientLock = new ReentrantLock();
    
    private final Invoker<RegistryService> registryInvoker;
    
    private final RegistryService registryService;
    
    public DubboRegistry(Invoker<RegistryService> registryInvoker, RegistryService registryService) {
        super(registryInvoker.getUrl());
        this.registryInvoker = registryInvoker;
        this.registryService = registryService;
        // ����������ʱ��
        int reconnectPeriod = registryInvoker.getUrl().getParameter(Constants.REGISTRY_RECONNECT_PERIOD_KEY, RECONNECT_PERIOD_DEFAULT);
        reconnectFuture = scheduledExecutorService.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                // ��Ⲣ����ע������
                try {
                    connect();
                } catch (Throwable t) { // �������ݴ�
                    logger.error("Unexpected error occur at reconnect, cause: " + t.getMessage(), t);
                }
            }
        }, reconnectPeriod, reconnectPeriod, TimeUnit.MILLISECONDS);
    }

    protected final void connect() {
        try {
            // ����Ƿ�������
            if (isAvailable()) {
                return;
            }
            if (logger.isInfoEnabled()) {
                logger.info("Reconnect to registry " + getUrl());
            }
            clientLock.lock();
            try {
                // ˫�ؼ���Ƿ�������
                if (isAvailable()) {
                    return;
                }
                recover();
            } finally {
                clientLock.unlock();
            }
        } catch (Throwable t) { // ���������쳣���ȴ��´�����
             if (getUrl().getParameter(Constants.CHECK_KEY, true)) {
                 if (t instanceof RuntimeException) {
                     throw (RuntimeException) t;
                 }
                 throw new RuntimeException(t.getMessage(), t);
             }
             logger.error("Failed to connect to registry " + getUrl().getAddress() + " from provider/consumer " + NetUtils.getLocalHost() + " use dubbo " + Version.getVersion() + ", cause: " + t.getMessage(), t);
        }
    }
    
    @Override
    public boolean isAvailable() {
        if (registryInvoker == null) {
            return false;
        }
        return registryInvoker.isAvailable();
    }
    
    @Override
    public void destroy() {
        super.destroy();
        try {
            // ȡ��������ʱ��
            if (! reconnectFuture.isCancelled()) {
                reconnectFuture.cancel(true);
            }
        } catch (Throwable t) {
            logger.warn("Failed to cancel reconnect timer", t);
        }
        registryInvoker.destroy();
    }
    
    @Override
    protected void doRegister(URL url) {
        registryService.register(url);
    }
    
    @Override
    protected void doUnregister(URL url) {
        registryService.unregister(url);
    }

    @Override
    protected void doSubscribe(URL url, NotifyListener listener) {
        registryService.subscribe(url, listener);
    }
    
    @Override
    protected void doUnsubscribe(URL url, NotifyListener listener) {
        registryService.unsubscribe(url, listener);
    }

    @Override
    public List<URL> lookup(URL url) {
        return registryService.lookup(url);
    }
    
}
