package ablak;

import  java.awt. *;  
import  java.awt.event.WindowEvent;  
import  java.awt.event.WindowListener;  
public class  WindowExample  extends   Frame  implements  WindowListener {   
	
	WindowExample () {  
        addWindowListener ( this );  
          
        setSize ( 400 , 400 );  
        setLayout ( null );  
        setVisible ( true ); 
        
    }  
	
      
public static void  main (String [] érvel) {    
    new  WindowExample ();  
}  
public void  windowActivated (WindowEvent arg0) {   
    System.out.println ( "Az ablak aktiválva" );  
}  
public void  windowClosed (WindowEvent arg0) {   
    System.out.println ( "Ablak bezárva" );  
}  
public void  windowClosing (WindowEvent arg0) {   
    System.out.println ( "Ablak bezárás alatt" );  
    dispose();  
}  
public void  windowDeactivated (WindowEvent arg0) {   
    System.out.println ( "Ablak aktiválásának megszűntetése" );  
}  
public void  windowDeiconified (WindowEvent arg0) {   
    
}  
public void  windowIconified (WindowEvent arg0) {   
}
public void  windowOpened (WindowEvent arg0) {   
    System.out.println ( "Ablak megnyitva" );  
}  
}
