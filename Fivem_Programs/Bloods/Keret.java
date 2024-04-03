package Bloods;

import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.MouseInfo;

import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;

public class Keret extends futattas{
	public static int Keret_Szeles=600;
	public static int Keret_Magas=600;
	public static JFrame keret = new JFrame();
	public static JLabel Hatterkep_Keret= new JLabel();
	public static Timer timer = new Timer();
	public static JLabel Label_Kilepes = new JLabel("X");
	
    //Ablak mozgatása
	static int pointerX= (int)MouseInfo.getPointerInfo().getLocation().getX();
	static int pointerY=(int)MouseInfo.getPointerInfo().getLocation().getY();
    static int frameX = ((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth() - Keret_Szeles) /2;
    static int frameY = ((int)Toolkit.getDefaultToolkit().getScreenSize().getHeight() - Keret_Magas) / 2; 
    
	/**
	 * @wbp.parser.entryPoint
	 */
	public static void KeretFuttat(){
		System.out.println("Keret megjelenites elindult");
		
		
		keret.setSize(Keret_Szeles,Keret_Magas);
		keret.setLocation(((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2-(Keret_Szeles/2)), ((int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()/2)-(Keret_Magas/2));
		
		keret.setUndecorated(true);
		keret.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		keret.getContentPane().setLayout(null);
		
		
		Label_Kilepes.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				System.out.println("Alkalmazas bezarasa");
				System.exit(0);
			}
		});
		Label_Kilepes.setForeground(new Color(255, 255, 0,200));
		Label_Kilepes.setHorizontalAlignment(SwingConstants.CENTER);
		Label_Kilepes.setFont(new Font("Tahoma", Font.BOLD, 25));
		Label_Kilepes.setBounds(552, 0, 48, 41);
		
		keret.getContentPane().add(Label_Kilepes);
		Hatterkep_Keret.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(e.getButton() == MouseEvent.BUTTON1) {
					Start_Timer();
				}
				
			}
			public void mouseReleased(MouseEvent e) {
				if(e.getButton() == MouseEvent.BUTTON1) {
					Stop_Timer();
				}
				
			}
		});
		Hatterkep_Keret.setLocation(0, 0);
		Hatterkep_Keret.setSize(Keret_Szeles,Keret_Magas+200);
		Hatterkep_Keret.setIcon(new ImageIcon(Keret.class.getResource("/Bloods/Hatterkep3.jpg")));
		Hatterkep_Keret.setVisible(true);
		keret.getContentPane().add(Hatterkep_Keret);
		keret.setAlwaysOnTop(true);
		keret.setAlwaysOnTop(false);
		Bejelentkezes.Login_Futtat();
		keret.setVisible(true);

		
	}
	public static void Start_Timer() {
    	pointerX= (int)MouseInfo.getPointerInfo().getLocation().getX();
    	pointerY=(int)MouseInfo.getPointerInfo().getLocation().getY();

		timer.cancel();
		timer=new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			
			
			@Override
			public void run() {
				int pointerX2= (int)MouseInfo.getPointerInfo().getLocation().getX();
             	int pointerY2=(int)MouseInfo.getPointerInfo().getLocation().getY();
             	if(pointerX2>pointerX) {
             		 keret.setLocation((int)keret.getLocation().getX()+(pointerX2-pointerX), (int)keret.getLocation().getY());
             		 pointerX=pointerX2;
             		 frameX=pointerX;
             	}else {
             		keret.setLocation((int)keret.getLocation().getX()-(pointerX-pointerX2), (int)keret.getLocation().getY());
            		 pointerX=pointerX2;
            		 frameX=pointerX;
             	}
             	if(pointerY2>pointerY) {
             		keret.setLocation((int)keret.getLocation().getX(), (int)keret.getLocation().getY()+(pointerY2-pointerY));
             		pointerY=pointerY2;
             		frameY=pointerY;
             	}else {
             		keret.setLocation((int)keret.getLocation().getX(), (int)keret.getLocation().getY()+(pointerY2-pointerY));
             		pointerY=pointerY2;
             		frameY=pointerY;
             	}
             	
            	 keret.setLocation((int)keret.getLocation().getX(), (int)keret.getLocation().getY());
				
				//keret.setLocation(Keret_Szeles, Keret_Magas);


				
				
			}
		}, 0, 10);
	}
	public static void Stop_Timer() {
		timer.cancel();
		timer=new Timer();
	}
}
