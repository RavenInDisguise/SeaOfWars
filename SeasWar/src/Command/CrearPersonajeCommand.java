/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command;

import Logica.Jugador;
import Logica.Luchador;
import java.awt.TextArea;
import java.io.OutputStream;
import java.util.Arrays;
import javax.swing.JTextArea;
import seaswar.SeasWarPantalla;

public class CrearPersonajeCommand extends BaseCommand {       
    public static final String COMMAN_NAME = "CREAR_PERSONAJE";       
    
    
    public void mostrarPantalla(SeasWarPantalla pantalla){
        pantalla.txtArea_Command.append("Ingrese un nombre: \n"
                                + "Ingrese un grupo entre (Manta Negra, Poseidon y Aquaman: \n"
                                + "Ingrese el porcentaje que representa para la civilizacion: \n"
                                + "Ingrese su porcentaje de poder: \n"
                                + "Ingrese su porcentaje de resistencia: \n"
                                + "Ingrese su porcentaje de sanidad: \n"
                                + "Ingrese el url de su imagen: \n"
                                + "TODO ESTO EN ORDEN Y DIVIDIDO POR - SIN ESPACIOS \n");
    }
    @Override
    public void execute(String[] datos, SeasWarPantalla pantalla, Jugador jugador) {      
        /*
        String nombreLuchador; 1
        String Grupo; 2
        int porcentajeCivilizacion; 3
        int poderLuchador; 4
        int resistenciaLuchador; 5
        int SanidadLuchador; 6
        */
        Luchador luchadorNuevo = new Luchador(datos[1],datos[2],Integer. parseInt(datos[3]),Integer. parseInt(datos[4]),Integer. parseInt(datos[5]),Integer. parseInt(datos[6]),datos[7]);
        jugador.agregarLuchador(luchadorNuevo);
    }       
    @Override           
    public String getCommandName() {           
        return COMMAN_NAME;   
    }   

}

