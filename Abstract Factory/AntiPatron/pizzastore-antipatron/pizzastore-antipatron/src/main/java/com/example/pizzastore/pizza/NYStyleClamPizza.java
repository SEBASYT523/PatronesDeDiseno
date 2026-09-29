package com.example.pizzastore.pizza;

import com.example.pizzastore.ingredients.FreshClams;
import com.example.pizzastore.ingredients.MarinaraSauce;
import com.example.pizzastore.ingredients.ReggianoCheese;
import com.example.pizzastore.ingredients.ThinCrustDough;

/**
 * ANTIPATRÓN: duplicación. Las tres primeras líneas de prepare() son
 * idénticas a las de NYStyleCheesePizza. La "receta regional" no existe
 * como concepto en el código: está copiada y pegada en cada pizza.
 */
public class NYStyleClamPizza extends Pizza {

    @Override
    public void prepare() {
        System.out.println("Preparando " + name + "...");
        dough  = new ThinCrustDough();
        sauce  = new MarinaraSauce();
        cheese = new ReggianoCheese();
        clam   = new FreshClams();
    }
}
