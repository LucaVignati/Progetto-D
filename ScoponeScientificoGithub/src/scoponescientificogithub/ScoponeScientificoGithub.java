/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scoponescientificogithub;

import gui.TavoloGUI;

/**
 *
 * @author cl417221
 */
public class ScoponeScientificoGithub {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //GestorePartita gp = new GestorePartita();
        //gp.Mano();
        Giocatore g = new Giocatore("1", "Carlo");
        TavoloGUI tg = new TavoloGUI(g);
    }
    
}
