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
package com.alibaba.dubbo.registry.integration;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.alibaba.dubbo.common.Constants;
import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.ExtensionLoader;
import com.alibaba.dubbo.common.logger.Logger;
import com.alibaba.dubbo.common.logger.LoggerFactory;
import com.alibaba.dubbo.common.utils.NetUtils;
import com.alibaba.dubbo.common.utils.StringUtils;
import com.alibaba.dubbo.common.utils.UrlUtils;
import com.alibaba.dubbo.registry.NotifyListener;
import com.alibaba.dubbo.registry.Registry;
import com.alibaba.dubbo.registry.RegistryFactory;
import com.alibaba.dubbo.registry.RegistryService;
import com.alibaba.dubbo.rpc.Exporter;
import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.Protocol;
import com.alibaba.dubbo.rpc.ProxyFactory;
import com.alibaba.dubbo.rpc.RpcException;
import com.alibaba.dubbo.rpc.cluster.Cluster;
import com.alibaba.dubbo.rpc.cluster.Configurator;
import com.alibaba.dubbo.rpc.protocol.InvokerWrapper;

/**
 * RegistryProtocol
 * 
 * @author william.liangf
 * @author chao.liuc
 */
public class RegistryProtocol implements Protocol {

    private Cluster cluster;
    
    public void setCluster(Cluster cluster) {
        this.cluster = cluster;
    }
    
    private Protocol protocol;
    
    public void setProtocol(Protocol protocol) {
        this.protocol = protocol;
    }

    private RegistryFactory registryFactory;
    
    public void setRegistryFactory(RegistryFactory registryFactory) {
        this.registryFactory = registryFactory;
    }

    private ProxyFactory proxyFactory;
    
    public void setProxyFactory(ProxyFactory proxyFactory) {
        this.proxyFactory = proxyFactory;
    }

    @Override
    public int getDefaultPort() {
        return 9090;
    }
    
    private static RegistryProtocol INSTANCE;

    public RegistryProtocol() {
        INSTANCE = this;
    }
    
    public static RegistryProtocol getRegistryProtocol() {
        if (INSTANCE == null) {
            ExtensionLoader.getExtensionLoader(Protocol.class).getExtension(Constants.REGISTRY_PROTOCOL); // load
        }
        return INSTANCE;
    }
    
    private final Map<URL, NotifyListener> overrideListeners = new ConcurrentHashMap<URL, NotifyListener>();
    
    public Map<URL, NotifyListener> getOverrideListeners() {
		return overrideListeners;
	}

	//锟斤拷锟节斤拷锟絩mi锟截革拷锟斤拷露锟剿口筹拷突锟斤拷锟斤拷锟解，锟窖撅拷锟斤拷露锟斤拷锟侥凤拷锟斤拷锟斤拷锟斤拷锟铰憋拷露
    //providerurl <--> exporter
    private final Map<String, ExporterChangeableWrapper<?>> bounds = new ConcurrentHashMap<String, ExporterChangeableWrapper<?>>();
    
    private final static Logger logger = LoggerFactory.getLogger(RegistryProtocol.class);
    
    @Override
    public <T> Exporter<T> export(final Invoker<T> originInvoker) throws RpcException {
        //export invoker
        final ExporterChangeableWrapper<T> exporter = doLocalExport(originInvoker);
        //registry provider
        final Registry registry = getRegistry(originInvoker);
        final URL registedProviderUrl = getRegistedProviderUrl(originInvoker);
        registry.register(registedProviderUrl);
        // 锟斤拷锟斤拷override锟斤拷锟斤拷
        // FIXME 锟结供锟竭讹拷锟斤拷时锟斤拷锟斤拷影锟斤拷同一JVM锟斤拷锟斤拷露锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷同一锟斤拷锟斤拷牡某锟斤拷锟斤拷锟斤拷锟轿猻ubscribed锟皆凤拷锟斤拷锟斤拷为锟斤拷锟斤拷锟絢ey锟斤拷锟斤拷锟铰讹拷锟斤拷锟斤拷息锟斤拷锟角★拷
        final URL overrideSubscribeUrl = getSubscribedOverrideUrl(registedProviderUrl);
        final OverrideListener overrideSubscribeListener = new OverrideListener(overrideSubscribeUrl);
        overrideListeners.put(overrideSubscribeUrl, overrideSubscribeListener);
        registry.subscribe(overrideSubscribeUrl, overrideSubscribeListener);
        //锟斤拷证每锟斤拷export锟斤拷锟斤拷锟斤拷一锟斤拷锟铰碉拷exporter实锟斤拷
        return new Exporter<T>() {
            @Override
            public Invoker<T> getInvoker() {
                return exporter.getInvoker();
            }
            @Override
            public void unexport() {
            	try {
            		exporter.unexport();
            	} catch (Throwable t) {
                	logger.warn(t.getMessage(), t);
                }
                try {
                	registry.unregister(registedProviderUrl);
                } catch (Throwable t) {
                	logger.warn(t.getMessage(), t);
                }
                try {
                	overrideListeners.remove(overrideSubscribeUrl);
                	registry.unsubscribe(overrideSubscribeUrl, overrideSubscribeListener);
                } catch (Throwable t) {
                	logger.warn(t.getMessage(), t);
                }
            }
        };
    }
    
