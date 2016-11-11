/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Maxime
 */
public class Shadock extends Thread{

    Vases vases;

    public Shadock(Vases vases) {
        this.vases = vases;
    }
    
    @Override
    public void run(){
        if(Math.random()<0.5){
            int q = (int) (Math.random()*vases.getVase1()/2);
            vases.preleveVase1(q);
            vases.verseDansVase2(q);
            vases.getVase1();
        }
        else{
            int q = (int) (Math.random()*vases.getVase2()/2);
            vases.preleveVase2(q);
            vases.verseDansVase1(q);
            vases.getVase2();
        }
    }
    
    public static void main(String[] args){
        Shadock[] s = new Shadock[100]; 
        for(int i=0; i<100; i++){
            s[i] = new Shadock(new Vases(10, 10));
            s[i].start();
            //s[i].join();
        }
        
    }
}
