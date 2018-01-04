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

    // 锟斤拷志锟斤拷锟�
    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractRegistryFactory.class);

    // 注锟斤拷锟斤拷锟侥伙拷取锟斤拷锟斤拷锟斤拷
    private static final ReentrantLock LOCK = new ReentrantLock();

    // 注锟斤拷锟斤拷锟侥硷拷锟斤拷 Map<RegistryAddress, Registry>
    private static final Map<String, Registry> REGISTRIES = new ConcurrentHashMap<String, Registry>();

    /**
     * 锟斤拷取锟斤拷锟斤拷注锟斤拷锟斤拷锟斤拷
     * 
     * @return 锟斤拷锟斤拷注锟斤拷锟斤拷锟斤拷
     */
    public static Collection<Registry> getRegistries() {
        return Collections.unmodifiableCollection(REGISTRIES.values());
    }

    /**
     * 锟截憋拷锟斤拷锟斤拷锟窖达拷锟斤拷注锟斤拷锟斤拷锟斤拷
     */
    public static void destroyAll() {
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("Close all registries " + getRegistries());
        }
        // 锟斤拷锟斤拷注锟斤拷锟斤拷锟侥关闭癸拷锟斤拷
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
            // 锟酵凤拷锟斤拷
            LOCK.unlock();
        }
    }

    @Override
    public Registry getRegistry(URL url) {
    	url = url.setPath(RegistryService.class.getName())
    			.addParameter(Constants.INTERFACE_KEY, RegistryService.class.getName())
    			.removeParameters(Constants.EXPORT_KEY, Constants.REFER_KEY);
    	String key = url.toServiceString();
        // 锟斤拷锟斤拷注锟斤拷锟斤拷锟侥伙拷取锟斤拷锟教ｏ拷锟斤拷证注锟斤拷锟斤拷锟侥碉拷一实锟斤拷
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
            // 锟酵凤拷锟斤拷
            LOCK.unlock();
        }
    }

    protected abstract Registry createRegistry(URL url);

}