    @SuppressWarnings("unchecked")
    private <T> ExporterChangeableWrapper<T>  doLocalExport(final Invoker<T> originInvoker){
        String key = getCacheKey(originInvoker);
        ExporterChangeableWrapper<T> exporter = (ExporterChangeableWrapper<T>) bounds.get(key);
        if (exporter == null) {
            synchronized (bounds) {
                exporter = (ExporterChangeableWrapper<T>) bounds.get(key);
                if (exporter == null) {
                    final Invoker<?> invokerDelegete = new InvokerDelegete<T>(originInvoker, getProviderUrl(originInvoker));
                    exporter = new ExporterChangeableWrapper<T>((Exporter<T>)protocol.export(invokerDelegete), originInvoker);
                    bounds.put(key, exporter);
                }
            }
        }
        return (ExporterChangeableWrapper<T>) exporter;
    }
    
    /**
     * 锟斤拷锟睫革拷锟斤拷url锟斤拷invoker锟斤拷锟斤拷export
     * @param originInvoker
     * @param newInvokerUrl
     */
    @SuppressWarnings("unchecked")
    private <T> void doChangeLocalExport(final Invoker<T> originInvoker, URL newInvokerUrl){
        String key = getCacheKey(originInvoker);
        final ExporterChangeableWrapper<T> exporter = (ExporterChangeableWrapper<T>) bounds.get(key);
        if (exporter == null){
            logger.warn(new IllegalStateException("error state, exporter should not be null"));
            return ;//锟斤拷锟斤拷锟斤拷锟斤拷锟届常锟斤拷锟斤拷 直锟接凤拷锟斤拷 
        } else {
            final Invoker<T> invokerDelegete = new InvokerDelegete<T>(originInvoker, newInvokerUrl);
            exporter.setExporter(protocol.export(invokerDelegete));
        }
    }

    /**
     * 锟斤拷锟斤拷invoker锟侥碉拷址锟斤拷取registry实锟斤拷
     * @param originInvoker
     * @return
     */
    private Registry getRegistry(final Invoker<?> originInvoker){
        URL registryUrl = originInvoker.getUrl();
        if (Constants.REGISTRY_PROTOCOL.equals(registryUrl.getProtocol())) {
            String protocol = registryUrl.getParameter(Constants.REGISTRY_KEY, Constants.DEFAULT_DIRECTORY);
            registryUrl = registryUrl.setProtocol(protocol).removeParameter(Constants.REGISTRY_KEY);
        }
        return registryFactory.getRegistry(registryUrl);
    }

    /**
     * 锟斤拷锟斤拷注锟结到注锟斤拷锟斤拷锟侥碉拷URL锟斤拷锟斤拷URL锟斤拷锟斤拷锟斤拷锟斤拷一锟轿癸拷锟斤拷
     * @param originInvoker
     * @return
     */
    private URL getRegistedProviderUrl(final Invoker<?> originInvoker){
        URL providerUrl = getProviderUrl(originInvoker);
        //注锟斤拷锟斤拷锟侥匡拷锟斤拷锟侥碉拷址
        final URL registedProviderUrl = providerUrl.removeParameters(getFilteredKeys(providerUrl)).removeParameter(Constants.MONITOR_KEY);
        return registedProviderUrl;
    }
    
    private URL getSubscribedOverrideUrl(URL registedProviderUrl){
    	return registedProviderUrl.setProtocol(Constants.PROVIDER_PROTOCOL)
                .addParameters(Constants.CATEGORY_KEY, Constants.CONFIGURATORS_CATEGORY, 
                        Constants.CHECK_KEY, String.valueOf(false));
    }

