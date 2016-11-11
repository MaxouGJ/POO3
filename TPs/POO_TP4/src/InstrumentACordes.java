/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Maxime
 */
public class InstrumentACordes extends Instrument{
 
    private int longueur, largeur;

    public InstrumentACordes(int longueur, int largeur, String nom, int prixDAchat, int prixDeVente) {
        super(nom, prixDAchat, prixDeVente);
        this.longueur = longueur;
        this.largeur = largeur;
    }

    @Override
    public String toString() {
        return super.toString()+"longueur : "+longueur+"\n largeur : "+ largeur+"\n";
    }
    
    
}
