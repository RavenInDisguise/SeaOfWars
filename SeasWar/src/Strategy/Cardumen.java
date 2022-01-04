/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Strategy;

import Logica.Jugador;
import java.awt.Point;
import java.util.Random;
/**
 *
 * @author monic
 */
public class Cardumen implements IAtacar {

    @Override
    public void atacarCasillas(Jugador jugadorActual, String[] arrayComandos) {
        Random rand = new Random();
        int cantPeces = (int) Math.floor(Math.random()*(34-100+1)+100);
        for (int i=0; i<cantPeces;i++){
            int irandom = rand.nextInt(20);
            int jrandom = rand.nextInt(30);
            if(jugadorActual.casillas[irandom][jrandom].porcentajeVida>0){
                int porcentajeActual = jugadorActual.casillas[irandom][jrandom].porcentajeVida;
                jugadorActual.casillas[irandom][jrandom].porcentajeVida-=33;
                String datosCasilla="Casilla"+"["+irandom+"]"+"["+jrandom+"]:"+" tiene un pez del cardúmen. Su porcentaje de vida de: "+porcentajeActual+" pasa a: "+jugadorActual.casillas[irandom][jrandom].porcentajeVida+".\n";
                jugadorActual.casillas[irandom][jrandom].historialAtaquesTotales+=datosCasilla;
                jugadorActual.casillas[irandom][jrandom].historialAtaques=datosCasilla;
                jugadorActual.setLogJugadorRecibido(datosCasilla);
                jugadorActual.casillas[irandom][jrandom].ataqueReciente=true;
            }
        }
        
    } 
    
     
}