    /**
     * 通锟斤拷invoker锟斤拷url 锟斤拷取 providerUrl锟侥碉拷址
     * @param origininvoker
     * @return
     */
    private URL getProviderUrl(final Invoker<?> origininvoker){
        String export = origininvoker.getUrl().getParameterAndDecoded(Constants.EXPORT_KEY);
        if (export == null || export.length() == 0) {
            throw new IllegalArgumentException("The registry export url is null! registry: " + origininvoker.getUrl());
        }
        
        URL providerUrl = URL.valueOf(export);
        return providerUrl;
    }

    /**
     * 锟斤拷取invoker锟斤拷bounds锟叫伙拷锟斤拷锟絢ey
     * @param originInvoker
     * @return
     */
    private String getCacheKey(final Invoker<?> originInvoker){
        URL providerUrl = getProviderUrl(originInvoker);
        String key = providerUrl.removeParameters("dynamic", "enabled").toFullString();
        return key;
    }
    
    @Override
    @SuppressWarnings("unchecked")
	public <T> Invoker<T> refer(Class<T> type, URL url) throws RpcException {
        url = url.setProtocol(url.getParameter(Constants.REGISTRY_KEY, Constants.DEFAULT_REGISTRY)).removeParameter(Constants.REGISTRY_KEY);
        Registry registry = registryFactory.getRegistry(url);
        if (RegistryService.class.equals(type)) {
        	return proxyFactory.getInvoker((T) registry, type, url);
        }

        // group="a,b" or group="*"
        Map<String, String> qs = StringUtils.parseQueryString(url.getParameterAndDecoded(Constants.REFER_KEY));
        String group = qs.get(Constants.GROUP_KEY);
        if (group != null && group.length() > 0 ) {
            if ( ( Constants.COMMA_SPLIT_PATTERN.split( group ) ).length > 1
                    || "*".equals( group ) ) {
                return doRefer( getMergeableCluster(), registry, type, url );
            }
        }
        return doRefer(cluster, registry, type, url);
    }
    
    private Cluster getMergeableCluster() {
        return ExtensionLoader.getExtensionLoader(Cluster.class).getExtension("mergeable");
    }
    
    private <T> Invoker<T> doRefer(Cluster cluster, Registry registry, Class<T> type, URL url) {
        RegistryDirectory<T> directory = new RegistryDirectory<T>(type, url);
        directory.setRegistry(registry);
        directory.setProtocol(protocol);
        URL subscribeUrl = new URL(Constants.CONSUMER_PROTOCOL, NetUtils.getLocalHost(), 0, type.getName(), directory.getUrl().getParameters());
        if (! Constants.ANY_VALUE.equals(url.getServiceInterface())
                && url.getParameter(Constants.REGISTER_KEY, true)) {
            registry.register(subscribeUrl.addParameters(Constants.CATEGORY_KEY, Constants.CONSUMERS_CATEGORY,
                    Constants.CHECK_KEY, String.valueOf(false)));
        }
        directory.subscribe(subscribeUrl.addParameter(Constants.CATEGORY_KEY, 
                Constants.PROVIDERS_CATEGORY 
                + "," + Constants.CONFIGURATORS_CATEGORY 
                + "," + Constants.ROUTERS_CATEGORY));
        return cluster.join(directory);
    }

    //锟斤拷锟斤拷URL锟叫诧拷锟斤拷要锟斤拷锟斤拷牟锟斤拷锟�(锟皆碉拷趴锟酵凤拷锟�)
    private static String[] getFilteredKeys(URL url) {
        Map<String, String> params = url.getParameters();
        if (params != null && !params.isEmpty()) {
            List<String> filteredKeys = new ArrayList<String>();
            for (Map.Entry<String, String> entry : params.entrySet()) {
                if (entry != null && entry.getKey() != null && entry.getKey().startsWith(Constants.HIDE_KEY_PREFIX)) {
                    filteredKeys.add(entry.getKey());
                }
            }
            return filteredKeys.toArray(new String[filteredKeys.size()]);
        } else {
            return new String[] {};
        }
    }
    
    @Override
    public void destroy() {
        List<Exporter<?>> exporters = new ArrayList<Exporter<?>>(bounds.values());
        for(Exporter<?> exporter :exporters){
            exporter.unexport();
        }
        bounds.clear();
    }
    
    
    /*锟斤拷锟斤拷export 1.protocol锟叫碉拷exporter destory锟斤拷锟斤拷 
     *1.要锟斤拷registryprotocol锟斤拷锟截碉拷exporter锟斤拷锟斤拷锟斤拷锟斤拷destroy
     *2.notify锟斤拷锟斤拷要锟斤拷锟斤拷锟斤拷注锟斤拷锟斤拷锟斤拷注锟斤拷 
     *3.export 锟斤拷锟斤拷锟斤拷锟斤拷锟絠nvoker锟斤拷锟斤拷锟揭恢憋拷锟轿猠xporter锟斤拷invoker.
     */
    private class OverrideListener implements NotifyListener {
    	
