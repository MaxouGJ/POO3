/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Maxime
 */
public class Immeuble extends Batiment {
    
    private int nbAppart;
    private Appartement[] apparts;

    public Immeuble(String adresse, double surfaceHabitable, int nbAppart) {
        super(adresse, surfaceHabitable);
        this.nbAppart = nbAppart;
        apparts = new Appartement[nbAppart];
        for(int i=0; i<apparts.length; i++){
            apparts[i] = new Appartement(this.getProprio());
        }
    }

    @Override
    public String toString() {
        return "Immeuble{" + "nbAppart=" + nbAppart + '}';
    }
    
    public void changerLocataire(int nApp, Personne loc){
        for(int i=0; i<apparts.length; i++){
            if(apparts[i].getNumero() == nApp )
                apparts[i].setLocataire(loc);
        }    
    }
    
    public void virerLocataire(int nApp, Personne loc){
        for(int i=0; i<apparts.length; i++){
            if(apparts[i].getNumero() == nApp )
                apparts[i].setLocataire(null);
        }    
    }
    
}
