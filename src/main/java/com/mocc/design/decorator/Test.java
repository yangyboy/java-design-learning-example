package com.mocc.design.decorator;

/**
 * @author 杨洋
 * @ClassName Test.java
 * @Description
 * @CreateTime 2020年05月09日 14:44:00
 *
 * 实际应用场景：
 *
 * 如上述一样，不同的人，选择的搭配不同，对应价格也不相同，若是应用传统方式你会发现这里四种配料就要写十几种实现类了，那如果我们的配料是二十几种或者三十几种呢，那么使用继承这种 方式肯定会使我们的子类爆炸。
 *
 * 通过不同的组合以Food food = new Bread(new Vegetable(new Cream(new Food("香肠"))));形式更加简化，结构更加清楚的方式展现。
 *
 * 优点：
 *
 * 把类中的装饰功能从类中搬除，可以简化原来的类
 * 可以把类的 核心职责和装饰功能区分开来，结构清晰 明了并且可以去除相关类的重复的装饰逻辑
 */
public class Test {
    public static void main(String[] args) {
        Food food = new Bread(new Vegetable(new Cream(new Food("香肠"))));
        System.out.println(food.make());
    }
}
