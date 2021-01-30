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
public class TermalRush implements IAtacar{

    @Override
    public void atacarCasillas(Jugador jugadorActual, String[] arrayComandos) {
        /* se genera un sobrecalentamiento del agua alrededor de un radio de 5 
        casillas del volcán. 
        El calentamiento será entre 5 y 6 segundos, cada segundo equivale a 
        porcentaje del radio del volcán de daño, es decir, 
        si el volcán tiene 5 de daño, cada segundo que pasa dañará las casillas 
        en 5%*/
        Random rand = new Random();
        for (int i = 0; i <20; i++){
            for (int j = 0; j <30; j++){ 
                if(jugadorActual.casillas[i][j].volcan){
                    int segundos=(int) Math.floor(Math.random()*(5-6+1)+6);
                    recorrerMatriz(i, j, segundos,jugadorActual);
                    
                }
            }
    
        }
    }
    
    public void recorrerMatriz(int x, int y, int tiempo, Jugador jugadorActual){
        for (int c = 0; c<5; c++){
            for (int i =x-c; i <= x+c; i++){
                for (int j =y-c; j<= y+c; j++){
                    if(i<20 && i>-1){
                     if(j<30 && j>-1){
                       if(jugadorActual.casillas[i][j].porcentajeVida>0){
                           atacarTiempo(i, j, tiempo, jugadorActual.casillas[i][j], jugadorActual);
                       }
                    }
                    }
                }
            }
        }
    }
    
    public void atacarTiempo(int i, int j,int tiempo, Casilla casilla, Jugador jugadorActual){
        for(int k=0; k<tiempo; k++){
            if(casilla.porcentajeVida>0){
                int porcentajeActual = casilla.porcentajeVida;
                casilla.porcentajeVida-=5;
                String datosCasilla="Casilla"+"["+i+"]"+"["+j+"]:"+" fue afectada por un sobrecalentamiento de agua. Su porcentaje de vida de: "+porcentajeActual+" pasa a: "+jugadorActual.casillas[i][j].porcentajeVida+".\n";
                casilla.historialAtaquesTotales+=datosCasilla;
                casilla.historialAtaques+=datosCasilla;
                jugadorActual.setLogJugadorRecibido(datosCasilla);
                jugadorActual.casillas[i][j].ataqueReciente=true;
            }
        }
    }
}

