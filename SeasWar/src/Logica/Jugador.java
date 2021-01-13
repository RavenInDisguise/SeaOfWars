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
    
    public void agregarLuchador(Luchador luchador){
        luchadores.add(luchador);
    }
}
