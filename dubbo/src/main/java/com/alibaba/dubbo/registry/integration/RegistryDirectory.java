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
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.alibaba.dubbo.common.Constants;
import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.Version;
import com.alibaba.dubbo.common.extension.ExtensionLoader;
import com.alibaba.dubbo.common.logger.Logger;
import com.alibaba.dubbo.common.logger.LoggerFactory;
import com.alibaba.dubbo.common.utils.NetUtils;
import com.alibaba.dubbo.common.utils.StringUtils;
import com.alibaba.dubbo.registry.NotifyListener;
import com.alibaba.dubbo.registry.Registry;
import com.alibaba.dubbo.rpc.Invocation;
import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.Protocol;
import com.alibaba.dubbo.rpc.RpcException;
import com.alibaba.dubbo.rpc.RpcInvocation;
import com.alibaba.dubbo.rpc.cluster.Cluster;
import com.alibaba.dubbo.rpc.cluster.Configurator;
import com.alibaba.dubbo.rpc.cluster.ConfiguratorFactory;
import com.alibaba.dubbo.rpc.cluster.Router;
import com.alibaba.dubbo.rpc.cluster.RouterFactory;
import com.alibaba.dubbo.rpc.cluster.directory.AbstractDirectory;
import com.alibaba.dubbo.rpc.cluster.directory.StaticDirectory;
import com.alibaba.dubbo.rpc.cluster.support.ClusterUtils;
import com.alibaba.dubbo.rpc.protocol.InvokerWrapper;
import com.alibaba.dubbo.rpc.support.RpcUtils;

/**
 * RegistryDirectory
 * 
 * @author william.liangf
 * @author chao.liuc
 */
public class RegistryDirectory<T> extends AbstractDirectory<T> implements NotifyListener {

    private static final Logger logger = LoggerFactory.getLogger(RegistryDirectory.class);
    
    private static final Cluster cluster = ExtensionLoader.getExtensionLoader(Cluster.class).getAdaptiveExtension();
    
    private static final RouterFactory routerFactory = ExtensionLoader.getExtensionLoader(RouterFactory.class).getAdaptiveExtension();

    private static final ConfiguratorFactory configuratorFactory = ExtensionLoader.getExtensionLoader(ConfiguratorFactory.class).getAdaptiveExtension();

    private Protocol protocol; // 注锟斤拷时锟斤拷始锟斤拷锟斤拷锟斤拷锟皆诧拷为null

    private Registry registry; // 注锟斤拷时锟斤拷始锟斤拷锟斤拷锟斤拷锟皆诧拷为null

    private final String serviceKey; // 锟斤拷锟斤拷时锟斤拷始锟斤拷锟斤拷锟斤拷锟皆诧拷为null

    private final Class<T> serviceType; // 锟斤拷锟斤拷时锟斤拷始锟斤拷锟斤拷锟斤拷锟皆诧拷为null
    
    private final Map<String, String> queryMap; // 锟斤拷锟斤拷时锟斤拷始锟斤拷锟斤拷锟斤拷锟皆诧拷为null

    private final URL directoryUrl; // 锟斤拷锟斤拷时锟斤拷始锟斤拷锟斤拷锟斤拷锟皆诧拷为null锟斤拷锟斤拷锟斤拷锟斤拷锟角革拷锟斤拷null值
    
    private final String[] serviceMethods;

    private final boolean multiGroup;

    private volatile boolean forbidden = false;
    
    private volatile URL overrideDirectoryUrl; // 锟斤拷锟斤拷时锟斤拷始锟斤拷锟斤拷锟斤拷锟皆诧拷为null锟斤拷锟斤拷锟斤拷锟斤拷锟角革拷锟斤拷null值

    /*override锟斤拷锟斤拷 
     * 锟斤拷锟饺硷拷锟斤拷override>-D>consumer>provider
     * 锟斤拷一锟街癸拷锟斤拷锟斤拷锟侥筹拷锟絧rovider <ip:port,timeout=100>
     * 锟节讹拷锟街癸拷锟斤拷锟斤拷锟斤拷锟斤拷锟絧rovider <* ,timeout=5000>
     */
    private volatile List<Configurator> configurators; // 锟斤拷始为null锟皆硷拷锟斤拷途锟斤拷锟杰憋拷锟斤拷为null锟斤拷锟斤拷使锟矫局诧拷锟斤拷锟斤拷锟斤拷锟斤拷
    
