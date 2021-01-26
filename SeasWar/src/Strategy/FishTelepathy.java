/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Strategy;

import Logica.Casilla;

/**
 *
 * @author monic
 */
public class FishTelepathy extends Atacar{

    public FishTelepathy() {
        super();
    }
    
    public IAtacar getAtaque() {
        return ataque;
    }

    public void setAtaque(IAtacar ataque) {
        this.ataque = ataque;
    }
    
}
