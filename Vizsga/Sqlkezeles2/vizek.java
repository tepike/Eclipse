package Sqlkezeles2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.DatabaseMetaData;


public class vizek {
	static Scanner bevitel = new Scanner(System.in);
    final String drive="com.mysql.cj.jdbc.Driver";
    final String username="root";
    final String password="";
    final String url="jdbc:mysql://localhost:3306/kornyezet";
    Connection con=null;
    Statement createStatement=null;
    static DatabaseMetaData dm=null;
   
    public vizek() throws Exception  {
       
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
            ResultSet rs=dm.getTables(null, "APP", "kornyezet", null);           
            if (!rs.next()) {               
                createStatement.execute("create table kornyezet (tonev varchar(50),vizminoseg varchar(50),datum varchar(50))");
                System.out.println("Tabla nem letezett, letrehozva");     
                
                }}}
        catch(SQLException e) {
            System.out.println("Tabla letezett");}
        
        //Új tábla létrehozása |Fontos, hogy adat beillesztésnél figyelni kell az elérési utat "kornyezetVedelem" |  String sql="INSERT INTO kornyezetVedelem VALUES (?,?,?)"; |
        try {
            if (dm!=null) {       
            ResultSet rs=dm.getTables(null, "APP", "kornyezetVedelem", null);           
            if (!rs.next()) {               
                createStatement.execute("create table kornyezetVedelem (tonev varchar(50),vizminoseg varchar(50),datum varchar(50))");
                System.out.println("Tabla nem letezett, letrehozva");     
                
                }}}
        catch(SQLException e) {
            System.out.println("Tabla letezett");}}
    
    
    
    

    
    
    public void addjegyzokonyv(String n,String m,String d) {    	
        try {        	
            String sql="INSERT INTO kornyezet VALUES (?,?,?)";
            PreparedStatement prm=con.prepareStatement(sql);
            prm.setString(1,n);
            prm.setString(2, m);
            prm.setString(3, d);
            prm.execute();                       
          
            System.out.println("Adatfelvetel megtortent");          
    }catch (SQLException e) {
        System.out.println("adatfelvetel hibas");
    }        
    }
    

    public void ChangeMeresData(String n, String m,String d,String g) {
    	try {
    				//UPDATE kornyezet SET vizminoseg='dsadasa' WHERE tonev='dsa' AND vizminoseg='dsa'AND datum='1';
    		String sql="UPDATE kornyezet set vizminoseg=(?) WHERE tonev=(?) AND vizminoseg=(?) and datum=(?)";
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
    
    public void ChangeDataDatumnal(String n, String m,String d) {
    	try {
    				//UPDATE kornyezet SET vizminoseg='dsadasa' WHERE tonev='dsa' AND vizminoseg='dsa'AND datum='1';
    		String sql="UPDATE kornyezet set tonev=(?), vizminoseg=(?) WHERE datum=(?)";
    				PreparedStatement prm=con.prepareStatement(sql);    				
    				prm.setString(1,n);
    				prm.setString(2,m);    	
    				prm.setString(3,d); 
    				prm.execute();
			System.out.println("Sikeres adat valtoztats");
		} catch (Exception e) {
			System.out.println("Sikertelen adat valtoztatas");
		}
    }
    
    
    public static void main(String[] args) throws Exception {        
			vizek adat=new vizek();
			boolean folytat=true;
			try {
				while (folytat==true) {
					System.out.println("\nKerlek add meg mit szeretnel \n(A) - Adat felvetel \n(M) - Adat modositas \n(E) - Feladat befejezes");
					String MegadottParameter=bevitel.nextLine();
					
					switch (MegadottParameter.toUpperCase()) {
					
					case "A": {					
						//Új adat felvétele			
						System.out.println("Kerlek add meg a to nevet");        
						String toNeve=bevitel.nextLine();
						
						System.out.println("Kerlek add meg a mert minoseget");        
						String toVizminoseg=bevitel.nextLine();
						
						System.out.println("Kerlek add meg a meres idopontjat YYYY/MM/DD");        
						String toDatum=bevitel.nextLine();									
						adat.addjegyzokonyv(toNeve, toVizminoseg, toDatum);
						break;
					}
					case "M": {		
						//Adat módosítás bekért névre
						System.out.println("Add meg a valtoztatni kivant to nevet");
						String RegiTonev=bevitel.nextLine();
						System.out.println("Add meg a regi vizminoseget");
						String RegiVizminoseg=bevitel.nextLine();	
						System.out.println("Add meg a regi datumot");
						String RegiDatum=bevitel.nextLine();	
						

						System.out.println("Add meg az uj vizminoseget");
						String UjVizminoseg=bevitel.nextLine();	
						adat.ChangeMeresData(UjVizminoseg, RegiTonev, RegiVizminoseg, RegiDatum);
						break;
					}
					case "ME": {		
						//Adat módosítás bekért névre
						System.out.println("Add meg a regi datumot");
						String RegiDatum=bevitel.nextLine();	
						
						System.out.println("Add meg az uj to nevet");
						String UjTonev=bevitel.nextLine();
						
						System.out.println("Add meg az uj vizminoseget");
						String UjVizminoseg=bevitel.nextLine();	
						


						adat.ChangeDataDatumnal(UjTonev, UjVizminoseg, RegiDatum);
						break;
					}
					case "E":{
						System.out.println("Feladat befejezve");
						folytat=false;
						break;
					}
					
					default:
						System.out.println("Nem megfelelo parancs");
						
					}
				}
				
			} catch (Exception e) {
				System.out.println("Bekeresi try hiba");
			}


			

			
		
       

    }}
    
    
    
    
    
    /*
     
    2. Összes adat lekérdezése
    
    5. Bekért dátumnál az értékek módosítása
    6. A bekért nap értékének a törlése
     */
    

