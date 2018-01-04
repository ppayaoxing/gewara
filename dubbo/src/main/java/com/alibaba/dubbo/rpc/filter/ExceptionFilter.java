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
package com.alibaba.dubbo.rpc.filter;

import java.lang.reflect.Method;

import com.alibaba.dubbo.common.Constants;
import com.alibaba.dubbo.common.extension.Activate;
import com.alibaba.dubbo.common.logger.Logger;
import com.alibaba.dubbo.common.logger.LoggerFactory;
import com.alibaba.dubbo.common.utils.ReflectUtils;
import com.alibaba.dubbo.common.utils.StringUtils;
import com.alibaba.dubbo.rpc.Filter;
import com.alibaba.dubbo.rpc.Invocation;
import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.Result;
import com.alibaba.dubbo.rpc.RpcContext;
import com.alibaba.dubbo.rpc.RpcException;
import com.alibaba.dubbo.rpc.RpcResult;
import com.alibaba.dubbo.rpc.service.GenericService;

/**
 * ExceptionInvokerFilter
 * <p>
 * ���ܣ�
 * <ol>
 * <li>���������쳣��ERROR��־��Provider�ˣ�<br>
 *     ����������־���ǣ�û�еĽӿ���������Unchecked�쳣��
 * <li>�쳣����API���У���Wrapһ��RuntimeException��<br>
 *     RPC���ڵ�һ���쳣��ֱ�����л�����(Cause�쳣��String��)�������쳣��Client�����ܷ����л����⡣
 * </ol>
 * 
 * @author william.liangf
 * @author ding.lid
 */
@Activate(group = Constants.PROVIDER)
public class ExceptionFilter implements Filter {

    private final Logger logger;
    
    public ExceptionFilter() {
        this(LoggerFactory.getLogger(ExceptionFilter.class));
    }
    
    public ExceptionFilter(Logger logger) {
        this.logger = logger;
    }
    
    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        try {
            Result result = invoker.invoke(invocation);
            if (result.hasException() && GenericService.class != invoker.getInterface()) {
                try {
                    Throwable exception = result.getException();

                    // �����checked�쳣��ֱ���׳�
                    if (! (exception instanceof RuntimeException) && (exception instanceof Exception)) {
                        return result;
                    }
                    // �ڷ���ǩ������������ֱ���׳�
                    try {
                        Method method = invoker.getInterface().getMethod(invocation.getMethodName(), invocation.getParameterTypes());
                        Class<?>[] exceptionClassses = method.getExceptionTypes();
                        for (Class<?> exceptionClass : exceptionClassses) {
                            if (exception.getClass().equals(exceptionClass)) {
                                return result;
                            }
                        }
                    } catch (NoSuchMethodException e) {
                        return result;
                    }

                    // δ�ڷ���ǩ���϶�����쳣���ڷ������˴�ӡERROR��־
                    logger.error("Got unchecked and undeclared exception which called by " + RpcContext.getContext().getRemoteHost()
                            + ". service: " + invoker.getInterface().getName() + ", method: " + invocation.getMethodName()
                            + ", exception: " + exception.getClass().getName() + ": " + exception.getMessage(), exception);

                    // �쳣��ͽӿ�����ͬһjar���ֱ���׳�
                    String serviceFile = ReflectUtils.getCodeBase(invoker.getInterface());
                    String exceptionFile = ReflectUtils.getCodeBase(exception.getClass());
                    if (serviceFile == null || exceptionFile == null || serviceFile.equals(exceptionFile)){
                        return result;
                    }
                    // ��JDK�Դ����쳣��ֱ���׳�
                    String className = exception.getClass().getName();
                    if (className.startsWith("java.") || className.startsWith("javax.")) {
                        return result;
                    }
                    // ��Dubbo������쳣��ֱ���׳�
                    if (exception instanceof RpcException) {
                        return result;
                    }

                    // ���򣬰�װ��RuntimeException�׸��ͻ���
                    String excepStr = StringUtils.toString(exception);
                    if(!StringUtils.isBlank(excepStr)){
                    	if(excepStr.length() > 200){
                    		excepStr.substring(0, 200);
                    	}
                    }
                    return new RpcResult(new RuntimeException(excepStr));
                } catch (Throwable e) {
                    logger.warn("Fail to ExceptionFilter when called by " + RpcContext.getContext().getRemoteHost()
                            + ". service: " + invoker.getInterface().getName() + ", method: " + invocation.getMethodName()
                            + ", exception: " + e.getClass().getName() + ": " + e.getMessage(), e);
                    return result;
                }
            }
            return result;
        } catch (RuntimeException e) {
            logger.error("Got unchecked and undeclared exception which called by " + RpcContext.getContext().getRemoteHost()
                    + ". service: " + invoker.getInterface().getName() + ", method: " + invocation.getMethodName()
                    + ", exception: " + e.getClass().getName() + ": " + e.getMessage(), e);
            throw e;
        }
    }

    public static void main(String[] args){
    	String a = "agbcd";
    	System.out.println(a.substring(0, a.length()));
    }
}
