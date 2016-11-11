/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Maxime
 */
public class PianoAQueue extends Piano {
    
    private String taille;

    public PianoAQueue(String taille, int nbTouches, int longueur, int largeur, int prixDAchat, int prixDeVente) {
        super(nbTouches, longueur, largeur, "Piano à queue", prixDAchat, prixDeVente);
        this.taille = taille;
    }
    
    @Override
    public String toString() {
        return super.toString()+ "taille : "+taille+"\n";
    }
    
}
