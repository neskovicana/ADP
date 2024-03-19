package test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Inzenjer;
import main.Menadzer;
import main.Prodavac;
import main.Radnik;

class RadnikTest {

	private Radnik radnik;
	private Radnik[] radnici;

	@BeforeEach
	void setUp() throws Exception {
		radnik = new Radnik() {
		};
	}

	@Test
	void testMinuliRad() {
		radnici = new Radnik[3];

		radnici[0] = new Inzenjer();
		ubaciPodatke(radnici[0]);

		radnici[1] = new Prodavac();
		ubaciPodatke(radnici[1]);

		radnici[2] = new Menadzer();
		ubaciPodatke(radnici[2]);

		double[] ocekivaneVrednosti = new double[] {
				radnici[0].getGodineRada() * Inzenjer.KOEFICIJENT * radnici[0].getMesecnaPlata(),
				radnici[1].getGodineRada() * Prodavac.KOEFICIJENT * radnici[1].getMesecnaPlata(),
				radnici[2].getGodineRada() * Menadzer.KOEFICIJENT * radnici[2].getMesecnaPlata() };
		assertArrayEquals(ocekivaneVrednosti,
				new double[] { radnici[0].minuliRad(), radnici[1].minuliRad(), radnici[2].minuliRad() });
	}

	@Test
	void testInzenjerIsplata() {
		radnik = new Inzenjer();
		ubaciPodatke(radnik);
		assertEquals(radnik.isplata(), radnik.minuliRad() + radnik.getMesecnaPlata() + radnik.getBonus());
	}

	@Test
	void testProdavacIsplata() {
		radnik = new Prodavac();
		ubaciPodatke(radnik);
		assertEquals(radnik.isplata(), radnik.minuliRad() + radnik.getMesecnaPlata());
	}

	@Test
	void testMenadzerIsplata() {
		radnik = new Menadzer();
		ubaciPodatke(radnik);
		assertEquals(radnik.isplata(), radnik.minuliRad() + radnik.getMesecnaPlata() + Menadzer.KOEFICIJENT_BONUS * radnik.getBonus());
	}

// Nema vise smisla za ovom test metodom jer ne moze biti kreiran neispravan tip radnika	
//	@Test()
//	void testNeispravanTipIsplata() {
//	}

	@Test
	void testIsplataVecaOdNule() {
		radnik = new Menadzer();
		ubaciPodatke(radnik);
		assertTrue(radnik.isplata() > 0,"Plata radnika " + radnik.isplata() + " bi trebalo da je veca od 0");
	}

	private void ubaciPodatke(Radnik radnik) {
		int godineRada = 2;
		int mesecnaPlata = 50000;
		int bonus = 6000;
		radnik.setGodineRada(godineRada);
		radnik.setMesecnaPlata(mesecnaPlata);
		radnik.setBonus(bonus);
	}

}

//sta je radjeno u ovome, sta je refaktorisano? uporedi prvu i poslednju verziju testova
// to je za domaci :)
// dobicemo da refakorisemo testove na zadatku za bodove
// kako mijenjamo kod ostalim, tako i testove
