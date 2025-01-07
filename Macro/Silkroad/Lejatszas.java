package Silkroad;

import java.awt.AWTException;
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
	static int Index=0;
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
        keyMap.put("ENTER", KeyEvent.VK_ENTER);
        // Add hozzá az összes szükséges gombot!
    }
	
	public static void Lejatszas_Indit() {
		
		
		if(Felvetel.Macro_indithato) {
			Osszes_Lenyomando_Gomb=Main.Felvett_macro_Skill_megjelenit.size()-1;
			
		try {
			 robot = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    Ido.scheduleAtFixedRate(new TimerTask() {
	        @Override
	        public void run() {
	        	System.err.println("\nValami ellenorzes a gobra, hogy frissül-é?: "+Main.Rogzites.get(Index).getGomb()+"\n"+"Index: "+Index);
	        	
	        	Integer keyCode = keyMap.get((Main.Felvett_macro_Skill_megjelenit.get(Index).getText()));
	        	robot.keyPress(keyCode);
            	try {
					Thread.sleep(Kovetkezo);

					robot.keyRelease(keyCode);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            	
            	//Ez a késleltetés helyileg elhelyezve még kétes

            	String eldobos=Main.Felvett_macro_Ido_megjelenit.get(Index).getText();
            	//System.out.println(eldobos);
            	double eldobos_int=Double.parseDouble(eldobos);
            	
            	System.err.println("Gomb: "+Main.Rogzites.get(Index).getGomb()+" \tAdando kesleltetes: "+(eldobos_int));
            	eldobos_int=eldobos_int*1000;
            	Kovetkezo=((int)eldobos_int);
            	
            	Index++;
            	
            	if(Index>Osszes_Lenyomando_Gomb) {
            		Index=0;
            	}
            	if(!Main.fut) {
            		Ido.cancel();
            		Ido = new Timer();}

	        	
	        }
	    }, 0, 100);
		
		
	}

	
	

}
}
