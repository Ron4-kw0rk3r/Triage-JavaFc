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
public class adminUser {
    
    
    private Connection connection;
    //private medicadd ;
    public adminUser(Connection connection) {
        this.connection = connection;
    }

    public void insertMedico(String nombre, String especialidad, String passwordd, String fechaext) {
        String query = "INSERT INTO medicologin(Nombre, Especialidad, passwordd, Fechaext) VALUES (?, ?, ?, ?)";
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, nombre);
            preparedStatement.setString(2, especialidad);
            preparedStatement.setString(3, passwordd);
            preparedStatement.setString(4, fechaext);
            
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    } 
    
}
