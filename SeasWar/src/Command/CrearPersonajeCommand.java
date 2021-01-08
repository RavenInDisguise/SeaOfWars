/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command;

import java.io.OutputStream;
import java.util.Arrays;

public class CrearPersonajeCommand extends BaseCommand {       
    public static final String COMMAN_NAME = "CREAR PERSONAJE";       
    
    @Override
    public void execute() {      
        //Crea personajes
    }       @Override       
        
    public String getCommandName() {           
        return COMMAN_NAME;   
    }   

}

