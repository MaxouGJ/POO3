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
public class HorlogeDigitale {
    
    Digit[] horloge = new Digit[4];
    
    static class Digit{
        int chiffre, max;

        public Digit(int max) {
            this.max = max;
        }

        public Digit(int chiffre, int max) {
            this.chiffre = chiffre;
            this.max = max;
        }
        
        public int getValeur(){
            return chiffre;
        }
        
        public void incremente(){
            if(!this.estALaValeurMax())
                chiffre++;
            else
                chiffre = 0;
        }
        
        public boolean estALaValeurMax(){
            return chiffre == max;
        }

        @Override
        public String toString() {
            return ""+chiffre+"";
        }
    }
    
    HorlogeDigitale(int a, int b, int c, int d){
            horloge[0] = new Digit(a, 2);
            horloge[1] = new Digit(b, 9);
            horloge[2] = new Digit(c, 5);
            horloge[3] = new Digit(d, 9);      
    }
    
    void incremente(){
        if(horloge[0].chiffre == 2 && horloge[1].chiffre == 3 && horloge[2].chiffre == 5 && horloge[3].chiffre == 9){
            horloge[0].chiffre = horloge[1].chiffre = horloge[2].chiffre = horloge[3].chiffre =0;
        }
        else{
            if(horloge[3].chiffre < 9)
                horloge[3].incremente();
            else{
                if (horloge[2].chiffre < 5){
                    horloge[3].incremente();
                    horloge[2].incremente();
                }
                else{
                    if(horloge[1].chiffre < 9){
                        horloge[3].incremente();
                        horloge[2].incremente();
                        horloge[1].incremente();
                    }
                    else{
                        if(horloge[0].chiffre < 1){
                            horloge[3].incremente();
                            horloge[2].incremente();
                            horloge[1].incremente();
                            horloge[0].incremente();
                        }
                        else{
                            horloge[0].chiffre = horloge[1].chiffre = horloge[2].chiffre = horloge[3].chiffre =0;
                        }
                    }
                }
            }
        }
    }
    
    public String toString(){
        return horloge[0].chiffre+""+horloge[1].chiffre+":"+horloge[2].chiffre+""+horloge[3].chiffre;
    }
    
    public static void main(String[] args){
        HorlogeDigitale h = new HorlogeDigitale(0,9,5,9);
        h.incremente();
        h.incremente();
        System.out.println(h);
    }
}
