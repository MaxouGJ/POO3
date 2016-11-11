
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ChangeListener;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Maxime
 */

public class Palette{
    
    Vue vue;
    Model c;
    Controleur controleur;
    
    Palette(){
        vue = new Vue();
        vue.pack();
        vue.setVisible(true);
    }
    
    class Vue extends JFrame{
        
        JPanel panneauColore, panneauChoix, panneauChoixGris, conteneur;
        JSlider[] curseur;
        JSlider curseurGris;
        JMenuBar barreMenu;
        JMenu selection, affichage;
        JMenuItem gris50, complementaire;
        JRadioButtonMenuItem gris, rvb;
        ButtonGroup grBout;
        JTextField couleur;
        
        Vue(){
            
            setTitle("Palette"); //Définit un titre pour notre fenêtre
            setSize(1200, 500); //Définit sa taille (largeur et hauteur)
            setLocationRelativeTo(null); //Nous demandons maintenant à notre objet de se positionner au centre
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Termine le processus lorsqu'on clique sur la croix rouge
            
            
            conteneur = (JPanel) getContentPane();
            conteneur.setLayout(new GridLayout(1,2));   //Nous faisons un panneau de 1 ligne par 2 colonnes
            
            panneauColore = new JPanel();
            conteneur.add(panneauColore);
            c = new Model();
                        
            couleur = new JTextField();
            couleur.setSize(50,20);
            panneauColore.add(couleur);
            miseAJour();
            
            panneauChoix = new JPanel();
            panneauChoix.setLayout(new GridLayout(3,1));    //Nous faisons un panneau de 3 lignes et 1 colonne
            conteneur.add(panneauChoix);
            panneauChoix.setBackground(new Color(0.75f, 0.75f, 0.75f));
            
            panneauChoixGris = new JPanel();
            panneauChoixGris.setBackground(new Color(0.75f, 0.75f, 0.75f));
           
            controleur = new Controleur();
            
            curseur = new JSlider[3];
            for(int i=0; i<3; i++){
                curseur[i] = new JSlider(0, 100, 100);
                curseur[i].addChangeListener(controleur);
                curseur[i].setPaintTicks(true); //On affiche les pointillés
                curseur[i].setPaintLabels(true);    //On affiche les valeurs
                curseur[i].setMajorTickSpacing(25); //On définit l'espacement des grands pointillés
                curseur[i].setMinorTickSpacing(5);  //On définit l'espacement des petits pointillés
                panneauChoix.add(curseur[i]);
            }
            curseur[0].setBorder(BorderFactory.createTitledBorder("Rouge"));    //On met un titre au slider
            curseur[1].setBorder(BorderFactory.createTitledBorder("Vert"));
            curseur[2].setBorder(BorderFactory.createTitledBorder("Bleu"));
            
            curseurGris = new JSlider(0, 100, 50);
            curseurGris.addChangeListener(controleur);
            curseurGris.setBorder(BorderFactory.createTitledBorder("Gris"));
            curseurGris.setPaintTicks(true);
            curseurGris.setPaintLabels(true);
            curseurGris.setMajorTickSpacing(25);
            curseurGris.setMinorTickSpacing(5);
            panneauChoixGris.add(curseurGris);
            
            barreMenu = new JMenuBar();
            selection = new JMenu("Sélection");
            affichage = new JMenu("Affichage");
            gris50 = new JMenuItem("Gris 50");
            complementaire = new JMenuItem("Complémentaire");
            gris = new JRadioButtonMenuItem("Gris");
            rvb = new JRadioButtonMenuItem("RVB");
            rvb.setSelected(true);  // On préselectionne RVB;
            grBout =  new ButtonGroup();   //On crée un groupe de boutons
            gris50.addActionListener(controleur);
            complementaire.addActionListener(controleur);
            selection.add(gris50);
            selection.add(complementaire);
            gris.addActionListener(controleur);
            rvb.addActionListener(controleur);
            grBout.add(gris);
            grBout.add(rvb);
            affichage.add(gris);
            affichage.add(rvb);
            barreMenu.add(selection);
            barreMenu.add(affichage);
            setJMenuBar(barreMenu);     //On colle au JFrame une barre de menu
                
        }
        
