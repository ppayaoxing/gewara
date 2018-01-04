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
package com.alibaba.dubbo.monitor.support;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

import com.alibaba.dubbo.common.Constants;
import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.Activate;
import com.alibaba.dubbo.common.logger.Logger;
import com.alibaba.dubbo.common.logger.LoggerFactory;
import com.alibaba.dubbo.common.utils.NetUtils;
import com.alibaba.dubbo.monitor.Monitor;
import com.alibaba.dubbo.monitor.MonitorFactory;
import com.alibaba.dubbo.monitor.MonitorService;
import com.alibaba.dubbo.rpc.Filter;
import com.alibaba.dubbo.rpc.Invocation;
import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.Result;
import com.alibaba.dubbo.rpc.RpcContext;
import com.alibaba.dubbo.rpc.RpcException;
import com.alibaba.dubbo.rpc.support.RpcUtils;
 
/**
 * MonitorFilter. (SPI, Singleton, ThreadSafe)
 * 
 * @author william.liangf
 */
@Activate(group = {Constants.PROVIDER, Constants.CONSUMER})
public class MonitorFilter implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(MonitorFilter.class);
    
    private final ConcurrentMap<String, AtomicInteger> concurrents = new ConcurrentHashMap<String, AtomicInteger>();
    
    private MonitorFactory monitorFactory;
    
    public void setMonitorFactory(MonitorFactory monitorFactory) {
        this.monitorFactory = monitorFactory;
    }
    
    // 锟斤拷锟矫癸拷锟斤拷锟斤拷锟斤拷
    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        if (invoker.getUrl().hasParameter(Constants.MONITOR_KEY)) {
            RpcContext context = RpcContext.getContext(); // 锟结供锟斤拷锟斤拷锟斤拷锟斤拷invoke()之前锟斤拷取context锟斤拷息
            long start = System.currentTimeMillis(); // 锟斤拷录锟斤拷始时锟斤拷戮
            getConcurrent(invoker, invocation).incrementAndGet(); // 锟斤拷锟斤拷锟斤拷锟斤拷
            try {
                Result result = invoker.invoke(invocation); // 锟矫碉拷锟斤拷锟斤拷锟斤拷锟斤拷执锟斤拷
                collect(invoker, invocation, result, context, start, false);
                return result;
            } catch (RpcException e) {
                collect(invoker, invocation, null, context, start, true);
                throw e;
            } finally {
                getConcurrent(invoker, invocation).decrementAndGet(); // 锟斤拷锟斤拷锟斤拷锟斤拷
            }
        } else {
            return invoker.invoke(invocation);
        }
    }
    
    // 锟斤拷息锟缴硷拷
    private void collect(Invoker<?> invoker, Invocation invocation, Result result, RpcContext context, long start, boolean error) {
        try {
            // ---- 锟斤拷锟斤拷锟斤拷息锟斤拷取 ----
            long elapsed = System.currentTimeMillis() - start; // 锟斤拷锟斤拷锟斤拷煤锟绞�
            int concurrent = getConcurrent(invoker, invocation).get(); // 锟斤拷前锟斤拷锟斤拷锟斤拷
            String application = invoker.getUrl().getParameter(Constants.APPLICATION_KEY);
            String service = invoker.getInterface().getName(); // 锟斤拷取锟斤拷锟斤拷锟斤拷锟斤拷
            String method = RpcUtils.getMethodName(invocation); // 锟斤拷取锟斤拷锟斤拷锟斤拷
            URL url = invoker.getUrl().getUrlParameter(Constants.MONITOR_KEY);
            Monitor monitor = monitorFactory.getMonitor(url);
            int localPort;
            String remoteKey;
            String remoteValue;
            if (Constants.CONSUMER_SIDE.equals(invoker.getUrl().getParameter(Constants.SIDE_KEY))) {
                // ---- 锟斤拷锟斤拷锟斤拷锟窖凤拷锟斤拷锟� ----
                context = RpcContext.getContext(); // 锟斤拷锟窖凤拷锟斤拷锟斤拷锟斤拷invoke()之锟斤拷锟饺ontext锟斤拷息
                localPort = 0;
                remoteKey = MonitorService.PROVIDER;
                remoteValue = invoker.getUrl().getAddress();
            } else {
                // ---- 锟斤拷锟斤拷锟结供锟斤拷锟斤拷锟� ----
                localPort = invoker.getUrl().getPort();
                remoteKey = MonitorService.CONSUMER;
                remoteValue = context.getRemoteHost();
            }
            String input = "", output = "";
            if (invocation.getAttachment(Constants.INPUT_KEY) != null) {
                input = invocation.getAttachment(Constants.INPUT_KEY);
            }
            if (result != null && result.getAttachment(Constants.OUTPUT_KEY) != null) {
                output = result.getAttachment(Constants.OUTPUT_KEY);
            }
            monitor.collect(new URL(Constants.COUNT_PROTOCOL,
                                NetUtils.getLocalHost(), localPort,
                                service + "/" + method,
                                MonitorService.APPLICATION, application,
                                MonitorService.INTERFACE, service,
                                MonitorService.METHOD, method,
                                remoteKey, remoteValue,
                                error ? MonitorService.FAILURE : MonitorService.SUCCESS, "1",
                                MonitorService.ELAPSED, String.valueOf(elapsed),
                                MonitorService.CONCURRENT, String.valueOf(concurrent),
                                Constants.INPUT_KEY, input,
                                Constants.OUTPUT_KEY, output));
        } catch (Throwable t) {
            logger.error("Failed to monitor count service " + invoker.getUrl() + ", cause: " + t.getMessage(), t);
        }
    }
    
    // 锟斤拷取锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷
    private AtomicInteger getConcurrent(Invoker<?> invoker, Invocation invocation) {
        String key = invoker.getInterface().getName() + "." + invocation.getMethodName();
        AtomicInteger concurrent = concurrents.get(key);
        if (concurrent == null) {
            concurrents.putIfAbsent(key, new AtomicInteger());
            concurrent = concurrents.get(key);
        }
        return concurrent;
    }

}
