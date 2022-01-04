/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command;

import Logica.Jugador;
import Logica.Luchador;
import java.awt.TextArea;
import java.io.OutputStream;
import java.util.Arrays;
import javax.swing.JTextArea;
import seaswar.SeasWarPantalla;

public class CaracteristicaCommand extends BaseCommand {       
    public static final String COMMAN_NAME = "CARACTERISTICA";       
    
    
    @Override
    public String mostrarInstrucciones(){
        String instrucciones="Formato de comando: CARACTERISTICA-SANIDAD/FUERZA/RESISTENCIA. \n"+
                "SANIDAD: En lugar de atacar, el luchador sana sus casillas no muertas, sino parcialmente heridas.\n"+
                "FUERZA: En lugar de atacar, el luchador aumentará la fuerza en su siguiente ataque.\n"+
                "RESISTENCIA: En lugar de atacar, el luchador protege sus casillas no muertas, sino parcialmente heridas.\n";
     return instrucciones;
    }
    
    @Override
    public String execute(String datosText, Jugador jugador) {      
        String mensaje;
        System.out.println(datosText);
        String[] datos=splitCommands(datosText);
        switch (datos[1].toUpperCase().trim()){
            case "SANIDAD":
                for (int i = 0; i <20; i++){
                    for (int j = 0; j <30; j++){ 
                        if(jugador.casillas[i][j].porcentajeVida>0){
                            int porGanar = (jugador.casillas[i][j].porcentajeVida*jugador.casillas[i][j].luchadorRepresentado.getSanidadLuchador())/100;
                            int suma = jugador.casillas[i][j].porcentajeVida+porGanar;
                            if(suma>100){
                                jugador.casillas[i][j].porcentajeVida = 100;
                            }else{
                                jugador.casillas[i][j].porcentajeVida = suma;
                            }
                        }
                    }
                }
            break;
            case "FUERZA":
                jugador.fuerza=true;
            break;
            case "RESISTENCIA":
                jugador.resistencia=true;
            break;
        }
        mensaje=jugador.getNombreUsuario()+" utilizó "+datos[1].toUpperCase().trim();
        return mensaje;
    }       
    @Override           
    public String getCommandName() {           
        return COMMAN_NAME;   
    }   

    @Override
    public String[] splitCommands(String datostxt) {
        String[] datos=datostxt.split("-");
        return datos;
    }

}