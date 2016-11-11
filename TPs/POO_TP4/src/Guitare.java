/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Maxime
 */
public class Guitare extends InstrumentACordes {

    protected Guitare(int longueur, int largeur, String nom, int prixDAchat, int prixDeVente) {
        super(longueur, largeur, nom, prixDAchat, prixDeVente);
    }
    
    public Guitare(int longueur, int largeur, int prixDAchat, int prixDeVente) {
        super(longueur, largeur, "Guitare", prixDAchat, prixDeVente);
    }
     
    @Override
    public String toString() {
        return super.toString();
    }
}
