package modelo;

@FunctionalInterface
public interface ReglaDescuento {

    double aplicar(double total);
}
