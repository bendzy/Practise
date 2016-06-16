package APS_PETA_SEMINARSKA;

public class ZRTOseb<E extends Oseba> {
	
	private E[] tabelca;
	private int kapaciteta;
	private double prag;
	private boolean strategija; // true linearna false kvadraticna
	
	private int stElementov=0;
	
	//*******************FUNKCIJA ZA PREPIS IN POVECANJE TABELE TABELE**************//
	private void prepisi(int novakapaciteta) {
		
		E[] nova= tabelca;
		tabelca=(E[]) new Oseba[novakapaciteta];
		stElementov=0;
		kapaciteta=novakapaciteta;
		dodaj(nova);
				
	}
	
	//********************LINEARNA & KVADRATNA *******************************//
	public int linearna(int index) {
		
			while (tabelca[index] != null) {
				index++;
				if (index == tabelca.length)
						index=0;
			}
			return index;
	}
	
	private int kvadraticna(int rez){
		int st = 2;
		int zacSt = 0;
		
		while (tabelca[rez] != null){
			st=st*2;
			rez += st;
			if (rez >= kapaciteta){
				rez = zacSt;
				zacSt++;
			}
		}
		return rez;
	}
	//*********************************KONSTRUKTORJI*****************************//
	//KONSTRUKOR NO 1 
	
	
	public ZRTOseb() {
		this.kapaciteta=10;
		tabelca=(E[]) new Oseba[this.kapaciteta];
		this.prag= 0.75;
		this.strategija=true;
		
	}
	
	//KONSTRUKTOR N0 2
	
	public ZRTOseb(int k) {
		tabelca=(E[]) new Oseba[this.kapaciteta=k];
		this.prag=0.75;
		this.strategija=true;
	}
	
	//KONSTRUKTOR NO 3
	
	public ZRTOseb(int k, double p ) {
		tabelca=(E[]) new Oseba[this.kapaciteta=k];
		this.prag=p;
		this.strategija=true;
	}
	
	//KONSTRUKTOR NO 4
	
	public ZRTOseb (int k, double p,boolean s ) {
		tabelca=(E[]) new Oseba[this.kapaciteta=k];
		this.prag=p;
		this.strategija=s;
	}
	
	//****************************DODAJ STUFF ************************************************//
	
	public void setKapaciteta(int kapaciteta) {
		this.kapaciteta = kapaciteta;
	}

	public void setPrag(double prag) {
		this.prag = prag;
	}

	public void setStrategija(boolean strategija) {
		this.strategija = strategija;
	}

	public void setStElementov(int stElementov) {
		this.stElementov = stElementov;
	}

	public E[] getTabelca() {
		return tabelca;
	}

	public void setTabelca(E[] tabelca) {
		this.tabelca = tabelca;
	}

	public void dodaj(E t) {
			if (t == null ) return;
			
			if( ((stElementov+ 1.0)/ kapaciteta) >= prag) 
				prepisi(kapaciteta*2);
			
			int hash=Math.abs(t.vrniVredHash());
			int rez=hash % kapaciteta;
		
			if (tabelca[rez] == null){}
			
			else if (strategija) {
				rez=linearna(rez);
			}
			else {
				rez=kvadraticna(rez);
			}
			tabelca[rez]=t;
			stElementov++;
	}
	
	public void dodaj(E[] t) {
		for (int i=0;i<t.length;i++) {
			dodaj(t[i]);
		}
		
	}
	
	//********************NASTAVITVE**************************************//
	
	public void nastaviAtr(int a) {
		Oseba b = new Oseba();
		b.setAtr(a);
		prepisi(kapaciteta);
	}
	
	public void nastaviKap(int k) {
		this.kapaciteta=k;
		prepisi(kapaciteta);
	}
	
	public void nastaviPrag(double p) {
		if(p>0 && p<1) {
		this.prag=p;
		if ((stElementov/kapaciteta) >= prag)
			prepisi(kapaciteta*2);
		}
	}
	
	public void nastaviStr( boolean s ) {
		if(s == strategija )
			return;
		else { this.strategija=s;
				prepisi(kapaciteta);
		}
	}
	
