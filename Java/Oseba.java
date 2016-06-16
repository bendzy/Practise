package APS_PETA_SEMINARSKA;


public class Oseba extends AbsOseba {

	private String ime;
	private String priimek;
	private Datum datum_rojstva;
	private Spol spol;
	private Naslov naslov;
	private String emso;
	
	private static String[] imena={"Marko","Miha","Rok","Janez","Bojan","Samo","Matej","Lozjka","Maricka","Andreja","Lucka","Luka"};
	private static String[] priimki={"Leban","Lol","Brezveze","Novak","Zgonc","Blablabla","Muhahahha","Smit","Kralj","Birsa","Zahovic","Ilicic"};
	private static String[] ulica={"Cesta v Dolino ","Cesta v blabla ","Trzaska ","Spruha ","Vodovodna ","Vojkova "};
	private static String[] hisnast={"10","5","2","33","65","11"};
	private static String[] kraj={"Ljubljana","Jesenice","Kranj","Kozina","Divaca","Dobrova"};
	private	static String[] ime_poste={"Posta Ljubljana","Posta Jesenice","Posta Kranj","Posta Kozina","Posta Divaca","Posta Dobrova"};
	

	
	public Oseba() {
		generate();
	}

	public void generate() {
		//DATUM 
		int random=(int) (Math.random()*12);
		this.ime=imena[random];
		this.priimek=priimki[random];
		
		int dan=0;
		int mesec=1+(int)(Math.random()*12);
		
		if(mesec == 1) {
			dan=1+(int)(Math.random()*27);
		}
		else if( (mesec == 3) || (mesec == 5) || (mesec == 8) || (mesec == 11 ) ){
			 dan=1+(int)(Math.random()*29);
		}
		else { 
			 dan=1+(int)(Math.random()*30);
		}
		
		int leto = 1980+(int)(Math.random()*12);
		this.datum_rojstva=new Datum(dan,mesec,leto);
		
		// EMSO
		String danE;
		if (dan <= 9 ) {
			danE="0"+Integer.toString(dan);
		}
		danE=Integer.toString(dan);
		String mesecE;
		if (mesec <=9) {
			mesecE="0"+Integer.toString(mesec);
		}
		mesecE=Integer.toString(mesec);
		String l=Integer.toString(leto);
		String letoE=l.substring(1, l.length());
		
		String rrE="50";
		
		//SPOL
		String spol1;
			if( ime.equalsIgnoreCase("Lojzka") || ime.equalsIgnoreCase("Lucka") || ime.equalsIgnoreCase("Andreja") ||
					ime.equalsIgnoreCase("Maricka")) {
						spol1=Integer.toString(500+(int)(Math.random()*499));
							this.spol=Spol.zenski;
			}
			else {
				spol1=Integer.toString((int)(Math.random()*499));
					this.spol=Spol.moski;
			}
		String kontrolna=Integer.toString((int)(Math.random()*9));
		
		this.emso =danE+mesecE+letoE+rrE+spol1+kontrolna;
		
				//NASLOV
				
				int index=(int)(Math.random()*6);
				String ul=ulica[index];
				String his=hisnast[index];
				String imep=ime_poste[index];
				String kr=kraj[index];
				int stevilka=0;	
				switch(index) {
					case 0:stevilka=1000;
					break;
					case 1:stevilka=4270;
					break;
					case 2: stevilka=4000;
					break;
					case 3: stevilka=6420;
					break;
					case 4: stevilka=6215;
					break;
					case 5: stevilka=1230;
					break;
					}
				this.naslov=new Naslov(ul, his, kr, imep, stevilka);
	
	}
	
	/*@Override
	public boolean manjsi (Primerljiv p ) {
		
		if (p instanceof Oseba ) {
			 
			Oseba o = (Oseba) p;
			
			switch (getAtr()) {
			case 1:  return ime.compareTo(o.getIme() ) * getSmer() < 0;
			case 2:	 return priimek.compareTo(o.getPriimek() )* getSmer() < 0;
			case 3:	 return datum_rojstva.getDan()*getSmer() < o.getDatum_rojstva().getDan()*o.getSmer();
			case 4:  return datum_rojstva.getMesec()*getSmer() < o.getDatum_rojstva().getMesec()*o.getSmer();
			case 5:  return datum_rojstva.getLeto()*getSmer()< o.getDatum_rojstva().getLeto()*o.getSmer();
			case 6:  if (spol.equals(Spol.zenski) && o.getSpol().equals(Spol.moski)) {
						return true;
					}
					return false;
			case 7:  return naslov.getHisna_st().compareTo(o.getNaslov().getHisna_st())*getSmer() < 0;
			case 8:  return naslov.getIme_poste().compareTo(o.getNaslov().getHisna_st())*getSmer() < 0;
			case 9:  return naslov.getKraj().compareTo(o.getNaslov().getKraj())*getSmer() < 0;
			case 10:  return naslov.getPostna_st()*getSmer() < o.getNaslov().getPostna_st() * getSmer();
			case 11: return naslov.getUlica().compareTo(o.getNaslov().getUlica())* getSmer() < 0;
			case 12 : return emso.compareTo(o.getEmso()) * getSmer()< 0;
		}
	 }
		return false;
		
}*/
	public boolean manjsi(String p){
		int smer = this.getSmer(); 
		return smer * this.vrniVredAtr().compareTo(p) < 0;
	}

