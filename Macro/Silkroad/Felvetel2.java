package Silkroad;

import java.awt.Color;
import java.awt.Font;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;

public class Felvetel2  {
	public static JPanel Felvett_Gombok= new JPanel();
	private static double ido=0;
	private static Integer Gomb=0;
	static Timer Ido = new Timer();
	static Timer Ido_Figyeles = new Timer();
	static String keyText;
	static String keyText_2;
	static boolean GombNyomva=false;
	static boolean Ido_Boolean=false;
	static boolean Figyeles_Elinditva=false;
	static int ido_szamlalo =0;
	static boolean Elso_Lenyomva=false;
	
	
	public int getGomb() {
		return Gomb;
	}

	public void setGomb(int gomb) {
		Gomb = gomb;
	}
	
	public double getIdo() {
		return ido;
	}

	public void setIdo(double ido) {
		ido = ido;
	}

	public Felvetel2(int Gomb,double ido) {
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
		        	if(Main.felvetel_megy) {
		        	if(!GombNyomva) {
		        		if(!Ido_Boolean) {
		        		Ido_Figyeles_Indul();
		        		}
		    	        keyText=NativeKeyEvent.getKeyText(e.getKeyCode());
		    	        switch (keyText) {
						case "0": {
							break;}
						case "1": {
							break;}
						case "2": {
							break;}
						case "3": {
							break;}
						case "4": {
							break;}
						case "5": {
							break;}
						case "6": {
							break;}
						case "7": {
							break;}
						case "8": {
							break;}
						case "9": {
							break;}
						default:
							keyText=null;
							System.err.println("Nem helyes");
							Main.Felvett_macro_Skill_megjelenit.clear();
							Main.Felvett_macro_Ido_megjelenit.clear();
							Felvett_Gombok.removeAll();
							JLabel Error= new JLabel("Hiba! Csak számot nyomj kérlek!");
							Error.setBounds(30, 100, 500, 50);
							Error.setFont(new Font("Arial", 0, 30));
							Error.setForeground(Color.red);
							Felvett_Gombok.add(Error);
							Main.frame.repaint();
							Felvetel_leallit();
						}
		    	        
		    	        
		                //System.out.println("Megnyomva: "+keyText);
		                GombNyomva=true;
		                //System.err.println("Be erkezett gombnyomas eszlelve: "+Integer.parseInt(keyText)+" Feldolgozas elkezdese");
		                if(Main.Felvett_macro_Skill_megjelenit.size()==0) {
		                	try {
		                		Main.Rogzites.add(new Felvetel2(Integer.parseInt(keyText), 0));
							} catch (Exception e2) {
								// TODO: handle exception
							}
		                	
		                	JLabel Skill= new JLabel();
			                Skill.setText(keyText);
			                Main.Felvett_macro_Skill_megjelenit.add(Skill);
			                	Main.Felvett_macro_Skill_megjelenit.get(Main.Felvett_macro_Skill_megjelenit.size()-1).setBounds(30, Main.Felvett_macro_Skill_megjelenit.size() * 30, 100, 30);
			                	Main.Felvett_macro_Skill_megjelenit.get(Main.Felvett_macro_Skill_megjelenit.size()-1).setFont(new Font("Arial", 0, 20));
			                	Main.Felvett_macro_Skill_megjelenit.get(Main.Felvett_macro_Skill_megjelenit.size()-1).setForeground(Color.red);
			                JLabel Ido= new JLabel(Double.toString(ido)+" mp");
			                	Main.Felvett_macro_Ido_megjelenit.add(Ido);
			                	Main.Felvett_macro_Ido_megjelenit.get(Main.Felvett_macro_Ido_megjelenit.size()-1).setBounds(100, Main.Felvett_macro_Ido_megjelenit.size() * 30, 100, 30);
			                	Main.Felvett_macro_Ido_megjelenit.get(Main.Felvett_macro_Ido_megjelenit.size()-1).setFont(new Font("Arial", 0, 20));
			                	Main.Felvett_macro_Ido_megjelenit.get(Main.Felvett_macro_Ido_megjelenit.size()-1).setForeground(Color.red);
			                	Felvett_Gombok.add(Main.Felvett_macro_Skill_megjelenit.get(Main.Felvett_macro_Skill_megjelenit.size()-1));
			                	Felvett_Gombok.add(Main.Felvett_macro_Ido_megjelenit.get(Main.Felvett_macro_Ido_megjelenit.size()-1));

			                	Main.frame.repaint();
			                	ido=0;
			                	
		                	
		                }
		                
		                if(keyText_2!=null) {
		                	try {
		                		Main.Rogzites.add(new Felvetel2(Integer.parseInt(keyText_2), ido));
							} catch (Exception e2) {
								
								keyText_2=null;
							}
		                	
		                	System.out.println("Utolso felvett adatok  Gomb: "+Main.Rogzites.get(Main.Rogzites.size()-1).getGomb()+" Ido: "+Main.Rogzites.get(Main.Rogzites.size()-1).getIdo());
		                	System.err.println("JLabel kiiras szenvedes KeyText_2-re");
		                	JLabel Skill= new JLabel();
			                Skill.setText(keyText);
			                Main.Felvett_macro_Skill_megjelenit.add(Skill);
			                	Main.Felvett_macro_Skill_megjelenit.get(Main.Felvett_macro_Skill_megjelenit.size()-1).setBounds(30, Main.Felvett_macro_Skill_megjelenit.size() * 30, 100, 30);
			                	Main.Felvett_macro_Skill_megjelenit.get(Main.Felvett_macro_Skill_megjelenit.size()-1).setFont(new Font("Arial", 0, 20));
			                	Main.Felvett_macro_Skill_megjelenit.get(Main.Felvett_macro_Skill_megjelenit.size()-1).setForeground(Color.red);
			                JLabel Ido= new JLabel(Double.toString(ido)+" mp");
			                	Main.Felvett_macro_Ido_megjelenit.add(Ido);
			                	Main.Felvett_macro_Ido_megjelenit.get(Main.Felvett_macro_Ido_megjelenit.size()-1).setBounds(100, Main.Felvett_macro_Ido_megjelenit.size() * 30, 100, 30);
			                	Main.Felvett_macro_Ido_megjelenit.get(Main.Felvett_macro_Ido_megjelenit.size()-1).setFont(new Font("Arial", 0, 20));
			                	Main.Felvett_macro_Ido_megjelenit.get(Main.Felvett_macro_Ido_megjelenit.size()-1).setForeground(Color.red);
			                	Felvett_Gombok.add(Main.Felvett_macro_Skill_megjelenit.get(Main.Felvett_macro_Skill_megjelenit.size()-1));
			                	Felvett_Gombok.add(Main.Felvett_macro_Ido_megjelenit.get(Main.Felvett_macro_Ido_megjelenit.size()-1));

			                	Main.frame.repaint();
			                	ido=0;
		                	
		                }
		        	}
		        	
		        	
		        	if(keyText!=null) {
		        		//Ezeket az adatokat vegye fel ne azt mai beérkezik
	                	try {
	                		Main.Rogzites.add(new Felvetel2(Integer.parseInt(keyText), ido));
	                		
						} catch (Exception e2) {
							
							keyText=null;
						}
		    	        keyText_2=NativeKeyEvent.getKeyText(e.getKeyCode());
		    	        //Biztonsagi parancs ha nem szamot nyom az illeto
		    	        switch (keyText_2) {
						case "0": {
							break;}
						case "1": {
							break;}
						case "2": {
							break;}
						case "3": {
							break;}
						case "4": {
							break;}
						case "5": {
							break;}
						case "6": {
							break;}
						case "7": {
							break;}
						case "8": {
							break;}
						case "9": {
							break;}
						default:
							keyText_2=null;

							System.err.println("Nem helyes");
							Main.Felvett_macro_Skill_megjelenit.clear();
							Main.Felvett_macro_Ido_megjelenit.clear();
							Felvett_Gombok.removeAll();
							JLabel Error= new JLabel("Hiba! Csak számot nyomj kérlek!");
							Error.setBounds(30, 100, 500, 50);
							Error.setFont(new Font("Arial", 0, 30));
							Error.setForeground(Color.red);
							Felvett_Gombok.add(Error);
							Main.frame.repaint();
							Felvetel_leallit();
						}
		    	        
		    	        
		        		System.out.println("Utolso felvett adatok_2  Gomb: "+Main.Rogzites.get(Main.Rogzites.size()-1).getGomb()+" Ido: "+Main.Rogzites.get(Main.Rogzites.size()-1).getIdo());
		                GombNyomva=false;
		                
	                	JLabel Skill= new JLabel();
		                Skill.setText(keyText);
		                Main.Felvett_macro_Skill_megjelenit.add(Skill);
		                	Main.Felvett_macro_Skill_megjelenit.get(Main.Felvett_macro_Skill_megjelenit.size()-1).setBounds(30, Main.Felvett_macro_Skill_megjelenit.size() * 30, 100, 30);
		                	Main.Felvett_macro_Skill_megjelenit.get(Main.Felvett_macro_Skill_megjelenit.size()-1).setFont(new Font("Arial", 0, 20));
		                	Main.Felvett_macro_Skill_megjelenit.get(Main.Felvett_macro_Skill_megjelenit.size()-1).setForeground(Color.red);
		                JLabel Ido= new JLabel(Double.toString(ido)+" mp");
		                	Main.Felvett_macro_Ido_megjelenit.add(Ido);
		                	Main.Felvett_macro_Ido_megjelenit.get(Main.Felvett_macro_Ido_megjelenit.size()-1).setBounds(100, Main.Felvett_macro_Ido_megjelenit.size() * 30, 100, 30);
		                	Main.Felvett_macro_Ido_megjelenit.get(Main.Felvett_macro_Ido_megjelenit.size()-1).setFont(new Font("Arial", 0, 20));
		                	Main.Felvett_macro_Ido_megjelenit.get(Main.Felvett_macro_Ido_megjelenit.size()-1).setForeground(Color.red);
		                
		                	Felvett_Gombok.add(Main.Felvett_macro_Skill_megjelenit.get(Main.Felvett_macro_Skill_megjelenit.size()-1));
		                	Felvett_Gombok.add(Main.Felvett_macro_Ido_megjelenit.get(Main.Felvett_macro_Ido_megjelenit.size()-1));

		                	Main.frame.repaint(); 
		                	ido=0;
		        	}
		        	ido=0;
		        	
		        	
		        }
		        }
			});
			
		}

		
	}
	
	
	public static void Felvetel_indit() {
		
		System.out.println("Felvetel elindul / Tarolt adatok torlese: "+Main.Felvett_macro_Skill_megjelenit.size());
		Main.Felvett_macro_Skill_megjelenit.clear();
		Main.Felvett_macro_Ido_megjelenit.clear();
		System.out.println("Torles ellenorzes: "+Main.Felvett_macro_Skill_megjelenit.size());
		Felvett_Gombok.removeAll();
		Main.frame.repaint();

	}
	
	static void Ido_Figyeles_Indul() {
	    Ido = new Timer();
	    Ido_Boolean = true;
	    Ido.scheduleAtFixedRate(new TimerTask() {
	        @Override
	        public void run() {
	            ido_szamlalo += 100; // Növeld az időt milliszekundumban
	            ido = ido_szamlalo / 1000.0; // Konvertáld másodpercbe
	            //System.out.printf("Ido: %.1f%n", ido); // Pontos, 1 tizedesjegyű formátum
	        }
	    }, 0, 100);
		
	}
	
	public static void Felvetel_leallit() {
		
		
		System.out.println("Billentyu figyeles leallit");
		Main.felvetel_megy=false;
		Main.Felvetel_Label.setForeground(Color.black);
		Ido_Boolean=false;
		Ido.cancel();
		ido=0;
		
	}
}
