package APS_PETA_SEMINARSKA;

public class Naslov {
	
	private String ulica;
	private String hisna_st;
	private String kraj;
	private String ime_poste;
	private int postna_st;
	public String getUlica() {
		return ulica;
	}
	public void setUlica(String ulica) {
		this.ulica = ulica;
	}
	public String getHisna_st() {
		return hisna_st;
	}
	public void setHisna_st(String hisna_st) {
		this.hisna_st = hisna_st;
	}
	public String getKraj() {
		return kraj;
	}
	public void setKraj(String kraj) {
		this.kraj = kraj;
	}
	public String getIme_poste() {
		return ime_poste;
	}
	public void setIme_poste(String ime_poste) {
		this.ime_poste = ime_poste;
	}
	public int getPostna_st() {
		return postna_st;
	}
	public void setPostna_st(int postna_st) {
		this.postna_st = postna_st;
	}
	
	public Naslov (String ulica, String hisna_st, String kraj, String ime_poste, int postna_st) {
		this.ulica=ulica;
		this.hisna_st=hisna_st;
		this.kraj=kraj;
		this.ime_poste=ime_poste;
		this.postna_st=postna_st;
	}
	
	public String toString() {
			return ulica+" "+hisna_st+" "+kraj+" "+ime_poste+" "+postna_st;
	}
	
}
