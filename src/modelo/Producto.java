package modelo;

import java.util.Locale;

public abstract class Producto {

    private final String nombre;
    private final double precio;

    protected Producto(String nombre, double precio) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre del producto no puede estar vacío.");
        }
        if (precio < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo.");
        }
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public abstract String getTipo();

    public String descripcion() {
        return String.format(Locale.US, "%s - %s ($%.2f)", getTipo(), nombre, precio);
    }
}
