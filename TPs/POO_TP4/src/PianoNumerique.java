/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Maxime
 */
public class PianoNumerique extends Piano{
    
    private boolean toucherLourd;
    private int qualiteDEchantillonage;

    public PianoNumerique(boolean toucherLourd, int qualiteDEchantillonage, int nbTouches, int longueur, int largeur, int prixDAchat, int prixDeVente) {
        super(nbTouches, longueur, largeur, "Piano numérique", prixDAchat, prixDeVente);
        this.toucherLourd = toucherLourd;
        this.qualiteDEchantillonage = qualiteDEchantillonage;
    }
    
    @Override
    public String toString() {
        String t;
        if(toucherLourd)
            t = "oui";
        else 
            t = "non";
        return super.toString()+"toucher lourd : "+t+"\n qualité d'échantillonage : "+qualiteDEchantillonage;
    }
}
