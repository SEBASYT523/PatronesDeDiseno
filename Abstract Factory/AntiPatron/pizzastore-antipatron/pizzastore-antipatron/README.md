# Proyecto de ejemplo: ANTIPATRÓN de Abstract Factory (PizzaStore)

Es la **misma pizzería** del proyecto `pizzastore-abstractfactory`, con las mismas
pizzas, el mismo `Main` y la misma salida por consola, pero escrita como se escribe
"de forma natural" antes de conocer el patrón: cada pizza crea sus ingredientes con
`new` y una sola tienda decide con `if/else` qué clase concreta instanciar.

Los dos proyectos están pensados para abrirse lado a lado.

## Qué cambia respecto al proyecto con patrón

| Aspecto | Antipatrón (este proyecto) | Patrón (`pizzastore-abstractfactory`) |
|---|---|---|
| Interfaces de producto (`Dough`, `Sauce`, `Cheese`, `Clams`) | **No existen.** Los atributos de `Pizza` son `Object` | Existen; cada variante regional las implementa |
| Fábrica (`PizzaIngredientFactory`) | **No existe** | Interfaz + `NYPizzaIngredientFactory` + `ChicagoPizzaIngredientFactory` |
| Dónde se hace `new` de un ingrediente | En **cada** clase de pizza (4 clases, 14 `new`) | Solo dentro de las 2 fábricas concretas |
| Clases de pizza | 4: una por tipo **y** región (`NYStyleCheesePizza`, `ChicagoStyleClamPizza`…) | 2: una por tipo (`CheesePizza`, `ClamPizza`); la región la pone la fábrica |
| Decisión de región | `if (region.equals("NY")) … else if ("Chicago")` en `PizzaStore.orderPizza` | Una subclase de tienda por región, sin `if` de región |
| Agregar región "California" | Crear 2 pizzas nuevas con sus `new` + editar `PizzaStore` + revisar cada sitio que decida por región | Crear 1 fábrica concreta + 1 subclase de tienda; `Pizza` no se toca |
| Garantía de familia coherente | **Ninguna.** `ChicagoStyleClamPizza` usa `FreshClams` (de NY) y compila | Imposible mezclar: la pizza le pide todo a una sola fábrica |

## Los tres síntomas del antipatrón, y dónde verlos

1. **Dependencia de clases concretas** → `pizza/NYStyleCheesePizza.java`: tres `new` a
   clases concretas. Cambiar el proveedor de queso de NY obliga a editar cada pizza de NY.
2. **Familias mezcladas** → `pizza/ChicagoStyleClamPizza.java`: error deliberado, una
   pizza de Chicago con almejas de Nueva York. Compila, corre y nadie se entera.
   Ejecute `Main` y mire el último pedido.
3. **Cirugía de escopeta** → `store/PizzaStore.java`: `if/else` anidado por región y tipo.
   Cada región nueva es una rama completa más, aquí y en cualquier otro sitio que decida
   por región.

## Cómo compilar y ejecutar

Requiere JDK 11 o superior. Desde la raíz del proyecto:

```bash
find src -name "*.java" > sources.txt
javac -d out @sources.txt
java -cp out com.example.pizzastore.Main
```

En Windows (cmd):

```
dir /s /b src\*.java > sources.txt
javac -d out @sources.txt
java -cp out com.example.pizzastore.Main
```

## Carpeta `ejemplo-bd/`

`UsuarioDAO.java` es la versión Java del fragmento de acceso a base de datos que
aparece en la sección "Antipatrón Asociado" del informe: conexión, sentencia y SQL
específicos de cada motor, elegidos con `if/else` dentro de **cada** método. Compila
con el JDK (`javac ejemplo-bd/UsuarioDAO.java`); para ejecutarlo harían falta los
drivers JDBC en el classpath, pero no es necesario para la demostración.

## Cómo exponerlo

1. Abrir `NYStyleCheesePizza` del antipatrón y `CheesePizza` del patrón lado a lado:
   tres `new` contra tres `ingredientFactory.createX()`.
2. Abrir `PizzaStore` del antipatrón y `NYPizzaStore` del patrón: el `if` de región
   desaparece porque cada tienda ya sabe qué fábrica usar.
3. Ejecutar los dos `Main`. La salida es idéntica **salvo el último pedido**: en el
   antipatrón las almejas de Chicago son frescas (de NY). Preguntar al público quién
   lo notó. Explicar por qué en el patrón ese error no puede escribirse.
4. Cerrar con `ejemplo-bd/UsuarioDAO.java`: mismo antipatrón, otro dominio, el que
   pidió el profesor.
