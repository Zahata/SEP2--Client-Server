package client;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;

import server.iBankingServer;
import model.Transaction;

public class BankingClient {
   
   private iBankingServer server;
   
   public BankingClient() throws MalformedURLException, RemoteException, NotBoundException {
	   
       server = (iBankingServer)Naming.lookup("rmi://10.152.200.112/bank");
     }  
   
   public DefaultTableModel viewTransactions(int AccNo) throws RemoteException, ClassNotFoundException, SQLException
   {
      return server.viewTransactions(AccNo);
   }
   public DefaultTableModel viewAllAccountInfo() throws ClassNotFoundException, SQLException, RemoteException {
	    return server.viewAllAccountInfo();
   }
   
   public void insertTransaction(Transaction t) throws RemoteException, ClassNotFoundException, SQLException
   {
      server.insertTransaction(t);
   }
   
   public String viewBalance(int AccNo) throws RemoteException, ClassNotFoundException, SQLException
   {
      return server.viewBalance(AccNo);
   }
   public void changeBalance(int AccNo,double amount) throws ClassNotFoundException, RemoteException, SQLException {
	   server.changeBalance(AccNo, amount);
   }
   
   public DefaultTableModel viewAccountInfo(int AccNo)throws RemoteException, ClassNotFoundException, SQLException
   {
      return server.viewAccountInfo(AccNo);
   }
   
   public void changeEmail(int AccNo,String email)throws RemoteException, ClassNotFoundException, SQLException
   {
      server.changeEmail(AccNo, email);
   }
   
   public void changePhoneNo(int AccNo,String number)throws RemoteException, ClassNotFoundException, SQLException
   {
      server.changePhoneNo(AccNo, number);
   }
   
   public static void main(String[] args)
   {
      try
      {
         BankingClient c = new BankingClient();
         System.out.println("connected to server"); 
      }
      catch (MalformedURLException e)
      {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      catch (RemoteException e)
      {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      catch (NotBoundException e)
      {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      
   }
   
}