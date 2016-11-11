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
public abstract class Figure {
    
    // coordonnées du centre approximaatif de la figure
    private int posX;
    private int posY;
    
    public Figure(int x, int y){
        posX = x;
        posY = y;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }
    
    public abstract void affiche();
    
    public double estDistantDe(Figure fig){
        return ((posX-fig.posX)+(posY-fig.posY))/2;
    }
    
    public abstract double surface();
    
    public void deplacement(int x, int y){
        posX = x;
        posY = y;
    }
    
    
}
