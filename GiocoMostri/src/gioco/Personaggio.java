package gioco;

public interface Personaggio {
	String getForza();
	int getVita();
	void attacca(Personaggio p); //sfruttiamo polimorfismo usando Personaggio per comprendere tutti 
	void riceviDanno(int danno);
	String toString();
}
