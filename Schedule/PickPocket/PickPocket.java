package PickPocket;
import java.awt.AWTException;
import java.awt.Color;
import java.awt.MouseInfo;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.time.LocalTime;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;


public class PickPocket {
	static boolean mehet=false;
	static Timer Ido = new Timer();
	static JFrame ablak = new JFrame();
	static JPanel szin= new JPanel();
    public static void main(String[] args) throws AWTException {

    	ablak.setSize(20,20);
    	ablak.setLocation((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()-25,5);
    	ablak.setUndecorated(true);
    	ablak.add(szin);
    	szin.setBounds(0, 0, 20, 20);
    	szin.setBackground(Color.red);
    	ablak.setAlwaysOnTop(true);
    	ablak.setTitle("Home|End");
    	
    	
    	ablak.setVisible(true);
    	ablak.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	
	    try {
			GlobalScreen.registerNativeHook();
		} catch (NativeHookException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	GlobalScreen.addNativeKeyListener(new NativeKeyListener() {
	        public void nativeKeyReleased(NativeKeyEvent e)
	        {
	            String keyText=NativeKeyEvent.getKeyText(e.getKeyCode());
	            //System.out.println("Lenyomott gomb: "+keyText+ " Kódja: "+e.getKeyCode());
	            if(keyText.equals("Home")) {
	            	//System.out.println("Home nyomva");
	            	mehet=!mehet;
	            	if(mehet) {
	            		try {
	            			Toolkit.getDefaultToolkit().beep();
							elemzes_indit();
							szin.setBackground(Color.green);
						} catch (AWTException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
	            	}
	            };
	            if(keyText.equals("End")) {
	            	Toolkit.getDefaultToolkit().beep();
	            	System.exit(0);
	            };
	        }
		});
    	

        
        
        // Eredmény megjelenítése

    }
    static void elemzes_indit() throws AWTException {
    	Robot robot = new Robot();

        TimerTask Folyamat_Elemzes= new TimerTask() {
			public void run() {
				//System.out.println("Fut "+LocalDateTime.now());
				if(mehet) {
					System.out.println("Program fut és elemez");
			        // Készítsünk egy robotot a képernyőképhez
			        
			        
			        // A képernyő teljes területét képezzük le
			        
			        
			        // Fekete-fehér képpé konvertálás
			        int Eger_x= (int)MouseInfo.getPointerInfo().getLocation().getX();
			        int Eger_y= (int)MouseInfo.getPointerInfo().getLocation().getY();
			        Color color = robot.getPixelColor(Eger_x, Eger_y);
			        
			        // Szürkeárnyalat számítása: egyszerű színátlagolás (R, G, B)
			        int gray = (int) (color.getRed() * 0.2 + color.getGreen() * 0.2 + color.getBlue() * 0.2);
			        
			        // Átváltás fekete-fehérre (fekete, ha szürkeérték kisebb, mint 128, fehér egyébként)
 			         if (gray < 128) {
			            System.out.println("Fekete: "+LocalTime.now());
			        } else {
			            System.out.println("Feher");
			            robot.keyPress(KeyEvent.VK_SPACE);
			            robot.keyRelease(KeyEvent.VK_SPACE);

			            mehet=!mehet;
 			             szin.setBackground(Color.red);
			            
			            
			        }
				}
				else {
					Ido.cancel();
					Ido.purge();
					Ido= new Timer();
					System.out.println("Megállt");
					Toolkit.getDefaultToolkit().beep();

					
							}
				}
		};
		 Ido.schedule(Folyamat_Elemzes, 10,1);
    }
}
