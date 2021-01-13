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

public abstract class BaseCommand implements ICommand {       
    
    @Override       
    public abstract String getCommandName();       
      
    public abstract void execute(String[] datos, SeasWarPantalla pantalla, Jugador jugador);   
    
    public abstract void mostrarPantalla(SeasWarPantalla pantalla);
    
    public void write(String message) {           
        try {   
            //Escribir en TextArea
        } 
        catch (Exception e) {   
            e.printStackTrace();   
        }   
    }   
}

