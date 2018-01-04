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

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.rpc.Invocation;
import com.alibaba.dubbo.rpc.Invoker;

/**
 * random load balance.
 *
 * @author qianlei
 * @author william.liangf
 */
public class RandomLoadBalance extends AbstractLoadBalance {

    public static final String NAME = "random";

    private final Random random = new Random();

    @Override
    protected <T> Invoker<T> doSelect(List<Invoker<T>> invokers, URL url, Invocation invocation) {
        int length = invokers.size(); // 锟杰革拷锟斤拷
        int totalWeight = 0; // 锟斤拷权锟斤拷
        boolean sameWeight = true; // 权锟斤拷锟角凤拷一锟斤拷
        for (int i = 0; i < length; i++) {
            int weight = getWeight(invokers.get(i), invocation);
            totalWeight += weight; // 锟桔硷拷锟斤拷权锟斤拷
            if (sameWeight && i > 0
                    && weight != getWeight(invokers.get(i - 1), invocation)) {
                sameWeight = false; // 锟斤拷锟斤拷锟斤拷锟斤拷权锟斤拷锟角凤拷一锟斤拷
            }
        }
        if (totalWeight > 0 && ! sameWeight) {
            // 锟斤拷锟饺拷夭锟斤拷锟酵拷锟饺拷卮锟斤拷锟�0锟斤拷锟斤拷权锟斤拷锟斤拷锟斤拷锟�
            int offset = random.nextInt(totalWeight);
            // 锟斤拷确锟斤拷锟斤拷锟街碉拷锟斤拷锟斤拷母锟狡拷锟斤拷锟�
            for (int i = 0; i < length; i++) {
                offset -= getWeight(invokers.get(i), invocation);
                if (offset < 0) {
                    return invokers.get(i);
                }
            }
        }
        // 锟斤拷锟饺拷锟斤拷锟酵拷锟饺拷锟轿�0锟斤拷锟斤拷锟斤拷锟斤拷
        return invokers.get(random.nextInt(length));
    }

}
