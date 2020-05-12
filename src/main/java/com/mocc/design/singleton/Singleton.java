package com.mocc.design.singleton;

import java.util.Objects;

/**
 * 懒汉式（线程不安全）
 * 实际应用场景：
 *
 * 在Spring中创建的Bean实例默认都是单例模式存在的。
 * Windows的Task Manager（任务管理器）就是很典型的单例模式（这个很熟悉吧），想想看，是不是呢，你能打开两个windows task manager吗？不信你自己试试看哦~
 * windows的Recycle Bin（回收站）也是典型的单例应用。在整个系统运行过程中，回收站一直维护着仅有的一个实例。
 * 网站的计数器，一般也是采用单例模式实现，否则难以同步。
 * 应用程序的日志应用，一般都何用单例模式实现，这一般是由于共享的日志文件一直处于打开状态，因为只能有一个实例去操作，否则内容不好追加。
 */
public class Singleton {

    private static Singleton singleton;

    private Singleton() {
    }

    /**
     * 单例模式获取对象实例（线程不安全，并发时，有机率生成多个单例对象实例）
     * @return
     */
//    public static Singleton getInstance(){
//        if(Objects.isNull(singleton)){//此处线程不安全
//            singleton = new Singleton();
//        }
//        return singleton;
//    }

    /**
     * 使用synchronized关键字同步整个获取实例的方法，做到线程安全
     *
     * @return
     */
    public static synchronized Singleton getInstance() {
        if (Objects.isNull(singleton)) {
            singleton = new Singleton();
        }
        return singleton;
    }

    /**
     * 饿汉式
     */
//    private static Singleton instance = new Singleton();
//    private Singleton (){}
//    public static Singleton getInstance() {
//        return instance;
//    }

    /**
     * 静态内部类方式
     */
    private static class SingletonHolder {
        private static final Singleton instance = new Singleton();

        private SingletonHolder() {
        }

        public static final Singleton getInstance() {
            return instance;
        }
    }


    /**
     * 双重校验机制
     */
//    private volatile static Singleton singleton;
//    private Singleton (){}
//    public static Singleton getSingleton() {
//        if (singleton == null) {
//            synchronized (Singleton.class) {
//                if (singleton == null) {
//                    singleton = new Singleton();
//                }
//            }
//        }
//        return singleton;
//    }


    /**
     * 杜绝 JVM 的指令重排对单例造成的影响
     * 1、什么是指令重排
     * 比如 java 中简单的一句 instance = new Singleton，会被编译器编译成如下 JVM 指令：
     * memory =allocate();    //1：分配对象的内存空间 
     *
     * ctorInstance(memory);  //2：初始化对象 
     *
     * instance =memory;     //3：设置instance指向刚分配的内存地址
     * 复制代码但是这些指令顺序并非一成不变，有可能会经过 JVM 和 CPU 的优化，指令重排成下面的顺序：
     * memory =allocate();    //1：分配对象的内存空间 
     *
     * instance =memory;     //3：设置instance指向刚分配的内存地址 
     *
     * ctorInstance(memory);  //2：初始化对象
     * 复制代码2、影响
     * 对应到上文的单例模式，会产生如下图的问题：
     *
     *
     * 当线程 A 执行完1,3,时，准备走2，即 instance 对象还未完成初始化，但已经不再指向 null 。
     *
     *
     * 此时如果线程 B 抢占到CPU资源，执行  if（instance == null）的结果会是 false，
     *
     *
     * 从而返回一个没有初始化完成的instance对象。
     *
     * 3、解决
     * 如何去防止呢，很简单，可以利用关键字 volatile 来修饰 instance 对象
     *
     * why？
     *
     * 很简单，volatile 修饰符在此处的作用就是阻止变量访问前后的指令重排，从而保证了指令的执行顺序。
     *
     * 意思就是，指令的执行顺序是严格按照上文的 1、2、3 来执行的，从而对象不会出现中间态
     */
}
