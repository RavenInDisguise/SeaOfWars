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

                    case 2: //Pasan un mensaje por el chat
                        String usuario1 = reader.readUTF();
                        String mensaje = reader.readUTF();
                        refPantalla.addMensaje(usuario1+": " + mensaje);
                    break;
                    case 3: //Instrucciones
                        String mensajeRetorno1 = reader.readUTF();
                        refPantalla.addMensaje(mensajeRetorno1);
                    break;
                    case 4: //Comandos generales
                        String mensajeRetorno2 = reader.readUTF();
                        refPantalla.addBitacora(mensajeRetorno2);
                    break;
                    case 5: //Ingresar persona
                        String usuario=reader.readUTF();
                        refPantalla.addBitacora("Ingresó el jugador: "+usuario+".\n");
                    break;
                    case 6: //Llenar pantalla
                        int valor1=reader.readInt();
                        String nombre1=reader.readUTF();
                        int casillas1=reader.readInt();
                        int valor2=reader.readInt();
                        String nombre2=reader.readUTF();
                        int casillas2=reader.readInt();
                        int valor3=reader.readInt();
                        String nombre3=reader.readUTF();
                        int casillas3=reader.readInt();
                        refPantalla.rellenarLabelsLuchadores(valor1, nombre1, casillas1, valor2, nombre2, casillas2, valor3, nombre3, casillas3);
                    break;
                    case 7:
                        int i=reader.readInt();
                        int j=reader.readInt();
                        String color=reader.readUTF();
                        refPantalla.pintarMatriz(i, j, color);
                    break;
                    default:
                }
            } catch (IOException ex) {
                
            }
    }
    }
}
