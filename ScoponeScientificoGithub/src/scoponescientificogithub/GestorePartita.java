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
public class GestorePartita {
    Squadra[] squadra;
    Giocatore[] giocatori;
    Tavolo tavolo;
    
    public GestorePartita() {
        squadra = new Squadra[2];
        giocatori = new Giocatore[4];
        giocatori[0] = new Giocatore("Giocatore A", "Paolo");
        giocatori[1] = new Giocatore("Giocatore C", "Luca");
        giocatori[2] = new Giocatore("Giocatore B", "Michele");
        giocatori[3] = new Giocatore("Giocatore D", "Antonio");
        squadra[0] = new Squadra("Squadra 1", giocatori[0], giocatori[2]);
        squadra[1] = new Squadra("Squadra 2", giocatori[1], giocatori[3]);
        Partita();
        //carteTavolo = new ArrayList<>();
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
        tavolo.distribuisciCarte();
        
        for (int i = 0; i < 10; i++) {
            for(int j = 0; j < 4; j++)
                giocata(j);
                
        }
    }
    
    public void giocata(int j){
        Carta cartaGiocata = giocatori[j].gioca();
        
    }
            
            
            
            
            
    public void distribuisciCarte() {
        
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
