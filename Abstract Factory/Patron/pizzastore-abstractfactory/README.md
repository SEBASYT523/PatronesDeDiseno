# Proyecto de ejemplo: Abstract Factory (PizzaStore)

Implementación en Java del patrón de diseño **Abstract Factory**,
siguiendo el diagrama UML del ejemplo clásico de la tienda de pizzas
(Head First Design Patterns).

## Estructura del patrón en este proyecto

| Rol del patrón                | Clase / interfaz en el proyecto                                  |
|-------------------------------|--------------------------------------------------------------------|
| Fábrica abstracta              | `factory.PizzaIngredientFactory`                                  |
| Fábricas concretas             | `factory.NYPizzaIngredientFactory`, `factory.ChicagoPizzaIngredientFactory` |
| Productos abstractos           | `ingredients.Dough`, `Sauce`, `Cheese`, `Veggies`, `Pepperoni`, `Clams` |
| Productos concretos            | `ThinCrustDough`, `ThickCrustDough`, `MarinaraSauce`, `PlumTomatoSauce`, etc. |
| Cliente del patrón             | `pizza.Pizza` (y sus subclases `CheesePizza`, `ClamPizza`)         |
| Código que decide la variante  | `store.NYPizzaStore`, `store.ChicagoStylePizzaStore`               |

## Idea central

`Pizza` nunca crea sus ingredientes con `new` directamente. Le pide
cada ingrediente a una `PizzaIngredientFactory` que recibe por
parámetro. Esa fábrica puede ser la de Nueva York o la de Chicago:
`Pizza` no lo sabe ni le importa, solo trabaja contra la interfaz
abstracta. Quien decide qué fábrica concreta se usa es la tienda
(`PizzaStore`), en el momento de construir la pizza.

Esto permite:
- Agregar una nueva región (por ejemplo, "California") creando solo
  una nueva fábrica concreta y sus ingredientes, sin tocar `Pizza`.
- Garantizar que los ingredientes de una misma pizza siempre sean
  de la misma variante/región (no se mezclan por accidente masa de
  Chicago con salsa de Nueva York).

## Cómo compilar y ejecutar

Requiere JDK 11 o superior.

```bash
# Desde la raíz del proyecto
find src -name "*.java" > sources.txt
javac -d out @sources.txt
java -cp out com.example.pizzastore.Main
```

## Cómo explicarlo al entregar el trabajo

1. Muestra `PizzaIngredientFactory`: es el contrato que define
   "qué" se puede fabricar (una familia de productos), sin decir
   "cómo".
2. Muestra `NYPizzaIngredientFactory` y `ChicagoPizzaIngredientFactory`:
   cada una implementa ese contrato con una variante regional distinta.
3. Muestra `Pizza`/`CheesePizza`: el cliente que usa la fábrica
   recibida, sin conocer su clase concreta.
4. Muestra `NYPizzaStore`/`ChicagoStylePizzaStore`: el único lugar
   del código donde se decide "new NYPizzaIngredientFactory()" o
   "new ChicagoPizzaIngredientFactory()".
5. Ejecuta `Main` y muestra cómo la misma pizza ("cheese") sale con
   ingredientes distintos según la tienda, sin que la clase `Pizza`
   tenga ningún `if` de región.
