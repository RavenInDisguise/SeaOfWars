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
public class Pulp implements IAtacar {

    @Override
    public void atacarCasillas(Jugador jugadorActual, String[] arrayComandos) {
        Random rand = new Random();
        int cantPulpos = (int) Math.floor(Math.random()*(20-50+1)+50);
        for (int i=0; i<cantPulpos;i++){
            for (int j=0; j<8;j++){
                int irandom = rand.nextInt(20);
                int jrandom = rand.nextInt(30);
                if(jugadorActual.casillas[irandom][jrandom].porcentajeVida>0){
                    int porcentajeActual = jugadorActual.casillas[irandom][jrandom].porcentajeVida;
                    jugadorActual.casillas[irandom][jrandom].porcentajeVida-=25;
                    String datosCasilla="Casilla"+"["+irandom+"]"+"["+jrandom+"]:"+" tiene un tentáculo de un pulpo. Su porcentaje de vida de: "+porcentajeActual+" pasa a: "+jugadorActual.casillas[irandom][jrandom].porcentajeVida+".\n";
                    jugadorActual.casillas[irandom][jrandom].historialAtaquesTotales+=datosCasilla;
                    jugadorActual.casillas[irandom][jrandom].historialAtaques=datosCasilla;
                    jugadorActual.setLogJugadorRecibido(datosCasilla);
                    jugadorActual.casillas[irandom][jrandom].ataqueReciente=true;
                }
            }
        }
        
    } 
    
    
}

