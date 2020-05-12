package com.mocc.design.adapter;

/**
 * @author 杨洋
 * @ClassName Phone.java
 * @Description
 * @CreateTime 2020年05月09日 15:24:00
 */
public class Phone {
    public static final int V = 220; // 正常电压220v，是一个常量
    private VoltageAdapter adapter;
    public void charge(){
        adapter.changeVoltage();
    }

    public Phone(VoltageAdapter adapter) {
        this.adapter = adapter;
    }
}
