/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Strategy;

import Logica.Jugador;

/**
 *
 * @author monic
 */
public class ThreeNumbers implements IAtacar{

    @Override
    public void atacarCasillas(Jugador jugadorActual, String[] arrayComandos) {
       int num1=Integer.parseInt(arrayComandos[4]);
       int num2=Integer.parseInt(arrayComandos[5]);
       int num3=Integer.parseInt(arrayComandos[6]);
       
       for(int i=0;i<jugadorActual.getNumeros().size();i++){
           if(jugadorActual.getNumeros().get(i)==num1 ||
           jugadorActual.getNumeros().get(i)==num2 ||
           jugadorActual.getNumeros().get(i)==num3){
               int cantidad=num1*num2*num3;
               atacarMatriz(cantidad, jugadorActual);
           }
       }
    }
    
    public void atacarMatriz(int contador, Jugador jugadorActual){
    for (int i = 0; i <20; i++){ // El primer índice recorre las filas.
            for (int j = 0; j <30; j++){
                if(jugadorActual.getMatrizCasillas()[i][j].porcentajeVida>0){
                    
                }
            }
    }
    } 
}
