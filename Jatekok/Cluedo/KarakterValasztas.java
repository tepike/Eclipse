package Cluedo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.event.MouseInputListener;
import javax.swing.text.StyleConstants;

public class KarakterValasztas extends Alapkep{
	static boolean Jatekos_Felveheto=true;
		static int Jatekosok_szama=1;
		static int Utolso_Jatekos=0;
		static int Utolso_Magassag;
		static JPanel Karakterek= new JPanel();
		static JLabel Karakter_Valaszto_Hatter = new JLabel();
		static JPanel Jatekos_Nevek= new JPanel();
		static JButton Inditas= new JButton("Indítás");
		static JLabel Felirat1=new JLabel("Játékosok felvétele");
		static JLabel [] Sorszam = new JLabel [Jatekosok_szama];
		static JTextField[] Jatekos_nev_megadas = new JTextField[Jatekosok_szama];
		static JButton Uj_Jatekos_Hozzaad= new JButton("Új játkos felvétel");
		static JLabel [] Karakter_Valasztas= new JLabel[Jatekosok_szama];
		
	
	public static void Karakter_Valaszto() {
		System.out.println("Karakter valasztas betoltese");
		// Karakter_Valaszto_Hatter -- ide kell hozzá adni mindent ami a képen kell ,hogy megjelenjen.
		
		//Alap hatterkep letrehozasa
		Fokepernyo.add(Karakter_Valaszto_Hatter);
		
		 ImageIcon imageIcon = new ImageIcon(Alapkep.class.getResource("/Cluedo/Kepek/Karakter_Valaszto.jpg")); // load the image to a imageIcon
		 Image image = imageIcon.getImage(); // transform it 
		 Image newimg = image.getScaledInstance(1920, 1080,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		 imageIcon = new ImageIcon(newimg);  // transform it back
		
		Karakter_Valaszto_Hatter.setBounds(0, 0, 1920, 1080);
		Karakter_Valaszto_Hatter.setLayout(null);
		Karakter_Valaszto_Hatter.setIcon(imageIcon);
		Fo_Hatterkep.setVisible(false);
		
		//Jatekos letrehozo panel letrehozasa
		Karakter_Valaszto_Hatter.add(Jatekos_Nevek);
		Jatekos_Nevek.setBounds(50, 100, 500, 700);
		Jatekos_Nevek.setBackground(new Color(0,0,0,150));
		Jatekos_Nevek.setLayout(null);
		
		//Indítási gomb létrehozása
		Karakter_Valaszto_Hatter.add(Inditas);
		Inditas.setBounds(keret.getWidth()-150, keret.getHeight()-100, 100, 40);
		Inditas.setBackground(new Color(0,255,0,150));
		Inditas.addMouseListener(new MouseInputListener() {
			
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
				System.out.println("Inditas gomb megnyomva");
				Karakter_Valaszto_Hatter.setVisible(false);
				Jatekkepernyo();
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				Karakter_Valaszto_Hatter.repaint();
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				Karakter_Valaszto_Hatter.repaint();
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		//Jatekos panel felirat letrehozasa
		Jatekos_Nevek.add(Felirat1);
		Felirat1.setBounds(Jatekos_Nevek.getWidth()/2-(Felirat1.getText().length()*12/2), 30, Felirat1.getText().length()*12, 40);
		Felirat1.setFont(new Font("Arial", 1, 24));
		Felirat1.setForeground(Color.white);
			//Felirat méretének ellenőrzése
				//Felirat1.setBorder(BorderFactory.createLineBorder(Color.RED, 3));
		
		//Jatekos panel felvételi mezők megalkotása
		Sorszam[0] = new JLabel();
		Jatekos_Nevek.add(Sorszam[0]);
		Sorszam[0].setText("1. Játekos:");
		Sorszam[0].setBounds(30, 100, Sorszam[0].getText().length()*11, 40);
		Sorszam[0].setFont(new Font("Arial", 1, 20));
		Sorszam[0].setForeground(Color.white);
			//Sorszam[0].setBorder(BorderFactory.createLineBorder(Color.RED, 3));
		
		Jatekos_nev_megadas[0] = new JTextField();
		Jatekos_Nevek.add(Jatekos_nev_megadas[0]);
		Jatekos_nev_megadas[0].setBounds(150, 100, 200, 40);
		Jatekos_nev_megadas[0].setHorizontalAlignment(JTextField.CENTER);
		Jatekos_nev_megadas[0].setFont(new Font("Arial",1,25));
		
		Karakter_Valasztas[0]= new JLabel();
		Jatekos_Nevek.add(Karakter_Valasztas[0]);
		
		ImageIcon Karakterfej=(new ImageIcon(KarakterValasztas.class.getResource("/Cluedo/Kepek/Karakter.png")));
		Image Bekertkep= Karakterfej.getImage();
		Image Formazott_Kep=Bekertkep.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
		Karakterfej=(new ImageIcon(Formazott_Kep));
		
		Karakter_Valasztas[0].setIcon(Karakterfej);
		Karakter_Valasztas[0].setBounds((int)Jatekos_nev_megadas[0].getLocation().getX()+250, (int)Jatekos_nev_megadas[0].getLocation().getY()-10, 50, 50);
		
		
		Jatekos_Nevek.add(Uj_Jatekos_Hozzaad);
		Uj_Jatekos_Hozzaad.setBounds(Jatekos_Nevek.getWidth()/2-100, Jatekos_nev_megadas[Utolso_Jatekos].getHeight()+120, 200, 30);
		Uj_Jatekos_Hozzaad.setFont(new Font("Arial", 1, 20));
		Uj_Jatekos_Hozzaad.addMouseListener(new MouseInputListener() {
			
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
				if(Jatekos_Felveheto) {
				Utolso_Magassag=(int)Sorszam[Utolso_Jatekos].getLocation().getY();
				Jatekosok_szama++;
				Utolso_Jatekos++;
				
				//Itt kell növelni a lista miatt a méreteket
				Sorszam = new JLabel [Jatekosok_szama];
				Jatekos_nev_megadas = new JTextField[Jatekosok_szama];
				Karakter_Valasztas= new JLabel[Jatekosok_szama];
				
				if(Utolso_Jatekos==8) {
					Jatekos_Felveheto=false;
					Uj_Jatekos_Hozzaad.setVisible(false);
				}
				

				
				System.out.println("Sorszam tomb merete:"+Sorszam.length);
				System.out.println("Nev tomb merete:"+Jatekos_nev_megadas.length);

				System.out.println("Kivalasztott tomb: "+Utolso_Jatekos);
				System.out.println("Maximum jatekosok: "+Jatekosok_szama);
				
				
				Sorszam[Utolso_Jatekos] = new JLabel();
				Jatekos_Nevek.add(Sorszam[Utolso_Jatekos]);
				Sorszam[Utolso_Jatekos].setText(Integer.toString(Utolso_Jatekos+1)+". Játekos:");
				Sorszam[Utolso_Jatekos].setBounds(30, Utolso_Magassag+60, Sorszam[Utolso_Jatekos].getText().length()*11, 40);
				Sorszam[Utolso_Jatekos].setFont(new Font("Arial", 1, 20));
				Sorszam[Utolso_Jatekos].setForeground(Color.white);
					//Sorszam[0].setBorder(BorderFactory.createLineBorder(Color.RED, 3));
				
				Jatekos_nev_megadas[Utolso_Jatekos] = new JTextField();
				Jatekos_Nevek.add(Jatekos_nev_megadas[Utolso_Jatekos]);
				Jatekos_nev_megadas[Utolso_Jatekos].setBounds(150, Utolso_Magassag+60, 200, 40);
				Jatekos_nev_megadas[Utolso_Jatekos].setHorizontalAlignment(JTextField.CENTER);
				Jatekos_nev_megadas[Utolso_Jatekos].setFont(new Font("Arial",1,25));
				
				ImageIcon Karakterfej=(new ImageIcon(KarakterValasztas.class.getResource("/Cluedo/Kepek/Karakter.png")));
				Image Bekertkep= Karakterfej.getImage();
				Image Formazott_Kep=Bekertkep.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
				Karakterfej=(new ImageIcon(Formazott_Kep));
				
				Karakter_Valasztas[Utolso_Jatekos]= new JLabel();
				Jatekos_Nevek.add(Karakter_Valasztas[Utolso_Jatekos]);
				Karakter_Valasztas[Utolso_Jatekos].setIcon(Karakterfej);
				Karakter_Valasztas[Utolso_Jatekos].setBounds((int)Jatekos_nev_megadas[Utolso_Jatekos].getLocation().getX()+250, Utolso_Magassag+50, 40, 50);
				
				
				Uj_Jatekos_Hozzaad.setBounds(Jatekos_Nevek.getWidth()/2-100, Utolso_Magassag+130, 200, 30);
				Fokepernyo.repaint();
				System.err.println("Utolso jatekos:"+Utolso_Jatekos);

				}
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {

				
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
		
		
		
		Karakter_Valaszto_Hatter.setVisible(true);
		
		
		
		
	}

}
