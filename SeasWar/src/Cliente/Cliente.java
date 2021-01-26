/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;

import Logica.Jugador;
import java.net.Socket;
import javax.swing.JOptionPane;
import seaswar.SeasWarPantalla;

/**
 *
 * @author diemo
 */
public class Cliente {
    Socket socketRef;
    SeasWarPantalla refPantalla;
    public ThreadCliente hiloCliente;

    public Cliente(SeasWarPantalla refPantalla) {
        this.refPantalla = refPantalla;
        refPantalla.setRefCliente(this);
    }
    
    public void conectar(){
 
        try{
            socketRef = new Socket("localhost", 35775);
            hiloCliente = new ThreadCliente(socketRef, refPantalla);
            hiloCliente.start();
            
            String nombre = JOptionPane.showInputDialog("Introduzca un nickname:");
            hiloCliente.writer.writeInt(1); //instruccion para el switch del thread servidor
            hiloCliente.writer.writeUTF(nombre); //instruccion para el switch del thread servidor
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        
        
    }
}