    // Map<url, Invoker> cache service url to invoker mapping.
    private volatile Map<String, Invoker<T>> urlInvokerMap; // 锟斤拷始为null锟皆硷拷锟斤拷途锟斤拷锟杰憋拷锟斤拷为null锟斤拷锟斤拷使锟矫局诧拷锟斤拷锟斤拷锟斤拷锟斤拷
    
    // Map<methodName, Invoker> cache service method to invokers mapping.
    private volatile Map<String, List<Invoker<T>>> methodInvokerMap; // 锟斤拷始为null锟皆硷拷锟斤拷途锟斤拷锟杰憋拷锟斤拷为null锟斤拷锟斤拷使锟矫局诧拷锟斤拷锟斤拷锟斤拷锟斤拷
    
    // Set<invokerUrls> cache invokeUrls to invokers mapping.
    private volatile Set<URL> cachedInvokerUrls; // 锟斤拷始为null锟皆硷拷锟斤拷途锟斤拷锟杰憋拷锟斤拷为null锟斤拷锟斤拷使锟矫局诧拷锟斤拷锟斤拷锟斤拷锟斤拷

    public RegistryDirectory(Class<T> serviceType, URL url) {
        super(url);
        if(serviceType == null ) {
            throw new IllegalArgumentException("service type is null.");
        }
        if(url.getServiceKey() == null || url.getServiceKey().length() == 0) {
            throw new IllegalArgumentException("registry serviceKey is null.");
        }
        this.serviceType = serviceType;
        this.serviceKey = url.getServiceKey();
        this.queryMap = StringUtils.parseQueryString(url.getParameterAndDecoded(Constants.REFER_KEY));
        this.overrideDirectoryUrl = this.directoryUrl = url.setPath(url.getServiceInterface()).clearParameters().addParameters(queryMap).removeParameter(Constants.MONITOR_KEY);
        String group = directoryUrl.getParameter( Constants.GROUP_KEY, "" );
        this.multiGroup = group != null && ("*".equals(group) || group.contains( "," ));
        String methods = queryMap.get(Constants.METHODS_KEY);
        this.serviceMethods = methods == null ? null : Constants.COMMA_SPLIT_PATTERN.split(methods);
    }

    public void setProtocol(Protocol protocol) {
        this.protocol = protocol;
    }

    public void setRegistry(Registry registry) {
        this.registry = registry;
    }
    
    public void subscribe(URL url) {
        setConsumerUrl(url);
        registry.subscribe(url, this);
    }

    @Override
    public void destroy() {
        if(isDestroyed()) {
            return;
        }
        // unsubscribe.
        try {
            if(getConsumerUrl() != null && registry != null && registry.isAvailable()) {
                registry.unsubscribe(getConsumerUrl(), this);
            }
        } catch (Throwable t) {
            logger.warn("unexpeced error when unsubscribe service " + serviceKey + "from registry" + registry.getUrl(), t);
        }
        super.destroy(); // 锟斤拷锟斤拷锟斤拷unsubscribe之锟斤拷执锟斤拷
        try {
            destroyAllInvokers();
        } catch (Throwable t) {
            logger.warn("Failed to destroy service " + serviceKey, t);
        }
    }

