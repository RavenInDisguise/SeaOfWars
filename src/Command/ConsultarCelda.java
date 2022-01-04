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
public class ConsultarCelda implements ICommand{
    public static final String COMMAND_NAME = "CONSULTARCELDA";
    @Override
    public String getCommandName() {
        return COMMAND_NAME;
    }

    @Override
    public String execute(String datosText, Jugador jugador) {
        System.out.println(datosText);
        String[] datos=splitCommands(datosText);
        int i=parseInt(datos[1].trim());
        int j=parseInt(datos[2].trim());
        return jugador.getCasillas()[i][j].historialAtaquesTotales;
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