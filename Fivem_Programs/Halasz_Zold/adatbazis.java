package Halasz_Zold;

import java.awt.AWTException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.DatabaseMetaData;

public class adatbazis extends Horgaszat_Zold{



	public adatbazis() throws AWTException {
		super();
		// TODO Auto-generated constructor stub
	}


	static Scanner bevitel = new Scanner(System.in);
	static final String drive="com.mysql.cj.jdbc.Driver";
    static  final String username="root";
    static final String password="";
    static final String url="jdbc:mysql://localhost:3306/horgaszat";
    static Connection con=null;
    static Statement createStatement=null;
    static DatabaseMetaData dm=null;

	public static void adatbazis() throws AWTException {
		
			
		       
		        try {
		         con =DriverManager.getConnection(url,username,password);
		         System.out.println("Hid ok");}
		        catch(SQLException e) {
		            System.out.println("Nincs hid");}
		        
		        
		        try {
		        if (con!=null) {
		            createStatement=con.createStatement();
		            System.out.println("Utasitas letrejott");}}
		        catch(SQLException e) {
		            System.out.println("Nem jott letre utasitas");}
		       
		        
		        try {
		            if (createStatement!=null) {       
		             dm=con.getMetaData();
		             System.out.println("Metaadat ok");}}
		        
		        catch (SQLException e) {
		            System.out.println("Metaadat nem ok");}
		        
		        
		        try {
		            if (dm!=null) {       
		            ResultSet rs=dm.getTables(null, "APP", "panel_helye", null);           
		            if (!rs.next()) {               
		                createStatement.execute("create table panel_helye (fopanel_x varchar(9),fopanel_y varchar(9),elemzopanel_x varchar(9),elemzopanel_y varchar(9))");
		                System.out.println("Tabla nem letezett, letrehozva");     
		                
		                }}}
		        catch(SQLException e) {
		            System.out.println("Tabla letezett");}
				}
		        
	    
		    
		    public static void uj_adat_felvetele(String a,String b,String c, String d) {    	
		        try {        	
		            String sql="INSERT INTO panel_helye VALUES (?,?,?,?)";
		            PreparedStatement prm=con.prepareStatement(sql);
		            prm.setString(1,a);
		            prm.setString(2, b);
		            prm.setString(3, c);
		            prm.setString(4, d);
		            prm.execute();                       
		          
		            System.out.println("Adatfelvetel megtortent");          
		    }catch (SQLException e) {
		        System.out.println("adatfelvetel hibas");
		    }        
		    }
		    

		    public static void felvett_adat_modositas(String n, String m,String d,String g) {
		    	try {
		    				//UPDATE kornyezet SET vizminoseg='dsadasa' WHERE tonev='dsa' AND vizminoseg='dsa'AND datum='1';
		    		String sql="UPDATE panel_helye set fopanel_x=(?), fopanel_y=(?), elemzopanel_x=(?), elemzopanel_y=(?)";
		    				PreparedStatement prm=con.prepareStatement(sql);    				
		    				prm.setString(1,n);
		    				prm.setString(2,m);    	
		    				prm.setString(3,d); 
		    				prm.setString(4,g); 
		    				prm.execute();
					System.out.println("Sikeres adat valtoztats");
				} catch (Exception e) {
					System.out.println("Sikertelen adat valtoztatas");
				}
		    }
		    
		    public static void adatleker() throws SQLException {
		    	String sql="SELECT jelszo FROM panel_helye WHERE felhasznalonev='test2'";
		    	con =DriverManager.getConnection(url,username,password);
		    	
		    	Statement statement = con.createStatement();
		    	ResultSet resultSet = statement.executeQuery(sql);
		    	
		    	try {
			    	while(resultSet.next()) {
			    		String jelszo=resultSet.getString("jelszo");
			    		System.out.println("Lekert jelszó: "+jelszo);
			    	}
				} catch (Exception e) {
					// TODO: handle exception
				}
		    	

		    	
		    	
		    	
		    	
		    }
		    

		    


	}


