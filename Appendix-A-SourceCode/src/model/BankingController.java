package model;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;

import client.BankingClient;

public class BankingController implements iBankingController {
	
	private int accNo;	
	private BankingClient client;
	
	
	
	
	public void setAccNo(int acc) {
		accNo = acc;
	}
	public int getAccNo() {
		return accNo; 
	}
	@Override
	public DefaultTableModel viewAllAccountInfo() throws ClassNotFoundException, SQLException, RemoteException {
	    return client.viewAllAccountInfo();
	}
	public boolean nick(String nick) throws ClassNotFoundException, RemoteException, SQLException {
		DefaultTableModel tab = new DefaultTableModel();
		tab = client.viewAllAccountInfo();
		
		for (int i = 0; i < tab.getRowCount(); i++) {
			if (nick.equals(tab.getValueAt(i, 7)));
			return true;
		}
		return false;
	}
	public boolean pass(String pass) throws ClassNotFoundException, RemoteException, SQLException {
		DefaultTableModel tab = new DefaultTableModel();
		tab = client.viewAllAccountInfo();
		
		for (int i = 0; i < tab.getRowCount(); i++) {
			if (pass.equals(tab.getValueAt(i, 8)));
			return true;
		}
		return false;
	}
	public	 BankingController() throws MalformedURLException, RemoteException, NotBoundException {
		client = new BankingClient();
	}
	@Override
	public DefaultTableModel viewTransactions(int AccNo) throws ClassNotFoundException, SQLException, RemoteException {
		return	client.viewTransactions(AccNo);
	}
	@Override
	public void insertTransaction(Transaction t) throws ClassNotFoundException, SQLException, RemoteException {
			client.insertTransaction(t);
	}
	@Override
	public  String viewBalance(int AccNo) throws ClassNotFoundException, SQLException, RemoteException {
		return	client.viewBalance(AccNo);
	}
	@Override
	public DefaultTableModel viewAccountInfo(int AccNo) throws ClassNotFoundException, SQLException, RemoteException {
		return	client.viewAccountInfo(AccNo);
	}
	@Override
	public void changeEmail (int AccNo,String email) throws SQLException, ClassNotFoundException, RemoteException {
			client.changeEmail(AccNo, email);
	}
	@Override
	public void changePhoneNo (int AccNo,String phoneNo) throws SQLException, ClassNotFoundException, RemoteException {
			client.changePhoneNo(AccNo, phoneNo);
	}
	@Override
	public void changeBalance(int AccNo,double amount) throws ClassNotFoundException, RemoteException, SQLException {
		   client.changeBalance(AccNo, amount);
	   }
	
	public boolean login(String nick, String pass) throws ClassNotFoundException, RemoteException, SQLException {
      DefaultTableModel tab = new DefaultTableModel();
      tab = client.viewAllAccountInfo();
      
      for (int i = 0; i < tab.getRowCount(); i++) {
         if ((nick.equals(tab.getValueAt(i, 5).toString()))&&(pass.equals(tab.getValueAt(i,6).toString()))) {
         accNo = Integer.parseInt(tab.getValueAt(i,2).toString());
         return true;
         }
      }
      return false;
      
   }
   public void logout() {
      accNo = 0;
   }
}
