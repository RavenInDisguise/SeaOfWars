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
public class SendHumanGarbage implements IAtacar{

    @Override
    public void atacarCasillas(Jugador jugadorActual, String[] arrayComandos) {
        Random rand = new Random();
        for (int i = 0; i <20; i++){
            for (int j = 0; j <30; j++){ 
                if(jugadorActual.casillas[i][j].remolino){
                    int cantidadToneladas=(int) Math.floor(Math.random()*(2-4+1)+4);
                    generarBasura(cantidadToneladas,jugadorActual.casillas[i][j],jugadorActual);
                }
            }
        }
    }
    
    public void generarBasura(int toneladas, Casilla casillaActual, Jugador jugadorActual){
        Random rand = new Random();
        for(int i=0; i<toneladas;i++){
            int radioToneladas=casillaActual.radioRemolino*10;
            int irandom = rand.nextInt(20);
            int jrandom = rand.nextInt(30);
            generarRadio(radioToneladas, irandom, jrandom, jugadorActual);
        }
    }
    
    public void generarRadio(int radioToneladas, int x, int y, Jugador jugadorActual){
        
        for (int c = 0; c<=radioToneladas; c++){
            for (int i =x-c; i <= x+c; i++){
                for (int j =y-c; j<= y+c; j++){
                    if(i<20 && i>-1){
                     if(j<30 && j>-1){
                         if(jugadorActual.casillas[i][j].porcentajeVida>0){
                           int porcentaje=jugadorActual.casillas[i][j].porcentajeVida;
                           jugadorActual.casillas[i][j].porcentajeVida-=25;
                           String datosCasilla="Casilla"+"["+i+"]"+"["+j+"]:"+" fue afectado por una tonelada del basura. Su porcentaje de vida de: "+porcentaje+" pasa a: "+jugadorActual.casillas[i][j].porcentajeVida+"\n";
                           jugadorActual.casillas[i][j].historialAtaquesTotales+=datosCasilla;
                           jugadorActual.casillas[i][j].historialAtaques=datosCasilla;
                           jugadorActual.setLogJugadorRecibido(datosCasilla);
                           jugadorActual.casillas[i][j].ataqueReciente=true;
                           int probabilidadRadioactiva=(int) Math.floor(Math.random()*(1-100+1)+100);
                           if(probabilidadRadioactiva > 50){
                               jugadorActual.casillas[i][j].radioactiva = true;
                           }
                       }
                     }
                    }
                }
            }
         }
    }
    
}
