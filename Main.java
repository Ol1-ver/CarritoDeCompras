/**
 * Programa principal para probar el carrito de compras.
 */
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