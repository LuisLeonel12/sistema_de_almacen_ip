package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Conexion {

	//para comprobar la coneccion se crea un objeto de la clase coneccion
	//y se llama a la clase conectar con la variable con    
	/*Conexion con = new Conexion();
	con.Conectar();*/
	    
	 private static Connection con;
	 static final String URL = "jdbc:mysql://localhost:3306/grupo_indigo_puro_almacen_db";
	 static final String USER = "root";
	 static final String PASS = "MAGODEOZ";
	 
	
	 public Connection Conectar(){
	     con = null;
	     
	     try {
	         con=(Connection)DriverManager.getConnection(URL,USER,PASS);
	         
	         if(con != null){
	             //MENSAJE QUE SE ENCARGA DE COMPROBRAR SI LA CONEXION ESTA LISTA
	        	 //JOptionPane.showMessageDialog(null,"conexion lista");
	         }
	         
	     } catch (SQLException e) {
	         System.out.println("Error"+e.toString());
	     }
	     return con;
	 }
	
	 public static void main(String[] args) {
		 Conexion con = new Conexion();
		 con.Conectar();
		 }
		
	}

