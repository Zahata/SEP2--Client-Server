package model;

import utility.collection.LinkedList;

public class TransactionList {
	
	private LinkedList<Transaction> transactions;
	
	public TransactionList(){
		transactions = new LinkedList<>();
	}
	
	public void addTransaction(Transaction transaction){
		transactions.add(transaction);
	}
	public void removeTransaction(Transaction transaction){
		transactions.remove(transaction);
	}
	public Transaction getTransaction(int index){
		return transactions.get(index);
	}
	public int size(){
		return transactions.size();
	}

}
