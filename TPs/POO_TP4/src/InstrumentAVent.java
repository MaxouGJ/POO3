/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Maxime
 */
public class InstrumentAVent extends Instrument {
    
    private String type;

    public InstrumentAVent(String nom, int prixDAchat, int prixDeVente, String type) {
        super(nom, prixDAchat, prixDeVente);
        this.type = type;
    }

    @Override
    public String toString() {
        return super.toString()+"type : "+type+"\n";
    }
    
    
    
}
