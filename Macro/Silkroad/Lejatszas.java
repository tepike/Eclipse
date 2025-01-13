package Silkroad;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public class Lejatszas {
	
	static Timer Ido=new Timer();
	public static int Kovetkezo=100;
	public static Robot robot;
	static int Osszes_Lenyomando_Gomb;
	public static int Index=0;
	public static final Map<String, Integer> keyMap = new HashMap<>();
    static {

    	keyMap.put("1", KeyEvent.VK_1);
    	keyMap.put("2", KeyEvent.VK_2);
    	keyMap.put("3", KeyEvent.VK_3);
    	keyMap.put("4", KeyEvent.VK_4);
    	keyMap.put("5", KeyEvent.VK_5);
    	keyMap.put("6", KeyEvent.VK_6);
    	keyMap.put("7", KeyEvent.VK_7);
    	keyMap.put("8", KeyEvent.VK_8);
    	keyMap.put("9", KeyEvent.VK_9);
    	keyMap.put("0", KeyEvent.VK_0);

    	keyMap.put("A", KeyEvent.VK_A);
    	keyMap.put("B", KeyEvent.VK_B);
    	keyMap.put("C", KeyEvent.VK_C);
    	keyMap.put("D", KeyEvent.VK_D);
    	keyMap.put("E", KeyEvent.VK_E);
    	keyMap.put("F", KeyEvent.VK_F);
    	keyMap.put("G", KeyEvent.VK_G);
    	keyMap.put("H", KeyEvent.VK_H);
    	keyMap.put("I", KeyEvent.VK_I);
    	keyMap.put("J", KeyEvent.VK_J);
    	keyMap.put("K", KeyEvent.VK_K);
    	keyMap.put("L", KeyEvent.VK_L);
    	keyMap.put("M", KeyEvent.VK_M);
    	keyMap.put("N", KeyEvent.VK_N);
    	keyMap.put("O", KeyEvent.VK_O);
    	keyMap.put("P", KeyEvent.VK_P);
    	keyMap.put("Q", KeyEvent.VK_Q);
    	keyMap.put("R", KeyEvent.VK_R);
    	keyMap.put("S", KeyEvent.VK_S);
    	keyMap.put("T", KeyEvent.VK_T);
    	keyMap.put("U", KeyEvent.VK_U);
    	keyMap.put("V", KeyEvent.VK_V);
    	keyMap.put("W", KeyEvent.VK_W);
    	keyMap.put("X", KeyEvent.VK_X);
    	keyMap.put("Y", KeyEvent.VK_Y);
    	keyMap.put("Z", KeyEvent.VK_Z);

    	keyMap.put("ENTER", KeyEvent.VK_ENTER);
    	keyMap.put("SPACE", KeyEvent.VK_SPACE);
    	keyMap.put("TAB", KeyEvent.VK_TAB);
    	keyMap.put("ESCAPE", KeyEvent.VK_ESCAPE);
    	keyMap.put("BACKSPACE", KeyEvent.VK_BACK_SPACE);
    	keyMap.put("SHIFT", KeyEvent.VK_SHIFT);
    	keyMap.put("CONTROL", KeyEvent.VK_CONTROL);
    	keyMap.put("ALT", KeyEvent.VK_ALT);

    	keyMap.put("LEFT", KeyEvent.VK_LEFT);
    	keyMap.put("RIGHT", KeyEvent.VK_RIGHT);
    	keyMap.put("UP", KeyEvent.VK_UP);
    	keyMap.put("DOWN", KeyEvent.VK_DOWN);

    	keyMap.put("F1", KeyEvent.VK_F1);
    	keyMap.put("F2", KeyEvent.VK_F2);
    	keyMap.put("F3", KeyEvent.VK_F3);
    	keyMap.put("F4", KeyEvent.VK_F4);
    	keyMap.put("F5", KeyEvent.VK_F5);
    	keyMap.put("F6", KeyEvent.VK_F6);
    	keyMap.put("F7", KeyEvent.VK_F7);
    	keyMap.put("F8", KeyEvent.VK_F8);
    	keyMap.put("F9", KeyEvent.VK_F9);
    	keyMap.put("F10", KeyEvent.VK_F10);
    	keyMap.put("F11", KeyEvent.VK_F11);
    	keyMap.put("F12", KeyEvent.VK_F12);

    	keyMap.put("INSERT", KeyEvent.VK_INSERT);
    	keyMap.put("DELETE", KeyEvent.VK_DELETE);
    	keyMap.put("HOME", KeyEvent.VK_HOME);
    	keyMap.put("END", KeyEvent.VK_END);
    	keyMap.put("PAGE_UP", KeyEvent.VK_PAGE_UP);
    	keyMap.put("PAGE_DOWN", KeyEvent.VK_PAGE_DOWN);

    	keyMap.put("NUMPAD0", KeyEvent.VK_NUMPAD0);
    	keyMap.put("NUMPAD1", KeyEvent.VK_NUMPAD1);
    	keyMap.put("NUMPAD2", KeyEvent.VK_NUMPAD2);
    	keyMap.put("NUMPAD3", KeyEvent.VK_NUMPAD3);
    	keyMap.put("NUMPAD4", KeyEvent.VK_NUMPAD4);
    	keyMap.put("NUMPAD5", KeyEvent.VK_NUMPAD5);
    	keyMap.put("NUMPAD6", KeyEvent.VK_NUMPAD6);
    	keyMap.put("NUMPAD7", KeyEvent.VK_NUMPAD7);
    	keyMap.put("NUMPAD8", KeyEvent.VK_NUMPAD8);
    	keyMap.put("NUMPAD9", KeyEvent.VK_NUMPAD9);

    	keyMap.put("MULTIPLY", KeyEvent.VK_MULTIPLY);
    	keyMap.put("ADD", KeyEvent.VK_ADD);
    	keyMap.put("SUBTRACT", KeyEvent.VK_SUBTRACT);
    	keyMap.put("DECIMAL", KeyEvent.VK_DECIMAL);
    	keyMap.put("DIVIDE", KeyEvent.VK_DIVIDE);

    	keyMap.put("COMMA", KeyEvent.VK_COMMA);
    	keyMap.put("PERIOD", KeyEvent.VK_PERIOD);
    	keyMap.put("MINUS", KeyEvent.VK_MINUS);
    	keyMap.put("PLUS", KeyEvent.VK_PLUS);
    	keyMap.put("SLASH", KeyEvent.VK_SLASH);
    	keyMap.put("SEMICOLON", KeyEvent.VK_SEMICOLON);
    	keyMap.put("EQUALS", KeyEvent.VK_EQUALS);

        // Add hozzá az összes szükséges gombot!
    }
	
	public static void Lejatszas_Indit() {
		System.out.println("Lejatszasi ido elindult");
		Index=0;
		
		
		if(Felvetel.Macro_indithato) {
			Osszes_Lenyomando_Gomb=Main.Felvett_macro_Skill_megjelenit.size()-1;
			Main.Inditas_Label.setForeground(Color.green);
	    	Felvetel.Felvett_Gombok.repaint();
	    	Main.frame.repaint(); 
			
		try {
			 robot = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    Ido.scheduleAtFixedRate(new TimerTask() {
	        @Override
	        public void run() {
	        	//System.err.println("\nValami ellenorzes a gobra, hogy frissül-é?: "+Main.Rogzites.get(Index).getGomb()+"\n"+"Index: "+Index);
            	String eldobos=Main.Felvett_macro_Ido_megjelenit.get(Index).getText();
            	double eldobos_int=Double.parseDouble(eldobos);
            	eldobos_int=eldobos_int*1000;
            	Kovetkezo=((int)eldobos_int);
	        	
	        	Integer keyCode = keyMap.get((Main.Felvett_macro_Skill_megjelenit.get(Index).getText()));
	        	Main.Felvett_macro_Skill_megjelenit.get(Index).setForeground(Color.green);
    	    	Felvetel.Felvett_Gombok.repaint();
    	    	Main.frame.repaint(); 
	        	robot.keyPress(keyCode);
            	try {
            		System.out.println("Thread ido: "+Kovetkezo);
					Thread.sleep(Kovetkezo);

					robot.keyRelease(keyCode);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            	
            	//Ez a késleltetés helyileg elhelyezve még kétes


            	//System.out.println(eldobos);
            	//System.err.println("Gomb: "+Main.Rogzites.get(Index).getGomb()+" \tAdando kesleltetes: "+(eldobos_int));

            	
            	Index++;
            	Main.Felvett_macro_Skill_megjelenit.get(Index-1).setForeground(Color.red);
    	    	Felvetel.Felvett_Gombok.repaint();
    	    	Main.frame.repaint(); 
            	
            	if(Index>Osszes_Lenyomando_Gomb) {
            		Index=0;
            	}
            	if(!Main.fut) {
            		System.err.println("Main.fut "+Main.fut +"miatt leáll");
            		Ido.cancel();
            		Ido = new Timer();}
    	    	Felvetel.Felvett_Gombok.repaint();
    	    	Main.frame.repaint(); 

	        	
	        }
	    }, 0, 100);
		
		
	}

	
	

}
}
