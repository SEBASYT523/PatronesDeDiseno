package com.example.pizzastore;

import com.example.pizzastore.pizza.Pizza;
import com.example.pizzastore.store.PizzaStore;

/**
 * Misma demostración que en el proyecto con patrón, para comparar la
 * salida lado a lado. Observe el último pedido: la pizza de almejas
 * de Chicago sale con "Almejas frescas" (ingrediente de Nueva York).
 * Compiló sin errores y se ejecutó sin errores; nadie se enteró.
 */
public class Main {
    public static void main(String[] args) {
        PizzaStore nyStore = new PizzaStore("NY");
        PizzaStore chicagoStore = new PizzaStore("Chicago");

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
        System.out.println(">>> Revise las almejas de la pizza anterior: son de Nueva York. Nadie lo detectó.");
    }
}
