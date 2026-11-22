package modelo;

public final class ReglasDescuento {

    private ReglasDescuento() {
    }

    public static final ReglaDescuento SIN_DESCUENTO = total -> total;

    public static final ReglaDescuento QUINCE_POR_CIENTO_SOBRE_10 =
            total -> total > 10 ? total * (1 - 0.15) : total;

    public static ReglaDescuento porcentajeDesde(double umbral, double porcentaje) {
        return total -> total > umbral ? total * (1 - porcentaje / 100.0) : total;
    }
}
