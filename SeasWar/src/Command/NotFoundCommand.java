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

public class NotFoundCommand extends BaseCommand {       
    private static final String COMMAND_NAME = "NOT FOUND";       
    
    @Override       public String getCommandName() {           
        return COMMAND_NAME;   
    }       

    @Override
    public void execute(JTextArea txtArea_Escribir, JTextArea txtArea_Command, Jugador jugador) {
        txtArea_Command.append("El comando escrito no existe. Intente de nuevo.");//To change body of generated methods, choose Tools | Templates.
    }
}
