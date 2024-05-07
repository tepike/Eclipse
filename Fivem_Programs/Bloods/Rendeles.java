package Bloods;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Rendeles extends Menu {
	 static JPanel Rendeles_panel= new JPanel();
	 static int Rendelesek=29;
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
	 
	static JPanel[] Panel_tomb = new JPanel[Rendelesek+1];
	static JLabel[] Label_tomb = new JLabel[Rendelesek+1];
	static JLabel[] Label_Kovetes_tomb = new JLabel[Rendelesek+1];
	static JLabel Tovabb_Nyil = new JLabel("Tovább");
	static JLabel Vissza_Nyil = new JLabel("Vissza");
	


	
	public static void Rendeles_lathato()  {
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
		Menu_panel.setVisible(true);
		Menu_Osszesito_panel.setVisible(true);
		Rendeles_panel.setVisible(false);

	}
	
	public static void Rendeles_Doboz() {
		if(!betoltve) {
			

		
		for(int i =1;i<=Rendelesek;) {
			final int hanyadik=i;

			//System.out.println(i);
			
			Panel_tomb[i]=new JPanel();
			Panel_tomb[i].setBounds(Doboz_X, Doboz_Y, Doboz_Szeles, Doboz_Magas);
			Panel_tomb[i].setBackground(Color.white);
			Panel_tomb[i].setBorder(BorderFactory.createLineBorder(Color.gray,4));
			Panel_tomb[i].setLayout(null);
			
			Label_tomb[i]=new JLabel("X");
			Label_tomb[i].setFont(new Font("Tahoma", Font.BOLD, 28));
			Label_tomb[i].setForeground(Color.red);
			Label_tomb[i].setVisible(false);
			Panel_tomb[i].add(Label_tomb[i]);
			
			Label_Kovetes_tomb[i]=new JLabel(Integer.toString(hanyadik));
			Label_Kovetes_tomb[i].setFont(new Font("Tahoma", Font.BOLD, 28));
			Label_Kovetes_tomb[i].setForeground(Color.red);
			Label_Kovetes_tomb[i].setVisible(true);
			Label_Kovetes_tomb[hanyadik].setBounds(Panel_tomb[hanyadik].getWidth()/2, 50, 60, 30);
			Panel_tomb[i].add(Label_Kovetes_tomb[i]);
			
			
			Panel_tomb[i].addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent e) {
		            if (e.getClickCount() == 2 && !e.isConsumed()) {
		                    e.consume();
		                    Doboz_X=((int)Panel_tomb[hanyadik].getLocation().getX());
		                    Doboz_Y=((int)Panel_tomb[hanyadik].getLocation().getY());
		                    Rendeles_panel.setComponentZOrder(Panel_tomb[hanyadik], 0);
		                 
		                    
		                    Panel_tomb[hanyadik].setBounds((int)Rendeles_panel.getWidth()/2-(Doboz_Szeles), (int)Rendeles_panel.getHeight()/2-(Doboz_Magas+75), Doboz_Szeles+350, Doboz_Magas+300);
		              
		                    Panel_tomb[hanyadik].repaint();
		                    Label_tomb[hanyadik].setBounds(Panel_tomb[hanyadik].getWidth()-30, 5, 30, 30);
		                    Label_Kovetes_tomb[hanyadik].setBounds(Panel_tomb[hanyadik].getWidth()/2, 50, 60, 30);
		                    Label_tomb[hanyadik].setVisible(true);
		                  

		                    
		                   // System.out.println("Megnyomtad duplán a panel: "+Integer.toString(hanyadik));
		            
		                    //System.out.println("Megnyomtad duplán a panel: "+Integer.toString(hanyadik));
		                    

		            }
		            Rendelesi_Kep_Frissit();
				}
			});
			
		                                          

			
			Label_tomb[i].addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent e) {
					//System.out.println("Megnyomtad az X-et: "+Integer.toString(hanyadik));
						Rendeles_panel.setComponentZOrder(Panel_tomb[hanyadik], 1);
					
						Panel_tomb[hanyadik].setBounds(Doboz_X,Doboz_Y, Doboz_Szeles, Doboz_Magas);
						Label_Kovetes_tomb[hanyadik].setBounds(Panel_tomb[hanyadik].getWidth()/2, 50, 60, 30);

	                    Label_tomb[hanyadik].setVisible(false);

	                    
	                    
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
		
		Tovabb_Nyil.setFont(new Font("Tahoma", Font.BOLD, 15));
		Tovabb_Nyil.setForeground(Color.red);
		Tovabb_Nyil.setBounds(Rendeles_panel.getWidth()/2+50, Rendeles_panel.getHeight()-40, 60, 35);
		Rendeles_panel.add(Tovabb_Nyil);
		
		if(Panel_tomb[1].isVisible()) {
			System.out.println("\nVisszanyil nem lathato, mert az 1-es rendeles lathato");
			Vissza_Nyil.setVisible(false);
			Rendelesi_Kep_Frissit();
		}
		
		Tovabb_Nyil.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				System.out.println("\n------------------------------------------------------------------");

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
				//System.out.println("\n------------------------------------------------------------------------");
			}
		
		});
		
		Vissza_Nyil.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				//System.out.println("\n****************************************************************************");
				
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
			}
			
		});
		
		Vissza_Nyil.setFont(new Font("Tahoma", Font.BOLD, 15));
		Vissza_Nyil.setForeground(Color.red);
		Vissza_Nyil.setBounds(Rendeles_panel.getWidth()/2-50, Rendeles_panel.getHeight()-40, 50, 35);
		Rendeles_panel.add(Vissza_Nyil);
		

		
		
		betoltve=true;
		}
		if (betoltve) {
			System.out.println("Nem tolti ujra a panelekt, mert mar egyszer betoltotte, viszont ha plusz adat jon nem kezeli, nincs deklarálva");
		}
		
	}
	static void Rendelesi_Kep_Frissit() {
		System.out.println("\nRendelsi panel frissitve");
		Hatterkep_Keret.setVisible(false);
		Hatterkep_Keret.setVisible(true);
		Rendeles_panel.setVisible(false);
		Rendeles_panel.setVisible(true);
	
	}


}
