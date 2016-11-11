public interface Fifo<E>{

	public void put(E e);

	public E pop();

	public boolean estVide();

	public int taille();
	



}
