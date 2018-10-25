package model;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.Date;

import javax.swing.table.DefaultTableModel;


public class BankingModelManager implements BankingModel{

	public iAdapter a;
	
	public BankingModelManager() throws ClassNotFoundException {
		a = new Adapter();
	}
	@Override
	public DefaultTableModel viewTransactions(int AccNo) throws ClassNotFoundException, RemoteException, SQLException {
		return a.viewTransactions(AccNo);
	}
	@Override
	public DefaultTableModel viewAllAccountInfo() throws ClassNotFoundException, SQLException, RemoteException {
	     return a.viewAllAccountInfo();
	}
	@Override
	public void insertTransaction(Transaction t) throws ClassNotFoundException, RemoteException, SQLException 
	{
		a.insertTransaction(t);
	}

	@Override
	public DefaultTableModel viewAccountInfo(int AccNo) throws ClassNotFoundException, RemoteException, SQLException {
		DefaultTableModel table = null;
		table = a.viewAccountInfo(AccNo);
		return table;
	}

	@Override
	public String viewBalance(int AccNo) throws ClassNotFoundException, RemoteException, SQLException {
		return a.viewBalance(AccNo);
	}

	@Override
	public void changeBalance(int AccNo, double amount) throws ClassNotFoundException, RemoteException, SQLException {
		a.changeBalance(AccNo, amount);	
	}

	@Override
	public void changeEmail(int AccNo, String email) throws ClassNotFoundException, RemoteException, SQLException {
		a.changeEmail(AccNo,email);
	}

	@Override
	public void changePhoneNo(int AccNo, String phoneNo) throws ClassNotFoundException, RemoteException, SQLException {
		a.changePhoneNo(AccNo,phoneNo);
	}

	

}
