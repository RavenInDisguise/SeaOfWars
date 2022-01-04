/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command;

import Logica.Jugador;

/**
 *
 * @author monic
 */
public class EnviarNum extends BaseCommand {       
    public static final String COMMAN_NAME = "ENVIARNUM"; 

    @Override
    public String getCommandName() {
        return COMMAN_NAME;
    }

    @Override
    public String execute(String datos, Jugador jugador) {
        return datos;
        
    }

    @Override
    public String mostrarInstrucciones() {
        return "Se utiliza para el ataque Three Numbers. \n";
    }

    @Override
    public String[] splitCommands(String datostxt) {
        String[] datos=datostxt.split("-");
        return datos;
    }
    
}
