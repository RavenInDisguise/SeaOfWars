/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

import Command.CommandManager;
import Command.ICommand;
import Logica.Casilla;
import Logica.Juego;
import Logica.Jugador;
import Logica.Luchador;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author diemo
 */
class ThreadServidor extends Thread{
    // DATOS DEL SERVER
    private Socket socketRef;
    private DataInputStream reader;
    private DataOutputStream writer;
    private boolean running = true;
    Servidor server;
    
    //DATOS DEL JUEGO
    Juego juegoActual;
    
    // DATOS DEL JUGADOR
    Jugador jugadorActual;
    private String nombre;
    
    //DATOS DEL COMMAND MANAGER
     CommandManager manager = CommandManager.getIntance();

    public ThreadServidor(Socket socketRef, Servidor server, Juego _juegoActual) throws IOException {
        this.socketRef = socketRef;
        reader = new DataInputStream(socketRef.getInputStream());
        writer = new DataOutputStream(socketRef.getOutputStream());
        this.server = server;
        this.juegoActual=_juegoActual;
    }
    
    public void run (){
        
        int instruccionId = 1;
        while (running){
            try {
                instruccionId = reader.readInt(); // esperar hasta que reciba un entero
                
                switch (instruccionId){
                    case 1: // pasan el nombre del usuario
                        nombre = reader.readUTF();      
                        writer.writeInt(5);
                        writer.writeUTF(nombre);
                        jugadorActual=new Jugador(nombre);
                        juegoActual.agregarJugadores(jugadorActual);
                        for(int i=0; i<juegoActual.getJugadores().size();i++){
                            System.out.println(juegoActual.getJugadores().get(i).getNombreUsuario());
                        }
                    break;
                    case 2: // pasan un mensaje por el chat
                        String mensaje = reader.readUTF();
                        
                        for (int i = 0; i < server.conexiones.size(); i++) {
                            ThreadServidor current = server.conexiones.get(i);
                            current.writer.writeInt(2);
                            current.writer.writeUTF(nombre);
                            current.writer.writeUTF(mensaje);
                        }
                    break;
                    case 3: //Comando de instrucciones
                        String datos1=reader.readUTF();
                        ICommand command1=manager.getCommand(datos1.trim());  
                        String mensajeRetorno1=command1.mostrarInstrucciones();
                        writer.writeInt(3);
                        writer.writeUTF(mensajeRetorno1);
                    break;
                    case 4: //Comandos generales
                        String datos2=reader.readUTF();
                        String[] datosArray=splitCommands(datos2);
                        ICommand command2=manager.getCommand(datosArray[0].trim());  
                        String mensajeRetorno2=command2.execute(datos2, jugadorActual);
                        /*for(int i=0; i<jugadorActual.getLuchadores().size();i++){
                            System.out.println("Luchadores "+jugadorActual.getLuchadores().get(i).getNombreLuchador());
                        }*/
                        writer.writeInt(4);
                        writer.writeUTF(mensajeRetorno2);
                     break;
                    case 5:  //Cargar matriz
                        try {
                            jugadorActual.generarMatrizCasillas(jugadorActual.getLuchadores().get(0),jugadorActual.getLuchadores().get(1),jugadorActual.getLuchadores().get(2));
                            for (int i = 0; i <20; i++){ // El primer índice recorre las filas.
                                for (int j = 0; j <30; j++){ 
                                    writer.writeInt(7);
                                    writer.writeInt(i);
                                    writer.writeInt(j);
                                    Casilla [][]casillasJugador = jugadorActual.getMatrizCasillas();
                                    writer.writeUTF(casillasJugador[i][j].color);
                                }
                             }
                           
                        } catch (IOException ex) {
                            Logger.getLogger(ThreadServidor.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    break; 
                    case 6:
                        try{
                            for(int i=0; i<jugadorActual.getLuchadores().size();i++){
                                int casillasVivas1=calcularCasillas(jugadorActual.getLuchadores().get(i));
                                int casillasTotales1=calcularCasillasTotales(jugadorActual.getLuchadores().get(i));
                                writer.writeInt(6);
                                writer.writeInt(i);
                                writer.writeUTF(jugadorActual.getLuchadores().get(i).getNombreLuchador());
                                writer.writeInt(casillasTotales1);
                                writer.writeInt(casillasVivas1);
                            }
                            
                        
                        }catch (IOException ex) {
                            Logger.getLogger(ThreadServidor.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    break;
                    default:
                        
                    
                    
                    
                }
            } catch (IOException ex) {
                
            }
        }
    } 
    
    public String[] splitCommands(String datostxt) {
        String[] datos=datostxt.split("-");
        return datos;
    }
    
    public int calcularCasillas(Luchador luchador){
        int contador=0;
         for (int i = 0; i <20; i++){ // El primer índice recorre las filas.
            for (int j = 0; j <30; j++){ 
                Casilla [][]casillasJugador = jugadorActual.getMatrizCasillas();
                if(casillasJugador[i][j].luchadorRepresentado.equals(luchador)){
                    if(casillasJugador[i][j].porcentajeVida>0){
                        contador++;
                    }

            }
            }
        }
        return contador;
    }
    
    public int calcularCasillasTotales(Luchador luchador){
        int contador=0;
         for (int i = 0; i <20; i++){ // El primer índice recorre las filas.
            for (int j = 0; j <30; j++){ 
                Casilla [][]casillasJugador = jugadorActual.getMatrizCasillas();
                if(casillasJugador[i][j].luchadorRepresentado.equals(luchador)){
                   contador++;
                    

                }
            }
        }
        return contador;
    }
}
