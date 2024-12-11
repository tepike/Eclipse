package Uj_Horgaszas;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class KepElemzes extends main{
	public static void Indul() {
		JLabel Elemzo_Bezaras_Label=new JLabel("X");
		Elemzo.setSize(200,200);
		Elemzo.setBounds((int)Keret.getLocation().getX()+Keret_szeles+100, (int)Keret.getLocation().getY(), 400, 400);
		Elemzo.setUndecorated(true);
		Elemzo.setBackground(new Color(200,200,200,50));
		Elemzo.setVisible(true);
		
		
		
	}

}
