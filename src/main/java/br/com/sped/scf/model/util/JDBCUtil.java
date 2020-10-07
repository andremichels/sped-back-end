/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sped.scf.model.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCUtil {


    
    public static Connection getConnectionOracleDesenvSefaz() throws Exception{
        Class.forName("oracle.jdbc.driver.OracleDriver");
        String url = "jdbc:oracle:thin:@//barbado-scan:1521/sfzd01.sefaz.mt.gov.br";
        Connection con = DriverManager.getConnection(url,"UIFDS","uifds");
        return con;
    }


   
    private static Connection getConnectionOracleProdSefaz_() throws Exception{

        Class.forName("oracle.jdbc.driver.OracleDriver");
        String url = "jdbc:oracle:thin:@//10.43.22.10:1521/orsfzppr";
        Connection con = DriverManager.getConnection(url,"711541241","181922");
        return con;
    }

    
    public static Connection getConnectionOracleCLOUD_1() throws Exception{
        Class.forName("oracle.jdbc.driver.OracleDriver");
        String url = "jdbc:oracle:thin:@(DESCRIPTION=(ADDRESS_LIST=(ADDRESS=(HOST=10.43.22.10)(PORT=1521)(PROTOCOL=TCP))(ADDRESS=(HOST=10.43.22.11)(PORT=1521)(PROTOCOL=TCP))(ADDRESS=(HOST=10.43.22.12)(PORT=1521)(PROTOCOL=TCP)))(CONNECT_DATA=(SERVICE_NAME=orsfzppr)))";
        Connection con = DriverManager.getConnection(url,"711541241","181922");

        return con;

        
    }
    

    public static void main(String[] args)
    {
      try
      {
        Connection con =   getConnectionOracleCLOUD_1();
          System.err.println(con);
       
       

      }
      catch (Exception e)
      {
         e.printStackTrace();
      }
   }
    
    
 
}