    @Override
    public synchronized void notify(List<URL> urls) {
        List<URL> invokerUrls = new ArrayList<URL>();
        List<URL> routerUrls = new ArrayList<URL>();
        List<URL> configuratorUrls = new ArrayList<URL>();
        for (URL url : urls) {
            String protocol = url.getProtocol();
            String category = url.getParameter(Constants.CATEGORY_KEY, Constants.DEFAULT_CATEGORY);
            if (Constants.ROUTERS_CATEGORY.equals(category) 
                    || Constants.ROUTE_PROTOCOL.equals(protocol)) {
                routerUrls.add(url);
            } else if (Constants.CONFIGURATORS_CATEGORY.equals(category) 
                    || Constants.OVERRIDE_PROTOCOL.equals(protocol)) {
                configuratorUrls.add(url);
            } else if (Constants.PROVIDERS_CATEGORY.equals(category)) {
                invokerUrls.add(url);
            } else {
                logger.warn("Unsupported category " + category + " in notified url: " + url + " from registry " + getUrl().getAddress() + " to consumer " + NetUtils.getLocalHost());
            }
        }
        // configurators 
        if (configuratorUrls != null && configuratorUrls.size() >0 ){
            this.configurators = toConfigurators(configuratorUrls);
        }
        // routers
        if (routerUrls != null && routerUrls.size() >0 ){
            List<Router> routers = toRouters(routerUrls);
            if(routers != null){ // null - do nothing
                setRouters(routers);
            }
        }
        List<Configurator> localConfigurators = this.configurators; // local reference
        // 锟较诧拷override锟斤拷锟斤拷
        this.overrideDirectoryUrl = directoryUrl;
        if (localConfigurators != null && localConfigurators.size() > 0) {
            for (Configurator configurator : localConfigurators) {
                this.overrideDirectoryUrl = configurator.configure(overrideDirectoryUrl);
            }
        }
        // providers
        refreshInvoker(invokerUrls);
    }
    
    
    /**
     * 锟斤拷锟斤拷invokerURL锟叫憋拷转锟斤拷为invoker锟叫憋拷转锟斤拷锟斤拷锟斤拷锟斤拷锟铰ｏ拷
     * 1.锟斤拷锟絬rl锟窖撅拷锟斤拷转锟斤拷为invoker锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟矫ｏ拷直锟接从伙拷锟斤拷锟叫伙拷取锟斤拷注锟斤拷锟斤拷锟絬rl锟斤拷锟轿猴拷一锟斤拷锟斤拷锟斤拷锟斤拷锟揭诧拷锟斤拷锟斤拷锟斤拷锟斤拷锟�
     * 2.锟斤拷锟斤拷锟斤拷锟斤拷invoker锟叫憋拷为锟秸ｏ拷锟斤拷锟绞撅拷锟斤拷碌锟絠nvoker锟叫憋拷
     * 3.锟斤拷锟斤拷锟斤拷锟斤拷invokerUrl锟叫憋拷锟角空ｏ拷锟斤拷锟绞局伙拷锟斤拷路锟斤拷锟給verride锟斤拷锟斤拷锟絩oute锟斤拷锟斤拷锟斤拷要锟斤拷锟铰斤拷锟斤拷员龋锟斤拷锟斤拷锟斤拷欠锟斤拷锟揭拷锟斤拷锟斤拷锟斤拷谩锟�
     * @param invokerUrls 锟斤拷锟斤拷牟锟斤拷锟斤拷锟斤拷锟轿猲ull
     */
    private void refreshInvoker(List<URL> invokerUrls){
        if (invokerUrls != null && invokerUrls.size() == 1 && invokerUrls.get(0) != null
                && Constants.EMPTY_PROTOCOL.equals(invokerUrls.get(0).getProtocol())) {
            this.forbidden = true; // 锟斤拷止锟斤拷锟斤拷
            this.methodInvokerMap = null; // 锟矫匡拷锟叫憋拷
            destroyAllInvokers(); // 锟截憋拷锟斤拷锟斤拷Invoker
        } else {
            this.forbidden = false; // 锟斤拷锟斤拷锟斤拷锟�
            Map<String, Invoker<T>> oldUrlInvokerMap = this.urlInvokerMap; // local reference
            if (invokerUrls.size() == 0 && this.cachedInvokerUrls != null){
                invokerUrls.addAll(this.cachedInvokerUrls);
            } else {
                this.cachedInvokerUrls = new HashSet<URL>();
                this.cachedInvokerUrls.addAll(invokerUrls);//锟斤拷锟斤拷invokerUrls锟叫憋拷锟斤拷锟节斤拷锟斤拷员锟�
            }
            if (invokerUrls.size() ==0 ){
            	return;
            }
            Map<String, Invoker<T>> newUrlInvokerMap = toInvokers(invokerUrls) ;// 锟斤拷URL锟叫憋拷转锟斤拷Invoker锟叫憋拷
            Map<String, List<Invoker<T>>> newMethodInvokerMap = toMethodInvokers(newUrlInvokerMap); // 锟斤拷锟斤拷锟斤拷锟斤拷映锟斤拷Invoker锟叫憋拷
            // state change
            //锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟津不斤拷锟叫达拷锟斤拷.
            if (newUrlInvokerMap == null || newUrlInvokerMap.size() == 0 ){
                logger.error(new IllegalStateException("urls to invokers error .invokerUrls.size :"+invokerUrls.size() + ", invoker.size :0. urls :"+invokerUrls.toString()));
                return ;
            }
            this.methodInvokerMap = multiGroup ? toMergeMethodInvokerMap(newMethodInvokerMap) : newMethodInvokerMap;
            this.urlInvokerMap = newUrlInvokerMap;
            try{
                destroyUnusedInvokers(oldUrlInvokerMap,newUrlInvokerMap); // 锟截憋拷未使锟矫碉拷Invoker
            }catch (Exception e) {
                logger.warn("destroyUnusedInvokers error. ", e);
            }
        }
    }
    
