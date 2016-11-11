/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo_tp8;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;

/**
 *
 * @author Maxime
 */
public class Cadre extends JFrame{
    
    JPanel conteneur;
    Carre[] carre;
    
    Cadre(){
        
        setTitle("Cadre"); //Définit un titre pour notre fenêtre
        setPreferredSize(new Dimension(600, 600)); //Définit sa taille (largeur et hauteur)
        setResizable(false); //Empêche de modifier la taille de fenêtre
        setLocationRelativeTo(null); //Nous demandons maintenant à notre objet de se positionner au centre
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Termine le processus lorsqu'on clique sur la croix rouge
                    
        conteneur = (JPanel) getContentPane();
        conteneur.setPreferredSize(new Dimension(600, 600)); //Définit sa taille (largeur et hauteur)
        conteneur.setLayout(null);
        
        int nbCarres = (int)(Math.random()*9+1);
        carre = new Carre[nbCarres];
        for(int i=0; i<nbCarres; i++){
            carre[i] = new Carre();
            conteneur.add(carre[i].carre);
        }
        
        pack(); //Fais en sorte que le JFrame fasse l ataille du JPanel
        setVisible(true);   //Permet que le JFrame soit visible
    }
    
    boolean gagne(){
        for(int i=0; i<carre.length-1; i++){
            if(!carre[i].couleur.equals(carre[i+1].couleur))
                return false;
        }
        return true;
    }
    
    void gagner(){
        if(gagne())
            System.exit(0);
    }
    
    class Carre extends JPanel implements MouseInputListener{
        
        JPanel carre;
        Color couleur = Color.blue;
        private int x;
        private int y;
        private static final int taille = 50;
        
        Carre(){
            carre = new JPanel();
            couleur = new Color((float) Math.random(), (float) Math.random(), (float) Math.random());
            carre.setBackground(couleur);
            x = (int) (Math.random()*550); y = (int) (Math.random()*550);
            carre.setBounds(x, y, taille, taille);
            carre.addMouseListener(this);
            carre.addMouseMotionListener(this);
        }

        public Color getCouleur() {
            return couleur;
        }

        public int getTaille() {
            return taille;
        }
        
        public void setCouleur(Color couleur) {
            this.couleur = couleur;
        }

        public void setX(int x) {
            this.x = x;
        }

        public void setY(int y) {
            this.y = y;
        }
        
        @Override
        public void mouseClicked(MouseEvent e) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mousePressed(MouseEvent e) {
            
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            x = carre.getX();
            y = carre.getY();
            carre.setBackground(new Color((float) Math.random(), (float) Math.random(), (float) Math.random()));
            couleur = getBackground();
            gagner();
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseExited(MouseEvent e) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            carre.setLocation(carre.getX()+e.getX()-taille/2, carre.getY() + e.getY()-taille/2);
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
    
    public static void main(String[] args){
        Cadre c = new Cadre();
    }
}
