package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import model.BankingController;
import model.Transaction;

import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.Font;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class GUI extends JFrame
{
   private JPanel contentPane;
   private JTextField emailText;
   private JTextField phoneNoText;
   private JTable table;
   private JTextField textField_4;
   private JTextField textField_5;
   private JTable table_1;

   /**
    * Launch the application.
    */
   public static void main(String[] args)
   {
      EventQueue.invokeLater(new Runnable()
      {
         public void run()
         {
            try
            {
            
               BankingController c = new BankingController();
               GUI frame = new GUI(c);
               frame.setVisible(true);
               frame.pack();
            }
            catch (Exception e)
            {
               e.printStackTrace();
            }
         }
      });
   }

   /**
    * Create the frame.
    */
   
   //CONSTRUCTOR
   public GUI(BankingController c)
   {
      super("Internet Banking");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(100, 100, 793, 450);
      contentPane = new JPanel();
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(contentPane);
      contentPane.setLayout(null);
      
      JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
      tabbedPane.setBackground(Color.WHITE);
      tabbedPane.setBounds(0, 0, 774, 413);
      contentPane.add(tabbedPane);
      
      //VIEW TRANSACTIONS
      DefaultTableModel m = null;
      
      try
      {
         m = c.viewAccountInfo(c.getAccNo());
      }
      catch (RemoteException | ClassNotFoundException | SQLException e)
      {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      
      JPanel AccountInfo = new JPanel();
      AccountInfo.setBackground(Color.WHITE);
      tabbedPane.addTab("Account Information", null, AccountInfo, null);
      AccountInfo.setLayout(null);
      
      JLabel lblEditing = new JLabel("EDITING");
      lblEditing.setFont(new Font("Arial", Font.BOLD, 20));
      lblEditing.setBounds(10, 164, 343, 31);
      AccountInfo.add(lblEditing);
      
      JSeparator separator = new JSeparator();
      separator.setBounds(-14, 151, 773, 2);
      AccountInfo.add(separator);
      
      JLabel lblPhoneNo = new JLabel("Phone no.:");
      lblPhoneNo.setFont(new Font("Arial", Font.BOLD, 13));
      lblPhoneNo.setBounds(10, 206, 86, 20);
      AccountInfo.add(lblPhoneNo);
      
      JLabel lblEmail_1 = new JLabel("E-mail:");
      lblEmail_1.setFont(new Font("Arial", Font.BOLD, 13));
      lblEmail_1.setBounds(10, 247, 86, 20);
      AccountInfo.add(lblEmail_1);
      
      emailText = new JTextField();
      emailText.setBackground(Color.LIGHT_GRAY);
      emailText.setColumns(10);
      emailText.setBounds(83, 248, 121, 20);
      AccountInfo.add(emailText);
      
      //CHANGE PHONE NUMBER
      JButton btnChangePhoneNo = new JButton("Change Phone no.");
      btnChangePhoneNo.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) 
         {
           
           String phoneNo = phoneNoText.getText();
           try
         {
            c.changePhoneNo(c.getAccNo(),phoneNo);
            JOptionPane.showMessageDialog(null,"Relog to see changes");
            phoneNoText.setText("");
            phoneNoText.requestFocus();
         }
         catch (ClassNotFoundException e1)
         {
            // TODO Auto-generated catch block
            e1.printStackTrace();
         }
         catch (RemoteException e1)
         {
            // TODO Auto-generated catch block
            e1.printStackTrace();
         }
         catch (SQLException e1)
         {
            // TODO Auto-generated catch block
            e1.printStackTrace();
         }
         }
      });
      
      
      btnChangePhoneNo.setFont(new Font("Arial", Font.BOLD, 13));
      btnChangePhoneNo.setBounds(232, 206, 178, 20);
      AccountInfo.add(btnChangePhoneNo);
      
      phoneNoText = new JTextField();
      phoneNoText.setBackground(Color.LIGHT_GRAY);
      phoneNoText.setColumns(10);
      phoneNoText.setBounds(83, 206, 121, 20);
      AccountInfo.add(phoneNoText);
      
      
      // CHANGE EMAIL 
      JButton btnChangeEmail = new JButton("Change E-mail");
      btnChangeEmail.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) 
         {
            String email = emailText.getText();
            try
            {
               c.changeEmail(c.getAccNo(),email);
               JOptionPane.showMessageDialog(null,"Relog to see changes");
               emailText.setText("");
               emailText.requestFocus();
            }
            catch (ClassNotFoundException e1)
            {
               // TODO Auto-generated catch block
               e1.printStackTrace();
            }
            catch (RemoteException e1)
            {
               // TODO Auto-generated catch block
               e1.printStackTrace();
            }
            catch (SQLException e1)
            {
               // TODO Auto-generated catch block
               e1.printStackTrace();
            }
         }
      });
      
      
      btnChangeEmail.setFont(new Font("Arial", Font.BOLD, 13));
      btnChangeEmail.setBounds(232, 247, 178, 20);
      AccountInfo.add(btnChangeEmail);
      
      JLabel lblAccountInformation = new JLabel("ACCOUNT INFORMATION");
      lblAccountInformation.setFont(new Font("Arial", Font.BOLD, 20));
      lblAccountInformation.setBounds(10, 11, 343, 25);
      AccountInfo.add(lblAccountInformation);
      
      table_1 = new JTable(m);
      table_1.setFont(new Font("Arial", Font.PLAIN, 13));
      
      table_1.setShowGrid(false);
      table_1.setShowHorizontalLines(false);
      table_1.setShowVerticalLines(false);
      
      table_1.setBounds(10, 74, 749, 18);
      AccountInfo.add(table_1);
      
      //LOGOUT
      loginGUI login;
      JButton btnLogout = new JButton("Logout");
      btnLogout.setFont(new Font("Arial", Font.BOLD, 13));
      btnLogout.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent arg0) 
         {
            loginGUI login = null;
            try
            {
               login = new loginGUI();
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
            login.setVisible(true);
            dispose();   
         }
      });
      
      
      btnLogout.setBounds(656, 15, 89, 23);
      AccountInfo.add(btnLogout);
      
      JLabel lblName = new JLabel("Name:");
      lblName.setFont(new Font("Arial", Font.BOLD, 13));
      lblName.setBounds(10, 49, 57, 14);
      AccountInfo.add(lblName);
      
      JLabel lblAccountNo = new JLabel("Account no.");
      lblAccountNo.setFont(new Font("Arial", Font.BOLD, 13));
      lblAccountNo.setBounds(222, 49, 94, 14);
      AccountInfo.add(lblAccountNo);
      
      JLabel lblPhoneNo_1 = new JLabel("Phone no.");
      lblPhoneNo_1.setFont(new Font("Arial", Font.BOLD, 13));
      lblPhoneNo_1.setBounds(326, 49, 71, 14);
      AccountInfo.add(lblPhoneNo_1);
      
      JLabel lblBalance = new JLabel("Balance");
      lblBalance.setFont(new Font("Arial", Font.BOLD, 13));
      lblBalance.setBounds(546, 49, 72, 14);
      AccountInfo.add(lblBalance);
      
      JLabel lblEmail = new JLabel("E-mail");
      lblEmail.setFont(new Font("Arial", Font.BOLD, 13));
      lblEmail.setBounds(439, 49, 46, 14);
      AccountInfo.add(lblEmail);
      
      JLabel lblLoginName = new JLabel("Login name");
      lblLoginName.setFont(new Font("Arial", Font.BOLD, 13));
      lblLoginName.setBounds(656, 48, 89, 15);
      AccountInfo.add(lblLoginName);
      
      JLabel label = new JLabel("");
      label.setIcon(new ImageIcon(GUI.class.getResource("/view/bankLogo.png")));
      label.setBounds(548, 175, 121, 199);
      AccountInfo.add(label);
      
      JPanel tansferMoney = new JPanel();
      tansferMoney.setBackground(Color.WHITE);
      tabbedPane.addTab("Transfer money", null, tansferMoney, null);
      tansferMoney.setLayout(null);
      
      textField_4 = new JTextField();
      textField_4.setBackground(Color.LIGHT_GRAY);
      textField_4.setBounds(10, 105, 123, 20);
      tansferMoney.add(textField_4);
      textField_4.setColumns(10);
      
      JLabel lblRecieverAccountNumber = new JLabel("Receiver account number");
      lblRecieverAccountNumber.setFont(new Font("Arial", Font.BOLD, 18));
      lblRecieverAccountNumber.setBounds(10, 80, 233, 14);
      tansferMoney.add(lblRecieverAccountNumber);
      
      JLabel lblTransactionAmmount = new JLabel("Transaction amount");
      lblTransactionAmmount.setFont(new Font("Arial", Font.BOLD, 18));
      lblTransactionAmmount.setBounds(10, 171, 233, 14);
      tansferMoney.add(lblTransactionAmmount);
      
      textField_5 = new JTextField();
      textField_5.setBackground(Color.LIGHT_GRAY);
      textField_5.setBounds(10, 208, 123, 20);
      tansferMoney.add(textField_5);
      textField_5.setColumns(10);
      
      //MAKING TRANSACTIONS
      JButton btnSend = new JButton("SEND");
      btnSend.addActionListener(new ActionListener() 
      {
         public void actionPerformed(ActionEvent e) 
         {   
            int recAcc = Integer.parseInt(textField_4.getText());
            double amount = Double.valueOf((textField_5.getText()));
            LocalDate date = LocalDate.now();
            Transaction t = new Transaction(date, c.getAccNo(), recAcc,amount);
            try 
            {
               c.insertTransaction(t);
               c.changeBalance(c.getAccNo(), -amount);
               c.changeBalance(recAcc, amount);
               JOptionPane.showMessageDialog(null,"Relog to see new transactions");
               textField_4.setText("");
               textField_4.requestFocus();
               textField_5.setText("");
               textField_5.requestFocus();
            } 
            catch (ClassNotFoundException | RemoteException | SQLException e1) 
            {
               // TODO Auto-generated catch block
               e1.printStackTrace();
            }
         }
     });
      
      
      btnSend.setFont(new Font("Arial", Font.BOLD, 13));
      btnSend.setBounds(10, 351, 123, 23);
      tansferMoney.add(btnSend);
      
      JLabel lblTransferMoney = new JLabel("TRANSFER MONEY");
      lblTransferMoney.setFont(new Font("Arial", Font.BOLD, 20));
      lblTransferMoney.setBounds(10, 7, 366, 44);
      tansferMoney.add(lblTransferMoney);
      
      JLabel label_1 = new JLabel("");
      label_1.setIcon(new ImageIcon(GUI.class.getResource("/view/bankLogo.png")));
      label_1.setBounds(580, 134, 118, 202);
      tansferMoney.add(label_1);
      
      JPanel Transactions = new JPanel();
      Transactions.setBackground(Color.WHITE);
      tabbedPane.addTab("Transactions", null, Transactions, null);
      Transactions.setLayout(null);
      
      //VIEW TRANSACTIONS
      DefaultTableModel m1 = null;
      try
      {
         m1 = c.viewTransactions(c.getAccNo());
      }
      catch (RemoteException | ClassNotFoundException | SQLException e)
      {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      
         
      table = new JTable(m1);
      table.setBounds(10, 39, 749, 335);
      Transactions.add(table);
      
      JLabel lblAccountNo_1 = new JLabel("Account no.");
      lblAccountNo_1.setFont(new Font("Arial", Font.BOLD, 13));
      lblAccountNo_1.setBounds(160, 14, 78, 14);
      Transactions.add(lblAccountNo_1);
      
      JLabel lblDate = new JLabel("Date");
      lblDate.setFont(new Font("Arial", Font.BOLD, 13));
      lblDate.setBounds(455, 14, 46, 14);
      Transactions.add(lblDate);
      
      JLabel lblSenderAccountNo = new JLabel("Sender account no.");
      lblSenderAccountNo.setFont(new Font("Arial", Font.BOLD, 13));
      lblSenderAccountNo.setBounds(308, 14, 137, 14);
      Transactions.add(lblSenderAccountNo);
      
      JLabel lblReceiverAccountNo = new JLabel("Receiver account no.");
      lblReceiverAccountNo.setFont(new Font("Arial", Font.BOLD, 13));
      lblReceiverAccountNo.setBounds(608, 14, 137, 14);
      Transactions.add(lblReceiverAccountNo);
      
      JLabel lblAmount = new JLabel("Amount");
      lblAmount.setFont(new Font("Arial", Font.BOLD, 13));
      lblAmount.setBounds(10, 14, 76, 14);
      Transactions.add(lblAmount);
      
      setMinimumSize(new Dimension(800, 300));
      setLocationRelativeTo(null);
   }
}
