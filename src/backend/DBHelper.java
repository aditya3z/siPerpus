/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;
import java.sql.*;
/**
 *
 * @author ASUS
 */
public class DBHelper {
     private static Connection koneksi;
     public static void bukaKoneksi()     
     {
          if(koneksi == null){ 
              try{
                  String url = "jdbc:mysql://localhost:3306/perpustakaan";
                  String user = "root";
                  String password = "";
                  DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                  koneksi = DriverManager.getConnection(url, user, password);
              }          
              catch (SQLException t){
                  System.out.println("Error koneksi!");
              }   
          }
     }
     
      public static int insertQueryGetId(String query){ 
          bukaKoneksi();
          int num = 0;
          int result = -1; 
          
          try{ 
              try (Statement stmt = koneksi.createStatement()) {
                  num = stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
                  
                  try (ResultSet rs = stmt.getGeneratedKeys()) {
                      if (rs.next()){
                          result = rs.getInt(1);
                      }
                  }
              }
          }
          catch (SQLException e){
              result = -1;       
              System.out.println(query);
          }
          return result;
          
     }
      
      public static boolean executeQuery(String query){
          bukaKoneksi();
          boolean result = false;
          
          try{
              try (Statement stmt = koneksi.createStatement()) {
                  stmt.executeUpdate(query);
                  result = true;
              }
          }         
          catch (SQLException e){
          }                  
          return result;     
      }
      
      public static ResultSet selectQuery(String query){
          bukaKoneksi();
          ResultSet rs = null;
          
          try{
              Statement stmt = koneksi.createStatement();
              rs = stmt.executeQuery(query);
          }         
          catch (SQLException e){
          }
          return rs;
      } 
}