    private Map<String, List<Invoker<T>>> toMergeMethodInvokerMap(Map<String, List<Invoker<T>>> methodMap) {
        Map<String, List<Invoker<T>>> result = new HashMap<String, List<Invoker<T>>>();
        for (Map.Entry<String, List<Invoker<T>>> entry : methodMap.entrySet()) {
            String method = entry.getKey();
            List<Invoker<T>> invokers = entry.getValue();
            Map<String, List<Invoker<T>>> groupMap = new HashMap<String, List<Invoker<T>>>();
            for (Invoker<T> invoker : invokers) {
                String group = invoker.getUrl().getParameter(Constants.GROUP_KEY, "");
                List<Invoker<T>> groupInvokers = groupMap.get(group);
                if (groupInvokers == null) {
                    groupInvokers = new ArrayList<Invoker<T>>();
                    groupMap.put(group, groupInvokers);
                }
                groupInvokers.add(invoker);
            }
            if (groupMap.size() == 1) {
                result.put(method, groupMap.values().iterator().next());
            } else if (groupMap.size() > 1) {
                List<Invoker<T>> groupInvokers = new ArrayList<Invoker<T>>();
                for (List<Invoker<T>> groupList : groupMap.values()) {
                    groupInvokers.add(cluster.join(new StaticDirectory<T>(groupList)));
                }
                result.put(method, groupInvokers);
            } else {
                result.put(method, invokers);
            }
        }
        return result;
    }
    
    /**
     * 锟斤拷overrideURL转锟斤拷为map锟斤拷锟斤拷锟斤拷锟斤拷refer时使锟斤拷.
     * 每锟斤拷锟铰凤拷全锟斤拷锟斤拷锟斤拷全锟斤拷锟斤拷锟斤拷锟斤拷装锟斤拷锟斤拷
     * @param urls
     * 锟斤拷约锟斤拷
     * </br>1.override://0.0.0.0/...(锟斤拷override://ip:port...?anyhost=true)&para1=value1...锟斤拷示全锟街癸拷锟斤拷(锟斤拷锟斤拷锟叫碉拷锟结供锟斤拷全锟斤拷锟斤拷效)
     * </br>2.override://ip:port...?anyhost=false 锟斤拷锟斤拷锟斤拷锟斤拷只锟斤拷锟侥筹拷锟斤拷峁╋拷锟斤拷锟叫э拷锟�
     * </br>3.锟斤拷支锟斤拷override://锟斤拷锟斤拷... 锟斤拷要注锟斤拷锟斤拷锟斤拷锟斤拷锟叫硷拷锟斤拷.
     * </br>4.锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷override://0.0.0.0/ 锟斤拷示锟斤拷锟給verride 
     * @return
     */
    public static List<Configurator> toConfigurators(List<URL> urls){
        List<Configurator> configurators = new ArrayList<Configurator>(urls.size());
        if (urls == null || urls.size() == 0){
            return configurators;
        }
        for(URL url : urls){
            if (Constants.EMPTY_PROTOCOL.equals(url.getProtocol())) {
                configurators.clear();
                break;
            }
            Map<String,String> override = new HashMap<String, String>(url.getParameters());
            //override 锟较碉拷anyhost锟斤拷锟斤拷锟斤拷锟皆讹拷锟斤拷拥模锟斤拷锟斤拷锟接帮拷锟侥憋拷url锟叫讹拷
            override.remove(Constants.ANYHOST_KEY);
            if (override.size() == 0){
                configurators.clear();
                continue;
            }
            configurators.add(configuratorFactory.getConfigurator(url));
        }
        Collections.sort(configurators);
        return configurators;
    }
    
