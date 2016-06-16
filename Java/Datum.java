package APS_PETA_SEMINARSKA;

public class Datum {
	private int dan;
	private int mesec;
	private int leto;
	
	
	//SET & GeT
	public int getDan() {
		return dan;
	}
	public void setDan(int dan) {
		this.dan = dan;
	}
	public int getMesec() {
		return mesec;
	}
	public void setMesec(int mesec) {
		this.mesec = mesec;
	}
	public int getLeto() {
		return leto;
	}
	public void setLeto(int leto) {
		this.leto = leto;
	}
	
	//konstruktor
	
	public Datum (int dan, int mesec, int leto ) {
		this.dan=dan;
		this.mesec=mesec;
		this.leto=leto;
	}
	
	public String toString() {
		return dan+" "+mesec+" "+leto;
	}
}
