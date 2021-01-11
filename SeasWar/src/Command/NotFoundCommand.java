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
    private static final String COMMAND_NAME = "NOT_FOUND";       
    
    @Override       
    public String getCommandName() {           
        return COMMAND_NAME;   
    }   

    /**
     *
     * @param datos
     * @param txtArea_Command
     * @param jugador
     */
    @Override
    public void execute(String[] datos, JTextArea txtArea_Command, Jugador jugador) {
        txtArea_Command.append("El comando escrito no existe. Intente de nuevo.");//To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void mostrarPantalla(JTextArea txtArea_Command) {
        txtArea_Command.append("*****************************");
    }
}
