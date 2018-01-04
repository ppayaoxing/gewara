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
        int length = invokers.size(); // �ܸ���
        int totalWeight = 0; // ��Ȩ��
        boolean sameWeight = true; // Ȩ���Ƿ�һ��
        for (int i = 0; i < length; i++) {
            int weight = getWeight(invokers.get(i), invocation);
            totalWeight += weight; // �ۼ���Ȩ��
            if (sameWeight && i > 0
                    && weight != getWeight(invokers.get(i - 1), invocation)) {
                sameWeight = false; // ��������Ȩ���Ƿ�һ��
            }
        }
        if (totalWeight > 0 && ! sameWeight) {
            // ���Ȩ�ز���ͬ��Ȩ�ش���0����Ȩ�������
            int offset = random.nextInt(totalWeight);
            // ��ȷ�����ֵ�����ĸ�Ƭ����
            for (int i = 0; i < length; i++) {
                offset -= getWeight(invokers.get(i), invocation);
                if (offset < 0) {
                    return invokers.get(i);
                }
            }
        }
        // ���Ȩ����ͬ��Ȩ��Ϊ0��������
        return invokers.get(random.nextInt(length));
    }

}
