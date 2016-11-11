/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Maxime
 */
public class GuitareAcoustique extends Guitare {
    
    private String type;
    private int tirant;

    public GuitareAcoustique(String type, int tirant, int longueur, int largeur, int prixDAchat, int prixDeVente) {
        super(longueur, largeur, "Guitare acoustique", prixDAchat, prixDeVente);
        this.type = type;
        this.tirant = tirant;
    }    
    
    @Override
    public String toString() {
        return super.toString()+ "type : "+type+"\n tirant : "+tirant+"\n";
    }
}
