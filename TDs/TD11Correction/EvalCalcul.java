
import java.util.ArrayList;
public class EvalCalcul{
	LifoLC<Double> pile = new LifoLC();
	
	
	
//	public void construitPile(String s){
//		String[] tab = s.split(" ");
//		for(t:tab){
//			pi.put(t);				
//		}
//		
//	}
	
	public void reset(){
		pile = new LifoLC();
	}
	
	public double eval(String[] tab) throws Exception{
			Double d = 0.0;
			for(String t:tab){
				if(t.equals("+")||t.equals("-")||t.equals("X")||t.equals("/")){
					try{
						Double n2= pile.pop();
						Double n1= pile.pop();	
						if(t.equals("+")){
							d=n1+n2;
						}
						else if(t.equals("-")){
							d=n1-n2;
						}
						else if(t.equals("X")){
							d=n1*n2;	
						}
						else if(t.equals("/")){
							d=n1/n2;
						}										
						pile.put(d);					
					}
					catch(Exception e){
						throw new IncompleteExpressionException();

					}
				}
				else{
					try{
						d=Double.parseDouble(t);
						pile.put(d);
					}
					catch(Exception e){
						throw new IncompleteExpressionException();

					}
				}
			}
			
			try{
				d=pile.pop();
				if(!pile.estVide()){
						throw new IncompleteExpressionException();
				}
				return d;
			}
			catch(Exception e){
				throw new IncompleteExpressionException();
				
			}

		}
		
		 	
		
		public static void main(String[] args){
			EvalCalcul ev = new EvalCalcul();
			
			try{System.out.println(ev.eval(args));
			}
			catch(Exception e){
				System.out.println(e.getMessage());
			}
			
		}
	
	
		class IncompleteExpressionException extends Exception{
				public String getMessage(){
					return "Erreur : Expression incomplete";
				}
			
			}
	
	
	
	
}