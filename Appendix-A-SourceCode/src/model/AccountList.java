package model;

import utility.collection.LinkedList;


public class AccountList {
	
	private LinkedList<Account> accounts;
	
	public AccountList(){
		accounts = new LinkedList<>();
	}
	
	public void addAccount(Account account){
		accounts.add(account);
	}
	
	public void removeAccount(Account account){
		accounts.remove(account);
	}
	
	public Account getAccount(int index){
		return accounts.get(index);
	}
	public int size(){
		return accounts.size();
	}

}
