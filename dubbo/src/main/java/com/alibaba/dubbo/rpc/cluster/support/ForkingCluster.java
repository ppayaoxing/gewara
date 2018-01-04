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
 * 锟斤拷锟叫碉拷锟矫ｏ拷只要一锟斤拷锟缴癸拷锟斤拷锟斤拷锟截ｏ拷通锟斤拷锟斤拷锟斤拷实时锟斤拷要锟斤拷细叩牟锟斤拷锟斤拷锟斤拷锟斤拷锟揭拷朔迅锟斤拷锟斤拷锟斤拷锟斤拷源锟斤拷
 * 
 * <a href="http://en.wikipedia.org/wiki/Fork_(topology)">Fork</a>
 * 
 * @author william.liangf
 */
public class ForkingCluster implements Cluster {
    
    public final static String NAME = "forking"; 
    
    @Override
    public <T> Invoker<T> join(Directory<T> directory) throws RpcException {
        return new ForkingClusterInvoker<T>(directory);
    }

}
