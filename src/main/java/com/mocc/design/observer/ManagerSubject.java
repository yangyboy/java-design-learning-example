package com.mocc.design.observer;

public class ManagerSubject extends Subject{
    public void doSomething(){
        super.notifyAllObserver();
    }
}
