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
        int length = invokers.size(); // �ܸ���
        int leastActive = -1; // ��С�Ļ�Ծ��
        int leastCount = 0; // ��ͬ��С��Ծ���ĸ���
        int[] leastIndexs = new int[length]; // ��ͬ��С��Ծ�����±�
        int totalWeight = 0; // ��Ȩ��
        int firstWeight = 0; // ��һ��Ȩ�أ������ڼ����Ƿ���ͬ
        boolean sameWeight = true; // �Ƿ�����Ȩ����ͬ
        for (int i = 0; i < length; i++) {
        	Invoker<T> invoker = invokers.get(i);
            int active = RpcStatus.getStatus(invoker.getUrl(), invocation.getMethodName()).getActive(); // ��Ծ��
            int weight = invoker.getUrl().getMethodParameter(invocation.getMethodName(), Constants.WEIGHT_KEY, Constants.DEFAULT_WEIGHT); // Ȩ��
            if (leastActive == -1 || active < leastActive) { // ���ָ�С�Ļ�Ծ�������¿�ʼ
                leastActive = active; // ��¼��С��Ծ��
                leastCount = 1; // ����ͳ����ͬ��С��Ծ���ĸ���
                leastIndexs[0] = i; // ���¼�¼��С��Ծ���±�
                totalWeight = weight; // �����ۼ���Ȩ��
                firstWeight = weight; // ��¼��һ��Ȩ��
                sameWeight = true; // ��ԭȨ����ͬ��ʶ
            } else if (active == leastActive) { // �ۼ���ͬ��С�Ļ�Ծ��
                leastIndexs[leastCount ++] = i; // �ۼ���ͬ��С��Ծ���±�
                totalWeight += weight; // �ۼ���Ȩ��
                // �ж�����Ȩ���Ƿ�һ��
                if (sameWeight && i > 0 
                        && weight != firstWeight) {
                    sameWeight = false;
                }
            }
        }
        // assert(leastCount > 0)
        if (leastCount == 1) {
            // ���ֻ��һ����С��ֱ�ӷ���
            return invokers.get(leastIndexs[0]);
        }
        if (! sameWeight && totalWeight > 0) {
            // ���Ȩ�ز���ͬ��Ȩ�ش���0����Ȩ�������
            int offsetWeight = random.nextInt(totalWeight);
            // ��ȷ�����ֵ�����ĸ�Ƭ����
            for (int i = 0; i < leastCount; i++) {
                int leastIndex = leastIndexs[i];
                offsetWeight -= getWeight(invokers.get(leastIndex), invocation);
                if (offsetWeight <= 0) {
                    return invokers.get(leastIndex);
                }
            }
        }
        // ���Ȩ����ͬ��Ȩ��Ϊ0��������
        return invokers.get(leastIndexs[random.nextInt(leastCount)]);
    }
}
