package com.mocc.design.decorator;

/**
 * 奶油
 */
public class Vegetable extends Food{
    private Food BasicFood;

    public Vegetable(Food basicFood) {
        BasicFood = basicFood;
    }

    @Override
    public String make() {
        return BasicFood.make() + "蔬菜";
    }
}
