package com.example.pizzastore.factory;

import com.example.pizzastore.ingredients.*;

/**
 * FÁBRICA ABSTRACTA.
 *
 * Define la interfaz para crear cada producto de la familia de
 * ingredientes de una pizza. No sabe nada de Nueva York ni de Chicago:
 * solo declara QUÉ se puede crear, nunca CÓMO.
 *
 * Cualquier clase que use esta interfaz (por ejemplo, una pizza)
 * podrá trabajar con cualquier región sin cambiar una sola línea
 * de su propio código.
 */
public interface PizzaIngredientFactory {
    Dough createDough();
    Sauce createSauce();
    Cheese createCheese();
    Veggies createVeggies();
    Pepperoni createPepperoni();
    Clams createClam();
}
