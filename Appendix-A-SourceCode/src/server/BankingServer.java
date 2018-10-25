package server;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;

import model.Adapter;
import model.BankingModel;
import model.BankingModelManager;
import model.Transaction;

public class BankingServer extends BankingModelManager implements iBankingServer {

   private BankingModel db;
   public BankingServer() throws RemoteException, ClassNotFoundException {
	   db = new BankingModelManager();
      UnicastRemoteObject.exportObject(this, 0);
     
   }

   @Override
   public DefaultTableModel viewTransactions(int AccNo) throws RemoteException, ClassNotFoundException, SQLException  {
      
      return db.viewTransactions(AccNo);
      
   }
   @Override
   public DefaultTableModel viewAllAccountInfo() throws ClassNotFoundException, SQLException, RemoteException {
	    return db.viewAllAccountInfo();
   }

   @Override
   public void insertTransaction(Transaction t) throws RemoteException, ClassNotFoundException, SQLException{
         db.insertTransaction(t);
   }

   @Override
   public String viewBalance(int AccNo) throws RemoteException, ClassNotFoundException, SQLException{
      String balance = null;
      balance = db.viewBalance(AccNo);
      return balance;
   }

   @Override
   public DefaultTableModel viewAccountInfo(int AccNo) throws RemoteException, ClassNotFoundException, SQLException{
      
    
   return db.viewAccountInfo(AccNo);
   }

   @Override
   public void changeBalance(int AccNo,double amount)throws RemoteException, ClassNotFoundException, SQLException {
         db.changeBalance(AccNo,amount);
   }
   @Override
   public void changeEmail(int AccNo,String email)throws RemoteException, ClassNotFoundException, SQLException {  
         db.changeEmail(AccNo,email);
   }

   @Override
   public void changePhoneNo(int AccNo,String phoneNo)throws RemoteException, ClassNotFoundException, SQLException {
         db.changePhoneNo(AccNo, phoneNo);
   }
   public static void main(String [] args){
      try
      {  
     
      LocateRegistry.createRegistry(1099);
      iBankingServer server = new BankingServer();
      Naming.rebind("bank",server);
      System.out.println("Starting server...");
      System.out.println("Server Running");
      
      }
      catch(Exception ex)
      {
         ex.printStackTrace();
      }
   }
}

