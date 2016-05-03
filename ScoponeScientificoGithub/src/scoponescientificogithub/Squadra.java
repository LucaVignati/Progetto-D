/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scoponescientificogithub;

import java.util.ArrayList;

/**
 *
 * @author cl417221
 */
public class Squadra {
    String id;
    Giocatore[] giocatore;
    int punteggioPartita;
    ArrayList<Carta> cartePrese;
    int countScopa;
    
    public Squadra(String id, Giocatore giocatore1, Giocatore giocatore2) {
        this.id = id;
        countScopa = 0;
        giocatore = new Giocatore[2];
        giocatore[0] = giocatore1;
        giocatore[1] = giocatore2;
        cartePrese = new ArrayList<>();
    }
    
    public String getId() {
        return id;
    }
    
    public int getPunteggioPartita() {
        return punteggioPartita;
    }
    
    public void setPunteggioPartita(int punteggio) {
       punteggioPartita = punteggio; 
    }
    
    public ArrayList<Carta> getCartePrese() {
        return cartePrese;
    }
    
    public void aggiungiCartaPresa(Carta carta) {
        cartePrese.add(carta);
    }
}
