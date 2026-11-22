package app;

import modelo.Bebida;
import modelo.Comida;
import modelo.Producto;
import modelo.ReglasDescuento;
import modelo.ServicioDescuento;
import persistencia.ConexionBD;
import vista.VentanaPrincipal;

import java.util.List;
import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {
        List<Producto> catalogo = List.of(
                new Bebida("Café americano", 3.50, 250),
                new Bebida("Jugo de naranja", 4.00, 300),
                new Comida("Sándwich de pollo", 6.50, 420));
        for (Producto p : catalogo) {
            System.out.println(p.descripcion());
        }

        ServicioDescuento servicio = new ServicioDescuento(ReglasDescuento.QUINCE_POR_CIENTO_SOBRE_10);
        System.out.println("Total del catálogo: $" + servicio.calcularTotal(catalogo));

        String mensajeConexion = new ConexionBD().probarConexion();

        SwingUtilities.invokeLater(() ->
                new VentanaPrincipal(servicio, mensajeConexion).setVisible(true));
    }
}
