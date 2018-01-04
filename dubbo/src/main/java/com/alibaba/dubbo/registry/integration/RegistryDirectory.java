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

    private Protocol protocol; // ע��ʱ��ʼ�������Բ�Ϊnull

    private Registry registry; // ע��ʱ��ʼ�������Բ�Ϊnull

    private final String serviceKey; // ����ʱ��ʼ�������Բ�Ϊnull

    private final Class<T> serviceType; // ����ʱ��ʼ�������Բ�Ϊnull
    
    private final Map<String, String> queryMap; // ����ʱ��ʼ�������Բ�Ϊnull

    private final URL directoryUrl; // ����ʱ��ʼ�������Բ�Ϊnull���������Ǹ���nullֵ
    
    private final String[] serviceMethods;

    private final boolean multiGroup;

    private volatile boolean forbidden = false;
    
    private volatile URL overrideDirectoryUrl; // ����ʱ��ʼ�������Բ�Ϊnull���������Ǹ���nullֵ

    /*override���� 
     * ���ȼ���override>-D>consumer>provider
     * ��һ�ֹ������ĳ��provider <ip:port,timeout=100>
     * �ڶ��ֹ����������provider <* ,timeout=5000>
     */
    private volatile List<Configurator> configurators; // ��ʼΪnull�Լ���;���ܱ���Ϊnull����ʹ�þֲ���������
    
    // Map<url, Invoker> cache service url to invoker mapping.
    private volatile Map<String, Invoker<T>> urlInvokerMap; // ��ʼΪnull�Լ���;���ܱ���Ϊnull����ʹ�þֲ���������
    
    // Map<methodName, Invoker> cache service method to invokers mapping.
    private volatile Map<String, List<Invoker<T>>> methodInvokerMap; // ��ʼΪnull�Լ���;���ܱ���Ϊnull����ʹ�þֲ���������
    
    // Set<invokerUrls> cache invokeUrls to invokers mapping.
    private volatile Set<URL> cachedInvokerUrls; // ��ʼΪnull�Լ���;���ܱ���Ϊnull����ʹ�þֲ���������

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
        super.destroy(); // ������unsubscribe֮��ִ��
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
        // �ϲ�override����
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
     * ����invokerURL�б�ת��Ϊinvoker�б�ת���������£�
     * 1.���url�Ѿ���ת��Ϊinvoker�������������ã�ֱ�Ӵӻ����л�ȡ��ע�����url���κ�һ���������Ҳ����������
     * 2.��������invoker�б�Ϊ�գ����ʾ���µ�invoker�б�
     * 3.��������invokerUrl�б��ǿգ����ʾֻ���·���override�����route������Ҫ���½���Աȣ������Ƿ���Ҫ�������á�
     * @param invokerUrls ����Ĳ�������Ϊnull
     */
    private void refreshInvoker(List<URL> invokerUrls){
        if (invokerUrls != null && invokerUrls.size() == 1 && invokerUrls.get(0) != null
                && Constants.EMPTY_PROTOCOL.equals(invokerUrls.get(0).getProtocol())) {
            this.forbidden = true; // ��ֹ����
            this.methodInvokerMap = null; // �ÿ��б�
            destroyAllInvokers(); // �ر�����Invoker
        } else {
            this.forbidden = false; // �������
            Map<String, Invoker<T>> oldUrlInvokerMap = this.urlInvokerMap; // local reference
            if (invokerUrls.size() == 0 && this.cachedInvokerUrls != null){
                invokerUrls.addAll(this.cachedInvokerUrls);
            } else {
                this.cachedInvokerUrls = new HashSet<URL>();
                this.cachedInvokerUrls.addAll(invokerUrls);//����invokerUrls�б����ڽ���Ա�
            }
            if (invokerUrls.size() ==0 ){
            	return;
            }
            Map<String, Invoker<T>> newUrlInvokerMap = toInvokers(invokerUrls) ;// ��URL�б�ת��Invoker�б�
            Map<String, List<Invoker<T>>> newMethodInvokerMap = toMethodInvokers(newUrlInvokerMap); // ��������ӳ��Invoker�б�
            // state change
            //�����������򲻽��д���.
            if (newUrlInvokerMap == null || newUrlInvokerMap.size() == 0 ){
                logger.error(new IllegalStateException("urls to invokers error .invokerUrls.size :"+invokerUrls.size() + ", invoker.size :0. urls :"+invokerUrls.toString()));
                return ;
            }
            this.methodInvokerMap = multiGroup ? toMergeMethodInvokerMap(newMethodInvokerMap) : newMethodInvokerMap;
            this.urlInvokerMap = newUrlInvokerMap;
            try{
                destroyUnusedInvokers(oldUrlInvokerMap,newUrlInvokerMap); // �ر�δʹ�õ�Invoker
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
     * ��overrideURLת��Ϊmap��������referʱʹ��.
     * ÿ���·�ȫ������ȫ��������װ����
     * @param urls
     * ��Լ��
     * </br>1.override://0.0.0.0/...(��override://ip:port...?anyhost=true)&para1=value1...��ʾȫ�ֹ���(�����е��ṩ��ȫ����Ч)
     * </br>2.override://ip:port...?anyhost=false ��������ֻ���ĳ���ṩ����Ч��
     * </br>3.��֧��override://����... ��Ҫע���������м���.
     * </br>4.����������override://0.0.0.0/ ��ʾ���override 
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
            //override �ϵ�anyhost�������Զ���ӵģ�����Ӱ��ı�url�ж�
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
     * ��urlsת��invokers,���url�Ѿ���refer���������������á�
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
        	//���reference��������protocol����ֻѡ��ƥ���protocol
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
            
            String key = url.toFullString(); // URL�����������
            if (keys.contains(key)) { // �ظ�URL
                continue;
            }
            keys.add(key);
            // ����keyΪû�кϲ����Ѷ˲�����URL���������Ѷ���κϲ���������������URL�����仯��������refer
            Map<String, Invoker<T>> localUrlInvokerMap = this.urlInvokerMap; // local reference
            Invoker<T> invoker = localUrlInvokerMap == null ? null : localUrlInvokerMap.get(key);
            if (invoker == null) { // ������û�У�����refer
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
                if (invoker != null) { // ���µ����÷��뻺��
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
     * �ϲ�url���� ˳��Ϊoverride > -D >Consumer > Provider
     * @param providerUrl
     * @param overrides
     * @return
     */
    private URL mergeUrl(URL providerUrl){
        providerUrl = ClusterUtils.mergeUrl(providerUrl, queryMap); // �ϲ����Ѷ˲���
        
        List<Configurator> localConfigurators = this.configurators; // local reference
        if (localConfigurators != null && localConfigurators.size() > 0) {
            for (Configurator configurator : localConfigurators) {
                providerUrl = configurator.configure(providerUrl);
            }
        }
        
        providerUrl = providerUrl.addParameter(Constants.CHECK_KEY, String.valueOf(false)); // ����������Ƿ�ɹ������Ǵ���Invoker��
        
        //directoryUrl �� override �ϲ�����notify��������ﲻ�ܹ�����
        this.overrideDirectoryUrl = this.overrideDirectoryUrl.addParametersIfAbsent(providerUrl.getParameters()); // �ϲ��ṩ�߲���        
        
        if ((providerUrl.getPath() == null || providerUrl.getPath().length() == 0)
                && "dubbo".equals(providerUrl.getProtocol())) { // ����1.0
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
     * ��invokers�б�ת���뷽����ӳ���ϵ
     * 
     * @param invokersMap Invoker�б�
     * @return Invoker�뷽����ӳ���ϵ
     */
    private Map<String, List<Invoker<T>>> toMethodInvokers(Map<String, Invoker<T>> invokersMap) {
        Map<String, List<Invoker<T>>> newMethodInvokerMap = new HashMap<String, List<Invoker<T>>>();
        // ���ṩ��URL��������methods���࣬����ע������ִ��·�ɹ��˵���methods
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
     * �ر�����Invoker
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
     * ��黺���е�invoker�Ƿ���Ҫ��destroy
     * ���url��ָ��refer.autodestroy=false����ֻ���Ӳ����٣����ܻ���referй©��
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
                invokers = localMethodInvokerMap.get(methodName + "." + args[0]); // �ɸ��ݵ�һ������ö��·��
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
     * �����࣬��Ҫ���ڴ洢ע�������·���url��ַ��������������referʱ�ܹ�����providerURL queryMap overrideMap������װ
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
