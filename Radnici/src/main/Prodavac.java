package main;

//nasledjuje polja i metode, konstruktor ne
public class Prodavac extends Radnik {

	public static final double KOEFICIJENT = 0.10;

	public Prodavac() {
		super();
	}

	public Prodavac(String ime) {
		super(ime);
	}

	@Override
	public double minuliRad() {
		return super.minuliRad() * KOEFICIJENT;
	}

	@Override
	public double isplata() {
		return super.isplata();
	}
	
}
