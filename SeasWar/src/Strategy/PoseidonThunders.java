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
public class PoseidonThunders implements IAtacar {

    @Override
    public void atacarCasillas(Jugador jugadorActual, String[] arrayComandos) {
        Random rand = new Random();
        int cantRayos = (int) Math.floor(Math.random()*(5-10+1)+10);
        System.out.println("CRayos: "+cantRayos);
        for (int i=0; i<cantRayos;i++){
            int radio = (int) Math.floor(Math.random()*(2-10+1)+10);
            int irandom = rand.nextInt(20);
            int jrandom = rand.nextInt(30);
            if(jugadorActual.casillas[irandom][jrandom].porcentajeVida>0){
                atacarRadio(irandom,jrandom,jugadorActual, radio);
            }
        }
        
    }
    
       public void atacarRadio(int x, int y, Jugador jugadorActual, int radio){
        for (int c = 0; c<=radio; c++){
            for (int i =x-c; i <= x+c; i++){
                for (int j =y-c; j<= y+c; j++){
                    //System.out.println("i: "+i);
                    //System.out.println("j: "+j);
                    if(i<20 && i>-1){
                     if(j<30 && j>-1){
                        if(jugadorActual.casillas[i][j].porcentajeVida>0){
                           String datosCasilla="Casilla"+"["+i+"]"+"["+j+"]:"+" fue afectado por un rayo de Poseidon. Su porcentaje de vida de: "+jugadorActual.casillas[i][j].porcentajeVida+" pasa a: 0.\n";
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