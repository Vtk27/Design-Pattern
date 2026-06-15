package com.example.designpattern.DecoratorDesignPattern;

public abstract class ToppingDecorator extends BasePizza{

    BasePizza basePizza;
    public abstract int addOnCost();
    
    public ToppingDecorator(BasePizza myPizza){
        basePizza = myPizza;
    }

    @Override
    public int cost(){
        return addOnCost()+basePizza.cost();
    }
}
