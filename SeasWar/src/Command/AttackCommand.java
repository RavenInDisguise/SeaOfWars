/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command;

import Strategy.Tentaculos;
import Logica.Jugador;

/**
 *
 * @author monic
 */
public class AttackCommand implements ICommand{
    public static final String COMMAND_NAME = "ATTACK"; 
    @Override
    public String getCommandName() {
        return COMMAND_NAME;   
    }

    @Override
    public String execute(String datos, Jugador jugador) {
        String datosArray[]=splitCommands(datos);
        for(int i=0; i<jugador.getLuchadores().size();i++){
                jugador.getLuchadores().get(i).asignarAtaques(datosArray[3]);
                jugador.getLuchadores().get(i).getIataque().atacarCasillas(jugador, datosArray);
        }
        return "Ataque ejecutado a: "+datosArray[2];
        
    }

    @Override
    public String mostrarInstrucciones() {
        String instrucciones="Release the kraken:"
                + "-Tentaculos: "
                +"-Kraken breath: Escriba un x,y para que se destruyan de 1 a 8 casillas en alguna direccion.";
        return instrucciones;
       
    }

    @Override
    public String[] splitCommands(String datostxt) {
        String[] datos=datostxt.split("-");
        return datos;
    }
    
}
