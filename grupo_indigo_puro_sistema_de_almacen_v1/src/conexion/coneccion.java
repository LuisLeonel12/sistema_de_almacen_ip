package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class coneccion {

	public static void main(String[] args) {
		
	String url = "jdbc:mysql://localhost:3306/tu_basededatos";
	String usuario = "tu_usuario";
	String contraseña = "tu_contraseña";
	
	try {
	    Connection conexion = DriverManager.getConnection(url, usuario, contraseña);
	    // Realiza operaciones en la base de datos aquí
	    
	    // No olvides cerrar la conexión cuando hayas terminado
	    conexion.close();
	} catch (SQLException e) {
	    e.printStackTrace();
	}

	}

}
