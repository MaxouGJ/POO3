/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo_tp6;

/**
 *
 * @author Maxime
 */
public class Main {

    static int f(int x){
        return x;
    }
    
    static Integer g(Integer x){
        return x;
    }
    
    public static void  main(String[] args){
        int a = 1;
        Integer c = new Integer(3);
        int b = new Integer(2);
        Integer d = 4;
        f(a);
        f(b);
        g(a);
        g(b);
    }
}
