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
package com.alibaba.dubbo.registry.support;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

import com.alibaba.dubbo.common.Constants;
import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.logger.Logger;
import com.alibaba.dubbo.common.logger.LoggerFactory;
import com.alibaba.dubbo.registry.Registry;
import com.alibaba.dubbo.registry.RegistryFactory;
import com.alibaba.dubbo.registry.RegistryService;

/**
 * AbstractRegistryFactory. (SPI, Singleton, ThreadSafe)
 * 
 * @see com.alibaba.dubbo.registry.RegistryFactory
 * @author william.liangf
 */
public abstract class AbstractRegistryFactory implements RegistryFactory {

    // ��־���
    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractRegistryFactory.class);

    // ע�����Ļ�ȡ������
    private static final ReentrantLock LOCK = new ReentrantLock();

    // ע�����ļ��� Map<RegistryAddress, Registry>
    private static final Map<String, Registry> REGISTRIES = new ConcurrentHashMap<String, Registry>();

    /**
     * ��ȡ����ע������
     * 
     * @return ����ע������
     */
    public static Collection<Registry> getRegistries() {
        return Collections.unmodifiableCollection(REGISTRIES.values());
    }

    /**
     * �ر������Ѵ���ע������
     */
    public static void destroyAll() {
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("Close all registries " + getRegistries());
        }
        // ����ע�����Ĺرչ���
        LOCK.lock();
        try {
            for (Registry registry : getRegistries()) {
                try {
                    registry.destroy();
                } catch (Throwable e) {
                    LOGGER.error(e.getMessage(), e);
                }
            }
            REGISTRIES.clear();
        } finally {
            // �ͷ���
            LOCK.unlock();
        }
    }

    @Override
    public Registry getRegistry(URL url) {
    	url = url.setPath(RegistryService.class.getName())
    			.addParameter(Constants.INTERFACE_KEY, RegistryService.class.getName())
    			.removeParameters(Constants.EXPORT_KEY, Constants.REFER_KEY);
    	String key = url.toServiceString();
        // ����ע�����Ļ�ȡ���̣���֤ע�����ĵ�һʵ��
        LOCK.lock();
        try {
            Registry registry = REGISTRIES.get(key);
            if (registry != null) {
                return registry;
            }
            registry = createRegistry(url);
            if (registry == null) {
                throw new IllegalStateException("Can not create registry " + url);
            }
            REGISTRIES.put(key, registry);
            return registry;
        } finally {
            // �ͷ���
            LOCK.unlock();
        }
    }

    protected abstract Registry createRegistry(URL url);

}
