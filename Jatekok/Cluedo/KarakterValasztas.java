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
import java.awt.event.MouseAdapter;
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
	public static int Osszesen_Jatszik=0;
	
	static boolean Jatekos_Felveheto=true;
	public static boolean Karakterek_Kivalasztva=false;
	static boolean Karakter_Valasztas_Aktiv=false;
		
		static int Max_Player=6;
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
		
		static ArrayList<JLabel> Sorszam=new ArrayList<JLabel>();
		static ArrayList<JTextField> Jatekos_nev_megadas = new ArrayList<>();
		static ArrayList<JLabel> Karakter_Valasztas = new ArrayList<>();
		public static ArrayList<String> Megadott_Nevek=new ArrayList<String>();

		
		static JButton Uj_Jatekos_Hozzaad= new JButton("Új játkos felvétel");
		static String Karakter_Valasztas_Nev;
		
		static JLabel Karakter_Valasztas1= new JLabel();
		static JLabel Karakter_1=new JLabel();

		
		static JLabel Karakter_2=new JLabel();
		static JLabel Karakter_3=new JLabel();
		static JLabel Karakter_4=new JLabel();
		static JLabel Karakter_5=new JLabel();
		static JLabel Karakter_6=new JLabel();

		
		
		
		static Boolean Char_Valaszt_1=false;
		static Boolean Char_Valaszt_2=false;
		static Boolean Char_Valaszt_3=false;
		static Boolean Char_Valaszt_4=false;
		static Boolean Char_Valaszt_5=false;
		static Boolean Char_Valaszt_6=false;
		
		static int Hanyadikfej2;
		
		
		static boolean Karakter1_Valaszt=false;
		static boolean Karakter2_Valaszt=false;
		static boolean Karakter3_Valaszt=false;
		static boolean Karakter4_Valaszt=false;
		static boolean Karakter5_Valaszt=false;
		static boolean Karakter6_Valaszt=false;
		static boolean Karakter7_Valaszt=false;
		static boolean Karakter8_Valaszt=false;
		static boolean Karakter9_Valaszt=false;
		
		
		
		
	
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
		
		
		Karakter_Valasztas.add(Karakter_Valasztas1);
		Jatekos_Nevek.add(Karakter_Valasztas1);
		
		ImageIcon Karakterfej=(new ImageIcon(KarakterValasztas.class.getResource("/Cluedo/Kepek/Karakter.png")));
		Image Bekertkep= Karakterfej.getImage();
		Image Formazott_Kep=Bekertkep.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
		Karakterfej=(new ImageIcon(Formazott_Kep));
		
		Karakter_Valasztas1.setIcon(Karakterfej);
		Karakter_Valasztas1.setText("1. Karakter");
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
				Megadott_Nevek.add(Karakter_Valasztas_Nev);
				System.err.println(Karakter_Valasztas1.getText());
				Char_Valaszt_1=true;
				Hanyadikfej2=1;
				
				
				System.out.println("Tarolt fej: "+Hanyadikfej2);
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
		            karakterLabel.setText((Sorszam.size() + 1) + ". Karakter");
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
		    				
		    				//Char_Valaszt_1=true;
		    				
		    				
		    				
		    				if(Karakter_Valasztas_Nev.length()>0) {
		    				Karakter_Valaszt_Most.setText("Karaktert választ: "+Karakter_Valasztas_Nev);
		    				Megadott_Nevek.add(Karakter_Valasztas_Nev);
		    				System.err.println(Karakter_Valasztas.get(Hanyadikfej).getText());
		    				Hanyadikfej2=Hanyadikfej+1;
		    				System.out.println("Tarolt fej: "+Hanyadikfej2);
		    				if(Hanyadikfej2==2) {
		    					System.err.println("\tMasodik kar valaszt");
		    					Char_Valaszt_1=false;
		    					Char_Valaszt_2=true;
		    					Char_Valaszt_3=false;
		    					Char_Valaszt_4=false;
		    					Char_Valaszt_5=false;
		    					Char_Valaszt_6=false;
		    				}
		    				if(Hanyadikfej2==3) {
		    					System.err.println("\tHarmadik kar valaszt");
		    					Char_Valaszt_1=false;
		    					Char_Valaszt_2=false;
		    					Char_Valaszt_3=true;
		    					Char_Valaszt_4=false;
		    					Char_Valaszt_5=false;
		    					Char_Valaszt_6=false;
		    				}
		    				
		    				
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
		            if (Sorszam.size() >= Max_Player) {
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

		
		ImageIcon Karakter_1_icon=new ImageIcon(KarakterValasztas.class.getResource("/Cluedo/Kepek/Coln_Mustard.jpg"));
		Image Feldolgozas_1=Karakter_1_icon.getImage();
		Image Karakter_1_Formazas=Feldolgozas_1.getScaledInstance(160, 160, java.awt.Image.SCALE_SMOOTH);
		Karakter_1_icon=new ImageIcon(Karakter_1_Formazas);
		Karakter_1.setIcon(Karakter_1_icon);
		Karakter_1.setBounds(32, 30, 165, 170);
		Karakter_Valasztas_Panel.add(Karakter_1);
		
		Karakter_1.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				System.out.println("Karakter_1");	
				if(Karakter_Valasztas_Aktiv&&Karakter_Valasztas_Nev.length()>0) {
					Karakter1_Valaszt=true;
					Image Karakter_1_Formazas=Feldolgozas_1.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
					ImageIcon Karakter_1_icon=new ImageIcon(Karakter_1_Formazas);
					Karakter_1.setIcon(Karakter_1_icon);
					Karakter_Kep_Athelyez();
				}
			}
		});
		
		
		
		ImageIcon Karakter_2_icon=new ImageIcon(KarakterValasztas.class.getResource("/Cluedo/Kepek/Miss_Scarlet.jpg"));
		Image Feldolgozas_2=Karakter_2_icon.getImage();
		Image Karakter_2_Formazas=Feldolgozas_2.getScaledInstance(160, 160, java.awt.Image.SCALE_SMOOTH);
		Karakter_2_icon=new ImageIcon(Karakter_2_Formazas);
		Karakter_2.setIcon(Karakter_2_icon);
		Karakter_2.setBounds(224, 30, 160, 170);
		Karakter_Valasztas_Panel.add(Karakter_2);
		
		Karakter_2.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				System.out.println("Karakter_2");
				if(Karakter_Valasztas_Aktiv&&Karakter_Valasztas_Nev.length()>0) {
					Karakter2_Valaszt=true;
					Image Karakter_2_Formazas=Feldolgozas_2.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
					ImageIcon Karakter_2_icon=new ImageIcon(Karakter_2_Formazas);
					Karakter_2.setIcon(Karakter_2_icon);
					Karakter_Kep_Athelyez();
					
					
				}
			}
		});
		

		ImageIcon Karakter_3_icon=new ImageIcon(KarakterValasztas.class.getResource("/Cluedo/Kepek/Mrs_Peacock.jpg"));
		Image Feldolgozas_3=Karakter_3_icon.getImage();
		Image Karakter_3_Formazas=Feldolgozas_3.getScaledInstance(160, 160, java.awt.Image.SCALE_SMOOTH);
		Karakter_3_icon=new ImageIcon(Karakter_3_Formazas);
		Karakter_3.setIcon(Karakter_3_icon);
		Karakter_3.setBounds(416, 30, 160, 170);
		Karakter_Valasztas_Panel.add(Karakter_3);
		
		Karakter_3.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				System.out.println("Karakter_3");
				if(Karakter_Valasztas_Aktiv&&Karakter_Valasztas_Nev.length()>0) {
					Karakter3_Valaszt=true;
					Image Karakter_3_Formazas=Feldolgozas_3.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
					ImageIcon Karakter_3_icon=new ImageIcon(Karakter_3_Formazas);
					Karakter_3.setIcon(Karakter_3_icon);
					Karakter_Kep_Athelyez();
					
					
				}
			}
		});
		

		ImageIcon Karakter_4_icon=new ImageIcon(KarakterValasztas.class.getResource("/Cluedo/Kepek/Mrs_White.jpg"));
		Image Feldolgozas_4=Karakter_4_icon.getImage();
		Image Karakter_4_Formazas=Feldolgozas_4.getScaledInstance(160, 160, java.awt.Image.SCALE_SMOOTH);
		Karakter_4_icon=new ImageIcon(Karakter_4_Formazas);
		Karakter_4.setIcon(Karakter_4_icon);
		Karakter_4.setBounds(608, 30, 160, 170);
		Karakter_Valasztas_Panel.add(Karakter_4);
		
		Karakter_4.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				System.out.println("Karakter_4");
				if(Karakter_Valasztas_Aktiv&&Karakter_Valasztas_Nev.length()>0) {
					Karakter4_Valaszt=true;
					Image Karakter_4_Formazas=Feldolgozas_4.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
					ImageIcon Karakter_4_icon=new ImageIcon(Karakter_4_Formazas);
					Karakter_4.setIcon(Karakter_4_icon);
					Karakter_Kep_Athelyez();
					
					
				}
			}
		});
		

		ImageIcon Karakter_5_icon=new ImageIcon(KarakterValasztas.class.getResource("/Cluedo/Kepek/Mr_Green.jpg"));
		Image Feldolgozas_5=Karakter_5_icon.getImage();
		Image Karakter_5_Formazas=Feldolgozas_5.getScaledInstance(160, 160, java.awt.Image.SCALE_SMOOTH);
		Karakter_5_icon=new ImageIcon(Karakter_5_Formazas);
		Karakter_5.setIcon(Karakter_5_icon);
		Karakter_5.setBounds(32, 222, 160, 170);
		Karakter_Valasztas_Panel.add(Karakter_5);
		
		Karakter_5.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				System.out.println("Karakter_5");
				if(Karakter_Valasztas_Aktiv&&Karakter_Valasztas_Nev.length()>0) {
					Karakter5_Valaszt=true;
					Image Karakter_5_Formazas=Feldolgozas_5.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
					ImageIcon Karakter_5_icon=new ImageIcon(Karakter_5_Formazas);
					Karakter_5.setIcon(Karakter_5_icon);
					Karakter_Kep_Athelyez();
					
					
				}
			}
		});
		

		ImageIcon Karakter_6_icon=new ImageIcon(KarakterValasztas.class.getResource("/Cluedo/Kepek/Porf_Plum.jpg"));
		Image Feldolgozas_6=Karakter_6_icon.getImage();
		Image Karakter_6_Formazas=Feldolgozas_6.getScaledInstance(160, 160, java.awt.Image.SCALE_SMOOTH);
		Karakter_6_icon=new ImageIcon(Karakter_6_Formazas);
		Karakter_6.setIcon(Karakter_6_icon);
		Karakter_6.setBounds(224, 222, 160, 170);
		Karakter_Valasztas_Panel.add(Karakter_6);
		System.out.println(Karakter_6.getText());
		
		Karakter_6.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				System.out.println("Karakter_6");
				if(Karakter_Valasztas_Aktiv&&Karakter_Valasztas_Nev.length()>0) {
					Karakter6_Valaszt=true;
					Image Karakter_6_Formazas=Feldolgozas_6.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
					ImageIcon Karakter_6_icon=new ImageIcon(Karakter_6_Formazas);
					Karakter_6.setIcon(Karakter_6_icon);
					Karakter_Kep_Athelyez();
					
					
				}
			}
		});

		


			
			
		
		
		
		
	}
	static void Karakter_Kep_Athelyez() {
		switch (Hanyadikfej2) {
		
		case 1: {
			System.out.println("Karaktert valaszto megtalalva: 1. jatekosnak");
			
			if(Karakter_Valasztas_Aktiv) {
				System.out.println("Valasztas aktiv igy kezdodik a kijeloles figyeles");
				
				if(Karakter1_Valaszt) {
					System.err.println("1. jatszahto karakter kivalasztva");
					Karakter_Valasztas1.setIcon(Karakter_1.getIcon());
					Karakter_1.setVisible(false);
					Karakter_Valaszto_Hatter.repaint();
					Karakter1_Valaszt=false;}
				
				if(Karakter2_Valaszt) {
					System.err.println("2. jatszahto karakter kivalasztva");
					Karakter_Valasztas1.setIcon(Karakter_2.getIcon());
					Karakter_2.setVisible(false);
					Karakter_Valaszto_Hatter.repaint();
					Karakter2_Valaszt=false;}
				
				if(Karakter3_Valaszt) {
					System.err.println("3. jatszahto karakter kivalasztva");
					Karakter_Valasztas1.setIcon(Karakter_3.getIcon());
					Karakter_3.setVisible(false);
					Karakter_Valaszto_Hatter.repaint();
					Karakter3_Valaszt=false;}
				
				if(Karakter4_Valaszt) {
					System.err.println("4. jatszahto karakter kivalasztva");
					Karakter_Valasztas1.setIcon(Karakter_4.getIcon());
					Karakter_4.setVisible(false);
					Karakter_Valaszto_Hatter.repaint();
					Karakter4_Valaszt=false;}
				
				if(Karakter5_Valaszt) {
					System.err.println("5. jatszahto karakter kivalasztva");
					Karakter_Valasztas1.setIcon(Karakter_5.getIcon());
					Karakter_5.setVisible(false);
					Karakter_Valaszto_Hatter.repaint();
					Karakter5_Valaszt=false;}
				
				if(Karakter6_Valaszt) {
					System.err.println("6. jatszahto karakter kivalasztva");
					Karakter_Valasztas1.setIcon(Karakter_6.getIcon());
					Karakter_6.setVisible(false);
					Karakter_Valaszto_Hatter.repaint();
					Karakter6_Valaszt=false;}

			}
			Karakter_Valasztas_Aktiv=false;
			Karakter1_Valaszt=false;
			Osszesen_Jatszik++;
			break;
		}


		
		case 2:{
			System.out.println("Karaktert valaszto megtalalva: 2. jatekosnak");
			
			if(Karakter_Valasztas_Aktiv) {
				System.out.println("Valasztas aktiv igy kezdodik a kijeloles figyeles");
				
				if(Karakter1_Valaszt) {
					System.err.println("1. jatszahto karakter kivalasztva");
					Karakter_Valasztas.get(Hanyadikfej2-1).setIcon(Karakter_1.getIcon());
					Karakter_1.setVisible(false);
					Karakter_Valaszto_Hatter.repaint();
					Karakter1_Valaszt=false;}
				
				if(Karakter2_Valaszt) {
					System.err.println("2. jatszahto karakter kivalasztva");
					Karakter_Valasztas.get(Hanyadikfej2-1).setIcon(Karakter_2.getIcon());
					Karakter_2.setVisible(false);
					Karakter_Valaszto_Hatter.repaint();
					Karakter2_Valaszt=false;}
				
				if(Karakter3_Valaszt) {
					System.err.println("3. jatszahto karakter kivalasztva");
					Karakter_Valasztas.get(Hanyadikfej2-1).setIcon(Karakter_3.getIcon());
					Karakter_3.setVisible(false);
					Karakter_Valaszto_Hatter.repaint();
					Karakter3_Valaszt=false;}
				
				if(Karakter4_Valaszt) {
					System.err.println("4. jatszahto karakter kivalasztva");
					Karakter_Valasztas.get(Hanyadikfej2-1).setIcon(Karakter_4.getIcon());
					Karakter_4.setVisible(false);
					Karakter_Valaszto_Hatter.repaint();
					Karakter4_Valaszt=false;}
				
				if(Karakter5_Valaszt) {
					System.err.println("5. jatszahto karakter kivalasztva");
					Karakter_Valasztas.get(Hanyadikfej2-1).setIcon(Karakter_5.getIcon());
					Karakter_5.setVisible(false);
					Karakter_Valaszto_Hatter.repaint();
					Karakter5_Valaszt=false;}
				
				if(Karakter6_Valaszt) {
					System.err.println("6. jatszahto karakter kivalasztva");
					Karakter_Valasztas.get(Hanyadikfej2-1).setIcon(Karakter_6.getIcon());
					Karakter_6.setVisible(false);
					Karakter_Valaszto_Hatter.repaint();
					Karakter6_Valaszt=false;}

			}
			Karakter_Valasztas_Aktiv=false;
			Karakter2_Valaszt=false;
			Osszesen_Jatszik++;
			break;
		}
		case 3:{
			System.out.println("Karaktert valaszto megtalalva: 3. jatekosnak");
			if(Karakter_Valasztas_Aktiv) {
				System.out.println("Valasztas aktiv igy kezdodik a kijeloles figyeles");
				
				if(Karakter1_Valaszt) {
					System.err.println("1. jatszahto karakter kivalasztva");
					Karakter_Valasztas.get(Hanyadikfej2-1).setIcon(Karakter_1.getIcon());
					Karakter_1.setVisible(false);
					Karakter_Valaszto_Hatter.repaint();
					Karakter1_Valaszt=false;}
				
				if(Karakter2_Valaszt) {
					System.err.println("2. jatszahto karakter kivalasztva");
					Karakter_Valasztas.get(Hanyadikfej2-1).setIcon(Karakter_2.getIcon());
					Karakter_2.setVisible(false);
					Karakter_Valaszto_Hatter.repaint();
					Karakter2_Valaszt=false;}
				
				if(Karakter3_Valaszt) {
					System.err.println("3. jatszahto karakter kivalasztva");
					Karakter_Valasztas.get(Hanyadikfej2-1).setIcon(Karakter_3.getIcon());
					Karakter_3.setVisible(false);
					Karakter_Valaszto_Hatter.repaint();
					Karakter3_Valaszt=false;}
				
				if(Karakter4_Valaszt) {
					System.err.println("4. jatszahto karakter kivalasztva");
					Karakter_Valasztas.get(Hanyadikfej2-1).setIcon(Karakter_4.getIcon());
					Karakter_4.setVisible(false);
					Karakter_Valaszto_Hatter.repaint();
					Karakter4_Valaszt=false;}
				
				if(Karakter5_Valaszt) {
					System.err.println("5. jatszahto karakter kivalasztva");
					Karakter_Valasztas.get(Hanyadikfej2-1).setIcon(Karakter_5.getIcon());
					Karakter_5.setVisible(false);
					Karakter_Valaszto_Hatter.repaint();
					Karakter5_Valaszt=false;}
				
				if(Karakter6_Valaszt) {
					System.err.println("6. jatszahto karakter kivalasztva");
					Karakter_Valasztas.get(Hanyadikfej2-1).setIcon(Karakter_6.getIcon());
					Karakter_6.setVisible(false);
					Karakter_Valaszto_Hatter.repaint();
					Karakter6_Valaszt=false;}

			}
			Karakter_Valasztas_Aktiv=false;
			Karakter3_Valaszt=false;
			Osszesen_Jatszik++;
			break;
		}
		case 4:{
			System.out.println("Karaktert valaszto megtalalva: 4. jatekosnak");
			if(Karakter_Valasztas_Aktiv) {
				System.out.println("Valasztas aktiv igy kezdodik a kijeloles figyeles");
				
				if(Karakter1_Valaszt) {
					System.err.println("1. jatszahto karakter kivalasztva");
					Karakter_Valasztas.get(Hanyadikfej2-1).setIcon(Karakter_1.getIcon());
					Karakter_1.setVisible(false);
					Karakter_Valaszto_Hatter.repaint();
					Karakter1_Valaszt=false;}
				
				if(Karakter2_Valaszt) {
					System.err.println("2. jatszahto karakter kivalasztva");
					Karakter_Valasztas.get(Hanyadikfej2-1).setIcon(Karakter_2.getIcon());
					Karakter_2.setVisible(false);
					Karakter_Valaszto_Hatter.repaint();
					Karakter2_Valaszt=false;}
				
				if(Karakter3_Valaszt) {
					System.err.println("3. jatszahto karakter kivalasztva");
					Karakter_Valasztas.get(Hanyadikfej2-1).setIcon(Karakter_3.getIcon());
					Karakter_3.setVisible(false);
					Karakter_Valaszto_Hatter.repaint();
					Karakter3_Valaszt=false;}
				
				if(Karakter4_Valaszt) {
					System.err.println("4. jatszahto karakter kivalasztva");
					Karakter_Valasztas.get(Hanyadikfej2-1).setIcon(Karakter_4.getIcon());
					Karakter_4.setVisible(false);
					Karakter_Valaszto_Hatter.repaint();
					Karakter4_Valaszt=false;}
				
				if(Karakter5_Valaszt) {
					System.err.println("5. jatszahto karakter kivalasztva");
					Karakter_Valasztas.get(Hanyadikfej2-1).setIcon(Karakter_5.getIcon());
					Karakter_5.setVisible(false);
					Karakter_Valaszto_Hatter.repaint();
					Karakter5_Valaszt=false;}
				
				if(Karakter6_Valaszt) {
					System.err.println("6. jatszahto karakter kivalasztva");
					Karakter_Valasztas.get(Hanyadikfej2-1).setIcon(Karakter_6.getIcon());
					Karakter_6.setVisible(false);
					Karakter_Valaszto_Hatter.repaint();
					Karakter6_Valaszt=false;}

			}
			Karakter_Valasztas_Aktiv=false;
			Karakter4_Valaszt=false;
			Osszesen_Jatszik++;
			break;
		}
		case 5:{
			System.out.println("Karaktert valaszto megtalalva: 5. jatekosnak");
			if(Karakter_Valasztas_Aktiv) {
				System.out.println("Valasztas aktiv igy kezdodik a kijeloles figyeles");
				
				if(Karakter1_Valaszt) {
					System.err.println("1. jatszahto karakter kivalasztva");
					Karakter_Valasztas.get(Hanyadikfej2-1).setIcon(Karakter_1.getIcon());
					Karakter_1.setVisible(false);
					Karakter_Valaszto_Hatter.repaint();
					Karakter1_Valaszt=false;}
				
				if(Karakter2_Valaszt) {
					System.err.println("2. jatszahto karakter kivalasztva");
					Karakter_Valasztas.get(Hanyadikfej2-1).setIcon(Karakter_2.getIcon());
					Karakter_2.setVisible(false);
					Karakter_Valaszto_Hatter.repaint();
					Karakter2_Valaszt=false;}
				
				if(Karakter3_Valaszt) {
					System.err.println("3. jatszahto karakter kivalasztva");
					Karakter_Valasztas.get(Hanyadikfej2-1).setIcon(Karakter_3.getIcon());
					Karakter_3.setVisible(false);
					Karakter_Valaszto_Hatter.repaint();
					Karakter3_Valaszt=false;}
				
				if(Karakter4_Valaszt) {
					System.err.println("4. jatszahto karakter kivalasztva");
					Karakter_Valasztas.get(Hanyadikfej2-1).setIcon(Karakter_4.getIcon());
					Karakter_4.setVisible(false);
					Karakter_Valaszto_Hatter.repaint();
					Karakter4_Valaszt=false;}
				
				if(Karakter5_Valaszt) {
					System.err.println("5. jatszahto karakter kivalasztva");
					Karakter_Valasztas.get(Hanyadikfej2-1).setIcon(Karakter_5.getIcon());
					Karakter_5.setVisible(false);
					Karakter_Valaszto_Hatter.repaint();
					Karakter5_Valaszt=false;}
				
				if(Karakter6_Valaszt) {
					System.err.println("6. jatszahto karakter kivalasztva");
					Karakter_Valasztas.get(Hanyadikfej2-1).setIcon(Karakter_6.getIcon());
					Karakter_6.setVisible(false);
					Karakter_Valaszto_Hatter.repaint();
					Karakter6_Valaszt=false;}

			}
			Karakter_Valasztas_Aktiv=false;
			Karakter5_Valaszt=false;
			Osszesen_Jatszik++;
			break;
		}
		case 6:{
			System.out.println("Karaktert valaszto megtalalva: 6. jatekosnak");
			if(Karakter_Valasztas_Aktiv) {
				System.out.println("Valasztas aktiv igy kezdodik a kijeloles figyeles");
				
				if(Karakter1_Valaszt) {
					System.err.println("1. jatszahto karakter kivalasztva");
					Karakter_Valasztas.get(Hanyadikfej2-1).setIcon(Karakter_1.getIcon());
					Karakter_1.setVisible(false);
					Karakter_Valaszto_Hatter.repaint();
					Karakter1_Valaszt=false;}
				
				if(Karakter2_Valaszt) {
					System.err.println("2. jatszahto karakter kivalasztva");
					Karakter_Valasztas.get(Hanyadikfej2-1).setIcon(Karakter_2.getIcon());
					Karakter_2.setVisible(false);
					Karakter_Valaszto_Hatter.repaint();
					Karakter2_Valaszt=false;}
				
				if(Karakter3_Valaszt) {
					System.err.println("3. jatszahto karakter kivalasztva");
					Karakter_Valasztas.get(Hanyadikfej2-1).setIcon(Karakter_3.getIcon());
					Karakter_3.setVisible(false);
					Karakter_Valaszto_Hatter.repaint();
					Karakter3_Valaszt=false;}
				
				if(Karakter4_Valaszt) {
					System.err.println("4. jatszahto karakter kivalasztva");
					Karakter_Valasztas.get(Hanyadikfej2-1).setIcon(Karakter_4.getIcon());
					Karakter_4.setVisible(false);
					Karakter_Valaszto_Hatter.repaint();
					Karakter4_Valaszt=false;}
				
				if(Karakter5_Valaszt) {
					System.err.println("5. jatszahto karakter kivalasztva");
					Karakter_Valasztas.get(Hanyadikfej2-1).setIcon(Karakter_5.getIcon());
					Karakter_5.setVisible(false);
					Karakter_Valaszto_Hatter.repaint();
					Karakter5_Valaszt=false;}
				
				if(Karakter6_Valaszt) {
					System.err.println("6. jatszahto karakter kivalasztva");
					Karakter_Valasztas.get(Hanyadikfej2-1).setIcon(Karakter_6.getIcon());
					Karakter_6.setVisible(false);
					Karakter_Valaszto_Hatter.repaint();
					Karakter6_Valaszt=false;}

			}
			Karakter_Valasztas_Aktiv=false;
			Karakter6_Valaszt=false;
			Osszesen_Jatszik++;
			break;
		}
		case 7:{
			System.out.println("Karaktert valaszto megtalalva: 7. jatekosnak");
			if(Karakter_Valasztas_Aktiv) {
				System.out.println("Valasztas aktiv igy kezdodik a kijeloles figyeles");
				
				if(Karakter1_Valaszt) {
					System.err.println("1. jatszahto karakter kivalasztva");
					Karakter_Valasztas.get(Hanyadikfej2-1).setIcon(Karakter_1.getIcon());
					Karakter_1.setVisible(false);
					Karakter_Valaszto_Hatter.repaint();
					Karakter1_Valaszt=false;}
				
				if(Karakter2_Valaszt) {
					System.err.println("2. jatszahto karakter kivalasztva");
					Karakter_Valasztas.get(Hanyadikfej2-1).setIcon(Karakter_2.getIcon());
					Karakter_2.setVisible(false);
					Karakter_Valaszto_Hatter.repaint();
					Karakter2_Valaszt=false;}
				
				if(Karakter3_Valaszt) {
					System.err.println("3. jatszahto karakter kivalasztva");
					Karakter_Valasztas.get(Hanyadikfej2-1).setIcon(Karakter_3.getIcon());
					Karakter_3.setVisible(false);
					Karakter_Valaszto_Hatter.repaint();
					Karakter3_Valaszt=false;}
				
				if(Karakter4_Valaszt) {
					System.err.println("4. jatszahto karakter kivalasztva");
					Karakter_Valasztas.get(Hanyadikfej2-1).setIcon(Karakter_4.getIcon());
					Karakter_4.setVisible(false);
					Karakter_Valaszto_Hatter.repaint();
					Karakter4_Valaszt=false;}
				
				if(Karakter5_Valaszt) {
					System.err.println("5. jatszahto karakter kivalasztva");
					Karakter_Valasztas.get(Hanyadikfej2-1).setIcon(Karakter_5.getIcon());
					Karakter_5.setVisible(false);
					Karakter_Valaszto_Hatter.repaint();
					Karakter5_Valaszt=false;}
				
				if(Karakter6_Valaszt) {
					System.err.println("6. jatszahto karakter kivalasztva");
					Karakter_Valasztas.get(Hanyadikfej2-1).setIcon(Karakter_6.getIcon());
					Karakter_6.setVisible(false);
					Karakter_Valaszto_Hatter.repaint();
					Karakter6_Valaszt=false;}

			}
			Osszesen_Jatszik++;
			break;
		}
		case 8:{
			System.out.println("Karaktert valaszto megtalalva: 8. jatekosnak");
			if(Karakter_Valasztas_Aktiv) {
				System.out.println("Valasztas aktiv igy kezdodik a kijeloles figyeles");
				
				if(Karakter1_Valaszt) {
					System.err.println("1. jatszahto karakter kivalasztva");
					Karakter_Valasztas.get(Hanyadikfej2-1).setIcon(Karakter_1.getIcon());
					Karakter_1.setVisible(false);
					Karakter_Valaszto_Hatter.repaint();
					Karakter1_Valaszt=false;}
				
				if(Karakter2_Valaszt) {
					System.err.println("2. jatszahto karakter kivalasztva");
					Karakter_Valasztas.get(Hanyadikfej2-1).setIcon(Karakter_2.getIcon());
					Karakter_2.setVisible(false);
					Karakter_Valaszto_Hatter.repaint();
					Karakter2_Valaszt=false;}
				
				if(Karakter3_Valaszt) {
					System.err.println("3. jatszahto karakter kivalasztva");
					Karakter_Valasztas.get(Hanyadikfej2-1).setIcon(Karakter_3.getIcon());
					Karakter_3.setVisible(false);
					Karakter_Valaszto_Hatter.repaint();
					Karakter3_Valaszt=false;}
				
				if(Karakter4_Valaszt) {
					System.err.println("4. jatszahto karakter kivalasztva");
					Karakter_Valasztas.get(Hanyadikfej2-1).setIcon(Karakter_4.getIcon());
					Karakter_4.setVisible(false);
					Karakter_Valaszto_Hatter.repaint();
					Karakter4_Valaszt=false;}
				
				if(Karakter5_Valaszt) {
					System.err.println("5. jatszahto karakter kivalasztva");
					Karakter_Valasztas.get(Hanyadikfej2-1).setIcon(Karakter_5.getIcon());
					Karakter_5.setVisible(false);
					Karakter_Valaszto_Hatter.repaint();
					Karakter5_Valaszt=false;}
				
				if(Karakter6_Valaszt) {
					System.err.println("6. jatszahto karakter kivalasztva");
					Karakter_Valasztas.get(Hanyadikfej2-1).setIcon(Karakter_6.getIcon());
					Karakter_6.setVisible(false);
					Karakter_Valaszto_Hatter.repaint();
					Karakter6_Valaszt=false;}

			}
			Osszesen_Jatszik++;
			break;
		}
		case 9:{
			System.out.println("Karaktert valaszto megtalalva: 9. jatekosnak");
			if(Karakter_Valasztas_Aktiv) {
				System.out.println("Valasztas aktiv igy kezdodik a kijeloles figyeles");
				
				if(Karakter1_Valaszt) {
					System.err.println("1. jatszahto karakter kivalasztva");
					Karakter_Valasztas.get(Hanyadikfej2-1).setIcon(Karakter_1.getIcon());
					Karakter_1.setVisible(false);
					Karakter_Valaszto_Hatter.repaint();
					Karakter1_Valaszt=false;}
				
				if(Karakter2_Valaszt) {
					System.err.println("2. jatszahto karakter kivalasztva");
					Karakter_Valasztas.get(Hanyadikfej2-1).setIcon(Karakter_2.getIcon());
					Karakter_2.setVisible(false);
					Karakter_Valaszto_Hatter.repaint();
					Karakter2_Valaszt=false;}
				
				if(Karakter3_Valaszt) {
					System.err.println("3. jatszahto karakter kivalasztva");
					Karakter_Valasztas.get(Hanyadikfej2-1).setIcon(Karakter_3.getIcon());
					Karakter_3.setVisible(false);
					Karakter_Valaszto_Hatter.repaint();
					Karakter3_Valaszt=false;}
				
				if(Karakter4_Valaszt) {
					System.err.println("4. jatszahto karakter kivalasztva");
					Karakter_Valasztas.get(Hanyadikfej2-1).setIcon(Karakter_4.getIcon());
					Karakter_4.setVisible(false);
					Karakter_Valaszto_Hatter.repaint();
					Karakter4_Valaszt=false;}
				
				if(Karakter5_Valaszt) {
					System.err.println("5. jatszahto karakter kivalasztva");
					Karakter_Valasztas.get(Hanyadikfej2-1).setIcon(Karakter_5.getIcon());
					Karakter_5.setVisible(false);
					Karakter_Valaszto_Hatter.repaint();
					Karakter5_Valaszt=false;}
				
				if(Karakter6_Valaszt) {
					System.err.println("6. jatszahto karakter kivalasztva");
					Karakter_Valasztas.get(Hanyadikfej2-1).setIcon(Karakter_6.getIcon());
					Karakter_6.setVisible(false);
					Karakter_Valaszto_Hatter.repaint();
					Karakter6_Valaszt=false;}

			}
			Osszesen_Jatszik++;
			break;
		}
		default:
			System.out.println("Nem talalhato karakter a switch-case kriteriumban");;
		}
		
	}
	static void Karakter_Kivalasztott_Kep() {
		
	}
}
