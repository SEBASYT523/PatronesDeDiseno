package com.example.pizzastore.store;

import com.example.pizzastore.factory.NYPizzaIngredientFactory;
import com.example.pizzastore.factory.PizzaIngredientFactory;
import com.example.pizzastore.pizza.CheesePizza;
import com.example.pizzastore.pizza.ClamPizza;
import com.example.pizzastore.pizza.Pizza;

/**
 * Tienda de Nueva York. Su única responsabilidad "especial" es
 * decidir que aquí se usa la fábrica de ingredientes de Nueva York.
 * De ahí en adelante, toda la lógica de Pizza es exactamente la
 * misma que en cualquier otra región.
 */
public class NYPizzaStore extends PizzaStore {

    @Override
    protected Pizza createPizza(String type) {
        Pizza pizza = null;
        PizzaIngredientFactory ingredientFactory = new NYPizzaIngredientFactory();

        if (type.equals("cheese")) {
            pizza = new CheesePizza(ingredientFactory);
            pizza.setName("Pizza de queso estilo Nueva York");
        } else if (type.equals("clam")) {
            pizza = new ClamPizza(ingredientFactory);
            pizza.setName("Pizza de almejas estilo Nueva York");
        }
        return pizza;
    }
}