    /**
     * 
     * @param urls
     * @return null : no routers ,do nothing
     *         else :routers list
     */
    private List<Router> toRouters(List<URL> urls) {
        List<Router> routers = new ArrayList<Router>();
        if(urls == null || urls.size() < 1){
            return routers ;
        }
        if (urls != null && urls.size() > 0) {
            for (URL url : urls) {
                if (Constants.EMPTY_PROTOCOL.equals(url.getProtocol())) {
                    continue;
                }
                String routerType = url.getParameter(Constants.ROUTER_KEY);
                if (routerType != null && routerType.length() > 0){
                    url = url.setProtocol(routerType);
                }
                try{
                    Router router = routerFactory.getRouter(url);
                    if (!routers.contains(router)) {
                        routers.add(router);
                    }
                } catch (Throwable t) {
                    logger.error("convert router url to router error, url: "+ url, t);
                }
            }
        }
        return routers;
    }
    
    /**
     * 锟斤拷urls转锟斤拷invokers,锟斤拷锟絬rl锟窖撅拷锟斤拷refer锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟矫★拷
     * 
     * @param urls
     * @param overrides
     * @param query
     * @return invokers
     */
    private Map<String, Invoker<T>> toInvokers(List<URL> urls) {
        Map<String, Invoker<T>> newUrlInvokerMap = new HashMap<String, Invoker<T>>();
        if(urls == null || urls.size() == 0){
            return newUrlInvokerMap;
        }
        Set<String> keys = new HashSet<String>();
        String queryProtocols = this.queryMap.get(Constants.PROTOCOL_KEY);
        for (URL providerUrl : urls) {
        	//锟斤拷锟絩eference锟斤拷锟斤拷锟斤拷锟斤拷protocol锟斤拷锟斤拷只选锟斤拷匹锟斤拷锟絧rotocol
        	if (queryProtocols != null && queryProtocols.length() >0) {
        		boolean accept = false;
        		String[] acceptProtocols = queryProtocols.split(",");
        		for (String acceptProtocol : acceptProtocols) {
        			if (providerUrl.getProtocol().equals(acceptProtocol)) {
        				accept = true;
        				break;
        			}
        		}
        		if (!accept) {
        			continue;
        		}
        	}
            if (Constants.EMPTY_PROTOCOL.equals(providerUrl.getProtocol())) {
                continue;
            }
            if (! ExtensionLoader.getExtensionLoader(Protocol.class).hasExtension(providerUrl.getProtocol())) {
                logger.error(new IllegalStateException("Unsupported protocol " + providerUrl.getProtocol() + " in notified url: " + providerUrl + " from registry " + getUrl().getAddress() + " to consumer " + NetUtils.getLocalHost() 
                        + ", supported protocol: "+ExtensionLoader.getExtensionLoader(Protocol.class).getSupportedExtensions()));
                continue;
            }
            URL url = mergeUrl(providerUrl);
            
            String key = url.toFullString(); // URL锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟�
            if (keys.contains(key)) { // 锟截革拷URL
                continue;
            }
            keys.add(key);
            // 锟斤拷锟斤拷key为没锟叫合诧拷锟斤拷锟窖端诧拷锟斤拷锟斤拷URL锟斤拷锟斤拷锟斤拷锟斤拷锟窖讹拷锟斤拷魏喜锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟経RL锟斤拷锟斤拷锟戒化锟斤拷锟斤拷锟斤拷锟斤拷refer
            Map<String, Invoker<T>> localUrlInvokerMap = this.urlInvokerMap; // local reference
            Invoker<T> invoker = localUrlInvokerMap == null ? null : localUrlInvokerMap.get(key);
            if (invoker == null) { // 锟斤拷锟斤拷锟斤拷没锟叫ｏ拷锟斤拷锟斤拷refer
                try {
                	boolean enabled = true;
                	if (url.hasParameter(Constants.DISABLED_KEY)) {
                		enabled = ! url.getParameter(Constants.DISABLED_KEY, false);
                	} else {
                		enabled = url.getParameter(Constants.ENABLED_KEY, true);
                	}
                	if (enabled) {
                		invoker = new InvokerDelegete<T>(protocol.refer(serviceType, url), url, providerUrl);
                	}
                } catch (Throwable t) {
                    logger.error("Failed to refer invoker for interface:"+serviceType+",url:("+url+")" + t.getMessage(), t);
                }
                if (invoker != null) { // 锟斤拷锟铰碉拷锟斤拷锟矫凤拷锟诫缓锟斤拷
                    newUrlInvokerMap.put(key, invoker);
                }
            }else {
                newUrlInvokerMap.put(key, invoker);
            }
        }
        keys.clear();
        return newUrlInvokerMap;
    }
    
