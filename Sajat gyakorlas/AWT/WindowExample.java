package AWT;
import java.awt.*;    
import java.awt.event.WindowEvent;    
import java.awt.event.WindowListener;    
  
// class which inherits Frame class and implement the WindowListener interface  
public class WindowExample extends Frame implements WindowListener {    
// constructor  
    WindowExample() {    
// adding WindowListener to frame  
        addWindowListener(this);    
     
// setting the size, layout and visibility of frame  
        setSize(400,400);    
        setLayout(null);    
        setVisible(true);    
    }    
        
// main method  
public static void main(String[] args) {    
    new WindowExample();    
}    
public void windowActivated(WindowEvent e) {}    
public void windowClosed(WindowEvent e) {}    
public void windowClosing(WindowEvent e) {    
    dispose();    
}    
public void windowDeactivated(WindowEvent e) {}    
public void windowDeiconified(WindowEvent e) {}    
public void windowIconified(WindowEvent e) {}    
public void windowOpened(WindowEvent arg0) {}    
}    