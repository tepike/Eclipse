package Cluedo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.Border;
import javax.swing.event.MouseInputListener;

import Bloods.Keret;

public class Alapkep extends Futtatas {
	static JFrame keret= new JFrame("Cluedo");
	static JPanel Fokepernyo = new JPanel();
	public static int Szeles=1920;
	public static int Magas=1080;
	
	static JLabel Fo_Hatterkep= new JLabel();
	static JLabel Kiadas = new JLabel();
	static int Kiadas_Felirat_Hely_Szeles=Szeles/2-300;
	static int Kiadas_Felirat_Hely_Magas=500;
	
	static JLabel Jatek_Hatterkep= new JLabel();
	static JLabel Jatek_Alap_Hatterkep = new JLabel();
	
	static JButton Start_Gomb = new JButton("Start");
	
	public static boolean Jatek_Betoltve=false;
	
	public static JLabel Kocka_gif= new JLabel();
	public static JLabel Kocka_Dobas= new JLabel();
	public static JPanel Karakter_Jelzo=new JPanel();
	static boolean Kocka_Boolean=false;
	static ImageIcon Nagy_Kocka= new ImageIcon((Alapkep.class.getResource("/Cluedo/Kepek/Kocka.png")));
	static ImageIcon Kicsi_kocka= new ImageIcon((Alapkep.class.getResource("/Cluedo/Kepek/Kocka.png")));
	
	


public static void Betoltes() {
	System.out.println("Keret betoltese");
	keret.setSize(Szeles,Magas);
	keret.setLocationRelativeTo(null);
	keret.setVisible(true);
	keret.setResizable(false);
	keret.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	Fokepernyo();
	
	
}
 static void Fokepernyo() {
	 keret.add(Fokepernyo);
	 Fokepernyo.setLayout(new BorderLayout());
	 Fokepernyo.add(Fo_Hatterkep);
	 Fo_Hatterkep.setBounds(0,0,600,600);
	 Fo_Hatterkep.setIcon(new ImageIcon(Alapkep.class.getResource("/Cluedo/Kepek/Fokepernyo.jpg")));
	 Fo_Hatterkep.setVisible(true);
	 Fo_Hatterkep.add(Start_Gomb);
	 Start_Gomb.setBounds(keret.getWidth()/2-50,keret.getHeight()/4,100,50);
	 Start_Gomb.addMouseListener(new MouseListener() {
		
		@Override
		public void mouseReleased(MouseEvent e) {
			System.out.println("Startgomb megnyomva");
			
			//Ezzel a parancsal indul el a konkrét játék
			//Jatekkepernyo();
			
			KarakterValasztas.Karakter_Valaszto();
		}
		
		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	});
	 Fo_Hatterkep.add(Kiadas);
	 
	 ImageIcon imageIcon = new ImageIcon(Alapkep.class.getResource("/Cluedo/Kepek/Editon_Tr.jpg")); // load the image to a imageIcon
	 Image image = imageIcon.getImage(); // transform it 
	 Image newimg = image.getScaledInstance(600, 350,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
	 imageIcon = new ImageIcon(newimg);  // transform it back
	 
	 Kiadas.setBounds(Kiadas_Felirat_Hely_Szeles,Kiadas_Felirat_Hely_Magas,600,350);
	 Kiadas.setIcon(imageIcon);
	 
 }
 static void Jatekkepernyo() {
	 
		 
	 KarakterValasztas.Karakter_Valaszto_Hatter.setVisible(false);
	 Fokepernyo.setLayout(new GridBagLayout());
	 Jatek_Alap_Hatterkep.setLayout(null);
	 Fokepernyo.add(Jatek_Alap_Hatterkep);
	 Jatek_Alap_Hatterkep.add(Jatek_Hatterkep);
	 Jatek_Hatterkep.add(Kocka_gif);
	 
	 ImageIcon imageIcon = new ImageIcon(Alapkep.class.getResource("/Cluedo/Kepek/Terkep3_TR.png")); // load the image to a imageIcon
	 Image image = imageIcon.getImage(); // transform it 
	 Image newimg = image.getScaledInstance(1350, 1050,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
	 imageIcon = new ImageIcon(newimg);  // transform it back
	 
	 Jatek_Hatterkep.setBounds(keret.getWidth()/2-650,keret.getHeight()/2-545,1350,1050);
	 Jatek_Hatterkep.setIcon(imageIcon);
	 
	 //Jatek_Hatterkep.setBounds(keret.getWidth()/2-480,keret.getHeight()/2-540,950,1012);
	 //Jatek_Hatterkep.setIcon(new ImageIcon(Alapkep.class.getResource("/Cluedo/Terkep2.jpg")));
	 
	 //Kocka gif
	 Kocka_gif.setBounds((int)Jatek_Hatterkep.getSize().getWidth()/2-250, 200, 500, 500);
	 ImageIcon Dobokocka = new ImageIcon(Alapkep.class.getResource("/Cluedo/Kepek/kocka.gif"));
	 Kocka_gif.setIcon(Dobokocka);
	 //Kocka_gif.setBorder(BorderFactory.createLineBorder(Color.red, 2));
	 Kocka_gif.setVisible(false);
	 
	 
	 
	 Fo_Hatterkep.setVisible(false);
	 Jatek_Alap_Hatterkep.setBounds(0,0,600,600);
	 Jatek_Alap_Hatterkep.setIcon(new ImageIcon(Alapkep.class.getResource("/Cluedo/Kepek/Jatek_Alap_Hatter.jpg")));
	 
	 Karakter_Jelzo.setBounds(5, 50, 300, 700);
	 Karakter_Jelzo.setBackground(new Color(0,0,0,200));
	 Karakter_Jelzo.setLayout(null);	 
	 Jatek_Alap_Hatterkep.add(Karakter_Jelzo);
	 
	 
	 Image Kicsi_Kocka_Beker= Kicsi_kocka.getImage();
	 Image Kicsi_Kocka_Beker_Alakit=Kicsi_Kocka_Beker.getScaledInstance(75, 75, java.awt.Image.SCALE_SMOOTH);
	 Kicsi_kocka= new ImageIcon(Kicsi_Kocka_Beker_Alakit);
	 
	 
	 Image Nagy_Kocka_Beker= Nagy_Kocka.getImage();
	 Image Nagy_Kocka_Beker_Alakit=Nagy_Kocka_Beker.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
	 Nagy_Kocka= new ImageIcon(Nagy_Kocka_Beker_Alakit);
	 
	 Kocka_Dobas.setBounds(Szeles-150, Magas-150, 75, 75);
	 Kocka_Dobas.setIcon(Kicsi_kocka);
	 Kocka_Dobas.addMouseListener(new MouseAdapter() {
		 	public void mouseReleased(MouseEvent e) {
		 		Mezok.Kocka_Dobas_Inudl();
		 	}
		 
			public void mouseEntered(MouseEvent e) {
					Kocka_Dobas.setBounds(Szeles-162, Magas-162, 100, 100);
					Kocka_Dobas.setIcon(Nagy_Kocka);
					keret.repaint();
				}
				
				public void mouseExited(MouseEvent e) {
					Kocka_Dobas.setBounds(Szeles-150, Magas-150, 75, 75);
					Kocka_Dobas.setIcon(Kicsi_kocka);
					keret.repaint();
					}
	});
	 
	 Kivalasztott_Karakterek.Action_Text.setBounds(Szeles-265, 10, 230, 500);
	 Kivalasztott_Karakterek.Action_Text.setBackground(new Color(0,0,0,200));
	 Kivalasztott_Karakterek.Action_Text.setLayout(null);

	 Jatek_Alap_Hatterkep.add(Kivalasztott_Karakterek.Action_Text);
	 Jatek_Alap_Hatterkep.add(Kocka_Dobas);
	 
	 
	 Jatek_Hatterkep.setVisible(true);
	 keret.repaint();
	 
	 Mezok.Mezo_Betoltes();
	 Mezok.Mezo_eger();
	 
	 try {
		 Kivalasztott_Karakterek.Jatek_Kezdodik();
	} catch (Exception e) {
		// TODO: handle exception
	}
	 
	 Kivalasztott_Karakterek.Karakter_Felvelte_Jatekkepbe();
	 }

	 
	 
 }



