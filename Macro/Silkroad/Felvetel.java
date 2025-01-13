package Silkroad;

import java.awt.Color;
import java.awt.Font;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;

public class Felvetel  {
	public static JPanel Felvett_Gombok= new JPanel();
	
	private static double ido=0; //Ezzé alakul a TimerTask alapján
	static int ido_szamlalo =0; //Ez fut a TimerTaskban
	private static String Gomb="0";
	static double Utolso_Ido;
	private static Timer Ido; // Globális szinten definiáld

	static boolean Ido_Figyelve=false;
	
	static String keyText;
	static String Elozo_Gomb;
	
	static boolean GombNyomva=false;
	static boolean Ido_Boolean=true;
	static boolean Figyeles_Elinditva=false;
	
	static boolean Elso_Lenyomva=false;
	static int Gombnyomas_int=1;
	static int felvetel_index=0;
	
	public static boolean Macro_indithato=false;
	static boolean Lejatszas_fut=false;
	
	static String Lejatszas_Gomb="Home";
	
	static JTextArea Segitseg=new JTextArea();
	public static JScrollPane scrollPane= new JScrollPane();


	
	
	public String getGomb() {
		return Gomb;
	}

	public void setGomb(String gomb) {
		Gomb = gomb;
	}
	
	public double getIdo() {
		return ido;
	}

	public void setIdo(double ido) {
		ido = ido;
	}

	public Felvetel(String Gomb,double ido) {
		this.ido=ido;
		this.Gomb=Gomb;;
		
	}
	
