package Uj_Horgaszas;

import java.awt.Color;
import java.awt.Font;
import java.awt.MouseInfo;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class main {
	public static JFrame Keret = new JFrame();
	public static JPanel Panel= new JPanel();
	public static JLabel Bezaras_Label=new JLabel("X");
	static int Kep_szeles;
	static int Kep_magas;
	static int Keret_szeles=500;
	static int Keret_magas=500;
	
	static int pointerX = (int)MouseInfo.getPointerInfo().getLocation().getX();
	static int pointerY = (int)MouseInfo.getPointerInfo().getLocation().getY();
	static Timer timer2 = new Timer();

	public static void main(String[] args) {
		
		Kep_szeles=(int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2;
		Kep_magas=(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()/2;
		Keret.setBounds(Kep_szeles-Keret_szeles/2,Kep_magas-Keret_magas/2,Keret_szeles,Keret_magas);
		Keret.setUndecorated(true);
		Keret.setDefaultCloseOperation(Keret.EXIT_ON_CLOSE);
		Keret.setAlwaysOnTop(true);
		Keret.add(Panel);
		Keret.setLayout(null);
		Keret.setResizable(false);
		Keret.setBackground(new Color(100,100,100,200));
		
		Panel.setBounds(10,50,50,50);
		Panel.setLayout(null);
		Panel.setBackground(new Color(200,200,200,100));
		
		//Bezárási label megalkotása
		Bezaras_Label.setBounds(Keret.getWidth()-25,5,20,20);
		Bezaras_Label.setFont(new Font("Arial Black", Font.BOLD, 20));
		Bezaras_Label.setVisible(true);

		Keret.getContentPane().addMouseListener(new MouseAdapter() {
	        	@Override
	        	public void mousePressed(MouseEvent e) {
	        		if(e.getButton()==MouseEvent.BUTTON1) {
	        			panelmozgat();
	        		}
	        		
	        	}
	        	@Override
	        	public void mouseReleased(MouseEvent e) {
	        		if(e.getButton()==MouseEvent.BUTTON1) {
	        			panelleark();
	        		}
	        		
	        	}
	        
	        });
		
		Keret.add(Bezaras_Label);
		
		Keret.setVisible(true);
		Panel.setVisible(true);
		Bezaras_Label.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				System.exit(0);
				
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
		}) ;}
		
	    //Panel mozgatása ha lenyomva van az egér
	    public static void panelmozgat() {
	    	 pointerX = (int)MouseInfo.getPointerInfo().getLocation().getX();
	    	 pointerY = (int)MouseInfo.getPointerInfo().getLocation().getY();
	    	 timer2 = new Timer();
	    	 timer2.scheduleAtFixedRate(new TimerTask() {
	    		 int i =0;
	    		 
	             @Override
	             public void run() {
	            	int pointerX2= (int)MouseInfo.getPointerInfo().getLocation().getX();
	             	int pointerY2=(int)MouseInfo.getPointerInfo().getLocation().getY();
	             	if(pointerX2>pointerX) {
	             		 Keret.setLocation((int)Keret.getLocation().getX()+(pointerX2-pointerX), (int)Keret.getLocation().getY());
	             		 pointerX=pointerX2;
	             	}else {
	             		Keret.setLocation((int)Keret.getLocation().getX()-(pointerX-pointerX2), (int)Keret.getLocation().getY());
	            		 pointerX=pointerX2;
	             	}
	             	if(pointerY2>pointerY) {
	             		Keret.setLocation((int)Keret.getLocation().getX(), (int)Keret.getLocation().getY()+(pointerY2-pointerY));
	             		pointerY=pointerY2;
	             	}else {
	             		Keret.setLocation((int)Keret.getLocation().getX(), (int)Keret.getLocation().getY()+(pointerY2-pointerY));
	             		pointerY=pointerY2;
	             	}
	             	
	            	 System.out.println(i);
	            	 i++;
	            	 Keret.setLocation((int)Keret.getLocation().getX(), (int)Keret.getLocation().getY());
	                 
	                 
	             }
	         },0, 10);
	    
	}
	    public static void panelleark() {
			timer2.cancel();
	    	timer2=new Timer();
	    
	    }

        
        
}

