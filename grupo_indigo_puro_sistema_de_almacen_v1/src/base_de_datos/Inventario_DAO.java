package base_de_datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexion.Conexion;

public class Inventario_DAO {

	
	//variables
    String sql;
    //Statement st;
    PreparedStatement ps;
    Conexion con = new Conexion();
    Connection Conexion = con.Conectar();
    ResultSet rs;
    //DefaultTableModel modelo = new DefaultTableModel();
    
    //INSERTAR DATOS A LA TABLA GENERAL
    public boolean Insertar_Inventario_General(Inventario in) {
        String sql = "INSERT INTO grupo_indigo_puro_almacen_db.inventario_general " +
                     "(codigo_rollo, nombre_tela, proveedor, peso_total, caracteristicas, fecha_entrada, hora_entrada) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {
            ps = Conexion.prepareStatement(sql);
            ps.setString(1, in.getCodigo_Rollo());
            ps.setString(2, in.getNombre_Tela());
            ps.setString(3, in.getProveedor());
            ps.setString(4, in.getPeso_total());
            ps.setString(5, in.getCaracteristicas());
            ps.setString(6, in.getFecha_Entrada());
            ps.setString(7, in.getHora_de_Entrada());
            ps.execute();
            return true;
        } catch (SQLException e1) {
            System.out.println(e1.toString());
            return false;
        }
    }
        
    //LISTAR LOS DATOS DE LA TABLA INVENTARIO GENERAL
    public List Listar_Inventario_General(){
        List<Inventario> listai = new ArrayList();
        sql = "SELECT * FROM inventario_general";
        
          try {
              ps = Conexion.prepareStatement(sql);
              rs = ps.executeQuery();
              
              while (rs.next()) {
              
            	  Inventario i = new Inventario();
                  i.setId(rs.getInt("Id"));
                  i.setCodigo_Rollo(rs.getString("Codigo_Rollo"));
                  i.setNombre_Tela(rs.getString("Nombre_Tela"));
                  i.setProveedor(rs.getString("Proveedor"));
                  i.setPeso_total(rs.getString("Peso_Total"));
              	  i.setCaracteristicas(rs.getString("Caracteristicas"));
              	  i.setFecha_Entrada(rs.getString("Fecha_Entrada"));
              	  i.setHora_de_Entrada(rs.getString("Hora_Entrada"));
                  listai.add(i);
              }
              
          } catch (SQLException e) {
              System.out.println(e.toString());
          }
        return listai;
          }
    
    
    //ACTUALIAR UN VALOR DE LA TABLA POR MEDIO DEL UPDATE 
    public boolean actualizarEntradaTela(Entradas e) {
        String sql = "UPDATE grupo_indigo_puro_almacen_db.inventario_general " +
                     "SET codigo_rollo=?, nombre_tela=?, proveedor=?, peso_total=?, caracteristicas=? " +
                     "WHERE id=?";
        
        try (PreparedStatement ps = Conexion.prepareStatement(sql)) {
            ps.setString(1, e.getCodigo_Rollo());
            ps.setString(2, e.getNombre_Tela());
            ps.setString(3, e.getProveedor());
            ps.setString(4, e.getPeso());
            ps.setString(5, e.getCaracteristicas());
            ps.setInt(6, e.getId());
            
            int filasActualizadas = ps.executeUpdate();
            
            return filasActualizadas > 0;
        } catch (SQLException ex) {
            System.out.println("Error al actualizar la entrada de tela: " + ex.toString());
            return false;
        }
    }
    
    //ELIMINAR DATOS DE LA TABLA POR MEIO DEL ID
    public boolean eliminarEntradaTela(int id) {
        String sql = "DELETE FROM grupo_indigo_puro_almacen_db.inventario_general WHERE id=?";
        
        try (PreparedStatement ps = Conexion.prepareStatement(sql)) {
            ps.setInt(1, id);
            
            int filasEliminadas = ps.executeUpdate();
            
            return filasEliminadas > 0;
        } catch (SQLException ex) {
            System.out.println("Error al eliminar la entrada de tela: " + ex.toString());
            return false;
        }
    }
	
	
}
