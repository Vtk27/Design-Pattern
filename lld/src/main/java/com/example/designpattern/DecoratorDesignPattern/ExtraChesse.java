package com.example.designpattern.DecoratorDesignPattern;

public class ExtraChesse extends ToppingDecorator {

    public ExtraChesse(BasePizza myPizza){
        super(myPizza);
    }

    @Override
    public int addOnCost() {
        return 20;
    }
    
}
