/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author pc 
 */
public class database {
  public database() throws SQLException{
  Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/mydata","omer","omer");
              System.out.println("successful");
 }   
  public static void main(String[] args) throws SQLException {
        database a1=new database();
    }

}
