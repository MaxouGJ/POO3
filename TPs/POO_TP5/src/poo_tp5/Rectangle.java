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
public class Rectangle extends Figure implements Deformable{

    public Rectangle(int x, int y) {
        super(x, y);
    }
    
    public void affiche(){
        System.out.println("");
    }
    
    public Figure deformation(double coeffH, double coeffV){
        return (new Rectangle((int)(getPosX()*coeffH), (int)(getPosY()*coeffV)));
    }
    
    public double surface(){
        return (getPosX()*2)*(getPosY()*2);
    }
}
