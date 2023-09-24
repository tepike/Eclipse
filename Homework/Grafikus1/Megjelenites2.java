package Grafikus1;
import javax.swing.*;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Megjelenites2 extends JFrame {

    private JTextArea Szovegdoboz;

    Megjelenites2() {


        setSize(400, 500);
        setLayout(null);
        setResizable(false);
        getContentPane().setBackground(new Color(0,150,20));
        //getContentPane().setBackground(Color.red);
        
        
        setLocation(400,100);
        setTitle("Fejléc neve");
        

        
        JButton backBtn = new JButton("Back");
        backBtn.setBounds(10, 300, 100, 40);
        add(backBtn);
        
        backBtn.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e) {
        		Szovegdoboz.setText("Lofaszka");
        	};
        });


        Szovegdoboz = new JTextArea();
        Szovegdoboz.setBounds(30, 50, 300, 200);
        Szovegdoboz.setEditable(false);
        Szovegdoboz.setText("Versenyzők beolvasásához kattints a tovább gombra");
        add(Szovegdoboz);
        
        setVisible(true);
    
    }





    public static void main(String[] args) {
    	new Megjelenites2();
    }

}
