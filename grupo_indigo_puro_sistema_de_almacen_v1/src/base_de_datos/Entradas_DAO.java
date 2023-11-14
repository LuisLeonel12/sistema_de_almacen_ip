package base_de_datos;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Entradas_DAO {

	//variables
    String sql;
    //Statement st;
    PreparedStatement ps;
    Conexion con = new Conexion();
    Connection Conexion = con.Conectar();
    ResultSet rs;
    //DefaultTableModel modelo = new DefaultTableModel();
    
    
    //realizando la insercion de los datos a la tabla por medio de un procedimiento almacenado
    public boolean registro_de_entradas_de_tela(Entradas e){
        sql = "INSERT INTO registro_de_entradas_de_tela(codigo_rollo,nombre_tela,proveedor,peso,caracteristicas,fecha_entrada,hora_entrada)  VALUES (?,?,?,?,?,?,?)";
        
        try {
            ps = Conexion.prepareStatement(sql);
            ps.setString(1,e.getCodigo_Rollo());
            ps.setString(2,e.getNombre_Tela());
            ps.setString(3,e.getProveedor());
            ps.setString(4,e.getPeso());
            ps.setString(5,e.getCaracteristicas());
            ps.setString(6,e.getFecha_Entrada());
            ps.setString(7,e.getHora_de_Entrada());
            ps.execute();
            return true;
        } catch (SQLException e1) {
            System.out.println(e1.toString());
            return false;
        }
    
    }
    
	
}
