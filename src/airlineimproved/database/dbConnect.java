/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airlineimproved.database;
import airlineimproved.views.Main;
import java.io.IOException;
import java.sql.*;
import java.sql.Connection;
import org.apache.derby.jdbc.ClientDataSource;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author dclop
 */
public abstract class dbConnect {
    
    private ClientDataSource ds;
    private Connection conn;
    
    
    
    public dbConnect(){
        ds = new ClientDataSource();
        ds.setDatabaseName("airline");
        ds.setServerName("localhost");
        ds.setPortNumber(1527);
        ds.setUser("airline");
        ds.setPassword("password");
        ds.setDataSourceName("jdbc:derby");
    }
    
    
    public void Connect(){
        try {
        ds = new ClientDataSource();
        ds.setDatabaseName("airline");
        ds.setServerName("localhost");
        ds.setPortNumber(1527);
        ds.setUser("airline");
        ds.setPassword("password");
        ds.setDataSourceName("jdbc:derby");
            conn = ds.getConnection();
        } catch (SQLException ex) {
            System.out.println("Unable To connect");
        }
    }
    
    
    public void createUser(String username,String fName, String lName, String email, String pass) throws SQLException, IOException{
        
//INSERT INTO AIRLINE.ACCOUNTS (ACCOUNTID, USERNAME, FIRSTNAME, LASTNAME, NUMFLIGHTS, MILES, PASS, CITY, ZIPCODE, EMAIL, STATES)        
         String userName = username;
         String first = fName;
         String last = lName;
         String uEmail = email;
         String tempPass = pass;
         int id = 2;
         
        String insertTableSQL = "INSERT INTO ACCOUNTS"
		+ "(ACCOUNTID, USERNAME , FIRSTNAME, LASTNAME, EMAIL, PASS) VALUES"
		+ "(?,?,?,?,?,?)";
        //stmt.setString(1, tempAccType);
        PreparedStatement stmt = conn.prepareStatement(insertTableSQL);
        stmt.setInt(1, id);
        stmt.setString(2,userName);
        stmt.setString(3,first);
        stmt.setString(4,last);
        stmt.setString(5,uEmail);
        stmt.setString(6,tempPass);
       try{
           
           stmt.executeUpdate();
       }
       catch(Exception e){
           e.printStackTrace();
       }
       
       Main.goHome();
       
    }
    
    private void deleteUser(String query){
    
    }
    
    private void getFlights(String query){
    
    }
    
    public Connection getConn(){
        return this.conn;
    }
    
    private void createFlight(String f, String a, String o,String dest, String dat,String dep,String arr,String p,String s)  throws SQLException, IOException{
    String flightNum = f;
    String airline = a;
    String origin = o;
    String desti = dest;
    String date = dat;
    String departTime = dep;
    String arrTime = arr;
    String price = p;
    String seats = s;
    
    String insertTableSQL = "INSERT INTO FLIGHTS"
		+ "(FLIGHTNUM, AIRLINENAME , ORIGIN, DEST, DEPARTTIME, ARRIVETIME, SEATSLEFT, DATE, PRICE) VALUES"
		+ "(?,?,?,?,?,?,?,?,?)";
        //stmt.setString(1, tempAccType);
        PreparedStatement stmt;
        
            stmt = conn.prepareStatement(insertTableSQL);
        
        stmt.setString(1, flightNum);
        stmt.setString(2,airline);
        stmt.setString(3,origin);
        stmt.setString(4,desti);
        stmt.setString(5,departTime);
        stmt.setString(6,arrTime);
        stmt.setString(7,seats);
        stmt.setString(8,date);
        stmt.setString(9,price);
        
        
        try{
           
           stmt.executeUpdate();
       }
       catch(Exception e){
           e.printStackTrace();
       }
    
    }
    private Connection getConnTwo(){
        return this.conn;
    }
    
    public boolean validateUser(String uid,String pass) throws SQLException{
         String tempUid=uid;
         String tempUid2="";
         String tempPass = pass;
         PreparedStatement stmt = conn.prepareStatement("SELECT USERNAME FROM ACCOUNTS WHERE USERNAME =? AND PASS = ?" );//TODO : MATCH SQL WITH ACTUAL DB
        //stmt.setString(1, tempAccType);
        stmt.setString(1, tempUid);
        stmt.setString(2,tempPass);
        try{
           //Statement s = this.getConn().createStatement();
           ResultSet resultSet = stmt.executeQuery();
           if(resultSet.next()){
            tempUid2 = resultSet.getString("USERNAME");
            System.out.println("User Entry: "+tempUid+ " / DB Entry "+ tempUid2);
            }
       }
       catch(Exception e){
           e.printStackTrace();
       }
        //return tempUid2.contentEquals(tempUid);
        return true;
    }
    
    public boolean validateUserAdmin(String uid,String pass) throws SQLException{
         String tempUid=uid;
         String tempUid2="";
         String tempPass = pass;
         int id = 0;
         PreparedStatement stmt = conn.prepareStatement("SELECT USERNAME, ACCOUNTID FROM ACCOUNTS WHERE USERNAME =? AND PASS = ?" );//TODO : MATCH SQL WITH ACTUAL DB
        //stmt.setString(1, tempAccType);
        stmt.setString(1, tempUid);
        stmt.setString(2,tempPass);
        try{
           //Statement s = this.getConn().createStatement();
           ResultSet resultSet = stmt.executeQuery();
           if(resultSet.next()){
            tempUid2 = resultSet.getString("USERNAME");
            id = resultSet.getInt("ACCOUNTID");
            //System.out.println("User Entry: "+tempUid+ " / DB Entry "+ tempUid2);
            }
       }
       catch(Exception e){
           e.printStackTrace();
       }
        return id == 1;
        //return true;
    }
    
    
    public boolean userExists(String u) throws SQLException{
        String user = u;
        boolean exists = false;
        PreparedStatement stmt = conn.prepareStatement("SELECT USERNAME FROM ACCOUNTS WHERE USERNAME =?" );
        stmt.setString(1, user);
        ResultSet resultSet = stmt.executeQuery();
        
        if(resultSet.next()){
            exists=true;
        }
        else{
            exists = false;
        }
        return exists;
    }
    
}
