package Bloods;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Window;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JToggleButton;

public class Bejelentkezes extends Keret{
	public static JPanel Login_Panel= new JPanel();
	public static JLabel Bejelentkezo_Label = new JLabel("Bejelentkezés");
	private static String Becenev="Tepike";
	private static String Felhasznalo="1";
	private static String Jelszo="1";
	private static JTextField Felhasznalo_Text;
	private static JPasswordField Jelszo_Text;
	public static JButton LoginButton= new JButton("Bejelentkezés");
	public static JPanel Adatok_Panel = new JPanel();
	
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public static void Login_Futtat() {
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
		LoginButton.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
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
}
