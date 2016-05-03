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
        
        /* test per il conta punti
        
        ArrayList<Carta> cim = giocatori[0].getCarteInMano();
        for (int i = 0; i < 10; i++) {
            squadra[0].aggiungiCartaPresa(cim.get(i));
        }
        
        cim = giocatori[1].getCarteInMano();
        for (int i = 0; i < 10; i++) {
            squadra[0].aggiungiCartaPresa(cim.get(i));
        }
        
        cim = giocatori[2].getCarteInMano();
        for (int i = 0; i < 10; i++) {
            squadra[1].aggiungiCartaPresa(cim.get(i));
        }
        
        cim = giocatori[3].getCarteInMano();
        for (int i = 0; i < 10; i++) {
            squadra[1].aggiungiCartaPresa(cim.get(i));
        }
        
        ArrayList<Carta> cp = squadra[0].getCartePrese();
        System.out.println("Carte squadra 1:");
        for (int i = 0; i < 20; i++) {
            System.out.println(cp.get(i));
        }
        
        cp = squadra[1].getCartePrese();
        System.out.println("\nCarte squadra 2:");
        for (int i = 0; i < 20; i++) {
            System.out.println(cp.get(i));
        }
        
        contaPunti();
        System.out.print("\n");
        System.out.println(squadra[0].getPunteggioPartita());
        System.out.println(squadra[1].getPunteggioPartita());
        
        
        */
        
        
        
        
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
                
                for (int k = 0; k < combinazioneCorrente.length; k++) {
                    // scansione del tavolo per vedere se e' presente la combinazione corrente
                    for (Carta cartaTav : carteTavolo) {
                        if (cartaTav.getValore() == combinazioneCorrente[k]) {
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
        //creo le variabili per ogni squadra
        int[] p = {0, 0}, pC = {0, 0}, pD = {0, 0}, pS = {0, 0}, pB = {0, 0}, d = {0, 0}, c = {0, 0}, s = {0, 0}, sB = {0, 0}, tot = {0, 0};
        //ciclo le due squadre
        for (int i = 0; i < 2; i++){
            
            int seme, val;
            s[i]=squadra[i].countScopa;
            //ciclo le carte per la squadra i
            for (Carta cartaCorrente : squadra[i].cartePrese) {
                seme = cartaCorrente.getSeme();
                val = cartaCorrente.getValore();
                //incremento il contatore carte
                c[i]++;
                //controllo il seme, e il vbalore piu alto della primiera
                if(seme==1){
                    if(val==7){
                        pC[i]=21;
                    }
                    if(val==6 && pC[i]<18){
                        pC[i]=18;
                    }
                    if(val==1 && pC[i]<16){
                        pC[i]=16;
                    }
                    if(val==5 && pC[i]<15){
                        pC[i]=15;
                    }
                    if(val==4 && pC[i]<14){
                        pC[i]=14;
                    }
                    if(val==3 && pC[i]<13){
                        pC[i]=13;
                    }
                    if(val==2 && pC[i]<12){
                        pC[i]=12;
                    }
                    if(val==8 || val==9 || val==10 && pC[i]<10){
                        pC[i]=10;
                    }
                }
                if(seme==2){
                    d[i]++;
                    if(val==7){
                        pD[i]=21;
                        sB[i]=1;
                    }
                    if(val==6 && pD[i]<18){
                        pD[i]=18;
                    }
                    if(val==1 && pD[i]<16){
                        pD[i]=16;
                    }
                    if(val==5 && pD[i]<15){
                        pD[i]=15;
                    }
                    if(val==4 && pD[i]<14){
                        pD[i]=14;
                    }
                    if(val==3 && pD[i]<13){
                        pD[i]=13;
                    }
                    if(val==2 && pD[i]<12){
                        pD[i]=12;
                    }
                    if(val==8 || val==9 || val==10 && pD[i]<10){
                        pD[i]=10;
                    }
                }
                if(seme==3){
                    if(val==7){
                        pS[i]=21;
                    }
                    if(val==6 && pS[i]<18){
                        pS[i]=18;
                    }
                    if(val==1 && pS[i]<16){
                        pS[i]=16;
                    }
                    if(val==5 && pS[i]<15){
                        pS[i]=15;
                    }
                    if(val==4 && pS[i]<14){
                        pS[i]=14;
                    }
                    if(val==3 && pS[i]<13){
                        pS[i]=13;
                    }
                    if(val==2 && pS[i]<12){
                        pS[i]=12;
                    }
                    if(val==8 || val==9 || val==10 && pS[i]<10){
                        pS[i]=10;
                    }
                }
                if(seme==4){
                    if(val==7){
                        pB[i]=21;
                    }
                    if(val==6 && pB[i]<18){
                        pB[i]=18;
                    }
                    if(val==1 && pB[i]<16){
                        pB[i]=16;
                    }
                    if(val==5 && pB[i]<15){
                        pB[i]=15;
                    }
                    if(val==4 && pB[i]<14){
                        pB[i]=14;
                    }
                    if(val==3 && pB[i]<13){
                        pB[i]=13;
                    }
                    if(val==2 && pB[i]<12){
                        pB[i]=12;
                    }
                    if(val==8 || val==9 || val==10 && pB[i]<10){
                        pB[i]=10;
                    }
                }
            }//dopo aver ciclato tutte le carte della squadra i
            p[i]=pC[i]+pD[i]+pS[i]+pB[i];
            
        }//dopo aver ciclato entrambi i giocatori
        
        //controllo chi ha fatto la primiera
        if(p[0]>p[1]) {
            tot[0]++;
        } else if(p[1]>p[0]) {
            tot[1]++;
        }
        //controllo chi ha fatto le carte
        if(c[0]>c[1]) {
            tot[0]++;
        } else if(c[1]>c[0]) {
            tot[1]++;
        }
        //controllo chi ha fatto i denari
        if(d[0]>d[1]) {
            tot[0]++;
        } else if(d[1]>d[0]) {
            tot[1]++;
        }
        tot[0]=tot[0]+sB[0]+s[0];
        tot[1]=tot[1]+sB[1]+s[1];
        squadra[0].setPunteggioPartita(tot[0]);
        squadra[1].setPunteggioPartita(tot[1]);
        
        /* 
        System.out.println("Denari 1 = "+d[0]+" 2 = "+d[1]);
        System.out.println("Carte 1 = "+c[0]+" 2 = "+c[1]);
        System.out.println("Primiera 1 = "+p[0]+" 2 = "+p[1]);
        System.out.println("Settebello 1 = "+sB[0]+" 2 = "+sB[1]);
        System.out.println("tot 1 = "+tot[0]+" 2 = "+tot[1]);
        */
    }
    
    /*
    public ArrayList<Carta> getCarteTavolo() {
        return carteTavolo;
    }
    */
    
    public void setCarteTavolo() {
        
    }
}
