/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Maxime
 */
public class Maison extends Batiment {

    private int nbPieces;
    private int surfaceJardin;
    
    protected Maison(String adresse, int surfaceHabitable, int nbPieces, int surfaceJardin){
        super(adresse, surfaceHabitable);
        this.nbPieces = nbPieces;
        this.surfaceJardin = surfaceJardin;
    }

    @Override
    public String toString() {
        return "Maison{" + "nbPieces=" + nbPieces + ", surfaceJardin=" + surfaceJardin + '}';
    }

    public int getSurfaceJardin() {
        return surfaceJardin;
    }
    
}
