/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command;

import java.io.OutputStream;

public abstract class BaseCommand implements ICommand {       
    
    @Override       
    public abstract String getCommandName();       
      
    public abstract void execute();       
    
    public void write(String message) {           
        try {   
            //Escribir en TextArea
        } 
        catch (Exception e) {   
            e.printStackTrace();   
        }   
    }   
}

