package com.cs;

import java.io.*;

/**
 * @author : Str2ke
 * @date : 2023/11/6 下午11:59
 * @Desc :
 */
public class RWstream {




    public static void main(String[] args) throws IOException {
        String path = "/home/str2ke/MyProjection/Advanced/IOCodingExample/src/main/java/com/cs/BaseDemo.java";
        FileReader fileReader = new FileReader(path);

        int i = 0;
        char[] buf = new char[1024];
        while ((i = fileReader.read(buf)) != -1) {
            System.out.println(new String(buf));
        }

        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(new File(path)), "gbk");
        int i1 = 0;
        char[] buf1 = new char[1024];
        while ((i1 = inputStreamReader.read(buf1)) != -1) {
            System.out.println(new String(buf1));
        }

        fileReader.close();
    }
}
