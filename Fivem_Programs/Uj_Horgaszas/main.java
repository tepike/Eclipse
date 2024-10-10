package Uj_Horgaszas;

import java.awt.Color;
import java.awt.Font;
import java.awt.MouseInfo;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;

import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;

public class main {
	static JFrame Keret = new JFrame();
	static JLabel Label1 = new JLabel("Horgászbot:");
	static JLabel Label1_gomb = new JLabel("Click");
	static int figyelo=0;
	static JLabel Label1_seged = new JLabel("Nyomd meg a használni kívánt gombot");

	static JLabel Bezaras_Label=new JLabel("X");
	static int Keret_szeles=700;
	static int Keret_magas=500;
	
	static int pointerX = (int)MouseInfo.getPointerInfo().getLocation().getX();
	static int pointerY = (int)MouseInfo.getPointerInfo().getLocation().getY();
	static Timer timer2 = new Timer();

	public static void main(String[] args) {
		

		Keret.setSize(Keret_szeles, Keret_magas);
		Keret.setLocationRelativeTo(null);
		Keret.setUndecorated(true);
		Keret.setDefaultCloseOperation(Keret.EXIT_ON_CLOSE);
		Keret.setAlwaysOnTop(true);

		Keret.setLayout(null);
		Keret.setResizable(false);
		Keret.setBackground(new Color(100,100,100,200));
		
		Horgaszbot_Felirat();
		

		
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
	    static void Horgaszbot_Felirat() {
			Keret.add(Label1);
			Keret.add(Label1_gomb);
			Keret.add(Label1_seged);
			//Horgászbot felirat
			Label1.setFont(new Font("Arial Bold", 0, 25));
			Label1.setForeground(Color.white);
			Label1.setBounds(30, 50, Label1.getText().length()*14, 25);
			Label1.setVisible(true);
			//Nyomandó gomb
			Label1_gomb.setFont(new Font("Arial Bold", 0, 25));
			Label1_gomb.setForeground(Color.white);
			Label1_gomb.setBounds((int)Label1.getLocation().getX()+Label1.getWidth()+5, 45, Label1_gomb.getText().length()*14, 35);
			Label1_gomb.setBorder(BorderFactory.createRaisedBevelBorder());
			
			Label1_seged.setFont(new Font("Arial Bold", 0, 22));
			Label1_seged.setForeground(Color.yellow);
			Label1_seged.setBounds((int)Label1_gomb.getLocation().getX()+Label1_gomb.getWidth()+10, 50, Label1_seged.getText().length()*14, 25);
			Label1_seged.setVisible(false);
			
			 try {
					GlobalScreen.registerNativeHook();
				} catch (NativeHookException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    
			
			Label1_gomb.addMouseListener(new MouseListener() {
				
				
				@Override
				public void mouseReleased(MouseEvent e) {
					
					System.out.println("Kattintva");
					Label1_seged.setVisible(true);
					figyelo++;
					if(figyelo==1) {
					GlobalScreen.addNativeKeyListener(new NativeKeyListener()
				    {

				        @Override
				        public void nativeKeyTyped(NativeKeyEvent e)
				        {
				        	
				        }

				        @Override
				        public void nativeKeyReleased(NativeKeyEvent e)
				        {
				        	if(figyelo==1) {
				            String keyText=NativeKeyEvent.getKeyText(e.getKeyCode());
				            System.out.println("User typed: "+keyText);
				            Label1_gomb.setText(keyText);
				            //Label1_gomb.setAlignmentX(0);
				            
				            
				            System.out.println(figyelo);
				            figyelo=0;
				        	}
				            
				        }

				        @Override
				        public void nativeKeyPressed(NativeKeyEvent e)
				        {
				        	
				        }
				    });
					}
					
				}
				
				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseExited(MouseEvent e) {
					Label1_seged.setVisible(false);
					
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
			
			
			Label1_gomb.setVisible(true);
			
	    }
        
        
}

