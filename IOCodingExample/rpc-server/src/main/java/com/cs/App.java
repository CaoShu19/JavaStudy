package com.cs;

import com.cs.rpc.RpcProxyServer;
import com.cs.serverImpl.HelloServiceImpl;

import java.io.IOException;

/**
 * @author : Str2ke
 * @date : 2023/11/12 上午3:39
 * @Desc :
 */
public class App {

    public static void main(String[] args) throws IOException {
        RpcProxyServer rpcProxyServer = new RpcProxyServer();
        HelloService helloService = new HelloServiceImpl();
        rpcProxyServer.publishServer(helloService, 8080);
    }
}
