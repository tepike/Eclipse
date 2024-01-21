

package Sqlkezeles;



import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.sql.Statement;

import java.util.ArrayList;

import java.util.List;

import java.util.Scanner;



public class Adatbazispelda {



   public static void main(String[] args) throws SQLException {



       List<Vizsgazo> vizsgazo = new ArrayList<>();



       String createTable = "CREATE TABLE vizsga2 (vizsgazo varchar(40), pontszam integer)";

       String insert = "INSERT INTO vizsga VALUES ('Tóth Béla', 80)";

       String select = "SELECT * FROM vizsga";

       String kereses = "SELECT * FROM vizsga WHERE pontszam > 90";



       try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/vizsgazok",

               "root", "")) {

           try (Statement statement = connection.createStatement()) {

               

               menu(connection);

               

               try (ResultSet resultSet = statement.executeQuery(select)) {

                   while (resultSet.next()) {

                       vizsgazo.add(new Vizsgazo(resultSet.getString("vizsgazo"), resultSet.getInt("pontszam")));

                   }

               }

           }

           System.out.println("Adatbázis tartalma: ");

           for (Vizsgazo diak : vizsgazo) {

               System.out.println(diak);

           }

       }



   }

   

   static void menu(Connection connection) throws SQLException {

       Scanner scanner = new Scanner(System.in);

       String input = "";

       System.out.println("'vizsga' adatbázis\r\nMenü\r\nAdatbázis lekérdezése = x\r\nÚj adat bevitele = n");

       input = scanner.nextLine();

       if (!input.equals("x")) {

           if (input.equals("n")) {

               String ujvizsgazo;

               int ujpontszam;

               System.out.println("Adja meg egy új vizsgázó nevét: ");

               ujvizsgazo = scanner.nextLine();

               System.out.println("Adja meg egy új vizsgázó pontszámát: ");

               ujpontszam = scanner.nextInt();



               ujRekord(connection, ujvizsgazo, ujpontszam);

           }

       }

       scanner.close();

   }



   static void ujRekord(Connection connection, String vizsgazo, int pontszam) throws SQLException {

       String insert = "INSERT INTO vizsga VALUES (?, ?)";

       try (PreparedStatement preparedStatement = connection.prepareStatement(insert)) {

           preparedStatement.setString(1, vizsgazo);

           preparedStatement.setInt(2, pontszam);



           preparedStatement.executeUpdate();

       }

   }

}