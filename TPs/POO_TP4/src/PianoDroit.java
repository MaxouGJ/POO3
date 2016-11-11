/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Maxime
 */
public class PianoDroit extends Piano {
    
    private String typeCorde;
    private boolean silencieux;

    public PianoDroit(String typeCorde, boolean silencieux, int nbTouches, int longueur, int largeur, int prixDAchat, int prixDeVente) {
        super(nbTouches, longueur, largeur, "Piano droit", prixDAchat, prixDeVente);
        this.typeCorde = typeCorde;
        this.silencieux = silencieux;
    }
    
    @Override
    public String toString() {
        String s;
        if(silencieux)
            s = "oui";
        else 
            s = "non";
        return super.toString()+"type de cordes : "+typeCorde+"\n silencieux : "+s+"\n";
    }
}
