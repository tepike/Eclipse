package VizSQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;

public class Adatbazis {
    final String drive="com.mysql.cj.jdbc.Driver";
    final String username="root";
    final String password="";
    final String url="jdbc:mysql://localhost:3306/vizsgazok";
    Connection con=null;
    Statement createStatement=null;
    DatabaseMetaData dm=null;
   
    public Adatbazis() throws Exception  {
       
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
             }
        }catch (SQLException e) {
            System.out.println("Metaadat nem ok");
        }
        try {
            if (dm!=null) {
       
            ResultSet rs=dm.getTables(null, "APP", "tanulo2", null);
           
            if (!rs.next()) {
               
                createStatement.execute("create table tanulo2 (nev varchar(30),kor integer(3))");
                System.out.println("Tábla nem létezett létrehozva");
       
       
                }
            }
        }catch(SQLException e) {
            System.out.println("Tábla létezett");
               
                }
    }
    public void addtanulo(String n,int k) {
        try {
            String sql="INSERT INTO tanulo2 VALUES (?,?)";
            PreparedStatement prm=con.prepareStatement(sql);
            prm.setString(1,n);
            prm.setInt(2, k);
            prm.execute();
           
          
            System.out.println("Adatfelvétel megtörtént");
        }catch (SQLException e) {
            System.out.println("adatfelvétel hibás");}
        }
            
           public void lekerdez() {
                String sql="SELECT * FROM vizsgazok";
				System.out.println(sql);
    }
    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
    	Adatbazis adat=new Adatbazis();
        adat.addtanulo("Hilda", 10);
        adat.lekerdez();
       

    }

}