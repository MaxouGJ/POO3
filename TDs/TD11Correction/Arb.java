import java.util.Iterator;

public class Arb<E>{
		LC<Arb<E>> fils = new LC<Arb<E>>();
		E val;
			
		public Arb(E val){
			this.val= val;	
		}

		public void ajouteFils(Arb<E> a){
			fils.ajoute(a);
		}
		
		public Fifo<E> fl(){
			Fifo<E> res = new FifoLC<E>();
			FifoLC<Arb<E>> f = new FifoLC<Arb<E>>();
			f.put(this);
			while(!f.estVide()){
				Arb<E> a = f.pop();
				res.put(a.val);
				Iterator<Arb<E>> it = a.fils.getIterator();
				while(it.hasNext()){
					Arb<E> ae = it.next();
					System.out.println(ae.val);
					f.put(ae);										
				}
			}
			return res;
			
		}
	
		public Fifo<E> fp(){
			Fifo<E> res = new FifoLC<E>();
			Lifo<Arb<E>> f = new LifoLC<Arb<E>>();
			f.put(this);
			while(!f.estVide()){
				Arb<E> a = f.pop();
				res.put(a.val);
				Iterator<Arb<E>> it = a.fils.getIterator();
				while(it.hasNext()){
					f.put(it.next());					
				}
			}
			return res;
			
		}
	
}