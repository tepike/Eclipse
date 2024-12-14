package Cluedo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import Bloods.Keret;

public class Alapkep extends Futtatas {
	static JFrame keret= new JFrame("Cluedo");
	static JPanel Fokepernyo = new JPanel();
	public static int Szeles=(1920);
	public static int Magas=(1080);
	
	static JLabel Fo_Hatterkep= new JLabel();
	static JLabel Kiadas = new JLabel();
	static int Kiadas_Felirat_Hely_Szeles=Szeles/2-300;
	static int Kiadas_Felirat_Hely_Magas=500;
	
	static JLabel Jatek_Hatterkep= new JLabel();
	static JLabel Jatek_Alap_Hatterkep = new JLabel();
	
	static JButton Start_Gomb = new JButton("Start");
	
	public static boolean Jatek_Betoltve=false;


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
	 Fo_Hatterkep.setIcon(new ImageIcon(Alapkep.class.getResource("/Cluedo/Fokepernyo.jpg")));
	 Fo_Hatterkep.setVisible(true);
	 Fo_Hatterkep.add(Start_Gomb);
	 Start_Gomb.setBounds(keret.getWidth()/2-50,keret.getHeight()/4,100,50);
	 Start_Gomb.addMouseListener(new MouseListener() {
		
		@Override
		public void mouseReleased(MouseEvent e) {
			System.out.println("Startgomb megnyomva");
			Jatekkepernyo();
			
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
	 
	 ImageIcon imageIcon = new ImageIcon(Alapkep.class.getResource("/Cluedo/Editon_Tr.jpg")); // load the image to a imageIcon
	 Image image = imageIcon.getImage(); // transform it 
	 Image newimg = image.getScaledInstance(600, 350,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
	 imageIcon = new ImageIcon(newimg);  // transform it back
	 
	 Kiadas.setBounds(Kiadas_Felirat_Hely_Szeles,Kiadas_Felirat_Hely_Magas,600,350);
	 Kiadas.setIcon(imageIcon);
	 
 }
 static void Jatekkepernyo() {
	 Fokepernyo.setLayout(new GridBagLayout());
	 Jatek_Alap_Hatterkep.setLayout(null);
	 Fokepernyo.add(Jatek_Alap_Hatterkep);
	 Jatek_Alap_Hatterkep.add(Jatek_Hatterkep);
	 
	 ImageIcon imageIcon = new ImageIcon(Alapkep.class.getResource("/Cluedo/Terkep3_TR.png")); // load the image to a imageIcon
	 Image image = imageIcon.getImage(); // transform it 
	 Image newimg = image.getScaledInstance(1350, 1050,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
	 imageIcon = new ImageIcon(newimg);  // transform it back
	 
	 Jatek_Hatterkep.setBounds(keret.getWidth()/2-650,keret.getHeight()/2-545,1350,1050);
	 Jatek_Hatterkep.setIcon(imageIcon);
	 
	 //Jatek_Hatterkep.setBounds(keret.getWidth()/2-480,keret.getHeight()/2-540,950,1012);
	 //Jatek_Hatterkep.setIcon(new ImageIcon(Alapkep.class.getResource("/Cluedo/Terkep2.jpg")));
	 
	 
	 Fo_Hatterkep.setVisible(false);
	 Jatek_Alap_Hatterkep.setBounds(0,0,600,600);
	 Jatek_Alap_Hatterkep.setIcon(new ImageIcon(Alapkep.class.getResource("/Cluedo/Jatek_Alap_Hatter.jpg")));
	 
	 Jatek_Hatterkep.setVisible(true);
	 keret.repaint();
	 
	 Mezok.Mezo_Betoltes();
	 Mezok.Mezo_eger();
	 
	 
	 
 }



}