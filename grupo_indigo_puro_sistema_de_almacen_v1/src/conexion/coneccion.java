package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class coneccion {

	
	public static void main(String[] args) {
	
		Connection conexion = obtenerConexion();
        if (conexion != null) {
            System.out.println("Conexión exitosa");
            cerrarConexion(conexion);
        }
		
	}
	
	
	private static final String URL = "jdbc:mysql://localhost:3306/grupo_indigo_puro_almacen_db";
    private static final String USUARIO = "root";
    private static final String CONTRASENA = "MAGODEOZ";

    public static Connection obtenerConexion() {
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");

            return DriverManager.getConnection(URL, USUARIO, CONTRASENA);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error al conectar a la base de datos", e);
        }
    }

    public static void cerrarConexion(Connection conexion) {
        try {
            if (conexion != null && !conexion.isClosed()) {
                conexion.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
}

