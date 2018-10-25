package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

public class Transaction implements Serializable {

   private LocalDate date;
   private String transactionNo;
   private int senderAccNo;
   private int receiverAccNo;
   private double transactionAmount;
   
   public Transaction(){};
    
   public Transaction(LocalDate date,int senderAccNo,int receiverAccNo,double transactionAmount){
      this.date = date;
      
      this.senderAccNo = senderAccNo;
      this.receiverAccNo= receiverAccNo;
      this.transactionAmount = transactionAmount;
   }
   public String toString(){
      return "Transaction date: " + date + "/ Transaction Number: " + transactionNo + "/ Sender: " + senderAccNo + "/ Receiver: " + receiverAccNo + "/ Transaction Amount: " + transactionAmount;
   }
   public void setDate(LocalDate date) {
      this.date = date;
   }

   public void setTransactionNo(String transactionNo) {
      this.transactionNo = transactionNo;
   }

   public void setSenderAccNo(int senderAccNo) {
      this.senderAccNo = senderAccNo;
   }

   public void setReceiverAccNo(int receiverAccNo) {
      this.receiverAccNo = receiverAccNo;
   }

   public LocalDate getDate() {
      return date;
   }

   public String getTransactionNo() {
      return transactionNo;
   }

   public double getSenderAccNo() {
      return senderAccNo;
   }

   public double getReceiverAccNo() {
      return receiverAccNo;
   }

   public double getTransactionAmount() {
      return transactionAmount;
   }

}