	public static void Billentyu_Figyeles() {
		if(!Figyeles_Elinditva) {
			try {
				GlobalScreen.registerNativeHook();
				Figyeles_Elinditva=true;
				
			} catch (NativeHookException e) {
				System.err.println("Nem sikerul figyelni a gombokat");
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			GlobalScreen.addNativeKeyListener(new NativeKeyListener() {
		        public void nativeKeyReleased(NativeKeyEvent e) {
	        		if(Main.Gyorsgomb_Valthato) {
	        			Lejatszas_Gomb=NativeKeyEvent.getKeyText(e.getKeyCode());
	        			if(Lejatszas_Gomb.equals("Enter")) {
	        				Lejatszas_Gomb="Home";
	        			}
	        			System.out.println("Megvaltozott a gyorsgomb: "+Lejatszas_Gomb);
	        			Main.Gyorsgomb_Label.setText("("+Lejatszas_Gomb+")");
	        			Main.Gyorsgomb_Label.setForeground(Color.black);
	        	    	Main.frame.repaint();
	        			Main.Gyorsgomb_Valthato=false;
	        			
	        		}

		        	if(Main.Rogzites.size()>0) {
		        		String Gyorsgomb=NativeKeyEvent.getKeyText(e.getKeyCode());
		        		
		        		if(Gyorsgomb.equals(Lejatszas_Gomb)) {
		        			System.out.println("Gyorsgomb egyezik");
		        			
		    				if(Lejatszas_fut) {
		    					System.err.println("Lejatszas megallit");
		    					Main.Felvett_macro_Skill_megjelenit.get(Lejatszas.Index).setForeground(Color.red);
		    					Main.Inditas_Label.setForeground(Color.black);
		    					Lejatszas.Index=0;
		    					Lejatszas_fut=false;
		    					Main.fut=false;
		    	    	    	Felvetel.Felvett_Gombok.repaint();
		    	    	    	Main.frame.repaint(); 
		    				}else {
		    					Felvetel.Macro_indithato=true;
		    					System.err.println("Lejatszas inditas");
		    					Lejatszas_fut=true;
		    					Lejatszas.Lejatszas_Indit();
		    					Main.fut=true;
		    				}
		        		};


		        	}
		        	if(Main.felvetel_megy) {
		        		if(Ido_Boolean) {
		        			System.out.println("\n\nFelteltel helyes \n\n");
		        			Ido_Figyeles_Indul();
		        			Ido_Boolean=false;
		        		}
		        		
		        		
		        		
		        		//Ez a rész nézi az első és a többi lenyomott gombot.
		        		if(Gombnyomas_int==1) {
		        		keyText=NativeKeyEvent.getKeyText(e.getKeyCode());
		        		GombNyomva=true;
		        		//System.out.println("Lenyomott gomb: "+keyText);
		        		if(!keyText.equals("Enter")) {
		        			Key_Text_Felvetele_Panelra();
		        		}else {
		        			System.err.println("\t\t\tIdo: "+ido);
		        			Felvetel_leallit();
		        			Main.felvetel_megy=false;
		        		}

		        		

		        		
		        		}
		        		
		        		
		        		//Ez a rész nézi az össze hasonlító gombot
		        		if(Gombnyomas_int==2) {
		        			Elozo_Gomb=NativeKeyEvent.getKeyText(e.getKeyCode());
		        			//System.err.println("Lenoymott gomb kodja: "+Elozo_Gomb);
		        			GombNyomva=true;
		        		if(!Elozo_Gomb.equals("Enter")) {
		        		Key_Text2_Felvetele_Panelra();
		        		}else {
		        			System.err.println("\t\t\tIdo: "+ido);
		        			Felvetel_leallit();
		        			Main.felvetel_megy=false;
		        		}



		        		
		        		}

		        		Gombnyomas_int++;
		        		if(Gombnyomas_int==3) {
		        			Gombnyomas_int=1;

		        		}
		        		

		        		
		        	}
		        	
		        }
			});
			
		}
	}
	

	
	public static void Key_Text_Felvetele_Panelra() {
		ido = ido_szamlalo / 1000.0;
		System.out.println("\t\t\t\t Elso gomb nezes");
		// Ott kell használni ahol már megkapta a Elozo_Gomb-őt
    	JLabel Skill= new JLabel();
        Skill.setText(keyText);
        
        Main.Felvett_macro_Skill_megjelenit.add(Skill);
        	Main.Felvett_macro_Skill_megjelenit.get(Main.Felvett_macro_Skill_megjelenit.size()-1).setBounds(30, Main.Felvett_macro_Skill_megjelenit.size() * 30, 100, 30);
        	Main.Felvett_macro_Skill_megjelenit.get(Main.Felvett_macro_Skill_megjelenit.size()-1).setFont(new Font("Arial", 0, 20));
        	Main.Felvett_macro_Skill_megjelenit.get(Main.Felvett_macro_Skill_megjelenit.size()-1).setForeground(Color.red);
        	
        JLabel Ido= new JLabel("0.0");
        	Main.Felvett_macro_Ido_megjelenit.add(Ido);
        	Main.Felvett_macro_Ido_megjelenit.get(Main.Felvett_macro_Ido_megjelenit.size()-1).setBounds(100, Main.Felvett_macro_Ido_megjelenit.size() * 30, 100, 30);
        	Main.Felvett_macro_Ido_megjelenit.get(Main.Felvett_macro_Ido_megjelenit.size()-1).setFont(new Font("Arial", 0, 20));
        	Main.Felvett_macro_Ido_megjelenit.get(Main.Felvett_macro_Ido_megjelenit.size()-1).setForeground(Color.red);
        	
        	if(Main.Felvett_macro_Skill_megjelenit.size()>1&&Main.Felvett_macro_Skill_megjelenit.size()%2!=0) {
        		System.err.println("\tIdo modositas lefut az elozo gombra, mert tobb a lenyomott gomb mint 1");
        		Ido.setText(Double.toString(ido));
        		Main.Felvett_macro_Ido_megjelenit.get(Main.Felvett_macro_Ido_megjelenit.size()-2).setText(Ido.getText());
        		Main.Felvett_macro_Ido_megjelenit.get(Main.Felvett_macro_Ido_megjelenit.size()-1).setText("0.0");
        	}
        	
        	Felvett_Gombok.add(Main.Felvett_macro_Skill_megjelenit.get(Main.Felvett_macro_Skill_megjelenit.size()-1));
        	Felvett_Gombok.add(Main.Felvett_macro_Ido_megjelenit.get(Main.Felvett_macro_Ido_megjelenit.size()-1));
        	
        	Felvett_Gombok.repaint();
        	Main.frame.repaint(); 
        	System.out.println("Meret: "+Main.Felvett_macro_Skill_megjelenit.size());
	}
	
	public static void Key_Text2_Felvetele_Panelra() {
		ido = ido_szamlalo / 1000.0;
		System.out.println("\t\t\t\t Masodik gomb nezes");
		
		// Ott kell használni ahol már megkapta a Elozo_Gomb-őt
    	JLabel Skill= new JLabel();
        Skill.setText(Elozo_Gomb);
        
        Main.Felvett_macro_Skill_megjelenit.add(Skill);
        	Main.Felvett_macro_Skill_megjelenit.get(Main.Felvett_macro_Skill_megjelenit.size()-1).setBounds(30, Main.Felvett_macro_Skill_megjelenit.size() * 30, 100, 30);
        	Main.Felvett_macro_Skill_megjelenit.get(Main.Felvett_macro_Skill_megjelenit.size()-1).setFont(new Font("Arial", 0, 20));
        	Main.Felvett_macro_Skill_megjelenit.get(Main.Felvett_macro_Skill_megjelenit.size()-1).setForeground(Color.red);
        	
        JLabel Ido= new JLabel("0.0");
        	Main.Felvett_macro_Ido_megjelenit.add(Ido);
        	Main.Felvett_macro_Ido_megjelenit.get(Main.Felvett_macro_Ido_megjelenit.size()-1).setBounds(100, Main.Felvett_macro_Ido_megjelenit.size() * 30, 100, 30);
        	Main.Felvett_macro_Ido_megjelenit.get(Main.Felvett_macro_Ido_megjelenit.size()-1).setFont(new Font("Arial", 0, 20));
        	Main.Felvett_macro_Ido_megjelenit.get(Main.Felvett_macro_Ido_megjelenit.size()-1).setForeground(Color.red);
        	
        	if(Main.Felvett_macro_Skill_megjelenit.size()>1&&Main.Felvett_macro_Skill_megjelenit.size()%2==0) {
        		System.err.println("\t2 Ido modositas lefut az elozo gombra, mert tobb a lenyomott gomb mint 1");
        		Ido.setText(Double.toString(ido));
        		Main.Felvett_macro_Ido_megjelenit.get(Main.Felvett_macro_Ido_megjelenit.size()-2).setText(Ido.getText());
        		Main.Felvett_macro_Ido_megjelenit.get(Main.Felvett_macro_Ido_megjelenit.size()-1).setText("0.0");

        	}
        	
        	Felvett_Gombok.add(Main.Felvett_macro_Skill_megjelenit.get(Main.Felvett_macro_Skill_megjelenit.size()-1));
        	Felvett_Gombok.add(Main.Felvett_macro_Ido_megjelenit.get(Main.Felvett_macro_Ido_megjelenit.size()-1));
        	
        	Felvett_Gombok.repaint();
        	Main.frame.repaint(); 
        	System.out.println("Meret: "+Main.Felvett_macro_Skill_megjelenit.size());
	}
	
	public static void Felvetel_indit() {
		ido = 0;
		ido_szamlalo = 0;
		Ido_Figyelve = false;
		Ido_Boolean = true;
		
		System.out.println("Felvetel elindul / Tarolt adatok torlese: "+Main.Felvett_macro_Skill_megjelenit.size());
		Main.Felvett_macro_Skill_megjelenit.clear();
		Main.Felvett_macro_Ido_megjelenit.clear();
		System.out.println("Torles ellenorzes: "+Main.Felvett_macro_Skill_megjelenit.size());
		Felvett_Gombok.removeAll();
		Felvett_Gombok.revalidate();
		Felvett_Gombok.repaint();
		Main.frame.repaint();
		Macro_indithato=false;

	}
	
	static void Ido_Figyeles_Indul() {
		if (Ido != null) {
			Ido.cancel(); // Az előző időzítést leállítjuk
			Ido.purge();  // Az összes beütemezett feladatot töröljük
		}
		Ido_Figyelve=true;
		Ido=new Timer();
	    Ido.scheduleAtFixedRate(new TimerTask() {
	        @Override
	        public void run() {

	        	System.out.println("Idoszamlalo: "+ido_szamlalo+ " Ido: "+ido);
	            ido_szamlalo += 100; // Növeld az időt milliszekundumban
	            ido = ido_szamlalo / 1000.0; // Konvertáld másodpercbe
	            //System.out.printf("Ido: %.1f%n", ido); // Pontos, 1 tizedesjegyű formátum
	        	if(GombNyomva) {
	        		System.err.println("TimerTask ido egyezik");
	        		GombNyomva=false;
	        		Utolso_Ido=ido;
	        		ido_szamlalo=0;
	        		System.out.println("Ido: "+ido);
	        	}
	        	if(!Ido_Figyelve) {
	        		 Ido.cancel();
	        	}
	        }
	    }, 0, 100);
		
	}
	
	public static void Felvetel_leallit() {
		Utolso_Ido=ido;
		Main.Inditas_Label.setForeground(Color.black);
		if(Main.Felvett_macro_Ido_megjelenit.size()!=0) {
		//System.out.println(Main.Felvett_macro_Skill_megjelenit.size());
		for (JLabel label : Main.Felvett_macro_Skill_megjelenit) {
			String gomb= label.getText();
			//System.out.println("Felvett label ki irasa");

			// public Felvetel(int Gomb,double ido);

			Main.Rogzites.add(new Felvetel(gomb, Double.parseDouble(Main.Felvett_macro_Ido_megjelenit.get(felvetel_index).getText())));
			System.err.println("\tFelvett adatok a Rogzitesben Gomb: "+Main.Rogzites.get(Main.Rogzites.size()-1).getGomb()+" Ido: "+Main.Rogzites.get(Main.Rogzites.size()-1).getIdo());
			felvetel_index++;
		}
		System.err.println("Utolsonak beallitando ido: "+Utolso_Ido);
		Main.Rogzites.get(Main.Rogzites.size()-1).setIdo(Utolso_Ido);
		//Itt allitodik az utolso gomb ertekenek az ideje 
		Main.Felvett_macro_Ido_megjelenit.get(Main.Felvett_macro_Ido_megjelenit.size()-1).setText(Double.toString(Utolso_Ido));
		}
    	Felvett_Gombok.repaint();
    	Main.frame.repaint(); 

    	
		Main.felvetel_megy=false;
		Main.Felvetel_Label.setForeground(Color.black);
		Elso_Lenyomva=false;

		Figyeles_Elinditva=false;
		GombNyomva=false;
		Gombnyomas_int=1;
		
		Main.felvetel_megy=false;
		
		Macro_indithato=true;
		Ido_Boolean=true;
    	ido=0;
    	ido_szamlalo=0;
    	felvetel_index=0;

    	if (Ido != null) {
    		Ido.cancel();
    		Ido.purge();
    		Ido = null; // Biztosítsd, hogy a Timer nullázódik
    	}


    	Ido_Figyelve=false;
		Kiir();
		
	}
	static void Kiir() {
		System.out.println("Rogzitesbe feldolgozott adatok ki irasa: "+Main.Rogzites.size());
		
	}
}
