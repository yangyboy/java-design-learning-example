package com.mocc.design.observer;

public class ObServerCat implements ObServer{

    private String name = "cat";

    @Override
    public void handleMessage(String message) {
        System.out.println(name + "接收到消息：【" + message + "】，开始处理！！！");
    }
}
