/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command;

import java.io.OutputStream;

public interface ICommand {       
    public String getCommandName();       
    public void execute(); 
}
