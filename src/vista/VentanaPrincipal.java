package vista;

import modelo.ServicioDescuento;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.util.Locale;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class VentanaPrincipal extends JFrame {

    private final ServicioDescuento servicio;
    private final JTextField campoMonto = new JTextField(10);
    private final JButton botonCalcular = new JButton("Calcular Descuento");
    private final JTextArea areaResultado = new JTextArea(10, 40);

    public VentanaPrincipal(ServicioDescuento servicio, String mensajeConexion) {
        super("Calculadora de descuentos");
        this.servicio = servicio;
        construirInterfaz();
        areaResultado.setText(mensajeConexion + "\n\nIngrese un monto y presione \"Calcular Descuento\".\n");
        configurarEventos();
    }

    private void construirInterfaz() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));

        JPanel panelSuperior = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 0));
        panelSuperior.add(new JLabel("Monto total ($):"));
        panelSuperior.add(campoMonto);
        panelSuperior.add(botonCalcular);

        areaResultado.setEditable(false);
        areaResultado.setLineWrap(true);
        areaResultado.setWrapStyleWord(true);

        panel.add(panelSuperior, BorderLayout.NORTH);
        panel.add(new JScrollPane(areaResultado), BorderLayout.CENTER);

        setContentPane(panel);
        pack();
        setLocationRelativeTo(null);
    }

    private void configurarEventos() {
        botonCalcular.addActionListener(this::alPresionarCalcular);
        campoMonto.addActionListener(this::alPresionarCalcular);
    }

    private void alPresionarCalcular(ActionEvent evento) {
        String texto = campoMonto.getText().trim().replace(',', '.');
        try {
            double monto = Double.parseDouble(texto);
            double montoFinal = servicio.calcularMontoFinal(monto);
            double descuento = monto - montoFinal;

            areaResultado.append(String.format(Locale.US,
                    "%nMonto ingresado: $%.2f%nDescuento aplicado: $%.2f%nMonto final: $%.2f%n",
                    monto, descuento, montoFinal));
        } catch (NumberFormatException e) {
            areaResultado.append("\nError: \"" + campoMonto.getText() + "\" no es un número válido.\n");
        } catch (IllegalArgumentException e) {
            areaResultado.append("\nError: " + e.getMessage() + "\n");
        }
        areaResultado.setCaretPosition(areaResultado.getDocument().getLength());
    }
}
