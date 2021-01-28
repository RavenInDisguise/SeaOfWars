/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command;

import Logica.Jugador;
import Logica.Luchador;

public class CrearPersonajeCommand extends BaseCommand {       
    public static final String COMMAN_NAME = "CREARPERSONAJE";       
    
    
    @Override
    public String mostrarInstrucciones(){
        String instrucciones="Ingrese un nombre:"
                                + "Ingrese un grupo entre (Thunders under the sea, Fish telepathy, Release the kraken, Waves Control, The trident, Undersea volcanoes):"
                                + "Ingrese el porcentaje que representa para la civilizacion:"
                                + "Ingrese su porcentaje de poder:"
                                + "Ingrese su porcentaje de resistencia:"
                                + "Ingrese su porcentaje de sanidad:"
                                + "Ingrese el url de su imagen:"
                                + "TODO ESTO EN ORDEN Y DIVIDIDO POR - SIN ESPACIOS \n";
     return instrucciones;
    }
    
    @Override
    public String execute(String datosText, Jugador jugador) {      
        /*
        String nombreLuchador; 1
        String Grupo; 2
        int porcentajeCivilizacion; 3
        int poderLuchador; 4
        int resistenciaLuchador; 5
        int SanidadLuchador; 6
        String rutaImagen; 7
        */
        System.out.println(datosText);
        String[] datos=splitCommands(datosText);
        //datos[2].toLowerCase();
        Luchador luchadorNuevo = new Luchador(datos[1].trim(),datos[2].trim() ,Integer. parseInt(datos[3].trim()),Integer. parseInt(datos[4].trim()),Integer. parseInt(datos[5].trim()),Integer. parseInt(datos[6].trim()),datos[7].trim());
        jugador.agregarLuchador(luchadorNuevo);
        return "Luchador agregado exitosamente.";
    }       
    @Override           
    public String getCommandName() {           
        return COMMAN_NAME;   
    }   

    @Override
    public String[] splitCommands(String datostxt) {
        String[] datos=datostxt.split("-");
        return datos;
    }

}