    	private volatile List<Configurator> configurators;
    	
    	private final URL subscribeUrl;

		public OverrideListener(URL subscribeUrl) {
			this.subscribeUrl = subscribeUrl;
		}

		/*
         *  provider 锟剿匡拷识锟斤拷锟給verride url只锟斤拷锟斤拷锟斤拷锟斤拷.
         *  override://0.0.0.0/serviceName?timeout=10
         *  override://0.0.0.0/?timeout=10
         */
        @Override
        public void notify(List<URL> urls) {
        	List<URL> result = null;
        	for (URL url : urls) {
        		URL overrideUrl = url;
        		if (url.getParameter(Constants.CATEGORY_KEY) == null
        				&& Constants.OVERRIDE_PROTOCOL.equals(url.getProtocol())) {
        			// 锟斤拷锟捷旧版本
        			overrideUrl = url.addParameter(Constants.CATEGORY_KEY, Constants.CONFIGURATORS_CATEGORY);
        		}
        		if (! UrlUtils.isMatch(subscribeUrl, overrideUrl)) {
        			if (result == null) {
        				result = new ArrayList<URL>(urls);
        			}
        			result.remove(url);
        			logger.warn("Subsribe category=configurator, but notifed non-configurator urls. may be registry bug. unexcepted url: " + url);
        		}
        	}
        	if (result != null) {
        		urls = result;
        	}
        	this.configurators = RegistryDirectory.toConfigurators(urls);
            List<ExporterChangeableWrapper<?>> exporters = new ArrayList<ExporterChangeableWrapper<?>>(bounds.values());
            for (ExporterChangeableWrapper<?> exporter : exporters){
                Invoker<?> invoker = exporter.getOriginInvoker();
                final Invoker<?> originInvoker ;
                if (invoker instanceof InvokerDelegete){
                    originInvoker = ((InvokerDelegete<?>)invoker).getInvoker();
                }else {
                    originInvoker = invoker;
                }
                
                URL originUrl = RegistryProtocol.this.getProviderUrl(originInvoker);
                URL newUrl = getNewInvokerUrl(originUrl, urls);
                
                if (! originUrl.equals(newUrl)){
                    RegistryProtocol.this.doChangeLocalExport(originInvoker, newUrl);
                }
            }
        }
        
        private URL getNewInvokerUrl(URL url, List<URL> urls){
        	List<Configurator> localConfigurators = this.configurators; // local reference
            // 锟较诧拷override锟斤拷锟斤拷
            if (localConfigurators != null && localConfigurators.size() > 0) {
                for (Configurator configurator : localConfigurators) {
                    url = configurator.configure(url);
                }
            }
            return url;
        }
    }
    
    public static class InvokerDelegete<T> extends InvokerWrapper<T>{
        private final Invoker<T> invoker;
        /**
         * @param invoker 
         * @param url invoker.getUrl锟斤拷锟截达拷值
         */
        public InvokerDelegete(Invoker<T> invoker, URL url){
            super(invoker, url);
            this.invoker = invoker;
        }
        public Invoker<T> getInvoker(){
            if (invoker instanceof InvokerDelegete){
                return ((InvokerDelegete<T>)invoker).getInvoker();
            } else {
                return invoker;
            }
        }
    }
    
    /**
     * exporter锟斤拷锟斤拷,锟斤拷锟斤拷锟斤拷锟截碉拷exporter锟斤拷protocol export锟斤拷锟斤拷exporter锟侥讹拷应锟斤拷系锟斤拷锟斤拷override时锟斤拷锟皆斤拷锟叫癸拷系锟睫革拷.
     * 
     * @author chao.liuc
     *
     * @param <T>
     */
    private class ExporterChangeableWrapper<T> implements Exporter<T>{
    	
        private Exporter<T> exporter;
        
        private final Invoker<T> originInvoker;

        public ExporterChangeableWrapper(Exporter<T> exporter, Invoker<T> originInvoker){
            this.exporter = exporter;
            this.originInvoker = originInvoker;
        }
        
        public Invoker<T> getOriginInvoker() {
            return originInvoker;
        }

        @Override
        public Invoker<T> getInvoker() {
            return exporter.getInvoker();
        }
        
        public void setExporter(Exporter<T> exporter){
            this.exporter = exporter;
        }

        @Override
        public void unexport() {
            String key = getCacheKey(this.originInvoker);
            bounds.remove(key);
            exporter.unexport();
        }
    }
}
