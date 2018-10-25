package model;

import java.io.Serializable;

public class Account {
 
	private String fname;
	private String lname;
	private int accountNo;
	private double balance;
	private String phoneNo;
	private String email;
	
	
	
	public Account(String fname,String lname,int accountNo,double balance,String phoneNo,String email){
		this.fname = fname;
		this.lname =  lname;
		this.accountNo = accountNo;
		this.balance = balance;
		this.phoneNo = phoneNo;
		this.email = email;
	}
	
	 public String toString(){
		 return "Full name" + fname + lname + "/ Account number: " + accountNo + "/ Balance: " + balance 
				 + "/ Phone number: " + phoneNo + "/ Email: " + email;
	 }
	 
		public void setAccountNo(int accountNo){
			accountNo = (int) (Math.random()*999999);
		}
	

	public String getFname() {
		return fname;
	}

	public String getLname() {
		return lname;
	}

	public double getAccountNo() {
		return accountNo;
	}

	public double getBalance() {
		return balance;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public String getEmail() {
		return email;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	

}
