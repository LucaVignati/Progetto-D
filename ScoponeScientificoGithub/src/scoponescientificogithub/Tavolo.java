/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scoponescientifico;

import java.util.ArrayList;

/**
 *
 * @author cl417221
 */
public class Tavolo {
    ArrayList<Carta> carteTavolo;
    
    public Tavolo() {
        carteTavolo = new ArrayList<>();
    }
    
    public ArrayList<Carta> getCarteTavolo() {
        return carteTavolo;
    }
    
    public void aggiungiCartaAlTavolo(Carta carta) {
        carteTavolo.add(carta);
    }
    
    public void rimuoviCartaDalTavolo(Carta carta) {
        carteTavolo.remove(carta);
    }
   
    public void distribuisciCarte() {
        
    }
}
