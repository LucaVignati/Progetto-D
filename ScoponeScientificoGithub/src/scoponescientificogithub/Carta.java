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
    
    public ArrayList<int[]> getCombinazioni(int valoreCarta)   {
        ArrayList<int[]> combinazioni = new ArrayList<>();
        int[] combinazione;
        int[] carte = new int[4];
        carte[0] = 1;
        carte[1] = 2;
        carte[2] = 3;
        carte[3] = 4;
        int somma, i, imax = 3;
        for(somma = 0 ; imax > 0 ; somma = 0)  {
            for(i = 0; i <= imax; i++)  {
                somma += carte[i];
            }
            if(somma > valoreCarta) {
                imax --;
            }   else if(somma == valoreCarta)   {
                combinazione = new int[imax + 1];
                for(i = 0; i <= imax; i++)   {
                    combinazione[i] = carte[i];
                }
                combinazioni.add(combinazione);
                for(i = 0; i < imax; i++)   {
                    if((carte[imax - i] - 1) != carte[imax - i - 1])  {
                        carte[imax - i - 1]++;
                        for(int j = 0; j < (i + 1); j++)   {
                            carte[imax - i + j] = carte[imax - i - 1 + j] + 1;
                        }
                        break;
                    }
                }
                if(i == imax)    {
                    imax --;
                }
            }   else    {
                carte[imax]++;
            }
        }
        return combinazioni;
    }
    
    @Override
    public String toString() {
        switch (seme) {
            case 1:
                return valore + " di coppe";
            case 2:
                return valore + " di denari";
            case 3:
                return valore + " di bastoni";
            case 4:
                return valore + " di spade";
        }
        
        return "";
    }
}