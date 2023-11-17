/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.main;


import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 *
 * @author Ron.Arc.Evx
 */
public class pacientereg {
    private Connection connection;
     
    
    
    public pacientereg(Connection connection) {
        this.connection = connection;
    }
    
    
    
    public void insertPaciente(int idpac, String nombre, String apellido, String fechaNacimiento, String genero, String direccion, String telefono) {
        
            // Paso 3: Crear una sentencia
        String query = "INSERT INTO paciente(IDPaciente, Nombre, Apellido, FechaNacimiento, Genero, Direccion, Telefono) VALUES (?, ?, ?, ?, ?, ?, ?)";
        //stmt = conn.prepareStatement(sql);

        // Los siguientes valores deben ser obtenidos desde tu formulario
        //String nombre = "nombre_del_usuario";
        //String apellido = "apellido_del_usuario";
        ///String fechaNacimiento = "2000-01-01"; // Obtener desde el formulario
        //String genero = "Masculino"; // Obtener desde el formulario
        //String direccion = "direccion_del_usuario";
        //String telefono = "telefono_del_usuario";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, idpac);
            preparedStatement.setString(2, nombre);
            preparedStatement.setString(3, apellido);
            preparedStatement.setString(4, fechaNacimiento);
            preparedStatement.setString(5, genero);
            preparedStatement.setString(6, direccion);
            preparedStatement.setString(7, telefono);


            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
            // Paso 4: Ejecutar la sentencia
            //int filasAfectadas = stmt.executeUpdate();

            //System.out.println("Filas afectadas: " + filasAfectadas);

        System.out.println("¡Registrado Finalizado!");
    }
   
}
