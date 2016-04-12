/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scoponescientificogithub;

/**
 *
 * @author cl417221
 */
public class Carta {
    int seme, valore; /* 1 coppe, 2 denari, 3 basoni, 4 spade */
    boolean scopa;
    
    public Carta(int seme, int valore) {
        scopa = false;
        this.seme = seme;
        this.valore = valore;
    }
    
    public int getSeme() {
        return seme;
    }
    
    public int getValore() {
        return valore;
    }
    
    public boolean getScopa() {
        return scopa;
    }
}