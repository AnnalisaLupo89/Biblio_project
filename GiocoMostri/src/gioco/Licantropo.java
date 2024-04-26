package gioco;

import java.util.Random;

public class Licantropo implements Mostro, Umano {
	
	private boolean isUomo;
	
	protected int forzaUmano, forzaMostro;
	int vita;
	int forza;
	public Licantropo()

	{
		
		Random random = new Random();
	    this.isUomo = random.nextBoolean();
	    if (isUomo) {
	        forzaUmano = 35;
	        forzaMostro = 0;
	       // System.out.println("Il random ha scelto un umano.");
	    } else {
	        forzaMostro = 45;
	        forzaUmano = 0;
	        //System.out.println("Il random ha scelto un licantropo.");
//		isUomo = !luna;
//		if (luna) {
//			forzaMostro = 35;
//			forzaUmano = 0;
//			
//		} else {
//			forzaUmano = 30;
//			forzaMostro = 0;
		
		} vita = 80;
	}

	
	
	@Override
	public String getForza() {
		return "Forza rimanente come umano: " + forzaUmano + "; " + "Forza rimanente come mostro: " + forzaMostro;
	}

	@Override
	public void azzanna(){
		
		//if (!isUomo) forzaMostro=forzaMostro-2;}
	if (!isUomo && vita>0 && forzaMostro>0){
		forzaMostro +=5;
		forzaUmano -=3;
		
	}
//	if(!isUomo&&vita<=0){
//		System.out.println("Sono morto.");
//	}
	}

//	public void combatti(){
//		 if (isUomo) forzaUmano=forzaUmano-3;}

	public void combatti() {
		if (isUomo && vita>0 && forzaUmano >0) {
			forzaMostro -=5;
			forzaUmano +=3;
	}
//		if(!isUomo&&vita<=0){
//		System.out.println("Sono morto.");
//	}
	}
	

	@Override
	public int getVita() {
		return vita;
	}

	@Override
	public void attacca(Personaggio p) {
		
		if(!isUomo && vita>0 && forzaMostro>0) {
			p.riceviDanno(forzaMostro);
			azzanna();
			//System.out.println("Il licantropo ti sta azzanando! La tua vita è: " +p.getVita());
		}
		else if(isUomo && vita>0 && forzaUmano >0){
			p.riceviDanno(forzaUmano);
			combatti();
			//System.out.println("L'umano ti sta attaccando! La tua vita è: " +p.getVita());
		}
		else {
			System.out.println("Sono morto.");
		}

	}

	@Override
	public void riceviDanno(int danno) {
		vita-=danno;
		if (vita<0) {
			vita=0;
			forzaUmano=forzaMostro=0;
			//System.out.println("Sono morto.");
	}
}
	@Override
	public String toString() {
	    return "licantropo";
	}	
}
