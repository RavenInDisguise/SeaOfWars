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
        String resultado = "";
        String datosArray[]=splitCommands(datos);
        if (jugador.isTurno()){
            for(int i=0; i<jugador.getLuchadores().size();i++){ 
                System.out.println(jugador.getLuchadores().get(i).getNombreLuchador());
                System.out.println(datosArray[1].trim());
                if(jugador.getLuchadores().get(i).getNombreLuchador().equals(datosArray[1].trim())){
                    jugador.getLuchadores().get(i).asignarAtaques(datosArray[2]);
                    jugador.getLuchadores().get(i).getIataque().atacarCasillas(jugador, datosArray);
                    resultado = "Ataque ejecutado.";
                    }
                }
        }else{
            resultado = "Ataque no ejecutado, NO es su turno.";
        }
        return resultado;
        
    }

    @Override
    public String mostrarInstrucciones() {
        String instrucciones="Release the kraken:"
                + "-Tentaculos: Escriba 3 x,y para que aparezcan 3 tentaculos."
                +"-Kraken breath: Escriba un x,y para que se destruyan de 1 a 8 casillas en alguna direccion.";
        return instrucciones;
       
    }

    @Override
    public String[] splitCommands(String datostxt) {
        String[] datos=datostxt.split("-");
        return datos;
    }
    
}
