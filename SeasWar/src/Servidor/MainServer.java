/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

import java.io.IOException;

/**
 *
 * @author diemo
 */
public class MainServer {
    public static void main(String[] args) throws IOException {
        ServerForm  pantalla = new ServerForm();
        Servidor srv = new Servidor(pantalla);
        pantalla.setVisible(true);
        srv.runServer();
        
    }
}
