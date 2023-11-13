package com.cs.serverImpl;

import com.cs.HelloService;

/**
 * @author : Str2ke
 * @date : 2023/11/11 下午9:01
 * @Desc :
 */
public class HelloServiceImpl implements HelloService {

    @Override
    public String greet(String name) throws InterruptedException {
        Thread.sleep(500);
        return "you too, i find you :" + name;
    }
}
