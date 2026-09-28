package com.example.pizzastore.pizza;

import com.example.pizzastore.factory.PizzaIngredientFactory;

/**
 * Pizza de almejas. Igual que CheesePizza, delega en la fábrica
 * abstracta la creación de cada ingrediente que necesita.
 */
public class ClamPizza extends Pizza {

    private final PizzaIngredientFactory ingredientFactory;

    public ClamPizza(PizzaIngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
    }

    @Override
    public void prepare() {
        System.out.println("Preparando " + name + "...");
        dough = ingredientFactory.createDough();
        sauce = ingredientFactory.createSauce();
        cheese = ingredientFactory.createCheese();
        clam = ingredientFactory.createClam();
    }
}
