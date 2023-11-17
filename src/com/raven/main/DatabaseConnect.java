package com.raven.main;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnect {
    private Connection connection;

    public DatabaseConnect(String dbURL, String user, String password) {
        try {
            //DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            // Cargar el controlador JDBC (com.mysql.cj.jdbc.Driver)
            connection = DriverManager.getConnection(dbURL, user, password);
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establecer la conexión a la base de datos
        } catch (ClassNotFoundException e) {
            System.err.println("Error: No se pudo cargar el controlador JDBC.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Error: No se pudo conectar a la base de datos.");
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void close() {
        try {
            if (connection != null) {
                connection.close();
                System.out.println("Conexión cerrada.");
            }
        } catch (SQLException e) {
            System.err.println("Error al cerrar la conexión.");
            e.printStackTrace();
        }
    }
}