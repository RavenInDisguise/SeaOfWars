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
public class VolcanoExplosion implements IAtacar{

    @Override
    public void atacarCasillas(Jugador jugadorActual, String[] arrayComandos) {
        Random rand = new Random();
        for (int i = 0; i <20; i++){
            for (int j = 0; j <30; j++){ 
                if(jugadorActual.casillas[i][j].volcan){
                    int cantidadPiedras=(int) Math.floor(Math.random()*(2-4+1)+4);
                    generarPiedras(jugadorActual,cantidadPiedras);
                }
            }
        }
    }
    
    public void generarPiedras(Jugador jugadorActual, int piedras){
        Random rand = new Random();
        for(int i=0; i<piedras;i++){
            
        
        }
    }
        
    
}
