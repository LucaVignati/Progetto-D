/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scoponescientificogithub;

import java.util.Random;
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
        Carta cartaPrendibile = null;
        ArrayList<int[]> combinazioni = new ArrayList<>(); 
        
        for (Carta cartaTav : carteTavolo) {
            if (cartaTav.getValore() == cartaGiocata.getValore()) {
                cartaPrendibile = cartaTav;
            }
        }
        
        if (cartaPrendibile != null) {
            carteTavolo.remove(cartaPrendibile);
                
            // per ora brutale, poi col login sistemiamo 
            if (j == 0 || j == 2) {
                squadra[0].aggiungiCartaPresa(cartaGiocata);
                squadra[0].aggiungiCartaPresa(cartaPrendibile);
            } else {
                squadra[1].aggiungiCartaPresa(cartaGiocata);
                squadra[1].aggiungiCartaPresa(cartaPrendibile);
            }
        } else {
            int numeroCombinazioniPossibiliSulTavolo = 0;
            ArrayList<Carta> combinazioniPrendibili = new ArrayList<>(); // come cartaPrendibile solo che contiene le combinazioni effettivamente prendibili che sono anche presenti sul tavolo 
            combinazioni = cartaGiocata.getCombinazioni();
            
            for (int i = 0; i < combinazioni.size(); i++) {
                int[] combinazioneCorrente = combinazioni.get(i);
                
                for (j = 0; j < combinazioneCorrente.length; j++) {
                    // scansione del tavolo per vedere se e' presente la combinazione corrente 
                    for (Carta cartaTav : carteTavolo) {
                        if (cartaTav.getValore() == combinazioneCorrente[j]) {
                            //controlla la successiva... pero' dipende dalla dimensione dell'int[] combinazionecorrente
                        }
                    }
                }
            } 
        }
    }
            
    public void distribuisciCarte() { /* le carte qui sono numerate da 1 a 40. 1-10 coppe, 11-20 denari, 21-30 bastoni, 31-40 spade */  
        /* creo mazzo */
        ArrayList<Carta> mazzo;
        mazzo = new ArrayList<>();
        
        /* crea le carte */
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
            
            
            mazzo.add(carta);
        }
            
        int c = 40;
        
        /* passo in rassegna i 4 giocatori uno alla volta e assegno una carta random dal mazzo, che poi rimuovo */
        for (int i = 1; i <= 10; i++) {
            for (int j = 0; j < 4; j++) {
                Random random = new Random();
                int numeroRandom = random.nextInt(c);
                
                giocatori[j].aggiungiCartaInMano(mazzo.get(numeroRandom));
                mazzo.remove(numeroRandom);
                c--;
            }
        }
        
//        /* test per vedere le carte */
//        for (int i = 0; i < 4; i++) {
//            ArrayList<Carta> carteTest = giocatori[i].getCarteInMano();
//            
//            System.out.println("Carte del giocatore " + i + ":");
//            for (int j = 0; j < 10; j++) {
//                System.out.println(carteTest.get(j));
//            } System.out.println("");
//        }
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
