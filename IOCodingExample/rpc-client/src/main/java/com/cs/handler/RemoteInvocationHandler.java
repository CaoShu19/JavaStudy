package com.cs.handler;

import com.cs.RpcClientTransport;
import com.cs.request.RpcRequest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author : Str2ke
 * @date : 2023/11/12 上午3:45
 * @Desc :
 */
public class RemoteInvocationHandler implements InvocationHandler {
    String host;
    int port;

    public RemoteInvocationHandler(String host, int port) {
        this.host = host;
        this.port = port;
    }

    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        RpcRequest request = new RpcRequest();
        request.setClassName(method.getDeclaringClass().getName());
        request.setMethodName(method.getName());
        request.setParameter(objects);
        request.setTypes(method.getParameterTypes());

        RpcClientTransport rpcClientTransport = new RpcClientTransport(host, port);

        return rpcClientTransport.sendRequest(request);
    }
}
