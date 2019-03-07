<%-- 
    Document   : index
    Author     : Lidia y Fran
--%>

<%@page import="modelo.PokemonDAO"%>
<%@page import="modelo.Pokemon"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.EntrenadorDAO"%>
<%@page import="modelo.Entrenador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>
    <head>
        <title>Gimnasio POKEMON</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="./css/style.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        
    <h1>Gimnasio POKEMON</h1>
    
    <div id="entranadoresZone">
        <h3>ENTRENADORES</h3>
        
        <div id="listadoEntrenadores">
        <p>Lista de Entrenadores registrados</p>
            <%
                // Lista ordenada por entrenadores, de mayor a menor
                ArrayList<Entrenador> listaE = EntrenadorDAO.consultarEntrenadores(true);
                for (Entrenador e : listaE) {
                       out.print("<p><button type='button' value='"+e.getNombre()+"'>Borrar</button>"+e.getNombre()+"'</p>");
                    }
            %>
        </div>
        <p>Insertar Entrenador</p>

        <form action="./Juego" method="POST">
            <p> Nombre:   <input type="text" size="20" name="entrenadorNombre">   </p>
            <p> Tipo:     
                <select name="entrenadorTipo">
                    <option value="bueno">Bueno</option>
                    <option value="mano">Malo</option>
                </select>

            <p> <input type="submit" name="buttonSubmit" value="insertarEntrenador"> 
            <input type="reset" name="buttonReset" value="Reset"> </p>
        </form>
    </div>
    
    <div id="pokemonZone">
        <h3>POKEMONS</h3>
        
        <div id="listadoPokemons">
        <p>Lista de Entrenadores registrados</p>
            <%
                // Lista ordenada por entrenadores, de mayor a menor
                ArrayList<Pokemon> listaP = PokemonDAO.consultarPokemons(true);
                for (Pokemon p : listaP) {
                       out.print("<p><button type='button' value='"+p.getNombre()+"'>Borrar</button>"+p.getNombre()+"'</p>");
                    }
            %>
        </div>
        
        
        <p>Insertar Pokemon</p>

        <form action="./Juego" method="POST">

            <p> Nombre:   <input type="text" size="20" name="pokemonNombre">   </p>
            <p> Entrenador:     
                <select name="pokemonEntrenador">
                <%
                    // Lista ordenada por entrenadores, de mayor a menor
                    ArrayList<Entrenador> lista = EntrenadorDAO.consultarEntrenadores(true);
                    for (Entrenador e : lista) {
                           out.print("<option value='"+e.getNombre()+"'>"+e.getNombre()+"</option>");
                        }
                %>
                </select>
            <p> <input type="submit" name="buttonSubmit" value="insertarPokemon"> 
            <input type="reset" name="buttonReset" value="Reset"> </p>
        </form>
    </div>
            
    </body>
</html>

