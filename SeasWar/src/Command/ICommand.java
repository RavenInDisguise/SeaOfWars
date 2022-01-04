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

public interface ICommand {       
    public String getCommandName();       
    public String execute(String datos, Jugador jugador); 
    public String mostrarInstrucciones();
    public String[] splitCommands(String datos);
}
