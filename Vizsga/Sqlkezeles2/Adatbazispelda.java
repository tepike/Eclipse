package Sqlkezeles2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;

public class Adatbazispelda {
    final String drive="com.mysql.cj.jdbc.Driver";

    
    Connection con=null;
    Statement createStatement=null;
    DatabaseMetaData dm=null;
   
    public Adatbazispelda() throws Exception  {
       
        try {
        	 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vizsgazok","root","");
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
       
            ResultSet rs=dm.getTables(null, "APP", "tanulo", null);
           
            if (!rs.next()) {
               
                createStatement.execute("create table tanulo (nev varchar(30),kor integer(3))");
                System.out.println("Tábla nem létezett létrehozva");
       
       
                }
            }
        }catch(SQLException e) {
            System.out.println("Tábla létezett");
               
                }
    }
    public void addtanulo(String n,int k) {
        try {
            String sql="INSERT INTO tanulo VALUES (?,?)";
            PreparedStatement prm=con.prepareStatement(sql);
            prm.setString(1,n);
            prm.setInt(2, k);
            prm.execute();                    
            System.out.println("Adatfelvétel megtörtént");
    }catch (SQLException e) {
        System.out.println("adatfelvétel hibás");
    }

        
        
        
}
    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        Adatbazispelda adat=new Adatbazispelda();
        adat.addtanulo("Balázs", 26);
       

    }

}