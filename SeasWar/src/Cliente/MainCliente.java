/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;
import seaswar.SeasWarPantalla;

/**
 *
 * @author diemo
 */
public class MainCliente {
    
    public static void main(String[] args) {
        try{
        SeasWarPantalla  pantalla = new SeasWarPantalla();
        Cliente c = new Cliente(pantalla);
        pantalla.setVisible(true); 
        c.conectar();
               
        }
        catch(Exception e){
            
        }
    }


}