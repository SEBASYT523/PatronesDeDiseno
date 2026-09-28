package com.example.pizzastore.store;

import com.example.pizzastore.pizza.Pizza;

/**
 * Tienda genérica. Define el proceso de pedido (Template Method
 * clásico de Head First), pero deja que cada subclase regional
 * decida qué pizza construir y con qué fábrica de ingredientes.
 */
public abstract class PizzaStore {

    public Pizza orderPizza(String type) {
        Pizza pizza = createPizza(type);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }

    protected abstract Pizza createPizza(String type);
}
