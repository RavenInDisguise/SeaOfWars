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
public class AttackCommand implements ICommand{
    public static final String COMMAND_NAME = "ATTACK"; 
    Jugador atacante;
    int contador=0;
    @Override
    public String getCommandName() {
        return COMMAND_NAME;   
    }

    public String execute(String datos, Jugador jugador) {
        if(contador==0){
            this.atacante=jugador;
            System.out.println(atacante.getNombreUsuario());
            contador++;
        }else{
            String datosArray[]=splitCommands(datos);
            System.out.println(jugador.getNombreUsuario());
            for(int i=0; i<atacante.getLuchadores().size();i++){
                    System.out.println(jugador.getNombreUsuario());
                    System.out.println(datosArray[3]);
                    if(atacante.getLuchadores().get(i).getNombreLuchador().trim().toUpperCase().equals(datosArray[1].trim().toUpperCase())){
                        if(datosArray[3].equals("CONTROL THE KRAKEN")){
                            if(atacante.isAtacadoRelease()){
                                atacante.getLuchadores().get(i).asignarAtaques(datosArray[3]);
                                atacante.getLuchadores().get(i).getIataque().atacarCasillas(jugador, datosArray);
                                atacante.setAtacadoRelease(false);
                            }     
                        }else{
                            atacante.getLuchadores().get(i).asignarAtaques(datosArray[3]);
                            atacante.getLuchadores().get(i).getIataque().atacarCasillas(jugador, datosArray);
                    
                        }
                    }
            }
            contador=0;
            return "Ataque ejecutado a: "+datosArray[2];    
        }
        return "";
    }

    @Override
    public String mostrarInstrucciones() {
        String instrucciones="Release the kraken:\n"
                +"-Tentaculos: ATTACK-NOMBRE PERSONAJE-PERSONA A ATACAR-TIPO DE ATAQUE\n"
                +"-Kraken breath: ATTACK-NOMBRE PERSONAJE-PERSONA A ATACAR-TIPO DE ATAQUE\n"
                +"-Release the kraken: ATTACK-NOMBRE PERSONAJE-PERSONA A ATACAR-TIPO DE ATAQUE\n"
                +"The trident:\n"
                +"-Three lines: ATTACK-NOMBRE PERSONAJE-PERSONA A ATACAR-TIPO DE ATAQUE-X1-Y1-X2-Y2-X3-Y3\n"
                +"-Three numbers: ATTACK-NOMBRE PERSONAJE-PERSONA A ATACAR-TIPO DE ATAQUE-NUM1-NUM2-NUM3\n"
                +"-Control the kraken: ATTACK-NOMBRE PERSONAJE-PERSONA A ATACAR-TIPO DE ATAQUE\n";

        return instrucciones;
       
    }

    @Override
    public String[] splitCommands(String datostxt) {
        String[] datos=datostxt.split("-");
        return datos;
    }
    
}
