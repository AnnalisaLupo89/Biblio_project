package gioco;


public class Eroe implements Umano {

	int forza;
	int vita;
	
public Eroe() {
	forza=30;
	vita=100;
}

@Override
public String getForza() {
	
	return "Forza rimanente come eroe: " +forza;
}

@Override
public void combatti() {
	if(vita>0 && forza>0) {
		forza -=7;
		//System.out.println("L'eroe ti sta attaccando!");		
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
		p.riceviDanno(forza); //10 val messo a caso, ma deve essere un parametro legato alla forza
		combatti(); //self-reference di metodi
	
	}
//	else {System.out.println("Sono morto");
//		
//	}
	

	
}

@Override
public void riceviDanno(int danno) {
	vita-=danno;
	if (vita<0) {
		vita=0;
		forza=0;
		//System.out.println("L'eroe è morto.");
}

}

public String toString() {
	return "eroe";
}

}
