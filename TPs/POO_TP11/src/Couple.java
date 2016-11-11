/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Maxime
 */
public class Couple<K,V> implements AUneCle{

    K cle;
    V val;

    public Couple(K cle, V val) {
        this.cle = cle;
        this.val = val;
    }
    
    public V getValeur(){
        return val;
    }
    
    @Override
    public Object getClef() {
        return cle;
    }
    
    public Couple renverse(){
        return new Couple(val, cle);
    }
    
    public String toString(){
        return cle+" : "+val;
    }
}
