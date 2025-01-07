package Program;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Font;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;


public class Minecraft implements NativeKeyListener{


        
    static boolean Fut=false;
    static int Fut_Szam=0;
	static Timer figyeles = new Timer();
	static JFrame keret= new JFrame();
	static JLabel Szoveg1= new JLabel("Nem fut");
	static JTextField Gyorsasag=new JTextField("700");
	static int Speed=700;
	static JLabel kilepes=new JLabel("X");
	static String Gyorsgomb="Caps Lock";
	static JCheckBox gomb=new JCheckBox();
	static int AntiCheat=0;
	 
	

	public static void main(String[] args) {
		
		
		keret.setLocation((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()-260,50);
		keret.setSize(250,50);
		keret.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		keret.setAlwaysOnTop(true);
		keret.setUndecorated(true);
		keret.setBackground(new Color(100,100,100,200));
		keret.setLayout(null);
		Szoveg1.setBounds(10, 10, 90, 30);
		Szoveg1.setFont(new Font("Arial Black", 0, 20));
		Szoveg1.setForeground(Color.yellow);
		Gyorsasag.setBounds(120, 10, 60, 30);
		Gyorsasag.setHorizontalAlignment(JTextField.CENTER);
		Gyorsasag.setFont(new Font("Arial Black", 0, 20));
		kilepes.setBounds(220, 5, 40, 30);
		kilepes.setFont(new Font("Arial Black", 0, 20));
		kilepes.setForeground(Color.red);
		kilepes.addMouseListener(new MouseListener() {
			
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
		});
		gomb.setBounds(190, 15, 20, 20);
		gomb.setBackground(new Color(100,100,100,200));
		keret.add(gomb);
		keret.add(kilepes);
		keret.add(Gyorsasag);
		keret.add(Szoveg1);
		keret.setVisible(true);
		

		try {
			GlobalScreen.registerNativeHook();
		} catch (NativeHookException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		GlobalScreen.addNativeKeyListener(new NativeKeyListener() {
	        public void nativeKeyTyped(NativeKeyEvent e)
	        {
	        	
	        }

	        @Override
	        public void nativeKeyReleased(NativeKeyEvent e)
	        {
	        	
	            String keyText=NativeKeyEvent.getKeyText(e.getKeyCode());
	            System.out.println("User typed: "+keyText);
	            
	            if(keyText.equals(Gyorsgomb)) {
	            	AntiCheat=0;
	            	Toolkit.getDefaultToolkit().beep();
	            	System.err.println(Gyorsasag.getText());
	            	Speed=Integer.parseInt(Gyorsasag.getText());
	            	Szoveg1.setText("Fut");
	            	Szoveg1.setForeground(Color.green);
	            	Fut_Szam++;
	    		figyeles.scheduleAtFixedRate(new TimerTask() {
	    			public void run() {
	    	            if(keyText.equals(Gyorsgomb)&Fut&Fut_Szam>1) {
	    	            	System.out.println("Kattintas megall");
	    	            	figyeles.cancel();
	    	            	figyeles.purge();
	    	            	figyeles = new Timer();
	    	            	Fut=false;
	    	            	Fut_Szam=0;
	    	            	Szoveg1.setText("Nem fut");
	    	            	Szoveg1.setForeground(Color.yellow);
	    	            	Toolkit.getDefaultToolkit().beep();
	    	            }
	    	            if(Fut&!gomb.isSelected()) {
	    	            	Robot robot = null;
							try {
								robot = new Robot();
							} catch (AWTException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
	    	            	System.out.println("Kattint");
	    	            	//robot.mousePress(InputEvent.BUTTON3_MASK);
	    	            	robot.keyPress(KeyEvent.VK_0);
	    	            	try {
								Thread.sleep(10);
								//robot.mouseRelease(InputEvent.BUTTON3_MASK);
								robot.keyPress(KeyEvent.VK_0);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
	    	            }
	    	            if(Fut&gomb.isSelected()) {
	    	            	AntiCheat++;
	    	            	if(AntiCheat==20) {
	    	            		
	    	            		Speed=Integer.parseInt(Gyorsasag.getText());
	    	            		Speed=Speed+1000;
	    	            		Gyorsasag.setText(Integer.toString(Speed));
	    	            		System.err.println(Speed);
	    	            	}
	    	            	if(AntiCheat==21) {
	    	            		
	    	            		Speed=Integer.parseInt(Gyorsasag.getText());
	    	            		Speed=Speed-1000;
	    	            		if(Speed<0) {
	    	            			Speed=100;
	    	            		}
	    	            		Gyorsasag.setText(Integer.toString(Speed));
	    	            		AntiCheat=0;
	    	            		System.err.println(Speed);
	    	            	}

	    	            	Robot robot = null;
							try {
								robot = new Robot();
							} catch (AWTException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
	    	            	System.out.println("Kattint");
	    	            	robot.mousePress(InputEvent.BUTTON1_MASK);
	    	            	try {
								Thread.sleep(10);
								robot.mouseRelease(InputEvent.BUTTON1_MASK);

							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
		    				try {
								Thread.sleep(Speed);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
	    	            }
	    	            		

	    				}
	    			}, 0, Speed);
	    		Fut=true;
	            }

	            
	        }

	        @Override
	        public void nativeKeyPressed(NativeKeyEvent e)
	        {
	        	
	        }
			
		}
		
				
				);
		
	

}}





