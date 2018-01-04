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
package com.alibaba.dubbo.rpc.cluster.support.wrapper;

import java.util.List;

import com.alibaba.dubbo.common.Constants;
import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.logger.Logger;
import com.alibaba.dubbo.common.logger.LoggerFactory;
import com.alibaba.dubbo.common.utils.StringUtils;
import com.alibaba.dubbo.rpc.Invocation;
import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.Result;
import com.alibaba.dubbo.rpc.RpcException;
import com.alibaba.dubbo.rpc.RpcInvocation;
import com.alibaba.dubbo.rpc.RpcResult;
import com.alibaba.dubbo.rpc.cluster.Directory;
import com.alibaba.dubbo.rpc.support.MockInvoker;

/**
 * @author chao.liuc
 */
public class MockClusterInvoker<T> implements Invoker<T>{
	
	private static final Logger logger = LoggerFactory.getLogger(MockClusterInvoker.class);

	private final Directory<T> directory ;
	
	private final Invoker<T> invoker;

    public MockClusterInvoker(Directory<T> directory, Invoker<T> invoker) {
       	this.directory = directory;
       	this.invoker = invoker;
    }

	@Override
    public URL getUrl() {
		return directory.getUrl();
	}

	@Override
    public boolean isAvailable() {
		return directory.isAvailable();
	}

	@Override
    public void destroy() {
		this.invoker.destroy();
	}

	@Override
    public Class<T> getInterface() {
		return directory.getInterface();
	}

	@Override
    public Result invoke(Invocation invocation) throws RpcException {
		Result result = null;
        
        String value = directory.getUrl().getMethodParameter(invocation.getMethodName(), Constants.MOCK_KEY, Boolean.FALSE.toString()).trim(); 
        if (value.length() == 0 || "false".equalsIgnoreCase(value)){
        	//no mock
        	result = this.invoker.invoke(invocation);
        } else if (value.startsWith("force")) {
        	if (logger.isWarnEnabled()) {
        		logger.info("force-mock: " + invocation.getMethodName() + " force-mock enabled , url : " +  directory.getUrl());
        	}
        	//force:direct mock
        	result = doMockInvoke(invocation, null);
        } else {
        	//fail-mock
        	try {
        		result = this.invoker.invoke(invocation);
        	}catch (RpcException e) {
				if (e.isBiz()) {
					throw e;
				} else {
					if (logger.isWarnEnabled()) {
		        		logger.info("fail-mock: " + invocation.getMethodName() + " fail-mock enabled , url : " +  directory.getUrl(), e);
		        	}
					result = doMockInvoke(invocation, e);
				}
			}
        }
        return result;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private Result doMockInvoke(Invocation invocation,RpcException e){
		Result result = null;
    	Invoker<T> minvoker ;
    	
    	List<Invoker<T>> mockInvokers = selectMockInvoker(invocation);
		if (mockInvokers == null || mockInvokers.size() == 0){
			minvoker = (Invoker<T>) new MockInvoker(directory.getUrl());
		} else {
			minvoker = mockInvokers.get(0);
		}
		try {
			result = minvoker.invoke(invocation);
		} catch (RpcException me) {
			if (me.isBiz()) {
				result = new RpcResult(me.getCause());
			} else {
				throw new RpcException(me.getCode(), getMockExceptionMessage(e, me), me.getCause());
			}
//			
		} catch (Throwable me) {
			throw new RpcException(getMockExceptionMessage(e, me), me.getCause());
		}
		return result;
    }
	
	private String getMockExceptionMessage(Throwable t, Throwable mt){
		String msg = "mock error : " + mt.getMessage();
		if (t != null){
			msg = msg + ", invoke error is :" + StringUtils.toString(t);
		}
		return msg;
	}

	/**
     * ����MockInvoker
     * ��Լ��
     * directory����invocation���Ƿ���Constants.INVOCATION_NEED_MOCK�����жϻ�ȡ����һ��normal invoker ����һ�� mock invoker
     * ���directorylist ���ض��mock invoker��ֻʹ�õ�һ��invoker.
     * @param invocation
     * @return 
     */
    private List<Invoker<T>> selectMockInvoker(Invocation invocation){
    	//TODO generic invoker��
        if (invocation instanceof RpcInvocation){
            //����������Լ(��Ȼ�ڽӿ���������������������չ�Ի��������.ͬʱ����attachement�е�������Ҫ�Ľ�
        	((RpcInvocation)invocation).setAttachment(Constants.INVOCATION_NEED_MOCK, Boolean.TRUE.toString());
            //directory����invocation��attachment�Ƿ���Constants.INVOCATION_NEED_MOCK�����жϻ�ȡ����normal invokers or mock invokers
        	List<Invoker<T>> invokers = directory.list(invocation);
            return invokers;
        } else {
            return null ;
        }
    }

	@Override
	public String toString() {
		return "invoker :" + this.invoker + ",directory: " + this.directory;
	}
}
