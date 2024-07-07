package Aim;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.github.kwhat.jnativehook.GlobalScreen;

public class Futtatas {
	static int kepernyo_szeles;
	static int kepernyo_magas;
	static int kepernye_szeles_elemez=0;
	static int kepernyo_magas_elemez=0;
	static int tombmeret;
	static int leptek;
	public static void main(String[] args) throws AWTException, InterruptedException {
		kepernyo_szeles=(int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		kepernyo_magas=(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		tombmeret=kepernyo_magas*kepernyo_magas*2;
		int Pixelcsoport1 []= new int[tombmeret];
		Robot robot = new Robot();
		leptek= kepernyo_szeles%100;
		
		BufferedImage screeshot= robot.createScreenCapture(new Rectangle(kepernyo_szeles, kepernyo_magas));
		JFrame keret = new JFrame();
		keret.setBounds(0, 0, kepernyo_szeles, kepernyo_magas);
		
		keret.setUndecorated(true);
		keret.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		keret.setBackground(new Color(255, 255, 255, 255));
		
		keret.setVisible(true);
		JPanel kepkocka= new JPanel();
		kepkocka.setBounds(100, 100, 5, 5);
		kepkocka.setBackground(Color.red);
		
		keret.add(kepkocka);
		
		kepkocka.setVisible(true);
		for(int i=0;i!=kepernyo_szeles+1;) {
			
			Thread.sleep(100);
			kepkocka.setBounds(i, kepernyo_magas_elemez, 100, 200);
			Color pixelkeres = new Color(screeshot.getRGB(i, kepernyo_magas_elemez));
			Pixelcsoport1[i]=pixelkeres.getRed();
			System.err.println("Tomb kiiratas "+Pixelcsoport1[i]+" "+i);
			
			if(i==kepernyo_szeles-1) {
				kepernyo_magas_elemez=kepernyo_magas_elemez+200;
				i=0;
				System.out.println("if 1");
				
				if(kepernyo_magas_elemez==kepernyo_magas) {
					System.out.println("For ciklus megallitas mert ki elemezte a kepet");
					System.out.println(kepernyo_magas_elemez);
					keret.setVisible(false);
					break;
				}
				kepernyo_magas_elemez++;
				
				
			}
			if(kepernyo_magas_elemez==kepernyo_magas) {
				kepernye_szeles_elemez=kepernye_szeles_elemez-1;
				System.out.println("if 2");
			}
			
			i=i+leptek;
			System.out.println("Leptekes i: "+i);
			
			if(i>kepernyo_szeles) {
				System.out.println("Utolso feltetel");
				int a=i-kepernyo_szeles-1;
				
				i=a-1;
				System.out.println(i);
			}
			
		}
		Color pixelkeres = new Color(screeshot.getRGB(0, 0));
		int red= pixelkeres.getRed();
		int grenn= pixelkeres.getGreen();
		int blue= pixelkeres.getBlue();
		
		System.out.println("Szeles: "+kepernyo_szeles+" Kepernyo magas: "+kepernyo_magas);
		
		
		System.out.println(pixelkeres);
		System.out.print("Piros: "+red);
		System.out.print(" Zold: "+grenn);
		System.out.print(" Kek: "+blue);
		
		
		
		
		
		
	}
		
		
	    private boolean isDesiredColor(Color color) {
	        int red = color.getRed();
	        int green = color.getGreen();
	        int blue = color.getBlue();
	        
	        return red >= 130 && red <= 190 &&
	               green >= 130 && green <= 190 &&
	               blue >= 130 && blue <= 190;
	    }

	    private boolean containsDesiredColor(BufferedImage screeshot) {
	        int width = screeshot.getWidth();
	        int height = screeshot.getHeight();

	        for (int y = 0; y < height; y++) {
	            for (int x = 0; x < width; x++) {
	                Color pixelColor = new Color(screeshot.getRGB(x, y));
	                if (isDesiredColor(pixelColor)) {
	                    return true; // Ha találtunk egy megfelelő pixelt, akkor azonnal térjünk vissza
	                }
	            }
	        }
	        return false; // Ha végigértünk a képen, és nem találtunk megfelelő pixelt
	}
	



}
