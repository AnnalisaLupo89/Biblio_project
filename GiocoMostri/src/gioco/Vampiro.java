package gioco;


public class Vampiro implements Mostro {

	protected int forza;
	protected int vita;

	
	public Vampiro() {
		forza=25;
		vita=90;
		
	
		
	}
	
	
	@Override
	public String getForza() {
		
		return "Forza rimanente come vampiro: "+forza;
	}

	@Override
	public void azzanna() {
		if(vita>0 && forza>0) {
			forza -=5;
			//forza +=5; //la forza acquisita durante azzanna
		
		}else {System.out.println("Non posso attaccare");
		
		}
	}


	@Override
	public int getVita() {
		return vita;
	}


	@Override
	public void attacca(Personaggio p) {
			if (vita>0) {
				p.riceviDanno(forza);//10 val messo a caso, ma deve essere un parametro legato alla forza
				azzanna(); //self-reference di metodi
				
			}
//			else {System.out.println("Sono morto");
//				
//			}
	}


	@Override
	public void riceviDanno(int danno) {
		vita-=danno;
		if (vita<0) {
			vita=0;
			forza=0;
			//System.out.println("Il vampiro è morto.");
		}
	}

	@Override
	public String toString() {
	    return "vampiro";
	}

}
