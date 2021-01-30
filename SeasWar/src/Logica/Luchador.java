/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Strategy.Cardumen;
import Strategy.ControlKraken;
import Strategy.EelAttack;
import Strategy.IAtacar;
import Strategy.KrakenBreath;
import Strategy.PoseidonThunders;
import Strategy.Pulp;
import Strategy.ReleaseKraken;
import Strategy.SharkAttack;
import Strategy.Tentaculos;
import Strategy.TermalRush;
import Strategy.ThreeLines;
import Strategy.ThreeNumbers;
import Strategy.ThunderRain;
import Strategy.VolcanoExplosion;
import Strategy.VolcanoRaising;

/**
 *
 * @author monic
 */
public class Luchador{
    String nombreLuchador;
    String Grupo;
    int porcentajeCivilizacion;
    int poderLuchador;
    int resistenciaLuchador;
    int SanidadLuchador;  
    int porcentajeAumentado=1;
    String urlImagen;
    IAtacar iataque;

    public Luchador(String nombreLuchador, String Grupo, int porcentajeCivilizacion, int poderLuchador, int resistenciaLuchador, int SanidadLuchador, String url) {
        this.nombreLuchador = nombreLuchador;
        this.Grupo = Grupo;
        this.porcentajeCivilizacion = porcentajeCivilizacion;
        this.poderLuchador = poderLuchador;
        this.resistenciaLuchador = resistenciaLuchador;
        this.SanidadLuchador = SanidadLuchador;
        this.urlImagen=url;
    }

    public IAtacar getIataque() {
        return iataque;
    }

    public void setIataque(IAtacar iataque) {
        this.iataque = iataque;
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

    public void asignarAtaques(String ataque){ 
        ataque=ataque.toUpperCase().trim();
        if(ataque.equals("SANIDAD")){ 
            
        }else if(ataque.equals("RESISTENCIA")){
        
        }else if(ataque.equals("FUERZA")){
            
        }else{
            if(null == this.Grupo.toLowerCase()){
                System.out.println("No existe tal grupo.");
            }else
            OUTER:
            switch (this.Grupo.toLowerCase()) {
                case "thunders under the sea":
                    switch (ataque) {
                        case "THUNDER RAIN":
                            iataque=new ThunderRain();
                            break;
                        case "POSEIDON THUNDERS":
                            iataque=new PoseidonThunders();
                            break;
                        default: //EEL ATTACK
                            iataque=new EelAttack();
                            break;
                        }
                    break;
                case "fish telepathy":
                    switch (ataque) {
                        case "CARDUMEN":
                            iataque=new Cardumen();
                            break;
                        case "SHARK ATTACK":
                            iataque=new SharkAttack();
                            break;
                        default: //PULP
                            iataque=new Pulp();
                            break;
                    }
                    break;
                case "release the kraken":
                    switch (ataque) {
                        case "TENTACULOS":
                            iataque=new Tentaculos();
                            break;
                        case "KRAKEN BREATH":
                            iataque=new KrakenBreath();
                            break;
                        case "RELEASE THE KRAKEN":
                            iataque=new ReleaseKraken();
                            break;
                        default:
                    }
                case "waves control":

                    break;
                case "the trident":
                    switch (ataque) {
                        case "THREE LINES":
                            iataque=new ThreeLines();
                            break;
                        case "THREE NUMBERS":
                            iataque=new ThreeNumbers();
                            break;
                        case "CONTROL THE KRAKEN":
                            iataque=new ControlKraken();
                        default:
                            break;
                    }
                case "undersea volcanoes":
                    switch (ataque) {
                        case "VOLCANO RAISING":
                            iataque=new VolcanoRaising();
                            break;
                        case "VOLCANO EXPLOSION":
                            iataque=new VolcanoExplosion();
                            break;
                        case "TERMAL RUSH":
                            iataque=new TermalRush();
                        default:
                            break;
                    }
                    break;
                default:
                    System.out.println("No existe tal grupo.");
                    break;
            }
        }
    }  
}


