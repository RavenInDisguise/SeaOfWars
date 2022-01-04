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
public class KrakenBreath implements IAtacar{
    
    @Override
    public void atacarCasillas(Jugador jugadorActual, String[] arrayComandos) {
        Random rand = new Random();
        int random = rand.nextInt(4);
        int aumento = rand.nextInt(10);
        int irandom = rand.nextInt(20);
        int jrandom = rand.nextInt(30);
        
        if(aumento==0){
            aumento=1;
        }
        switch(random){
            case 0 -> {
                for(int i=0;i<aumento;i++){
                    if(i<20 && i>-1){
                        if(jugadorActual.casillas[i][jrandom].porcentajeVida>0){
                            System.out.println("case 1");
                            String datosCasilla="Casilla"+"["+i+"]"+"["+jrandom+"]:"+" estaba en el paso del aliento del Kraken. Su porcentaje de vida de: "+jugadorActual.casillas[i][jrandom].porcentajeVida+" pasa a: 0.\n";
                            jugadorActual.casillas[irandom][jrandom].historialAtaquesTotales+=datosCasilla;
                            jugadorActual.casillas[irandom][jrandom].historialAtaques=datosCasilla;
                            jugadorActual.setLogJugadorRecibido(datosCasilla);
                            jugadorActual.casillas[i][jrandom].porcentajeVida=0;
                            jugadorActual.casillas[i][jrandom].ataqueReciente=true;
                        }
                    }
                }
            }
            case 1 -> {
                for(int i=aumento;i<0;i--){
                    if(i<20 && i>-1){
                        if(jugadorActual.casillas[i][jrandom].porcentajeVida>0){
                            System.out.println("case 2");
                            String datosCasilla="Casilla"+"["+i+"]"+"["+jrandom+"]:"+" estaba en el paso del aliento del Kraken. Su porcentaje de vida de: "+jugadorActual.casillas[i][jrandom].porcentajeVida+" pasa a: 0.\n";
                            jugadorActual.casillas[i][jrandom].historialAtaques+=datosCasilla;
                            jugadorActual.setLogJugadorRecibido(datosCasilla);
                            jugadorActual.casillas[i][jrandom].porcentajeVida=0;
                            jugadorActual.casillas[i][jrandom].ataqueReciente=true;
                        }
                    }
                }
            }
            case 2 -> {
                for(int j=0;j<aumento;j++){
                    if(j<30 && j>-1){
                        if(jugadorActual.casillas[irandom][j].porcentajeVida>0){
                            System.out.println("case 3");
                            String datosCasilla="Casilla"+"["+irandom+"]"+"["+j+"]:"+" estaba en el paso del aliento del Kraken. Su porcentaje de vida de: "+jugadorActual.casillas[irandom][j].porcentajeVida+" pasa a: 0.\n";
                            jugadorActual.casillas[irandom][j].historialAtaques+=datosCasilla;
                            jugadorActual.setLogJugadorRecibido(datosCasilla);
                            jugadorActual.casillas[irandom][j].porcentajeVida=0;
                            jugadorActual.casillas[irandom][j].ataqueReciente=true;
                        }
                    }
                }
            }
            default -> {
                for(int j=aumento;j<0;j--){
                    if(j<30 && j>-1){
                        if(jugadorActual.casillas[irandom][j].porcentajeVida>0){
                            System.out.println("case 4");
                            String datosCasilla="Casilla"+"["+irandom+"]"+"["+j+"]:"+" estaba en el paso del aliento del Kraken. Su porcentaje de vida de: "+jugadorActual.casillas[irandom][j].porcentajeVida+" pasa a: 0.\n";
                            jugadorActual.casillas[irandom][j].historialAtaques+=datosCasilla;
                            jugadorActual.setLogJugadorRecibido(datosCasilla);
                            jugadorActual.casillas[irandom][j].porcentajeVida=0;
                            jugadorActual.casillas[irandom][j].ataqueReciente=true;
                        }
                    }
                }   
            }
        }
      
    }
}
    
