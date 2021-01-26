/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Strategy;

/**
 *
 * @author monic
 */
public class Atacar {
    public IAtacar ataque;

    public Atacar() {
    }
    
    public void atacar(){
        this.ataque.atacarCasillas();
    }

    public IAtacar getAtaque() {
        return ataque;
    }

    public void setAtaque(IAtacar ataque) {
        this.ataque = ataque;
    }
    
}
