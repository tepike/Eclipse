package Program;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.AWTException;

import java.awt.Color;

import java.awt.Toolkit;

import javax.swing.JTextField;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.MouseInfo;

import java.awt.Robot;

import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;

import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JButton;

import java.awt.event.InputEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.time.LocalTime;
import java.util.ArrayList;

import java.util.List;
import java.util.Random;
import java.util.Timer;

import javax.swing.JCheckBox;

import java.util.TimerTask;


public class AutoClickerBeta implements NativeKeyListener{
	

   

	private JFrame frame;
	private JTextField Ora;
	private JTextField Perc;
	private JTextField Masodperc;
	private static JTextField Milisec;
	private static JTextField Kattintas_X_Poz_Textfield;
	private static JTextField Kattintas_Y_Poz_Textfield;
	boolean Ism_Sor=false;
	boolean Ism_Vegtelen=false;
	static List<String> interfaceNames = new ArrayList<>();
	static int listahossza=1;
	
	JButton Gyorsgomb_gomb = new JButton("Gyorsgomb beállítás");
	JButton Stop_gomb = new JButton("Stop");
	@SuppressWarnings("rawtypes")
	static JComboBox Internet_comboBox = new JComboBox();
	static JCheckBox Internet_Lekapcs_Box = new JCheckBox("Internet lekapcsolás");
	JRadioButton Kattintas_Poz_Aktualis_Radio_Gomb = new JRadioButton("Egér követése");
	static JRadioButton IsmetlesVegtelen_Radio_Gomb = new JRadioButton("Ismétlés megállításig");
	static JLabel Kattintas_Ismetles_Fejlec_1 = new JLabel("Kattintási ismétlés");
	static JRadioButton Ismetles_Radio_Gomb = new JRadioButton("Ismétlés hányszor:");
	static JCheckBox VedelemCheckBox = new JCheckBox("Vedelem Be\\Ki");
	
	static double Eger_Poz_X;
	static double Eger_Poz_Y;
	static double Eger_Poz_X2;
	static double Eger_Poz_Y2;
	Boolean X_Keres_Aktiv=true;

	static JSpinner spinner = new JSpinner();
	static int SpinnerErtek=0;
	static boolean frissites=true;
	static int masodperc;
	static int masodperc2=LocalTime.now().getSecond();
	static boolean running;
	static boolean Egerrunning;
	static boolean AutoclickRunning;
	static boolean GyorsgombRunning;
	static boolean F6Bekapcsolva=true;
	static Timer timer = new Timer();
	static Timer timer2 = new Timer();
	static Timer timer3 = new Timer();
	static Timer timer4 = new Timer();
	static int Helyi_X=0;
	static int Helyi_Y=0;
	static int F6Integer =0;
	static boolean KattintasMegjelolve=false;
	static int Milsec=1000;
	static boolean vedelem=true;
	static int figyeles=0;
	
	
	
	
	

	//Thread.sleep(1000); // 1000 milliszekundum = 1 másodperc
	
