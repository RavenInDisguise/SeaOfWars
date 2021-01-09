/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

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

    public Servidor(ServerForm refPantalla) {
        this.refPantalla = refPantalla;
        conexiones = new ArrayList<ThreadServidor>();
        this.refPantalla.setSrv(this);
    }
    
    public void stopserver(){
        running = false;
    }
    
    public void runServer() throws IOException{
        
        int contador = 0;
        srv = new ServerSocket(35775);
        
        while(running){
            refPantalla.addMensaje(".: Esperando conexiones");
            Socket refSocket = srv.accept();
            refPantalla.addMensaje(".: Conexion realizada: " + (++contador));
            
            // Thread
            ThreadServidor newThread = new ThreadServidor(refSocket, this);
            conexiones.add(newThread);
            newThread.start();
        }
    }
    
    
}
