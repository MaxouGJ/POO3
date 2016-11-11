/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Maxime
 */
public class TestBatiment {

    public static int surfaceHabitableTotale(Batiment[] b){
        int r = 0;
        for(int i=0; i<b.length; i++){
            r += b[i].getSurfaceHabitable();
        }
        return r;
    }
    
    public static int surfaceJardinTotale(Batiment[] b){
        int r = 0;
        for(int i=0; i<b.length; i++){
            r += b[i].getSurfaceJardin();
        }
        return r;
    }
    
    public static void main(String[]args){
        Batiment b = new Batiment("2 rue Paul Prouteau", 1000);
        Maison m1 = new Maison("jhhferh", 190, 6,100);
        Maison m2 = new Maison("jhhferh", 110, 6,150);
        Maison m3 = new Maison("jhhferh", 100, 6,200);
        Immeuble i1 = new Immeuble("reg", 19000, 100);
        Immeuble i2 = new Immeuble("reg", 2900, 15);
        Immeuble i3 = new Immeuble("reg", 1090, 20);
        
        //System.out.println(b);
        //System.out.println(m);
        //System.out.println(i);
        
        Batiment[]bat = new Batiment[6];
        bat[0] = m1;
        bat[1] = i1;
        bat[2] = m2;
        bat[3] = i2;
        bat[4] = m3;
        bat[5] = i3;
//        for(int j = 0; j < 10; j++){
//            System.out.println(bat[j]);
//        }
//        System.out.println(surfaceHabitableTotale(bat));
//        System.out.println(surfaceJardinTotale(bat));
        
        
    }
}
