package main;

//nasledjuje polja i metode, konstruktor ne
public class Inzenjer extends Radnik {

	public static final double KOEFICIJENT = 0.20;

	public Inzenjer() {
		super();
	}

	public Inzenjer(String ime) {
		super(ime);
	}

	@Override
	public double minuliRad() {
		return super.minuliRad() * KOEFICIJENT;
	}

	@Override
	public double isplata() {
		return super.isplata() + getBonus();
	}
	
}
