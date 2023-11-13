package com.cs.proxy;

import com.cs.handler.RemoteInvocationHandler;

import java.lang.reflect.Proxy;

/**
 * @author : Str2ke
 * @date : 2023/11/12 上午3:41
 * @Desc :
 */
public class RpcClientProxy {


    public <T> T clientProxy(final Class<T> interfaceClass, final String host, final int port) {
        return (T) Proxy.newProxyInstance(interfaceClass.getClassLoader(),
                new Class<?>[]{interfaceClass}, new RemoteInvocationHandler(host, port));
    }
}
