package com.example.pizzastore.pizza;

/**
 * ANTIPATRÓN: clase base de pizza.
 *
 * Fíjese en el tipo de los atributos: son OBJECT. No existe ninguna
 * interfaz Dough, Sauce, Cheese o Clams que agrupe las variantes, así
 * que no hay forma de declarar "esto es una masa" sin nombrar la clase
 * concreta. Cada subclase decide por su cuenta qué clase concreta
 * instanciar, y nada garantiza que todas sean de la misma región.
 */
public abstract class Pizza {

    protected String name;
    protected Object dough;
    protected Object sauce;
    protected Object cheese;
    protected Object clam;

    /** Cada subclase crea SUS ingredientes con new. Aquí vive el antipatrón. */
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
        if (dough != null)  sb.append("Masa: ").append(dough).append("\n");
        if (sauce != null)  sb.append("Salsa: ").append(sauce).append("\n");
        if (cheese != null) sb.append("Queso: ").append(cheese).append("\n");
        if (clam != null)   sb.append("Almejas: ").append(clam).append("\n");
        return sb.toString();
    }
}
