public interface Lifo<E>{
	void put(E e);

	E pop();

	boolean estVide();

	int taille();
	
	void renverseSur(Lifo<E> p);
		
	
	
	
}