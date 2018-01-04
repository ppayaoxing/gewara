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
 * 失锟斤拷锟皆讹拷锟街革拷锟斤拷锟斤拷台锟斤拷录失锟斤拷锟斤拷锟襟，讹拷时锟截凤拷锟斤拷通锟斤拷锟斤拷锟斤拷锟斤拷息通知锟斤拷锟斤拷锟斤拷
 * 
 * <a href="http://en.wikipedia.org/wiki/Failback">Failback</a>
 * 
 * @author william.liangf
 */
public class FailbackCluster implements Cluster {

    public final static String NAME = "failback";    

    @Override
    public <T> Invoker<T> join(Directory<T> directory) throws RpcException {
        return new FailbackClusterInvoker<T>(directory);
    }

}
