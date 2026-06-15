package com.example.designpattern.DecoratorDesignPattern;

public class PepperoniTopping extends ToppingDecorator {

    public PepperoniTopping(BasePizza myPizza){
        super(myPizza);
    }

    @Override
    public int addOnCost() {
        return 100;
    }

}
