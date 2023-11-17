package base_de_datos;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.mysql.cj.jdbc.CallableStatement;

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
    
    
    public List Listar_registro_entradas(){
        List<Entradas> listae = new ArrayList();
        sql = "SELECT * FROM registro_de_entradas_de_tela";
        
          try {
              ps = Conexion.prepareStatement(sql);
              rs = ps.executeQuery();
              
              while (rs.next()) {
              
            	  Entradas e = new Entradas();
                  e.setId(rs.getInt("Id"));
                  e.setCodigo_Rollo(rs.getString("Codigo_Rollo"));
                  e.setNombre_Tela(rs.getString("Nombre_Tela"));
                  e.setProveedor(rs.getString("Proveedor"));
                  e.setPeso(rs.getString("Peso"));
              	  e.setCaracteristicas(rs.getString("Caracteristicas"));
              	  e.setFecha_Entrada(rs.getString("Fecha_Entrada"));
              	  e.setHora_de_Entrada(rs.getString("Hora_Entrada"));
                  listae.add(e);
              }
              
          } catch (SQLException e) {
              System.out.println(e.toString());
          }
        return listae;
          }
    
    
    
//           public void Update_Sp(JTextField txt_id,JTextField txt_codigo_rollo ,JTextField txt_nombre_tela , JTextField txt_proveedor , JTextField txt_peso
//            , JTextField txt_caracteristicas, JLabel lbl_fecha, JLabel lbl_hora ){
//
//			try {
//			
//			CallableStatement modificar = (CallableStatement) Conexion.prepareCall("CALL actualizar_datos(?,?,?,?,?,?,?,?);");
//			
//			modificar.setInt(1,Integer.parseInt(txt_id.getText()));
//			modificar.setString(2, txt_codigo_rollo.getText());
//			modificar.setString(3, txt_nombre_tela.getText());
//			modificar.setString(4, txt_proveedor.getText());
//			modificar.setString(5, txt_peso.getText());
//			modificar.setString(6, txt_caracteristicas.getText());
//			modificar.setString(7, lbl_fecha.getText());
//			modificar.setString(8, lbl_hora.getText());
//			
//			modificar.execute();
//			
//			} catch (SQLException e) {
//			System.out.println(e.toString());
//			}
//    
//           }
    
    			
    public boolean Actualizar_Registro_Entradas(Entradas e) {
        String sql = "UPDATE registro_de_entradas_de_tela " +
                     "SET codigo_rollo = ?, " +
                     "nombre_tela = ?, " +
                     "proveedor = ?, " +
                     "peso = ?, " +
                     "caracteristicas = ?, " +
                     "fecha_entrada = ?, " +
                     "hora_entrada = ? " +
                     "WHERE id = ?";
        try {
            ps = Conexion.prepareStatement(sql);
            ps.setString(1, e.getCodigo_Rollo());
            ps.setString(2, e.getNombre_Tela());
            ps.setString(3, e.getProveedor());
            ps.setString(4, e.getPeso());
            ps.setString(5, e.getCaracteristicas());
            ps.setString(6, e.getFecha_Entrada());
            ps.setString(7, e.getHora_de_Entrada());
            ps.setInt(8, e.getId());  // Asegúrate de tener un método getId() en tu clase Entradas
            ps.executeUpdate();
            return true;
        } catch (SQLException e1) {
            e1.printStackTrace();
            return false;
        }
    }
    
	
}
