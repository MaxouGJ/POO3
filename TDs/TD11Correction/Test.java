/*
 * Test.java
 * 
 * Copyright 2014 Pierre Charbit <charbit@liafa3.liafasc.sg.lan>
 * 
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301, USA.
 * 
 * 
 */


public class Test {
	
	public static void main (String args[]) {
		LifoLC<Integer> pile = new LifoLC<Integer>();
		pile.put(3);
		pile.put(55);
		pile.put(666);
		pile.put(66);
		pile.put(345);
		pile.pop();
				System.out.println(pile);
		
		pile.ajoute(56,2);
				System.out.println(pile);

		/*
		
		FifoLC<String> f = new FifoLC<String>();
		f.put("pierre");
		f.put("Momo");
		f.put("Titi");
		f.pop();
		System.out.println(f);
		
		Arb<Integer> a = new Arb<Integer>(-1);
		Arb[] tab = new Arb[10];
		for(int i =0;i<10;i++){
			tab[i] = new Arb<Integer>(i);
		}
		tab[0].ajouteFils(tab[2]);
		tab[0].ajouteFils(tab[4]);
		tab[2].ajouteFils(tab[3]);
		tab[2].ajouteFils(tab[5]);
		tab[4].ajouteFils(tab[7]);
		tab[1].ajouteFils(tab[6]);
		tab[6].ajouteFils(tab[8]);
		tab[6].ajouteFils(tab[9]);
		a.ajouteFils(tab[0]);
		a.ajouteFils(tab[1]);		
		
	
		
		System.out.println("prof"+a.fp());
		
		System.out.println("larg"+a.fl());
		* */
		
	}
}

