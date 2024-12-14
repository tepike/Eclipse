package Cluedo;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.LayoutManager;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;

public class Mezok extends Alapkep{
	static boolean Mezo_Szam_Lathato=false;
	static int Mezo_X;
	static int Mezo_Y;
	static boolean Eger_belepett=false;
	static boolean Eger_kilepett=true;
	static boolean Mezo_Mehet=true;
	static int a=0;
	static int Mezo_Eger=0;
	static JPanel[] Mezok=new JPanel[300];
	static JLabel [] Mezo_Szamok= new JLabel[300];
	static void Mezo_Betoltes() {

		for(int i=0;i<300;i++) {
			System.out.println("Mezo letrehoz: "+i);
			
			Mezok[i]=new JPanel();
			Mezok[i].setLayout(new GridBagLayout());
			Mezo_Szamok[i] =new JLabel(Integer.toString(i+1));
			Mezok[i].add(Mezo_Szamok[i]);
			Jatek_Hatterkep.add(Mezok[i]);
			Mezok[i].setVisible(false);
			Mezo_Szamok[i].setVisible(Mezo_Szam_Lathato);
		}
		
		Mezok[0].setBounds(150, Jatek_Hatterkep.getHeight()/2-100, 45, 45);
		Mezok[0].setBackground(new Color(255,255,255,200));
		Mezok[0].setVisible(true);
		//Elso oszlop letrehozas
		for(int i =1;i<7;i++) {
			if(i==1){
			Mezok[i].setBounds((int)Mezok[0].getLocation().getX()+55, (int)Mezok[0].getLocation().getY(), 45, 45);
			Mezok[i].setBackground(new Color(255,255,255,200));
			Mezok[i].setVisible(true);
		}
			if(i==2) {
				Mezok[i].setBounds((int)Mezok[0].getLocation().getX()+55, (int)Mezok[0].getLocation().getY()-55, 45, 45);
				Mezok[i].setBackground(new Color(255,255,255,200));
				Mezok[i].setVisible(true);
			}
			if(i>2) {
			Mezok[i].setBounds((int)Mezok[0].getLocation().getX()+55, (int)Mezok[i-1].getLocation().getY()+55, 45, 45);
				if(i==3) {
					Mezok[i].setBounds((int)Mezok[0].getLocation().getX()+55, (int)Mezok[i].getLocation().getY()+55, 45, 45);
				}
			Mezok[i].setBackground(new Color(255,255,255,200));
			Mezok[i].setVisible(true);
			}
		}
		
		//Masodik oszlop letrehozas
		for(int i =7;i<13;i++) {
			if(i==7){
			Mezok[i].setBounds((int)Mezok[0].getLocation().getX()+110, (int)Mezok[0].getLocation().getY(), 45, 45);
			Mezok[i].setBackground(new Color(255,255,255,200));
			Mezok[i].setVisible(true);
		}
			if(i==8) {
				Mezok[i].setBounds((int)Mezok[0].getLocation().getX()+110, (int)Mezok[0].getLocation().getY()-55, 45, 45);
				Mezok[i].setBackground(new Color(255,255,255,200));
				Mezok[i].setVisible(true);
			}
			if(i>8) {
			Mezok[i].setBounds((int)Mezok[0].getLocation().getX()+110, (int)Mezok[i-1].getLocation().getY()+55, 45, 45);
				if(i==9) {
					Mezok[i].setBounds((int)Mezok[0].getLocation().getX()+110, (int)Mezok[i].getLocation().getY()+55, 45, 45);
				}
			Mezok[i].setBackground(new Color(255,255,255,200));
			Mezok[i].setVisible(true);
			}
		}
		
		Mezok[14]=new JPanel();
		Mezok[14].setLayout(new GridBagLayout());
		Mezok[14].setBounds((int)Mezok[9].getLocation().getX()+55, (int)Mezok[9].getLocation().getY(), 45, 45);
		Mezo_Szamok[14] =new JLabel("15");
		Mezok[14].add(Mezo_Szamok[14]);
		Mezok[14].setBackground(new Color(255,255,255,200));
		Jatek_Hatterkep.add(Mezok[14]);
		Mezo_Szamok[14].setVisible(Mezo_Szam_Lathato);
		Mezok[14].setVisible(true);
		
		Mezok[15]=new JPanel();
		Mezok[15].setLayout(new GridBagLayout());
		Mezok[15].setBounds((int)Mezok[14].getLocation().getX()+55, (int)Mezok[14].getLocation().getY(), 45, 45);
		Mezo_Szamok[15] =new JLabel("16");
		Mezok[15].add(Mezo_Szamok[15]);
		Mezok[15].setBackground(new Color(255,255,255,200));
		Jatek_Hatterkep.add(Mezok[15]);
		Mezo_Szamok[15].setVisible(Mezo_Szam_Lathato);
		Mezok[15].setVisible(true);
		

		Mezok[16]=new JPanel();
		Mezok[16].setLayout(new GridBagLayout());
		Mezok[16].setBounds((int)Mezok[15].getLocation().getX()+55, (int)Mezok[15].getLocation().getY(), 45, 45);
		Mezo_Szamok[16] =new JLabel("17");
		Mezok[16].add(Mezo_Szamok[16]);
		Mezok[16].setBackground(new Color(255,255,255,200));
		Jatek_Hatterkep.add(Mezok[16]);
		Mezo_Szamok[16].setVisible(Mezo_Szam_Lathato);
		Mezok[16].setVisible(true);
		
		
		//Belépési mezők: 
		
		Mezok[13]=new JPanel();
		Mezok[13].setBounds((int)Mezok[0].getLocation().getX()+110, (int)Mezok[0].getLocation().getY()-110, 45, 45);
		Mezok[13].setLayout(new GridBagLayout());
		Mezo_Szamok[13] =new JLabel("14");
		Mezok[13].add(Mezo_Szamok[13]);
		Jatek_Hatterkep.add(Mezok[13]);
		Mezo_Szamok[13].setVisible(Mezo_Szam_Lathato);
		Mezok[13].setVisible(true);
		Mezok[13].setBackground(new Color(255,255,255,200));
		
		  		
		Mezok[12].setBackground(new Color(255,255,255,200));
		 
		 

		Kozepso_Mezok();
		
		System.out.println("Mezo betoltve");
	}
	static void Kozepso_Mezok() {
		Mezo_eger();
		System.out.println("Belso mezok betoltese");
		for(int i =17;i<38;i++) {
			//Belső tér
			if(i==17){
			Mezok[i].setBounds((int)Mezok[16].getLocation().getX()+55, (int)Mezok[8].getLocation().getY()-55, 45, 45);
			Mezok[i].setBackground(new Color(255,255,255,200));
			Mezok[i].setVisible(true);
			
		}
			if(i>17){
				Mezok[i].setBounds((int)Mezok[17].getLocation().getX(), (int)Mezok[17].getLocation().getY()+a, 45, 45);
				Mezok[i].setBackground(new Color(255,255,255,200));
				Mezok[i].setVisible(true);
			}

			System.out.println(i);
			if(i==24) {
				a=0;
				System.err.println("A reset");
				Mezok[i].setBounds((int)Mezok[16].getLocation().getX()+238, (int)Mezok[17].getLocation().getY()+a, 45, 45);
				Mezok[i].setBackground(new Color(255,255,255,200));
				Mezok[i].setVisible(true);
			}
			if(i>24) {
				Mezok[i].setBounds((int)Mezok[24].getLocation().getX(), (int)Mezok[17].getLocation().getY()+a, 45, 45);
				Mezok[i].setBackground(new Color(255,255,255,200));
				Mezok[i].setVisible(true);
				
			}
			
			if(i==31) {
				a=0;
				System.err.println("A reset");
				Mezok[i].setBounds((int)Mezok[16].getLocation().getX()+470, (int)Mezok[17].getLocation().getY()+a, 45, 45);
				Mezok[i].setBackground(new Color(255,255,255,200));
				Mezok[i].setVisible(true);
			}
			if(i>31) {
				Mezok[i].setBounds((int)Mezok[31].getLocation().getX(), (int)Mezok[17].getLocation().getY()+a, 45, 45);
				Mezok[i].setBackground(new Color(255,255,255,200));
				Mezok[i].setVisible(true);
				
			}
			a=a+55;
			
		}
		a=60;
		
		//Belsőtér vizszintes sor kitoltes
		for(int i= 38;i<53;i++) {
			//felso sor
			Mezok[i].setBounds((int)Mezok[17].getLocation().getX()+a, (int)Mezok[17].getLocation().getY(), 45, 45);
			Mezok[i].setBackground(new Color(255,255,255,200));
			Mezok[i].setVisible(true);
			if(i==40) {
				Mezok[i].setBounds((int)Mezok[17].getLocation().getX()+a+65, (int)Mezok[17].getLocation().getY(), 45, 45);
				Mezok[i].setBackground(new Color(255,255,255,200));
				Mezok[i].setVisible(true);
				a=a+60;
			}
			
			//Kozepso sor
			if(i==42) {
				a=0;
			}
			if(i>42) {
				Mezok[i].setBounds((int)Mezok[20].getLocation().getX()+a, (int)Mezok[20].getLocation().getY(), 45, 45);
				Mezok[i].setBackground(new Color(255,255,255,200));
				Mezok[i].setVisible(true);
			}
			if(i==45) {
				Mezok[i].setBounds((int)Mezok[20].getLocation().getX()+a+65, (int)Mezok[20].getLocation().getY(), 45, 45);
				Mezok[i].setBackground(new Color(255,255,255,200));
				Mezok[i].setVisible(true);
				a=a+60;
			}
			
			//Also sor
			
			if(i==47) {
				a=0;
			}
			if(i>47) {
				Mezok[i].setBounds((int)Mezok[23].getLocation().getX()+a, (int)Mezok[23].getLocation().getY(), 45, 45);
				Mezok[i].setBackground(new Color(255,255,255,200));
				Mezok[i].setVisible(true);
			}
			if(i==50) {
				Mezok[i].setBounds((int)Mezok[23].getLocation().getX()+a+65, (int)Mezok[23].getLocation().getY(), 45, 45);
				Mezok[i].setBackground(new Color(255,255,255,200));
				Mezok[i].setVisible(true);
				a=a+60;
			}
			
			a=a+60;
			
		}
	}
	public static void Mezo_eger() {
		for(int i=0;i<300;i++) {
			 final int Mezo_Eger=i;
		Mezok[i].addMouseListener(new MouseInputListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				if(Eger_belepett&&Eger_kilepett) {
				System.out.println("Eger kilepett");
				Mezok[Mezo_Eger].setSize(45,45);
				Mezok[Mezo_Eger].setLocation(Mezo_X,Mezo_Y);
				Eger_belepett=false;
				Eger_kilepett=true;
				Mezo_Szamok[Mezo_Eger].setHorizontalTextPosition(JLabel.CENTER);
				Mezo_Szamok[Mezo_Eger].setVerticalTextPosition(JLabel.CENTER);
				Mezok[Mezo_Eger].setBorder(BorderFactory.createEmptyBorder());
				}
				
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				if(!Eger_belepett) {
				System.out.println("Eger belepett");
				Mezo_X=((int)Mezok[Mezo_Eger].getLocation().getX());
				Mezo_Y=((int)Mezok[Mezo_Eger].getLocation().getY());
				Mezok[Mezo_Eger].setSize(55,55);
				Mezok[Mezo_Eger].setLocation((int)Mezok[Mezo_Eger].getLocation().getX()-5,(int)Mezok[Mezo_Eger].getLocation().getY()-5);
				Eger_belepett=true;
				Mezok[Mezo_Eger].setBorder(BorderFactory.createLineBorder(Color.RED, 3));
				Mezo_Szamok[Mezo_Eger].setHorizontalTextPosition(JLabel.CENTER);
				Mezo_Szamok[Mezo_Eger].setVerticalTextPosition(JLabel.CENTER);
				}
				
				


				
				
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
		
	}
	
	
}
