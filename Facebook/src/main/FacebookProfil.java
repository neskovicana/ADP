package main;

public class FacebookProfil extends ProfilNaSocijalnojMrezi {
	
	private String id, ime, status;
	
	FacebookProfil(int brojPr) {
		super(brojPr);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FacebookProfil other = (FacebookProfil) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public void setId(String id) {
		this.id = id;
	}


	public void setIme(String ime) {
		this.ime = ime;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	@Override
	public String toString() {
		return "FacebookProfil [id=" + id + ", ime=" + ime + ", status=" + status + "]";
	}
	
	

}
