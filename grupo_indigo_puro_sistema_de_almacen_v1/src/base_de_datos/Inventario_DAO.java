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
    PreparedStatement ps;
    Conexion con = new Conexion();
    Connection Conexion = con.Conectar();
    ResultSet rs;


    // INSERTAR DATOS A LA TABLA GENERAL
    public boolean Insertar_Inventario_General(Inventario in) {
        String sql = "INSERT INTO grupo_indigo_puro_almacen_db.inventario_general " +
                     "(codigo_rollo,nombre_tela,proveedor,peso_total,metros,estilo,ancho,caracteristicas,ubicacion,fecha_entrada,hora_entrada) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ? ,? , ?, ?,?)";

        try (PreparedStatement ps = Conexion.prepareStatement(sql)) {
            ps.setString(1, in.getCodigo_Rollo());
            ps.setString(2, in.getNombre_Tela());
            ps.setString(3, in.getProveedor());
            ps.setString(4, in.getPeso_total());
            ps.setDouble(5, in.getMetros());
            ps.setString(6, in.getEstilo());
            ps.setString(7, in.getAncho());
            ps.setString(8, in.getCaracteristicas());
            ps.setString(9, in.getUbicacion());
            ps.setString(10, in.getFecha_Entrada());
            ps.setString(11, in.getHora_de_Entrada());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
    }


    public List<Inventario> Listar_Inventario_General() {
        List<Inventario> listai = new ArrayList<>();
        String sql = "SELECT * FROM inventario_general";

        try (Connection Conexion = con.Conectar();
             PreparedStatement ps = Conexion.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Inventario i = new Inventario();
                i.setId(rs.getInt("Id"));
                i.setCodigo_Rollo(rs.getString("Codigo_Rollo"));
                i.setNombre_Tela(rs.getString("Nombre_Tela"));
                i.setProveedor(rs.getString("Proveedor"));
                i.setPeso_total(rs.getString("Peso_Total"));
                i.setMetros(Double.parseDouble(rs.getString("Metros")));
                i.setEstilo(rs.getString("Estilo"));
                i.setAncho(rs.getString("Ancho"));
                i.setCaracteristicas(rs.getString("Caracteristicas"));
                i.setUbicacion(rs.getString("Ubicacion"));
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
    public boolean Actualizar_Inventario_General(Inventario i) {
        String sql = "UPDATE inventario_general SET codigo_rollo=?, nombre_tela=?, proveedor=?, peso_total=?, metros=?, estilo=?, ancho=?, caracteristicas=?, ubicacion=? WHERE id=?";

        try (PreparedStatement ps = Conexion.prepareStatement(sql)) {
            ps.setString(1, i.getCodigo_Rollo());
            ps.setString(2, i.getNombre_Tela());
            ps.setString(3, i.getProveedor());
            ps.setString(4, i.getPeso_total());
            ps.setDouble(5, i.getMetros());
            ps.setString(6, i.getEstilo());
            ps.setString(7, i.getAncho());
            ps.setString(8, i.getCaracteristicas());
            ps.setString(9, i.getUbicacion());
            ps.setInt(10, i.getId());

            int filasActualizadas = ps.executeUpdate();

            return filasActualizadas > 0;
        } catch (SQLException ex) {
            System.out.println("Error al actualizar la entrada de tela: " + ex.toString());
            return false;
        }
    }


    //ELIMINAR DATOS DE LA TABLA POR MEIO DEL ID
    public boolean Eliminar_Inventario_General(int id) {
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



    public Inventario Buscar_Rollo(String cod) {
        Inventario i = new Inventario();

        String sql = "SELECT * FROM inventario_general WHERE codigo_rollo = ?";

        try (PreparedStatement ps = Conexion.prepareStatement(sql)) {
            ps.setString(1, cod);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    i.setNombre_Tela(rs.getString("nombre_tela"));
                    i.setMetros(Double.parseDouble(rs.getString("metros")));
                    i.setAncho(rs.getString("ancho"));
                    i.setCaracteristicas(rs.getString("caracteristicas"));
                    i.setPeso_total(rs.getString("peso_total"));
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error al buscar el rollo en el inventario: " + ex.toString());
        }

        return i;
    }    
    
    // Método modificado para recuperar todos los registros con el mismo nombre de rollo
    public List<Inventario> Buscar_Rollo_Nombre(String nom) {
        List<Inventario> inventarios = new ArrayList<>();

        String sql = "SELECT * FROM inventario_general WHERE nombre_tela = ?";

        try (PreparedStatement ps = Conexion.prepareStatement(sql)) {
            ps.setString(1, nom);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Inventario i = new Inventario();
                    i.setNombre_Tela(rs.getString("nombre_tela"));
                    i.setCodigo_Rollo(rs.getString("codigo_rollo"));
                    i.setProveedor(rs.getString("proveedor"));
                    i.setPeso_total(rs.getString("peso_total"));
                    i.setMetros(Double.parseDouble(rs.getString("metros")));
                    i.setAncho(rs.getString("ancho"));
                    i.setCaracteristicas(rs.getString("caracteristicas"));
                    i.setEstilo(rs.getString("estilo"));
                    i.setUbicacion(rs.getString("ubicacion"));
                    i.setFecha_Entrada(rs.getString("Fecha_Entrada"));

                    inventarios.add(i);
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error al buscar el rollo en el inventario: " + ex.toString());
        }

        return inventarios;
    }


    public boolean codigoRolloExiste(String Rollo) {
        String sql = "SELECT COUNT(*) FROM inventario_general WHERE codigo_rollo = ?";
        try {
            ps = Conexion.prepareStatement(sql);
            ps.setString(1, Rollo);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return false;
    }


    public boolean Actualizar_Metros(Double met_sol, String cod) {
        sql = "UPDATE inventario_general SET metros=? WHERE codigo_rollo=?";

        try {
            ps = Conexion.prepareStatement(sql);
            ps.setDouble(1, met_sol);
            ps.setString(2, cod);
            ps.execute();

            ps.close();

            return true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
