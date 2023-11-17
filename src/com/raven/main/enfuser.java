/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Ron.Arc.Evx
 */
public class enfuser {
     private Connection connection;

    public enfuser(Connection connection) {
        this.connection = connection;
    }

    public void insertenf(String nombre, String cargo, String passwordd, String fechaext) {
        String query = "INSERT INTO enfermeralogin(Nombre, cargo, passwordd, Fechaext) VALUES (?, ?, ?, ?)";
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, nombre);
            preparedStatement.setString(2, cargo);
            preparedStatement.setString(3, passwordd);
            preparedStatement.setString(4, fechaext);
            
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    } 
    
}
