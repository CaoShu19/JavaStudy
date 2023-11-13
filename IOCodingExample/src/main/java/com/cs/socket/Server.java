package com.cs.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author : Str2ke
 * @date : 2023/11/10 上午1:35
 * @Desc :
 */
public class Server {

    public static void main(String[] args) throws IOException {
        new Server().run(8081);
    }

    void run(int port) throws IOException {
        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream inputStream = null;
        try {
            serverSocket = new ServerSocket(port);
            socket = serverSocket.accept();
            inputStream = socket.getInputStream();
            int len = 0;
            byte[] buff = new byte[1024];
            while((len = inputStream.read(buff)) != -1) {
                System.out.println(new String(buff,0,len,"UTF-8"));
            }
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write("i receive your message !!!\n".getBytes());
            outputStream.flush();
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            inputStream.close();
            socket.close();
            serverSocket.close();
        }



    }
}
