package com.cs.rpc;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author : Str2ke
 * @date : 2023/11/11 下午9:07
 * @Desc :
 */
public class RpcProxyServer {

    private final ExecutorService executorService = Executors.newCachedThreadPool();

    public void publishServer(Object service, int port) throws IOException {
        // 建立服务

        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(port);
            while (true) {
                // 这里是BIO,那么执行任务必然有顺序性
                Socket accept = serverSocket.accept();
                // 执行任务,其中socket中任务信息,service是具体服务
                executorService.execute(new ProcessorHandler(accept,service));
            }

        } catch (Exception e) {

        } finally {
            serverSocket.close();
        }



    }
}
