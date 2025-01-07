package Silkroad;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Cluedo.Alapkep;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Main extends JFrame {

	private static final long serialVersionUID = 1L;
	public static JPanel contentPane;
	public static JLabel Inditas_Label;
	public static JLabel Felvetel_Label;
	public static JLabel Gyorsgomb_Label;
	public static Main frame;
	public static ArrayList<Felvetel> Rogzites = new ArrayList<>();
	public static ArrayList<JLabel> Felvett_macro_Skill_megjelenit = new ArrayList<JLabel>();
	public static ArrayList<JLabel> Felvett_macro_Ido_megjelenit = new ArrayList<JLabel>();
	public static boolean fut=false;
	
	private JLabel Lathato_Label;
	public static boolean kicsinyit=false;
	public static boolean felvetel_megy=false;

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					System.out.println("fut");
					 frame = new Main();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 600, 600);
		setLocationRelativeTo(null);
		setUndecorated(true);
		setAlwaysOnTop(true);
		contentPane = new JPanel();
		contentPane.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				Panel_Mozgatas.Mozgatas_be();
			}
			
			public void mouseReleased(MouseEvent e) {
				Panel_Mozgatas.Mozgatas_ki();
			}
		});
		contentPane.setForeground(Color.WHITE);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Bezar_label = new JLabel("X");
		Bezar_label.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				Bezar_label.setFont(new Font("ROG Fonts", Font.BOLD, 40));
				Bezar_label.setBounds(553, -4, 44, 51);
				
			}
			public void mouseExited(MouseEvent e) {
				Bezar_label.setFont(new Font("ROG Fonts", Font.BOLD, 30));
				Bezar_label.setBounds(553, 5, 44, 51);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				System.exit(0);
			}
		});
		Bezar_label.setHorizontalAlignment(SwingConstants.CENTER);
		Bezar_label.setVerticalAlignment(SwingConstants.TOP);
		Bezar_label.setFont(new Font("ROG Fonts", Font.BOLD, 30));
		Bezar_label.setForeground(Color.RED);
		Bezar_label.setBounds(553, 5, 44, 44);
		contentPane.add(Bezar_label);
		
		Inditas_Label = new JLabel("Indítás");
		Inditas_Label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				Felvetel.Macro_indithato=true;
				Lejatszas.Lejatszas_Indit();
				if(fut) {
					fut=false;
				}else {
					fut=true;
				}
				
			}
		});
		Inditas_Label.setFont(new Font("Tahoma", Font.BOLD, 16));
		Inditas_Label.setBounds(22, 4, 60, 30);
		contentPane.add(Inditas_Label);
		
		Felvetel_Label = new JLabel("Felvétel");
		Felvetel_Label.addMouseListener(new MouseAdapter() {
			boolean nyomhato=false;
			
			@Override
			public void mouseEntered(MouseEvent e) {
				nyomhato=true;
			}
			public void mouseExited(MouseEvent e) {
				nyomhato=false;
			}
			
			public void mouseReleased(MouseEvent e) {
				if(nyomhato) {
				if(felvetel_megy) {
					System.out.println("Felvetel leall");
					Felvetel.Felvetel_leallit();
					felvetel_megy=false;
					Felvetel_Label.setForeground(Color.black);
					Felvetel_Label.setVisible(false);
					Felvetel_Label.setVisible(true);
					
				}
				else {
					if(kicsinyit) {
						setSize(600,600);
						kicsinyit=false;
					}
					System.out.println("Felvetel rogzit");
				Felvetel_Label.setForeground(Color.red);
				felvetel_megy=true;
				Felvetel.Felvetel_indit();
				
				}
				
				
				}
			}
		});
		Felvetel_Label.setFont(new Font("Tahoma", Font.BOLD, 16));
		Felvetel_Label.setBounds(135, 4, 65, 30);
		contentPane.add(Felvetel_Label);
		
		JLabel Betoltes_Label = new JLabel("Betöltés");
		Betoltes_Label.addMouseListener(new MouseAdapter() {
			boolean nyomhato=false;
			@Override
			public void mouseReleased(MouseEvent e) {
				if(nyomhato) {
				System.out.println("Betoltes gomb megnyomva");
				}
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				nyomhato=true;
			}
			public void mouseExited(MouseEvent e) {
				nyomhato=false;
			}
		});
		Betoltes_Label.setFont(new Font("Tahoma", Font.BOLD, 16));
		Betoltes_Label.setBounds(522, 559, 68, 30);
		contentPane.add(Betoltes_Label);
		
		JLabel Mentes_Label = new JLabel("Mentés");
		Mentes_Label.setFont(new Font("Tahoma", Font.BOLD, 16));
		Mentes_Label.setBounds(419, 559, 65, 30);
		contentPane.add(Mentes_Label);
		
		Gyorsgomb_Label = new JLabel("(Home)");
		Gyorsgomb_Label.setHorizontalAlignment(SwingConstants.CENTER);
		Gyorsgomb_Label.setFont(new Font("Tahoma", Font.BOLD, 14));
		Gyorsgomb_Label.setBounds(2, 33, 100, 20);
		contentPane.add(Gyorsgomb_Label);
		setBackground(new Color(200,200,200,100));
		
		Felvetel.Felvett_Gombok.setLayout(null);
		Felvetel.Felvett_Gombok.setBounds(20, 80, 550, 460);
		Felvetel.Felvett_Gombok.setBackground(new Color(0,0,0,150));
		Felvetel.Felvett_Gombok.setVisible(true);
		contentPane.add(Felvetel.Felvett_Gombok);
		
		Lathato_Label = new JLabel();
		Lathato_Label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				 ImageIcon imageIcon = new ImageIcon(Main.class.getResource("/Silkroad/minimize.png")); // load the image to a imageIcon
				 Image image = imageIcon.getImage(); // transform it 
				 Image newimg = image.getScaledInstance(40, 40,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
				 imageIcon = new ImageIcon(newimg);  // transform it back
				Lathato_Label.setIcon(imageIcon);
			}
			
			public void mouseExited(MouseEvent e) {
				 ImageIcon imageIcon = new ImageIcon(Main.class.getResource("/Silkroad/minimize.png")); // load the image to a imageIcon
				 Image image = imageIcon.getImage(); // transform it 
				 Image newimg = image.getScaledInstance(30, 30,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
				 imageIcon = new ImageIcon(newimg);  // transform it back
				Lathato_Label.setIcon(imageIcon);
			}
			public void mouseReleased(MouseEvent e) {
				if(!kicsinyit) {
					setSize(600,60);
					kicsinyit=true;
					
					
				}else {
					setSize(600,600);
					kicsinyit=false;

					
				}
				
			}
		});
		Lathato_Label.setHorizontalAlignment(SwingConstants.CENTER);
		Lathato_Label.setFont(new Font("Symbol", Font.BOLD, 20));
		Lathato_Label.setBounds(503, 5, 44, 44);
		 ImageIcon imageIcon = new ImageIcon(Main.class.getResource("/Silkroad/minimize.png")); // load the image to a imageIcon
		 Image image = imageIcon.getImage(); // transform it 
		 Image newimg = image.getScaledInstance(30, 30,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		 imageIcon = new ImageIcon(newimg);  // transform it back
		Lathato_Label.setIcon(imageIcon);
		contentPane.add(Lathato_Label);
		Felvetel.Billentyu_Figyeles();
	}
}
