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
public class Rendirse implements ICommand{
    public static final String COMMAND_NAME = "RENDIRSE"; 
    @Override
    public String getCommandName() {
        return COMMAND_NAME;
    }

    @Override
    public String execute(String datos, Jugador jugador) {
        return "El jugador de este turno decidió rendirse. Qué débil.\n";
    }

    @Override
    public String mostrarInstrucciones() {
        return "Se utiliza cuando un jugador desea rendirse.\n";
    }

    @Override
    public String[] splitCommands(String datostxt) {
        String[] datos=datostxt.split("-");
        return datos;
    }
}
