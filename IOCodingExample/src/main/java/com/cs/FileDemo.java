package com.cs;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author : Str2ke
 * @date : 2023/11/6 下午10:20
 * @Desc :
 */
public class FileDemo {

    public static void main(String[] args) throws IOException {
        String path = System.getProperty("user.dir") + "/src/main";
        File file = new File(path);
        if (file.isDirectory()) {
            System.out.println("this is directory");
        }
        System.out.println(file.getCanonicalPath());

        getAllFile(file);
    }

    public static void getAllFile(File file) throws IOException {

        File[] files = file.listFiles();
        for (File file1 : files) {
            if (file1.isDirectory()) {
                getAllFile(file1);
            }
            if (!file1.isDirectory()) {
                FileInputStream fileInputStream = null;
                System.out.println(file1.getName());
                if (file1.canRead()) {
                    fileInputStream = new FileInputStream(file1);
                    int b = 0;
                    byte[] buf = new byte[1024];
                    while((b = fileInputStream.read(buf)) != -1) {
                        System.out.printf(new String(buf,0, b, "utf-8"));
                    }
                }
                fileInputStream.close();
            }

        }

    }
}
