package main;

//nasledjuje polja i metode, konstruktor ne
public class PomocniRadnik extends Radnik {

	public PomocniRadnik() {
		super();
	}

	public PomocniRadnik(String ime) {
		super(ime);
	}

	@Override
	public double minuliRad() {
		throw new RuntimeException();
	}

	@Override
	public double isplata() {
		return getMesecnaPlata();
	}
	
}
