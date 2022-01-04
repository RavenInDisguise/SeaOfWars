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
public class ThreeLines implements IAtacar{

    @Override
    public void atacarCasillas(Jugador jugadorActual, String[] arrayComandos) {
        int x1=Integer.parseInt(arrayComandos[4].trim());
        int y1=Integer.parseInt(arrayComandos[5].trim());
        generarRadio(jugadorActual, x1, y1);
        
        int x2=Integer.parseInt(arrayComandos[6].trim());
        int y2=Integer.parseInt(arrayComandos[7].trim());
        generarRadio(jugadorActual, x2, y2);
        
        int x3=Integer.parseInt(arrayComandos[8].trim());
        int y3=Integer.parseInt(arrayComandos[9].trim());
        generarRadio(jugadorActual, x3, y3);
    }
    
    public void generarRadio(Jugador jugadorActual, int iValor, int jValor){
        Random rand = new Random();
        int random = rand.nextInt(3);
        System.out.println("R:"+random);
        int aumento = rand.nextInt(5);
        if(aumento==0){
            aumento=1;
        }
        switch(random){
            case 0:
                for(int i=0;i<aumento;i++){
                    if(i<20 && i>-1){
                        if(jugadorActual.casillas[i][jValor].porcentajeVida>0){
                            String datosCasilla="Casilla"+"["+i+"]"+"["+jValor+"]:"+" estaba en las líneas de Poseidon. Su porcentaje de vida de: "+jugadorActual.casillas[i][jValor].porcentajeVida+" pasa a: 0.\n";
                            jugadorActual.casillas[i][jValor].historialAtaquesTotales+=datosCasilla;
                            jugadorActual.casillas[i][jValor].historialAtaques=datosCasilla;
                            jugadorActual.setLogJugadorRecibido(datosCasilla);
                            jugadorActual.casillas[i][jValor].porcentajeVida=0;
                            jugadorActual.casillas[i][jValor].ataqueReciente=true;
                        }
                    }
                }
            break;
            case 1:
                for(int i=aumento;i<0;i--){
                    if(i<20 && i>-1){
                        if(jugadorActual.casillas[i][jValor].porcentajeVida>0){
                            String datosCasilla="Casilla"+"["+i+"]"+"["+jValor+"]:"+" estaba en las líneas de Poseidon. Su porcentaje de vida de: "+jugadorActual.casillas[i][jValor].porcentajeVida+" pasa a: 0.\n";
                            jugadorActual.casillas[i][jValor].historialAtaquesTotales+=datosCasilla;
                            jugadorActual.casillas[i][jValor].historialAtaques=datosCasilla;
                            jugadorActual.setLogJugadorRecibido(datosCasilla);
                            jugadorActual.casillas[i][jValor].porcentajeVida=0;
                            jugadorActual.casillas[i][jValor].ataqueReciente=true;
                        }
                    }
                }
            break;
            case 2:
                for(int j=0;j<aumento;j++){
                    if(j<30 && j>-1){
                        if(jugadorActual.casillas[iValor][j].porcentajeVida>0){
                            String datosCasillas="Casilla"+"["+iValor+"]"+"["+j+"]:"+" estaba en las líneas de Poseidon. Su porcentaje de vida de: "+jugadorActual.casillas[iValor][j].porcentajeVida+" pasa a: 0.\n";
                            jugadorActual.casillas[iValor][j].historialAtaquesTotales+=datosCasillas;
                            jugadorActual.casillas[iValor][j].historialAtaques=datosCasillas;
                            jugadorActual.setLogJugadorRecibido(datosCasillas);
                            jugadorActual.casillas[iValor][j].porcentajeVida=0;
                            jugadorActual.casillas[iValor][j].ataqueReciente=true;
                        }
                    }
                }
            break;
            default:
                for(int j=aumento;j<0;j--){
                    if(j<30 && j>-1){
                        if(jugadorActual.casillas[iValor][j].porcentajeVida>0){
                            String datosCasillas="Casilla"+"["+iValor+"]"+"["+j+"]:"+" estaba en las líneas de Poseidon. Su porcentaje de vida de: "+jugadorActual.casillas[iValor][j].porcentajeVida+" pasa a: 0.\n";
                            jugadorActual.casillas[iValor][j].historialAtaquesTotales+=datosCasillas;
                            jugadorActual.casillas[iValor][j].historialAtaques=datosCasillas;
                            jugadorActual.setLogJugadorRecibido(datosCasillas);
                            jugadorActual.casillas[iValor][j].ataqueReciente=true;
                        }
                    }
                }
        }
    }
    
}
