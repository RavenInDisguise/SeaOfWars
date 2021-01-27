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

public class MensajeCommand extends BaseCommand {       
    public static final String COMMAN_NAME = "MENSAJE";       
    
    
    @Override
    public String mostrarInstrucciones(){
        String instrucciones="Si desea enviar un mensaje general, escriba MENSAJE-GENERAL-texto a enviar. \n"
                                + "Si desea enviar un mensaje privado, escriba MENSAJE-nombre del jugador-texto a enviar. \n";
     return instrucciones;
    }
    
    @Override
    public String execute(String datosText, Jugador jugador) {      
        
        System.out.println(datosText);
        String[] datos=splitCommands(datosText);
        return datos[2];
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