/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Maxime
 */
public class Vases {
  
    private int vase1, vase2;

    public Vases(int vase1, int vase2) {
        this.vase1 = vase1;
        this.vase2 = vase2;
    }
    
    void preleveVase1(int q){
        if(vase1-q <= 0)
            return;
        vase1 -= q;
    }
    
    void verseDansVase1(int q){
        vase1 += q;
    }
    
    void preleveVase2(int q){
        if(vase1-q <= 0)
            return;
        vase1 -= q;
    }
    
    void verseDansVase2(int q){
        vase2 += q;
    }

    public int getVase1() {
        return vase1;
    }

    public int getVase2() {
        return vase2;
    }
    
}