    /**
     * 锟较诧拷url锟斤拷锟斤拷 顺锟斤拷为override > -D >Consumer > Provider
     * @param providerUrl
     * @param overrides
     * @return
     */
    private URL mergeUrl(URL providerUrl){
        providerUrl = ClusterUtils.mergeUrl(providerUrl, queryMap); // 锟较诧拷锟斤拷锟窖端诧拷锟斤拷
        
        List<Configurator> localConfigurators = this.configurators; // local reference
        if (localConfigurators != null && localConfigurators.size() > 0) {
            for (Configurator configurator : localConfigurators) {
                providerUrl = configurator.configure(providerUrl);
            }
        }
        
        providerUrl = providerUrl.addParameter(Constants.CHECK_KEY, String.valueOf(false)); // 锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷欠锟缴癸拷锟斤拷锟斤拷锟角达拷锟斤拷Invoker锟斤拷
        
        //directoryUrl 锟斤拷 override 锟较诧拷锟斤拷锟斤拷notify锟斤拷锟斤拷锟斤拷锟斤拷锊伙拷芄锟斤拷锟斤拷锟�
        this.overrideDirectoryUrl = this.overrideDirectoryUrl.addParametersIfAbsent(providerUrl.getParameters()); // 锟较诧拷锟结供锟竭诧拷锟斤拷        
        
        if ((providerUrl.getPath() == null || providerUrl.getPath().length() == 0)
                && "dubbo".equals(providerUrl.getProtocol())) { // 锟斤拷锟斤拷1.0
            //fix by tony.chenl DUBBO-44
            String path = directoryUrl.getParameter(Constants.INTERFACE_KEY);
            if (path != null) {
                int i = path.indexOf('/');
                if (i >= 0) {
                    path = path.substring(i + 1);
                }
                i = path.lastIndexOf(':');
                if (i >= 0) {
                    path = path.substring(0, i);
                }
                providerUrl = providerUrl.setPath(path);
            }
        }
        return providerUrl;
    }

    private List<Invoker<T>> route(List<Invoker<T>> invokers, String method) {
        Invocation invocation = new RpcInvocation(method, new Class<?>[0], new Object[0]);
        List<Router> routers = getRouters(); 
        if (routers != null) {
            for (Router router : routers) {
                if (router.getUrl() != null && ! router.getUrl().getParameter(Constants.RUNTIME_KEY, true)) {
                    invokers = router.route(invokers, getConsumerUrl(), invocation);
                }
            }
        }
        return invokers;
    }

