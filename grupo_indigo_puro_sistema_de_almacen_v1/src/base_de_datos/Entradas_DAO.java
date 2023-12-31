package base_de_datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexion.Conexion;

public class Entradas_DAO {

	//variables
    String sql;
    //Statement st;
    PreparedStatement ps;
    Conexion con = new Conexion();
    Connection Conexion = con.Conectar();
    ResultSet rs;
    //DefaultTableModel modelo = new DefaultTableModel();



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


    public List<Entradas> Listar_registro_entradas(){
        List<Entradas> listae = new ArrayList<>();
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




    public boolean actualizarEntradaTela(Entradas e) {
        String sql = "UPDATE registro_de_entradas_de_tela SET codigo_rollo=?, nombre_tela=?, proveedor=?, peso=?, caracteristicas=? WHERE id=?";

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


    public boolean eliminarEntradaTela(int id) {
        String sql = "DELETE FROM registro_de_entradas_de_tela WHERE id=?";

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
