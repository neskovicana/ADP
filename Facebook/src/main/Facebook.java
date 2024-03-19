package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Facebook {

	private FacebookProfil niz[];
	
	//open buffer metod izdvojiti
	//close buffer isto u poseban metod
	//obrati paznju na nazive promjenljivih
	
	public FacebookProfil[] profilCitanje(String profili) {
		BufferedReader bf;
		try {
			bf = new BufferedReader(new FileReader(profili));
			niz = new FacebookProfil[Integer.parseInt(bf.readLine().trim())];
			for (int i = 0; i < niz.length; i++) {
				String[] podaci = bf.readLine().split("\\|");
				for (int j = 0; j < podaci.length; j++)
					podaci[j] = podaci[j].trim();
				FacebookProfil fp = new FacebookProfil(Integer.parseInt(podaci[2]));
				fp.setId(podaci[0]);
				fp.setIme(podaci[1]);
				if (podaci.length == 4)
					fp.setStatus(podaci[3]);

				niz[i] = fp;
			}
			bf.close();
			return niz;
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
			return null;
		}

	}

	public void matricaCitanje(String matrica, FacebookProfil[] niz) {
		BufferedReader bf;
		try {
			bf = new BufferedReader(new FileReader(matrica));
			niz = new FacebookProfil[Integer.parseInt(bf.readLine().trim())];
			for (int i = 0; i < niz.length; i++) {
				String[] podaci = bf.readLine().split("\\|");
				for (int j = i + 1; j < podaci.length; j++) {
					if (Integer.parseInt(podaci[j].trim()) == 1) {
						niz[i].dodajPrijatelja(niz[j]);
						niz[j].dodajPrijatelja(niz[i]);
					}
				}
			}
			bf.close();
		} catch (IOException | NekonzistentniPodaci e) {
			e.printStackTrace();
			return;
		}

	}

	Facebook(String Profili, String Matrica) {
		niz = profilCitanje(Profili);
		matricaCitanje(Matrica, niz);
	}

	//kod konkatenacije stringa se uvijek pravi string
	//zato je bolje praviti bufferString
	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i < niz.length; i++) {
			String ss = niz[i].toString();
			ss += "\n Prijatelji:\n";
			ss += niz[i].pomocnaIspis();
			ss += "\n";
			s += ss;
		}
		return s;
	}

	//neka se ovo zove args
	//prosledjujemo hardcodovane stringove
	//sve sto je hardcodovano izdvojiti u konstante
	//ako ih ima putno napraviti posebnu klasu koja sadrzi samo konstante
	//
	public static void main(String[] sdadsa) {
		Facebook fb = new Facebook("profili.txt", "matrica.txt");
		System.out.println(fb);
	}
}
