package Bloods;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Bejelentkezes extends Keret{
	public static JPanel Login_Panel= new JPanel();
	public static JLabel Bejelentkezo_Label = new JLabel("Bejelentkezés");
	private static String Becenev="Tepike";
	private static String Felhasznalo;
	private static String Jelszo;
	static JTextField Felhasznalo_Text;
	static JPasswordField Jelszo_Text;
	public static JButton LoginButton= new JButton("Bejelentkezés");
	public static JPanel Adatok_Panel = new JPanel();
	static int probalkozasok=0;
	static public String probak="Hibás adatok\nHátralévő próbálkozások száma : " +(2-probalkozasok);
	static JPanel Betoltes_Panel= new JPanel();
	static JLabel Betoltes= new JLabel();
	
	
	/**
	 * @throws Exception 
	 * @wbp.parser.entryPoint
	 */
	public static void Login_Futtat() throws Exception {
		@SuppressWarnings("unused")
		Adatbazis adat= new Adatbazis();
		Adatbazis.Felhasznalok();
		

		//adat.addfelhasznalo("Test", "Jelszo", "Din Rifat");
		
		Bejelentkezo_Label.setFont(new Font("Tahoma", Font.BOLD, 20));
		Bejelentkezo_Label.setHorizontalAlignment(SwingConstants.CENTER);
		
		

		Bejelentkezo_Label.setBounds(0, 0, 400, 46);
		
		
		Login_Panel.setSize(400,250);
	
		Login_Panel.setBackground(new Color(100,100,100,200));
		
		Login_Panel.setLocation(Keret_Szeles/2-(Login_Panel.getWidth()/2), Keret_Magas/2-(Login_Panel.getHeight()/2));
		Login_Panel.setLayout(null);
		Login_Panel.add(Bejelentkezo_Label);
		

		
		
		
		
		//Utolso folyamat
		Login_Panel.setVisible(true);
		Hatterkep_Keret.add(Login_Panel);
		
		//Betolto loop gif
		Betoltes_Panel.setBounds(Login_Panel.getX()-10,Login_Panel.getY()-10,Login_Panel.getWidth()+20, Login_Panel.getHeight()+60);
		Betoltes_Panel.setBackground(new Color(0,0,0,0));
		Betoltes_Panel.setOpaque(false);
		
		Betoltes.setIcon(new ImageIcon(Keret.class.getResource("/Bloods/loading.gif")));
		Betoltes.setBounds(Keret_Szeles/2-200,Keret_Magas-400,400,400);
		Betoltes.setForeground(Color.black);
		
		Betoltes_Panel.add(Betoltes);
		Hatterkep_Keret.add(Betoltes_Panel);
		Hatterkep_Keret.setComponentZOrder(Betoltes_Panel, 0);
		System.out.println(Hatterkep_Keret.getComponentZOrder(Betoltes_Panel));
		System.out.println(Hatterkep_Keret.getComponentZOrder(Login_Panel));
		Betoltes_Panel.setVisible(false);
		

		
		

		
		LoginButton.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			public void mousePressed(MouseEvent e) {
				System.out.println(probalkozasok);
				Adatbazis.Felhasznalo_Leker();

				
				if(Felhasznalo_Text.getText().length()<1&&Adatbazis.con!=null) {
					JOptionPane.showMessageDialog(null, "Nincs megadva felhasználó");
					System.out.println("Nincs megadott felhasznalo");
				}
				if(Jelszo_Text.getText().length()<1&&Adatbazis.con!=null) {
					JOptionPane.showMessageDialog(null, "Nincs megadva jelszó");
					System.out.println("Nincs megadott jelszo");
				}
				else if(!Jelszo_Text.getText().equals(getJelszo())|!Felhasznalo_Text.getText().equals(getFelhasznalo())&&Adatbazis.con!=null) {
					JOptionPane.showMessageDialog(null, probak);
					probalkozasok++;
					probak="Hibás adatok\nHátralévő próbálkozások száma : " +(2-probalkozasok);
					if(probalkozasok==3) {
						System.exit(0);
					}
				
				}else if (Jelszo_Text.getText().equals(getJelszo())&&Felhasznalo_Text.getText().equals(getFelhasznalo())&&Adatbazis.con!=null) {
					probalkozasok=0;
					Toolkit.getDefaultToolkit().beep();
					
					Menu.Menu_futtat();
				}

		}});
		
		
		LoginButton.setBounds(270, 201, 120, 30);
		Login_Panel.add(LoginButton);
		LoginButton.setVisible(true);
		
		
		
		Adatok_Panel.setBounds(10, 70, 380, 120);
		Adatok_Panel.setBackground(new Color(100,100,100,180));
		Login_Panel.add(Adatok_Panel);
		Adatok_Panel.setLayout(null);
		Adatok_Panel.setVisible(false);
		Adatok_Panel.setVisible(true);
		
		JLabel Felhasznalo_Label = new JLabel("Felhasznaló:");
		Felhasznalo_Label.setBounds(0, 11, 129, 46);
		Adatok_Panel.add(Felhasznalo_Label);
		Felhasznalo_Label.setHorizontalAlignment(SwingConstants.RIGHT);
		Felhasznalo_Label.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		Jelszo_Text = new JPasswordField();
		Jelszo_Text.setHorizontalAlignment(SwingConstants.CENTER);
		Jelszo_Text.setFont(new Font("Tahoma", Font.BOLD, 16));
		Jelszo_Text.setBounds(139, 59, 186, 25);
		Jelszo_Text.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@SuppressWarnings("deprecation")
			@Override
			public void keyPressed(KeyEvent e) {
	        	  if (e.getKeyCode() == KeyEvent.VK_ENTER) {
	        		  Adatbazis.Felhasznalo_Leker();
	        		  
	        		  
	        		  if(Felhasznalo_Text.getText().length()<1&&Adatbazis.con!=null) {
	  					JOptionPane.showMessageDialog(null, "Nincs megadva felhasználó");
	  					System.out.println("Nincs megadott felhasznalo");
	  				}
	  				if(Jelszo_Text.getText().length()<1&&Adatbazis.con!=null) {
	  					JOptionPane.showMessageDialog(null, "Nincs megadva jelszó");
	  					System.out.println("Nincs megadott jelszo");
	  				}
	  				else if(!Jelszo_Text.getText().equals(getJelszo())|!Felhasznalo_Text.getText().equals(getFelhasznalo())&&Adatbazis.con!=null) {
						JOptionPane.showMessageDialog(null, probak);
						probalkozasok++;
						probak="Hibás adatok\nHátralévő próbálkozások száma : " +(2-probalkozasok);
						if(probalkozasok==3) {
							System.exit(0);
						}
	  				
	  				}else if (Jelszo_Text.getText().equals(getJelszo())&&Felhasznalo_Text.getText().equals(getFelhasznalo())&&Adatbazis.con!=null) {
	  					Toolkit.getDefaultToolkit().beep();
	  					
	  					Menu.Menu_futtat();
	  				}
		                 
		             }
				
			}
		});
		Adatok_Panel.add(Jelszo_Text);
		
		JLabel Jelszo_Label = new JLabel("Jelszó:");
		Jelszo_Label.setBounds(0, 46, 129, 46);
		Adatok_Panel.add(Jelszo_Label);
		Jelszo_Label.setHorizontalAlignment(SwingConstants.RIGHT);
		Jelszo_Label.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		Felhasznalo_Text = new JTextField();
		Felhasznalo_Text.setFont(new Font("Tahoma", Font.BOLD, 16));
		Felhasznalo_Text.setHorizontalAlignment(SwingConstants.CENTER);
		Felhasznalo_Text.setBounds(139, 24, 186, 25);
		Felhasznalo_Text.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@SuppressWarnings("deprecation")
			@Override
			public void keyPressed(KeyEvent e) {
	        	  if (e.getKeyCode() == KeyEvent.VK_ENTER) {
	        		  if(Felhasznalo_Text.getText().length()<1) {
	  					JOptionPane.showMessageDialog(null, "Nincs megadva felhasználó");
	  					System.out.println("Nincs megadott felhasznalo");
	  				}
	  				if(Jelszo_Text.getText().length()<1) {
	  					JOptionPane.showMessageDialog(null, "Nincs megadva jelszó");
	  					System.out.println("Nincs megadott jelszo");
	  				}
	  				else if(!Jelszo_Text.getText().equals(getJelszo())|!Felhasznalo_Text.getText().equals(getFelhasznalo())) {
	  					JOptionPane.showMessageDialog(null, "Hibás bejelentkezési adatok");
	  				
	  				}else if (Jelszo_Text.getText().equals(getJelszo())&&Felhasznalo_Text.getText().equals(getFelhasznalo())) {
	  					Toolkit.getDefaultToolkit().beep();
	  					Menu.Menu_futtat();
	  				}
		                 
		             }
				
			}
		});
		
		
		Adatok_Panel.add(Felhasznalo_Text);
		Felhasznalo_Text.setColumns(10);
		
		
	}
	public static void Bejelentkezes_bezar() {
		Login_Panel.setVisible(false);
		
	}

	public static String getFelhasznalo() {
		return Felhasznalo;
	}


	public static void setFelhasznalo(String felhasznalo) {
		Felhasznalo = felhasznalo;
	}


	public static String getJelszo() {
		return Jelszo;
	}


	public static void setJelszo(String jelszo) {
		Jelszo = jelszo;
	}
	public static String getBecenev() {
		return Becenev;
	}
	public static void setBecenev(String becenev) {
		Becenev = becenev;
	}
	public static void Adatbazis_Kapcsolat_Hiba() {
		Betoltes_Panel.setVisible(true);
		Hatterkep_Keret.setVisible(false);
		Login_Panel.setVisible(false);
		Hatterkep_Keret.setVisible(true);
		Login_Panel.setVisible(true);

		Felhasznalo_Text.setEditable(false);
		Jelszo_Text.setEditable(false);
	}
	public static void Adatbazis_Kapcsolat_Sikeres() {
		Betoltes_Panel.setVisible(false);
		Hatterkep_Keret.setVisible(false);
		Login_Panel.setVisible(false);
		Hatterkep_Keret.setVisible(true);
		Login_Panel.setVisible(true);
		Felhasznalo_Text.setEditable(true);
		Jelszo_Text.setEditable(true);
	}
	
}
