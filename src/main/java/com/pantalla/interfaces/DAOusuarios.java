/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.pantalla.interfaces;

import com.pantalla.modelos.log;
import java.util.List;

/**
 *
 * @author Isaac
 */
public interface DAOusuarios {
    
    public void registrar(log user) throws Exception;
       public void modificar(log user) throws Exception;
       public void eliminar(log user) throws Exception;
       public  List<log> listar() throws Exception;
       log obtenerUsuarioPorNombre(String nombreUsuario) throws Exception;
       log obtenerUsuarioPorUsuarioyContraseña(String nombreUsuario, String contrasena) throws Exception;
}
