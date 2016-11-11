/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Maxime
 */
public class Piano extends InstrumentACordes {
    
    private int nbTouches;

    public Piano(int nbTouches, int longueur, int largeur, int prixDAchat, int prixDeVente) {
        super(longueur, largeur, "Piano", prixDAchat, prixDeVente);
        this.nbTouches = nbTouches;
    }
    
    protected Piano(int nbTouches, int longueur, int largeur, String nom, int prixDAchat, int prixDeVente) {
        super(longueur, largeur, nom, prixDAchat, prixDeVente);
        this.nbTouches = nbTouches;
    }
    
    @Override
    public String toString() {
        return super.toString()+ "nombre de touches : "+nbTouches+"\n";
    }
    
}
