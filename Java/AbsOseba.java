package APS_PETA_SEMINARSKA;

public abstract class AbsOseba implements Primerljiv {
	
	private static int atribut = 1;
	private static int smer = 1;
	
	public int getAtr() {
		return atribut;
	}
	public int getSmer() {
		return smer;
	}
	public void setAtr(int x) {
		atribut=x;
	}
	public void setSmer(int x) {
		if (x >= 1 ) {
			smer = 1;
		}
		else if (x == 0 ) {
			smer = 0;
		}
		else {
			smer =-1;
		}
		
	}
	
	
}
