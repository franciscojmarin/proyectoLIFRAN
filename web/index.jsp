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
        ${sessionScope['botonBorrar']}
    <h1>Gimnasio POKEMON</h1>
    <h3>ENTRENADORES</h3>
    <div id="entranadoresZone">
        <div id="listadoEntrenadores">
            <p>Lista de Entrenadores registrados</p>
            <form action="./Juego" method="POST">
                <%
                    // Lista ordenada por entrenadores, de mayor a menor
                    ArrayList<Entrenador> listaE = EntrenadorDAO.consultarEntrenadores(true);
                    for (Entrenador e : listaE) {
                           out.print("<span><button type='button' name='borrar' value='"+e.getNombre()+"'>Borrar</button>"+e.getNombre()+"</span>");
                        }
                %>
            </form>
        </div>
            
        <div id="insertarEntrenadores">
            <p>Insertar Entrenador</p>
            <form action="./Juego" method="POST">
                <p> Nombre:   <input type="text" size="20" name="entrenadorNombre">   </p>
                <p> Tipo:     
                    <select name="entrenadorTipo">
                        <option value="bueno">Bueno</option>
                        <option value="mano">Malo</option>
                    </select>

                <p> <input type="submit" name="buttonSubmit" value="insertar Entrenador"> 
                <input type="reset" name="buttonReset" value="Reset"> </p>
            </form>
        </div>
    </div>
    
    <h3>POKEMONS</h3>
    <div id="pokemonZone">
        <div id="listadoPokemons">
            <p>Lista de Pokemons registrados</p>
            <form action="./Juego" method="POST">
                <%
                    // Lista ordenada por entrenadores, de mayor a menor
                    ArrayList<Pokemon> listaP = PokemonDAO.consultarPokemons(true);
                    for (Pokemon p : listaP) {
                           out.print("<span><button  name='borrar' type='button' value='"+p.getNombre()+"'>Borrar</button>"+p.getNombre()+"</span>");
                        }
                %>
            </form>
        </div>
        
        <div id="insertarPokemons">
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
                <p> <input type="submit" name="buttonSubmit" value="insertar Pokemon"> 
                <input type="reset" name="buttonReset" value="Reset"> </p>
            </form>
        </div>
    </div>
            
    </body>
</html>

