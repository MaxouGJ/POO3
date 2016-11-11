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
public class Jeu {

    Case[] plateau;
    Joueur[] joueur;
    
    Jeu(int nbJoueur, int nbCase){
        plateau = new Case[nbCase];
        joueur = new Joueur[nbJoueur];
        for(int i=0; i<nbJoueur; i++){
            joueur[i] = new Joueur(i);
        }
        plateau[0] = new Case(0);
        for(int i=1; i<nbCase; i++){
            if(Math.random() >0.85)
                plateau[i] = new Case(i, (int)(Math.random()*nbCase+1));
            else
                plateau[i] = new Case(i);
        }
    }
    
    static class Case{
        int numero, suivante;
        
        public Case(int numero) {
            this.numero = numero;
            this.suivante = numero;
        }

        public Case(int numero, int suivante) {
            this.numero = numero;
            this.suivante = suivante;
        }
                
        int destination(){
            return suivante;
        }
    }
    
    class Joueur{
        Case place;
        int nujoueur;

        public Joueur(int nujoueur) {
            this.nujoueur = nujoueur;
            place = new Case(0);
        }
                
        boolean joueUnTour(){
            int de = (int)(Math.random()*6+1);
            if(place.numero+de < plateau.length-1)
                place.numero = plateau[place.numero+de-1].suivante;
            else{
                place.numero = plateau[place.numero+de+(plateau.length-(place.numero+de))-1].suivante;
            }
            return place.numero == plateau.length-1;
        }
        
        public String toString(){
            if(joueUnTour())
                return "Vous avez gagné. Bravo !";
            return "Joueur "+nujoueur+" vous êtes sur la case "+place.numero;
        }
    }
    
    static class LancerJeu{
        public static void main(String[] args){ 
            System.out.println("Combien de joueur voulez-vous ?");
            Scanner sc = new Scanner(System.in);
            int nbjoueur = sc.nextInt();
            Jeu jeu = new Jeu(nbjoueur, 64);
            for(int i = 0; i<nbjoueur; i++){
                System.out.println("Joueur "+jeu.joueur[i].nujoueur+" vous êtes sur la case "+jeu.joueur[i].place.numero);
            }
            System.out.println("-----------");
            boolean b = true;
            while(b){
                for(int i = 0; i<nbjoueur; i++){
                    System.out.println(jeu.joueur[i]);
                }
                System.out.println("-----------");
                System.out.println("Appuyer sur enter pour continuer\n");
                b = false;
                String s = sc.nextLine();
                b = (s!=null);
            }
        }
    }
}
