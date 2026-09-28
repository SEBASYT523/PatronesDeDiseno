package com.example.pizzastore;

import com.example.pizzastore.pizza.Pizza;
import com.example.pizzastore.store.ChicagoStylePizzaStore;
import com.example.pizzastore.store.NYPizzaStore;
import com.example.pizzastore.store.PizzaStore;

/**
 * Clase de demostración. Pide la misma pizza ("cheese") en dos
 * tiendas distintas para mostrar cómo, gracias a Abstract Factory,
 * el mismo flujo (Pizza + PizzaStore) produce resultados distintos
 * y coherentes según la región, sin ningún "if" que distinga
 * ingredientes dentro de la clase Pizza.
 */
public class Main {
    public static void main(String[] args) {
        PizzaStore nyStore = new NYPizzaStore();
        PizzaStore chicagoStore = new ChicagoStylePizzaStore();

        System.out.println("== Pedido en la tienda de Nueva York ==");
        Pizza pizza = nyStore.orderPizza("cheese");
        System.out.println(pizza);

        System.out.println("== Pedido en la tienda de Chicago ==");
        pizza = chicagoStore.orderPizza("cheese");
        System.out.println(pizza);

        System.out.println("== Pedido de almejas en Nueva York ==");
        pizza = nyStore.orderPizza("clam");
        System.out.println(pizza);

        System.out.println("== Pedido de almejas en Chicago ==");
        pizza = chicagoStore.orderPizza("clam");
        System.out.println(pizza);
    }
}