    public void nativeKeyPressed(NativeKeyEvent e) {
    	
        if (e.getKeyCode() == NativeKeyEvent.VC_F6) {
            System.out.println("F6 megnyomva!");
            F6Integer++;
        }
        if (F6Integer==1&e.getKeyCode() == NativeKeyEvent.VC_F6) {
            System.out.println("F6 bekapcsolva!");
            AutoClickStart();
            System.out.println(F6Integer);
        }
        if (F6Integer==2&e.getKeyCode() == NativeKeyEvent.VC_F6) {
            System.out.println("F6 kikapcsolva!");
            System.out.println(F6Integer);
            AutoClickStop();
            
            
        }
    }
	
public static void TimeStart() {
	if (running==false) {
		System.out.println("\n\tTimer false ugyhogy indul");
		TimerTask task=new TimerTask() {
			int i=1;
			public void run() {
				
				System.out.println("Timer fut: "+i);
				i++;
			}		
		};
		timer.scheduleAtFixedRate(task, 100, 100);
	}
	running=true;
}

public static void GyorsgombStart() {
	if (running==false) {
		System.out.println("Gyorsgomb figyeles elindult");
		TimerTask task=new TimerTask() {
			public void run() {
				

			}		
		};
		timer.scheduleAtFixedRate(task, 10, 10);
	}
	running=true;
}

public static void EgerStart() {
	if (Egerrunning==false) {
		System.out.println("\n\tEger idofigyelo pozicio rogzites elindult");
		TimerTask task=new TimerTask() {
			public void run() {
				 Eger_Poz_X = MouseInfo.getPointerInfo().getLocation().getX();
				 Eger_Poz_Y = MouseInfo.getPointerInfo().getLocation().getY();
				 
					 int EgerX=(int)Eger_Poz_X;
					 String EgerX_String=String.valueOf(EgerX);
					 Kattintas_X_Poz_Textfield.setText(EgerX_String);
					
					 
					 int EgerY=(int)Eger_Poz_Y;
					 String EgerY_String=String.valueOf(EgerY);
					 Kattintas_Y_Poz_Textfield.setText(EgerY_String);
				 
				Helyi_X= Integer.parseInt(Kattintas_X_Poz_Textfield.getText());
				Helyi_Y= Integer.parseInt(Kattintas_Y_Poz_Textfield.getText());
				
				//Teszt üzem, hogy ha nem rögzített egér pozíciót attól függően, hogy a gomb meg lett nyomva akkor force indítja megint.
				if(!Egerrunning&&Kattintas_Y_Poz_Textfield.getText().length()==0) {
					try {
						Thread.sleep(300);
						Eger_Poz_X = MouseInfo.getPointerInfo().getLocation().getX();
						Eger_Poz_Y = MouseInfo.getPointerInfo().getLocation().getY();
						Helyi_X= Integer.parseInt(Kattintas_X_Poz_Textfield.getText());
						Helyi_Y= Integer.parseInt(Kattintas_Y_Poz_Textfield.getText());
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					
				}
				 

			}		
		};
		timer2.scheduleAtFixedRate(task, 10, 10);
	}
	Egerrunning=true;
}

public static void AutoClickStart() {
	Milsec=Integer.parseInt(Milisec.getText());
	if(vedelem&&Integer.parseInt(Milisec.getText())<20) {
		JOptionPane.showMessageDialog(null, "Veszélyes érték megadva! 20 alatt crashel a játék");
		Milsec=20;
		Milisec.setText("20");
		return;
		
	}
	if(Kattintas_X_Poz_Textfield.getText().length()==0) {
		System.out.println("Nincs megadva koordinata");
		F6Integer=0;
		JOptionPane.showMessageDialog(null, "Nincs kattintási koordináta megadva!");
	}
	

//Végtelenített klikkelés
	if (AutoclickRunning==false&&Kattintas_X_Poz_Textfield.getText().length()>0&&IsmetlesVegtelen_Radio_Gomb.isSelected()) {
		internet();
		if(Egerrunning) {
			EgerStart();
		}

		TimerTask task=new TimerTask() {
			public void run() {
				System.out.println("Start gomb megnyomva");
				internet();
					Robot robot = null;
					try {
						robot = new Robot();
					} catch (AWTException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					robot.mouseMove(Helyi_X, Helyi_Y);
	                robot.mousePress(InputEvent.BUTTON1_DOWN_MASK); // Egér bal gomb lenyomása
	                robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK); // Egér bal gomb felengedése
			}		
		};
		timer3.scheduleAtFixedRate(task, Milsec, Milsec);
	}
	
//Auto klikker kattintás a megadott mennyiségig a megadott pontra.
	if (AutoclickRunning==false&&Kattintas_X_Poz_Textfield.getText().length()>0&&Ismetles_Radio_Gomb.isSelected()) {
		Helyi_X= Integer.parseInt(Kattintas_X_Poz_Textfield.getText());
		Helyi_Y= Integer.parseInt(Kattintas_Y_Poz_Textfield.getText());
		
			internet();
		
	TimerTask task=new TimerTask() {
		public void run() {
			SpinnerErtek=(Integer)spinner.getValue();	
			
			System.out.println("Start gomb megnyomva");
			internet();
				Robot robot = null;
				try {
					robot = new Robot();
				} catch (AWTException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				robot.mouseMove(Helyi_X, Helyi_Y);
				System.out.println("Helyi_X erteke: "+Helyi_X);
                robot.mousePress(InputEvent.BUTTON1_DOWN_MASK); // Egér bal gomb lenyomása
                robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK); // Egér bal gomb felengedése
                figyeles++;
                System.out.println("\nFigyeles szam: "+figyeles);
                System.out.println("Spinner szam: "+SpinnerErtek);
                if(figyeles==(SpinnerErtek)) {
                	AutoClickStop();
                	figyeles=0;
                }
                
                //ide kell berakni, hogy figyelje a kattintás számokat. (AutoclickRunning = false;)
		}		
	};
	timer3.scheduleAtFixedRate(task, Milsec, Milsec);
	}
	

	
	
	
	
	
	//AutoclickRunning=true;
}



public static void TimeStop() {
    if (timer != null) {
        timer.cancel();
        System.out.println("\n\tTimer nem fut");
        running = false;
       timer = new Timer();
    }
}

public static void GyorsgombStop() {
    if (timer != null) {
        timer.cancel();
        System.out.println("\n\tTimer nem fut");
        running = false;
       timer = new Timer();
    }
}

public static void EgerStop() {
    if (timer2 != null) {
    	timer2.cancel();
        System.out.println("\n\tTimer nem fut");
        Egerrunning = false;
        timer2 = new Timer();
    }
}

public static void AutoClickStop() {
    if (timer3 != null) {
    	timer3.cancel();
        System.out.println("\n\tTimer nem fut");
        AutoclickRunning = false;
        timer3 = new Timer();
        F6Integer=0;
    }
}
	
	

	public static void main(String[] args) throws IOException, InterruptedException {
		
		
		//Billenytűzet figyelő
        try {
            GlobalScreen.registerNativeHook();
        } catch (NativeHookException ex) {
            System.err.println("Hiba a globális billentyűzetfigyelő regisztrálásakor: " + ex.getMessage());
            System.exit(1);
        }

        GlobalScreen.addNativeKeyListener(new AutoClickerBeta());

        //Eddig tart a billentyűzet figyelés

        try {
            // Parancs létrehozása a hálózati adapterek listázására
            ProcessBuilder builder = new ProcessBuilder("ipconfig", "/all");
            builder.redirectErrorStream(true);

            // Parancs futtatása
            Process process = builder.start();

            // Parancs kimenetének olvasása
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;

            // Az adapter nevek kiírása
            while ((line = reader.readLine()) != null) {
                // Ellenőrizzük, hogy az aktuális sor tartalmazza-e az "Ethernet" címet
                if (line.contains("Ethernet")) {
                    // Az interfész nevét a következő sorban találjuk
                    int index = line.indexOf("Ethernet") + "Ethernet adapter".length(); // Az "Ethernet" szöveg utáni rész kezdeti indexe
                    String adapterInfo = line.substring(index).trim();
                    // Többi kötőjel eltávolítása
                    adapterInfo = adapterInfo.replace(":", "").trim();
                    // Tömbhöz adás
                    interfaceNames.add(adapterInfo);
                    listahossza=listahossza+1;
                }
            }

            // Parancs lezárása
            process.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        // Kiírás
        System.out.println("Halozati adapterek:");
        for (String name : interfaceNames) {
            System.out.println(name);
            
        }
        System.out.println("Print1: "+interfaceNames.get(0));
        System.out.println("Print2: "+interfaceNames.get(1));
    
		
		
		
		 @SuppressWarnings("unused")
		String originalGateway = getGateway();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AutoClickerBeta window = new AutoClickerBeta();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	@SuppressWarnings("unused")
	private static Object idoszamolo(int i) {
		// TODO Auto-generated method stub
		return null;
	}


	
	
	/**
	 * Create the application.
	 */
	public AutoClickerBeta() {
        initialize();

    }
		
		
	

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initialize() {
	    

	    
		
		Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		int KepernyoSzeles=(int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		int KepernyoMagas=(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		
		frame = new JFrame();
		frame.setBounds(KepernyoSzeles/2-300, KepernyoMagas/2-200, 600, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("A makkrók csúúúcsa");
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		JPanel Alapkep = new JPanel();
		Alapkep.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				System.out.println("Billentyu lenyomva");
				 SpinnerErtek=(Integer)spinner.getValue();		
				 }
			
			
		});
		

		
		Alapkep.setBackground(new Color(235, 235, 235));
		Alapkep.setBounds(0, 0, 584, 461);
		frame.getContentPane().add(Alapkep);
		Alapkep.setLayout(null);
		
		JPanel Kattintas_Ido_lec = new JPanel();
		Kattintas_Ido_lec.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		Kattintas_Ido_lec.setBounds(10, 5, 564, 75);
		Alapkep.add(Kattintas_Ido_lec);
		Kattintas_Ido_lec.setLayout(null);
		
		Ora = new JTextField();
		Ora.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Ora.setHorizontalAlignment(SwingConstants.RIGHT);
		Ora.setBounds(61, 35, 80, 29);
		Kattintas_Ido_lec.add(Ora);
		Ora.setColumns(10);
		
		Perc = new JTextField();
		Perc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Perc.setHorizontalAlignment(SwingConstants.RIGHT);
		Perc.setColumns(10);
		Perc.setBounds(176, 35, 80, 29);
		Kattintas_Ido_lec.add(Perc);
		
		Masodperc = new JTextField();
		Masodperc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Masodperc.setHorizontalAlignment(SwingConstants.RIGHT);
		Masodperc.setColumns(10);
		Masodperc.setBounds(291, 35, 80, 29);
		Kattintas_Ido_lec.add(Masodperc);
		
		Milisec = new JTextField();
		Milisec.setText("1000");
		Milisec.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Milisec.setHorizontalAlignment(SwingConstants.RIGHT);
		Milisec.setColumns(10);
		Milisec.setBounds(406, 35, 80, 29);
		Kattintas_Ido_lec.add(Milisec);
		if(Milisec.getText().length()>0) {
			Milsec=Integer.parseInt(Milisec.getText());
		}
		
		JLabel Ora_Label = new JLabel("Óra");
		Ora_Label.setBounds(151, 42, 31, 14);
		Kattintas_Ido_lec.add(Ora_Label);
		
		JLabel Perc_Label = new JLabel("Perc");
		Perc_Label.setBounds(260, 42, 31, 14);
		Kattintas_Ido_lec.add(Perc_Label);
		
		JLabel Masodperc_Label = new JLabel("Mp");
		Masodperc_Label.setBounds(381, 42, 58, 14);
		Kattintas_Ido_lec.add(Masodperc_Label);
		
		JLabel Milisec_Label = new JLabel("Milisec");
		Milisec_Label.setBounds(496, 42, 58, 14);
		Kattintas_Ido_lec.add(Milisec_Label);


		
		JLabel Ido_Fejlec = new JLabel("Kattintási gyakoriság");
		Ido_Fejlec.setFont(new Font("Tahoma", Font.BOLD, 16));
		Ido_Fejlec.setBounds(189, 0, 174, 24);
		Kattintas_Ido_lec.add(Ido_Fejlec);
		
		
		VedelemCheckBox.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				if(VedelemCheckBox.isSelected()) {
					vedelem=true;
					System.out.println("Vedelem bekapcsolva");
				}else {
					vedelem=false;
					System.out.println("Vedelem kikapcsolva");
				}
			}
		});
		VedelemCheckBox.setBounds(406, 3, 135, 23);
		VedelemCheckBox.setSelected(true);
		Kattintas_Ido_lec.add(VedelemCheckBox);
		
		JPanel Kattintas_lec = new JPanel();
		Kattintas_lec.setLayout(null);
		Kattintas_lec.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		Kattintas_lec.setBounds(10, 91, 270, 117);
		Alapkep.add(Kattintas_lec);
		
		JLabel Eger_Kattintas_label = new JLabel("Egér lenyomás");
		Eger_Kattintas_label.setFont(new Font("Tahoma", Font.BOLD, 13));
		Eger_Kattintas_label.setBounds(22, 38, 113, 20);
		Kattintas_lec.add(Eger_Kattintas_label);
		
		JLabel Kattintas_Fejlec = new JLabel("Kattintási gyakoriság");
		Kattintas_Fejlec.setFont(new Font("Tahoma", Font.BOLD, 16));
		Kattintas_Fejlec.setBounds(38, 7, 174, 24);
		Kattintas_lec.add(Kattintas_Fejlec);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setEnabled(false);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Bal egér", "Jobb egér", "Görgő"}));
		comboBox.setBounds(131, 38, 127, 22);
		Kattintas_lec.add(comboBox);
		
		JLabel Kattintas_Tipusa_label = new JLabel("Kattintás típusa");
		Kattintas_Tipusa_label.setFont(new Font("Tahoma", Font.BOLD, 13));
		Kattintas_Tipusa_label.setBounds(22, 67, 113, 20);
		Kattintas_lec.add(Kattintas_Tipusa_label);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setEnabled(false);
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Szimpla kattintas", "Dupla kattintas"}));
		comboBox_1.setBounds(131, 67, 127, 22);
		Kattintas_lec.add(comboBox_1);
		
		JPanel Kattintas_Szor_lec_1 = new JPanel();

		Kattintas_Szor_lec_1.setLayout(null);
		Kattintas_Szor_lec_1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		Kattintas_Szor_lec_1.setBounds(290, 91, 281, 117);
		Alapkep.add(Kattintas_Szor_lec_1);
		
		
		spinner.setModel(new SpinnerNumberModel(Integer.valueOf(1), null, null, Integer.valueOf(1)));
		spinner.setBounds(173, 43, 60, 25);
		Kattintas_Szor_lec_1.add(spinner);
		

		Kattintas_Ismetles_Fejlec_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		Kattintas_Ismetles_Fejlec_1.setBounds(44, 11, 174, 24);
		Kattintas_Szor_lec_1.add(Kattintas_Ismetles_Fejlec_1);
		

		Ismetles_Radio_Gomb.setFont(new Font("Tahoma", Font.BOLD, 14));
		Ismetles_Radio_Gomb.setBounds(6, 42, 161, 23);
		Kattintas_Szor_lec_1.add(Ismetles_Radio_Gomb);

		
		
		
		IsmetlesVegtelen_Radio_Gomb.setFont(new Font("Tahoma", Font.BOLD, 14));
		IsmetlesVegtelen_Radio_Gomb.setBounds(6, 68, 174, 23);
		Kattintas_Szor_lec_1.add(IsmetlesVegtelen_Radio_Gomb);
		
		
		JPanel Kattintas_Poz_lec = new JPanel();
		Kattintas_Poz_lec.setLayout(null);
		Kattintas_Poz_lec.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		Kattintas_Poz_lec.setBounds(10, 219, 564, 75);
		Alapkep.add(Kattintas_Poz_lec);
		
		Kattintas_X_Poz_Textfield = new JTextField();
		Kattintas_X_Poz_Textfield.setHorizontalAlignment(SwingConstants.RIGHT);
		Kattintas_X_Poz_Textfield.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Kattintas_X_Poz_Textfield.setColumns(10);
		Kattintas_X_Poz_Textfield.setBounds(380, 35, 80, 24);
		Kattintas_Poz_lec.add(Kattintas_X_Poz_Textfield);
		
		JLabel Ido_Fejlec_1 = new JLabel("Kattintási pozíció");
		Ido_Fejlec_1.setBounds(4, 1, 174, 24);
		Kattintas_Poz_lec.add(Ido_Fejlec_1);
		Ido_Fejlec_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		
		Kattintas_Poz_Aktualis_Radio_Gomb.setBounds(4, 35, 135, 23);
		Kattintas_Poz_lec.add(Kattintas_Poz_Aktualis_Radio_Gomb);
		
		JButton Kattintas_Pozicio_Fix_NyomoGomb = new JButton("Pozíció megjelölése");
		Kattintas_Pozicio_Fix_NyomoGomb.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				//Toolkit.getDefaultToolkit().beep();  //Alert sound
				JOptionPane.showMessageDialog(null, "Pozíció véglegesítéséhez nyomj X gombot");
				
		
				
			}
		});
		Kattintas_Pozicio_Fix_NyomoGomb.setBounds(205, 35, 150, 23);
		Kattintas_Poz_lec.add(Kattintas_Pozicio_Fix_NyomoGomb);
		
		
		JLabel Kattintas_X_Poz_label = new JLabel("X");
		Kattintas_X_Poz_label.setBounds(365, 35, 21, 24);
		Kattintas_Poz_lec.add(Kattintas_X_Poz_label);
		Kattintas_X_Poz_label.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel Kattintas_Y_Poz_label = new JLabel("Y");
		Kattintas_Y_Poz_label.setFont(new Font("Tahoma", Font.BOLD, 16));
		Kattintas_Y_Poz_label.setBounds(463, 35, 21, 24);
		Kattintas_Poz_lec.add(Kattintas_Y_Poz_label);
		
		Kattintas_Y_Poz_Textfield = new JTextField();
		Kattintas_Y_Poz_Textfield.setHorizontalAlignment(SwingConstants.RIGHT);
		Kattintas_Y_Poz_Textfield.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Kattintas_Y_Poz_Textfield.setColumns(10);
		Kattintas_Y_Poz_Textfield.setBounds(475, 35, 80, 24);
		Kattintas_Poz_lec.add(Kattintas_Y_Poz_Textfield);
		
		JButton Start_gomb = new JButton("Start");

		Start_gomb.setBounds(41, 389, 155, 56);
		Alapkep.add(Start_gomb);
		
		

		Stop_gomb.setBounds(377, 389, 155, 56);
		Alapkep.add(Stop_gomb);
		
		

		Gyorsgomb_gomb.setBounds(212, 389, 155, 56);
		Alapkep.add(Gyorsgomb_gomb);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 303, 564, 75);
		Alapkep.add(panel);
		panel.setLayout(null);
		
		JLabel Internet_Fejlec = new JLabel("Internet adapter");
		Internet_Fejlec.setFont(new Font("Tahoma", Font.BOLD, 16));
		Internet_Fejlec.setBounds(10, 11, 147, 32);
		panel.add(Internet_Fejlec);
		
		
		for(int i=0;i<listahossza;i++) {
			if (i==1) {
				Internet_comboBox.setModel(new DefaultComboBoxModel(new String[] {interfaceNames.get(0)}));
			}else if(i==2) {
				Internet_comboBox.setModel(new DefaultComboBoxModel(new String[] {interfaceNames.get(0),interfaceNames.get(1)}));

			}else if(i==3) {
				Internet_comboBox.setModel(new DefaultComboBoxModel(new String[] {interfaceNames.get(0),interfaceNames.get(1),interfaceNames.get(2)}));

			}else if(i==4) {
				Internet_comboBox.setModel(new DefaultComboBoxModel(new String[] {interfaceNames.get(0),interfaceNames.get(1),interfaceNames.get(2),interfaceNames.get(3)}));

			}
			
		}
		Internet_comboBox.setBounds(202, 18, 130, 22);
		panel.add(Internet_comboBox);
		
		
		Internet_Lekapcs_Box.setBounds(367, 18, 147, 23);
		panel.add(Internet_Lekapcs_Box);
		
		

																		//Clicked activityy
		// Ismétlés x-ig gomb aktiválás
		Ismetles_Radio_Gomb.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				IsmetlesVegtelen_Radio_Gomb.setSelected(false);
				KattintasMegjelolve=true;

				
			}
		});
		
		//Ismétlés végtelenig gomb aktiválás
		IsmetlesVegtelen_Radio_Gomb.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				Ismetles_Radio_Gomb.setSelected(false);
				KattintasMegjelolve=true;

			
			}
		});
		
	

		
		Kattintas_Szor_lec_1.addMouseListener(new MouseAdapter() {
			public void mouseExited(MouseEvent e) {
				try {
					Robot Robot= new Robot();
					Robot.keyPress(KeyEvent.VK_ENTER);
				} catch (AWTException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				}
		});
		
		//Egér követés gomb aktiválás
		Kattintas_Poz_Aktualis_Radio_Gomb.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
			if(Kattintas_Poz_Aktualis_Radio_Gomb.isSelected()) {
				EgerStart();
			}else {
				EgerStop();
			}
			}
		});
		
		
		
		Kattintas_Pozicio_Fix_NyomoGomb.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				X_Keres_Aktiv=true;
				System.out.println("Vidd az egeret a választandó pontra, majd nyomj 'x' betűt");
				Kattintas_Pozicio_Fix_NyomoGomb.addKeyListener(new KeyAdapter() {
					
				    public void keyPressed(KeyEvent e) {
				    	
				    	
				        if (X_Keres_Aktiv&e.getKeyChar() == 'x' || e.getKeyChar() == 'X') {
				            // Ha a felhasználó az 'x' vagy 'X' karaktert nyomja le
				            System.out.println("Az 'x' karakter lenyomva!");
				            System.out.println("Az eger pozicioja, ahol az 'x' karaktert lenyomtak: X=" + MouseInfo.getPointerInfo().getLocation().getX() + ", Y=" + MouseInfo.getPointerInfo().getLocation().getY());
				            
							 int Eger_Poz_X=(int)MouseInfo.getPointerInfo().getLocation().getX();
							 String Eger_Poz_X_String=String.valueOf(Eger_Poz_X);
							 Kattintas_X_Poz_Textfield.setText(Eger_Poz_X_String);
							 
							 int Eger_Poz_Y=(int)MouseInfo.getPointerInfo().getLocation().getY();
							 String Eger_Poz_Y_String=String.valueOf(Eger_Poz_Y);
							 Kattintas_Y_Poz_Textfield.setText(Eger_Poz_Y_String);
							
								JOptionPane.showMessageDialog(null, "Pozíció megjelölve");

							 X_Keres_Aktiv=false;
				            // Itt folytathatja a további műveleteket az egér pozíciójával
				        }
				        
				    }
				}); 
				
			}

			
			
		});
		
		
		
		Start_gomb.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if(vedelem&&Integer.parseInt(Milisec.getText())<20) {
					JOptionPane.showMessageDialog(null, "Veszélyes érték megadva! 20 alatt crashel a játék");
					Milsec=20;
					Milisec.setText("20");
				}
				if(IsmetlesVegtelen_Radio_Gomb.isSelected()==false&Ismetles_Radio_Gomb.isSelected()==false) {
					KattintasMegjelolve=false;
			}
				F6Bekapcsolva=true;
				System.out.println("Kattintas megjelolve: "+KattintasMegjelolve);


				
				if(Kattintas_X_Poz_Textfield.getText().length()==0) {
					System.out.println("Nincs megadva koordinata");
					JOptionPane.showMessageDialog(null, "Nincs kattintási koordináta megadva!");
					F6Integer=0;
					
					
				}
				if(!KattintasMegjelolve) {
					JOptionPane.showMessageDialog(null, "Nincs kattintási ismétlés megjelölve!");
					F6Integer=0;
				}
				 