    /**
     * 锟斤拷invokers锟叫憋拷转锟斤拷锟诫方锟斤拷锟斤拷映锟斤拷锟较�
     * 
     * @param invokersMap Invoker锟叫憋拷
     * @return Invoker锟诫方锟斤拷锟斤拷映锟斤拷锟较�
     */
    private Map<String, List<Invoker<T>>> toMethodInvokers(Map<String, Invoker<T>> invokersMap) {
        Map<String, List<Invoker<T>>> newMethodInvokerMap = new HashMap<String, List<Invoker<T>>>();
        // 锟斤拷锟结供锟斤拷URL锟斤拷锟斤拷锟斤拷锟斤拷methods锟斤拷锟洁，锟斤拷锟斤拷注锟斤拷锟斤拷锟斤拷执锟斤拷路锟缴癸拷锟剿碉拷锟斤拷methods
        List<Invoker<T>> invokersList = new ArrayList<Invoker<T>>();
        if (invokersMap != null && invokersMap.size() > 0) {
            for (Invoker<T> invoker : invokersMap.values()) {
                String parameter = invoker.getUrl().getParameter(Constants.METHODS_KEY);
                if (parameter != null && parameter.length() > 0) {
                    String[] methods = Constants.COMMA_SPLIT_PATTERN.split(parameter);
                    if (methods != null && methods.length > 0) {
                        for (String method : methods) {
                            if (method != null && method.length() > 0 
                                    && ! Constants.ANY_VALUE.equals(method)) {
                                List<Invoker<T>> methodInvokers = newMethodInvokerMap.get(method);
                                if (methodInvokers == null) {
                                    methodInvokers = new ArrayList<Invoker<T>>();
                                    newMethodInvokerMap.put(method, methodInvokers);
                                }
                                methodInvokers.add(invoker);
                            }
                        }
                    }
                }
                invokersList.add(invoker);
            }
        }
        newMethodInvokerMap.put(Constants.ANY_VALUE, invokersList);
        if (serviceMethods != null && serviceMethods.length > 0) {
            for (String method : serviceMethods) {
                List<Invoker<T>> methodInvokers = newMethodInvokerMap.get(method);
                if (methodInvokers == null || methodInvokers.size() == 0) {
                    methodInvokers = invokersList;
                }
                newMethodInvokerMap.put(method, route(methodInvokers, method));
            }
        }
        // sort and unmodifiable
        for (String method : new HashSet<String>(newMethodInvokerMap.keySet())) {
            List<Invoker<T>> methodInvokers = newMethodInvokerMap.get(method);
            Collections.sort(methodInvokers, InvokerComparator.getComparator());
            newMethodInvokerMap.put(method, Collections.unmodifiableList(methodInvokers));
        }
        return Collections.unmodifiableMap(newMethodInvokerMap);
    }

    /**
     * 锟截憋拷锟斤拷锟斤拷Invoker
     */
    private void destroyAllInvokers() {
        Map<String, Invoker<T>> localUrlInvokerMap = this.urlInvokerMap; // local reference
        if(localUrlInvokerMap != null) {
            for (Invoker<T> invoker : new ArrayList<Invoker<T>>(localUrlInvokerMap.values())) {
                try {
                    invoker.destroy();
                } catch (Throwable t) {
                    logger.warn("Failed to destroy service " + serviceKey + " to provider " + invoker.getUrl(), t);
                }
            }
            localUrlInvokerMap.clear();
        }
        methodInvokerMap = null;
    }
    
    /**
     * 锟斤拷榛猴拷锟斤拷械锟絠nvoker锟角凤拷锟斤拷要锟斤拷destroy
     * 锟斤拷锟絬rl锟斤拷指锟斤拷refer.autodestroy=false锟斤拷锟斤拷只锟斤拷锟接诧拷锟斤拷锟劫ｏ拷锟斤拷锟杰伙拷锟斤拷refer泄漏锟斤拷
     * 
     * @param invokers
     */
    private void destroyUnusedInvokers(Map<String, Invoker<T>> oldUrlInvokerMap, Map<String, Invoker<T>> newUrlInvokerMap) {
        if (newUrlInvokerMap == null || newUrlInvokerMap.size() == 0) {
            destroyAllInvokers();
            return;
        }
        // check deleted invoker
        List<String> deleted = null;
        if (oldUrlInvokerMap != null) {
            Collection<Invoker<T>> newInvokers = newUrlInvokerMap.values();
            for (Map.Entry<String, Invoker<T>> entry : oldUrlInvokerMap.entrySet()){
                if (! newInvokers.contains(entry.getValue())) {
                    if (deleted == null) {
                        deleted = new ArrayList<String>();
                    }
                    deleted.add(entry.getKey());
                }
            }
        }
        
        if (deleted != null) {
            for (String url : deleted){
                if (url != null ) {
                    Invoker<T> invoker = oldUrlInvokerMap.remove(url);
                    if (invoker != null) {
                        try {
                            invoker.destroy();
                            if(logger.isDebugEnabled()){
                                logger.debug("destory invoker["+invoker.getUrl()+"] success. ");
                            }
                        } catch (Exception e) {
                            logger.warn("destory invoker["+invoker.getUrl()+"] faild. " + e.getMessage(), e);
                        }
                    }
                }
            }
        }
    }

