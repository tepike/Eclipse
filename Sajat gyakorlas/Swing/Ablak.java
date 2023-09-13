package Swing;

import java.awt.*;
import javax.swing.*;
public class Ablak extends JFrame{
JFrame f;
Ablak(){
	
JButton b=new JButton("click");
b.setBounds(130,100,100, 40);
add(b);

JButton c=new JButton("click2");
c.setBounds(0,50,100, 20); //Balról, fentről, keret szélesség, magasság
add(c);

setSize(400,500);
setLayout(null);
setVisible(true);
}

public static void main(String[] args) {
new Ablak();
}
}

/*


package Swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class Ablak extends JFrame{
JFrame f;
Ablak(){
	
JButton b=new JButton("click");
b.setBounds(130,100,100, 40);
		
add(b);
		
setSize(400,500);
setLayout(null);
setVisible(true);
}

public static void main(String[] args) {  
    JFrame f=new JFrame("Button Example");  
    final JTextField tf=new JTextField();  
    tf.setBounds(50,50, 150,20);  
    JButton b=new JButton("Click Here");  
    b.setBounds(50,100,95,30);  
    b.addActionListener((ActionListener) new ActionListener(){  
public void actionPerformed(ActionEvent e){  
            tf.setText("Welcome to Javatpoint.");  
        }  
    });  
    f.add(b);f.add(tf);  
    f.setSize(400,400);  
    f.setLayout(null);  
    f.setVisible(true);   
}  
}  

*/