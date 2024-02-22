package UtolsoHonap5;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Sqlkezeles2.Adatbazispelda;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ablak {

	private JFrame frame;
	private JTextField Tipus_Text;
	private JTextField Ar_Text;
	private JTextField Evjarat_Text;
	private JTextField Szin_Text;
	private JTextField Meglevo_Tipus_Text;
	private JTextField Meglevo_Ar_Text;
	private JTextField Meglevo_Evjarat_Text;
	private JTextField Meglevo_Szin_Text;
	
	JButton Letrehozas_Button = new JButton("Létrehozás");
	JButton Modositas_Button = new JButton("Módosítás");
	JButton Torles_Button = new JButton("Törléls");

final String drive="com.mysql.cj.jdbc.Driver";

    
    Connection con=null;
    Statement createStatement=null;
    DatabaseMetaData dm=null;
   
      {
       
        try {
        	 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hasznaltauto","root","");
         System.out.println("Híd ok");}
        catch(SQLException e) {
            System.out.println("Nincs híd");}
        try {
        if (con!=null) {
            createStatement=con.createStatement();
            System.out.println("Utasítás létrejött");
        }
        }
        catch(SQLException e) {
            System.out.println("Nem jött létre utasítás");
        }
       
        try {
            if (createStatement!=null) {
       
             dm=con.getMetaData();
             System.out.println("Metaadat ok");
             }
        }catch (SQLException e) {
            System.out.println("Metaadat nem ok");
        }
        try {
            if (dm!=null) {
       
            ResultSet rs=dm.getTables(null, "APP", "hasznaltauto", null);
           
            if (!rs.next()) {
               
                createStatement.execute("create table hasznaltauto (tipus varchar(30),ar varchar(30), evjarat varchar(30), szin varchar(30))");
                System.out.println("Tábla nem létezett létrehozva");
       
       
                }
            }
        }catch(SQLException e) {
            System.out.println("Tábla létezett");
               
                }
    }
    public void addkocsi(String n,String k,String h,String g) {
        try {
            String sql="INSERT INTO hasznaltauto VALUES (?,?,?,?)";
            PreparedStatement prm=con.prepareStatement(sql);
            prm.setString(1,n);
            prm.setString(2, k);
            prm.setString(3,h);
            prm.setString(4, g);
            
            prm.execute();                    
            System.out.println("Adatfelvétel megtörtént");
    }catch (SQLException e) {
        System.out.println("adatfelvétel hibás");
    }

        
        
        
}
	
	
	
	
	
	
	public static void main(String[] args) throws Exception {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ablak window = new Ablak();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Ablak() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 878, 527);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 862, 488);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel Tipus_Label = new JLabel("Tipus");
		Tipus_Label.setHorizontalAlignment(SwingConstants.RIGHT);
		Tipus_Label.setFont(new Font("Tahoma", Font.BOLD, 16));
		Tipus_Label.setBounds(254, 73, 75, 25);
		panel.add(Tipus_Label);
		
		JLabel Ar_Label = new JLabel("Ár");
		Ar_Label.setHorizontalAlignment(SwingConstants.RIGHT);
		Ar_Label.setFont(new Font("Tahoma", Font.BOLD, 16));
		Ar_Label.setBounds(401, 73, 75, 25);
		panel.add(Ar_Label);
		
		JLabel Evjarat_Label = new JLabel("Évjárat");
		Evjarat_Label.setHorizontalAlignment(SwingConstants.RIGHT);
		Evjarat_Label.setFont(new Font("Tahoma", Font.BOLD, 16));
		Evjarat_Label.setBounds(551, 73, 75, 25);
		panel.add(Evjarat_Label);
		
		JLabel Szin_Label = new JLabel("Szín");
		Szin_Label.setHorizontalAlignment(SwingConstants.RIGHT);
		Szin_Label.setFont(new Font("Tahoma", Font.BOLD, 16));
		Szin_Label.setBounds(699, 73, 75, 25);
		panel.add(Szin_Label);
		
		Tipus_Text = new JTextField();
		Tipus_Text.setHorizontalAlignment(SwingConstants.RIGHT);
		Tipus_Text.setFont(new Font("Tahoma", Font.BOLD, 14));
		Tipus_Text.setBounds(191, 109, 138, 40);
		panel.add(Tipus_Text);
		Tipus_Text.setColumns(10);
		
		Ar_Text = new JTextField();
		Ar_Text.setHorizontalAlignment(SwingConstants.RIGHT);
		Ar_Text.setFont(new Font("Tahoma", Font.BOLD, 14));
		Ar_Text.setColumns(10);
		Ar_Text.setBounds(340, 109, 138, 40);
		panel.add(Ar_Text);
		
		Evjarat_Text = new JTextField();
		Evjarat_Text.setHorizontalAlignment(SwingConstants.RIGHT);
		Evjarat_Text.setFont(new Font("Tahoma", Font.BOLD, 14));
		Evjarat_Text.setColumns(10);
		Evjarat_Text.setBounds(488, 109, 138, 40);
		panel.add(Evjarat_Text);
		
		Szin_Text = new JTextField();
		Szin_Text.setHorizontalAlignment(SwingConstants.RIGHT);
		Szin_Text.setFont(new Font("Tahoma", Font.BOLD, 14));
		Szin_Text.setColumns(10);
		Szin_Text.setBounds(636, 109, 138, 40);
		panel.add(Szin_Text);
	
		
		Letrehozas_Button.setBounds(253, 417, 128, 60);
		panel.add(Letrehozas_Button);
		
		
		Modositas_Button.setBounds(391, 417, 128, 60);
		panel.add(Modositas_Button);
		
		
		Torles_Button.setBounds(529, 417, 128, 60);
		panel.add(Torles_Button);
		
		JLabel Letrehozo_Label = new JLabel("Letrohozási adatok");
		Letrehozo_Label.setFont(new Font("Tahoma", Font.BOLD, 16));
		Letrehozo_Label.setBounds(21, 116, 160, 25);
		panel.add(Letrehozo_Label);
		
		JLabel Meglevo_Tipus_Label = new JLabel("Tipus");
		Meglevo_Tipus_Label.setHorizontalAlignment(SwingConstants.RIGHT);
		Meglevo_Tipus_Label.setFont(new Font("Tahoma", Font.BOLD, 16));
		Meglevo_Tipus_Label.setBounds(254, 177, 75, 25);
		panel.add(Meglevo_Tipus_Label);
		
		JLabel Megelvo_Ar_Label = new JLabel("Ár");
		Megelvo_Ar_Label.setHorizontalAlignment(SwingConstants.RIGHT);
		Megelvo_Ar_Label.setFont(new Font("Tahoma", Font.BOLD, 16));
		Megelvo_Ar_Label.setBounds(401, 177, 75, 25);
		panel.add(Megelvo_Ar_Label);
		
		JLabel Meglevo_Evjarat_Label = new JLabel("Évjárat");
		Meglevo_Evjarat_Label.setHorizontalAlignment(SwingConstants.RIGHT);
		Meglevo_Evjarat_Label.setFont(new Font("Tahoma", Font.BOLD, 16));
		Meglevo_Evjarat_Label.setBounds(551, 177, 75, 25);
		panel.add(Meglevo_Evjarat_Label);
		
		JLabel Meglevo_Szin_Label = new JLabel("Szín");
		Meglevo_Szin_Label.setHorizontalAlignment(SwingConstants.RIGHT);
		Meglevo_Szin_Label.setFont(new Font("Tahoma", Font.BOLD, 16));
		Meglevo_Szin_Label.setBounds(699, 177, 75, 25);
		panel.add(Meglevo_Szin_Label);
		
		Meglevo_Tipus_Text = new JTextField();
		Meglevo_Tipus_Text.setHorizontalAlignment(SwingConstants.RIGHT);
		Meglevo_Tipus_Text.setFont(new Font("Tahoma", Font.BOLD, 14));
		Meglevo_Tipus_Text.setColumns(10);
		Meglevo_Tipus_Text.setBounds(191, 213, 138, 40);
		panel.add(Meglevo_Tipus_Text);
		
		Meglevo_Ar_Text = new JTextField();
		Meglevo_Ar_Text.setHorizontalAlignment(SwingConstants.RIGHT);
		Meglevo_Ar_Text.setFont(new Font("Tahoma", Font.BOLD, 14));
		Meglevo_Ar_Text.setColumns(10);
		Meglevo_Ar_Text.setBounds(340, 213, 138, 40);
		panel.add(Meglevo_Ar_Text);
		
		Meglevo_Evjarat_Text = new JTextField();
		Meglevo_Evjarat_Text.setHorizontalAlignment(SwingConstants.RIGHT);
		Meglevo_Evjarat_Text.setFont(new Font("Tahoma", Font.BOLD, 14));
		Meglevo_Evjarat_Text.setColumns(10);
		Meglevo_Evjarat_Text.setBounds(488, 213, 138, 40);
		panel.add(Meglevo_Evjarat_Text);
		
		Meglevo_Szin_Text = new JTextField();
		Meglevo_Szin_Text.setHorizontalAlignment(SwingConstants.RIGHT);
		Meglevo_Szin_Text.setFont(new Font("Tahoma", Font.BOLD, 14));
		Meglevo_Szin_Text.setColumns(10);
		Meglevo_Szin_Text.setBounds(636, 213, 138, 40);
		panel.add(Meglevo_Szin_Text);
		
		JLabel Meglevo_Label = new JLabel("Meglevo Adatok");
		Meglevo_Label.setFont(new Font("Tahoma", Font.BOLD, 16));
		Meglevo_Label.setBounds(21, 227, 160, 25);
		panel.add(Meglevo_Label);
		
		//Gombok kezelése
		Letrehozas_Button.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				System.out.println("Letrehozas gomb megnyomva");
				adatletrehozas();
				
			}
		});
		
		Modositas_Button.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				System.out.println("Modositas gomb megnyomva");
				adatmeglevo();
			}
		});
		
		Torles_Button.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				System.out.println("Torles gomb megnyomva");
			}
		});
		
		
	}
	public void adatletrehozas() {
		//Hasznaltauto
		Ablak adat=new Ablak();
		adat.addkocsi(Tipus_Text.getText(),Ar_Text.getText(),Evjarat_Text.getText(),Szin_Text.getText());
		System.out.println("\nAdat letrehozas | Tipus: "+Tipus_Text.getText()+" Ar: "+Ar_Text.getText()+" Evjarat: "+Evjarat_Text.getText()+" Szin: "+Szin_Text.getText());
	}
	
	public void adatmeglevo() {
		System.out.println("\nMeglevo adat modositas | Tipus: "+Meglevo_Tipus_Text.getText()+" Ar: "+Meglevo_Ar_Text.getText()+" Evjarat: "+Meglevo_Evjarat_Text.getText()+" Szin: "+Meglevo_Szin_Text.getText());
	}
	

}
