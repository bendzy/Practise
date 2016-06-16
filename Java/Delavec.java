package APS_PETA_SEMINARSKA;

import java.util.Random;

import APS1_DRUGA_SEM.Spol;

public class Delavec extends Oseba {
	private	static String[] podjetje={"Acroni","Hidria","Vegrad"};
	private	static String[] polozajx={"Delovodja","Vodja obrata","BigBoss"};
	
	private String ime_podjetja;
	private int delovna_doba;
	private String polozaj;
	private boolean zavarovan;
	private double[][] place;
	
	public String getIme_podjetja() {
		return ime_podjetja;
	}
	public void setIme_podjetja(String ime_podjetja) {
		this.ime_podjetja = ime_podjetja;
	}
	public int getDelovna_doba() {
		return delovna_doba;
	}
	public void setDelovna_doba(int delovna_doba) {
		this.delovna_doba = delovna_doba;
	}
	public String getPolozaj() {
		return polozaj;
	}
	public void setPolozaj(String polozaj) {
		this.polozaj = polozaj;
	}
	public boolean isZavarovan() {
		return zavarovan;
	}
	public void setZavarovan(boolean zavarovan) {
		this.zavarovan = zavarovan;
	}
	public double[][] getPlace() {
		return place;
	}
	public void setPlace(double[][] place) {
		this.place = place;
	}
	
	public Delavec () {
		super.generate();
		generate();
	}
	public void generate() {
		
		//ZAVAROVAN*/
		Random r=new Random();
		this.zavarovan=r.nextBoolean();
		
		int leto = 1980+(int)(Math.random()*12);
		
		//podjetje
		this.ime_podjetja=podjetje[(int)(Math.random()*3)];
		//delovnadoba
		
		this.delovna_doba=2010-leto;
		this.polozaj=polozajx[(int)(Math.random()*3)];
		
		
		//place
		place=new double[delovna_doba][];
		
		
		for(int i=0;i<place.length;i++) {
			if(i == 0) {
				place[i] =new double[(int) Math.random()*12];		
			}
			if ( i > 0 && i< delovna_doba-1) {
				place[i]=new double [12];
			}
			if ( i == delovna_doba -1 ) {
				place[i]=new double[9];
			}
			
		}
		for (int i=0;i<place.length;i++) {
			for (int j=0;j<place[i].length;j++) {
				place[i][j]=800+(Math.random()*200);
			}
		}
		
	
	}
	public String toString() {
		return super.toString()+" "+ime_podjetja+" "+delovna_doba+" "+polozaj+" "+zavarovan+" ";
	}
	public int stElementov(double[][] place) {
		int elementi=0;
		for(int i=0;i<place.length;i++) {
			for(int j=0;j<place[i].length;j++) {
				elementi++;
			}
		}
		return elementi;
	}
	public int vsotaElementov(double[][] place) {
		int vsota=0;
		for(int i=0;i<place.length;i++) {
			for(int j=0;j<place[i].length;j++) {
				vsota+=place[i][j];
			}
		}
		return vsota;
	}
	public double max(double[][] place) {
		double max=Integer.MIN_VALUE;
		for(int i=0;i<place.length;i++) {
			for(int j=0;j<place[i].length;j++) {
				if( place[i][j]>max) {
					max=place[i][j];
				}
			}
	}
		return max;
	}
	public double min(double[][] place) {
	double min=Integer.MAX_VALUE;
	for(int i=0;i<place.length;i++) {
		for(int j=0;j<place[i].length;j++) {
			if( place[i][j]<min) {
			min=place[i][j];
			}
		}
	}
	return min;
	}
	public double povprecna(double[][] place) {
		double vsota1=0;
		double vsota=0;
			for(int i=0;i<place.length;i++) {
				vsota1=0;
				for(int j=0;j<place[i].length;j++) {
					vsota1+=place[i][j];
				}
					vsota+=vsota1/place[i].length;
			}
			return vsota;
	}
	
	public boolean  manjsi ( Primerljiv p) {
		
			
		if ( p instanceof Delavec ) {
			Delavec d= (Delavec ) p;
				
				switch ( getAtr() ) {
				//IME PRIIMEK
				case 1: return this.getIme().compareTo(d.getIme()) * getSmer() < 0;
				case 2 : return this.getPriimek().compareTo(d.getPriimek()) * getSmer() <0;
				// DATUM_ROJSTVA
				case 3 : return this.getDatum_rojstva().getDan()* getSmer() < d.getDatum_rojstva().getDan() * getSmer() ;
				case 4 : return this.getDatum_rojstva().getMesec() *getSmer() < d.getDatum_rojstva().getMesec() *getSmer();
				case 5 : return this.getDatum_rojstva().getLeto() *getSmer() < d.getDatum_rojstva().getLeto() *getSmer();
				//SPOL
				case 6: if( this.getSpol().equals(Spol.zenski) && d.getSpol().equals(Spol.moski) ) return true; return false;
				// NASLOV
				case 7 : return this.getNaslov().getUlica().compareTo(d.getNaslov().getUlica()) * getSmer() < 0 ;
				case 8 : return this.getNaslov().getHisna_st().compareTo(d.getNaslov().getHisna_st()) * getSmer() < 0 ;
				case 9 : return this.getNaslov().getKraj().compareTo(d.getNaslov().getKraj())*getSmer() < 0 ;
				case 10: return this.getNaslov().getIme_poste().compareTo(d.getNaslov().getIme_poste()) *getSmer() < 0 ;
				case 11 :return this.getNaslov().getPostna_st()* getSmer() < d.getNaslov().getPostna_st()*getSmer();
				//EMSO
				case 12: return this.getEmso().compareTo(d.getEmso()) * getSmer() < 0;
				
				//Delavec stuff
				case 13 : return this.ime_podjetja.compareTo(d.getIme_podjetja()) * getSmer() < 0;
				case 14 : return Integer.toString(this.delovna_doba).compareTo(Integer.toString(d.getDelovna_doba())) *getSmer() < 0;
				case 15 : return this.polozaj.compareTo(d.getPolozaj()) *getSmer() < 0;
				case 16 : return this.boolTotxt(this.zavarovan).compareTo(boolTotxt(d.isZavarovan()))*getSmer()< 0 ;
				default : return false;
				}
		}
		return false;
		
	}
	
	
	
