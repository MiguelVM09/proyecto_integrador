package modelo;

public class Bebida extends Producto {

    private final int mililitros;

    public Bebida(String nombre, double precio, int mililitros) {
        super(nombre, precio);
        if (mililitros <= 0) {
            throw new IllegalArgumentException("El tamaño de la bebida debe ser mayor que cero.");
        }
        this.mililitros = mililitros;
    }

    public int getMililitros() {
        return mililitros;
    }

    @Override
    public String getTipo() {
        return "Bebida";
    }

    @Override
    public String descripcion() {
        return super.descripcion() + " [" + mililitros + " ml]";
    }
}
