package main;

public abstract class Radnik {

	private String ime;
	private int godineRada;
	private int mesecnaPlata;
	private int bonus;

	//zasto bismo u konstruktoru zvali seter, zato i promijenjeno u kako jeste
	public Radnik(String ime) {
		this.ime = ime;
	}

	public Radnik() {

	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public int getGodineRada() {
		return godineRada;
	}

	public void setGodineRada(int godineRada) {
		this.godineRada = godineRada;
	}

	public int getMesecnaPlata() {
		return mesecnaPlata;
	}

	public void setMesecnaPlata(int mesecnaPlata) {
		this.mesecnaPlata = mesecnaPlata;
	}

	public int getBonus() {
		return bonus;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}
	
	//prebacena ovde iz Zaposleni
	//feature envy 
	//prevaceno je pomocu desni klik refactor move
	//uklonili smo string jer ga pravimo samo da privremeno drzimo poruku koju vracamo
	public String prikaziPlatu() {
		if (getIme() != null) {
			return getIme() + " prima " + isplata();
		} else {
			return "Ovo nije radnik!";
		}
	}


	//nesto je ovde nije moralo ovako
	//switch ruzan za dugotrajnu upotrebu gdje ce biti izmjena
	//treba ih izdvajati u posebne klase
	// kad dodam jos jedan tip radnika, moram ga dodati u switch, znaci lose za prosirivanje
	//replace type code with subclasses
	//bice na zadatku za poene
	//u glavnu klasu skupiti neko zajednicko ponasanje
	//trebace nam  ove dvije metode i konstruktor
	public double minuliRad() {
		return godineRada * mesecnaPlata;
//		switch (getTip()) {
//		case "INZENJER":
//			return godineRada * 0.20 * mesecnaPlata;
//		case "PRODAVAC":
//			return godineRada * 0.10 * mesecnaPlata;
//		case "MENADZER":
//			return godineRada * 0.15 * mesecnaPlata;
//		default:
//			throw new RuntimeException("Neispravan tip zaposlenog");
//		}
	}
	
	//sta ako ucitam nesto sto ucitavam je neispravan tip radnika
	//mozda je rjesenje napraviti poseban tip koji se zove neispravan tip radnika
	//pri ucitavanju mozemo da odmah bacamo izuzetak

	public double isplata() {
		return mesecnaPlata + minuliRad();
//		switch (getTip()) {
//		case "INZENJER":
//			return mesecnaPlata + izracunajProsek() + bonus;
//		case "PRODAVAC":
//			return mesecnaPlata + izracunajProsek();
//		case "MENADZER":
//			return mesecnaPlata + izracunajProsek() + (0.5 * bonus);
//		case "POMOCNI RADNIK":
//			return mesecnaPlata;
//		default:
//			throw new RuntimeException("Neispravan tip zaposlenog");
//		}
	}

}
