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
public class Giocatore {
    String id, nome;
    ArrayList<Carta> carteInMano;
    
    public Giocatore(String id, String nome) {
        this.id = id;
        this.nome = nome;
        carteInMano = new ArrayList<>();
    }
    
    public String getId() {
        return id;
    }
    
    public String getNome() {
        return nome;
    }
    
    public ArrayList<Carta> getCarteInMano() {
        return carteInMano;
    }
    
    public void aggiungiCartaInMano(Carta carta) {
        carteInMano.add(carta);
    }
    
    public Carta gioca()    {
        Carta cartaGiocata = carteInMano.get(0);
        carteInMano.remove(cartaGiocata);
        return cartaGiocata;
    }
}
