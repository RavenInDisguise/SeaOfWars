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

    public String getNombreLuchador() {
        return nombreLuchador;
    }

    public void setNombreLuchador(String nombreLuchador) {
        this.nombreLuchador = nombreLuchador;
    }

    public String getGrupo() {
        return Grupo;
    }

    public void setGrupo(String Grupo) {
        this.Grupo = Grupo;
    }

    public int getPorcentajeCivilizacion() {
        return porcentajeCivilizacion;
    }

    public void setPorcentajeCivilizacion(int porcentajeCivilizacion) {
        this.porcentajeCivilizacion = porcentajeCivilizacion;
    }

    public int getPoderLuchador() {
        return poderLuchador;
    }

    public void setPoderLuchador(int poderLuchador) {
        this.poderLuchador = poderLuchador;
    }

    public int getResistenciaLuchador() {
        return resistenciaLuchador;
    }

    public void setResistenciaLuchador(int resistenciaLuchador) {
        this.resistenciaLuchador = resistenciaLuchador;
    }

    public int getSanidadLuchador() {
        return SanidadLuchador;
    }

    public void setSanidadLuchador(int SanidadLuchador) {
        this.SanidadLuchador = SanidadLuchador;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }
    
    
}


