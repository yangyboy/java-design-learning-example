package com.mocc.design.adapter;

/**
 * @author 杨洋
 * @ClassName VoltageAdapter.java
 * @Description
 * @CreateTime 2020年05月09日 15:24:00
 * 变压器
 */
public class VoltageAdapter {
    // 改变电压的功能
    public void changeVoltage() {
        System.out.println("正在充电...");
        System.out.println("原始电压：" + Phone.V + "V");
        System.out.println("经过变压器转换之后的电压:" + (Phone.V - 200) + "V");
    }
}
