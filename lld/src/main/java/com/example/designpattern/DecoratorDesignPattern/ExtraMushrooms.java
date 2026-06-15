package com.example.designpattern.DecoratorDesignPattern;

public class ExtraMushrooms extends ToppingDecorator {


    public ExtraMushrooms(BasePizza myPizza){
        super(myPizza);
    }

    @Override
    public int addOnCost() {
        return 50;
    }
    
}
