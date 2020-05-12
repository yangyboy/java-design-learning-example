package com.mocc.design.decorator;

/**
 * 食物类，用于演示装饰者模式
 */
public class Food {
    private String foodName;

    public Food() {
    }

    public Food(String foodName) {
        this.foodName = foodName;
    }

    public String make(){
        return foodName;
    }
}
