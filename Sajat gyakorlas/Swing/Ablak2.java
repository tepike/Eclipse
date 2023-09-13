package Swing;

import java.awt.Color;
import java.awt.Font;
import java.awt.Panel;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;

public class Ablak2 {
	
	public static void main(String[]args) {
		System.out.print("Program elindult");		
		Boolean ablak_meretezes =true; //Ablak széthúzása
		
		Border keret= BorderFactory.createLineBorder(Color.yellow,5); //Keret hozzáadása valamihez és annak nagysága. | funkcio.setBorder(keret);
		
		JFrame panel= new JFrame();  //ablak létrehozása
		panel.setTitle("Vakablak");  //ablak fejléc neve
		panel.setDefaultCloseOperation(panel.EXIT_ON_CLOSE); // panel.EXIT_ON_CLOSE - bezárja a kilépéssel | panel.HIDE_ON_CLOSE - elrejti | DO_NOTHING_ON_CLOSE - nem engedi bezárni
		panel.setResizable(ablak_meretezes);
		panel.setSize(800,800); //ablak megnyitási mérete szélesség/magasság
		panel.setLayout(null); // Funkció behatárolása, hogy ne fedjen mindent
		// panel.pack();  | Behatárol mindent magának
		
				
		ImageIcon icon = new ImageIcon("Logo.png"); // Logo neve ha egy könyvtárban van vagy elérési útvonal
		panel.setIconImage(icon.getImage());		
		panel.getContentPane().setBackground(Color.cyan); //Háttér alap változtatás
		//panel.getContentPane().setBackground(new Color(0,100,255)); //Háttér alap változtatás RGB kóddal
		
		
		//new Ablak2_Frame();
		 
		
		
		ImageIcon image= new ImageIcon("Logo.png"); //Kép beszúrása
		
		JLabel funkcio = new JLabel(); //label= címke létrehozás |     JLabel funkcio = new JLabel("Minta szöveg");
		funkcio.setText("Ez itt a reklám helye"); //címke szövegének szerkesztése		panel.add(funkcio);
		funkcio.setHorizontalTextPosition(funkcio.CENTER); // funkcio.CENTER | LEFT | RIGHT | az iconhoz képest
		funkcio.setVerticalTextPosition(funkcio.TOP); // TOP | CENTER | BOTTOM az iconhoz képest
		funkcio.setIcon(image);
		funkcio.setForeground(new Color(255,0,0)); // Címke színének megadása.
		funkcio.setFont(new Font("MV Boli", Font.PLAIN,20)); // Címke betűtípusa, méretének megadása.
		funkcio.setIconTextGap(-50); //Címke távolsága az icontól
		funkcio.setBackground(Color.green); //Háttér megváltoztatása
		funkcio.setOpaque(true); //Háttér láthatóvá tétele
		funkcio.setBorder(keret);
		funkcio.setVerticalAlignment(JLabel.CENTER); //Funkció elhelyezése fentről le
		funkcio.setHorizontalAlignment(JLabel.CENTER); //Funkció elhelyezése balról jobbra
		funkcio.setBounds(100, 100, 300, 300); //Elhelyezés és méret behatárolása
		 
		
		
		
		
		
		panel.add(funkcio);
		panel.setVisible(true); //ablak láthatósága
	}
	
}
