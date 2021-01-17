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
public class Jugador {
    String nombreUsuario;
    ArrayList<Luchador> luchadores=new ArrayList<>();
    Casilla [][]matrizCasillas;
    
    public void agregarLuchador(Luchador luchador){
        luchadores.add(luchador);
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public ArrayList<Luchador> getLuchadores() {
        return luchadores;
    }

    public void setLuchadores(ArrayList<Luchador> luchadores) {
        this.luchadores = luchadores;
    }
    
    public int getSizeLuchadores(){
        return luchadores.size();
    }

    public Casilla[][] getMatrizCasillas() {
        return matrizCasillas;
    }

    public void setMatrizCasillas(Casilla[][] matrizCasillas) {
        this.matrizCasillas = matrizCasillas;
    }

    
    
    
}
