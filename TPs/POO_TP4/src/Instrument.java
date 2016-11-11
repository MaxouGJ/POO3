/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Maxime
 */
public class Instrument {

    private String nom;
    private int prixDAchat, prixDeVente;

    public Instrument(String nom, int prixDAchat, int prixDeVente) {
        this.nom = nom;
        this.prixDAchat = prixDAchat;
        this.prixDeVente = prixDeVente;
    }

    @Override
    public String toString() {
        return "Instrument : "+nom+"\n prix d'achat : "+prixDAchat+"\n prix de vente : "+prixDeVente+"\n";
    }

    public int getPrixDAchat() {
        return prixDAchat;
    }

    public String getNom() {
        return nom;
    }

    public int getPrixDeVente() {
        return prixDeVente;
    }
    
}
