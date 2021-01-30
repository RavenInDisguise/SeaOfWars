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
public class SharkAttack implements IAtacar {

    @Override
    public void atacarCasillas(Jugador jugadorActual,String[] arrayComandos) {
        if(jugadorActual.casillas[0][0].porcentajeVida>0){
            atacarRadio(0,0,jugadorActual);
        }
        if(jugadorActual.casillas[0][29].porcentajeVida>0){
            atacarRadio(0,29,jugadorActual);
        }
        if(jugadorActual.casillas[19][0].porcentajeVida>0){
            atacarRadio(19,0,jugadorActual);
        }
        if(jugadorActual.casillas[19][29].porcentajeVida>0){
            atacarRadio(19,29,jugadorActual);
        }
    } 
    
    public void atacarRadio(int i, int j, Jugador jugadorActual){
        int iRef=i; //x de la casilla
        int jRef=j; //y de la casilla
        int radio = (int) Math.floor(Math.random()*(1-10+1)+10);
        if (iRef==0 && jRef==0){
            int xMax=iRef+radio;
            int yMax=jRef+radio;        
            for (int x=0; x<=xMax; x++){
                for (int y=0; y<=yMax; y++){
                    if(jugadorActual.casillas[x][y].porcentajeVida>0){
                        int porcentajeActual = jugadorActual.casillas[x][y].porcentajeVida;
                        jugadorActual.casillas[x][y].porcentajeVida-=33;
                        String datosCasilla="Casilla"+"["+x+"]"+"["+y+"]:"+" tiene un tiburón. Su porcentaje de vida de: "+porcentajeActual+" pasa a: "+jugadorActual.casillas[x][y].porcentajeVida+".\n";
                        jugadorActual.casillas[x][y].historialAtaques+=datosCasilla;
                        jugadorActual.setLogJugadorRecibido(datosCasilla);
                        jugadorActual.casillas[x][y].ataqueReciente=true;
                    }
                }
            }
        } 
        if (iRef==0 && jRef==29){
            int xMax=iRef+radio;
            int yMin=jRef-radio;        
            for (int x=0; x<=xMax; x++){
                for (int y=29; y<=yMin; y--){
                    if(jugadorActual.casillas[x][y].porcentajeVida>0){
                        int porcentajeActual = jugadorActual.casillas[x][y].porcentajeVida;
                        jugadorActual.casillas[x][y].porcentajeVida-=33;
                        String datosCasilla="Casilla"+"["+x+"]"+"["+y+"]:"+" tiene un tiburón. Su porcentaje de vida de: "+porcentajeActual+" pasa a: "+jugadorActual.casillas[x][y].porcentajeVida+".\n";
                        jugadorActual.casillas[x][y].historialAtaques+=datosCasilla;
                        jugadorActual.setLogJugadorRecibido(datosCasilla);
                        jugadorActual.casillas[x][y].ataqueReciente=true;
                    }
                }
            }
        } 
        if (iRef==19 && jRef==0){
            int xMin=iRef-radio;
            int yMax=jRef+radio;        
            for (int x=19; x<=xMin; x--){
                for (int y=0; y<=yMax; y++){
                    if(jugadorActual.casillas[x][y].porcentajeVida>0){
                        int porcentajeActual = jugadorActual.casillas[x][y].porcentajeVida;
                        jugadorActual.casillas[x][y].porcentajeVida-=33;
                        String datosCasilla="Casilla"+"["+x+"]"+"["+y+"]:"+" tiene un tiburón. Su porcentaje de vida de: "+porcentajeActual+" pasa a: "+jugadorActual.casillas[x][y].porcentajeVida+".\n";
                        jugadorActual.casillas[x][y].historialAtaques+=datosCasilla;
                        jugadorActual.setLogJugadorRecibido(datosCasilla);
                        jugadorActual.casillas[x][y].ataqueReciente=true;
                    }
                }
            }
        } 
        if (iRef==19 && jRef==29){
            int xMax=iRef-radio;
            int yMax=jRef-radio;        
            for (int x=19; x<=xMax; x--){
                for (int y=29; y<=yMax; y--){
                    if(jugadorActual.casillas[x][y].porcentajeVida>0){
                        int porcentajeActual = jugadorActual.casillas[x][y].porcentajeVida;
                        jugadorActual.casillas[x][y].porcentajeVida-=33;
                        String datosCasilla="Casilla"+"["+x+"]"+"["+y+"]:"+" tiene un tiburón. Su porcentaje de vida de: "+porcentajeActual+" pasa a: "+jugadorActual.casillas[x][y].porcentajeVida+".\n";
                        jugadorActual.casillas[x][y].historialAtaques+=datosCasilla;
                        jugadorActual.setLogJugadorRecibido(datosCasilla);
                        jugadorActual.casillas[x][y].ataqueReciente=true;
                    }
                }
            }
        } 
    }
}
