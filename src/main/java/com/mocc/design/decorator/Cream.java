package com.mocc.design.decorator;

/**
 * 奶油
 */
public class Cream extends Food{
    private Food BasicFood;

    public Cream(Food basicFood) {
        BasicFood = basicFood;
    }

    @Override
    public String make() {
        return BasicFood.make() + "奶油";
    }
}
