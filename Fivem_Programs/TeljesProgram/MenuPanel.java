package TeljesProgram;

import java.awt.Color;
import java.awt.Font;
import java.awt.Menu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;

public class MenuPanel extends Grafikus {
	public static JPanel MenuPanel= new JPanel();
	public static JPanel panel= new JPanel();
	
	private JLabel Jelszo_Szoveg = new JLabel("Jelszó:");
	public static JLabel Felhasznalonev_Szoveg = new JLabel("Felhasználónév:");
	final JLabel BejelentkezoDoboz_Szoveg = new JLabel("Bejelentkezés");
	
	public JTextField Felhasznalonev_TextFielad;
	private JPasswordField Jelszo_Textfield;
	

	
	JButton btnNewButton = new JButton("Bejelentkezés");
	
	/**
	 * @throws InterruptedException 
	 * @wbp.parser.entryPoint
	 */
	
	public void Bejelentkezo_Menu() throws InterruptedException {
		
		panel.setForeground(new Color(0, 0, 0));
		panel.setSize(100,100);
		panel.setBounds(194, 279, 431, 166);
		panel.setBackground(new Color(200, 200, 200, 180));
		keret.getContentPane().add(panel);
		panel.setLayout(null);


		
		BejelentkezoDoboz_Szoveg.setHorizontalAlignment(SwingConstants.RIGHT);
		BejelentkezoDoboz_Szoveg.setFont(new Font("Tahoma", Font.BOLD, 18));
		BejelentkezoDoboz_Szoveg.setBackground(Color.LIGHT_GRAY);
		BejelentkezoDoboz_Szoveg.setBounds(137, 11, 146, 22);
		
		Felhasznalonev_Szoveg.setHorizontalAlignment(SwingConstants.RIGHT);
		Felhasznalonev_Szoveg.setBounds(10, 76, 146, 22);
		Felhasznalonev_Szoveg.setBackground(Color.LIGHT_GRAY);
		Felhasznalonev_Szoveg.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		Felhasznalonev_TextFielad = new JTextField();
		Felhasznalonev_TextFielad.setHorizontalAlignment(SwingConstants.CENTER);
		Felhasznalonev_TextFielad.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Felhasznalonev_TextFielad.setBounds(166, 75, 209, 30);
		Felhasznalonev_TextFielad.setColumns(10);
		
		Jelszo_Textfield = new JPasswordField();
		Jelszo_Textfield.setHorizontalAlignment(SwingConstants.CENTER);
		Jelszo_Textfield.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Jelszo_Textfield.setToolTipText("");
		Jelszo_Textfield.setBounds(166, 113, 209, 30);
		
		Jelszo_Szoveg.setHorizontalAlignment(SwingConstants.RIGHT);
		Jelszo_Szoveg.setFont(new Font("Tahoma", Font.BOLD, 18));
		Jelszo_Szoveg.setBackground(Color.LIGHT_GRAY);
		Jelszo_Szoveg.setBounds(10, 114, 146, 22);
		
		panel.add(Felhasznalonev_Szoveg);
		panel.add(Jelszo_Szoveg);
		panel.add(BejelentkezoDoboz_Szoveg);
		panel.add(Felhasznalonev_TextFielad);
		panel.add(Jelszo_Textfield);
		
		
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(Felhasznalonev_TextFielad.getText().equals(getFelhasznalonev())&&Jelszo_Textfield.getText().equals(getJelszo())) {
					System.out.println("Sikeres bejelentkezes");
				}else if(Felhasznalonev_TextFielad.getText().length()==0) {
					System.err.println("Nem adtal meg felhasznalo nevet");
				}else if (Jelszo_Textfield.getText().length()==0) {
					System.err.println("Nem adtal meg kodot");
				}else if(!Felhasznalonev_TextFielad.getText().equals(getFelhasznalonev())&&!Jelszo_Textfield.getText().equals(getJelszo())){
					System.err.println("Hibas bejelntkezesi adatok");
			}
			}
		});
		btnNewButton.setBackground(new Color(5, 173, 254));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(600, 504, 150, 30);
		
		MenuPanel.setLocation(0,1);
		MenuPanel.setBackground(new Color(0,0,0,0));
		MenuPanel.setSize(getAblak_Szeles(),getAblak_Magas());
			
		btnNewButton.setVisible(true);
		Grafikus.Login_Hatterkep.add(btnNewButton);
		Grafikus.Login_Hatterkep.add(panel);
		Grafikus.Login_Hatterkep.add(MenuPanel);
		
		MenuPanel.setLayout(null);
		JLabel lblNewLabel = new JLabel("Test");
		lblNewLabel.setBounds(49, 5, 201, 14);
		MenuPanel.add(lblNewLabel);
		MenuPanel.setVisible(true);
		System.out.println("Valami");


		
	}

}
