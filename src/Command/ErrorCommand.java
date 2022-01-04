/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command;

import Logica.Jugador;
import java.awt.TextArea;
import java.io.OutputStream;
import javax.swing.JTextArea;
import seaswar.SeasWarPantalla;

public class ErrorCommand extends BaseCommand {       
    private static final String COMMAND_NAME = "ERROR";       
    
    @Override       
    public String getCommandName() {           
        return COMMAND_NAME;   
    }       
   
    @Override
    public String execute(String datos, Jugador jugador) {
       String instrucciones="El comando escrito presenta un error. Intente de nuevo.";
       return instrucciones;
    }

    @Override
    public String mostrarInstrucciones() {
       String instrucciones="El comando se presenta cuando ocurre un error.";
       return instrucciones;
    }

    @Override
    public String[] splitCommands(String datostxt) {
        String[] datos= datostxt.split("-");
        return datos;
    }
    
}

