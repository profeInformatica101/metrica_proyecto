/*
 * DAOUsusarios.
 * Operaciones de acceso a datos para la entidad Usuario
 */
package bbdd;

import entidades.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author SGame
 */
public class DAOUsuarios {
    
    public Usuario buscarPorId(String id) {
        Usuario user = null;
        Connection conn = null;
        try {
            conn = Conexion.conectarBD();
            PreparedStatement ps = conn.prepareStatement("select * from usuario where id = ?");
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user = new Usuario(id, rs.getString("password"), rs.getString("nombre"), rs.getBoolean("esAdmin"));
            }
        } catch (SQLException e) {
            System.err.println("buscarPorId: " + e.getMessage());
        } finally {
            Conexion.desconectarBD(conn);
        }
        return user;
    }
    
    public Usuario buscarPorNombre(String nombre) {
        Usuario user = null;
        Connection conn = null;
        try {
            conn = Conexion.conectarBD();
            System.out.println("Conexion:" + conn);
            PreparedStatement ps = conn.prepareStatement("select * from usuario where nombre = ?");
            ps.setString(1, nombre);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                System.out.println(rs.getString("id") + rs.getString("password") + rs.getString("nombre") + rs.getBoolean("es_admin"));
                user = new Usuario(rs.getString("id"), rs.getString("password"), rs.getString("nombre"), rs.getBoolean("es_admin"));
            }
        } catch (SQLException e) {
            System.err.println("buscarPorNombre: " + e.getMessage());
        } finally {
            Conexion.desconectarBD(conn);
        }
        return user;
    }
    
    public void insertarUsuario(Usuario user) {
        Connection conn = null;
        try {
            conn = Conexion.conectarBD();
            PreparedStatement ps = conn.prepareStatement("insert into usuario values(?, ?, ?, ?)");
            ps.setString(1, user.getId());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getNombre());
            ps.setBoolean(4, user.isEsAdmin());
            ps.execute();
        } catch (SQLException e) {
            System.err.println("insertarUsuario: " + e.getMessage());
        } finally {
            Conexion.desconectarBD(conn);
        }
    }
    
    public List<Usuario> consultarUsuarios() {
        Connection conn = null;
        List<Usuario> usuarios = new ArrayList();
        try {
            conn = Conexion.conectarBD();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from usuarios");
            while (rs.next()) {
                Usuario user = new Usuario(rs.getString("id"), rs.getString("password"), rs.getString("nombre"), rs.getBoolean("esAdmin"));
                usuarios.add(user);
            }
        } catch (SQLException e) {
            System.err.println("consultarUsuarios: " + e.getMessage());
        } finally {
            Conexion.desconectarBD(conn);
        }
        return usuarios;
    }
}
