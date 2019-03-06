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
 * @author lidia
 */
public class PokemonDAO {
    
    // Este método devuelve una lista de Pokemons ordenada por nombre
    // si creterio es FALSE o por votos si criterio es TRUE

    public static ArrayList<Pokemon> consultarPokemons(boolean criterio){
        Statement st;
        ResultSet res;
        ArrayList<Pokemon> lista = new ArrayList();
        
        // Guardo la consulta SQL realizar en una cadena
        String sql = (criterio)?"select * from Jugadores order by Votos desc":"select * from Jugadores order by Nombre";
  
        Conexion conexion = new Conexion();
        
        try {
            
            // Preparamos Statement
            st = conexion.getConexion().createStatement(); 
            // Ejecutamos la sentencia y obtenemos la tabla resultado
            res = st.executeQuery(sql);
            // Ahora construimos la lista
            while (res.next()){
                Pokemon p = new Pokemon();
                // Recogemos los datos del turismo, guardamos en un objeto
                p.setNombre(res.getString("nombre"));
                p.setEntrenador(res.getInt("entrenador"));

                //Añadimos el objeto al array
                lista.add(p);
            }
            // Cerramos el recurso PreparedStatement 
            st.close();
            // Cerramos la conexión 
            conexion.cerrarConexion();
            // La inserción se realizó con éxito, devolvemos filas afectadas
        } catch (SQLException e) {
            System.out.println("Problemas durante la consulta en tabla Pokemons");
            System.out.println(e);
            
        }

        return lista;  
    }
    
    public static int insertarPokemon(String nombre, String tipo){
        
        // Cadena con la consulta parametrizada
        String sql = "insert into pokemons values (?,?)";

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
            prest.setString(2, entrenador);

            // Ejecutamos la sentencia de inserción preparada anteriormente
            int nfilas = prest.executeUpdate();
    
            // Cerramos el recurso PreparedStatement 
            prest.close();
            
            // Cerramos la conexión 
            conexion.cerrarConexion();
            // La inserción se realizó con éxito, devolvemos filas afectadas
            return nfilas;
        } catch (SQLException e) {
            System.out.println("Problemas durante la inserción de datos en la tabla Pokemons");
            System.out.println(e);
            return -1;
        }
    }
    
    public static int actualizarPokemon(String nombre, String tipo){
        // Cadena con la consulta 
        String sql = "update pokemons set tipo = "+tipo+" where nombre like '" + nombre + "'";
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
            System.out.println("Problemas durante la modificación de datos en la tabla Pokemons");
            System.out.println(e);
            return -1;
        }
    }
    
    
}
