package com.example.pizzastore.pizza;

import com.example.pizzastore.factory.PizzaIngredientFactory;

/**
 * Pizza de queso. Nótese que esta clase no sabe si sus ingredientes
 * vendrán de la variante Nueva York o Chicago: eso lo decide la
 * fábrica que le fue inyectada en el constructor.
 */
public class CheesePizza extends Pizza {

    private final PizzaIngredientFactory ingredientFactory;

    public CheesePizza(PizzaIngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
    }

    @Override
    public void prepare() {
        System.out.println("Preparando " + name + "...");
        dough = ingredientFactory.createDough();
        sauce = ingredientFactory.createSauce();
        cheese = ingredientFactory.createCheese();
    }
}
