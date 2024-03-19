package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

//replace error code with exception-od proslog casa smell, taj nivo izmjene programa je dozvoljen
public class Zaposleni {

	private static final String ZAPOSLENI = "zaposleni.txt";
	private Radnik[] radnici;

	// konstruktor koji citav niz prima kao parametar a ne da se nesto setuje
	// ljepsi konstruktor, da li vise konstruktora, da li proslijediti citav niz

	// factory method: kreira objekte koji su mi potrebni na osnovu nekih parametara

	// napraviti da ovo bude jedini try catch, a da sve ostalo baca izuzetke
	public Zaposleni(String zaposleni) {

		try {
			BufferedReader bf = otvaranjeBf(zaposleni);
			
			radnici = new Radnik[Integer.parseInt(bf.readLine().trim())];
			for (int i = 0; i < radnici.length; i++) {
				String[] podaci = bf.readLine().split("\\|");
				for (int j = 0; j < podaci.length; j++)
					podaci[j] = podaci[j].trim();
				Radnik radnik = kreirajRadnika(podaci[0], podaci[1]);
				radnik.setGodineRada(Integer.parseInt(podaci[2]));
				radnik.setMesecnaPlata(Integer.parseInt(podaci[3]));
				if (podaci.length > 4) {
					radnik.setBonus(Integer.parseInt(podaci[4]));
				}
				radnici[i] = radnik;
				zatvaranjeBf(bf);
			}
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}

	}

	// samo jedan switch mora da ostane, a to je ovaj pri kreiranju objekata
	// mozemo staviti da je static jer faktory metod moze biti staticki
	private static Radnik kreirajRadnika(String ime, String tip) {
		switch (tip) {
		case "INZENJER":
			return new Inzenjer(ime);
		case "MENADZER":
			return new Inzenjer(ime);
		case "PRODAVAC":
			return new Inzenjer(ime);
		case "POMOCNI RADNIK":
			return new Inzenjer(ime);
		default:
			throw new RuntimeException("Neispravan tip zaposlenog");
		}
	}

	public Radnik[] getRadnici() {
		return radnici;
	}

	// kolekcije ne setujemo ovako
	// imali bismo add radnika, u ovom slucaju samo add, nekad i add i remove
	// takodje niz nije ni najbolja struktura za cuvanje podataka
	public void setRadnici(Radnik[] radnici) {
		this.radnici = radnici;
	}

	private BufferedReader otvaranjeBf(String file) throws FileNotFoundException {
		BufferedReader bf;
		bf = new BufferedReader(new FileReader(file));
		return bf;
	}

	private void zatvaranjeBf(BufferedReader bf) throws IOException {
		bf.close();
	}

	public static void main(String[] args) {
		Zaposleni zap = new Zaposleni(ZAPOSLENI);
		for (int i = 0; i < zap.getRadnici().length; i++) {
			System.out.println(zap.getRadnici()[i].prikaziPlatu());
		}

	}

}
