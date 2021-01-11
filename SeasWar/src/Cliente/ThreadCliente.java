/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;

import seaswar.SeasWarPantalla;
import java.awt.Color;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author diemo
 */
public class ThreadCliente extends Thread{
    private Socket socketRef;
    public DataInputStream reader;
    public DataOutputStream writer;
    private String nombre;
    private boolean running = true;
    private SeasWarPantalla refPantalla;

    public ThreadCliente(Socket socketRef, SeasWarPantalla refPantalla) throws IOException {
        this.socketRef = socketRef;
        reader = new DataInputStream(socketRef.getInputStream());
        writer = new DataOutputStream(socketRef.getOutputStream());
        this.refPantalla = refPantalla;
    }
    
    public void run (){
        
        int instruccionId = 1;
        while (running){
            try {
                instruccionId = reader.readInt(); // esperar hasta que reciba un entero
                
                switch (instruccionId){

                    case 2: // pasan un mensaje por el chat
                        String usuario1 = reader.readUTF();
                        String mensaje = reader.readUTF();
                        //System.out.println("CLIENTE Recibido mensaje: " + mensaje);
                        refPantalla.addMensaje(usuario1+": " + mensaje);
                    break;
                    case 3: // pasan un mensaje por el chat
                        String usuario2 = reader.readUTF();
                        int valorDados = reader.readInt();
                        //System.out.println("CLIENTE Recibido mensaje: " + mensaje);
                        refPantalla.addMensaje("");
                       // refPantalla.btnEnviar.setBackground(Color.red);
                        //refPantalla.btnEnviar.setText("Dados: " + valorDados);
                    case 4:
                       String usuario3 = reader.readUTF();
                       //refPantalla.addUser(usuario3);
                }
            } catch (IOException ex) {
                
            }
    }
    }
}
