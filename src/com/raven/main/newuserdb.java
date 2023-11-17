

package com.raven.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class newuserdb {
    private Connection connection;

    public newuserdb(Connection connection) {
        this.connection = connection;
    }

    public void insertMedico(String nombre, String especialidad, String passwordd, String fechaext) {
        String query = "INSERT INTO Medicologin (Nombre, Especialidad, passwordd, Fechaext) VALUES (?, ?, ?, ?)";
        
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