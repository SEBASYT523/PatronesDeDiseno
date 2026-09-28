package com.example.pizzastore.factory;

import com.example.pizzastore.ingredients.*;

/**
 * FÁBRICA CONCRETA (variante Chicago).
 *
 * Igual que la fábrica de Nueva York, pero entrega la variante
 * de cada ingrediente correspondiente a Chicago. El código que
 * consume esta fábrica (la pizza) no necesita saber que existe
 * esta clase: solo conoce PizzaIngredientFactory.
 */
public class ChicagoPizzaIngredientFactory implements PizzaIngredientFactory {

    @Override
    public Dough createDough() {
        return new ThickCrustDough();
    }

    @Override
    public Sauce createSauce() {
        return new PlumTomatoSauce();
    }

    @Override
    public Cheese createCheese() {
        return new MozzarellaCheese();
    }

    @Override
    public Veggies createVeggies() {
        return new ChicagoVeggies();
    }

    @Override
    public Pepperoni createPepperoni() {
        return new ChicagoPepperoni();
    }

    @Override
    public Clams createClam() {
        return new FrozenClams();
    }
}
