/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Maxime
 */
public class Batiment {

    private String adresse;
    private int surfaceHabitable;
    public final static double tauxA = 5.6;
    public final static double tauxB = 1.5;
    private Personne proprio;
    
    protected Batiment(String adresse, double surfaceHabitable){
        this.adresse = adresse;
        this.surfaceHabitable = (int)surfaceHabitable;
    }

    public Batiment(String adresse, int surfaceHabitable, Personne proprio) {
        this.adresse = adresse;
        this.surfaceHabitable = surfaceHabitable;
        this.proprio = proprio;
    }

    public void setProprio(Personne proprio) {
        this.proprio = proprio;
    }

    public Personne getProprio() {
        return proprio;
    }
    

    @Override
    public String toString() {
        return "Batiment{" + "adresse=" + adresse + ", surfaceHabitable=" + surfaceHabitable + '}';
    }

    public int getSurfaceHabitable() {
        return surfaceHabitable;
    }
    
    public int getSurfaceJardin() {
        return 0;
    }
    
    public double impot(){
        return tauxA*getSurfaceHabitable()+tauxB*getSurfaceJardin();
    }
    
}
