package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {

    private static Connection con;
    static final String URL = "jdbc:mysql://localhost:3306/grupo_indigo_puro_almacen_db";
    static final String USER = "root";
    static final String PASS = "MAGODEOZ";

    public Connection Conectar() {
        con = null;

        try {
            con = (Connection) DriverManager.getConnection(URL, USER, PASS);

            if (con != null) {
                //MENSAJE QUE SE ENCARGA DE COMPROBAR SI LA CONEXION ESTA LISTA
                //JOptionPane.showMessageDialog(null,"conexion lista");
            }

        } catch (SQLException e) {
            System.out.println("Error" + e.toString());
        }
        return con;
    }

    public void cerrarConexion() {
        try {
            if (con != null && !con.isClosed()) {
                con.close();
                System.out.println("Conexión cerrada.");
            }
        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexión: " + e.toString());
        }
    }

    public static void main(String[] args) {
        Conexion con = new Conexion();
        con.Conectar();
        
        // CERRAR LA CONEXION AL FINALIZAR
        con.cerrarConexion();
    	}
	
  	}

