package com.example.pizzastore.store;

import com.example.pizzastore.factory.ChicagoPizzaIngredientFactory;
import com.example.pizzastore.factory.PizzaIngredientFactory;
import com.example.pizzastore.pizza.CheesePizza;
import com.example.pizzastore.pizza.ClamPizza;
import com.example.pizzastore.pizza.Pizza;

/**
 * Tienda de Chicago. La única diferencia real frente a NYPizzaStore
 * es qué fábrica concreta se instancia aquí. El resto del sistema
 * (Pizza, PizzaStore) permanece intacto.
 */
public class ChicagoStylePizzaStore extends PizzaStore {

    @Override
    protected Pizza createPizza(String type) {
        Pizza pizza = null;
        PizzaIngredientFactory ingredientFactory = new ChicagoPizzaIngredientFactory();

        if (type.equals("cheese")) {
            pizza = new CheesePizza(ingredientFactory);
            pizza.setName("Pizza de queso estilo Chicago");
        } else if (type.equals("clam")) {
            pizza = new ClamPizza(ingredientFactory);
            pizza.setName("Pizza de almejas estilo Chicago");
        }
        return pizza;
    }
}
