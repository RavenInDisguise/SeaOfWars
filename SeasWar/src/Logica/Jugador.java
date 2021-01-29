/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.ArrayList;

/**
 *
 * @author monic
 */
public class Jugador {
    protected String nombreUsuario;
    protected String logJugadorRecibido="Ataques recibidos: \n";
    protected String logJugadorEnviado="Ataques enviados: \n";
    protected ArrayList<Luchador> luchadores=new ArrayList<>();
    public Casilla [][]casillas = new Casilla[20][30];
    public boolean turno = false;
    
    public Jugador(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public boolean isTurno() {
        return turno;
    }

    public void setTurno(boolean turno) {
        this.turno = turno;
    }
    
    public String getLogJugadorEnviado() {
        return logJugadorEnviado;
    }

    public void setLogJugadorEnviado(String logJugadorEnviado) {
        this.logJugadorEnviado = logJugadorEnviado;
    }

    public String getLogJugadorRecibido() {
        return logJugadorRecibido;
    }

    public void setLogJugadorRecibido(String logJugador) {
        this.logJugadorRecibido += logJugador;
    }

    public Casilla[][] getCasillas() {
        return casillas;
    }

    public void setCasillas(Casilla[][] casillas) {
        this.casillas = casillas;
    }
    
    public void agregarLuchador(Luchador luchador){
        luchadores.add(luchador);
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public ArrayList<Luchador> getLuchadores() {
        return luchadores;
    }

    public void setLuchadores(ArrayList<Luchador> luchadores) {
        this.luchadores = luchadores;
    }
    
    public int getSizeLuchadores(){
        return luchadores.size();
    }

    public Casilla[][] getMatrizCasillas() {
        return casillas;
    }

    public void setMatrizCasillas(Casilla[][] matrizCasillas) {
        this.casillas = matrizCasillas;
    }
    
    public void generarMatrizCasillas(Luchador luchador1, Luchador luchador2, Luchador luchador3) {
    int cantidad1 = (luchador1.porcentajeCivilizacion*600)/100; //GRIS 
    int cantidad2 = (luchador2.porcentajeCivilizacion*600)/100; //AZUL 
    int cantidad3 = (luchador3.porcentajeCivilizacion*600)/100; //VERDE 
    int cont1 = 0;
    int cont2 = 0;
    int cont3 = 0;
  
     for(int r=0; r<20; r++){
        for(int c=0; c<30; ){
            System.out.println("ewe");
            casillas[r][c] = new Casilla("","blanco",null,null,r,c);
            int caso = (int) (Math.random() * 3) + 1;
            switch (caso) {
                case 1:
                    if (cont1<cantidad1){
                        casillas[r][c].setLuchadorRepresentado(luchador1);
                        casillas[r][c].setColor("gris");
                        cont1+=1;
                        c++;
                        continue;
                    }else{
                        continue;
                    }
                case 2:
                    if (cont2<cantidad2){
                        casillas[r][c].setLuchadorRepresentado(luchador2);
                        casillas[r][c].setColor("azul");
                        cont2+=1;
                        c++;
                        continue;
                    }else{
                        continue;
                    }
                default:
                    if (cont3<cantidad3){
                        casillas[r][c].setLuchadorRepresentado(luchador3);
                        casillas[r][c].setColor("verde");
                        cont3+=1;
                        c++;
                        continue;
                    }else{
                        continue;
                    }
                }
            }
        
    }

    for (int i = 0; i <20; i++) // El primer índice recorre las filas.
	for (int j = 0; j <30; j++){ // El segundo índice recorre las columnas.
	// Procesamos cada elemento de la matriz.
            System.out.println(casillas[i][j].luchadorRepresentado);
        }
    }   
}
