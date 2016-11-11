/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo_tp5;

/**
 *
 * @author Maxime
 */
public class Triangle extends Figure implements Deformable{

    int base, hauteur;
    
    public Triangle(int x, int y, int base, int hauteur) {
        super(x, y);
        this.base = base;
        this.hauteur = hauteur;
    }
    
    public void affiche(){
        System.out.println("");
    }
    
    public Figure deformation(double coeffH, double coeffV){
        return (new Rectangle((int)(getPosX()*coeffH), (int)(getPosY()*coeffV)));
    }
    
    public double surface(){
        return (base*hauteur)/2;
    }
}
