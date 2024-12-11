package Cluedo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
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
	static JLabel Jatek_Hatterkep= new JLabel();
	
	static JButton Start_Gomb = new JButton("Start");


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
	 
 }
 static void Jatekkepernyo() {
	 Fokepernyo.setLayout(new FlowLayout());
	 Fokepernyo.add(Jatek_Hatterkep);
	 Jatek_Hatterkep.setBounds(keret.getWidth()/2,0,600,600);
	 Jatek_Hatterkep.setIcon(new ImageIcon(Alapkep.class.getResource("/Cluedo/Terkep.jpg")));
	 Fo_Hatterkep.setVisible(false);
	 Jatek_Hatterkep.setVisible(true);
	 keret.repaint();
	 
	 
 }



}