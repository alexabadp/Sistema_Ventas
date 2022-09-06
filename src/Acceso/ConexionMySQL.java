package Acceso;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionMySQL {

    public static Connection MyConexion() {
        Connection cn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection("jdbc:mysql://localhost/dbVentas", "root", "");
            System.out.println("Se conectó");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("No se conectó");
        }
        return cn;
    }

}
