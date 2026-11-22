package modelo;

import java.util.List;
import java.util.Objects;

public class ServicioDescuento {

    private final ReglaDescuento regla;

    public ServicioDescuento(ReglaDescuento regla) {
        this.regla = Objects.requireNonNull(regla, "La regla de descuento no puede ser nula.");
    }

    public double calcularTotal(List<Producto> productos) {
        double total = 0;
        for (Producto p : productos) {
            total += p.getPrecio();
        }
        return total;
    }

    public double calcularMontoFinal(double total) {
        if (total < 0) {
            throw new IllegalArgumentException("El monto no puede ser negativo.");
        }
        return regla.aplicar(total);
    }

    public double calcularDescuento(double total) {
        return total - calcularMontoFinal(total);
    }
}
