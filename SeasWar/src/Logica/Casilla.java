/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import javax.swing.JButton;

/**
 *
 * @author Jennifer
 */
public class Casilla {
    public int porcentajeVida=100;
    public String historialAtaques = "";
    public String historialAtaquesTotales = "";
    public String color;
    public Luchador luchadorRepresentado;
    public JButton refBoton;
    public int x;
    public int y;
    public boolean volcan=false;
    public boolean remolino=false;
    public int radioVolcan=0;
    public boolean ataqueReciente=false;

    public Casilla(String historialAtaques, String color, Luchador luchadorRepresentado, JButton refBoton, int x, int y) {
        this.historialAtaques = historialAtaques;
        this.color = color;
        this.luchadorRepresentado = luchadorRepresentado;
        this.refBoton = refBoton;
        this.x = x;
        this.y = y;
    }

    public int getPorcentajeVida() {
        return porcentajeVida;
    }

    public void setPorcentajeVida(int porcentajeVida) {
        this.porcentajeVida = porcentajeVida;
    }

    public String getHistorialAtaques() {
        return historialAtaques;
    }

    public void setHistorialAtaques(String historialAtaques) {
        this.historialAtaques = historialAtaques;
    }

    public Luchador getLuchadorRepresentado() {
        return luchadorRepresentado;
    }

    public void setLuchadorRepresentado(Luchador luchadorRepresentado) {
        this.luchadorRepresentado = luchadorRepresentado;
    }

    public JButton getRefBoton() {
        return refBoton;
    }

    public void setRefBoton(JButton refBoton) {
        this.refBoton = refBoton;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    
}

