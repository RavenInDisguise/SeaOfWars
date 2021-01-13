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
    public void execute(String[] datos, SeasWarPantalla pantalla, Jugador jugador) {
        pantalla.txtArea_Command.append("El comando escrito presenta un error. Intente de nuevo."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mostrarPantalla(SeasWarPantalla pantalla) {
        pantalla.txtArea_Command.append("*****************************");
    }
}

