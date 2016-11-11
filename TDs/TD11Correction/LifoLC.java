public class LifoLC<E> extends LC<E> implements Lifo<E>{
	private int taille;
	
	
	public void put(E e){
		this.ajoute(e);
		taille++;
	}
	
	public E pop(){
		if(this.debut==null){
			return null;	
		}
		else{
			E e = debut.getVal();
			this.debut= debut.getSuiv();
			taille--;
			return e;
		}
	}




	public int taille(){
		return taille;
		
	}
	
	public void renverseSur(Lifo<E> p){
		while(!this.estVide()){
			p.put(this.pop());
		}
	}
	
}



