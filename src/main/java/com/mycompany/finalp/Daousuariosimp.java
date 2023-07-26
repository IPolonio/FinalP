/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.finalp;

import com.pantalla.db.ConnectionDB;
import com.pantalla.interfaces.DAOusuarios;
import com.pantalla.modelos.log;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Isaac
 */
public class Daousuariosimp extends ConnectionDB implements DAOusuarios {

    // ...

    @Override
public void registrar(log user) throws Exception {
    try {
        this.conectar();

        // Verificar si el usuario ya existe
        if (existeUsuario(user.getUsuario())) {
            throw new Exception("El usuario ya está registrado");
        }

        // Insertar el nuevo usuario en la base de datos
        PreparedStatement st = this.conexion.prepareStatement("INSERT INTO log (nombre,apellido,Telefono,Correo,usuario,contraseña) VALUES (?,?,?,?,?,?);");
        st.setString(1, user.getNombre());
        st.setString(2, user.getApellido());
        st.setString(3, user.getTelefono());
        st.setString(4, user.getCorreo());
        st.setString(5, user.getUsuario());
        st.setString(6, user.getPassw());
        st.executeUpdate();
        st.close();
    } catch (SQLException e) {
        throw e;
    } finally {
        // No cerrar la conexión aquí, asegúrate de que siga abierta
    }
}

// Método para verificar si el usuario ya existe en la base de datos
private boolean existeUsuario(String nombreUsuario) throws Exception {
    try {
      
        PreparedStatement st = this.conexion.prepareStatement("SELECT COUNT(*) FROM log WHERE usuario = ?");
        st.setString(1, nombreUsuario);
        ResultSet rs = st.executeQuery();
        rs.next();
        int count = rs.getInt(1);
        rs.close();
        st.close();
        return count > 0;
    } catch (SQLException e) {
        throw e;
    } finally {
      
    }
}



    


    @Override
    public void modificar(log user) throws Exception {
         try {
        this.conectar();
    PreparedStatement st = this.conexion.prepareStatement("UPDATE log SET apellido=?, Telefono=?, Correo=?, usuario=?, contraseña=? WHERE nombre=?");
    
st.setString(1, user.getApellido());
st.setString(2, user.getTelefono());
st.setString(3, user.getCorreo());
st.setString(4, user.getUsuario());
st.setString(5, user.getPassw());
st.setString(6, user.getNombre());
st.executeUpdate();

    } catch (SQLException e) {
        throw e;
    } finally {
        this.cerrar();
    }
}
    
    

    @Override
    public void eliminar(log user) throws Exception {
        try {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement("DELETE FROM log WHERE nombre = ?");
            st.setString(1, user.getNombre());
            st.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.cerrar();
        }
    }
 // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    

    @Override
    public List<log> listar() throws Exception {
    List<log> lista = new ArrayList<>(); // Inicializar la lista aquí

    try {
        this.conectar();
        PreparedStatement st = this.conexion.prepareStatement("SELECT * FROM log;");

        try (ResultSet rs = st.executeQuery()) {
            while (rs.next()) {
                log user = new log();
                user.setNombre(rs.getString("nombre"));
                user.setApellido(rs.getString("apellido"));
                user.setCorreo(rs.getString("Correo"));
                user.setUsuario(rs.getString("usuario"));
                user.setTelefono(rs.getString("Telefono"));
                lista.add(user);
            }
        }
    } catch (SQLException e) {
        throw new Exception("Error al obtener la lista de usuarios: " + e.getMessage());
    } finally {
        this.cerrar();
    }

    return lista;
}

    @Override
    public log obtenerUsuarioPorNombre(String nombreUsuario) throws Exception {
    log usuario = null;
    try {
        this.conectar();
        PreparedStatement st = this.conexion.prepareStatement("SELECT * FROM log WHERE nombre = ?");
        st.setString(1, nombreUsuario);
        ResultSet rs = st.executeQuery();
        if (rs.next()) {
            usuario = new log();
            usuario.setNombre(rs.getString("nombre"));
            usuario.setApellido(rs.getString("apellido"));
            usuario.setTelefono(rs.getString("Telefono"));
            usuario.setCorreo(rs.getString("Correo"));
            usuario.setUsuario(rs.getString("usuario"));
        }
        rs.close();
        st.close();
    } catch (SQLException e) {
        throw e;
    } finally {
        this.cerrar();
    }
    return usuario;
        
        
        
    }  

    @Override
    public log obtenerUsuarioPorUsuarioyContraseña(String usuario, String contrasena) throws Exception {
        
    log usuarioEncontrado = null;
    try {
        this.conectar();
        PreparedStatement st = this.conexion.prepareStatement("SELECT * FROM log WHERE usuario = ? AND contraseña = ?");
        st.setString(1, usuario);
        st.setString(2, contrasena);
        ResultSet rs = st.executeQuery();
        if (rs.next()) {
            usuarioEncontrado = new log();
            usuarioEncontrado.setNombre(rs.getString("nombre"));
            usuarioEncontrado.setApellido(rs.getString("apellido"));
            usuarioEncontrado.setTelefono(rs.getString("Telefono"));
            usuarioEncontrado.setCorreo(rs.getString("Correo"));
            usuarioEncontrado.setUsuario(rs.getString("usuario"));
            usuarioEncontrado.setPassw(rs.getString("contraseña"));
        }
        rs.close();
        st.close();
    } catch (SQLException e) {
        throw e;
    } finally {
        this.cerrar();
    }
    return usuarioEncontrado;
}
  



    }

    
    
    

