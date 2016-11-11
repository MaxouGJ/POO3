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
public class POO_TP5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        /*int a = 5;
        int[]t = new int[5];
        for(int i=0; i<5; i++){
            t[i] = a;
            a--;
        }
        EntierTriable e= new EntierTriable(t);
        System.out.println(e);
        Triable.triBulles(e);*/
        
        String[] t = new String[5];
        t[0] = "baba";
        t[1] = "ababa";
        t[2] = "dada";
        t[3] = "eaea";
        t[4] = "caca";
        
        Dictionnaire d = new Dictionnaire(t);
        
        Triable.triBulles(d);
               
    }
    
}
