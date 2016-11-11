/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Maxime
 */
import java.util.LinkedList;

public class Magasin {

    private static final int montantLoyer = 0;
    private int tresorerie;
    private LinkedList<Instrument> stockInstruments;         
    
    private Magasin(int tresorerie){
        this.tresorerie = tresorerie;
    }
    
    public static void ficheTechnique(Instrument i){
        System.out.println(i);
    }
    
    private void fournir(Instrument i, int quantite){
        if(tresorerie > 0){
            int q = quantite;
            while(quantite != 0 || tresorerie > 0){
                stockInstruments.add(i);
                tresorerie -= i.getPrixDAchat();
                quantite --;
            }
            System.out.println("Vous avez été fourni de "+(q-quantite)+" instruments, trésorerie : "+tresorerie);
        }
        else 
            System.out.println("La trésorerie est vide !");
    }
    
    private void vendre(Instrument i){
        for(int n=0; n<stockInstruments.size(); n++){
            if(i.getNom().equals(stockInstruments.get(n).getNom()) && stockInstruments.get(n) instanceof i ){
                tresorerie += stockInstruments.get(n).getPrixDeVente();
                stockInstruments.remove(n);
                System.out.println("L'instrument a bien été vendu, trésorerie : "+tresorerie);
                return;
            }
        }
        System.out.println("L'instrument n'a été vendu, trésorerie : "+tresorerie);
    }
    
    private void simulerFonctionnement(){
        int mois = 1;
        while(mois <= 12){
            System.out.println("----- Mois "+mois+" -----");
            
            mois++;
        }
    }
    
    public static void main(String[] args){
        Magasin magasin = new Magasin(100000);
    }
}
