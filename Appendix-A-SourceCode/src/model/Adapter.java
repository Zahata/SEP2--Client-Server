
package model;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.activation.MailcapCommandMap;
import javax.swing.table.DefaultTableModel;


public class Adapter implements iAdapter{

//This variables were used at the beginning during testing methods in console   
private String fName;
private String lName;
private String phoneNo;
private String email;
private String balance;

private String transactionNo;
private String date;
private String recieverAccNo;
private String senderAccNo;
private String transactionAmount;


//VIEW TRANSACTIONS
public DefaultTableModel viewTransactions(int AccNo) throws ClassNotFoundException, SQLException, RemoteException
{
 //Driver
 Class.forName("org.postgresql.Driver");
 Connection con = null;    
 con = DriverManager.getConnection ("jdbc:postgresql://localhost:5432/BANK","postgres", "Meandiou123");
   
 //Model
 DefaultTableModel mod = new DefaultTableModel(new String[] {"Transaction no.","Date","Reciever","Sender","Amount"} , 0);
    
 //View transactions 
 PreparedStatement read = con.prepareStatement ("SELECT * FROM Bank.transaction WHERE AccNo =" + AccNo+ "OR recieverAccNo =" +AccNo );
 ResultSet rs = read.executeQuery();
 while(rs.next()) 
  {
    String transactionNo = rs.getString(5);
    String date = rs.getString(1);
    String recieverAccNo = rs.getString(3);
    String senderAccNo = rs.getString(2);
    String transactionAmount = rs.getString(4);
       
    mod.addRow(new Object[] {transactionNo,date,recieverAccNo,senderAccNo,transactionAmount});
    System.out.println(transactionNo+"\n"+date+"\n"+recieverAccNo+"\n"+senderAccNo+"\n"+transactionAmount);
  }
 
//Closing
if (con != null)
con.close ();         
return mod; 
}

//INSERT TRANSACTION
public void insertTransaction(Transaction t) throws ClassNotFoundException, SQLException, RemoteException
{
  //Driver
  Class.forName("org.postgresql.Driver");
  Connection con = null;  
  con = DriverManager.getConnection ("jdbc:postgresql://localhost:5432/BANK","postgres", "Meandiou123");
  
  //Inserting
  PreparedStatement insert = con.prepareStatement ("INSERT INTO "
        +"Bank.transaction"+ " (AccNo,Date ,senderAccNo,recieverAccNo, transactionAmount) "+
        "VALUES("+t.getReceiverAccNo()+",'"+t.getDate()+"',"+t.getSenderAccNo()+","+t.getReceiverAccNo()+","+t.getTransactionAmount()+ ")");
  insert.executeUpdate();
  
  //Closing
  if (con != null)
  con.close ();
}

//VIEW BALANCE
public  String viewBalance(int AccNo) throws ClassNotFoundException, SQLException, RemoteException
  {
   //Driver
   Class.forName("org.postgresql.Driver");
   Connection con = null;  
   con = DriverManager.getConnection ("jdbc:postgresql://localhost:5432/BANK","postgres", "Meandiou123");
      
   //Receive balance from database    
   PreparedStatement read = con.prepareStatement ("SELECT * FROM Bank.accounts WHERE AccNo =" + AccNo );
   ResultSet rs = read.executeQuery();
      
    if (rs.next())
       {
        System.out.println(rs.getString(6));
       }
    
   //Closing 
   if (con != null)
       con.close ();   

   return balance;
  }

//VIEW ACC INFO
public DefaultTableModel viewAccountInfo(int AccNo) throws ClassNotFoundException, SQLException, RemoteException {
    
    //Driver
    Class.forName("org.postgresql.Driver");  
    Connection con = null;
    con = DriverManager.getConnection ("jdbc:postgresql://localhost:5432/BANK","postgres", "Meandiou123");
    
    //Model
    DefaultTableModel mod = new DefaultTableModel(new String[] {"First name: ","Last name: ","Account Number: ","Phone Number: ","Email: ","Balance: ","Login Nickname"},0);
    
    //Personal info view
    PreparedStatement read = con.prepareStatement ("SELECT * FROM Bank.accounts WHERE AccNo =" +AccNo );
    ResultSet rs = read.executeQuery();
    while(rs.next()) 
    {
        String fname = rs.getString(1);
        String lname = rs.getString(2);
        String accno = rs.getString(3);
        String phone = rs.getString(4);
        String balance = rs.getString(5);
        String email = rs.getString(6);
        String nick = rs.getString(7);
        
    mod.addRow(new Object[] {fname,lname,accno,phone,balance,email,nick});  

    //Closing
    if (con != null)
    con.close ();
    }
    return mod;
 }

//CHANGE BALANCE
public void changeBalance(int AccNo,double amount) throws ClassNotFoundException, SQLException, RemoteException
 {
 double money = 0;
 //Balance
    Class.forName("org.postgresql.Driver");
    Connection con = null;
    con = DriverManager.getConnection ("jdbc:postgresql://localhost:5432/BANK","postgres", "Meandiou123");
    
    PreparedStatement read = con.prepareStatement ("SELECT * FROM Bank.accounts WHERE AccNo =" + AccNo );
    ResultSet rs = read.executeQuery();
    while(rs.next()) 
      {
        money = Double.parseDouble(rs.getString(6));
      }
    System.out.println(money);
    
    //Changing balance
    money = money + amount;
    PreparedStatement changeBalance = con.prepareStatement("update Bank.accounts set balance = '"+money+"' where AccNo =" + AccNo );
    changeBalance.executeUpdate();
   
    //Closing
    if (con != null)
       con.close ();   
    }

//CHANGE EMAIL
public void changeEmail (int AccNo,String email) throws SQLException, ClassNotFoundException, RemoteException //updated 7.12
   {
   //Driver
   Class.forName("org.postgresql.Driver");  
   Connection con = null;
   con = DriverManager.getConnection ("jdbc:postgresql://localhost:5432/BANK","postgres", "Meandiou123");
 
   //Changing email
   PreparedStatement changeEmail = con.prepareStatement("update Bank.accounts set email= '"+email+"' where AccNo ="+ AccNo);
   changeEmail.executeUpdate();  
  }

//CHANGE PHONE NUMBER
public void changePhoneNo (int AccNo,String phoneNo) throws SQLException, ClassNotFoundException, RemoteException
 {
   //Driver
   Class.forName("org.postgresql.Driver");  
   Connection con = null;
   con = DriverManager.getConnection ("jdbc:postgresql://localhost:5432/BANK","postgres", "Meandiou123");

   //Changing phoneNo
   PreparedStatement changePhoneNo = con.prepareStatement("update Bank.accounts set phoneNo= '"+phoneNo+"' where AccNo ="+ AccNo);
   changePhoneNo.executeUpdate();
 }

//VIEW ALL ACCOUNT INFo
public DefaultTableModel viewAllAccountInfo() throws ClassNotFoundException, SQLException, RemoteException {
   
   //Driver
   Class.forName("org.postgresql.Driver");  
   Connection con = null;
   con = DriverManager.getConnection ("jdbc:postgresql://localhost:5432/BANK","postgres", "Meandiou123");
   
   //Model
   DefaultTableModel mod = new DefaultTableModel(new String[] {"First name: ","Last name: ","Account Number: ","Phone Number: ","Email: ","Balance: ","Login Nickname","Password"},0);
   
   //Personal info view
   PreparedStatement read = con.prepareStatement ("SELECT * FROM Bank.accounts" );
   ResultSet rs = read.executeQuery();
   while(rs.next()) 
   {
       String fname = rs.getString(1);
       String lname = rs.getString(2);
       String accno = rs.getString(3);
       String phone = rs.getString(4);
       String balance = rs.getString(5);
       String nick = rs.getString(7);
       String pass = rs.getString(8);
       
   mod.addRow(new Object[] {fname,lname,accno,phone,balance,nick,pass});  

   //Closing
   if (con != null)
   con.close ();
   }
   return mod;
    }
}
 

