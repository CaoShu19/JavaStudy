package com.cs;

import java.io.*;
import java.net.Socket;

/**
 * @author : Str2ke
 * @date : 2023/11/6 下午10:14
 * @Desc :
 */
public class BaseDemo {

    public static void main(String[] args) throws IOException {
        // 本质都是句柄
        // 硬盘 file
        File file = new File(System.getProperty("user.dir"));



        // 内存
        String val = "sfg内存";
        ByteArrayInputStream stream = new ByteArrayInputStream(val.getBytes());
        byte[] buf = new byte[1024];
        int read = stream.read(buf);
//        System.out.println(new String(buf,"utf-16"));
        System.out.println(new String(buf,"utf-8"));
        // 键盘
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String path = bufferedReader.readLine();
        System.out.println(path);
        // 网络
//        Socket socket = new Socket();
    }
}
