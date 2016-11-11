/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Maxime
 */
public class GuitareElectrique extends Guitare {
    
    private boolean amplificateur, pedales;

    public GuitareElectrique(boolean amplificateur, boolean pedales, int longueur, int largeur, int prixDAchat, int prixDeVente) {
        super(longueur, largeur, "Guitare électrique", prixDAchat, prixDeVente);
        this.amplificateur = amplificateur;
        this.pedales = pedales;
    }
    
    @Override
    public String toString() {
        String a, p;
        if(amplificateur)
            a = "oui";
        else 
            a = "non";
        if(pedales)
            p = "oui";
        else 
            p = "non";
        return super.toString()+ "amplificateur : "+a+"\n pédales : "+p;
    }
}
