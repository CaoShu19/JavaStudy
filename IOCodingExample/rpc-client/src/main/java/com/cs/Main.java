package com.cs;

import com.cs.proxy.RpcClientProxy;

/**
 * @author : Str2ke
 * @date : 2023/11/11 下午9:03
 * @Desc :
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        // execute promote server
        RpcClientProxy rpcClientProxy = new RpcClientProxy();
        HelloService helloService = rpcClientProxy.clientProxy(HelloService.class,"localhost", 8080);
        for (int i = 0; i < 20; i++) {
            String greet = helloService.greet("client:" + i);
            System.out.println(greet);
        }
    }
}
