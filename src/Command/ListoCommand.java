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

public class ListoCommand extends BaseCommand {       
    public static final String COMMAN_NAME = "LISTO";       
    
    
    @Override
    public String mostrarInstrucciones(){
        String instrucciones="Utilice este comando para indicar que está listo para jugar. \n";
     return instrucciones;
    }
    
    @Override
    public String execute(String datosText, Jugador jugador) {      
        String mensaje;
        if(jugador.getSizeLuchadores()==3){
            mensaje="true";
        }else{
            mensaje="false";
        }
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