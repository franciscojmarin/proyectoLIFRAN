/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Entrenador;
import modelo.EntrenadorDAO;
import modelo.Pokemon;
import modelo.PokemonDAO;

/**
 *
 * @author fmarin
 */
public class Juego extends HttpServlet {
    
    // El siguiente método procesa la petición para métodos GET y POST
    // Tiene dos parámetros:
    //  -   request objeto tipo HTTPServletRequest con info de la 
    //      petición del cliente
    //  -   response objeto tipo HTTPServletResponse con info de la 
    //      respuesta al cliente
       
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Se establece el tipo de contenido a enviar en la respuesta
        response.setContentType("text/html;charset=UTF-8");
       
        // Obtengo la sesion de la petición HTTP, si existe. 
        // Con true, si no está creada se crea
        HttpSession sesion = request.getSession(true);
        
        // Guardo el nombre del entrenador a insertar en un String
        String nombreEntrenador = request.getParameter("entrenadorNombre");
        
        // Asigno también el tipo de entrenador
        String tipoEntrenador = request.getParameter("entrenadorTipo");
        
        
        
        //Vamos a comprobar si hay información en el botón
        String botonBorrar = request.getParameter("borrar");
        EntrenadorDAO.eliminarEntrenador(botonBorrar);
        
        
        // Si el visitante ha elegido "otros", hay que obtener el valor de la caja de texto
        /*if(!botonBorrar.equals("")){
            sesion.setAttribute("botonBorrar", botonBorrar);
        }*/
        
        /*// Obtengo al jugador votado
        String jugadorVotado = request.getParameter("r1");*/
        
        // Si el visitante ha elegido "otros", hay que obtener el valor de la caja de texto
        /*if(jugadorVotado.equals("Otros")){
            jugadorVotado = request.getParameter("txtOtros");
        }*/
        
        // Obtengo la lista de entrenadores que hay en la base de datos
        // ordenada por nombre
        
        ArrayList<Entrenador> lista = EntrenadorDAO.consultarEntrenadores(false);
        
        // En este punto miramos si el entrenador existe en la lista o no
        // Si existe, habría que reenviar a una página de error
        // Si no existe, hay que insertarlo con su Tipo - INSERT       
        
        if (buscarEntrenador(lista, nombreEntrenador)){
            // Mandar a página error entrenador ya existe - botón volver
            EntrenadorDAO.actualizarEntrenador(nombreEntrenador, tipoEntrenador);
        }else{
            // Como no existe el entrenador en la base de datos,
            // hay que insertarlo con su tipo
            EntrenadorDAO.insertarEntrenador(nombreEntrenador, tipoEntrenador);
        }

        // Obtengo la lista actualizada de jugadores, ordenada por votos
        lista = EntrenadorDAO.consultarEntrenadores(true);

        // Expresión lambda para imprimir los elementos de la lista
        lista.forEach(System.out::println);

        // Una vez realizada la operación, redirigimos a la vista
        response.sendRedirect(response.encodeRedirectURL("index.jsp"));

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
    // Método que hace búsqueda de un Jugador por su nombre
    // dentro de la lista de Jugadores
  
    private static boolean buscarEntrenador (ArrayList<Entrenador> lista, String nombre){
        // Ejemplo de uso de expresiones lambda y API Stream de Java 8
        return lista.stream().anyMatch((entrenador) -> (entrenador.getNombre().equals(nombre)));
    }
    
    private static boolean buscarPokemon (ArrayList<Pokemon> listau, String email){
        // Ejemplo de uso de expresiones lambda y API Stream de Java 8
        return listau.stream().anyMatch((pokemon) -> (pokemon.getNombre().equals(email)));
    }
    
}
