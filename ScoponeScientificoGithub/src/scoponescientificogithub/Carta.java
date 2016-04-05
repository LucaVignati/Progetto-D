/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scoponescientifico;

/**
 *
 * @author cl417221
 */
public class Carta {
    int seme, valore;
    boolean scopa;
    
    public Carta() {
        scopa = false;
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
