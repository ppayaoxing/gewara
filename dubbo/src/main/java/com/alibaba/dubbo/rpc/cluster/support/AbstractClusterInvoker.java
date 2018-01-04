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
package com.alibaba.dubbo.rpc.cluster.support;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.dubbo.common.Constants;
import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.Version;
import com.alibaba.dubbo.common.extension.ExtensionLoader;
import com.alibaba.dubbo.common.logger.Logger;
import com.alibaba.dubbo.common.logger.LoggerFactory;
import com.alibaba.dubbo.common.utils.NetUtils;
import com.alibaba.dubbo.rpc.Invocation;
import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.ProviderException;
import com.alibaba.dubbo.rpc.Result;
import com.alibaba.dubbo.rpc.RpcException;
import com.alibaba.dubbo.rpc.cluster.Directory;
import com.alibaba.dubbo.rpc.cluster.LoadBalance;
import com.alibaba.dubbo.rpc.support.RpcUtils;

/**
 * AbstractClusterInvoker
 * 
 * @author william.liangf
 * @author chao.liuc
 */
public abstract class AbstractClusterInvoker<T> implements Invoker<T> {

    private static final Logger                logger                            = LoggerFactory
                                                                                         .getLogger(AbstractClusterInvoker.class);
    protected final Directory<T>               directory;

    protected final boolean                    availablecheck;
    
    private volatile boolean                   destroyed = false;

    private volatile Invoker<T>                stickyInvoker                     = null;

    public AbstractClusterInvoker(Directory<T> directory) {
        this(directory, directory.getUrl());
    }
    
    public AbstractClusterInvoker(Directory<T> directory, URL url) {
        if (directory == null) {
            throw new IllegalArgumentException("service directory == null");
        }
        
        this.directory = directory ;
        //sticky 锟斤拷要锟斤拷锟� avaliablecheck 
        this.availablecheck = url.getParameter(Constants.CLUSTER_AVAILABLE_CHECK_KEY, Constants.DEFAULT_CLUSTER_AVAILABLE_CHECK) ;
    }

    @Override
    public Class<T> getInterface() {
        return directory.getInterface();
    }

    @Override
    public URL getUrl() {
        return directory.getUrl();
    }

    @Override
    public boolean isAvailable() {
        Invoker<T> invoker = stickyInvoker;
        if (invoker != null) {
            return invoker.isAvailable();
        }
        return directory.isAvailable();
    }

    @Override
    public void destroy() {
        directory.destroy();
        destroyed = true;
    }

    /**
     * 使锟斤拷loadbalance选锟斤拷invoker.</br>
     * a)锟斤拷lb选锟斤拷锟斤拷锟斤拷锟絪elected锟叫憋拷锟斤拷 锟斤拷锟斤拷 锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷时锟斤拷锟斤拷锟斤拷锟斤拷一锟斤拷(锟斤拷选),锟斤拷锟斤拷直锟接凤拷锟斤拷</br>
     * b)锟斤拷选锟斤拷证锟斤拷锟斤拷selected > available .锟斤拷证锟斤拷选锟斤拷锟侥斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟絪elect锟叫ｏ拷锟斤拷锟斤拷锟角匡拷锟矫碉拷 
     * 
     * @param availablecheck 锟斤拷锟斤拷锟斤拷锟絫rue锟斤拷锟斤拷选锟斤拷锟绞憋拷锟斤拷锟窖nvoker.available == true
     * @param selected 锟斤拷选锟斤拷锟斤拷invoker.注锟解：锟斤拷锟诫保证锟斤拷锟截革拷
     * 
     */
    protected Invoker<T> select(LoadBalance loadbalance, Invocation invocation, List<Invoker<T>> invokers, List<Invoker<T>> selected) throws RpcException {
        if (invokers == null || invokers.size() == 0) {
            return null;
        }
        String methodName = invocation == null ? "" : invocation.getMethodName();
        
        boolean sticky = invokers.get(0).getUrl().getMethodParameter(methodName,Constants.CLUSTER_STICKY_KEY, Constants.DEFAULT_CLUSTER_STICKY) ;
        {
            //ignore overloaded method
            if ( stickyInvoker != null && !invokers.contains(stickyInvoker) ){
                stickyInvoker = null;
            }
            //ignore cucurrent problem
            if (sticky && stickyInvoker != null && (selected == null || !selected.contains(stickyInvoker))){
                if (availablecheck && stickyInvoker.isAvailable()){
                    return stickyInvoker;
                }
            }
        }
        Invoker<T> invoker = doselect(loadbalance, invocation, invokers, selected);
        
        if (sticky){
            stickyInvoker = invoker;
        }
        return invoker;
    }
    
