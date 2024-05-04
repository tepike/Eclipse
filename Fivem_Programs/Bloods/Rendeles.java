package Bloods;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Iterator;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class Rendeles extends Menu {
	 static JPanel Rendeles_panel= new JPanel();
	 static int Rendelesek=8;
	 static int Doboz_Magas=200;
	 static int Doboz_Szeles=250;
	 static int Doboz_X=150;
	 static int Doboz_Y=30;
	 static boolean betoltve=false;
	 
	static JPanel[] Panel_tomb = new JPanel[Rendelesek+1];
	static JLabel[] Label_tomb = new JLabel[Rendelesek+1];
	
	
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
			
		
		System.out.println("Rendelési dobozok létrehozása");
		for(int i =1;i<=Rendelesek;) {
			final int hanyadik=i;

			System.out.println(i);
			
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
		                    
		                    Label_tomb[hanyadik].setVisible(true);
		                  

		                    Rendelesi_Kep_Frissit();
		                   // System.out.println("Megnyomtad duplán a panel: "+Integer.toString(hanyadik));
		                    
		                    int Felso_Panel=keret.getLayeredPane().getPosition(Panel_tomb[hanyadik]);
		                    System.out.println(Felso_Panel);
		                    System.out.println("Megnyomtad duplán a panel: "+Integer.toString(hanyadik));
		                    

		            }
		           
				}
			});
			
		                                          

			
			Label_tomb[i].addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent e) {
					System.out.println("Megnyomtad az X-et: "+Integer.toString(hanyadik));
						Rendeles_panel.setComponentZOrder(Panel_tomb[hanyadik], 1);
					
						Panel_tomb[hanyadik].setBounds(Doboz_X,Doboz_Y, Doboz_Szeles, Doboz_Magas);

	                    Label_tomb[hanyadik].setVisible(false);
	                    Rendelesi_Kep_Frissit();
	               	   Doboz_X=150;
	            	   Doboz_Y=30;
					

					
				}
			});
			
			System.out.println("Doboz_X = "+Doboz_X+" Doboz_Y = "+Doboz_Y);
			Doboz_X=Doboz_X+270;
			if(i==4) {
				Doboz_X=150;
				Doboz_Y=Doboz_Y+240;
			}
			
			if(i==8) {
				System.out.println("Az i elerte a 4-et ezert vissza all alapra a Doboz_X es Y");
				Doboz_X=150;
				Doboz_Y=150;
				System.out.println("Doboz_X = "+Doboz_X+" Doboz_Y = "+Doboz_Y);
			}
			if(i>8) {
				Panel_tomb[i].setVisible(false);
			}
			Rendeles_panel.add(Panel_tomb[i]);
			i++;
			
			
		}
		betoltve=true;
		}
		if (betoltve) {
			System.out.println("Nem tolti ujra a panelekt, mert mar egyszer betoltotte, viszont ha plusz adat jon nem kezeli");
		}
		
	}
	static void Rendelesi_Kep_Frissit() {
		System.out.println("Rendelsi panel frissitve");
		Hatterkep_Keret.setVisible(false);
		Hatterkep_Keret.setVisible(true);
		Rendeles_panel.setVisible(false);
		Rendeles_panel.setVisible(true);
	
	}

}
