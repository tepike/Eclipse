package Banyaszat;

import javax.swing.*;
import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class main extends JFrame implements KeyListener {
	
	private boolean analysisInProgress = false;

    static int screenWidth = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    static int screenHeight = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
    static int frameWidth = 50;
    static int frameHeight = 20;
    static int frameX = (screenWidth - frameWidth) /2;
    static int frameY = (screenHeight - frameHeight) / 2; 
    static boolean aktiv=false;
    static boolean talat=false;
    private Timer timer= new Timer();
    private static Timer timer2= new Timer();
    private  static boolean NumEgned;
    
    static JFrame Ablak= new JFrame();
    static JFrame Ablak2= new JFrame();
    static JButton gomb2= new JButton(" X ");
    static JLabel gomb= new JLabel("Valami");
    static JLabel SegedSzoveg2 = new JLabel("Találatok száma:");
    static JLabel SegedSzoveg3 = new JLabel("VÉSZKILÉPÉS (Page up)");
    static JLabel SegedSzoveg1 = new JLabel("Aktív: ");
    public static int talatokszama=0;
    public static int probak=0;
    public static String probakstring=Integer.toString(probak);
    public static String talatokszamastring=Integer.toString(talatokszama);
    public static JLabel lblIgen_1_1 = new JLabel(talatokszamastring);
    public static JLabel lblIgen_1 = new JLabel(probakstring);
    PointerInfo pointerInfo = MouseInfo.getPointerInfo();
    public static JLabel lblIgen = new JLabel("Nem");
    private final JLabel lblBekapcsHome = new JLabel("Bekapcsol: Home");
    private final JLabel lblKikapcsolEnd = new JLabel("Kikapcsol: End");
    private final JLabel lblNumlock = new JLabel("NUMLOCK");
    private final JLabel lblMozgatsNyilak_1 = new JLabel("Meretezes: Num(2-4-6-8)");
    private final JLabel lblGyakorisg = new JLabel("Gyakoriság(ms):");
    private final JLabel lblValtoztassmeg = new JLabel("10");
    private final JLabel lblszlelsekSzma = new JLabel("Észlelések száma:");
    static double Eger_X_Double=MouseInfo.getPointerInfo().getLocation().getX();
    static double Eger_Y_Double=MouseInfo.getPointerInfo().getLocation().getY();
    static int Eger_X=((int)(Eger_X_Double));
    static int Eger_Y=((int)(Eger_Y_Double));
    private static int numkod=0;
    static int sebesseg=10;
    static int sebessegHorgaszat=1000;
    
    public static int Keresett_Piros_Min=0;
    public static int Keresett_Piros_Max=40;
    public static int Keresett_Zold_Min=100;
    public static int Keresett_Zold_Max=150;
    public static int Keresett_Kek_Min=0;
    public static int Keresett_Kek_Max=40;
    private final JLabel Erzekelt_Szin_Piros = new JLabel(Integer.toString(Keresett_Piros_Min+25));
    private final JLabel Erzekelt_Szin_Zold = new JLabel(Integer.toString(Keresett_Zold_Min+20));
    private final JLabel Erzekelt_Szin_Kek = new JLabel(Integer.toString(Keresett_Kek_Min+25));
    
    //Horgászati cuccok (nem elemzes)
    static JLabel lblHtralvKrkSzama = new JLabel("0");
    static JLabel lblHtralvKrk = new JLabel("Hátralévő körök:");
    static   JLabel lblJelenlegiKrSzma = new JLabel("");
    static   JLabel lblJelenlegiKr = new JLabel("Jelenlegi kör:");
    static   JLabel lblIsm = new JLabel("Ism.");
    static  JLabel lblFeladatIsmtls = new JLabel("Feladat ismétlése:");
    static  JLabel lblMilsec_3 = new JLabel("Milsec");
    
    static int horgaszatfut=1;
    private final JLabel lblAutomata = new JLabel("AUTOMATA Off");
    private JTextField Elemzes_Textfield;
    private JTextField IsmetlesSzor_Textfield;
    static private int HorgaszatKorIg=1;
    static private int JelenlegiKor=0;
    static final JLabel Automata_Feladat_Most_1 = new JLabel("Autómata szünetel");
    static final JLabel Automata_Feladat_Ido = new JLabel("Aktuális Időzítő:");
    static final JLabel Automata_Feladat_Ido_Text = new JLabel("0");
    static final JLabel Automata_Feladat_Ido_Mpkiiras = new JLabel("mp");
    static boolean SzinMegjelol=false;
    private final JLabel Szinjeloles_Aktiv_Label = new JLabel("Jelölés aktív:");
    private final JLabel Szinjeloles_Aktiv_Boolean_label = new JLabel("Nem");
    private final JLabel lblUjrakezdesDelay_ = new JLabel("Újrakezdés Delay:");
    private final JTextField UjrakezdesDealyInteger = new JTextField();
    private final JLabel lblMilsec_3_1 = new JLabel("Milsec");
    
    //Ablak mozgatása
	static int pointerX= (int)MouseInfo.getPointerInfo().getLocation().getX();
	static int pointerY=(int)MouseInfo.getPointerInfo().getLocation().getY();
    
    

    public main() {
    	
    	lblJelenlegiKrSzma.setText(Integer.toString(JelenlegiKor));
    	lblHtralvKrkSzama.setText(Integer.toString(HorgaszatKorIg-JelenlegiKor));
    	
    	 Timer timer = new Timer();
    	 Timer timer2 = new Timer();
    	 lblAutomata.setForeground(Color.RED);
    	
    	
    	
	    try {
			GlobalScreen.registerNativeHook();
		} catch (NativeHookException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    GlobalScreen.addNativeKeyListener(new NativeKeyListener()
	    {

	        @Override
	        public void nativeKeyTyped(NativeKeyEvent e)
	        {
	        	
	        }

	        @Override
	        public void nativeKeyReleased(NativeKeyEvent e)
	        {
	            //String keyText=NativeKeyEvent.getKeyText(e.getKeyCode());
	            //System.out.println("User typed: "+keyText);
	        }

	        @Override
	        public void nativeKeyPressed(NativeKeyEvent e)
	        {
	        	
	        	//Feldolgozási adatok
	        	
	        	 if (e.getKeyCode() == NativeKeyEvent.VC_NUM_LOCK) {
	        		    if (Toolkit.getDefaultToolkit().getLockingKeyState(KeyEvent.VK_NUM_LOCK)) {
	        		        numkod++;
	        		        System.out.println("Elso "+numkod);
	        		    }else {
	        		    	numkod++;
	        		    	System.out.println("Masodik  "+numkod);
	        		    }
	        		    if(numkod==0) {
	        		    	lblNumlock.setForeground(Color.GREEN);
	        		    	NumEgned = true;
	        		    }
	        		    if(numkod==1) {
	        		    	lblNumlock.setForeground(Color.GREEN);
	        		    	NumEgned = true;
	        		    	
	        		    }
	        		    if(numkod==2) {
	        		    	lblNumlock.setForeground(Color.RED);
	        		    	NumEgned = false;
	        		    	numkod=0;
	        		    }

	        		}
	        		
	        	 
	        	 else if (e.getKeyCode() == NativeKeyEvent.VC_PAGE_UP) {
	                 System.exit(0);
	             }
		             
	        	 

	             else if (e.getKeyCode() == NativeKeyEvent.VC_END) {
	            	 probak=0;
	            	 talatokszama=0;
	            	 probakfrissit();
	                 aktiv=false;
	                 Ablak.setBackground(new Color(100, 0, 0, 40));
	                 lblIgen.setText("Nem");
	             }
	             else if (e.getKeyCode() == NativeKeyEvent.VC_HOME) {
	                    EgerFrissit();
	                    
		                 aktiv=true;
		                 Ablak.setBackground(new Color(0, 100, 0, 40));
		                 lblIgen.setText("Igen");

						}
	             else if (NumEgned&(e.getKeyCode() == NativeKeyEvent.VC_8)) {
	             	frameHeight=frameHeight-5;
	             	if(frameHeight<1) {
	             		frameHeight=1;
	             	}
	             	Ablak.setSize(frameWidth+200, frameHeight+10);
	             }
	             else if (NumEgned&(e.getKeyCode() == NativeKeyEvent.VC_2)) {
	             	frameHeight=frameHeight+5;
	             	Ablak.setSize(frameWidth+200, frameHeight+10);
	             }
	             else if (NumEgned&(e.getKeyCode() == NativeKeyEvent.VC_6)) {
	             	frameWidth=frameWidth+5;
	             	Ablak.setSize(frameWidth+200, frameHeight+10);

	             	
	             }
	             else if (NumEgned&(e.getKeyCode() == NativeKeyEvent.VC_4)) {
	             	frameWidth=frameWidth-5;
	             	if(frameWidth<1) {
	             		frameWidth=1;
	             	}
	             	Ablak.setSize(frameWidth+200, frameHeight+10);

	             }
	        	 
	        	 //Horgászati adatok
	        	 else if (e.getKeyCode() == NativeKeyEvent.VC_F6) {
	        		 
	        		 horgaszatfut++;
	        		 if(horgaszatfut==1) {
	        		    	NumEgned = false;
	        		    	numkod=0;

	        			 
	        			 System.out.println("Horgaszat Off");
	        			 lblAutomata.setForeground(Color.RED);
	        			 lblAutomata.setText("Automata Off");
	        			 Automata_Feladat_Most_1.setText("Autómata szünetel");
	             		System.out.println("Megallitva, H gomb megnyomva");
	             		Ablak.setBackground(new Color(100, 0, 40));
	             		UjrakezdesDealyInteger.setEditable(true);
	             		Elemzes_Textfield.setEditable(true);
	             		IsmetlesSzor_Textfield.setEditable(true);
	        			 Robot robot;
						try {
							robot = new Robot();
	                        robot.mousePress(InputEvent.BUTTON2_DOWN_MASK);
	                        robot.keyPress(KeyEvent.VK_END);
	                        robot.keyRelease(KeyEvent.VK_END);
	                        robot.mouseRelease(InputEvent.BUTTON2_DOWN_MASK);
						} catch (AWTException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

	        			
	        			 
	        			 
	        		 }else if(horgaszatfut==2) {
	        			 System.out.println("Horgasazt On");
	        			 lblAutomata.setForeground(Color.GREEN);
	        			 lblAutomata.setText("Automata On");
	        			 horgaszatfut=0;
	        			 UjrakezdesDealyInteger.setEditable(false);
	        			 Elemzes_Textfield.setEditable(false);
	        			 IsmetlesSzor_Textfield.setEditable(false);
	        			 
	        			 try {
	        				
	        			
							restartTimerHorgaszat();
						} catch (AWTException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
	        		 }
	                 System.out.println("F6 megnyomva");
	                 
	             }
	        	 //Gombnyomásra kiválszatható szín
	        	 else if (SzinMegjelol&(e.getKeyCode() == NativeKeyEvent.VC_X)) {
	        		 Robot robot;
	        		 for(int i=0;i!=2;i++) {
	        			 System.out.println("Kor "+i);
	        		 try {
	        			 robot = new Robot();
		                 PointerInfo pointerInfo = MouseInfo.getPointerInfo();
		                 BufferedImage image = robot.createScreenCapture(pointerInfo.getDevice().getDefaultConfiguration().getBounds());
		                 int x = pointerInfo.getLocation().x;
		                 int y = pointerInfo.getLocation().y;
		                 Color color = new Color(image.getRGB(x, y));
		                 System.out.println("Az egér pozíciójának színe: RGB(" + color.getRed() + ", " + color.getGreen() + ", " + color.getBlue() + ")");
		                 int piros=color.getRed();
		                 int zold=color.getGreen();
		                 int kek=color.getBlue();
		                 Erzekelt_Szin_Piros.setText(Integer.toString(Keresett_Piros_Min+25));
		                 Erzekelt_Szin_Zold.setText(Integer.toString(Keresett_Zold_Min+25));
		                 Erzekelt_Szin_Kek.setText(Integer.toString(Keresett_Kek_Min+25));
		                 Keresett_Piros_Max=piros+40;
		                 Keresett_Zold_Max=zold+40;
		                 Keresett_Kek_Max=kek+40;
		                 if(piros-40>=0) {
		                	 System.out.println("\nA Pirosbol vonhato 25, mert ugy is nagyobb vagy egyenlo mint 0");
		                	 Keresett_Piros_Min=piros-25;
		                 }else {
		                	 System.out.println("\nA Pirosbol levonas kevesebb lett volna mint nulla ezert az eredmenyt beallitom 0-ra");
		                	 Keresett_Piros_Min=0;
		                 }
		                 if(zold-25>=0) {
		                	 System.out.println("A Zoldbol vonhato 25, mert ugy is nagyobb vagy egyenlo mint 0");
		                	 Keresett_Zold_Min=zold-25;
		                 }else {
		                	 System.out.println("A Zoldbol levonas kevesebb lett volna mint nulla ezert az eredmenyt beallitom 0-ra");
		                	 Keresett_Zold_Min=0;
		                 }
		                 if(kek-25>=0) {
		                	 System.out.println("A Kekbol vonhato 25, mert ugy is nagyobb vagy egyenlo mint 0");
		                	 Keresett_Kek_Min=kek-25;
		                 }else {
		                	 System.out.println("A Kekbol levonas kevesebb lett volna mint nulla ezert az eredmenyt beallitom 0-ra");
		                	 Keresett_Kek_Min=0;
		                 }
		                 

		                 
		                 

	        		 
					} catch (AWTException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	        		 }
	        		 
	        		 SzinMegjelol=false;
	        		 Szinjeloles_Aktiv_Boolean_label.setText("Nem");
	        		 Szinjeloles_Aktiv_Boolean_label.setForeground(Color.BLACK);
	        		 
		             }
	             
	        	 
	             
	             
	             
	             
	        
	        }


	     });
	
    	 
    	
	    Ablak.setUndecorated(true);
	    Ablak.setBackground(new Color(100, 0, 0, 40));
	    Ablak.setSize(frameWidth+200, frameHeight+10);
	    Ablak.setLocation(frameX, frameY);
	    Ablak.setDefaultCloseOperation(EXIT_ON_CLOSE);
	    Ablak.setVisible(true);
	    Ablak.setAlwaysOnTop(true);
        
	    Ablak.getContentPane().addMouseListener(new MouseAdapter() {
        	@Override
        	public void mousePressed(MouseEvent e) {
        		elemzomozgat();
        	}
        	@Override
        	public void mouseReleased(MouseEvent e) {
        		panelleark();
        	}
        });


        Ablak2.getContentPane().addMouseListener(new MouseAdapter() {
        	@Override
        	public void mousePressed(MouseEvent e) {
        		panelmozgat();
        	}
        	@Override
        	public void mouseReleased(MouseEvent e) {
        		panelleark();
        	}
        });



        Ablak2.setUndecorated(true);
        Ablak2.setBackground(new Color(200, 200, 200, 100));
        Ablak2.setSize(frameWidth + 500, frameHeight + 300);
        Ablak2.setLocation(10, screenHeight/3);
        Ablak2.setDefaultCloseOperation(EXIT_ON_CLOSE);
        Ablak2.setVisible(true);
        Ablak2.setAlwaysOnTop(true);
        Ablak2.getContentPane().setLayout(null);
        gomb2.setBounds(480, 1, 70, 31);
        gomb2.setFont(new Font("Arial Black", Font.BOLD, 13));
        gomb2.setBackground(new Color(255, 81, 85));
        gomb2.setForeground(Color.BLACK);
        gomb2.addMouseListener(new MouseAdapter() {     	
        public void mouseReleased(MouseEvent e) {
        	System.exit(0);
         	}
         });
        Ablak2.getContentPane().add(gomb2);
        SegedSzoveg1.setFont(new Font("Tahoma", Font.BOLD, 16));
        SegedSzoveg1.setBounds(5, 120, 60, 31);
        Ablak2.getContentPane().add(SegedSzoveg1);
        SegedSzoveg2.setFont(new Font("Tahoma", Font.BOLD, 16));
        SegedSzoveg2.setBounds(5, 140, 150, 31);
        Ablak2.getContentPane().add(SegedSzoveg2);
        SegedSzoveg3.setHorizontalAlignment(SwingConstants.CENTER);
        SegedSzoveg3.setForeground(Color.RED);
        SegedSzoveg3.setFont(new Font("Tahoma", Font.BOLD, 18));
        SegedSzoveg3.setBounds(177, 278, 220, 36);
        SegedSzoveg3.setVisible(true);
        Ablak2.getContentPane().add(SegedSzoveg3);
        lblIgen.setForeground(Color.BLACK);
        lblIgen.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblIgen.setBounds(55, 120, 43, 31);
        
        Ablak2.getContentPane().add(lblIgen);
        lblBekapcsHome.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblBekapcsHome.setBounds(5, 30, 157, 22);
        
        Ablak2.getContentPane().add(lblBekapcsHome);
        lblKikapcsolEnd.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblKikapcsolEnd.setBounds(5, 50, 125, 22);
        
        Ablak2.getContentPane().add(lblKikapcsolEnd);
        lblIgen_1.setHorizontalAlignment(SwingConstants.LEFT);
        lblIgen_1.setForeground(Color.BLACK);
        lblIgen_1.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblIgen_1.setBounds(155, 140, 60, 31);
        
        Ablak2.getContentPane().add(lblIgen_1);
        lblMozgatsNyilak_1.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblMozgatsNyilak_1.setBounds(5, 70, 225, 22);
        
        Ablak2.getContentPane().add(lblMozgatsNyilak_1);
        lblGyakorisg.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblGyakorisg.setBounds(5, 100, 140, 31);
        
        Ablak2.getContentPane().add(lblGyakorisg);
        lblValtoztassmeg.setForeground(Color.BLACK);
        lblValtoztassmeg.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblValtoztassmeg.setBounds(150, 100, 43, 31);
        
        Ablak2.getContentPane().add(lblValtoztassmeg);
        lblszlelsekSzma.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblszlelsekSzma.setBounds(5, 160, 150, 31);
        
        Ablak2.getContentPane().add(lblszlelsekSzma);
        lblIgen_1_1.setHorizontalAlignment(SwingConstants.LEFT);
        lblIgen_1_1.setForeground(Color.BLACK);
        lblIgen_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblIgen_1_1.setBounds(160, 160, 60, 31);
        
        Ablak2.getContentPane().add(lblIgen_1_1);
        
        
        lblNumlock.setForeground(Color.RED);
        lblNumlock.setHorizontalAlignment(SwingConstants.CENTER);
        lblNumlock.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblNumlock.setBounds(5, 5, 157, 22);
        Ablak2.getContentPane().add(lblNumlock);
        
        JLabel lblHorgszatElindits = new JLabel("Bányászat elinditás:");
        lblHorgszatElindits.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblHorgszatElindits.setBounds(242, 30, 178, 22);
        Ablak2.getContentPane().add(lblHorgszatElindits);
        
        JLabel lblFgomb = new JLabel("F6 gomb");
        lblFgomb.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblFgomb.setBounds(430, 30, 80, 22);
        Ablak2.getContentPane().add(lblFgomb);
        lblAutomata.setHorizontalAlignment(SwingConstants.CENTER);
        
        lblAutomata.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblAutomata.setBounds(291, 5, 157, 22);
        
        Ablak2.getContentPane().add(lblAutomata);
        
        JLabel lblElemzesDelay = new JLabel("Elemzés Delay:");
        lblElemzesDelay.setHorizontalAlignment(SwingConstants.RIGHT);
        lblElemzesDelay.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblElemzesDelay.setBounds(250, 50, 150, 22);
        Ablak2.getContentPane().add(lblElemzesDelay);
        
        Elemzes_Textfield = new JTextField();
        Elemzes_Textfield.setText("4000");
        Elemzes_Textfield.setFont(new Font("Tahoma", Font.BOLD, 13));
        Elemzes_Textfield.setHorizontalAlignment(SwingConstants.CENTER);
        Elemzes_Textfield.setColumns(10);
        Elemzes_Textfield.setBounds(410, 50, 80, 20);
        Ablak2.getContentPane().add(Elemzes_Textfield);

        lblMilsec_3.setForeground(Color.BLACK);
        lblMilsec_3.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblMilsec_3.setBounds(494, 50, 43, 20);
        Ablak2.getContentPane().add(lblMilsec_3);

        lblFeladatIsmtls.setHorizontalAlignment(SwingConstants.RIGHT);
        lblFeladatIsmtls.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblFeladatIsmtls.setBounds(249, 110, 164, 22);
        Ablak2.getContentPane().add(lblFeladatIsmtls);
        
        IsmetlesSzor_Textfield = new JTextField();
        IsmetlesSzor_Textfield.setText("1");
        IsmetlesSzor_Textfield.setHorizontalAlignment(SwingConstants.CENTER);
        IsmetlesSzor_Textfield.setFont(new Font("Tahoma", Font.BOLD, 13));
        IsmetlesSzor_Textfield.setColumns(10);
        IsmetlesSzor_Textfield.setBounds(423, 110, 80, 20);
        Ablak2.getContentPane().add(IsmetlesSzor_Textfield);

        lblIsm.setForeground(Color.BLACK);
        lblIsm.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblIsm.setBounds(507, 110, 43, 20);
        Ablak2.getContentPane().add(lblIsm);

        lblJelenlegiKr.setHorizontalAlignment(SwingConstants.RIGHT);
        lblJelenlegiKr.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblJelenlegiKr.setBounds(249, 131, 164, 22);
        Ablak2.getContentPane().add(lblJelenlegiKr);

        lblJelenlegiKrSzma.setForeground(Color.BLACK);
        lblJelenlegiKrSzma.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblJelenlegiKrSzma.setBounds(423, 131, 43, 20);
        Ablak2.getContentPane().add(lblJelenlegiKrSzma);

        lblHtralvKrk.setHorizontalAlignment(SwingConstants.RIGHT);
        lblHtralvKrk.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblHtralvKrk.setBounds(249, 151, 164, 22);
        Ablak2.getContentPane().add(lblHtralvKrk);
        
       
        lblHtralvKrkSzama.setForeground(Color.BLACK);
        lblHtralvKrkSzama.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblHtralvKrkSzama.setBounds(423, 151, 43, 20);
        Ablak2.getContentPane().add(lblHtralvKrkSzama);
        
        JLabel Automata_Feladat_Most = new JLabel("Aktuális Rész:");
        Automata_Feladat_Most.setHorizontalAlignment(SwingConstants.RIGHT);
        Automata_Feladat_Most.setFont(new Font("Tahoma", Font.BOLD, 16));
        Automata_Feladat_Most.setBounds(217, 191, 125, 22);
        Ablak2.getContentPane().add(Automata_Feladat_Most);
        Automata_Feladat_Most_1.setHorizontalAlignment(SwingConstants.LEFT);
        Automata_Feladat_Most_1.setFont(new Font("Tahoma", Font.BOLD, 16));
        Automata_Feladat_Most_1.setBounds(345, 191, 205, 22);
        
        Ablak2.getContentPane().add(Automata_Feladat_Most_1);
        Automata_Feladat_Ido.setHorizontalAlignment(SwingConstants.LEFT);
        Automata_Feladat_Ido.setFont(new Font("Tahoma", Font.BOLD, 16));
        Automata_Feladat_Ido.setBounds(355, 216, 145, 22);
        
        Ablak2.getContentPane().add(Automata_Feladat_Ido);
        Automata_Feladat_Ido_Text.setForeground(Color.BLACK);
        Automata_Feladat_Ido_Text.setFont(new Font("Tahoma", Font.BOLD, 14));
        Automata_Feladat_Ido_Text.setBounds(500, 216, 20, 20);
        
        Ablak2.getContentPane().add(Automata_Feladat_Ido_Text);
        Automata_Feladat_Ido_Mpkiiras.setForeground(Color.BLACK);
        Automata_Feladat_Ido_Mpkiiras.setFont(new Font("Tahoma", Font.BOLD, 14));
        Automata_Feladat_Ido_Mpkiiras.setBounds(512, 216, 25, 20);
        
        Ablak2.getContentPane().add(Automata_Feladat_Ido_Mpkiiras);
        
        JButton Szinvalaszto_Btn = new JButton("Szín jelölés");
        Szinvalaszto_Btn.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mousePressed(MouseEvent e) {
        		JOptionPane.showMessageDialog(null, "A megjelölendő színen nyomj 'X' Gombot");
        		SzinMegjelol=true;
        		Szinjeloles_Aktiv_Boolean_label.setText("Igen");
        		Szinjeloles_Aktiv_Boolean_label.setForeground(Color.GREEN);
        		
        		
        		
        	}
        });
        Szinvalaszto_Btn.setBounds(5, 288, 113, 23);
        Ablak2.getContentPane().add(Szinvalaszto_Btn);
        
        JLabel Erzekelt_Szin_Label = new JLabel("Figyelt szín (R|G|B):");
        Erzekelt_Szin_Label.setFont(new Font("Tahoma", Font.BOLD, 16));
        Erzekelt_Szin_Label.setBounds(5, 224, 180, 31);
        Ablak2.getContentPane().add(Erzekelt_Szin_Label);
        
       
        Erzekelt_Szin_Piros.setForeground(Color.BLACK);
        Erzekelt_Szin_Piros.setFont(new Font("Tahoma", Font.BOLD, 16));
        Erzekelt_Szin_Piros.setBounds(180, 224, 30, 31);
        
        Ablak2.getContentPane().add(Erzekelt_Szin_Piros);

        Erzekelt_Szin_Zold.setForeground(Color.BLACK);
        Erzekelt_Szin_Zold.setFont(new Font("Tahoma", Font.BOLD, 16));
        Erzekelt_Szin_Zold.setBounds(217, 224, 30, 31);
        Ablak2.getContentPane().add(Erzekelt_Szin_Zold);
        
        
        Erzekelt_Szin_Kek.setForeground(Color.BLACK);
        Erzekelt_Szin_Kek.setFont(new Font("Tahoma", Font.BOLD, 16));
        Erzekelt_Szin_Kek.setBounds(256, 224, 30, 31);
        Ablak2.getContentPane().add(Erzekelt_Szin_Kek);
        Szinjeloles_Aktiv_Label.setFont(new Font("Tahoma", Font.BOLD, 16));
        Szinjeloles_Aktiv_Label.setBounds(5, 251, 113, 31);
        
        Ablak2.getContentPane().add(Szinjeloles_Aktiv_Label);
        Szinjeloles_Aktiv_Boolean_label.setFont(new Font("Tahoma", Font.BOLD, 16));
        Szinjeloles_Aktiv_Boolean_label.setBounds(120, 251, 43, 31);
        
        Ablak2.getContentPane().add(Szinjeloles_Aktiv_Boolean_label);
        lblUjrakezdesDelay_.setHorizontalAlignment(SwingConstants.RIGHT);
        lblUjrakezdesDelay_.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblUjrakezdesDelay_.setBounds(250, 80, 150, 22);
        
        Ablak2.getContentPane().add(lblUjrakezdesDelay_);
        UjrakezdesDealyInteger.setText("12000");
        UjrakezdesDealyInteger.setHorizontalAlignment(SwingConstants.CENTER);
        UjrakezdesDealyInteger.setFont(new Font("Tahoma", Font.BOLD, 13));
        UjrakezdesDealyInteger.setColumns(10);
        UjrakezdesDealyInteger.setBounds(410, 80, 80, 20);
        
        Ablak2.getContentPane().add(UjrakezdesDealyInteger);
        lblMilsec_3_1.setForeground(Color.BLACK);
        lblMilsec_3_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblMilsec_3_1.setBounds(494, 80, 43, 20);
        
        Ablak2.getContentPane().add(lblMilsec_3_1);

        // Billentyűfigyelő hozzáadása
        addKeyListener(this);

        // Időzített feladat az elemzés indításához
       
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                analyzeContent();
            }
        }, 0, sebesseg);
    }
        
        // Időzített feladat a horgászat elkezdéséhez
       

    
    private void probakfrissit() {
        talatokszamastring=Integer.toString(talatokszama);
        lblIgen_1.setText(talatokszamastring);
        
        probakstring=Integer.toString(probak);
        lblIgen_1_1.setText(probakstring);
        
    	lblIgen_1_1.setVisible(false);
    	lblIgen_1.setVisible(false);
    	lblIgen_1_1.setVisible(true);
    	lblIgen_1.setVisible(true);
    }

