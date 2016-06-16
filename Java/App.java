package APS_PETA_SEMINARSKA;

import java.util.Scanner;

public class App {
	static Scanner sc=new Scanner(System.in);

	static ZRTOseb<Oseba> zrtoseb;
	public static void main(String[] args) {

		while( true ) {
			switch( meni() ) {

			case 0: System.out.print("EXIT");System.exit(1);
			break;

			case 1: zrtoseb=new ZRTOseb();
			break;

			case 2: System.out.print("Vpisite kapaciteto tabele :");
			zrtoseb=new ZRTOseb(sc.nextInt());
			break;

			case 3: System.out.println("Vpisite kapaciteto tabele in prag :");
			zrtoseb=new ZRTOseb(sc.nextInt(),sc.nextDouble());
			break;

			case 4: System.out.println("Vpisite kapaciteto tabele, prag , ter strategijo :");
				zrtoseb=new ZRTOseb(sc.nextInt(),sc.nextDouble(),sc.nextBoolean());
				break;

			case 5: System.out.print("Nastavite atribut :");
			zrtoseb.nastaviAtr(sc.nextInt());
			break;

			case 6: System.out.print("Vpisite kapaciteto :");
			zrtoseb.nastaviKap(sc.nextInt());
			break;

			case 7: System.out.println("Vpisite prag :");
			zrtoseb.nastaviPrag(sc.nextDouble());
			break;

			case 8: System.out.print("Vpisite strategijo : ");
			zrtoseb.nastaviStr(sc.nextBoolean());
			break;

			case 9: zrtoseb.izpisiNastavitve();
			break;

			case 10:	
				double r= (Math.random());
				if (r <0.5)  {
					zrtoseb.dodaj(new Oseba());
				}
				else {
					zrtoseb.dodaj(new Delavec());
				}	
			break;

				case 11: System.out.println("Vpisite st elementov");
				Oseba[] tmp=new Oseba[sc.nextInt()];
				for(int i=0;i<tmp.length;i++) {
				 r= (Math.random());
					if (r < 0.5 ) tmp[i]=new Oseba();
					else tmp[i]=new Delavec();
				}
				zrtoseb.dodaj(tmp);
				break;

				case 12 : zrtoseb.brisiVse();
				break;
				
				case 13 : r=(Math.random());
							if (r <0.5 ) {
								Oseba o = new Oseba();
								System.out.println("Brisemo :  "+o.toString());
								zrtoseb.brisi(o);
							}
							else {
								Delavec d=new Delavec();
								System.out.println("Brisemo : "+d.toString());
								zrtoseb.brisi(d);
							}
				break;
				
				case 14 : System.out.println("Vpisite niz za brisanje : "+zrtoseb.brisi(sc.next()));
				break;
				
				case 15: System.out.println("Vpisite spodnjo in zgornjo mejo ");
						String sp=sc.next();
						String zg=sc.next();
						zrtoseb.brisiPoAtr(sp, zg);
					
					
				case 16: zrtoseb.izpisiVseAtr();
				break;
				
				case 17: System.out.println("Vpisite niz za izpis : " );
				zrtoseb.izpisi(sc.next());
				break;
				
				case 18: System.out.println("Vpisite spodnjo in zgornjo mejo ");
							String spodnja=sc.next();
							String zgornja=sc.next();
								zrtoseb.izpisiPoAtr(spodnja, zgornja);
				break;
				
				case 19 : 	 zrtoseb.izpisiMinMax();
				break;
				
				case 20 : zrtoseb.izpisiUrejeno();
				break;
				}
			

			}



		}


	

		//********************************MENI********************************//
		public static int meni() {
			System.out.println("0--> EXIT");
			System.out.println("1--> Tvorba prazne tabele z kapaciteto 10, pragom 0.75 ter linearno strategijo");
			System.out.println("2--> Tvorba prazne tabele z vpisano kapaciteto, pragom 0.75 ter linearno strategijo");
			System.out.println("3--> Tvorba prazne tabele z vpisano kapaciteto in pragor ter linearno strategijo");
			System.out.println("4--> Tvorba prazne tabele z vpisanimi lastnostmi");
			System.out.println("5--> Nastavitev atr ter prepis tabele");
			System.out.println("6--> Nastavitev kapacitete ter prepis tabele");
			System.out.println("7--> Nastavitev praga ter mozen prepis tabele");
			System.out.println("8--> Nastavitev strategije ter mozen prepis tabele ");
			System.out.println("9--> Izpis vseh nastavitev ");
			System.out.println("10--> Dodajanje osebe glede na vrednost hash funkcije");
			System.out.println("11--> Zaporedno dodajanje vseh iz tabele ");
			System.out.println("12--> Brisanje vseh ");
			System.out.println("13--> Brisanje dolocenga elementa");
			System.out.println("14--> Brisanje ki imajo enako vredonst podanega atributa  ");
			System.out.println("15--> Brisanje sp / zg meja");
			System.out.println("16--> Izpis vseh atributa za celo tabelo   ");
			System.out.println("17--> Izpisi vse ki imajo vrednost atributa enak podanemu   ");
			System.out.println("18--> Izpis vseh med sp / zg mejo");
			System.out.println("19--> Izpis oseb z MIN/MAX vrednostji  ");
			System.out.println("20--> Izpis urejeno  ");
			System.out.print("Vnesite izbiro : ");
			return sc.nextInt();
		}

	}
