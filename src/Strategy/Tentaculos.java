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
public class Tentaculos implements IAtacar {

    @Override
    public void atacarCasillas(Jugador jugadorActual,String[] arrayComandos) {
        Random rand = new Random();
        for (int i=0; i<3; i++){
            int irandom = rand.nextInt(20);
            int jrandom = rand.nextInt(30);
            if(jugadorActual.casillas[irandom][jrandom].porcentajeVida>0){
                String datosCasilla="Casilla"+"["+irandom+"]"+"["+jrandom+"]:"+" tiene un tentáculo. Su porcentaje de vida de: "+jugadorActual.casillas[irandom][jrandom].porcentajeVida+" pasa a: 0.\n";
                jugadorActual.casillas[irandom][jrandom].historialAtaquesTotales+=datosCasilla;
                jugadorActual.casillas[irandom][jrandom].historialAtaques=datosCasilla;
                jugadorActual.setLogJugadorRecibido(datosCasilla);
                jugadorActual.casillas[irandom][jrandom].porcentajeVida=0;
                jugadorActual.casillas[irandom][jrandom].ataqueReciente=true; 
            }
            atacarRadio(irandom,jrandom,jugadorActual);
        }
        
    } 
    
    public void atacarRadio(int i, int j, Jugador jugadorActual){
        int iRef=i;
        int jRef=j;
        for(int k=0; k<3; k++){
            iRef=i;
             switch(k){
                 case 0:
                     iRef=i;
                     break;
                 case 1:
                     iRef+=1;
                     break;
                 case 2:
                     iRef-=1;
                     break;
                 case 3:
                     iRef-=1;
                     break;
                 default:  
             }
      
            for(int l=0; l<3; l++){
                jRef=j;
                 switch(l){
                    case 0:
                        jRef=j;
                        break;
                    case 1:
                        jRef+=1;
                        break;
                    case 2:
                        jRef-=1;
                        break;
                    case 3:
                        jRef-=1;
                        break;
                    default: 
                 }
                 System.out.println(iRef+","+jRef);
                 if(iRef<20 && iRef>-1){
                     if(jRef<30 && jRef>-1){
                         if(jugadorActual.casillas[iRef][jRef].porcentajeVida>0){
                         String datosCasilla="Casilla"+"["+iRef+"]"+"["+jRef+"]:"+" fue afectada por el radio de un tentáculo. Su porcentaje de vida de: "+jugadorActual.casillas[iRef][jRef].porcentajeVida+" pasa a: 0.\n";
                         jugadorActual.casillas[iRef][jRef].historialAtaquesTotales+=datosCasilla;
                         jugadorActual.casillas[iRef][jRef].historialAtaques=datosCasilla;
                         jugadorActual.setLogJugadorRecibido(datosCasilla);
                         jugadorActual.casillas[iRef][jRef].porcentajeVida=0;
                         jugadorActual.casillas[iRef][jRef].ataqueReciente=true;
                         }
                     }
                 }
            }
         
        }
    } 
}
