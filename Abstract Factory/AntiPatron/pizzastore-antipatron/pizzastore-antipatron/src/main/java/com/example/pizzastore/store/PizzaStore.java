package com.example.pizzastore.store;

import com.example.pizzastore.pizza.ChicagoStyleCheesePizza;
import com.example.pizzastore.pizza.ChicagoStyleClamPizza;
import com.example.pizzastore.pizza.NYStyleCheesePizza;
import com.example.pizzastore.pizza.NYStyleClamPizza;
import com.example.pizzastore.pizza.Pizza;

/**
 * ANTIPATRÓN: condicionales por variante.
 *
 * Una sola tienda decide con if/else anidados qué clase concreta
 * instanciar según la región Y el tipo. Agregar una región nueva
 * ("california") obliga a:
 *   1. crear N clases de pizza nuevas (una por tipo) con sus new,
 *   2. abrir esta clase y añadir una rama completa al if,
 *   3. repetir el paso 2 en cualquier otro sitio que también decida por región.
 * Compárese con la versión con patrón, donde agregar una región es
 * crear UNA fábrica concreta y una subclase de tienda, sin tocar Pizza.
 */
public class PizzaStore {

    private final String region;

    public PizzaStore(String region) {
        this.region = region;
    }

    public Pizza orderPizza(String type) {
        Pizza pizza = null;

        if (region.equals("NY")) {
            if (type.equals("cheese")) {
                pizza = new NYStyleCheesePizza();
                pizza.setName("Pizza de queso estilo Nueva York");
            } else if (type.equals("clam")) {
                pizza = new NYStyleClamPizza();
                pizza.setName("Pizza de almejas estilo Nueva York");
            }
        } else if (region.equals("Chicago")) {
            if (type.equals("cheese")) {
                pizza = new ChicagoStyleCheesePizza();
                pizza.setName("Pizza de queso estilo Chicago");
            } else if (type.equals("clam")) {
                pizza = new ChicagoStyleClamPizza();
                pizza.setName("Pizza de almejas estilo Chicago");
            }
        }
        // } else if (region.equals("California")) { ... otra rama completa ... }

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }
}
