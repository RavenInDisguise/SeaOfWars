/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command;

import Logica.Jugador;
import static java.lang.Integer.parseInt;

/**
 *
 * @author monic
 */
public class LogCommand implements ICommand{
    public static final String COMMAND_NAME = "LOG";
    @Override
    public String getCommandName() {
        return COMMAND_NAME;
    }

    @Override
    public String execute(String datosText, Jugador jugador) {
        return "log";
    }

    @Override
    public String mostrarInstrucciones() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String[] splitCommands(String datostxt) {
        String[] datos=datostxt.split("-");
        return datos;
    }
    
}