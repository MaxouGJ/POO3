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
public class Dictionnaire implements Triable{
    public String[]t ;

    public Dictionnaire(String[] t) {
        this.t = t;
    }
    
    public void echange(int i, int j){
        String tampon = t[i];
        t[i] = t[i+1];
        t[i+1] = tampon;
    }
    
    public boolean plusGrand(int i, int j){
        return (t[i].compareTo(t[i+1]) > 0);
    }
    
    public int taille(){
     int taille = 0;
        for(int i=0; i<t.length ; i++){
            taille++;
        }
        return taille;   
    }
    
    public String toString() {
        String s="";
        for(int i=0; i<t.length; i++){
            s += " -> "+t[i];
        }
        return s;
    }
}
