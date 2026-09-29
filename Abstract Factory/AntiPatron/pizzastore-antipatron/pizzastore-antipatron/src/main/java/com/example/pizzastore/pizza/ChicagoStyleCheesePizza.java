package com.example.pizzastore.pizza;

import com.example.pizzastore.ingredients.MozzarellaCheese;
import com.example.pizzastore.ingredients.PlumTomatoSauce;
import com.example.pizzastore.ingredients.ThickCrustDough;

/** ANTIPATRÓN: misma estructura que NYStyleCheesePizza, con otros new. */
public class ChicagoStyleCheesePizza extends Pizza {

    @Override
    public void prepare() {
        System.out.println("Preparando " + name + "...");
        dough  = new ThickCrustDough();
        sauce  = new PlumTomatoSauce();
        cheese = new MozzarellaCheese();
    }
}
