package Swing;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.Color;
public class Ablak2_Frame extends JFrame {
	
	Ablak2_Frame(){
	Boolean ablak_meretezes =true; //Ablak széthúzása
	this.setTitle("Vakablak");  //ablak fejléc neve
	this.setDefaultCloseOperation(this.EXIT_ON_CLOSE); // this.EXIT_ON_CLOSE - bezárja a kilépéssel | this.HIDE_ON_CLOSE - elrejti | DO_NOTHING_ON_CLOSE - nem engedi bezárni
	this.setResizable(ablak_meretezes);
	
	
	
	this.setSize(800,800); //ablak megnyitási mérete szélesség/magasság
	this.setVisible(true); //ablak láthatósága
	
	ImageIcon icon = new ImageIcon("Logo.png"); // Logo neve ha egy könyvtárban van vagy elérési útvonal
	this.setIconImage(icon.getImage());
	
	this.getContentPane().setBackground(Color.cyan); //Háttér alap változtatás
	//this.getContentPane().setBackground(new Color(0,100,255)); //Háttér alap változtatás RGB kóddal

	
}
}
