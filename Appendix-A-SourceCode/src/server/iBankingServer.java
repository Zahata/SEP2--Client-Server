package server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;

import model.Account;
import model.Transaction;
import utility.collection.LinkedList;

public interface iBankingServer extends Remote{

	public DefaultTableModel viewTransactions(int AccNo) throws ClassNotFoundException, SQLException, RemoteException;
	public void insertTransaction(Transaction t) throws ClassNotFoundException, SQLException, RemoteException;
	public  String viewBalance(int AccNo) throws ClassNotFoundException, SQLException, RemoteException;
	public DefaultTableModel viewAccountInfo(int AccNo) throws ClassNotFoundException, SQLException, RemoteException;
	public void changeBalance(int AccNo,double amount) throws ClassNotFoundException, SQLException, RemoteException;
	public void changeEmail (int AccNo,String email) throws SQLException, ClassNotFoundException, RemoteException;
	public void changePhoneNo (int AccNo,String phoneNo) throws SQLException, ClassNotFoundException, RemoteException;
	public DefaultTableModel viewAllAccountInfo() throws ClassNotFoundException, SQLException, RemoteException;
	    
	
	 
}
