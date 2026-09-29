package com.example.pizzastore.pizza;

import com.example.pizzastore.ingredients.MarinaraSauce;
import com.example.pizzastore.ingredients.ReggianoCheese;
import com.example.pizzastore.ingredients.ThinCrustDough;

/**
 * ANTIPATRÓN: la pizza conoce y crea sus ingredientes concretos.
 *
 * Tres "new" a clases concretas. Si mañana Nueva York cambia de
 * proveedor de queso, hay que abrir ESTA clase y también
 * NYStyleClamPizza (y cualquier otra pizza de NY) para cambiarlo.
 */
public class NYStyleCheesePizza extends Pizza {

    @Override
    public void prepare() {
        System.out.println("Preparando " + name + "...");
        dough  = new ThinCrustDough();
        sauce  = new MarinaraSauce();
        cheese = new ReggianoCheese();
    }
}