	public void izpisiNastavitve() {
		System.out.println("Kapaciteta je :"+this.kapaciteta+ " Prag je : " +this.prag+ " Strategija je :  "+(strategija ? " Linearna":" Kvadraticna")+ 
				" Stevilo elementov je : "+this.stElementov);
	}
	
	
	//***************************BRISANJE***************************//
	public void brisiVse() {
		tabelca=(E[]) new Oseba[this.kapaciteta];
		stElementov=0;
	}
	
	public void brisi (E t) {
		
		for (int i=0;i<tabelca.length;i++) {
			if (tabelca[i] == null) 
				continue;
			if (tabelca[i].equals(t)) {
				tabelca[i]=null;
				stElementov--;	
			}
		}
	}
	
	public int brisi (String s) {
		int st=0;
		for (int i=0;i<tabelca.length;i++) {
			if (tabelca[i] == null) 
				continue;
			if (tabelca[i].vrniVredAtr().compareToIgnoreCase(s) == 0) {
				st++;
				stElementov--;
				tabelca[i]=null;
			}
				
		}
		return st;
	}
	
	/*public int brisipoAtr (String sp, String zg) {
		
	}*/
	
	//********************************IZPIS***************************//
	
	public void izpisiVseAtr() {
		for (int i=0;i<tabelca.length;i++) {
			if (tabelca[i] == null)
				System.out.println("Index je prazen ");
			else
			System.out.println(tabelca[i].vrniVredAtr());
		}
	}
	
	public void izpisi (String s) {
		for (int i=0;i<tabelca.length;i++) {
				if( tabelca[i]==null) continue;
			if ( (tabelca[i].vrniVredAtr().compareToIgnoreCase(s) ) == 0) 
				System.out.println(tabelca[i].toString());
		}
		
	}
	
	public void izpisiMinMax() {
		int min=0,max=0;
	
		for(int i=0;i<tabelca.length;i++) {
			if (tabelca[i] != null) {
				min=i;
				max=i;
				break;
			}
		}
		for(int i=0;i<tabelca.length;i++) {
			if(tabelca[i]== null) continue;
		
			tabelca[i].setSmer(-1);
			if ( ! (tabelca[i].manjsi(tabelca[max]))) {
				max=i;
			}
		}
			for(int i=0;i<tabelca.length;i++) {
				if(tabelca[i]== null) continue;
				
				if (tabelca[i].manjsi(tabelca[min])) {
					min=i;
				}		
				
		}
			System.out.println("Minimalen element je : "+tabelca[max]);
			System.out.println("Maximalen element je : "+tabelca[min]);
			
	}
	
	public void izpisiPoAtr(String spMeja, String zgMeja){
		for(int i=0;i<kapaciteta;i++){
			if(tabelca[i]!=null&&tabelca[i].manjsi(zgMeja)&&!tabelca[i].manjsi(spMeja))
					System.out.println(tabelca[i]);
		}
	}
		public void brisiPoAtr(String spMeja, String zgMeja){
			for(int i=0;i<kapaciteta;i++){
				if(tabelca[i]!=null&&tabelca[i].manjsi(zgMeja)&&!tabelca[i].manjsi(spMeja))
						brisi(tabelca[i]);
			}
	}
	
		 public static void straightinsertion(Oseba[] a) {
		    int i,j;
		    Oseba x;
		    for (i=1; i<a.length; ++i) {
		      x=a[i];
		      for (j=i-1; (j>=0 && (x.manjsiHash(a[j]))); --j)
		        a[j+1]=a[j];
		      a[j+1]=x;
		    } 
		  }
		 
		public void izpisiUrejeno()	{
			Oseba[] tmp =new Oseba[stElementov];
			int anze=0;
			for(int i=0;i<tabelca.length;i++) {

			if(tabelca[i]== null) 
			continue;
			tmp[anze++]=tabelca[i];
			}
			straightinsertion(tmp);
			for(int i=0;i<tmp.length;i++){
				System.out.println(tmp[i]);
			}
		}
		
		public boolean manjsiHash(Oseba p)	{
			return Math.abs(this.hashCode())<Math.abs(p.hashCode());
		}
	
	
}
