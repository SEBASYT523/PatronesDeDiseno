package com.example.pizzastore.factory;

import com.example.pizzastore.ingredients.*;

/**
 * FÁBRICA CONCRETA (variante Nueva York).
 *
 * Su única responsabilidad es saber qué ingrediente concreto
 * corresponde a la región de Nueva York para cada producto de
 * la familia. Todos los productos que entrega son compatibles
 * entre sí porque pertenecen a la misma variante regional.
 */
public class NYPizzaIngredientFactory implements PizzaIngredientFactory {

    @Override
    public Dough createDough() {
        return new ThinCrustDough();
    }

    @Override
    public Sauce createSauce() {
        return new MarinaraSauce();
    }

    @Override
    public Cheese createCheese() {
        return new ReggianoCheese();
    }

    @Override
    public Veggies createVeggies() {
        return new NYVeggies();
    }

    @Override
    public Pepperoni createPepperoni() {
        return new SlicedPepperoni();
    }

    @Override
    public Clams createClam() {
        return new FreshClams();
    }
}
