/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

/**
 *
 * @author monic
 */
public class Luchador {
    String nombreLuchador;
    String Grupo;
    int porcentajeCivilizacion;
    int poderLuchador;
    int resistenciaLuchador;
    int SanidadLuchador;  
    String urlImagen;

    public Luchador(String nombreLuchador, String Grupo, int porcentajeCivilizacion, int poderLuchador, int resistenciaLuchador, int SanidadLuchador, String url) {
        this.nombreLuchador = nombreLuchador;
        this.Grupo = Grupo;
        this.porcentajeCivilizacion = porcentajeCivilizacion;
        this.poderLuchador = poderLuchador;
        this.resistenciaLuchador = resistenciaLuchador;
        this.SanidadLuchador = SanidadLuchador;
        this.urlImagen=url;
    }
    
}


