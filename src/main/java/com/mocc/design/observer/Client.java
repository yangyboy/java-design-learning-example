package com.mocc.design.observer;

/**
 * 观察者模式
 * 场景描述：
 *
 * 以购票为核心业务(此模式不限于该业务)，但围绕购票会产生不同的其他逻辑，如：
 *
 * 购票后记录文本日志
 * 购票后记录数据库日志
 * 购票后发送短信
 * 购票送抵扣卷、兑换卷、积分
 * -其他各类活动等
 *
 * 传统解决方案:
 *
 * 在购票逻辑等类内部增加相关代码，完成各种逻辑。
 *
 * 存在问题：
 *
 * 1、一旦某个业务逻辑发生改变，如购票业务中增加其他业务逻辑，需要修改购票核心文件、甚至购票流程。
 *
 * 2、日积月累后，文件冗长，导致后续维护困难。
 *
 * 存在问题原因主要是程序的"紧密耦合"，使用观察模式将目前的业务逻辑优化成"松耦合"，达到易维护、易修改的目的，同时也符合面向接口编程的思想。
 */
public class Client {
    public static void main(String[] args) {
        ManagerSubject managerSubject = new ManagerSubject();
        ObServerCat obServerCat = new ObServerCat();
        ObServerDog obServerDog = new ObServerDog();
        managerSubject.addObServer(obServerCat);
        managerSubject.addObServer(obServerDog);

        managerSubject.notifyAllObserver();


    }
}
