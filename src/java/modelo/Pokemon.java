/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author fmarin
 * @author lidia
 */
public class Pokemon {
    
    private String nombre;
    private String entrenador;

    public Pokemon() {
    }

    public Pokemon(String nombre, String entrenador) {
        this.nombre = nombre;
        this.entrenador = entrenador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(String entrenador) {
        this.entrenador = entrenador;
    }

    @Override
    public String toString() {
        return "Pokemon{" + "nombre=" + nombre + ", entrenador=" + entrenador + '}';
    }
        
}