    @Override
    public List<Invoker<T>> doList(Invocation invocation) {
        if (forbidden) {
            throw new RpcException(RpcException.FORBIDDEN_EXCEPTION, "Forbid consumer " +  NetUtils.getLocalHost() + " access service " + getInterface().getName() + " from registry " + getUrl().getAddress() + " use dubbo version " + Version.getVersion() + ", Please check registry access list (whitelist/blacklist).");
        }
        List<Invoker<T>> invokers = null;
        Map<String, List<Invoker<T>>> localMethodInvokerMap = this.methodInvokerMap; // local reference
        if (localMethodInvokerMap != null && localMethodInvokerMap.size() > 0) {
            String methodName = RpcUtils.getMethodName(invocation);
            Object[] args = RpcUtils.getArguments(invocation);
            if(args != null && args.length > 0 && args[0] != null
                    && (args[0] instanceof String || args[0].getClass().isEnum())) {
                invokers = localMethodInvokerMap.get(methodName + "." + args[0]); // 锟缴革拷锟捷碉拷一锟斤拷锟斤拷锟斤拷枚锟斤拷路锟斤拷
            }
            if(invokers == null) {
                invokers = localMethodInvokerMap.get(methodName);
            }
            if(invokers == null) {
                invokers = localMethodInvokerMap.get(Constants.ANY_VALUE);
            }
            if(invokers == null) {
                Iterator<List<Invoker<T>>> iterator = localMethodInvokerMap.values().iterator();
                if (iterator.hasNext()) {
                    invokers = iterator.next();
                }
            }
        }
        return invokers == null ? new ArrayList<Invoker<T>>(0) : invokers;
    }
    
    @Override
    public Class<T> getInterface() {
        return serviceType;
    }

    @Override
    public URL getUrl() {
    	return this.overrideDirectoryUrl;
    }

    @Override
    public boolean isAvailable() {
        if (isDestroyed()) {
            return false;
        }
        Map<String, Invoker<T>> localUrlInvokerMap = urlInvokerMap;
        if (localUrlInvokerMap != null && localUrlInvokerMap.size() > 0) {
            for (Invoker<T> invoker : new ArrayList<Invoker<T>>(localUrlInvokerMap.values())) {
                if (invoker.isAvailable()) {
                    return true;
                }
            }
        }
        return false;
    }
    
    /**
     * Haomin: added for test purpose
     */
    public Map<String, Invoker<T>> getUrlInvokerMap(){
        return urlInvokerMap;
    }
    
    /**
     * Haomin: added for test purpose
     */
    public Map<String, List<Invoker<T>>> getMethodInvokerMap(){
        return methodInvokerMap;
    } 
    
    private static class InvokerComparator implements Comparator<Invoker<?>> {
        
        private static final InvokerComparator comparator = new InvokerComparator();
        
        public static InvokerComparator getComparator() {
            return comparator;
        }
        
        private InvokerComparator() {}

        @Override
        public int compare(Invoker<?> o1, Invoker<?> o2) {
            return o1.getUrl().toString().compareTo(o2.getUrl().toString());
        }

    }
    
    /**
     * 锟斤拷锟斤拷锟洁，锟斤拷要锟斤拷锟节存储注锟斤拷锟斤拷锟斤拷锟铰凤拷锟斤拷url锟斤拷址锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷refer时锟杰癸拷锟斤拷锟斤拷providerURL queryMap overrideMap锟斤拷锟斤拷锟斤拷装
     * 
     * @author chao.liuc
     *
     * @param <T>
     */
    private static class InvokerDelegete<T> extends InvokerWrapper<T>{
        private URL providerUrl;
        public InvokerDelegete(Invoker<T> invoker, URL url, URL providerUrl) {
            super(invoker, url);
            this.providerUrl = providerUrl;
        }
        public URL getProviderUrl() {
            return providerUrl;
        }
    }
}
