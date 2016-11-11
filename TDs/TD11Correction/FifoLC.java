import java.util.Iterator;

public class FifoLC<E> extends LC<E> implements Fifo<E>{
	
	private int taille;
	protected Cellule<E> fin ; 
	
	public void put(E e){
		Cellule<E> c = new Cellule(e,null);
		if(this.fin!=null){
			this.fin.setSuiv(c);
			this.fin=c;
			taille++;
		}
		else{			
			this.debut=c;
			this.fin=this.debut;
			taille++;
		}
	}
	
	public E pop(){
		if(this.debut==null){
			return null;	
		}
		else{
			E e = debut.getVal();
			this.debut= debut.getSuiv();
			if(this.debut==null)
				this.fin=null;
			taille--;
			return e;
		}
	}




	public int taille(){
		return taille;
		
	}
	


}