private static void ablak2Reset() {
    Ablak2.setVisible(false);
    Ablak2.setVisible(true);
}

    // Billentyűzet lenyomásának eseménykezelése
    private void restartTimer() {
    	
    	 
        timer.cancel(); // Megszakítjuk az aktuális időzítőt
        timer = new Timer(); // Létrehozzuk az új időzítőt
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                analyzeContent();
                
            }
        }, 0, sebesseg);
    }
    
    private void TimerGorgaszatStop() {
    	timer2.cancel();
    	timer2 = new Timer();
    	
    }
    
    private void restartTimerHorgaszat() throws AWTException {
    	Robot robot= new Robot();
    	EgerFrissit();
    	Automata_Feladat_Most_1.setText("Autómata szünetel");
    	
    	
   	 
        timer2.cancel(); // Megszakítjuk az aktuális időzítőt
        timer2 = new Timer(); // Létrehozzuk az új időzítőt
        timer2.scheduleAtFixedRate(new TimerTask() {
        	
            @Override
            public void run() {
            	if(lblHtralvKrkSzama.getText().equals("0")) {
            		IsmetlesSzor_Textfield.setText(Integer.toString(1));
            		Automata_Feladat_Ido_Text.setText("0");
            	}
            	if(horgaszatfut!=1&&!lblHtralvKrkSzama.getText().equals("0")) {
            		//System.out.println("Horgaszati szar");
            		JelenlegiKor++;
                    if(IsmetlesSzor_Textfield.getText().equals("")) {
                    	IsmetlesSzor_Textfield.setText("0");
                    }
                    HorgaszatKorIg=Integer.parseInt(IsmetlesSzor_Textfield.getText());
                    //Jelenlegi körök száma
                    lblJelenlegiKrSzma.setText(Integer.toString(JelenlegiKor));
                    //Hátralévő körök száma
                    lblHtralvKrkSzama.setText(Integer.toString(HorgaszatKorIg-JelenlegiKor));
                    if(lblHtralvKrkSzama.getText().equals("0")) {
                    	System.out.println("Lefutott az otlso kor");
                    	IsmetlesSzor_Textfield.setText("0");
                    	HorgaszatKorIg=Integer.parseInt(IsmetlesSzor_Textfield.getText());
                    	timer2.cancel();
                    }
                    //Itt kell megfogalmazni a horgaszatot úgy, hogy ha van thread akkor az ne üsse a kép feldolgozást
                    if(horgaszatfut!=1) {
                    	System.out.println("\nBányászat elkezdése");
                    	Automata_Feladat_Most_1.setText("Bányászat elkezdése");
   
                        robot.mousePress(InputEvent.BUTTON2_DOWN_MASK);
                        try {Thread.sleep(100);
                        	robot.keyPress(KeyEvent.VK_E);
							Thread.sleep(500);
	                        robot.keyRelease(KeyEvent.VK_E);
	                        robot.mouseRelease(InputEvent.BUTTON2_DOWN_MASK);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
                    }
                    
                    if(horgaszatfut!=1) {
                        try {
                        	//Elemzés elkezdésének ideje
                        	Automata_Feladat_Ido_Text.setText(Integer.toString(Integer.parseInt(Elemzes_Textfield.getText())/1000));
                        	Thread.sleep(Integer.parseInt(Elemzes_Textfield.getText()));
    						Automata_Feladat_Most_1.setText("Elemzés elindult");
    						
                            robot.mousePress(InputEvent.BUTTON2_DOWN_MASK);
                            robot.keyPress(KeyEvent.VK_HOME);
                            Thread.sleep(500);
                            robot.keyRelease(KeyEvent.VK_HOME);
                            robot.mouseRelease(InputEvent.BUTTON2_DOWN_MASK);
                            Automata_Feladat_Most_1.setText("Újkörig várakozás");
                            Thread.sleep(Integer.parseInt(UjrakezdesDealyInteger.getText()));
    					} catch (InterruptedException e) {
    						// TODO Auto-generated catch block
    						e.printStackTrace();
    					}
                    	
                    }
            	}
            	
            	
            	if(horgaszatfut==2) {
                    timer2.cancel();

            	}
            	if(horgaszatfut!=1&&lblHtralvKrkSzama.getText().equals("0")) {
            		lblHtralvKrkSzama.setText(Integer.toString(HorgaszatKorIg-JelenlegiKor));
            		if(Integer.parseInt(lblHtralvKrkSzama.getText())<0) {
            			 int adat=Integer.parseInt(lblHtralvKrkSzama.getText());
            			 adat=adat*(-1);
            			 lblHtralvKrkSzama.setText(Integer.toString(adat));
            			 System.out.println("Pozitivitas lefutott");
            			 Automata_Feladat_Most_1.setText("Alap ismetles megadva");
            		}
            		horgaszatfut=1;
            		JelenlegiKor=0;
            		lblJelenlegiKrSzma.setText(Integer.toString(JelenlegiKor));
            		timer2.cancel();
            		IsmetlesSzor_Textfield.setText("1");
            		
            		System.out.println("Uj ismetles beallitas");
       			 horgaszatfut=0;
       			setBackground(new Color(100, 0, 0, 40));
            }
            }
        }, 0, sebessegHorgaszat);


    }
    @Override
    public void keyReleased(KeyEvent e) {
        // Nem szükséges implementálni
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Nem szükséges implementálni
    }
    public void EgerFrissit() {
        Eger_X_Double=MouseInfo.getPointerInfo().getLocation().getX();
        Eger_Y_Double=MouseInfo.getPointerInfo().getLocation().getY();
         Eger_X=((int)(Eger_X_Double));
         Eger_Y=((int)(Eger_Y_Double));
    }
    


    private void analyzeContent() {
    	//Horgászati progressbar
        if (aktiv && !analysisInProgress) {
            analysisInProgress = true; // Elemzési folyamat elindítása

            // Elemzési folyamat aszinkron módon fut
            Thread analyzeThread = new Thread(() -> {
                try {
                    // Elemzési folyamat
                    Robot robot = new Robot();
                    BufferedImage screenshot = robot.createScreenCapture(new Rectangle(frameX, frameY, frameWidth+200, frameHeight+10));

                    // Az elemzési folyamat tartalma itt helyezkedik el
                    if (containsDesiredColor(screenshot)) {
                        System.out.println("A kívánt szín megtalálva!");
                        aktiv = false;
                        Ablak.setBackground(new Color(100, 0, 0, 40));
                        lblIgen.setText("Nem");
                       // kattintas(robot);
                        talatokszama++;
                        probakfrissit();
                        
                        robot.mousePress(InputEvent.BUTTON2_DOWN_MASK);
                        robot.keyPress(KeyEvent.VK_E);
                        Thread.sleep(50);
                        robot.keyRelease(KeyEvent.VK_E);
                        Thread.sleep(100);
                        robot.mouseRelease(InputEvent.BUTTON2_DOWN_MASK);
                       
                        
                        
                        talat = true;
                    } else {
                        System.out.println(Eger_X + " | " + Eger_Y);
                        System.out.println("A kép nem tartalmazza a kívánt színt.");
                        Ablak.setBackground(new Color(0, 100, 0, 40));
                        probak++;
                        probakfrissit();
                    }
                    if (talat) {
                        aktiv = false;
                        talat = false;
                    }
                } catch (AWTException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
                    analysisInProgress = false; // Elemzési folyamat befejezése
                }
            });

            // Elemzés indítása
            analyzeThread.start();
        }
    }

    @SuppressWarnings("unused")


    private boolean isDesiredColor(Color color) {
        int red = color.getRed();
        int green = color.getGreen();
        int blue = color.getBlue();
        
        Erzekelt_Szin_Piros.setText(Integer.toString(Keresett_Piros_Min));
        Erzekelt_Szin_Zold.setText(Integer.toString(Keresett_Zold_Min));
        Erzekelt_Szin_Kek.setText(Integer.toString(Keresett_Kek_Min));
        return red >= Keresett_Kek_Min && red <= Keresett_Kek_Max &&
               green >= Keresett_Zold_Min && green <= Keresett_Zold_Max &&
               blue >= Keresett_Kek_Min && blue <= Keresett_Kek_Max;
               
    }

    private boolean containsDesiredColor(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Color pixelColor = new Color(image.getRGB(x, y));
                if (isDesiredColor(pixelColor)) {
                    return true; // Ha találtunk egy megfelelő pixelt, akkor azonnal térjünk vissza
                }
            }
        }
        return false; // Ha végigértünk a képen, és nem találtunk megfelelő pixelt
    }

    private void setFrameVisibility(boolean visible) {
        SwingUtilities.invokeLater(() -> {
        	Ablak.setVisible(visible);
        	Ablak.repaint();
        });
    }
    
    //Panel mozgatása ha lenyomva van az egér
    public static void panelmozgat() {
    	pointerX= (int)MouseInfo.getPointerInfo().getLocation().getX();
    	pointerY=(int)MouseInfo.getPointerInfo().getLocation().getY();
    	
    	 timer2.scheduleAtFixedRate(new TimerTask() {
    		 int i =0;
    		 
             @Override
             public void run() {
            	int pointerX2= (int)MouseInfo.getPointerInfo().getLocation().getX();
             	int pointerY2=(int)MouseInfo.getPointerInfo().getLocation().getY();
             	if(pointerX2>pointerX) {
             		 Ablak2.setLocation((int)Ablak2.getLocation().getX()+(pointerX2-pointerX), (int)Ablak2.getLocation().getY());
             		 pointerX=pointerX2;
             	}else {
             		Ablak2.setLocation((int)Ablak2.getLocation().getX()-(pointerX-pointerX2), (int)Ablak2.getLocation().getY());
            		 pointerX=pointerX2;
             	}
             	if(pointerY2>pointerY) {
             		Ablak2.setLocation((int)Ablak2.getLocation().getX(), (int)Ablak2.getLocation().getY()+(pointerY2-pointerY));
             		pointerY=pointerY2;
             	}else {
             		Ablak2.setLocation((int)Ablak2.getLocation().getX(), (int)Ablak2.getLocation().getY()+(pointerY2-pointerY));
             		pointerY=pointerY2;
             	}
             	
            	 System.out.println(i);
            	 i++;
            	 Ablak2.setLocation((int)Ablak2.getLocation().getX(), (int)Ablak2.getLocation().getY());
                 
                 
             }
         },0, 10);
    }
    
    public static void elemzomozgat() {
    	pointerX= (int)MouseInfo.getPointerInfo().getLocation().getX();
    	pointerY=(int)MouseInfo.getPointerInfo().getLocation().getY();
    	
    	 timer2.scheduleAtFixedRate(new TimerTask() {
    		 int i =0;
    		 
             @Override
             public void run() {
            	int pointerX2= (int)MouseInfo.getPointerInfo().getLocation().getX();
             	int pointerY2=(int)MouseInfo.getPointerInfo().getLocation().getY();
             	if(pointerX2>pointerX) {
             		 Ablak.setLocation((int)Ablak.getLocation().getX()+(pointerX2-pointerX), (int)Ablak.getLocation().getY());
             		 pointerX=pointerX2;
             		 frameX=pointerX;
             	}else {
             		Ablak.setLocation((int)Ablak.getLocation().getX()-(pointerX-pointerX2), (int)Ablak.getLocation().getY());
            		 pointerX=pointerX2;
            		 frameX=pointerX;
             	}
             	if(pointerY2>pointerY) {
             		Ablak.setLocation((int)Ablak.getLocation().getX(), (int)Ablak.getLocation().getY()+(pointerY2-pointerY));
             		pointerY=pointerY2;
             		frameY=pointerY;
             	}else {
             		Ablak.setLocation((int)Ablak.getLocation().getX(), (int)Ablak.getLocation().getY()+(pointerY2-pointerY));
             		pointerY=pointerY2;
             		frameY=pointerY;
             	}
             	
            	 System.out.println(i);
            	 i++;
            	 Ablak.setLocation((int)Ablak.getLocation().getX(), (int)Ablak.getLocation().getY());
                 
                 
             }
         },0, 10);
    }
    
    public void panelleark() {
    	
    	timer2.cancel();
    	timer2=new Timer();
    
    }
    
    
    
    //Felismerő keret mozgatása ha lenyomva van az egér
    
    

    public static void main(String[] args) throws AWTException {
        new main();
        try {
			Thread.sleep(10);
			ablak2Reset();
			 
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
