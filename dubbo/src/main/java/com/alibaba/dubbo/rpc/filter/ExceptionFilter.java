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
 * 锟斤拷锟杰ｏ拷
 * <ol>
 * <li>锟斤拷锟斤拷锟斤拷锟斤拷锟届常锟斤拷ERROR锟斤拷志锟斤拷Provider锟剿ｏ拷<br>
 *     锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷志锟斤拷锟角ｏ拷没锟叫的接匡拷锟斤拷锟斤拷锟斤拷锟斤拷Unchecked锟届常锟斤拷
 * <li>锟届常锟斤拷锟斤拷API锟斤拷锟叫ｏ拷锟斤拷Wrap一锟斤拷RuntimeException锟斤拷<br>
 *     RPC锟斤拷锟节碉拷一锟斤拷锟届常锟斤拷直锟斤拷锟斤拷锟叫伙拷锟斤拷锟斤拷(Cause锟届常锟斤拷String锟斤拷)锟斤拷锟斤拷锟斤拷锟届常锟斤拷Client锟斤拷锟斤拷锟杰凤拷锟斤拷锟叫伙拷锟斤拷锟解。
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

                    // 锟斤拷锟斤拷锟絚hecked锟届常锟斤拷直锟斤拷锟阶筹拷
                    if (! (exception instanceof RuntimeException) && (exception instanceof Exception)) {
                        return result;
                    }
                    // 锟节凤拷锟斤拷签锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷直锟斤拷锟阶筹拷
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

                    // 未锟节凤拷锟斤拷签锟斤拷锟较讹拷锟斤拷锟斤拷斐ｏ拷锟斤拷诜锟斤拷锟斤拷锟斤拷舜锟接RROR锟斤拷志
                    logger.error("Got unchecked and undeclared exception which called by " + RpcContext.getContext().getRemoteHost()
                            + ". service: " + invoker.getInterface().getName() + ", method: " + invocation.getMethodName()
                            + ", exception: " + exception.getClass().getName() + ": " + exception.getMessage(), exception);

                    // 锟届常锟斤拷徒涌锟斤拷锟斤拷锟酵籮ar锟斤拷锟斤，直锟斤拷锟阶筹拷
                    String serviceFile = ReflectUtils.getCodeBase(invoker.getInterface());
                    String exceptionFile = ReflectUtils.getCodeBase(exception.getClass());
                    if (serviceFile == null || exceptionFile == null || serviceFile.equals(exceptionFile)){
                        return result;
                    }
                    // 锟斤拷JDK锟皆达拷锟斤拷锟届常锟斤拷直锟斤拷锟阶筹拷
                    String className = exception.getClass().getName();
                    if (className.startsWith("java.") || className.startsWith("javax.")) {
                        return result;
                    }
                    // 锟斤拷Dubbo锟斤拷锟斤拷锟斤拷斐ｏ拷锟街憋拷锟斤拷壮锟�
                    if (exception instanceof RpcException) {
                        return result;
                    }

                    // 锟斤拷锟津，帮拷装锟斤拷RuntimeException锟阶革拷锟酵伙拷锟斤拷
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
