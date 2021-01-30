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
public class SwirlRaising implements IAtacar {

    @Override
    public void atacarCasillas(Jugador jugadorActual, String[] arrayComandos) {
        Random rand = new Random();
        int irandom = rand.nextInt(20);
        int jrandom = rand.nextInt(30);
        int radio = (int) Math.floor(Math.random()*(2-10+1)+10);
        generarRadio(irandom, jrandom, radio, jugadorActual);
    }

    public void generarRadio(int x, int y,int radio, Jugador jugadorActual){
        for (int c = 0; c<=radio; c++){
            for (int i =x-c; i <= x+c; i++){
                for (int j =y-c; j<= y+c; j++){
                    if(i<20 && i>-1){
                     if(j<30 && j>-1){
                        if(jugadorActual.casillas[i][j].porcentajeVida>0){
                           String datosCasilla="Casilla"+"["+i+"]"+"["+j+"]:"+" fue afectado por un remolino. Su porcentaje de vida de: "+jugadorActual.casillas[i][j].porcentajeVida+" pasa a: 0.\n";
                           jugadorActual.casillas[i][j].historialAtaquesTotales+=datosCasilla;
                           jugadorActual.casillas[i][j].historialAtaques=datosCasilla;
                           jugadorActual.setLogJugadorRecibido(datosCasilla);
                           jugadorActual.casillas[i][j].porcentajeVida=0;
                           jugadorActual.casillas[i][j].remolino=true;
                           jugadorActual.casillas[i][j].radioRemolino=radio;
                           jugadorActual.casillas[i][j].ataqueReciente=true;
                       }
                    }
                  }
                }
            }
        }
    }
}