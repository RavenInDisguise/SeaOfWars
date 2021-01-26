/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

import Logica.Juego;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author diemo
 */
public class Servidor {
        
    ServerForm refPantalla;
    public ArrayList<ThreadServidor> conexiones;
    private boolean running = true;
    private ServerSocket srv;
    protected Juego juegoActual;
    private boolean partidaIniciada = false;

    public Servidor(ServerForm refPantalla) {
        this.refPantalla = refPantalla;
        this.conexiones = new ArrayList<ThreadServidor>();
        this.refPantalla.setSrv(this);
        
    }
    
    public void stopserver(){
        running = false;
    }
    
    public void runServer() throws IOException{
        this.juegoActual = Juego.getSingletonInstance();
        int contador = 0;
        srv = new ServerSocket(35775);
        
        while(running){
            if (!partidaIniciada){ 
                refPantalla.addMensaje(".: Esperando conexiones");
                Socket refSocket = srv.accept();
                refPantalla.addMensaje(".: Conexion realizada: " + (++contador));
            
            
                // Thread
                ThreadServidor newThread = new ThreadServidor(refSocket, this, juegoActual);
                conexiones.add(newThread);
                newThread.start();
            }else{
                    // OutputStream socket para poder hacer un writer
                    refPantalla.addMensaje(":Conexión denegada: partida iniciada.");
                }
        }
    }
    
    
}
