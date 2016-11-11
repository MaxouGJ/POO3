/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Maxime
 */
public class Appartement {

    private Personne proprio, locataire;
    private int numero;
    private static int numeroApp = 1;

    public Appartement(Personne proprio) {
        this.proprio = proprio;
        this.numero = numeroApp;
        numeroApp++;
    }

    public void setLocataire(Personne locataire) {
        this.locataire = locataire;
    }

    public void setProprio(Personne proprio) {
        this.proprio = proprio;
    }

    public Personne getProprio() {
        return proprio;
    }

    public Personne getLocataire() {
        return locataire;
    }

    public int getNumero() {
        return numero;
    }

    @Override
    public String toString() {
        return "Appartement{" + "proprio=" + proprio + ", locataire=" + locataire + ", numero=" + numero + '}';
    }
    
    
    
}