    private Invoker<T> doselect(LoadBalance loadbalance, Invocation invocation, List<Invoker<T>> invokers, List<Invoker<T>> selected) throws RpcException {
        if (invokers == null || invokers.size() == 0) {
            return null;
        }
        if (invokers.size() == 1) {
            return invokers.get(0);
        }
        // 锟斤拷锟街伙拷锟斤拷锟斤拷锟絠nvoker锟斤拷锟剿伙拷锟斤拷锟斤拷循
        if (invokers.size() == 2 && selected != null && selected.size() > 0) {
            return selected.get(0) == invokers.get(0) ? invokers.get(1) : invokers.get(0);
        }
        Invoker<T> invoker = loadbalance.select(invokers, getUrl(), invocation);
        
        //锟斤拷锟� selected锟叫帮拷锟斤拷锟斤拷锟斤拷锟斤拷锟叫断ｏ拷 锟斤拷锟斤拷 锟斤拷锟斤拷锟斤拷&&availablecheck=true 锟斤拷锟斤拷锟斤拷.
        if( (selected != null && selected.contains(invoker))
                ||(!invoker.isAvailable() && getUrl()!=null && availablecheck)){
            try{
                Invoker<T> rinvoker = reselect(loadbalance, invocation, invokers, selected, availablecheck);
                if(rinvoker != null){
                    invoker =  rinvoker;
                }else{
                    //锟斤拷锟铰碉拷一锟斤拷选锟斤拷位锟矫ｏ拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷选+1位锟斤拷.
                    int index = invokers.indexOf(invoker);
                    try{
                        //锟斤拷锟斤拷诒锟斤拷锟斤拷锟阶�
                        invoker = index <invokers.size()-1?invokers.get(index+1) :invoker;
                    }catch (Exception e) {
                        logger.warn(e.getMessage()+" may because invokers list dynamic change, ignore.",e);
                    }
                }
            }catch (Throwable t){
                logger.error("clustor relselect fail reason is :"+t.getMessage() +" if can not slove ,you can set cluster.availablecheck=false in url",t);
            }
        }
        return invoker;
    } 
    
    /**
     * 锟斤拷选锟斤拷锟饺从凤拷selected锟斤拷锟叫憋拷锟斤拷选锟斤拷没锟斤拷锟节达拷selected锟叫憋拷锟斤拷选锟斤拷.
     * @param loadbalance
     * @param invocation
     * @param invokers
     * @param selected
     * @return
     * @throws RpcException
     */
    private Invoker<T> reselect(LoadBalance loadbalance,Invocation invocation,
                                List<Invoker<T>> invokers, List<Invoker<T>> selected ,boolean availablecheck)
            throws RpcException {
        
        //预锟饺凤拷锟斤拷一锟斤拷锟斤拷锟斤拷锟斤拷斜锟斤拷锟揭伙拷锟斤拷锟斤拷玫锟斤拷锟�.
        List<Invoker<T>> reselectInvokers = new ArrayList<Invoker<T>>(invokers.size()>1?(invokers.size()-1):invokers.size());
        
        //锟饺从凤拷select锟斤拷选
        if( availablecheck ){ //选isAvailable 锟侥凤拷select
            for(Invoker<T> invoker : invokers){
                if(invoker.isAvailable()){
                    if(selected ==null || !selected.contains(invoker)){
                        reselectInvokers.add(invoker);
                    }
                }
            }
            if(reselectInvokers.size()>0){
                return  loadbalance.select(reselectInvokers, getUrl(), invocation);
            }
        }else{ //选全锟斤拷锟斤拷select
            for(Invoker<T> invoker : invokers){
                if(selected ==null || !selected.contains(invoker)){
                    reselectInvokers.add(invoker);
                }
            }
            if(reselectInvokers.size()>0){
                return  loadbalance.select(reselectInvokers, getUrl(), invocation);
            }
        }
        //锟斤拷锟斤拷select锟斤拷选锟斤拷锟矫碉拷. 
        {
            if(selected != null){
                for(Invoker<T> invoker : selected){
                    if((invoker.isAvailable()) //锟斤拷锟斤拷选available 
                            && !reselectInvokers.contains(invoker)){
                        reselectInvokers.add(invoker);
                    }
                }
            }
            if(reselectInvokers.size()>0){
                return  loadbalance.select(reselectInvokers, getUrl(), invocation);
            }
        }
        return null;
    }
    
    @Override
    public Result invoke(final Invocation invocation) throws RpcException {

        checkWheatherDestoried();

        LoadBalance loadbalance;
        
        List<Invoker<T>> invokers = list(invocation);
        if (invokers != null && invokers.size() > 0) {
            loadbalance = ExtensionLoader.getExtensionLoader(LoadBalance.class).getExtension(invokers.get(0).getUrl()
                    .getMethodParameter(invocation.getMethodName(),Constants.LOADBALANCE_KEY, Constants.DEFAULT_LOADBALANCE));
        } else {
            loadbalance = ExtensionLoader.getExtensionLoader(LoadBalance.class).getExtension(Constants.DEFAULT_LOADBALANCE);
        }
        RpcUtils.attachInvocationIdIfAsync(getUrl(), invocation);
        return doInvoke(invocation, invokers, loadbalance);
    }

    protected void checkWheatherDestoried() {

        if(destroyed){
            throw new RpcException("Rpc cluster invoker for " + getInterface() + " on consumer " + NetUtils.getLocalHost()
                    + " use dubbo version " + Version.getVersion()
                    + " is now destroyed! Can not invoke any more.");
        }
    }

    @Override
    public String toString() {
        return getInterface() + " -> " + getUrl().toString();
    }
    
    protected void checkInvokers(List<Invoker<T>> invokers, Invocation invocation) {
        if (invokers == null || invokers.size() == 0) {
            throw new ProviderException("Failed to invoke the method "
                    + invocation.getMethodName() + " in the service " + getInterface().getName() 
                    + ". No provider available for the service " + directory.getUrl().getServiceKey()
                    + " from registry " + directory.getUrl().getAddress() 
                    + " on the consumer " + NetUtils.getLocalHost()
                    + " using the dubbo version " + Version.getVersion()
                    + ". Please check if the providers have been started and registered.");
        }
    }

    protected abstract Result doInvoke(Invocation invocation, List<Invoker<T>> invokers,
                                       LoadBalance loadbalance) throws RpcException;
    
    protected  List<Invoker<T>> list(Invocation invocation) throws RpcException {
    	List<Invoker<T>> invokers = directory.list(invocation);
    	return invokers;
    }
}
