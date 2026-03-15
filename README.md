# Carrito de Compras en Java

Este proyecto implementa un **carrito de compras** en Java con buenas prácticas de programación orientada a objetos. Permite agregar, remover y listar artículos (`Item`) junto con su cantidad, calcular el total y manejar excepciones de forma segura.

---

## 📂 Estructura del proyecto

CarritoDeCompras/
│
├─ README.md
├─ src/
│   ├─ Main.java
│   ├─ CarritoDeCompras.java
│   └─ Item.java
└─ bin/                ← (opcional) archivos compilados .class

- `src/` → Contiene los archivos fuente del proyecto.
- `README.md` → Documentación del proyecto.
- `bin/` → Carpeta opcional donde se guardan los `.class` compilados.

---

## 🛠️ Tecnologías

- Java 17+ (recomendado)
- Herramienta de compilación: `javac`
- IDE sugerido: Visual Studio Code o IntelliJ IDEA

---

## 📖 Descripción de clases

### Item.java
- Representa un artículo que puede ser agregado al carrito.
- Atributos privados: `nombre` y `precio`.
- Métodos:
  - `getNombre()`, `setNombre()`
  - `getPrecio()`, `setPrecio()`
  - `toString()` → devuelve la representación legible del ítem.
- Validación: los precios deben estar dentro de límites definidos (`PRECIO_MINIMO` y `PRECIO_MAXIMO`). Lanza `IllegalArgumentException` si se viola.

### CarritoDeCompras.java
- Contiene un conjunto de `Item` junto con su cantidad (`Map<Item, Integer>`).
- Métodos:
  - `agregarItem(Item item, int cantidad)` → añade un artículo con la cantidad indicada.
  - `removerItem(Item item)` → elimina un artículo, lanza excepción si no existe.
  - `calcularTotal()` → retorna el total del carrito.
  - `imprimirDetalle()` → imprime los artículos con su cantidad y el total.
- Constantes para personalización: símbolo de moneda, cabecera de listado.

### Main.java
- Programa principal que instancia el carrito, agrega artículos y muestra el detalle.
- Incluye manejo de excepciones al remover items no existentes.

---

## 💻 Ejemplo de uso

```java
public class Main {
    public static void main(String[] args) {
        CarritoDeCompras carrito = new CarritoDeCompras();

        Item camiseta = new Item("Camiseta", 20.99);
        Item pantalon = new Item("Pantalones", 34.99);

        carrito.agregarItem(camiseta, 2);
        carrito.agregarItem(pantalon, 1);

        carrito.imprimirDetalle();

        // Ejemplo de manejo de excepción
        try {
            carrito.removerItem(new Item("Zapatos", 50));
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

Detalles del carrito de compras:
Camiseta - €20.99 x2
Pantalones - €34.99 x1
Total: €76.97
Error: El item no existe en el carrito.