//Ha be van pipálva az, hogy mennyiszer
				if(Ismetles_Radio_Gomb.isSelected()&Kattintas_X_Poz_Textfield.getText().length()>0) {
					Helyi_X= Integer.parseInt(Kattintas_X_Poz_Textfield.getText());
					Helyi_Y= Integer.parseInt(Kattintas_Y_Poz_Textfield.getText());
					SpinnerErtek=(Integer)spinner.getValue();
					//System.out.println(Helyi_X);
					System.out.println("Start gomb megnyomva");
					internet();
					for(int i=0;i<SpinnerErtek+1;i++) {
						Robot robot = null;
						try {
							robot = new Robot();
						} catch (AWTException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						robot.mouseMove(Helyi_X, Helyi_Y);
		                robot.mousePress(InputEvent.BUTTON1_DOWN_MASK); // Egér bal gomb lenyomása
		                robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK); // Egér bal gomb felengedése
		                robot.delay(Milsec); // 1 másodperc várakozás a kattintások között
						//System.out.println("Eger kattintva: "+Helyi_X);
				}if(Ismetles_Radio_Gomb.isSelected()&Kattintas_X_Poz_Textfield.getText().length()==0) {
					System.out.println("Nincs megadva koordinata");
					F6Integer=0;
				}
				}
