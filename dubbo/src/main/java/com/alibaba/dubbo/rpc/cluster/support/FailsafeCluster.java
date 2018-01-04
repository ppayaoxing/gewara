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

import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.RpcException;
import com.alibaba.dubbo.rpc.cluster.Cluster;
import com.alibaba.dubbo.rpc.cluster.Directory;

/**
 * ʧ�ܰ�ȫ�������쳣ʱ��ֱ�Ӻ��ԣ�ͨ������д�������־�Ȳ����� 
 * 
 * <a href="http://en.wikipedia.org/wiki/Fail-safe">Fail-safe</a>
 * 
 * @author william.liangf
 */
public class FailsafeCluster implements Cluster {

    public final static String NAME = "failsafe";

    @Override
    public <T> Invoker<T> join(Directory<T> directory) throws RpcException {
        return new FailsafeClusterInvoker<T>(directory);
    }

}
