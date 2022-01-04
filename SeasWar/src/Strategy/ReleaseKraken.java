/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Strategy;

import Logica.Jugador;
import java.util.Random;

/**
 *
 * @author monic
 */
public class ReleaseKraken implements IAtacar{

    @Override
    public void atacarCasillas(Jugador jugadorActual, String[] arrayComandos) {
        jugadorActual.setAtacadoRelease(true);
        Random rand = new Random();
        int irandom = rand.nextInt(20);
        int jrandom = rand.nextInt(30);
        if(jugadorActual.casillas[irandom][jrandom].porcentajeVida>0){
            String datosCasilla="Casilla"+"["+irandom+"]"+"["+jrandom+"]:"+" fue afectado por Release the kraken. Su porcentaje de vida de: "+jugadorActual.casillas[irandom][jrandom].porcentajeVida+" pasa a: 0.\n";
            jugadorActual.casillas[irandom][jrandom].historialAtaquesTotales+=datosCasilla;
            jugadorActual.casillas[irandom][jrandom].historialAtaques=datosCasilla;
            jugadorActual.setLogJugadorRecibido(datosCasilla);
            jugadorActual.casillas[irandom][jrandom].porcentajeVida=0;
            jugadorActual.casillas[irandom][jrandom].ataqueReciente=true;
        }
        atacarRadio(irandom,jrandom,jugadorActual);
    }
    
    public void atacarRadio(int x, int y, Jugador jugadorActual){
        for (int c = 0; c<=9; c++){
            for (int i =x-c; i <= x+c; i++){
                for (int j =y-c; j<= y+c; j++){
                    //System.out.println("i: "+i);
                    //System.out.println("j: "+j);
                    if(i<20 && i>-1){
                     if(j<30 && j>-1){
                        if(jugadorActual.casillas[i][j].porcentajeVida>0){
                           String datosCasilla="Casilla"+"["+i+"]"+"["+j+"]:"+" fue afectado por Release the kraken. Su porcentaje de vida de: "+jugadorActual.casillas[i][j].porcentajeVida+" pasa a: 0.\n";
                           jugadorActual.casillas[i][j].historialAtaquesTotales+=datosCasilla;
                           jugadorActual.casillas[i][j].historialAtaques=datosCasilla;
                           jugadorActual.setLogJugadorRecibido(datosCasilla);
                           jugadorActual.casillas[i][j].porcentajeVida=0;
                           jugadorActual.casillas[i][j].ataqueReciente=true;
                       }
                    }
                  }
                }
            }
        }
    }
}
