
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Maxime
 */
public class ThreadCompteur extends Thread{
    static int place = 0;
    
    @Override
    public void run(){
        for(int i=1; i<=10; i++){
            try {
                this.dort();
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadCompteur.class.getName()).log(Level.SEVERE, null, ex);
            }
                System.out.print(i);
        }
        place++;
        
        System.out.println("\nJe suis à la place : "+place);
    }
       
    public void dort() throws InterruptedException{
        this.sleep((long) (Math.random()*1000));
    }
    public static void main(String[] args) throws InterruptedException{
        ThreadCompteur t1 = new ThreadCompteur();
        ThreadCompteur t2 = new ThreadCompteur();
        
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}

