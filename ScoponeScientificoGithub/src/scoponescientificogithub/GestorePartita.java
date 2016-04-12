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
public class GestorePartita {
    Squadra[] squadra;
    Giocatore[] giocatori;
    ArrayList<Carta> carteTavolo;
    
    public GestorePartita() {
        squadra = new Squadra[2];
        giocatori = new Giocatore[4];
        giocatori[0] = new Giocatore("Giocatore A", "Paolo");
        giocatori[1] = new Giocatore("Giocatore C", "Luca");
        giocatori[2] = new Giocatore("Giocatore B", "Michele");
        giocatori[3] = new Giocatore("Giocatore D", "Antonio");
        squadra[0] = new Squadra("Squadra 1", giocatori[0], giocatori[2]);
        squadra[1] = new Squadra("Squadra 2", giocatori[1], giocatori[3]);
        carteTavolo = new ArrayList<>();
    }
    
    public void Partita() { //sistemare (?)
        while(true) {
            if ((squadra[0].getPunteggioPartita() > squadra[1].getPunteggioPartita()) && (squadra[0].getPunteggioPartita() >= 21)) {
                System.out.println("Vince la squadra " + squadra[0].getId());
                break;
            } else if ((squadra[1].getPunteggioPartita() > squadra[0].getPunteggioPartita()) && (squadra[1].getPunteggioPartita() >= 21)) {
                System.out.println("Vince la squadra " + squadra[1].getId());
                break;
            } else {
                Mano();
            }
        }
    }
    
    public void Mano() {
        distribuisciCarte();
        
        for (int i = 0; i < 10; i++) {
            for(int j = 0; j < 4; j++)
                giocata(j);
        }
        
        
        /* contare e assegnare punti. NB: poi togliere i boolean scopa dalle carte */
    }
    
    public void giocata(int j) {
        Carta cartaGiocata = giocatori[j].gioca();
        ArrayList<Carta> cartePrendibili = new ArrayList<>();
        
        for (Carta cartaTav : carteTavolo) {
            if (cartaTav.getValore() == cartaGiocata.getValore()) {
                cartePrendibili.add(cartaTav);
            }
        }
            
        switch (cartePrendibili.size()) {
            case 0:
                carteTavolo.add(cartaGiocata);
                break;
            case 1:
                carteTavolo.remove(cartePrendibili.get(0));
                
                /* per ora brutale, poi col login sistemiamo */
                if (j == 0 || j == 2) {
                    squadra[0].aggiungiCartaPresa(cartaGiocata);
                    squadra[0].aggiungiCartaPresa(cartePrendibili.get(0));
                } else {
                    squadra[1].aggiungiCartaPresa(cartaGiocata);
                    squadra[1].aggiungiCartaPresa(cartePrendibili.get(0));
                }
                
                break;
            default:
                //il giocatore sceglie cosa fare. Se ci sono più carte prendibili o se ci sono combinazioni, ecc. ecc.
                break;
        }
        
    }
            
    public void distribuisciCarte() { /* le carte qui sono numerate da 1 a 40. 1-10 coppe, 11-20 denari, 21-30 bastoni, 31-40 spade */
        /* poi fare il random, ora semplice algoritmo di base da utilizzare per creare lo scheletro del programma */
        
        for (int i = 1; i <= 40; i++) {
            Carta carta;
            
            if (i <= 10) {
                carta = new Carta(1, i);
            } else if (i <= 20) {
                carta = new Carta(2, i - 10);
            } else if (i <= 30) {
                carta = new Carta(3, i - 20);
            } else {
                carta = new Carta(4, i - 30);
            }
            
            giocatori[3 - (i % 4)].aggiungiCartaInMano(carta); //molto basic
        }
    }
    
    public void contaPunti() {
        
    }
    
    /*
    public ArrayList<Carta> getCarteTavolo() {
        return carteTavolo;
    }
    */
    
    public void setCarteTavolo() {
        
    }
}
