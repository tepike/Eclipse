package Bloods;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.time.Clock;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class Rendeles extends Menu {
	
	 static JPanel Rendeles_panel= new JPanel();
	 static int Rendelesek=Menu.Rendelesek_Adatbazis;
	 static int Rendelesi_Oldalak=(Rendelesek/8);
	 static int Rendelesi_Oldalak_Seged=Rendelesi_Oldalak;
	 static int Jelenlegi_Oldal=0;
	 static int Jelenlegi_Oldal_Seged=0;
	 static int Fennmarado_Rendelesek=(Rendelesek%8);
	 static boolean Maradok_Szamolva=false;
	 

	 static int Doboz_Magas=200;
	 static int Doboz_Szeles=250;
	 static int Doboz_X=150;
	 static int Doboz_Y=30;
	 static boolean betoltve=false;
	 
	 static boolean sql_frissitve=false;
	 static boolean Tovabbnyil_nyomhato=true;
	 static boolean Visszanyil_nyomhato=true;
	 
	 //Az a gond, hogy a rendelesek az 0 így a panel csak 1.
	static JPanel[] Panel_tomb = new JPanel[Rendelesek+1];
	static JLabel[] Label_tomb_X = new JLabel[Rendelesek+1];
	static JLabel[] Label_Kovetes_tomb = new JLabel[Rendelesek+1];
	static JLabel[][] Label_Rendeles_Adatok = new JLabel[Rendelesek+1][40];
	static JLabel[][] Label_Columns= new JLabel[Rendelesek+1][40];
	static JLabel Tovabb_Nyil = new JLabel("Tovább");
	static JLabel Vissza_Nyil = new JLabel("Vissza");
	
	  String Azonosito;
	  String Rendelest_felvette;
	  String Rendeles_leadva;
	  String Elerhetoseg;
	  String Eloleg;
	  String Eloleg_fizetve;
	  String Tetelek;
	  String Fizetendo;
	  String Elkeszitesi_ido;
	  String Vallalt_teljesites;
	  String Teljesitve;
	  
	  static int Label_Magassag=0;
	  static int Osszes_Colum=0;
	  static int Osszes_Colum_Hasnolit=0;
	  static boolean Colum_Betoltve=false;
	  static int kivalasztott_panel;
	
	public Rendeles (String Azonosito,String Rendelest_felvette,String Rendeles_leadva,
					String Elerhetoseg,String Eloleg, String Eloleg_fizetve,String Tetelek,
					String Fizetendo,String Elkeszitesi_ido,String Vallalt_teljesites,String Teljesitve){
		
		this.Azonosito=Azonosito;
		this.Rendelest_felvette=Rendelest_felvette;
		this.Rendeles_leadva=Rendeles_leadva;
		this.Elerhetoseg=Elerhetoseg;
		this.Eloleg=Eloleg;
		this.Eloleg_fizetve=Eloleg_fizetve;
		this.Tetelek=Tetelek;
		this.Fizetendo=Fizetendo;
		this.Elkeszitesi_ido=Elkeszitesi_ido;
		this.Vallalt_teljesites=Vallalt_teljesites;
		this.Teljesitve=Teljesitve;
		return;
	}
	public void printeles() {
		System.out.println("Adatok printelese: Azonosito: "+Azonosito+"| Rendelest_felvette: "+Rendelest_felvette+"| Rendeles_leadva: "+Rendeles_leadva+"| Elerhetoseg: "+Elerhetoseg+"| Eloleg: "+Eloleg
				+"| Eloleg_fizetve: "+Eloleg_fizetve+"| Tetelek: "+Tetelek+"| Fizetendo: "+Fizetendo+"| Elkeszitesi_ido: "+Elkeszitesi_ido+"| Vallalt_teljesites: "+Vallalt_teljesites
				+"| Teljesitve: "+Teljesitve);
	}
	


	
	public static void Rendeles_lathato()  {

		//System.out.println("Tomb merete: "+Panel_tomb.length);
		
		
		
		
		System.out.println("Rendeles betoltese");
		Menu_panel.setVisible(false);
		Menu_Osszesito_panel.setVisible(false);
		
		Hatterkep_Keret.add(Rendeles_panel);
		Rendeles_panel.setBounds(35, 100, 1250, 580);
		Rendeles_panel.setLayout(null);
		Rendeles_panel.setBackground(new Color(10,10,10,200));
		Rendeles_panel.setVisible(true);


	}
	
	public static void Bolt_lathato()  {
		System.out.println("Bolt betoltese");
		timer.purge();
		timer.cancel();
		timer = new Timer();
		Menu_panel.setVisible(true);
		Menu_Osszesito_panel.setVisible(true);
		Rendeles_panel.setVisible(false);
		Adatbazis_Frissites_Mp_Mehet=false;
		Frissites_ujratolt=true;
		

	}
	
	static ArrayList<Integer> arrayList = new ArrayList<Integer>();
	
	//Csak akkor lehet true ha éppen a rendelési panel fut különben a timer mindig frissíti az adatokat, az pedig akkor lehetséges ha van visible panel
	public static Timer timer= new Timer();
	static boolean Adatbazis_Frissites_Mp_Mehet=true;
	static boolean Frissites_ujratolt=true;
	static boolean Frissites_Utani_Eslo_Toltes=false;

	static int Sql_frissites_ido=5000;
	
	
	public static void Rendeles_Doboz() throws Exception {
		Sgl_Darab_Valtozas_Figyeles();
		Osszes_Colum_Hasnolit=Osszes_Colum;
		Adatbazis.Rendelesek_lekerdezese();
		if(Osszes_Colum_Hasnolit!=Osszes_Colum) {
			betoltve=false;
		}
		
		
		if(!betoltve) {
			System.err.println("Feltoltes elindul");
			
			
			
			
			

		
		for(int i =1;i<=Rendelesek;) {
			
			final int hanyadik=i;
			


			//System.out.println(i);
			//System.out.println("Rendelesek szama: "+Rendelesek);
	
			//Rendelési panel létrehozása
			Panel_tomb[i]=new JPanel();
			Panel_tomb[i].setBounds(Doboz_X, Doboz_Y, Doboz_Szeles, Doboz_Magas);
			Panel_tomb[i].setBackground(Color.white);
			Panel_tomb[i].setBorder(BorderFactory.createLineBorder(Color.gray,4));
			Panel_tomb[i].setLayout(null);
			
			//Panel bázárásának megalkotása
			Label_tomb_X[i]=new JLabel("X");
			Label_tomb_X[i].setFont(new Font("Tahoma", Font.BOLD, 20));
			Label_tomb_X[i].setForeground(Color.red);
			Label_tomb_X[i].setVisible(false);
			Panel_tomb[i].add(Label_tomb_X[i]);
			
			
			Label_Magassag=0;
				


			
			if(!sql_frissitve) {
				System.out.println("Sql frissites true tehat frissit ellenorzes = "+sql_frissitve);
				
				sql_frissitve=true;
			}
			
			if(hanyadik ==1) {
				Adatbazis.Rendelesek_lekerdezese();
			}
			
			//System.out.println("Osszes_Colum: "+Osszes_Colum);
				for(int d=1;d<Osszes_Colum;d++) {
					
					Panel_tomb[i].add(Label_Columns[i][d]);
					Label_Columns[i][d].setFont(new Font("Tahoma", Font.BOLD, 18));
					Label_Columns[i][d].setBounds(7, 0+Label_Magassag, 200, 30);
					
					Panel_tomb[i].add(Label_Rendeles_Adatok[hanyadik][d]);
					Label_Rendeles_Adatok[i][d].setFont(new Font("Tahoma", Font.BOLD, 15));
					Label_Rendeles_Adatok[i][d].setBounds(7, 20+Label_Magassag, 200, 30);
					
					
					
					if(d==2|d==3|d==6|d==7|d==8|d==9|d==11) {
						//System.err.println("D vizsgalata: "+d);
						Label_Columns[i][d].setVisible(false);
						Label_Rendeles_Adatok[i][d].setVisible(false);
						// Labelek állítása darbszámhoz hozva
						Label_Magassag=Label_Magassag-50;	
					}
					if(d==1|d==4|d==5|d==10) {
						Label_Columns[i][d].setBounds(7, 0+Label_Magassag, 200, 30);						
					}
					Label_Magassag=Label_Magassag+50;

				}
				
				
			Label_Kovetes_tomb[i]=new JLabel(Integer.toString(hanyadik));
			Label_Kovetes_tomb[i].setFont(new Font("Tahoma", Font.BOLD, 28));
			Label_Kovetes_tomb[i].setForeground(Color.red);
			Label_Kovetes_tomb[i].setVisible(false);
			Label_Kovetes_tomb[hanyadik].setBounds(Panel_tomb[hanyadik].getWidth()/2, 50, 60, 30);
			Panel_tomb[i].add(Label_Kovetes_tomb[i]);
			
			//Panel dupla kattintásra nagyítása
		
			Panel_tomb[i].addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent e) {
    				Visszanyil_nyomhato=false;
    				Tovabbnyil_nyomhato=false;
		            if (e.getClickCount() == 2 && !e.isConsumed()) {
		            	

		            	
		            	Adatbazis.kapcsolat_teszt();
		                    e.consume();
		                    Doboz_X=((int)Panel_tomb[hanyadik].getLocation().getX());
		                    Doboz_Y=((int)Panel_tomb[hanyadik].getLocation().getY());
		                    Rendeles_panel.setComponentZOrder(Panel_tomb[hanyadik], 0);
		                    Panel_tomb[hanyadik].setBounds((int)Rendeles_panel.getWidth()/2-(Doboz_Szeles), (int)Rendeles_panel.getHeight()/2-(Doboz_Magas+75), Doboz_Szeles+350, Doboz_Magas+300);
		                    Panel_tomb[hanyadik].repaint();
		                  //Rendelések kitöltése amikor nagy
		                    Label_tomb_X[hanyadik].setBounds(Panel_tomb[hanyadik].getWidth()-30, 5, 30, 30);
		                    //Label_Kovetes_tomb[hanyadik].setBounds(Panel_tomb[hanyadik].getWidth()/2, 50, 60, 30);
		                    Label_tomb_X[hanyadik].setVisible(true);
		                    
		    				// Rendelési panelek kisképes betöltése
		                    
		                    Label_Magassag=0;
		                    try {
		                    	kivalasztott_panel=hanyadik;
		                    	Adatbazis.Adat_Frissit_Egy();
		                    	System.out.println("\nPanelek feltoltese sql adattal");
			    				for(int d=1;d<Osszes_Colum;d++) {
			    					
			    					Panel_tomb[hanyadik].add(Label_Columns[hanyadik][d]);
			    					Label_Columns[hanyadik][d].setFont(new Font("Tahoma", Font.BOLD, 18));
			    					Label_Columns[hanyadik][d].setBounds(7, 0+Label_Magassag, 200, 30);
			    					Label_Columns[hanyadik][d].setVisible(true);
			    					
			    					
			    					Panel_tomb[hanyadik].add(Label_Rendeles_Adatok[hanyadik][d]);
			    					Label_Rendeles_Adatok[hanyadik][d].setFont(new Font("Tahoma", Font.BOLD, 18));
			    					Label_Rendeles_Adatok[hanyadik][d].setBounds(300, 0+Label_Magassag, 200, 30);
			    					Label_Rendeles_Adatok[hanyadik][d].setVisible(true);
			    					//System.err.println(Label_Rendeles_Adatok[hanyadik][d].getText());

			    					Label_Magassag=Label_Magassag+45;
			    					
			    					
			    							    					
			    				}
			    				
							} catch (Exception e2) {
								e2.printStackTrace();
							}
		                    Rendelesi_Kep_Frissit();
		            }
		            
		            
				}
			});
			
		                                          

			
			Label_tomb_X[i].addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent e) {
					//System.out.println("Megnyomtad az X-et: "+Integer.toString(hanyadik));
						Rendeles_panel.setComponentZOrder(Panel_tomb[hanyadik], 1);
						Panel_tomb[hanyadik].setBounds(Doboz_X,Doboz_Y, Doboz_Szeles, Doboz_Magas);
						//Kitöltés vissza állítása kis méretre
						Label_Kovetes_tomb[hanyadik].setBounds(Panel_tomb[hanyadik].getWidth()/2, 50, 60, 30);
	                    Label_tomb_X[hanyadik].setVisible(false);
	                    Label_Magassag=0;
	                    System.out.println("\nPanelek feltoltese sql adattal");
                    	kivalasztott_panel=hanyadik;
                    	Adatbazis.Adat_Frissit_Egy();
	    				for(int d=1;d<Osszes_Colum;d++) {
	    					
	    					Panel_tomb[hanyadik].add(Label_Columns[hanyadik][d]);
	    					Label_Columns[hanyadik][d].setFont(new Font("Tahoma", Font.BOLD, 18));
	    					Label_Columns[hanyadik][d].setBounds(7, 0+Label_Magassag, 200, 30);
	    					
	    					Panel_tomb[hanyadik].add(Label_Rendeles_Adatok[hanyadik][d]);
	    					Label_Rendeles_Adatok[hanyadik][d].setFont(new Font("Tahoma", Font.BOLD, 15));
	    					Label_Rendeles_Adatok[hanyadik][d].setBounds(7, 20+Label_Magassag, 200, 30);
	    					
	    					if(d==2|d==3|d==6|d==7|d==8|d==9|d==11) {
	    						//System.err.println("D vizsgalata: "+d);
	    						Label_Columns[hanyadik][d].setVisible(false);
	    						Label_Rendeles_Adatok[hanyadik][d].setVisible(false);
	    						// Labelek állítása darbszámhoz hozva
	    						Label_Magassag=Label_Magassag-50;	
	    					}
	    					if(d==1|d==4|d==5|d==10) {
	    						Label_Columns[hanyadik][d].setBounds(7, 0+Label_Magassag, 200, 30);						
	    					}
	    					Label_Magassag=Label_Magassag+50;
	    				}
	    				Visszanyil_nyomhato=true;
	    				Tovabbnyil_nyomhato=true;
	    				

	                    
	                    
	               	   Doboz_X=150;
	            	   Doboz_Y=30;
					
	            	   Rendelesi_Kep_Frissit();
					
				}
			});
			
			//System.out.println("Doboz_X = "+Doboz_X+" Doboz_Y = "+Doboz_Y);
			
			//Ennyivel növeli az eltolást minden for ciklus kezdésnél
			Doboz_X=Doboz_X+270;
			if(i%4==0) {
				//System.out.println("Az i elerte a 4-et ezert vissza all alapra a Doboz_X es Y");
				Doboz_X=150;
				Doboz_Y=Doboz_Y+240;
			}
			if(i%8==0) {
				
				Doboz_X=150;
				Doboz_Y=30;
				//System.out.println("Doboz_X = "+Doboz_X+" Doboz_Y = "+Doboz_Y);
			}
			//A 8 feletti panelokat láthatatlanná teszi első nyitáskor
			if(i>8) {
				Panel_tomb[i].setVisible(false);
			}
			//Eddig tart
			
			Rendeles_panel.add(Panel_tomb[i]);
			i++;
			
			
		}
		System.out.println("Rendelési dobozok létrehozása");
		//System.out.println("Sql frissites false tehat kovetkezonek frissiteni fog ellenorzes = "+sql_frissitve);
		sql_frissitve=false;
		
		Tovabb_Nyil.setFont(new Font("Tahoma", Font.BOLD, 15));
		Tovabb_Nyil.setForeground(Color.red);
		Tovabb_Nyil.setBounds(Rendeles_panel.getWidth()/2+50, Rendeles_panel.getHeight()-40, 60, 35);
		Tovabb_Nyil.setVisible(false);
		Rendeles_panel.add(Tovabb_Nyil);
		if(Jelenlegi_Oldal==0&Rendelesek>8) {
			Tovabb_Nyil.setVisible(true);	
		}
		
		if((Panel_tomb.length-1)!=0) {
			System.err.println(Panel_tomb.length);
			if(Panel_tomb[1].isVisible()) {
				//System.out.println("Visszanyil nem lathato, mert az 1-es rendeles lathato");
				Vissza_Nyil.setVisible(false);
				Rendelesi_Kep_Frissit();
			}
		}else{
			Vissza_Nyil.setVisible(false);
		}

		
		Tovabb_Nyil.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				//System.err.println("Tovabbgomb nyomas eszlelve: "+Tovabbnyil_nyomhato);
				if(Tovabbnyil_nyomhato) {

					
				
				
				

				if(Rendelesi_Oldalak>0&Jelenlegi_Oldal<Rendelesi_Oldalak) {
					Maradok_Szamolva=false;

					Jelenlegi_Oldal++;		
					//System.out.println("\nJelenelgi oldal nott");
					//System.out.println("\nJelenlegi oldal = "+(Jelenlegi_Oldal)+" Rendelsi oldalak = "+Rendelesi_Oldalak);
					
					for(int i =1;i<=8;i++) {						
						if(Jelenlegi_Oldal>0&Jelenlegi_Oldal<=Rendelesi_Oldalak) {
							Panel_tomb[(Jelenlegi_Oldal-1)*8+i].setVisible(false);
						}						
						
						if(!Maradok_Szamolva&Jelenlegi_Oldal!=Rendelesi_Oldalak) {
							
						Panel_tomb[Jelenlegi_Oldal*8+i].setVisible(true);
							if(Rendelesek%8!=0&Fennmarado_Rendelesek!=i) {
								Panel_tomb[Jelenlegi_Oldal*8+i].setVisible(true);
							}
						}
						//Eddig, mert valszeg rossz helyen van a programrész
					}	
					
					//Itt úszik el a program tovább lépése, viszont ha kiveszem akkor nem tölri az utolsó képet ha 1-el visszábról nyitom meg
					if(Jelenlegi_Oldal==Rendelesi_Oldalak&Rendelesek%8!=0) {
						//System.out.println("\nNem oszthato 8-al betoltve");
						
						for(int a =1;a<=Fennmarado_Rendelesek;a++) {
							Panel_tomb[(Rendelesek/8)*8+a].setVisible(true);
						}
						Tovabb_Nyil.setVisible(false);
						//Maradok_Szamolva=true;
					}
					

					if(!Panel_tomb[1].isVisible()){
						Vissza_Nyil.setVisible(true);
					}
					
					if(Panel_tomb[Rendelesek].isVisible()){
						Tovabb_Nyil.setVisible(false);
					}
					
					if(Jelenlegi_Oldal==0&Rendelesek>8) {
						Tovabb_Nyil.setVisible(true);	
					}

				}				
				Rendelesi_Kep_Frissit();
				//System.err.println("arrayLista frissites elott: "+arrayList);
				Array_Frissites();
				//System.err.println("arrayLista frissites utan: "+arrayList);
				//System.out.println("\n------------------------------------------------------------------------");
			}
			}
		
		});
		
		Vissza_Nyil.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				//System.out.println("\n****************************************************************************");
				if(Visszanyil_nyomhato) {
					
					
				
				if(Rendelesi_Oldalak>0&Jelenlegi_Oldal!=0) {
					Jelenlegi_Oldal--;
					if(Jelenlegi_Oldal<Rendelesi_Oldalak) {
						Tovabb_Nyil.setVisible(true);
					}
					

				}
				for(int i =1;i<=8;i++) {
					if(Jelenlegi_Oldal>0) {
						
						Panel_tomb[(Jelenlegi_Oldal-1)*8+i].setVisible(false);
					}
					if(Jelenlegi_Oldal<Rendelesi_Oldalak-1) {
						Panel_tomb[(Jelenlegi_Oldal+1)*8+i].setVisible(false);
					}
					if(Jelenlegi_Oldal==Rendelesi_Oldalak) {
						if(i!=Fennmarado_Rendelesek) {
							Panel_tomb[(Jelenlegi_Oldal)*8+i].setVisible(false);
						}
						
					}
					
					if(Jelenlegi_Oldal==Rendelesi_Oldalak-1&Rendelesek%8!=0) {
						
						//System.err.println("\n\tRendeles feletti ertek kezelese");
						for(int a =1;a<=Fennmarado_Rendelesek;a++) {
					
							Panel_tomb[(Rendelesek/8)*8+a].setVisible(false);
						}
						
						Maradok_Szamolva=false;
					}

					
					Panel_tomb[Jelenlegi_Oldal*8+i].setVisible(true);
					Rendeles_panel.setComponentZOrder(Panel_tomb[Jelenlegi_Oldal*8+i], 0);
	
				}

				
				//System.out.println("Jelenlegi oldal vissza lepett = "+Jelenlegi_Oldal);
				
				if(Panel_tomb[1].isVisible()){
					//System.out.println("\nVisszanyil nem lathato, mert az 1-es rendeles lathato");
					Vissza_Nyil.setVisible(false);
					Jelenlegi_Oldal=0;
				
				}

				Rendelesi_Kep_Frissit();
				//System.err.println("arrayLista frissites elott: "+arrayList);
				Array_Frissites();
				//System.err.println("arrayLista frissites utan: "+arrayList);
			}
			}
			
		});
		
		Vissza_Nyil.setFont(new Font("Tahoma", Font.BOLD, 15));
		Vissza_Nyil.setForeground(Color.red);
		Vissza_Nyil.setBounds(Rendeles_panel.getWidth()/2-50, Rendeles_panel.getHeight()-40, 50, 35);
		Rendeles_panel.add(Vissza_Nyil);
		

		
		
		betoltve=true;
		}

		
	}
	static void Rendelesi_Kep_Frissit() {
		//System.out.println("Rendelsi panel frissitve");
		Hatterkep_Keret.setVisible(false);
		Hatterkep_Keret.setVisible(true);
		Rendeles_panel.setVisible(false);
		Rendeles_panel.setVisible(true);
	
	}
	
	static void Rendelesek_szinkronizalasa() {
		// boolean: Adatbazis_Frissites_Mp_Mehet
		timer.cancel();
		timer = new Timer();
		
		//System.out.println("ArrayList frissitese");
		Array_Frissites();

    	
    		
    		if(Frissites_ujratolt) {
    			Frissites_ujratolt=false;
    		try {
    			timer.scheduleAtFixedRate(new TimerTask() {
					
					@Override
					public void run() {
						if(Adatbazis_Frissites_Mp_Mehet) {
							System.out.println("Adatok frissitve: "+LocalTime.now().getHour()+":"+LocalTime.now().getMinute()+":"+LocalTime.now().getSecond());
							//System.out.println("Sql frissites mp-re fut "+LocalDateTime.now().getHour()+":"+LocalDateTime.now().getMinute()+":"+LocalDateTime.now().getSecond());
							//System.out.println(arrayList);
							
							//Ha nem egyezik az lekért mennyiség akkor lekéri az adatokat és frissítni a paneleket
							Sgl_Darab_Valtozas_Figyeles();
							
							
							for(int i =0;i<arrayList.size();i++) {
								kivalasztott_panel=arrayList.get(i);
								Adatbazis.Adat_Frissit_Egy();
								
							}
							
						}else {
							System.err.println("Frissites megallitas, mert Frissites_ujratolt = "+Frissites_ujratolt);
							timer.cancel();
						
						
					}
						Rendelesi_Kep_Frissit();
						}
				}, 0,Sql_frissites_ido );
				
			
				
				
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		
    		
    	}
    	
    	
    	//System.out.println("Lista elemei: "+arrayList);
    	
    	
    	
	}

	static void Array_Frissites() {
		//System.out.println("ArrayList frissitese");
		if(arrayList.size()>0) {
			arrayList.removeAll(arrayList);
		}
    	for(int i =1;i<Panel_tomb.length;i++) {
    		if(Panel_tomb[i].isVisible()) {
    			arrayList.add(i);
    		}
    			
    	}
	}
	static void Sgl_Darab_Valtozas_Figyeles() {
		//System.out.println("Panel darab frissites szamitas");
		Adatbazis.Rendeles_darab_Kulonbseg();
		//System.out.println("Bejott kulonbeseg = "+Rendelesek_Adatbazis+" kulonbozeti szamolt: "+Menu.Rendelesek_Adatbazis_Kulonbseg);
		//System.err.println("\t\t\t\tFrissites_Utani_Eslo_Toltes: "+Frissites_Utani_Eslo_Toltes);
		//System.out.println("Panel tomb merete: "+Panel_tomb.length);
		if(Menu.Rendelesek_Adatbazis!=Menu.Rendelesek_Adatbazis_Kulonbseg) {
			Frissites_Utani_Eslo_Toltes=true;
			//System.err.println("\t\t\t\tFrissites_Utani_Eslo_Toltes True: "+Frissites_Utani_Eslo_Toltes);

			//Számos adatok újra megadása

			
			for(int i =1;i<Panel_tomb.length;i++) {
				Panel_tomb[i].setVisible(false);
			}
			Tovabb_Nyil.setVisible(false);
			Vissza_Nyil.setVisible(false);
			

			
			Rendelesi_Kep_Frissit();
			try {

				Adatbazis.Column_megadva=false;
				Adatbazis.Panel_Darab=1;
				Adatbazis.Rendeles_darab();
				Rendelesek=Menu.Rendelesek_Adatbazis;
				
				Rendelesek=Menu.Rendelesek_Adatbazis;
				Rendelesi_Oldalak=(Rendelesek/8);
				Rendelesi_Oldalak_Seged=Rendelesi_Oldalak;
				Jelenlegi_Oldal=0;
				Jelenlegi_Oldal_Seged=0;
				Fennmarado_Rendelesek=(Rendelesek%8);
				
				 Doboz_Magas=200;
				 Doboz_Szeles=250;
				 Doboz_X=150;
				 Doboz_Y=30;
				 
				 Label_Magassag=0;
				 Osszes_Colum=0;
				 Osszes_Colum_Hasnolit=0;
				
				
				 Panel_tomb = new JPanel[Rendelesek+1];
				 Label_tomb_X = new JLabel[Rendelesek+1];
				 Label_Kovetes_tomb = new JLabel[Rendelesek+1];
				 Label_Rendeles_Adatok = new JLabel[Rendelesek+1][40];
				 Label_Columns= new JLabel[Rendelesek+1][40];
				System.out.println("\t\t Panelek teljesen ujra toltese az adatbazis alapjan");
				
				betoltve=false;
				
				Rendeles_Doboz();
				Tovabbnyil_nyomhato=true;
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		
		
	}
	
	
}
