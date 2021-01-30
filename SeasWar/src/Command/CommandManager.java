/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command;

import java.util.HashMap;

public class CommandManager {       
    private static CommandManager commandManager;       
    private static final HashMap<String, Class<? extends ICommand>> COMMANDS =          
            new HashMap<String, Class<? extends ICommand>>();       
    
    private CommandManager() {           
        registCommand(CrearPersonajeCommand.COMMAN_NAME, CrearPersonajeCommand.class);
        registCommand(AttackCommand.COMMAND_NAME, AttackCommand.class);
        registCommand(MensajeCommand.COMMAN_NAME, MensajeCommand.class);
        registCommand(ListoCommand.COMMAN_NAME, ListoCommand.class);
        registCommand(EnviarNum.COMMAN_NAME, EnviarNum.class);
        registCommand(Rendirse.COMMAND_NAME, Rendirse.class);
        registCommand(SaltarTurno.COMMAND_NAME, SaltarTurno.class);
        registCommand(CaracteristicaCommand.COMMAN_NAME, CaracteristicaCommand.class);
    }       
    
    public static synchronized CommandManager getIntance() {           
        if (commandManager == null) {               
            commandManager = new CommandManager();   
        }
        return commandManager;   
    }       
    
    public ICommand getCommand(String commandName) {           
        if (COMMANDS.containsKey(commandName.toUpperCase())) {               
            try {                   
                return COMMANDS.get(commandName.toUpperCase()).newInstance();
            } catch (Exception e) {   e.printStackTrace();                   
            return new ErrorCommand();   
            }           
        } 
        else {
            return new NotFoundCommand();   
        }   
    }       
    
    public void registCommand(String commandName, Class<? extends ICommand> command) {   
        COMMANDS.put(commandName.toUpperCase(), command);   
    }   
}

