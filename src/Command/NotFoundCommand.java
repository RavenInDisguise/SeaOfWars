/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command;

import Logica.Jugador;

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
    public String execute(String datos, Jugador jugador) {
        return "El comando escrito no existe. Intente de nuevo.";
    }

    @Override
    public String mostrarInstrucciones() {
        return "El comando escrito se presenta cuando el comando ingresado anteriormente no existe.";
    }

    @Override
    public String[] splitCommands(String datostxt) {
        String[] datos= datostxt.split("-");
        return datos;
    }
}