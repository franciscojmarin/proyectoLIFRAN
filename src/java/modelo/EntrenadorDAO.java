/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author fmarin
 */
public class EntrenadorDAO {
    
    // Este método devuelve una lista de Jugadores ordenada por Nombre
    // si creterio es FALSE o por votos si criterio es TRUE
    public static ArrayList<Entrenador> consultarEntrenadores(boolean criterio){
        Statement st;
        ResultSet res;
        ArrayList<Entrenador> lista = new ArrayList();
        
        // Guardo la consulta SQL realizar en una cadena
        String sql = (criterio)?"select * from entrenadores order by nombre desc":"select * from entrenadores order by tipo";
  
        Conexion conexion = new Conexion();
        
        try {
            
            // Preparamos Statement
            st = conexion.getConexion().createStatement(); 
            // Ejecutamos la sentencia y obtenemos la tabla resultado
            res = st.executeQuery(sql);
            // Ahora construimos la lista
            while (res.next()){
                Entrenador e = new Entrenador();
                // Recogemos los datos del turismo, guardamos en un objeto
                e.setNombre(res.getString("Nombre"));
                e.setTipo(res.getString("Tipo"));

                //Añadimos el objeto al array
                lista.add(e);
            }
            // Cerramos el recurso PreparedStatement 
            st.close();
            // Cerramos la conexión 
            conexion.cerrarConexion();
            // La inserción se realizó con éxito, devolvemos filas afectadas
        } catch (SQLException e) {
            System.out.println("Problemas durante la consulta en tabla entrenadores");
            System.out.println(e);
            
        }

        return lista;  
    }
    
     public static int eliminarEntrenador(String nombre){
        
        // Cadena con la consulta parametrizada
        String sql = "delete from entrenadores where name = "+nombre;

        Conexion conexion = new Conexion();
        
        PreparedStatement prest;

        try { 
            // Preparamos la inserción de datos  mediante un PreparedStatement
            prest = conexion.getConexion().prepareStatement(sql);

            // Procedemos a indicar los valores que queremos insertar
            // Usamos los métodos setXXX(indice, valor)
            // indice indica la posicion del argumento ?, empieza en 1
            // valor es el dato que queremos insertar
            prest.setString(1, nombre);

            // Ejecutamos la sentencia de inserción preparada anteriormente
            int nfilas = prest.executeUpdate();
    
            // Cerramos el recurso PreparedStatement 
            prest.close();
            
            // Cerramos la conexión 
            conexion.cerrarConexion();
            // La inserción se realizó con éxito, devolvemos filas afectadas
            return nfilas;
        } catch (SQLException e) {
            System.out.println("Problemas durante la eliminación del Entrenador");
            System.out.println(e);
            return -1;
        }
    }
    public static int insertarEntrenador(String nombre, String tipo){
        
        // Cadena con la consulta parametrizada
        String sql = "insert into entrenadores values (?,?)";

        Conexion conexion = new Conexion();
        
        PreparedStatement prest;

        try { 
            // Preparamos la inserción de datos  mediante un PreparedStatement
            prest = conexion.getConexion().prepareStatement(sql);

            // Procedemos a indicar los valores que queremos insertar
            // Usamos los métodos setXXX(indice, valor)
            // indice indica la posicion del argumento ?, empieza en 1
            // valor es el dato que queremos insertar
            prest.setString(1, nombre);
            prest.setString(2, tipo);

            // Ejecutamos la sentencia de inserción preparada anteriormente
            int nfilas = prest.executeUpdate();
    
            // Cerramos el recurso PreparedStatement 
            prest.close();
            
            // Cerramos la conexión 
            conexion.cerrarConexion();
            // La inserción se realizó con éxito, devolvemos filas afectadas
            return nfilas;
        } catch (SQLException e) {
            System.out.println("Problemas durante la inserción de datos en la tabla entrenadores");
            System.out.println(e);
            return -1;
        }
    }
    
    public static int actualizarJugador(String nombre, String tipo){
        // Cadena con la consulta 
        String sql = "update entrenadores set tipo = '" + tipo + "' where nombre like '" + nombre + "'";
        Conexion conexion = new Conexion();
        try {

            int nfilas;
            // Ejecutamos la sentencia de modificación
            //try-with-resources
            try (Statement prest = conexion.getConexion().createStatement()) {
                // Ejecutamos la sentencia de modificación
                nfilas = prest.executeUpdate(sql);
                // Cerramos el recurso PreparedStatement
            }
            // Cerramos la conexión 
            conexion.cerrarConexion();
            // La inserción se realizó con éxito, devolvemos filas afectadas
            return nfilas;
        } catch (SQLException e) {
            System.out.println("Problemas durante la modificación de datos en la tabla entrenadores");
            System.out.println(e);
            return -1;
        }
    }
    
}
