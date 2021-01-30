/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Strategy;

import Logica.Casilla;
import Logica.Jugador;
import java.util.Random;

/**
 *
 * @author monic
 */
public class VolcanoExplosion implements IAtacar{

    @Override
    public void atacarCasillas(Jugador jugadorActual, String[] arrayComandos) {
        Random rand = new Random();
        for (int i = 0; i <20; i++){
            for (int j = 0; j <30; j++){ 
                if(jugadorActual.casillas[i][j].volcan){
                    int cantidadPiedras=(int) Math.floor(Math.random()*(2-4+1)+4);
                    generarPiedras(cantidadPiedras,jugadorActual.casillas[i][j],jugadorActual);
                }
            }
        }
    }
    
    public void generarPiedras(int piedras, Casilla casillaActual, Jugador jugadorActual){
        Random rand = new Random();
        for(int i=0; i<piedras;i++){
            int radioPiedras=casillaActual.radioVolcan*10;
            int irandom = rand.nextInt(20);
            int jrandom = rand.nextInt(30);
            generarRadio(radioPiedras, irandom, jrandom, jugadorActual);
        }
    }
    
    public void generarRadio(int radioPiedra, int x, int y, Jugador jugadorActual){
         for (int c = 0; c<=radioPiedra; c++){
            for (int i =x-c; i <= x+c; i++){
                for (int j =y-c; j<= y+c; j++){
                    if(i<20 && i>-1){
                     if(j<30 && j>-1){
                         if(jugadorActual.casillas[i][j].porcentajeVida>0){
                           int porcentaje=jugadorActual.casillas[i][j].porcentajeVida;
                           jugadorActual.casillas[i][j].porcentajeVida-=20;
                           String datosCasilla="Casilla"+"["+i+"]"+"["+j+"]:"+" fue afectado por una piedra del volcán. Su porcentaje de vida de: "+porcentaje+" pasa a: "+jugadorActual.casillas[i][j].porcentajeVida+"\n";
                           jugadorActual.casillas[i][j].historialAtaquesTotales+=datosCasilla;
                           jugadorActual.casillas[i][j].historialAtaques=datosCasilla;
                           jugadorActual.setLogJugadorRecibido(datosCasilla);
                           jugadorActual.casillas[i][j].ataqueReciente=true;
                       }
                     }
                    }
                }
            }
         }
    }
    
}