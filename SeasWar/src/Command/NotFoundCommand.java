/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command;

import java.io.OutputStream;

public class NotFoundCommand extends BaseCommand {       
    private static final String COMMAND_NAME = "NOT FOUND";       
    
    @Override       public String getCommandName() {           
        return COMMAND_NAME;   
    }       

    @Override
    public void execute() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
