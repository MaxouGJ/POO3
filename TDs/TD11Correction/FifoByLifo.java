public abstract class FifoByLifo<E> implements Fifo<E>{
	Lifo<E> phaut;
	Lifo<E> pbas;
	int n;
	
	public void put(E e){
		pbas.put(e);	
		n++;	
	}

	public E pop(){
		if(phaut.estVide()){
			pbas.renverseSur(phaut);			
		}
		if(phaut.estVide()){
			return null;
		}
		else{
			n--;
			return phaut.pop();		
		}
	}


	public boolean estVide(){
		return n==0;
	}

	public int taille(){
		return n;
	}
	
	
}
