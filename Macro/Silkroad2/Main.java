package Silkroad2;

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
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.ListSelectionModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;

public class Main extends JFrame {

	private static final long serialVersionUID = 1L;
	static JPanel contentPane;
	static JLabel Inditas_Label;
	static JLabel Felvetel_Label;
	static JLabel Gyorsgomb_Label;
	public static Main frame;

	static JPanel Felvett_Gombok= new JPanel();
	private JLabel Lathato_Label;
	static boolean kicsinyit=false;
	static boolean felvetel_megy=false;
	static ArrayList<JComboBox> Skillek = new ArrayList<JComboBox>();
	static int Skillek_Y=34;
	static int Keret_Tarolt_X=0;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
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
		setBounds(0, 0, 600, 500);
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
				Bezar_label.setBounds(Bezar_label.getX(), Bezar_label.getY()-6, 44, 51);
				
			}
			public void mouseExited(MouseEvent e) {
				Bezar_label.setFont(new Font("ROG Fonts", Font.BOLD, 30));
				Bezar_label.setBounds(Bezar_label.getX(), Bezar_label.getY()+6, 44, 51);
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
		
		Inditas_Label = new JLabel("Indítás:");
		Inditas_Label.setFont(new Font("Tahoma", Font.BOLD, 16));
		Inditas_Label.setBounds(15, 4, 65, 30);
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
				Felvetel_Label.setForeground(Color.black);
				felvetel_megy=false;
				}
				else {
					if(kicsinyit) {
						setSize(600,600);
						kicsinyit=false;
					}
					System.out.println("Felvetel rogzit");
				Felvetel_Label.setForeground(Color.red);
				felvetel_megy=true;
				
				}
				
				
				}
			}
		});
		Felvetel_Label.setFont(new Font("Tahoma", Font.BOLD, 16));
		Felvetel_Label.setBounds(135, 4, 65, 30);
		//contentPane.add(Felvetel_Label);
		
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
		Betoltes_Label.setBounds(522, 456, 68, 30);
		contentPane.add(Betoltes_Label);
		
		JLabel Mentes_Label = new JLabel("Mentés");
		Mentes_Label.setFont(new Font("Tahoma", Font.BOLD, 16));
		Mentes_Label.setBounds(419, 456, 65, 30);
		contentPane.add(Mentes_Label);
		
		Gyorsgomb_Label = new JLabel("(Home)");
		Gyorsgomb_Label.setHorizontalAlignment(SwingConstants.LEFT);
		Gyorsgomb_Label.setFont(new Font("Tahoma", Font.BOLD, 16));
		Gyorsgomb_Label.setBounds(85, 4, 100, 30);
		contentPane.add(Gyorsgomb_Label);
		setBackground(new Color(200,200,200,100));
		getContentPane().add(Felvett_Gombok);
		Felvett_Gombok.setBounds(20, 55, 560, 390);
		Felvett_Gombok.setBackground(new Color(0,0,0,150));
		Felvett_Gombok.setLayout(null);
		
		JLabel Skillek_Label = new JLabel("Skill helye");
		Skillek_Label.setForeground(Color.WHITE);
		Skillek_Label.setFont(new Font("Tahoma", Font.BOLD, 16));
		Skillek_Label.setBounds(10, 3, 90, 30);
		Felvett_Gombok.add(Skillek_Label);
		
		for(int i=0;i<10;i++) {
		JComboBox comboBox_0 = new JComboBox();
		comboBox_0.setMaximumRowCount(11);
		comboBox_0.setToolTipText("Skill helye");
		comboBox_0.setEditable(false);
		comboBox_0.setLayout(null);
		comboBox_0.setAlignmentX(CENTER_ALIGNMENT);
		comboBox_0.setModel(new DefaultComboBoxModel(new String[] {" ","0", "1", "2", "3", "4", "5", "6", "7", "8", "9"}));
		comboBox_0.setBounds(11, Skillek_Y, 82, 22);
		comboBox_0.setFont(new Font("Tahoma", Font.BOLD, 16));
        // Középre igazítás beállítása
        DefaultListCellRenderer igazitas = new DefaultListCellRenderer();
        igazitas.setHorizontalAlignment(SwingConstants.CENTER);
        comboBox_0.setRenderer(igazitas);
		Skillek.add(comboBox_0);
		Felvett_Gombok.add(Skillek.get(i));
		Skillek_Y=Skillek_Y+34;
		}
		
		
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
					//Keret_Tarolt_X=(int)getLocation().getX();
					setLocation((int)getLocation().getX()+350, (int)getLocation().getY());;
					setSize(250,50);
					kicsinyit=true;
					Lathato_Label.setLocation((int)Lathato_Label.getLocation().getX()-350,(int)Lathato_Label.getLocation().getY());
					Bezar_label.setLocation((int)Bezar_label.getLocation().getX()-350,(int)Bezar_label.getLocation().getY());
					repaint();
					
					
				}else {
					//setLocation(Keret_Tarolt_X, (int)getLocation().getY());;
					setLocation((int)getLocation().getX()-350, (int)getLocation().getY());;
					setSize(600,500);
					kicsinyit=false;
					Lathato_Label.setLocation((int)Lathato_Label.getLocation().getX()+350,(int)Lathato_Label.getLocation().getY());
					Bezar_label.setBounds(553, 5, 44, 44);
					repaint();
					
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
		
	}
}
