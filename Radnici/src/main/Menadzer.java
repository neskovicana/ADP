package main;

//nasledjuje polja i metode, konstruktor ne
public class Menadzer extends Radnik {

	public static final double KOEFICIJENT_BONUS = 0.5;
	public static final double KOEFICIJENT = 0.15;

	public Menadzer() {
		super();
	}

	public Menadzer(String ime) {
		super(ime);
	}

	@Override
	public double minuliRad() {
		return super.minuliRad() * KOEFICIJENT;
	}

	@Override
	public double isplata() {
		return super.isplata() + (KOEFICIJENT_BONUS * getBonus());
	}
	
}
