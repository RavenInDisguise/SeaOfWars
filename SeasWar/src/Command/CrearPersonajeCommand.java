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

public class CrearPersonajeCommand extends BaseCommand {       
    public static final String COMMAN_NAME = "CREAR PERSONAJE";       
    
    
    public void mostrarPantalla(JTextArea txtArea_Command){
        txtArea_Command.append("Ingrese un nombre: \n"
                                + "Ingrese un grupo entre (Manta Negra, Poseidon y Aquaman: \n"
                                + "Ingrese el porcentaje que representa para la civilizacion: \n"
                                + "Ingrese su porcentaje de poder: \n"
                                + "Ingrese su porcentaje de resistencia: \n"
                                + "Ingrese su porcentaje de sanidad: \n"
                                + "Ingrese el url de su imagen: \n"
                
                                + "TODO ESTO EN ORDEN Y DIVIDIDO POR * SIN ESPACIOS \n");
    }
    @Override
    public void execute(JTextArea txtArea_Escribir, JTextArea txtArea_Command, Jugador jugador) {      
        String datosTxt=txtArea_Escribir.getText();
        String[] datos= datosTxt.split("*");
        
        /*
        String nombreLuchador; 0
        String Grupo; 1
        int porcentajeCivilizacion; 2
        int poderLuchador; 3
        int resistenciaLuchador; 4
        int SanidadLuchador; 5
        */
        Luchador luchadorNuevo = new Luchador(datos[0],datos[1],Integer. parseInt(datos[2]),Integer. parseInt(datos[3]),Integer. parseInt(datos[4]),Integer. parseInt(datos[5]),datos[6]);
        jugador.agregarLuchador(luchadorNuevo);
    }       
    @Override           
    public String getCommandName() {           
        return COMMAN_NAME;   
    }   

}

