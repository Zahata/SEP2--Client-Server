package model;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.Date;

import javax.swing.table.DefaultTableModel;


public interface BankingModel {
	
	public DefaultTableModel viewTransactions(int AccNo) throws ClassNotFoundException, SQLException, RemoteException;
	public void insertTransaction(Transaction t) throws ClassNotFoundException, SQLException, RemoteException;
	public  String viewBalance(int AccNo) throws ClassNotFoundException, SQLException, RemoteException;
	public DefaultTableModel viewAccountInfo(int AccNo) throws ClassNotFoundException, SQLException, RemoteException;
	public void changeBalance(int AccNo,double amount) throws ClassNotFoundException, SQLException, RemoteException;
	public void changeEmail (int AccNo,String email) throws SQLException, ClassNotFoundException, RemoteException;
	public void changePhoneNo (int AccNo,String phoneNo) throws SQLException, ClassNotFoundException, RemoteException;
	public DefaultTableModel viewAllAccountInfo() throws ClassNotFoundException, SQLException, RemoteException;
	    
}
