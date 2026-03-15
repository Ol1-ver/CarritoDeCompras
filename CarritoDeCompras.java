import java.util.HashMap;
import java.util.Map;

/**
 * Representa un carrito de compras que contiene varios Items y sus cantidades.
 */
public class CarritoDeCompras {

    // Constantes
    private static final String SIMBOLO_MONEDA = "€";
    private static final String CABECERA_DETALLE = "Detalles del carrito de compras:";

    // Mapa de items y sus cantidades
    private Map<Item, Integer> items;

    /**
     * Constructor del carrito de compras.
     */
    public CarritoDeCompras() {
        this.items = new HashMap<>();
    }

    /**
     * Agrega un ítem al carrito.
     * 
     * @param item Item a agregar.
     * @param cantidad Cantidad a agregar.
     * @throws IllegalArgumentException si cantidad <= 0
     */
    public void agregarItem(Item item, int cantidad) {
        if(cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor que cero.");
        }
        items.put(item, items.getOrDefault(item, 0) + cantidad);
    }

    /**
     * Remueve un ítem del carrito.
     * 
     * @param item Item a remover.
     * @throws IllegalArgumentException si el item no existe en el carrito.
     */
    public void removerItem(Item item) {
        if(!items.containsKey(item)) {
            throw new IllegalArgumentException("El item no existe en el carrito.");
        }
        items.remove(item);
    }

    /**
     * Calcula el total del carrito.
     * 
     * @return Total del carrito.
     */
    public double calcularTotal() {
        double total = 0;
        for(Map.Entry<Item, Integer> entry : items.entrySet()) {
            total += entry.getKey().getPrecio() * entry.getValue();
        }
        return total;
    }

    /**
     * Imprime el detalle completo del carrito.
     */
    public void imprimirDetalle() {
        System.out.println(CABECERA_DETALLE);
        for(Map.Entry<Item, Integer> entry : items.entrySet()) {
            System.out.println(entry.getKey() + " x" + entry.getValue());
        }
        System.out.println("Total: " + SIMBOLO_MONEDA + calcularTotal());
    }
}