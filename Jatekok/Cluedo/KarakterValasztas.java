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
import java.util.ArrayList;

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
		static JLabel Karakter_Valaszt_Most= new JLabel("Karaktert választ: (Jelölésre vár)");
		static JPanel Karakter_Valasztas_Panel= new JPanel();
		
		//static JLabel [] Sorszam = new JLabel [Jatekosok_szama];
		//static JTextField[] Jatekos_nev_megadas = new JTextField[Jatekosok_szama];
		//static JLabel [] Karakter_Valasztas= new JLabel[Jatekosok_szama];
		static ArrayList<JLabel> Sorszam=new ArrayList<JLabel>();
		static ArrayList<JTextField> Jatekos_nev_megadas = new ArrayList<>();
		static ArrayList<JLabel> Karakter_Valasztas = new ArrayList<>();

		
		static JButton Uj_Jatekos_Hozzaad= new JButton("Új játkos felvétel");
		
		static boolean Karakter_Valasztas_Aktiv=false;
		static String Karakter_Valasztas_Nev;
		
	
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
		
		JLabel Sorszam1 = new JLabel();
		Sorszam.add(Sorszam1);
		Jatekos_Nevek.add(Sorszam1);
		Sorszam1.setText("1. Játekos:");
		Sorszam1.setBounds(30, 100, Sorszam1.getText().length()*11, 40);
		Sorszam1.setFont(new Font("Arial", 1, 20));
		Sorszam1.setForeground(Color.white);
			//Sorszam[0].setBorder(BorderFactory.createLineBorder(Color.RED, 3));
		
		
		
		JTextField Jatekos_nev_megadas1 = new JTextField();
		Jatekos_nev_megadas.add(Jatekos_nev_megadas1);
		Jatekos_Nevek.add(Jatekos_nev_megadas1);
		Jatekos_nev_megadas1.setBounds(150, 100, 200, 40);
		Jatekos_nev_megadas1.setHorizontalAlignment(JTextField.CENTER);
		Jatekos_nev_megadas1.setFont(new Font("Arial",1,25));
		
		JLabel Karakter_Valasztas1= new JLabel();
		Karakter_Valasztas.add(Karakter_Valasztas1);
		Jatekos_Nevek.add(Karakter_Valasztas1);
		
		ImageIcon Karakterfej=(new ImageIcon(KarakterValasztas.class.getResource("/Cluedo/Kepek/Karakter.png")));
		Image Bekertkep= Karakterfej.getImage();
		Image Formazott_Kep=Bekertkep.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
		Karakterfej=(new ImageIcon(Formazott_Kep));
		
		Karakter_Valasztas1.setIcon(Karakterfej);
		Karakter_Valasztas1.setBounds(400, (int)Jatekos_nev_megadas1.getLocation().getY()-10, 50, 50);
		
		Karakter_Valasztas1.addMouseListener(new MouseInputListener() {
			
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
				Karakter_Valasztas_Aktiv=true;
				try {				Karakter_Valasztas_Nev=Jatekos_nev_megadas1.getText();
				System.err.println("Karaktert valaszt: "+Karakter_Valasztas_Nev);
				if(Karakter_Valasztas_Nev.length()>0) {
				Karakter_Valaszt_Most.setText("Karaktert választ: "+Karakter_Valasztas_Nev);
				Karakter_Valaszto_Hatter.repaint();
				}
					
				} catch (Exception e2) {
					// TODO: handle exception
				}

				
				
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
		
		
		Jatekos_Nevek.add(Uj_Jatekos_Hozzaad);
		Uj_Jatekos_Hozzaad.setBounds(Jatekos_Nevek.getWidth()/2-100, Jatekos_nev_megadas.get(0).getHeight()+120, 200, 30);
		Uj_Jatekos_Hozzaad.setFont(new Font("Arial", 1, 20));
		Uj_Jatekos_Hozzaad.addMouseListener(new MouseInputListener() {
		    @Override
		    public void mouseReleased(MouseEvent e) {
		        if (Jatekos_Felveheto) {
		        	
		        	
		        	/*
		JLabel Sorszam1 = new JLabel();
		Sorszam.add(Sorszam1);
		Jatekos_Nevek.add(Sorszam1);
		Sorszam1.setText("1. Játekos:");
		Sorszam1.setBounds(30, 100, Sorszam1.getText().length()*11, 40);
		Sorszam1.setFont(new Font("Arial", 1, 20));
		Sorszam1.setForeground(Color.white);
		        	 * 
		        	 */
		        	
		            JLabel sorszamLabel = new JLabel();
		            JTextField nevTextField = new JTextField();
		            JLabel karakterLabel = new JLabel();
		            
		            // Hozzáadás a listákhoz



		            int yOffset = Sorszam.size() > 0 ? Sorszam.get(Sorszam.size() - 1).getY() + 60 : 100;

		            sorszamLabel.setText((Sorszam.size() + 1) + ". Játékos:");
		            sorszamLabel.setBounds(30, (int)Sorszam.get(Sorszam.size()-1).getLocation().getY()+65, sorszamLabel.getText().length() * 11, 40);
		            sorszamLabel.setFont(new Font("Arial", Font.BOLD, 20));
		            sorszamLabel.setForeground(Color.WHITE);
		            

		            nevTextField.setBounds(150, yOffset, 200, 40);
		            nevTextField.setHorizontalAlignment(JTextField.CENTER);
		            nevTextField.setFont(new Font("Arial", Font.BOLD, 25));

		            ImageIcon karakterIcon = new ImageIcon(KarakterValasztas.class.getResource("/Cluedo/Kepek/Karakter.png"));
		            Image scaledImage = karakterIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		            karakterIcon = new ImageIcon(scaledImage);

		            karakterLabel.setIcon(karakterIcon);
		            karakterLabel.setBounds(400, yOffset, 50, 50);

		            Sorszam.add(sorszamLabel);
		            Jatekos_nev_megadas.add(nevTextField);
		            Karakter_Valasztas.add(karakterLabel);
		            System.err.println("Utolso Sorszamos Label Szoveg ki iratas: "+Sorszam.get(Sorszam.size()-1).getText());
		            //Fejre kattintott gomb cselekvés
		            Karakter_Valasztas.get(Karakter_Valasztas.size()-1).addMouseListener(new MouseInputListener() {
		            	int Hanyadikfej=Karakter_Valasztas.size()-1;
		    			
		    			@Override
		    			public void mouseMoved(MouseEvent e) {
		    				// TODO Auto-generated method stub
		    				
		    			}
		    			
		    			@Override
		    			public void mouseDragged(MouseEvent e) {
		    				System.out.println("Kep huzasa");
		    				
		    			}
		    			
		    			@Override
		    			public void mouseReleased(MouseEvent e) {
		    				Karakter_Valasztas_Aktiv=true;
		    				try {				Karakter_Valasztas_Nev=Jatekos_nev_megadas.get(Hanyadikfej).getText();
		    				System.err.println("Karaktert valaszt: "+Karakter_Valasztas_Nev);
		    				if(Karakter_Valasztas_Nev.length()>0) {
		    				Karakter_Valaszt_Most.setText("Karaktert választ: "+Karakter_Valasztas_Nev);
		    				Karakter_Valaszto_Hatter.repaint();
		    				}
		    				
		    					
		    				} catch (Exception e2) {
		    					// TODO: handle exception
		    				}

		    				
		    				
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
		            
		            
		            // Hozzáadás a panelhez
		            Jatekos_Nevek.add(Sorszam.get(Sorszam.size()-1));
		            Jatekos_Nevek.add(Jatekos_nev_megadas.get(Jatekos_nev_megadas.size()-1));
		            Jatekos_Nevek.add(Karakter_Valasztas.get(Karakter_Valasztas.size()-1));



		            // Ellenőrzés a maximális játékosszám miatt
		            if (Sorszam.size() >= 9) {
		                Jatekos_Felveheto = false;
		                Uj_Jatekos_Hozzaad.setVisible(false);
		            }
		            Uj_Jatekos_Hozzaad.setBounds(Jatekos_Nevek.getWidth()/2-100, (int)Sorszam.get(Sorszam.size()-1).getLocation().getY()+65, 200, 30);
		            Karakter_Valaszto_Hatter.repaint();
		            Jatekos_Nevek.revalidate();
		            Jatekos_Nevek.repaint();
		        }
		    }
		    // A többi MouseInputListener metódus implementációja üres maradhat
		    @Override public void mouseClicked(MouseEvent e) {}
		    @Override public void mouseEntered(MouseEvent e) {}
		    @Override public void mouseExited(MouseEvent e) {}
		    @Override public void mousePressed(MouseEvent e) {}
		    @Override public void mouseMoved(MouseEvent e) {}
		    @Override public void mouseDragged(MouseEvent e) {}
		});
		
		Valaszthato_karakterek();
		
		Karakter_Valaszto_Hatter.setVisible(true);
		
		
		
		
	}
	public static void Valaszthato_karakterek() {
		
		JPanel Karakter_Valasztas_Panel= new JPanel();
		Karakter_Valaszto_Hatter.add(Karakter_Valasztas_Panel);
		Karakter_Valasztas_Panel.setBounds(800, 100, 800, 700);
		Karakter_Valasztas_Panel.setLayout(null);
		Karakter_Valasztas_Panel.setBackground(new Color(0,0,0,150));
		
		Karakter_Valasztas_Panel.add(Karakter_Valaszt_Most);
		Karakter_Valaszt_Most.setBounds(32, 650, 550, 40);
		Karakter_Valaszt_Most.setForeground(Color.white);
		Karakter_Valaszt_Most.setFont(new Font("Arial", 1, 30));
		//Karakter_Valaszt_Most.setBorder(BorderFactory.createLineBorder(Color.red,1));

		JLabel Karakter_1=new JLabel();
		ImageIcon Karakter_1_icon=new ImageIcon(KarakterValasztas.class.getResource("/Cluedo/Kepek/Coln_Mustard.jpg"));
		Image Feldolgozas_1=Karakter_1_icon.getImage();
		Image Karakter_1_Formazas=Feldolgozas_1.getScaledInstance(160, 160, java.awt.Image.SCALE_SMOOTH);
		Karakter_1_icon=new ImageIcon(Karakter_1_Formazas);
		Karakter_1.setIcon(Karakter_1_icon);
		Karakter_1.setBounds(32, 30, 165, 170);
		Karakter_Valasztas_Panel.add(Karakter_1);
		
		JLabel Karakter_2=new JLabel();
		ImageIcon Karakter_2_icon=new ImageIcon(KarakterValasztas.class.getResource("/Cluedo/Kepek/Miss_Scarlet.jpg"));
		Image Feldolgozas_2=Karakter_2_icon.getImage();
		Image Karakter_2_Formazas=Feldolgozas_2.getScaledInstance(160, 160, java.awt.Image.SCALE_SMOOTH);
		Karakter_2_icon=new ImageIcon(Karakter_2_Formazas);
		Karakter_2.setIcon(Karakter_2_icon);
		Karakter_2.setBounds(224, 30, 160, 170);
		Karakter_Valasztas_Panel.add(Karakter_2);
		
		JLabel Karakter_3=new JLabel();
		ImageIcon Karakter_3_icon=new ImageIcon(KarakterValasztas.class.getResource("/Cluedo/Kepek/Mrs_Peacock.jpg"));
		Image Feldolgozas_3=Karakter_3_icon.getImage();
		Image Karakter_3_Formazas=Feldolgozas_3.getScaledInstance(160, 160, java.awt.Image.SCALE_SMOOTH);
		Karakter_3_icon=new ImageIcon(Karakter_3_Formazas);
		Karakter_3.setIcon(Karakter_3_icon);
		Karakter_3.setBounds(416, 30, 160, 170);
		Karakter_Valasztas_Panel.add(Karakter_3);
		
		JLabel Karakter_4=new JLabel();
		ImageIcon Karakter_4_icon=new ImageIcon(KarakterValasztas.class.getResource("/Cluedo/Kepek/Mrs_White.jpg"));
		Image Feldolgozas_4=Karakter_4_icon.getImage();
		Image Karakter_4_Formazas=Feldolgozas_4.getScaledInstance(160, 160, java.awt.Image.SCALE_SMOOTH);
		Karakter_4_icon=new ImageIcon(Karakter_4_Formazas);
		Karakter_4.setIcon(Karakter_4_icon);
		Karakter_4.setBounds(608, 30, 160, 170);
		Karakter_Valasztas_Panel.add(Karakter_4);
		
		JLabel Karakter_5=new JLabel();
		ImageIcon Karakter_5_icon=new ImageIcon(KarakterValasztas.class.getResource("/Cluedo/Kepek/Mr_Green.jpg"));
		Image Feldolgozas_5=Karakter_5_icon.getImage();
		Image Karakter_5_Formazas=Feldolgozas_5.getScaledInstance(160, 160, java.awt.Image.SCALE_SMOOTH);
		Karakter_5_icon=new ImageIcon(Karakter_5_Formazas);
		Karakter_5.setIcon(Karakter_5_icon);
		Karakter_5.setBounds(32, 222, 160, 170);
		Karakter_Valasztas_Panel.add(Karakter_5);
		
		JLabel Karakter_6=new JLabel();
		ImageIcon Karakter_6_icon=new ImageIcon(KarakterValasztas.class.getResource("/Cluedo/Kepek/Porf_Plum.jpg"));
		Image Feldolgozas_6=Karakter_6_icon.getImage();
		Image Karakter_6_Formazas=Feldolgozas_6.getScaledInstance(160, 160, java.awt.Image.SCALE_SMOOTH);
		Karakter_6_icon=new ImageIcon(Karakter_6_Formazas);
		Karakter_6.setIcon(Karakter_6_icon);
		Karakter_6.setBounds(224, 222, 160, 170);
		Karakter_Valasztas_Panel.add(Karakter_6);
		
		
		
	}

}
