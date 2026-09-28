package com.example.pizzastore.pizza;

import com.example.pizzastore.factory.PizzaIngredientFactory;
import com.example.pizzastore.ingredients.*;

/**
 * CLIENTE DEL PATRÓN.
 *
 * Pizza es quien realmente usa la fábrica abstracta para conseguir
 * sus ingredientes. Nunca hace "new ThickCrustDough()" ni nada
 * parecido directamente: le pide cada pieza a la fábrica que
 * recibió, y esa fábrica decide qué variante entregarle.
 *
 * Gracias a esto, la misma clase Pizza sirve tanto para una pizza
 * de Nueva York como para una de Chicago, sin ningún cambio.
 */
public abstract class Pizza {

    protected String name;
    protected Dough dough;
    protected Sauce sauce;
    protected Cheese cheese;
    protected Veggies veggies;
    protected Pepperoni pepperoni;
    protected Clams clam;

    /**
     * Cada subclase define QUÉ ingredientes necesita pedir,
     * pero es la fábrica (recibida por parámetro) la que decide
     * CÓMO se construye cada uno.
     */
    public abstract void prepare();

    public void bake() {
        System.out.println("Horneando " + name + " a 350°C durante 25 minutos.");
    }

    public void cut() {
        System.out.println("Cortando " + name + " en trozos diagonales.");
    }

    public void box() {
        System.out.println("Empacando " + name + " en una caja oficial.");
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("---- ").append(name).append(" ----\n");
        if (dough != null)     sb.append("Masa: ").append(dough).append("\n");
        if (sauce != null)     sb.append("Salsa: ").append(sauce).append("\n");
        if (cheese != null)    sb.append("Queso: ").append(cheese).append("\n");
        if (veggies != null)   sb.append("Vegetales: ").append(veggies).append("\n");
        if (pepperoni != null) sb.append("Pepperoni: ").append(pepperoni).append("\n");
        if (clam != null)      sb.append("Almejas: ").append(clam).append("\n");
        return sb.toString();
    }
}
