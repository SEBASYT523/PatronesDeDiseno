import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * ANTIPATRÓN: instanciación directa de clases concretas + condicionales por variante.
 * Versión Java del fragmento del informe. Compila con el JDK (java.sql);
 * para ejecutarlo harían falta los drivers de cada motor en el classpath.
 */
public class UsuarioDAO {

    static final String MOTOR = "postgres";   // cambiarlo obliga a revisar TODAS las funciones de abajo

    public static void guardarUsuario(String nombre, String correo) throws SQLException {
        Connection conexion;
        PreparedStatement sentencia;
        if (MOTOR.equals("postgres")) {
            conexion = DriverManager.getConnection("jdbc:postgresql://localhost:5432/app", "app", "...");
            sentencia = conexion.prepareStatement(
                "INSERT INTO usuarios (nombre, correo) VALUES (?, ?) RETURNING id");
        } else if (MOTOR.equals("sqlite")) {
            conexion = DriverManager.getConnection("jdbc:sqlite:app.db");
            sentencia = conexion.prepareStatement(
                "INSERT INTO usuarios (nombre, correo) VALUES (?, ?)");
        } else {
            throw new IllegalStateException("Motor no soportado: " + MOTOR);
        }
        sentencia.setString(1, nombre);
        sentencia.setString(2, correo);
        sentencia.execute();
        conexion.close();
    }

    public static List<String> listarUsuarios() throws SQLException {
        Connection conexion;
        if (MOTOR.equals("postgres")) {
            conexion = DriverManager.getConnection("jdbc:postgresql://localhost:5432/app", "app", "...");
        } else if (MOTOR.equals("sqlite")) {
            conexion = DriverManager.getConnection("jdbc:sqlite:app.db");
        } else {
            throw new IllegalStateException("Motor no soportado: " + MOTOR);
        }
        PreparedStatement sentencia = conexion.prepareStatement("SELECT nombre, correo FROM usuarios");
        ResultSet filas = sentencia.executeQuery();
        List<String> resultado = new ArrayList<>();
        while (filas.next()) {
            resultado.add(filas.getString("nombre") + " <" + filas.getString("correo") + ">");
        }
        conexion.close();
        return resultado;
    }

    // ... y el mismo bloque if/else se repite en actualizarUsuario, eliminarUsuario, etc.
}
