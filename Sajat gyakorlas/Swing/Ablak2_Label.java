package Swing;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.Border;

public class Ablak2_Label extends JLabel{
	Ablak2_Label(){
		ImageIcon image= new ImageIcon("Logo.png"); //Kép beszúrása
		Border keret= BorderFactory.createLineBorder(Color.yellow,5); //Keret hozzáadása valamihez és annak nagysága. | funkcio.setBorder(keret);

		this.setText("Ez itt a reklám helye"); //címke szövegének szerkesztése		panel.add(this);
		this.setHorizontalTextPosition(this.CENTER); // this.CENTER | LEFT | RIGHT | az iconhoz képest
		this.setVerticalTextPosition(this.TOP); // TOP | CENTER | BOTTOM az iconhoz képest
		this.setIcon(image);
		this.setForeground(new Color(255,0,0)); // Címke színének megadása.
		this.setFont(new Font("MV Boli", Font.PLAIN,20)); // Címke betűtípusa, méretének megadása.
		this.setIconTextGap(-50); //Címke távolsága az icontól
		this.setBackground(Color.green); //Háttér megváltoztatása
		this.setOpaque(true); //Háttér láthatóvá tétele
		this.setBorder(keret);
		this.setVerticalAlignment(JLabel.CENTER); //Funkció elhelyezése fentről le
		this.setHorizontalAlignment(JLabel.CENTER); //Funkció elhelyezése balról jobbra
		this.setBounds(0, 0, 300, 300); //Elhelyezés és méret behatárolása
		
		 
	}

}
