public class FifoByLifoLC<E> extends FifoByLifo<E>{
	
	
	public FifoByLifoLC(){
		this.phaut=new LifoLC();
		this.pbas= new LifoLC();
	}
	
	public void reempile(){
		LifoLC<E> temp = new LifoLC();
		phaut.renverseSur(temp);
		pbas.renverseSur(phaut);
		temp.renverseSur(phaut);
	}
	
	public String toString(){
		String s1=phaut.toString();
		LifoLC<E> temp = new LifoLC();
		pbas.renverseSur(temp);
		s1+=temp.toString();
		temp.renverseSur(pbas);
		return s1;		
	}
	
}