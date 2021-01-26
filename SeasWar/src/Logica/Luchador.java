/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Strategy.Atacar;
import Strategy.FishTelepathy;
import Strategy.IAtacar;
import Strategy.ReleaseKraken;
import Strategy.TheTrident;
import Strategy.Thunders;
import Strategy.Undersea;
import Strategy.WavesControl;

/**
 *
 * @author monic
 */
public class Luchador implements IAtacar{
    String nombreLuchador;
    String Grupo;
    int porcentajeCivilizacion;
    int poderLuchador;
    int resistenciaLuchador;
    int SanidadLuchador;  
    String urlImagen;
    Atacar ataque;

    public Luchador(String nombreLuchador, String Grupo, int porcentajeCivilizacion, int poderLuchador, int resistenciaLuchador, int SanidadLuchador, String url) {
        this.nombreLuchador = nombreLuchador;
        this.Grupo = Grupo;
        this.porcentajeCivilizacion = porcentajeCivilizacion;
        this.poderLuchador = poderLuchador;
        this.resistenciaLuchador = resistenciaLuchador;
        this.SanidadLuchador = SanidadLuchador;
        this.urlImagen=url;
        this.ataque=new Atacar();
       
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

    @Override
    public void atacarCasillas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void asignarAtaques(){ 
        if("thunders under the sea".equals(this.Grupo)){
            Atacar Thunders = new Thunders();
            ataque=Thunders;
            ataque=(Thunders)ataque;
        }else if("fish telepathy".equals(this.Grupo)){ 
            Atacar FishTelepathy = new FishTelepathy();
            ataque=FishTelepathy;
            ataque=(FishTelepathy)ataque;
        }else if("release the kraken".equals(this.Grupo)){ 
            Atacar ReleaseKraken = new ReleaseKraken();
            ataque=ReleaseKraken;
            ataque=(ReleaseKraken)ataque;
        }else if("waves control".equals(this.Grupo)){
            Atacar WavesControl = new WavesControl();
            ataque=WavesControl;
            ataque=(WavesControl)ataque;
        }else if("the trident".equals(this.Grupo)){
            Atacar TheTrident=new TheTrident();
            ataque=TheTrident;
            ataque=(TheTrident)ataque;
        }else if("undersea volcanoes".equals(this.Grupo)){ 
            Atacar Undersea=new Undersea();
            ataque=Undersea;
            ataque=(Undersea)ataque;
        }else{
            System.out.println("No existe tal grupo.");
        }
    }
    
}


