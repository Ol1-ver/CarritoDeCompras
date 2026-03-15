/**
 * Representa un artículo o producto que puede ser agregado a un carrito de compras.
 */
public class Item {
    private String nombre;
    private double precio;

    // Constantes
    public static final double PRECIO_MAXIMO = 10000.0; // ejemplo de límite superior
    public static final double PRECIO_MINIMO = 0.0;

    /**
     * Constructor de un Item.
     * 
     * @param nombre Nombre del artículo.
     * @param precio Precio del artículo, debe estar entre PRECIO_MINIMO y PRECIO_MAXIMO.
     * @throws IllegalArgumentException si el precio es inválido.
     */
    public Item(String nombre, double precio) {
        this.nombre = nombre;
        setPrecio(precio);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if(nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre del artículo no puede estar vacío.");
        }
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        if(precio < PRECIO_MINIMO || precio > PRECIO_MAXIMO) {
            throw new IllegalArgumentException("Precio inválido: debe estar entre " + PRECIO_MINIMO + " y " + PRECIO_MAXIMO);
        }
        this.precio = precio;
    }

    @Override
    public String toString() {
        return nombre + " - €" + precio;
    }
}
