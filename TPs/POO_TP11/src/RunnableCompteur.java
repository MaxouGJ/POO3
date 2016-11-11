/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Maxime
 */
public class RunnableCompteur implements Runnable{

    @Override
    public void run() {
        new ThreadCompteur().run();
        new ThreadCompteur().run();
    }
    
    public static void main(String[] args){
        new RunnableCompteur().run();
    }
    
}
