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
public class EelAttack implements IAtacar {

    @Override
    public void atacarCasillas(Jugador jugadorActual,String[] arrayComandos) {
        Random rand = new Random();
        int cantAnguilas = (int) Math.floor(Math.random()*(25-100+1)+100);
        System.out.println("anguilitas: "+cantAnguilas);
        for (int i=0; i<cantAnguilas;i++){
            int descargas = (int) Math.floor(Math.random()*(1-10+1)+10);
            int irandom = rand.nextInt(20);
            int jrandom = rand.nextInt(30);
            for (int j=0; j<descargas;j++){
                if(jugadorActual.casillas[irandom][jrandom].porcentajeVida>0){
                    int porcentajeActual = jugadorActual.casillas[irandom][jrandom].porcentajeVida;
                    jugadorActual.casillas[irandom][jrandom].porcentajeVida-=10;
                    String datosCasilla="Casilla"+"["+irandom+"]"+"["+jrandom+"]:"+" tiene una anguila. Su porcentaje de vida de: "+porcentajeActual+" pasa a: "+jugadorActual.casillas[irandom][jrandom].porcentajeVida+".\n";
                    jugadorActual.casillas[irandom][jrandom].historialAtaquesTotales+=datosCasilla;
                    jugadorActual.casillas[irandom][jrandom].historialAtaques=datosCasilla;
                    jugadorActual.setLogJugadorRecibido(datosCasilla);
                    jugadorActual.casillas[irandom][jrandom].ataqueReciente=true;
                    
                }
            }
        }
    } 
    
    
}
