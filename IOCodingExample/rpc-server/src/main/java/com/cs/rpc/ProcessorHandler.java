package com.cs.rpc;

import com.cs.request.RpcRequest;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Socket;

/**
 * @author : Str2ke
 * @date : 2023/11/11 下午9:38
 * @Desc :
 */
public class ProcessorHandler implements Runnable{
    private Socket socket;
    private Object service;
    ProcessorHandler(Socket socket, Object service) {
        this.socket = socket;
        this.service = service;
    }

    @Override
    public void run() {
        ObjectInputStream inputStream = null;
        ObjectOutputStream outputStream = null;

        try {
            String name = Thread.currentThread().getName();
            System.out.println(name + " Thread will execute");
            inputStream = new ObjectInputStream(socket.getInputStream());
            RpcRequest request = (RpcRequest) inputStream.readObject();
            Object invoke = invoke(request);

            outputStream = new ObjectOutputStream(socket.getOutputStream());
            outputStream.writeObject(invoke);
            outputStream.flush();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                outputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


    }

    private Object invoke(RpcRequest request) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        Class<?> aClass = Class.forName(request.getClassName());
        Method method = aClass.getMethod(request.getMethodName(), request.getTypes());
        return method.invoke(service, request.getParameter());
    }
}