	public boolean ustreza (String niz) {
		
		
		switch( getAtr()) {
		case 1: return this.getIme().startsWith(niz);
		case 2: return this.getPriimek().startsWith(niz);
		//DATUM
		case 3: return Integer.toString(this.getDatum_rojstva().getDan()).startsWith(niz);
		case 4: return Integer.toString(this.getDatum_rojstva().getMesec()).startsWith(niz);
		case 5: return Integer.toString(this.getDatum_rojstva().getLeto()).startsWith(niz);
		case 6:  if( this.getSpol().equals(Spol.zenski) && (niz.compareToIgnoreCase("zenski") == 0 ||  niz.compareToIgnoreCase("z") == 0) ) return true;
        return false;
        
        //NASLOV 
		case 7: return this.getNaslov().getUlica().startsWith(niz);
		case 8 : return this.getNaslov().getHisna_st().startsWith(niz);
		case 9 : return this.getNaslov().getKraj().startsWith(niz);
		case 10: return this.getNaslov().getIme_poste().startsWith(niz);
		case 11 :return Integer.toString(this.getNaslov().getPostna_st()).startsWith(niz);
		
		//EMSO
		case 12: return this.getEmso().startsWith(niz);
		
		//DELAVEC STAFF
		case 13: return this.ime_podjetja.startsWith(niz);
		case 14: return Integer.toString(this.delovna_doba).startsWith(niz);
		case 15: return this.polozaj.startsWith(niz);
		case 16: return boolTotxt(this.zavarovan).startsWith(niz);
		
		//place
		case 17: return Integer.toString(this.stElementov(place)).startsWith(niz);
		case 18: return Double.toString(vsotaElementov(place)).startsWith(niz);
		case 19: return Double.toString(max(place)).startsWith(niz);
		case 20: return Double.toString(min(place)).startsWith(niz);
		case 21: if (Double.toString(povprecna(place)).startsWith(niz) ) {
						return true;
				}
				return false;
		default : return false ;
		}
		
	}

	public String  vrniVredAtr() {
		switch(getAtr()) {
       
		case 1: return this.getIme();
        case 2: return this.getPriimek();

        // datum
        case 3: return Integer.toString(this.getDatum_rojstva().getDan());
        case 4: return Integer.toString(this.getDatum_rojstva().getMesec());
        case 5: return Integer.toString(this.getDatum_rojstva().getLeto());
        case 6: return this.getSpol().toString();

        // naslov
        case 7: return this.getNaslov().getUlica();
        case 8: return this.getNaslov().getHisna_st();
        case 9: return this.getNaslov().getKraj();
        case 10: return this.getNaslov().getIme_poste();
        case 11: return Integer.toString(this.getNaslov().getPostna_st());
        // emso
        case 12: return this.getEmso();
        
        //delavec:
        case 13: return this.getIme_podjetja();
        case 14: return Integer.toString(this.getDelovna_doba());
        case 15: return this.getPolozaj();
        case 16: return this.boolTotxt(isZavarovan());
        case 17: return izpisiPlace();
        default : return null;
		}
	}
	public String izpisiPlace() {
		String niz="";
		for(int i=0;i<place.length;i++) {
			for(int j=0;j<place[i].length;j++) {
				niz+=place[i][j]+" ";
			}
		}
		return niz;
	}
	public String boolTotxt(boolean b) {
		if ( b ) return "true";
		return "false";
	}
	public boolean equals (Object o) {
		
		if ( o instanceof Delavec ) {
			Delavec d = (Delavec ) o ;
		
				int x =d.getAtr();
				System.out.println(x);
				if( x <= 17 && x > 0 ) {
					return this.vrniVredAtr().equalsIgnoreCase(d.vrniVredAtr());
				
				}
				else {
					return this.toString().equalsIgnoreCase(o.toString());
				}
		}
		return false;
	}
	public int hashcode() {
		return super.hashcode()+ime_podjetja.hashCode()+delovna_doba+polozaj.hashCode()+boolTotxt(zavarovan).hashCode()+hashTab();
	}
	@Override
	public int vrniVredHash() {
		
		return Math.abs(vrniVredAtr().hashCode());
	}
	
	public int hashTab() {
		double vsota=0;
			for(int i=0;i<place.length;i++) {
				for(int j=0;j<place[i].length;j++) {
					vsota+=place[i][j];
				}
			}
			return (int) vsota;
	}
}
