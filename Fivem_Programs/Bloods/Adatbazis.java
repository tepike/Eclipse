package Bloods;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class Adatbazis {
	
    final static String drive="com.mysql.cj.jdbc.Driver";
    final static String username="root";
    final static String password="";
    static String url="jdbc:mysql://localhost:3306";
    static Connection con=null;
    static Statement createStatement=null;
    static DatabaseMetaData dm=null;
    static int Panel_Darab=1;
    static boolean Column_megadva=false;
    static boolean Adatbazis_megtalalva =false;
    static Timer timer = new Timer();
   
    public Adatbazis() throws Exception  {
       
        try {
         con =DriverManager.getConnection(url,username,password);
         System.out.println("Híd ok");}
        
        
        catch(SQLException e) {
        	con=null;
            System.out.println("Nincs híd");
        
        }
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
             ResultSet rs = dm.getCatalogs();
             while(rs.next()) {
            	 System.out.println("Adat tablak: "+rs.getString(1));
            	 if(rs.getString(1).equals("bloods")) {
            		 System.err.println(rs.getString(1)+" tabla megtalalva");
            		 Adatbazis_megtalalva=true;
                  	url="jdbc:mysql://localhost:3306/bloods";
                  	con =DriverManager.getConnection(url,username,password);
                  	createStatement=con.createStatement();
                  	dm=con.getMetaData();
            		 
            	 }
             }
             if(!Adatbazis_megtalalva) {
            	 System.out.println("Bloods Adattabla letrehozasa mert nem letezik");
                 try {
                 	
                 	String Adatbazis_letrehoz="CREATE DATABASE bloods";
                 	url="jdbc:mysql://localhost:3306/";
                 	System.out.println("Adatbazis letrehozva");
                 	 con =DriverManager.getConnection(url,username,password);
                 	createStatement.execute(Adatbazis_letrehoz);
                 	url="jdbc:mysql://localhost:3306/bloods";
                 	con =DriverManager.getConnection(url,username,password);
                 	createStatement=con.createStatement();
                 	dm=con.getMetaData();
     			} catch (Exception e2) {
     				System.out.println("Az adatbazist nem sikerult letrehozni");
     			}
                 
             }
             }
        }catch (SQLException e) {
            System.out.println("Metaadat nem ok");
        }
      

 

    }
    public void addfelhasznalo(String a,String b,String c) {
        try {
            String sql="INSERT INTO felhasznalok VALUES (?,?,?)";
            PreparedStatement prm=con.prepareStatement(sql);
            prm.setString(1,a);
            prm.setString(2,b);
            prm.setString(3,c);
            prm.execute();
           
            System.out.println("Adatfelvétel megtörtént");
        }catch (SQLException e) {
            System.out.println("adatfelvétel hibás");}
        }
            
    public void lekerdez() {
                String sql="SELECT * FROM felhasznalok";
				System.out.println(sql);
    }

    public static void Felhasznalok() {
        	  	  System.out.println("Felhasznalok adattabla elindul");
        	         try {
        	             if (dm!=null) { 
        	            	 System.out.println("Dm nem nulla");
        	          	   
        	             ResultSet rs=dm.getTables(null, "APP", "bloods_felhasznalok", null);   
        	             
        	             if (!rs.next()) {                      
        	                 createStatement.execute("create table bloods_felhasznalok (Id char(30),Password char(30),Teljes_Nev char(50),primary key (Teljes_Nev))"); 
        	                 System.err.println("\nTábla nem létezett létrehozva bloods_felhasznalok\n");
        	                 String sql2="INSERT INTO bloods_felhasznalok VALUES ('1','1','Test admin')";
        	                 PreparedStatement prm=con.prepareStatement(sql2);
        	                 prm.execute();
        	                 System.out.println("Alap felhasznalo letrehozva");
        	                 }
        	             
        	             ResultSet rs_adatbazis=dm.getCatalogs();
        	             while(rs.next()) {
        	            	 System.out.println("Adatbazis nevek lekerdezese");
        	            	 System.out.println(rs_adatbazis.getString(1));
        	             }

        	             }
        	         }catch(SQLException e) {
        	             System.out.println("Tábla létezett bloods_felhasznalok");                      
        	                 } 
           }

    public static void Rendelesek() {
     	  System.out.println("Rendelesek adattabla elindul");
          try {
              if (dm!=null) {              
              ResultSet rs2=dm.getTables(null, "APP", "bloods_rendelesek", null);                  
              if (!rs2.next()) {                      
                  createStatement.execute("create table bloods_rendelesek (Azonosito int,Rendelest_Felvette char(50),Rendeles_Leadva char(50),Elerhetoseg char(70),Eloleg int,Eloleg_Fizetve char(5),Tetelek varchar(500),Fizetendo int,Elkeszetisei_Ido char(50),Vallalt_Teljesites char(50),Teljesitve char(5),primary key (Rendelest_Felvette))");
                  System.err.println("\nTábla nem létezett létrehozva bloods_rendelesek\n");                            
                  }
              }
          }catch(SQLException e) {
        	 
              System.out.println("Tábla létezett bloods_rendelesek");                      
                  } 
    }
    
    public static void Felhasznalo_Leker() {
    	if(con!=null) {
            try {
                String sql = "SELECT id, password, teljes_nev FROM bloods_felhasznalok WHERE id = ?";
                PreparedStatement prm = con.prepareStatement(sql);
                prm.setString(1, Bejelentkezes.Felhasznalo_Text.getText()); // beállítjuk a keresési feltételt
                ResultSet rs = prm.executeQuery();

                // Ellenőrizzük, hogy van-e eredmény
                if (rs.next()) {
                    // Az eredmény kiírása
                    System.out.println("Kiiras probalas");
                    //System.out.println("\nLekert felhasznalo = " + rs.getString("id"));
                    Bejelentkezes.setFelhasznalo(rs.getString("id"));
                    //System.out.println("\nLekert jelszo = " + rs.getString("password"));
                    Bejelentkezes.setJelszo(rs.getString("password"));
                    Aruk.Felhasnzalo_Felso.setText("Felhasználó: "+rs.getString("teljes_nev"));
                    //Adott adat olvasása itt az első adat az 1 nem a 0.
                    System.out.println(rs.getString(1));
                    //System.out.println("\nFelhasznalo es lofasz printeles");
                    //System.out.println("Felh: "+Bejelentkezes.getFelhasznalo());
                    //System.out.println("Jelszo: "+Bejelentkezes.getJelszo());
                } else {
                    System.out.println("Nincs találat.");
                }
            } catch (Exception e) {
                System.out.println("Hiba a felhasználó név keresésében: " + e.getMessage());
            }
    	}
    	
    	else {
    		JOptionPane.showMessageDialog(null, "Nincs kapcsolat az adatbázissal");
    		
    		timer.scheduleAtFixedRate(new TimerTask() {
				
				@Override
				public void run() {
					System.out.println("Timer fut "+LocalDateTime.now());
					if(con==null) {
			  	        try {
		    	            con =DriverManager.getConnection(url,username,password);
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
		    	                JOptionPane.showMessageDialog(null, "Létrejött a kapcsolat az adatbázissal");
		    	                Bejelentkezes.Adatbazis_Kapcsolat_Sikeres();
		    	                }
		    	           }catch (SQLException e) {
		    	               System.out.println("Metaadat nem ok");
		    	           }
		    	           try {
		    	        	   if(con==null) {
		    	        		   System.err.println("Nincs kapcsolat az adatbazissal, 5mp mulva ujra kapcsolodik");
		    	        		   Bejelentkezes.Adatbazis_Kapcsolat_Hiba();
		    	        		   
		    	        	   }
		    	        	   
							
						} catch (Exception e) {
							e.getMessage();
						}
		    	       	if(con!=null) {
		    	    		timer.cancel();
		    	    		timer = new Timer();
		    	    		
		    	    	}
						
					}
					
				}
			}, 0, 5000);
		}


        
    }
    public static void Rendeles_darab() {
    	System.out.println("Rendelesi darabszam szamolasa");
    	
    	try {
			String sqlCount= "SELECT COUNT(azonosito) FROM bloods_rendelesek";
			PreparedStatement prmCount= con.prepareStatement(sqlCount);
			ResultSet rsCount = prmCount.executeQuery();
			
			if(rsCount.next()) {
				final int Count= rsCount.getInt(1);
				//System.out.println("Az id-k szama: "+Count);
				Menu.Rendelesek_Adatbazis=Count;
			}
		} catch (Exception e) {
			e.getMessage();
			System.out.println("Hiba a megszamlalasban");
		}
    	
    }
    
    public static void Rendeles_darab_Kulonbseg() {
    	//System.out.println("\tRendelesi darabszam kulonbseg szamolasa");
    	
    	try {
			String sqlCount= "SELECT COUNT(azonosito) FROM bloods_rendelesek";
			PreparedStatement prmCount= con.prepareStatement(sqlCount);
			ResultSet rsCount = prmCount.executeQuery();
			
			if(rsCount.next()) {
				final int Count= rsCount.getInt(1);
				//System.out.println("Az id-k szama: "+Count);
				Menu.Rendelesek_Adatbazis_Kulonbseg=Count;
			}
		} catch (Exception e) {
			e.getMessage();
			System.out.println("Hiba a megszamlalasban");
		}
    	
    }
    
    public static void Rendelesek_lekerdezese() {
    	//Adatbázisban hozzak létre tömböt ami felveszi az adatokat és így megtudom hívni a rendeléseknél a panel létrehozásásos for ciklusnál.
    	
    	//System.out.println("Rendeles lekerdezes elindult");
    	try {
    		String sqlLekerdez="SELECT * FROM bloods_rendelesek ORDER BY Azonosito ";
    		PreparedStatement prmLekerdez=con.prepareStatement(sqlLekerdez);
    		ResultSet rsLekerdez= prmLekerdez.executeQuery();
    		ResultSetMetaData rsmd= rsLekerdez.getMetaData();
    		//System.out.println("Osszes column: "+rsmd.getColumnCount()+"\n");
    		String Columns []  = new String [rsmd.getColumnCount()+1];
    		Rendeles[] Sql_Adatok   = new Rendeles [rsmd.getColumnCount()+1];
    		
    		
    		while(rsLekerdez.next()) {
    			//Fejléc tömbösítése a vissza kérdezehtőség miatt.
    			
    			if(!Column_megadva) {
    				//System.out.println("Column tomb letrehozasa");
    				for(int a =1;a<=rsmd.getColumnCount();) {
    					Columns[a]=new String(rsmd.getColumnLabel(a));
    					//System.out.println("Tomb tartalma: "+a+" "+Columns[a]);
    					Rendeles.Label_Columns[Panel_Darab][a]= new JLabel(rsmd.getColumnLabel(a));
    					a++;
    					
    				}
    				//System.out.println("Panel darab sql tombositesben (Adatbazis): "+Panel_Darab);
    				if(Panel_Darab==Menu.Rendelesek_Adatbazis) {
    					Column_megadva=true;
    				}
    				Rendeles.Osszes_Colum=Columns.length;
    				//System.out.println("\nTomb merete: "+Columns.length+"\n");
    			}
    			
    			for(int a =1;a<rsmd.getColumnCount()+1;) {
    				//System.out.println(rsmd.getColumnLabel(a)+": "+rsLekerdez.getString(a));
    				Sql_Adatok[a]= new Rendeles(rsLekerdez.getString(1), rsLekerdez.getString(2),rsLekerdez.getString(3),rsLekerdez.getString(4),rsLekerdez.getString(5),
    											rsLekerdez.getString(6),rsLekerdez.getString(7),rsLekerdez.getString(8),rsLekerdez.getString(9),rsLekerdez.getString(10),rsLekerdez.getString(11));
    				
    				Rendeles.Label_Rendeles_Adatok[Panel_Darab][a]= new JLabel(rsLekerdez.getString(a));
    				
    				a++;
    			}
    			//Adatok ki printelése void alapján (1-es azonosítóval)
    			//Sql_Adatok[1].printeles();
    			
    			//System.out.println(Sql_Adatok[1].Azonosito);
    			//System.out.println("\n");
    			Panel_Darab++;
    		}
    		//System.err.println("Proba ki iratas 1-es azonosito 2-es reszlegere "+Rendeles.Label_Rendeles_Adatok[1][11].getText());
			//System.out.println("Rendeles lekerdezes befejezve");
		} catch (Exception e) {
			// TODO: handle exception
		}
    }
    public static void Adat_Frissit_Egy() {
    	try {
    		
    		//System.out.println("\tEgy darabos panel frissites");
    		String sql_Egy_adat = "Select * From bloods_rendelesek Where Azonosito = ?";
    		
			PreparedStatement prm = con.prepareStatement(sql_Egy_adat);
			prm.setString(1, Integer.toString(Rendeles.kivalasztott_panel));
			ResultSet rst= prm.executeQuery();
			ResultSetMetaData rsmeta= rst.getMetaData();
			
			int osszes= rsmeta.getColumnCount();
			while(rst.next()) {
				for(int i =1;i<osszes+1;i++) {
					//System.out.println("Egy darab adat frissitese megnyitaskor: "+rst.getString(i));
					Rendeles.Label_Rendeles_Adatok[Rendeles.kivalasztott_panel][i].setText(rst.getString(i));
					//System.err.println("\n\tAdatok vissza ellenorzese: "+Rendeles.Label_Rendeles_Adatok[Rendeles.kivalasztott_panel][i].getText());
				}
			}
			
			
			for(int i =1;i<osszes;i++) {
				//System.out.println("Egy darab adat frissitese megnyitaskor: "+rsmeta.getColumnLabel(i));
			}
			
    		
		} catch (Exception e) {
			System.err.println("Hiba az egy darabos adat frissitesenel");
		}
    }
    
  public static void kapcsolat_teszt() {
	  //System.out.println("\nKapcsolat tesztelese az adatbazissal (Kapcsolat_teszt void)");
      try {
          con =DriverManager.getConnection(url,username,password);
          //System.err.println("\nVan kapcsolat az adatbazissal (Kapcsolat_teszt void)");
          }
         catch(SQLException e) {
         	con=null;
             System.out.println("\nNincs kapcsolat az adatbazissal (Kapcsolat_teszt void)");
             timer.scheduleAtFixedRate(new TimerTask() {
			
			@Override
			public void run() {
				System.out.println("Timer fut "+LocalDateTime.now());
				if(con==null) {
		  	        try {
	    	            con =DriverManager.getConnection(url,username,password);
	    	            System.out.println("Híd ok (Kapcsolat_teszt void)");}
	    	           catch(SQLException e) {
	    	               System.out.println("Nincs híd (Kapcsolat_teszt void)");}
	    	           try {
	    	           if (con!=null) {
	    	               createStatement=con.createStatement();
	    	               System.out.println("Utasítás létrejött (Kapcsolat_teszt void)");
	    	           }
	    	           }
	    	           catch(SQLException e) {
	    	               System.out.println("Nem jött létre utasítás (Kapcsolat_teszt void)");
	    	           }
	    	          
	    	           try {
	    	               if (createStatement!=null) {
	    	          
	    	                dm=con.getMetaData();
	    	                System.out.println("Metaadat ok (Kapcsolat_teszt void)");
	    	                JOptionPane.showMessageDialog(null, "Létrejött a kapcsolat az adatbázissal (Kapcsolat_teszt void)");
	    	                Bejelentkezes.Adatbazis_Kapcsolat_Sikeres();
	    	                }
	    	           }catch (SQLException e) {
	    	               System.out.println("Metaadat nem ok (Kapcsolat_teszt void)");
	    	           }
	    	           try {
	    	        	   if(con==null) {
	    	        		   System.err.println("Nincs kapcsolat az adatbazissal, 5mp mulva ujra kapcsolodik (Kapcsolat_teszt void)");
	    	        		   Bejelentkezes.Adatbazis_Kapcsolat_Hiba();
	    	        		   
	    	        	   }
	    	        	   
						
					} catch (Exception e) {
						e.getMessage();
					}
	    	       	if(con!=null) {
	    	    		timer.cancel();
	    	    		timer = new Timer();
	    	    		
	    	    	}
					
				}
				
			}
		}, 0, 5000);
	}
  }
}
          
          
