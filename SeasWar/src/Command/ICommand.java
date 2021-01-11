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

public interface ICommand {       
    public String getCommandName();       
    public void execute(String[] datos, JTextArea txtArea_Command, Jugador jugador); 
    public void mostrarPantalla(JTextArea txtArea_Command);
}
