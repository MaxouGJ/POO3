
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * <b>Classe qui représente une case du plateau</b>
 * 
 *  Une case est caractérisée par :
 * <ul>
 * <li>la présence de sels minéraux</li>
 * <li>la présence d'herbe</li>
 * <li>un abscisse</li>
 * <li>une ordonnée</li>
 * <li>un Animal</li>
 * <li>un JPanel</li>
 * </ul>
 * 
 * @author FERRE Adrien et GALLAIS-JIMENEZ Maxime
 */
public class Case {

    /**
     * Présence de sels minéraux ou non
     * 
     * @see Case#getSels() 
     * @see Case#setSels(boolean) 
     */
    private boolean sels;
    
    /**
     * Présence d'herbe ou non
     * 
     * @see Case#getHerbe() 
     * @see Case#setHerbe(boolean) 
     */
    private boolean herbe;
    
    /**
     * Abscisse de la case
     * 
     * @see Case#Case(int, int) 
     * @see Case#getX() 
     * @see Case#setX(int) 
     */
    private int x;
    
    /**
     * Ordonnée de la case
     * 
     * @see Case#Case(int, int) 
     * @see Case#getY() 
     * @see Case#setY(int) 
     */
    private int y;
    
    /**
     * Animal présent sur la case
     * 
     * @see Case#getAnimal() 
     * @see Case#setAnimal(Animal) 
     */
    private Animal animal; 
    
    /**
     * JPanel représentant la case 
     */
    public JPanel panel;
    
    /**
     * Image présente sur la case
     */
    public ImagePane image;
    
    /**
     * Constructeur de la case.
     * 
     * Initialise l'abscisse et l'ordonnée aux valeurs indiquées.
     * Initialise la présence d'herbe à vrai, celle de sels minéraux à faux.
     * Indique qu'il n'y a pas  d'Animal et crée le JPanel.
     * 
     * @param x
     * Abscisse de la case
     * @param y 
     * Ordonnée de la case
     */
    public Case(int x, int y) {
        this.x = x;
        this.y = y;
        this.herbe = true;
        this.sels = false;
        this.animal = null;
        panel = new JPanel();
        panel.setBackground(new Color(58, 157,35));
        image = new ImagePane();
        panel.add(image);
    }

    /**
     * Retourne sels
     * 
     * @return
     * La présence de sels minéraux ou non
     */
    public boolean getSels() {
        return sels;
    }

    /**
     * Retourne herbe
     * 
     * @return 
     * La présence d'herbe ou non
     */
    public boolean getHerbe() {
        return herbe;
    }

    /**
     * Retourne animal
     * 
     * @return
     * L'Animal présent sur la case, ou null s'il n'y en a pas
     */
    public Animal getAnimal() {
        return animal;
    }
        
    /**
     * Retourne x
     * 
     * @return
     * Retourne l'abscisse de la case 
     */
    public int getX() {
        return x;
    }
    
    /**
     * Retourne y
     * 
     * @return
     * Retourne l'ordonnée de la case
     */
    public int getY(){
        return y;
    }
    
    /**
     * Modifie la présence de sels
     * 
     * @param sels
     * Nouvelle valeur de sels
     */
    public void setSels(boolean sels) {
        this.sels = sels;
    }

    /**
     * Modifie la présence d'Herbe
     * 
     * @param herbe
     * Nouvelle valeur d'herbe
     */
    public void setHerbe(boolean herbe) {
        this.herbe = herbe;
    }
   
    /**
     * Modifie l'Animal présent sur la case
     * 
     * @param a
     * Animal qui va sur la case
     */
    public void setAnimal(Animal a){
        animal = a;
    }
    
    /**
     * Informe si la case est vide de tout animal
     * 
     * @return
     * True s'il n'y a pas d'Animal
     */
    public boolean estVide(){
        return animal==null;
    }

    @Override
    public String toString() {
        return "Case{" + "sels=" + sels + ", herbe=" + herbe + ", x=" + x + ", y=" + y + ", animal=" + animal + ", panel=" + panel + '}';
    }
    
    public static class ImagePane extends JPanel {
        BufferedImage image;
        
        ImagePane(){
            image = null;
            
            setPreferredSize(new Dimension(0, 0));
            repaint();
        }
        
        @Override
         protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(image, 0, 0, null);
        }
        
        /**
         * Redimensionne une image
         * 
         * @param image
         * Image à redimensionner
         * @param width
         * Largeur de l'image
         * @param height
         * Hauteur de l'image
         * @return
         * L'image à la bone taille
         */
        public static BufferedImage resize(BufferedImage image, int width, int height) {
            BufferedImage i = new BufferedImage(width, height, image.getType());
            Graphics2D g = i.createGraphics();
            g.drawImage(image, 0, 0, width, height, null);
            g.dispose();
            g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            return i;
        }
    }
}
