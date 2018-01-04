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
package com.alibaba.dubbo.rpc.cluster.loadbalance;

import java.util.List;
import java.util.Random;

import com.alibaba.dubbo.common.Constants;
import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.rpc.Invocation;
import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.RpcStatus;

/**
 * LeastActiveLoadBalance
 * 
 * @author william.liangf
 */
public class LeastActiveLoadBalance extends AbstractLoadBalance {

    public static final String NAME = "leastactive";
    
    private final Random random = new Random();

    @Override
    protected <T> Invoker<T> doSelect(List<Invoker<T>> invokers, URL url, Invocation invocation) {
        int length = invokers.size(); // 锟杰革拷锟斤拷
        int leastActive = -1; // 锟斤拷小锟侥伙拷跃锟斤拷
        int leastCount = 0; // 锟斤拷同锟斤拷小锟斤拷跃锟斤拷锟侥革拷锟斤拷
        int[] leastIndexs = new int[length]; // 锟斤拷同锟斤拷小锟斤拷跃锟斤拷锟斤拷锟铰憋拷
        int totalWeight = 0; // 锟斤拷权锟斤拷
        int firstWeight = 0; // 锟斤拷一锟斤拷权锟截ｏ拷锟斤拷锟斤拷锟节硷拷锟斤拷锟角凤拷锟斤拷同
        boolean sameWeight = true; // 锟角凤拷锟斤拷锟斤拷权锟斤拷锟斤拷同
        for (int i = 0; i < length; i++) {
        	Invoker<T> invoker = invokers.get(i);
            int active = RpcStatus.getStatus(invoker.getUrl(), invocation.getMethodName()).getActive(); // 锟斤拷跃锟斤拷
            int weight = invoker.getUrl().getMethodParameter(invocation.getMethodName(), Constants.WEIGHT_KEY, Constants.DEFAULT_WEIGHT); // 权锟斤拷
            if (leastActive == -1 || active < leastActive) { // 锟斤拷锟街革拷小锟侥伙拷跃锟斤拷锟斤拷锟斤拷锟铰匡拷始
                leastActive = active; // 锟斤拷录锟斤拷小锟斤拷跃锟斤拷
                leastCount = 1; // 锟斤拷锟斤拷统锟斤拷锟斤拷同锟斤拷小锟斤拷跃锟斤拷锟侥革拷锟斤拷
                leastIndexs[0] = i; // 锟斤拷锟铰硷拷录锟斤拷小锟斤拷跃锟斤拷锟铰憋拷
                totalWeight = weight; // 锟斤拷锟斤拷锟桔硷拷锟斤拷权锟斤拷
                firstWeight = weight; // 锟斤拷录锟斤拷一锟斤拷权锟斤拷
                sameWeight = true; // 锟斤拷原权锟斤拷锟斤拷同锟斤拷识
            } else if (active == leastActive) { // 锟桔硷拷锟斤拷同锟斤拷小锟侥伙拷跃锟斤拷
                leastIndexs[leastCount ++] = i; // 锟桔硷拷锟斤拷同锟斤拷小锟斤拷跃锟斤拷锟铰憋拷
                totalWeight += weight; // 锟桔硷拷锟斤拷权锟斤拷
                // 锟叫讹拷锟斤拷锟斤拷权锟斤拷锟角凤拷一锟斤拷
                if (sameWeight && i > 0 
                        && weight != firstWeight) {
                    sameWeight = false;
                }
            }
        }
        // assert(leastCount > 0)
        if (leastCount == 1) {
            // 锟斤拷锟街伙拷锟揭伙拷锟斤拷锟叫★拷锟街憋拷臃锟斤拷锟�
            return invokers.get(leastIndexs[0]);
        }
        if (! sameWeight && totalWeight > 0) {
            // 锟斤拷锟饺拷夭锟斤拷锟酵拷锟饺拷卮锟斤拷锟�0锟斤拷锟斤拷权锟斤拷锟斤拷锟斤拷锟�
            int offsetWeight = random.nextInt(totalWeight);
            // 锟斤拷确锟斤拷锟斤拷锟街碉拷锟斤拷锟斤拷母锟狡拷锟斤拷锟�
            for (int i = 0; i < leastCount; i++) {
                int leastIndex = leastIndexs[i];
                offsetWeight -= getWeight(invokers.get(leastIndex), invocation);
                if (offsetWeight <= 0) {
                    return invokers.get(leastIndex);
                }
            }
        }
        // 锟斤拷锟饺拷锟斤拷锟酵拷锟饺拷锟轿�0锟斤拷锟斤拷锟斤拷锟斤拷
        return invokers.get(leastIndexs[random.nextInt(leastCount)]);
    }
}
