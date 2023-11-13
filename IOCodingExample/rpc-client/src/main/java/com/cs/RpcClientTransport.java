package com.cs;

import com.cs.request.RpcRequest;

import java.io.*;
import java.net.Socket;

/**
 * @author : Str2ke
 * @date : 2023/11/12 上午3:53
 * @Desc :
 */
public class RpcClientTransport {

    String host;
    int port;

    public Object sendRequest(RpcRequest request) throws IOException, ClassNotFoundException {
        Socket socket = new Socket(host, port);
        ObjectOutputStream objectOutputStream =
                new ObjectOutputStream(socket.getOutputStream());
        objectOutputStream.writeObject(request);
        ObjectInputStream objectInputStream =
                new ObjectInputStream(socket.getInputStream());
        return objectInputStream.readObject();
    }

    public RpcClientTransport(String host, int port) {
        this.host = host;
        this.port = port;
    }
}
