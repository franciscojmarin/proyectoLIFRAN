/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author fmarin
 */
public class Conexion {
    
    private static final String SERVIDOR = "jdbc:mysql://localhost/";
    private static final String NOMBRE_BASE_DATOS = "bd_pokemons";
    private static final String USER = "ubuntu";
    private static final String PASS = "ubuntu";
    public static final String DRIVER = "com.mysql.jdbc.Driver";
    
    private Connection conexion;
    
    public Conexion(){
        
        try {
            Class.forName(DRIVER); 

            // Se crea el objeto Connection	
            conexion = DriverManager.getConnection(SERVIDOR + NOMBRE_BASE_DATOS, USER, PASS);

            System.out.println("Conexión realizada con éxito.");

        } catch (SQLException | ClassNotFoundException e) {
           
            System.out.println(e);
        }
    }
    
    public Connection getConexion() {
        return conexion;
    }
    
    public void cerrarConexion() {
        try {
            conexion.close();
            System.out.println("Cerrando la conexión con la BD.");
        } catch (SQLException e) {
            System.out.println(e);
        }
        conexion = null;
    }
    
}
