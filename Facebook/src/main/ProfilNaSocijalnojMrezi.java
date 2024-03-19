package main;

public abstract class ProfilNaSocijalnojMrezi implements CvorUMrezi{
	
	// ne koristi se implementirani metod
	// zato mozemo obrisati interfejs
	
	private class Prijatelji
	{
		private ProfilNaSocijalnojMrezi niz[];
		private int popunjeno;
		
		Prijatelji(int n)
		{
			niz = new ProfilNaSocijalnojMrezi[n];
			popunjeno = 0;
		}
		
		public int vratiInd(ProfilNaSocijalnojMrezi p)
		{
			for(int i=0;i<popunjeno;i++)
				if(niz[i].equals(p))
					return i;
			return -1;
		}
		
		public boolean imaMesta()
		{
			return popunjeno<niz.length;
		}
		
		public void dodaj(ProfilNaSocijalnojMrezi p)
		{
			niz[popunjeno++] = p;
		}
		
		public String pomIspis()
		{
			String s = "";
			for(int i=0;i<popunjeno;i++)
			{
				s += (FacebookProfil) niz[i];
				s += "\n";
			}
			return s;
		}
	}
	
	Prijatelji prijatelji;
	
	public ProfilNaSocijalnojMrezi(int brojPr)
	{
		this.prijatelji = new Prijatelji(brojPr);
	}

	//select method, references, workspace, ako se nigdje ne koristi, brisemo ga (ovde sam selektovala vratiInd)
	@Override
	public boolean sused(CvorUMrezi c) {
		return (this.prijatelji.vratiInd((ProfilNaSocijalnojMrezi) c) != -1);
	}
	
	public void dodajPrijatelja(ProfilNaSocijalnojMrezi pr) throws NekonzistentniPodaci
	{
		if(this.prijatelji.imaMesta())
			this.prijatelji.dodaj(pr);
		else
			throw new NekonzistentniPodaci("Previse ih je u " + ((ProfilNaSocijalnojMrezi)this).toString());
	}
	
	public String pomocnaIspis()
	{
		return this.prijatelji.pomIspis();
	}
}