        void miseAJour(){
            panneauColore.setBackground(new Color(c.getR()/100f, c.getV()/100f, c.getB()/100f));
            couleur.setText((int)(c.getR()*2.55)+""+(int)(c.getV()*2.55)+""+(int)(c.getB()*2.55)+" -> "+ Integer.toHexString((int)((c.getR()*2.55)))+Integer.toHexString((int)((c.getV()*2.55)))+Integer.toHexString((int)((c.getB()*2.55))));
        }
        
        void miseAJourCurseurs(){
            curseur[0].setValue(c.getR());
            curseur[1].setValue(c.getV());
            curseur[2].setValue(c.getB());
            couleur.setText(c.getR()*2.5+""+c.getV()*2.5+""+c.getB()*2.5);
        }
        
        void gris50(){
            panneauColore.setBackground(new Color(50/100f, 50/100f, 50/100f));
            couleur.setText(c.getR()*2.5+""+c.getV()*2.5+""+c.getB()*2.5);
        }
        
        void complementaire(){
            panneauColore.setBackground(new Color((100-c.getR())/100f, (100-c.getV())/100f, (100-c.getB())/100f));
            couleur.setText(c.getR()*2.5+""+c.getV()*2.5+""+c.getB()*2.5);
        }
        
        void gris(){
            panneauColore.setBackground(new Color((c.getR()+c.getV()+c.getB())/3/100f, (c.getR()+c.getV()+c.getB())/3/100f, (c.getR()+c.getV()+c.getB())/3/100f));
            couleur.setText((int)c.getR()*2.5+""+(int)c.getV()*2.5+""+(int)c.getB()*2.5);
        }
        
        void RVB(){
            couleur.setText(c.getR()*2.5+""+c.getV()*2.5+""+c.getB()*2.5);
            //Pas besoin
        }
    }
    
    class Model {
            
        private int r, v, b;

        private Model(){
            r = v = b = 100;
        }
        
        public int getR() {
            return r;
        }

        public int getV() {
            return v;
        }

        public int getB() {
            return b;
        }

        public void setR(int r) {
            this.r = r;
        }

        public void setV(int v) {
            this.v = v;
        }

        public void setB(int b) {
            this.b = b;
        }
            
    }
    
    class Controleur implements ChangeListener, ActionListener {
        
        @Override
        public void stateChanged(ChangeEvent event){
            if(event.getSource() == vue.curseurGris){
                c.setR(vue.curseurGris.getValue());
                c.setV(vue.curseurGris.getValue());
                c.setB(vue.curseurGris.getValue());
                vue.gris();
            }
            else{
                c.setR(vue.curseur[0].getValue());
                c.setV(vue.curseur[1].getValue());
                c.setB(vue.curseur[2].getValue());
                vue.miseAJour();
            }
        }

        @Override
        public void actionPerformed(ActionEvent event) {
            JMenuItem item = (JMenuItem) event.getSource();
            if(item == vue.complementaire){
                c.setR(vue.curseur[0].getValue());
                c.setV(vue.curseur[1].getValue());
                c.setB(vue.curseur[2].getValue());
                vue.complementaire();
                for(int i=0; i<3; i++)
                    vue.curseur[i].setValue(100-vue.curseur[i].getValue());
            }
            else if(item == vue.gris50){
                vue.gris50();
                for(int i=0; i<3; i++)
                    vue.curseur[i].setValue(50);
            }
            else if(item == vue.gris){
                vue.conteneur.remove(vue.panneauChoix);
                vue.conteneur.add(vue.panneauChoixGris);
                vue.curseurGris.setValue((c.getR()+c.getV()+c.getB())/3);
                vue.gris();
                vue.conteneur.validate();
            } 
            else if(item == vue.rvb){
                vue.conteneur.remove(vue.panneauChoixGris);
                vue.conteneur.validate();
                vue.conteneur.add(vue.panneauChoix);
                vue.miseAJourCurseurs();
                vue.conteneur.validate();
            }
        }
    }
    
    public static void main(String[] args){
        new Palette();     
    }
}
