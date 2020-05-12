package com.mocc.design.decorator;

/**
 * 面包
 */
public class Bread extends Food{
    private Food BasicFood;

    public Bread(Food basicFood) {
        BasicFood = basicFood;
    }

    @Override
    public String make() {
        return BasicFood.make() + "面包";
    }
}
