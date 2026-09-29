package com.example.pizzastore.pizza;

import com.example.pizzastore.ingredients.FreshClams;
import com.example.pizzastore.ingredients.MozzarellaCheese;
import com.example.pizzastore.ingredients.PlumTomatoSauce;
import com.example.pizzastore.ingredients.ThickCrustDough;

/**
 * ANTIPATRÓN: familias mezcladas.
 *
 * ERROR DELIBERADO para la demostración: esta pizza es de Chicago pero
 * usa FreshClams, que son las almejas de Nueva York (debería ser
 * FrozenClams). Es el típico error de copiar NYStyleClamPizza y cambiar
 * "casi todo". El compilador no lo detecta porque no existe ninguna
 * regla en el código que diga "los ingredientes de una pizza deben ser
 * de la misma región". Con Abstract Factory este error es imposible:
 * la pizza le pide TODO a una sola fábrica y la fábrica de Chicago
 * solo sabe entregar ingredientes de Chicago.
 */
public class ChicagoStyleClamPizza extends Pizza {

    @Override
    public void prepare() {
        System.out.println("Preparando " + name + "...");
        dough  = new ThickCrustDough();
        sauce  = new PlumTomatoSauce();
        cheese = new MozzarellaCheese();
        clam   = new FreshClams();   // <-- ingrediente de NY en una pizza de Chicago
    }
}