	public boolean manjsi(Primerljiv p)
	{
	int smer = this.getSmer(); 
	return smer * this.vrniVredAtr().compareTo(p.vrniVredAtr()) < 0;
	}
	
	@Override
	public boolean ustreza (String niz) {
	
		switch ( getAtr() ) {
		case 1:  return ime.startsWith(niz);
		case 2:	 return priimek.startsWith(niz);
		case 3:	 return Integer.toString(datum_rojstva.getDan()).startsWith(niz);
		case 4:  return Integer.toString(datum_rojstva.getMesec()).startsWith(niz) ;
		case 5:  return  Integer.toString(datum_rojstva.getLeto()).startsWith(niz);
		case 6:  if  ( this.spol.equals(Spol.zenski) &&( (niz.compareTo("zenski") ==0 ||  niz.compareTo("z")==0) )) return true;
				 return false ;
		case 7:  return naslov.getHisna_st().startsWith(niz);
		case 8:  return naslov.getIme_poste().startsWith(niz);
		case 9:  return naslov.getKraj().startsWith(niz);
		case 10:  return Integer.toString(naslov.getPostna_st()).startsWith(niz);
		case 11: return naslov.getUlica().startsWith(niz);
		case 12 : return emso.startsWith(emso);
		default: return false;
		}
		
		
	}
	@Override
	public String vrniVredAtr() {
		switch( getAtr() ) {
		case 1: return ime;
		case 2: return priimek;
		case 3: return Integer.toString(datum_rojstva.getDan());
		case 4: return Integer.toString(datum_rojstva.getMesec());
		case 5: return Integer.toString(datum_rojstva.getLeto());
		case 6: return String.valueOf(spol);
		case 7: return naslov.getUlica();
		case 8: return naslov.getHisna_st();
		case 9: return naslov.getKraj();
		case 10: return naslov.getIme_poste();
		case 11: return Integer.toString(naslov.getPostna_st());
		case 12: return getEmso();
		}
		return null;
	}
	
	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPriimek() {
		return priimek;
	}

	public void setPriimek(String priimek) {
		this.priimek = priimek;
	}

	public Datum getDatum_rojstva() {
		return datum_rojstva;
	}

	public void setDatum_rojstva(Datum datum_rojstva) {
		this.datum_rojstva = datum_rojstva;
	}

	public Spol getSpol() {
		return spol;
	}

	public void setSpol(Spol spol) {
		this.spol = spol;
	}

	public Naslov getNaslov() {
		return naslov;
	}

	public void setNaslov(Naslov naslov) {
		this.naslov = naslov;
	}

	public String getEmso() {
		return emso;
	}

	public void setEmso(String emso) {
		this.emso = emso;
	}

	public boolean equals (Object o) {
	
		if ( o instanceof Oseba ) {
			Oseba os = (Oseba) o ;
				int x = getAtr();
				
				if ( x <= 12 && x > 0 ) {
					return this.vrniVredAtr().equalsIgnoreCase(os.vrniVredAtr());
				}
				else { 
					return this.toString().equalsIgnoreCase(os.toString());
				}
		}
		return false ;
	}
	
	public int hashcode() {
		return ime.hashCode()+priimek.hashCode()+datum_rojstva.hashCode()+naslov.hashCode()+spol.hashCode()+emso.hashCode();
	}
	public String toString() {
		return ime+" "+priimek+" "+datum_rojstva.toString()+" "+naslov.toString()+" "+emso;
	}
	
	public int vrniVredHash() {
		return this.vrniVredAtr().hashCode();
		
	}
	public boolean manjsiHash(Oseba p)	{
		return Math.abs(this.hashCode())<Math.abs(p.hashCode());
	}
	}

