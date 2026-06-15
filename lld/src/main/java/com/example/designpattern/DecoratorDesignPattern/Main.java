package com.example.designpattern.DecoratorDesignPattern;

public class Main {
    public static void main(String[] args) {
        // initialize base pizza 
        BasePizza margPizza = new MargaritaPizza();

        // add Extracheese topping
        margPizza = new ExtraChesse(margPizza);

        // add Pepperoni topping
        margPizza = new PepperoniTopping(margPizza);

        // add ExtraMushroom topping
        margPizza = new ExtraMushrooms(margPizza);

        System.out.println("Total Cost of Pizza with added toppings->"+margPizza.cost());
    }   
}
//Note only with 3 Topping classes we can generate 6 combinations of toppings 
