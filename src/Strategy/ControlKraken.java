/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Strategy;

import Logica.Jugador;

/**
 *
 * @author monic
 */
public class ControlKraken implements IAtacar{

    @Override
    public void atacarCasillas(Jugador jugadorActual, String[] arrayComandos) {
          System.out.println("ENTRA TRUE");
          IAtacar CTK=new ReleaseKraken();
          CTK.atacarCasillas(jugadorActual, arrayComandos);
    }
}
