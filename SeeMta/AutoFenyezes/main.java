package AutoFenyezes;

import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.text.ListFormat.Style;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.border.LineBorder;

import Bloods.Keret;
import Cluedo.Alapkep;

public class main  {

	static JFrame keret = new JFrame();
	public static JFrame Munkaterulet= new JFrame();
	static Boolean Panel_mozgat=true;
	static Short Eger_X;
	static Short Eger_Y;
	static byte i=0;
	public static byte gomb=0;
	static boolean ElsoMegnyitas=true;
	final static JSlider Lathatosag= new JSlider();
	final static JLabel Munkaterulet_Attetszoseg= new JLabel("Áttetszőség");
	static JLabel MainScreen_Wallpaper;

	public static void main(String[] args) {
//Keret létrehozása
		keret.setTitle("Fenyezes");
		keret.setBounds(100, 100, 500, 300);
		keret.setUndecorated(true);
		keret.setBackground(new Color(100,100,100,150));
		keret.setLocationRelativeTo(null);
		keret.setLayout(null);
		keret.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		keret.setAlwaysOnTop(true);
		/*
	 ImageIcon imageIcon = new ImageIcon(Alapkep.class.getResource("/Cluedo/Kepek/Editon_Tr.jpg")); // load the image to a imageIcon
	 Image image = imageIcon.getImage(); // transform it 
	 Image newimg = image.getScaledInstance(600, 350,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
	 imageIcon = new ImageIcon(newimg);  // transform it back
	 
	 Kiadas.setBounds(Kiadas_Felirat_Hely_Szeles,Kiadas_Felirat_Hely_Magas,600,350);
	 Kiadas.setIcon(imageIcon);
		 */
		
		ImageIcon img= new ImageIcon((main.class.getResource("/AutoFenyezes/MainScreen3.jpg")));
		Image KepBeolvas= img.getImage();
		Image KepFeldolgoz=KepBeolvas.getScaledInstance(500, 300, java.awt.Image.SCALE_SMOOTH);
		img= new ImageIcon(KepFeldolgoz);
		MainScreen_Wallpaper= new JLabel(img);
		MainScreen_Wallpaper.setBounds(0, 0, 500, 300);
		MainScreen_Wallpaper.setLayout(null);
		
		keret.add(MainScreen_Wallpaper);
		keret.setComponentZOrder(MainScreen_Wallpaper, 0);
		MainScreen_Wallpaper.setVisible(true);
		//Kilépés gomb létrehozása és beállítása
		JLabel Bezar= new JLabel("X");
		MainScreen_Wallpaper.add(Bezar);
		Bezar.setFont(new Font("Arial", Font.BOLD, 25));
		Bezar.setBounds(keret.getWidth()-30,15, 20, 20);
		Bezar.setForeground(Color.red);
		Bezar.addMouseListener(new MouseAdapter() {
			public void mouseExited(MouseEvent e) {
				Bezar.setFont(new Font("Arial", Font.BOLD, 25));
				Bezar.setBounds(keret.getWidth()-30,15, 20, 20);
				//Terület elrejtes
				//Bezar.setBorder(BorderFactory.createLineBorder(Color.red, 0));
			}

			public void mouseEntered(MouseEvent e) {
				Bezar.setFont(new Font("Arial", Font.BOLD, 35));
				Bezar.setBounds(keret.getWidth()-34,8, 28, 32);
				//Terület megjelenites
				//Bezar.setBorder(BorderFactory.createLineBorder(Color.red, 2));
			}

			public void mousePressed(MouseEvent e) {
				if(e.getButton()==MouseEvent.BUTTON1) {
					System.exit(0);
				}
			}
		});
		
		//Keret mozgatása
		keret.addMouseListener(new MouseAdapter() {
			int gomb;
			int mozgo_x;
			int mozgo_y;
			int alap_x;
			int alap_y;
			public void mousePressed(MouseEvent e) {
				alap_x=(int)keret.getMousePosition().getX();
				alap_y=(int)keret.getMousePosition().getY();
				gomb=e.getButton();
				keret.addMouseMotionListener(new MouseAdapter() {
					public void mouseDragged(MouseEvent e) {
						 mozgo_x=(int)MouseInfo.getPointerInfo().getLocation().getX();
						 mozgo_y=(int)MouseInfo.getPointerInfo().getLocation().getY();
						if(gomb==1) {
							keret.setLocation(mozgo_x-alap_x,mozgo_y-alap_y);}
					}
					public void mouseReleased(MouseEvent e) {
						alap_x=0;
						alap_y=0;}
				});
			}
		});
		
TeruletJeloles teruletJeloles= new TeruletJeloles();
teruletJeloles.Munkaterulet_Letrehozas();

//Főkeret feltöltése
	Fenyezes.FenyezesGomb();
		



		
		Munkaterulet.setVisible(false);
		keret.setVisible(true);
		

		
	}

}
