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
public interface Triable {
  
    // échange les éléments en position i et j
    void echange(int i, int j);
    
    // retourne vrai si l'élément en position i est plus que celui en j
    boolean plusGrand(int i, int j);
    
    // retourne le nombre d'éléments à trier
    int taille();
    
    static void triBulles(Triable t){
        boolean change;
        do {
            change = false;
            for(int i=0; i<t.taille()-1; i++){
                if(t.plusGrand(i, i+1)){
                    t.echange(i, i+1);
                    change = true;                    
                }
            }
        }
        while(change);
        System.out.println(t);
    }
}
