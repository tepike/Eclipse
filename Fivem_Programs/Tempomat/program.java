package Tempomat;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.LayoutManager;
import java.awt.Panel;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.tree.AbstractLayoutCache;

import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;

public class program {
	public static JLabel szoveg=new JLabel("Nem fut");
	public static JFrame keret= new JFrame();
	public static JPanel panel= new JPanel();
	public static int fut=0;
	public static int szamolo=0;
	public static void main(String[] args) throws AWTException {
		keret.setLocation((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()/4, (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()-100);
		keret.setSize(90,30);
		keret.setUndecorated(true);
		panel.setSize(90,30);
		keret.setAlwaysOnTop(true);
		
		panel.add(szoveg);
		
		szoveg.setLocation(50,50);
		
		panel.setBackground(new Color(255,0,0));
		
		panel.setVisible(true);
		keret.add(panel);
		
		keret.setVisible(true);
		

		Robot robot= new Robot();
		Timer ido=new Timer();
		

	    try {
			GlobalScreen.registerNativeHook();
		} catch (NativeHookException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    GlobalScreen.addNativeKeyListener(new NativeKeyListener()
	    {

	        @Override
	        public void nativeKeyTyped(NativeKeyEvent e)
	        {
	        	
	        }

	        @Override
	        public void nativeKeyReleased(NativeKeyEvent e)
	        {
	            //String keyText=NativeKeyEvent.getKeyText(e.getKeyCode());
	            //System.out.println("User typed: "+keyText);
	        }

	        @Override
	        public void nativeKeyPressed(NativeKeyEvent e)
	        {
	        	
	        	//Feldolgozási adatok
	        	if(e.getKeyCode()==NativeKeyEvent.VC_PAGE_UP) {
	        		java.awt.Toolkit.getDefaultToolkit().beep();
	        		System.exit(0);
	        	}
	        	
	        	 if (e.getKeyCode() == NativeKeyEvent.VC_CONTROL) {
	        		 
	        		 Timer ido=new Timer();
	        		    ido.schedule(new TimerTask() {
							
							
							public void run() {
								if(fut==1) {


								try {
									szoveg.setText("Fut: "+szamolo);
									fut++;
									szamolo++;
									robot.mousePress(InputEvent.BUTTON2_DOWN_MASK);
									robot.keyPress(KeyEvent.VK_B);
									Thread.sleep(10);
									robot.keyRelease(KeyEvent.VK_B);
									robot.mouseRelease(InputEvent.BUTTON2_DOWN_MASK);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}


								
							}}
						}, 0,30);
	        		    if(fut==1) {
	        		    	
	        		    	panel.setBackground(new Color(0,255,0));
	        		    	java.awt.Toolkit.getDefaultToolkit().beep();
	        		    }
	        		        if(fut==2) {
	        		        	if(szamolo/2!=0) {
									try {
										
										robot.mousePress(InputEvent.BUTTON2_DOWN_MASK);
										robot.keyPress(KeyEvent.VK_B);
										Thread.sleep(10);
										robot.keyRelease(KeyEvent.VK_B);
										robot.mouseRelease(InputEvent.BUTTON2_DOWN_MASK);
									} catch (InterruptedException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
	        		        	}
	        		        	ido.cancel();
	        		        	fut=0;
		        		    	szoveg.setText("Nem fut: "+szamolo);
		        		    	panel.setBackground(new Color(255,0,0));
	        		        }
	        		        System.out.println("Elindult");
	        		        System.out.println(szamolo-1);
	        		    }
	        	 
		
		
	
	        };
	    });
	}}
	
