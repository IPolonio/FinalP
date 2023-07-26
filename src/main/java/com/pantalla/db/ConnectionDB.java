/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pantalla.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Isaac
 */
public class ConnectionDB {
    
    protected Connection conexion;
    private final String JDBC_driver ="com.mysql.cj.jdbc.Driver";
    private final String Url = "jdbc:mysql://localhost:3306/hola"; // Corregir la URL
    
    private final String user = "root";
    private final String contraseña = "root";
    
    
    public void conectar(){
    
        try {
            conexion = DriverManager.getConnection(Url,user,contraseña);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        try {
            Class.forName(JDBC_driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    public void cerrar() throws SQLException {
        if (conexion != null) {
            if (!conexion.isClosed()) {
                conexion.close();
            }
        }
    }
}

    
    
    
    
    
    
    
    
    
    
    
    

