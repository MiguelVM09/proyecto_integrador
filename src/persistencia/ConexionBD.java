package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionBD {

    private static final String URL_POR_DEFECTO = "jdbc:sqlite:descuentos.db";

    private final String url;

    public ConexionBD() {
        this(URL_POR_DEFECTO);
    }

    public ConexionBD(String url) {
        this.url = url;
    }

    public String probarConexion() {
        try (Connection conexion = DriverManager.getConnection(url);
             Statement consulta = conexion.createStatement();
             ResultSet resultado = consulta.executeQuery("SELECT sqlite_version()")) {

            if (resultado.next()) {
                return "Conexión exitosa a SQLite (versión " + resultado.getString(1) + ").";
            }
            return "Conexión exitosa, pero la consulta no devolvió resultados.";

        } catch (SQLException e) {
            return "ERROR de conexión a la base de datos: " + e.getMessage();
        }
    }
}
