import java.util.Iterator;


public class LC<E>{

	protected Cellule<E> debut;
	
	public void ajoute(E e){
		Cellule<E> c = new Cellule(e,this.debut);
		this.debut=c;
	}

	public void ajoute(E e , int i){
		if(this.debut==null){
			this.debut= new Cellule(e,null);
		}else{
			this.debut.ajoute(e,i);			
		}
	}
	
	public boolean estVide(){
			return this.debut == null;
	}
	
	public String toString(){
		Iterator<E> it = this.getIterator();
		String s="";
		while(it.hasNext()){
			s+=it.next().toString();
			s+="|";
		}
		return s;				
	}
	
	public Iterator<E> getIterator(){
		return new Iterator<E>(){
			Cellule<E> temp=debut;
			public boolean hasNext(){
				return temp!=null;				
			}
			public E next(){				
				E e= temp.getVal();	
				temp=temp.getSuiv();
				return e;
			}
			
			public void remove(){ 
				throw new UnsupportedOperationException();
			}			
		};
	}
		
		
	protected class Cellule<E>{
		private E val;
		private Cellule<E> suivant;
		
		public Cellule(E v, Cellule<E> s){
		this.val=v;
		this.suivant = s;
		}	
		
		public E getVal(){
			return val;
		}
		
		public Cellule<E> getSuiv(){
			return suivant;
		}
		
		public void setSuiv(Cellule<E> c){
			this.suivant=c;		
		}
		
		public void ajoute(E e, int i){
			if(i==0){
				Cellule<E> c = new Cellule(this.val,this.suivant);
				this.val =e;
				this.suivant=c;			
			}
			else if(this.suivant!=null){
				this.suivant.ajoute(e,i-1);				
			}
	
		}
	
	}
		




}
