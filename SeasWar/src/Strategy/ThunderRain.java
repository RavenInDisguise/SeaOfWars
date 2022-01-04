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
public class ThunderRain implements IAtacar {

    @Override
    public void atacarCasillas(Jugador jugadorActual, String[] arrayComandos) {
        Random rand = new Random();
        for (int i=0; i<100;i++){
            int porMenos = (int) Math.floor(Math.random()*(10-20+1)+20);
            int irandom = rand.nextInt(20);
            int jrandom = rand.nextInt(30);
            if(jugadorActual.casillas[irandom][jrandom].porcentajeVida>0){
                int porcentajeActual = jugadorActual.casillas[irandom][jrandom].porcentajeVida;
                jugadorActual.casillas[irandom][jrandom].porcentajeVida-=porMenos;
                String datosCasilla="Casilla"+"["+irandom+"]"+"["+jrandom+"]:"+" tiene un rayo. Su porcentaje de vida de: "+porcentajeActual+" pasa a: "+jugadorActual.casillas[irandom][jrandom].porcentajeVida+".\n";
                jugadorActual.casillas[irandom][jrandom].historialAtaquesTotales+=datosCasilla;
                jugadorActual.casillas[irandom][jrandom].historialAtaques=datosCasilla;
                jugadorActual.setLogJugadorRecibido(datosCasilla);
                jugadorActual.casillas[irandom][jrandom].ataqueReciente=true;
                
            }
        }
    
    }
}