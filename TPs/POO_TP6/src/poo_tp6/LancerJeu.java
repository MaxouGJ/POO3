/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo_tp6;

import java.util.Scanner;

/**
 *
 * @author Maxime
 */
public class LancerJeu {

    public static void main(String[] args){
            System.out.println("Combien de joueur voulez-vous ?");
            Scanner sc = new Scanner(System.in);
            int nbjoueur = sc.nextInt();
            Jeu jeu = new Jeu(nbjoueur, 64);
            for(int i = 0; i<nbjoueur; i++){
                System.out.println(jeu.joueur[i]);
            }
        }
}