//Végtelenített klikkelés
				if(IsmetlesVegtelen_Radio_Gomb.isSelected()&Kattintas_X_Poz_Textfield.getText().length()>0) {
					Helyi_X= Integer.parseInt(Kattintas_X_Poz_Textfield.getText());
					Helyi_Y= Integer.parseInt(Kattintas_Y_Poz_Textfield.getText());
					Robot robot = null;
					try {
						robot = new Robot();
					} catch (AWTException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					robot.mouseMove(Helyi_X, Helyi_Y);
					
					internet();
					AutoClickStart();
					
				}
			}
		});
		
		Gyorsgomb_gomb.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {

			}
		});
		
		Stop_gomb.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				TimeStop();
				EgerStop();
				AutoClickStop();
				F6Bekapcsolva=false;
				
			}
		});
		
		

		spinner.addChangeListener((ChangeListener) new ChangeListener() {
		    public void stateChanged(ChangeEvent e) {
		        // Az új érték lekérése a spinnerből
		        int newValue = (int) spinner.getValue();
		        
		        // Itt tedd meg azokat a lépéseket, amelyeket végrehajtasz az új értékkel
		        // például frissítheted a grafikus felületet vagy végrehajthatsz más műveleteket
		        // Ebben a példában csak kiírjuk az új értéket a konzolra
		        System.out.println("Az új érték: " + newValue);
		    }
		});
		
		
	}	
	


	public static void internet() {
		if(Internet_Lekapcs_Box.isSelected()) {
        try {
            // Véletlenszerűen generált új átjáró IP cím
            String newGateway = generateRandomGateway();

            // Hálózati kapcsolat letiltása
            disableNetwork();

            // Új átjáró beállítása
            setGateway(newGateway);

            // Hálózati kapcsolat engedélyezése
            enableNetwork();

            // Visszaállítás az eredeti átjáróra
            setGateway(newGateway);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
		}
		
    }

    // Metódus az eredeti átjáró IP címének lekérésére
    private static String getGateway() throws IOException {
        ProcessBuilder builder = new ProcessBuilder("route", "print", "-4");
        builder.redirectErrorStream(true);
        Process process = builder.start();
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        String gateway = "";
        while ((line = reader.readLine()) != null) {
            if (line.contains("0.0.0.0")) {
                String[] parts = line.trim().split("\\s+");
                gateway = parts[2];
                break;
            }
        }
        return gateway;
    }

    // Metódus az átjáró beállítására
    private static void setGateway(String gateway) throws IOException, InterruptedException {
        ProcessBuilder builder = new ProcessBuilder("route", "change", "0.0.0.0", "mask", "0.0.0.0", gateway);
        builder.redirectErrorStream(true);
        Process process = builder.start();
        process.waitFor();
    }

    // Metódus a hálózati kapcsolat letiltására
    private static void disableNetwork() throws IOException, InterruptedException {
    	Object lekeres = Internet_comboBox.getSelectedItem();
    	ProcessBuilder builder = new ProcessBuilder("netsh", "interface", "set", "interface", "name=\"" + lekeres + "\"", "admin=disable");
        builder.redirectErrorStream(true);
        Process process = builder.start();
        process.waitFor();
    }

    // Metódus a hálózati kapcsolat engedélyezésére
    private static void enableNetwork() throws IOException, InterruptedException {
    	Object lekeres = Internet_comboBox.getSelectedItem();
    	ProcessBuilder builder = new ProcessBuilder("netsh", "interface", "set", "interface", "name=\"" + lekeres + "\"", "admin=enable");
        builder.redirectErrorStream(true);
        Process process = builder.start();
        process.waitFor();
    }

    // Metódus véletlenszerű átjáró IP cím generálására
    private static String generateRandomGateway() {
        Random rand = new Random();
        return "192.168." + rand.nextInt(256) + "." + rand.nextInt(256);
    }
	}


