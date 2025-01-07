package Silkroad;

import java.awt.MouseInfo;
import java.awt.event.MouseListener;
import java.util.Timer;
import java.util.TimerTask;

public class Panel_Mozgatas extends Main{
	static Timer Ido=new Timer();
	static int pointerX= (int)MouseInfo.getPointerInfo().getLocation().getX();
	static int pointerY=(int)MouseInfo.getPointerInfo().getLocation().getY();
	
	public static void Mozgatas_be() {
		pointerX= (int)MouseInfo.getPointerInfo().getLocation().getX();
		pointerY=(int)MouseInfo.getPointerInfo().getLocation().getY();
    	
    	Ido.scheduleAtFixedRate(new TimerTask() {
    		 int i =0;
    		 
             @Override
             public void run() {
            	int pointerX2= (int)MouseInfo.getPointerInfo().getLocation().getX();
             	int pointerY2=(int)MouseInfo.getPointerInfo().getLocation().getY();
             	if(pointerX2>pointerX) {
             		Main.frame.setLocation((int)Main.frame.getLocation().getX()+(pointerX2-pointerX), (int)Main.frame.getLocation().getY());
             		 pointerX=pointerX2;
             	}else {
             		Main.frame.setLocation((int)Main.frame.getLocation().getX()-(pointerX-pointerX2), (int)Main.frame.getLocation().getY());
            		 pointerX=pointerX2;
             	}
             	if(pointerY2>pointerY) {
             		Main.frame.setLocation((int)Main.frame.getLocation().getX(), (int)Main.frame.getLocation().getY()+(pointerY2-pointerY));
             		pointerY=pointerY2;
             	}else {
             		Main.frame.setLocation((int)Main.frame.getLocation().getX(), (int)Main.frame.getLocation().getY()+(pointerY2-pointerY));
             		pointerY=pointerY2;
             	}
             	
            	 //System.out.println(i);
            	 i++;
            	 Main.frame.setLocation((int)Main.frame.getLocation().getX(), (int)Main.frame.getLocation().getY());
                 
                 
             }
         },0, 5);
		
	}
	
	public static void Mozgatas_ki() {
		//System.out.println("Ido figyeles lekapcsolas");
		Ido.cancel();
		Ido = new Timer();
		
	}

}
