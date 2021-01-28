/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.ArrayList;

/**
 *
 * @author monic
 */
public class Juego {
    protected ArrayList<Jugador> jugadores=new ArrayList<Jugador>();
    public ArrayList<Jugador> jugadoresTurnados=new ArrayList<Jugador>();
    private static Juego juego;
    public int contListos =0;

    private Juego() {
    }
    
    public static Juego getSingletonInstance() {
        if (juego == null){
            juego= new Juego();
            System.out.println("New game");
        }
        else{
            System.out.println("No se puede crear el objeto porque ya existe un objeto de la clase Juego");
        }
        
        return juego;
    }

    public ArrayList<Jugador> getJugadoresTurnados() {
        return jugadoresTurnados;
    }

    public void setJugadoresTurnados(ArrayList<Jugador> jugadoresTurnados) {
        this.jugadoresTurnados = jugadoresTurnados;
    }
    
    public Juego clone(){
    try {
        throw new CloneNotSupportedException();
    } catch (CloneNotSupportedException ex) {
            System.out.println("No se puede clonar un objeto de la clase Juego.");
    }
    return null; 
    }
    
    public void agregarJugadores(Jugador jugador){
        jugadores.add(jugador);
    }
    public void agregarJugadoresOrden(Jugador jugador){
        jugadores.add(jugador);
    }
    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(ArrayList<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public static Juego getJuego() {
        return juego;
    }

    public static void setJuego(Juego juego) {
        Juego.juego = juego;
    }
    
    
    
}