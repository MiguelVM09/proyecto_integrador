package modelo;

public class Comida extends Producto {

    private final int calorias;

    public Comida(String nombre, double precio, int calorias) {
        super(nombre, precio);
        if (calorias < 0) {
            throw new IllegalArgumentException("Las calorías no pueden ser negativas.");
        }
        this.calorias = calorias;
    }

    public int getCalorias() {
        return calorias;
    }

    @Override
    public String getTipo() {
        return "Comida";
    }

    @Override
    public String descripcion() {
        return super.descripcion() + " [" + calorias + " kcal]";
    }
}
