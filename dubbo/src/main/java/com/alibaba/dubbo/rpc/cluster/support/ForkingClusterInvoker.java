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
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import com.alibaba.dubbo.common.Constants;
import com.alibaba.dubbo.common.utils.NamedThreadFactory;
import com.alibaba.dubbo.rpc.Invocation;
import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.Result;
import com.alibaba.dubbo.rpc.RpcContext;
import com.alibaba.dubbo.rpc.RpcException;
import com.alibaba.dubbo.rpc.cluster.Directory;
import com.alibaba.dubbo.rpc.cluster.LoadBalance;

/**
 * 锟斤拷锟叫碉拷锟矫ｏ拷只要一锟斤拷锟缴癸拷锟斤拷锟斤拷锟截ｏ拷通锟斤拷锟斤拷锟斤拷实时锟斤拷要锟斤拷细叩牟锟斤拷锟斤拷锟斤拷锟斤拷锟揭拷朔迅锟斤拷锟斤拷锟斤拷锟斤拷源锟斤拷
 * 
 * <a href="http://en.wikipedia.org/wiki/Fork_(topology)">Fork</a>
 * 
 * @author william.liangf
 */
public class ForkingClusterInvoker<T> extends AbstractClusterInvoker<T>{

    private final ExecutorService executor = Executors.newCachedThreadPool(new NamedThreadFactory("forking-cluster-timer", true)); 

    public ForkingClusterInvoker(Directory<T> directory) {
        super(directory);
    }

    @Override
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public Result doInvoke(final Invocation invocation, List<Invoker<T>> invokers, LoadBalance loadbalance) throws RpcException {
        checkInvokers(invokers, invocation);
        final List<Invoker<T>> selected;
        final int forks = getUrl().getParameter(Constants.FORKS_KEY, Constants.DEFAULT_FORKS);
        final int timeout = getUrl().getParameter(Constants.TIMEOUT_KEY, Constants.DEFAULT_TIMEOUT);
        if (forks <= 0 || forks >= invokers.size()) {
            selected = invokers;
        } else {
            selected = new ArrayList<Invoker<T>>();
            for (int i = 0; i < forks; i++) {
                //锟斤拷invoker锟叫憋拷(锟脚筹拷selected)锟斤拷,锟斤拷锟矫伙拷锟窖★拷锟�,锟斤拷锟斤拷锟斤拷馗锟窖拷锟斤拷锟斤拷锟�.锟斤拷select实锟斤拷.
                Invoker<T> invoker = select(loadbalance, invocation, invokers, selected);
                if(!selected.contains(invoker)){//锟斤拷止锟截革拷锟斤拷锟絠nvoker
                    selected.add(invoker);
                }
            }
        }
        RpcContext.getContext().setInvokers((List)selected);
        final AtomicInteger count = new AtomicInteger();
        final BlockingQueue<Object> ref = new LinkedBlockingQueue<Object>();
        for (final Invoker<T> invoker : selected) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        Result result = invoker.invoke(invocation);
                        ref.offer(result);
                    } catch(Throwable e) {
                        int value = count.incrementAndGet();
                        if (value >= selected.size()) {
                            ref.offer(e);
                        }
                    }
                }
            });
        }
        try {
            Object ret = ref.poll(timeout, TimeUnit.MILLISECONDS);
            if (ret instanceof Throwable) {
                Throwable e = (Throwable) ret;
                throw new RpcException(e instanceof RpcException ? ((RpcException)e).getCode() : 0, "Failed to forking invoke provider " + selected + ", but no luck to perform the invocation. Last error is: " + e.getMessage(), e.getCause() != null ? e.getCause() : e);
            }
            return (Result) ret;
        } catch (InterruptedException e) {
            throw new RpcException("Failed to forking invoke provider " + selected + ", but no luck to perform the invocation. Last error is: " + e.getMessage(), e);
        }
    }
}
