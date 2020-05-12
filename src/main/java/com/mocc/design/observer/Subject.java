package com.mocc.design.observer;

import java.util.ArrayList;
import java.util.List;

public class Subject {
    List<ObServer> obServerList = new ArrayList<>();

    public void addObServer(ObServer obServer){
        obServerList.add(obServer);
    }

    public void notifyAllObserver(){
        for (ObServer obServer : obServerList) {
            obServer.handleMessage("这算发送给你们的消息");
        }
    }

    public static void main(String[] args) {
        System.out.println();
    }
}
