/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import scoponescientificogithub.Giocatore;

/**
 *
 * @author cl419290
 */
public class TavoloGUI extends JFrame {
    Giocatore giocatore;
    
    public TavoloGUI(Giocatore giocatore) {
        this.giocatore = giocatore;
        
        /* settaggi vari per il JFrame */
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); //per ottenere la dimensione dello schermo
        double width = screenSize.getWidth();
        double height = screenSize.getHeight();
        
        setSize((int) width * 3/4, (int) height * 3/4);
        setLocation((int) width * 1/8, (int) height * 1/10);
        //setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Scopone Scientifico - Giocatore " + giocatore.getId() + " (" + giocatore.getNome() + ")");
        //setIconImage(new ImageIcon("files\\immagini\\logo.png").getImage());
        setVisible(true);
        initComponents();
    }
    
    private void initComponents() {
        JPanel mainPanel;
        JPanel mioPanel, socioPanel, avversarioSXPanel, avversarioDXPanel, tavoloPanel;
        JPanel mieCartePanel, carteSocioPanel, carteAvversarioSXPanel, carteAvversarioDXPanel, carteTavoloPanel;
        
        //prove per i vari pannelli
        mioPanel = new JPanel(new BorderLayout());
        socioPanel = new JPanel(new BorderLayout());
        avversarioSXPanel = new JPanel(new BorderLayout());
        avversarioDXPanel = new JPanel(new BorderLayout());
        tavoloPanel = new JPanel(new BorderLayout()); 
        carteTavoloPanel = new JPanel (new FlowLayout()); //FlowLayout per il tavolo
        tavoloPanel.add(carteTavoloPanel, BorderLayout.CENTER);
        
        mieCartePanel = new JPanel(new FlowLayout());
        mioPanel.add(mieCartePanel);
        
        //test dei pannelli
        JButton b1, b2, b3, b4, b5, bmiecarte, bcartesocio, bcartesx, bcartedx, bmazzomiasquadra, bmazzosquadraavversaria;
        b1 = new JButton("mioPanel");
        b2 = new JButton("socioPanel");
        socioPanel.add(b2);
        b3 = new JButton("avversarioSXPanel");
        avversarioSXPanel.add(b3);
        b4 = new JButton("avversarioDXPanel");
        avversarioDXPanel.add(b4);
        b5 = new JButton("CARTE TAVOLO");
        carteTavoloPanel.add(b5);
        
        bmiecarte = new JButton("mieCartePanel");
        bcartesx = new JButton("Carte SX");
        bcartedx = new JButton("Carte DX");
        bcartesocio = new JButton("Carte socio");
        bmazzomiasquadra = new JButton("Mazzo mia squadra");
        bmazzosquadraavversaria = new JButton("Mazzo squadra avversaria");
        
        mieCartePanel.add(bmiecarte);
        mioPanel.add(mieCartePanel, BorderLayout.CENTER);
        mioPanel.add(bmazzomiasquadra, BorderLayout.EAST);
        
        socioPanel.add(bcartesocio, BorderLayout.CENTER);
        avversarioSXPanel.add(bcartesx, BorderLayout.CENTER);
        avversarioDXPanel.add(bcartedx, BorderLayout.CENTER);
        avversarioDXPanel.add(bmazzosquadraavversaria, BorderLayout.NORTH);
        
        
        
        
        
        
        mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(mioPanel, BorderLayout.SOUTH);
        mainPanel.add(socioPanel, BorderLayout.NORTH);
        mainPanel.add(avversarioSXPanel, BorderLayout.WEST);
        mainPanel.add(avversarioDXPanel, BorderLayout.EAST);
        mainPanel.add(tavoloPanel, BorderLayout.CENTER);
        
        //bisogna vedere bene a quali pannelli assegnare il background color
        Color backgroundColor = new Color(0, 130, 0); //RGB
        mainPanel.setBackground(backgroundColor);
        mioPanel.setBackground(backgroundColor);
        socioPanel.setBackground(backgroundColor);
        avversarioSXPanel.setBackground(backgroundColor);
        avversarioDXPanel.setBackground(backgroundColor);
        tavoloPanel.setBackground(backgroundColor);
        mieCartePanel.setBackground(backgroundColor);
        carteTavoloPanel.setBackground(backgroundColor);
    
        add(mainPanel);
    }
}
