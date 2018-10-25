package view;

import javax.swing.*;

import model.BankingController;

import java.awt.*;
import java.awt.event.*;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;


public class loginGUI extends JFrame {
	BankingController control;
public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
loginGUI frameTabel = new loginGUI();

}

JButton blogin = new JButton("Login");
JPanel panel = new JPanel();
JTextField txuser = new JTextField(15);
JPasswordField pass = new JPasswordField(15);
private final JLabel lblNick = new JLabel("Nick");
private final JLabel lblPassword = new JLabel("Password");

loginGUI() throws MalformedURLException, RemoteException, NotBoundException{
super("Login");
setSize(440,293);
setLocation(500,280);
panel.setBackground(Color.WHITE);
panel.setLayout (null); 

control = new BankingController();
txuser.setBackground(Color.LIGHT_GRAY);

txuser.setBounds(79,42,126,20);
pass.setBackground(Color.LIGHT_GRAY);
pass.setBounds(79,113,126,20);
blogin.setFont(new Font("Arial", Font.BOLD, 13));
blogin.setBounds(104,180,80,20);

panel.add(blogin);
panel.add(txuser);
panel.add(pass);

getContentPane().add(panel);
lblNick.setFont(new Font("Arial", Font.BOLD, 13));
lblNick.setBounds(10, 44, 46, 14);
panel.add(lblNick);
lblPassword.setFont(new Font("Arial", Font.BOLD, 13));
lblPassword.setBounds(10, 115, 83, 14);
panel.add(lblPassword);
JLabel label = new JLabel("");
label.setIcon(new ImageIcon(loginGUI.class.getResource("/view/bankLogo.png")));
label.setBounds(244, 23, 118, 202);
panel.add(label);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
actionlogin();
}

public void actionlogin(){
blogin.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent ae) {
String puname = txuser.getText();
String ppaswd = pass.getText();
try
{
   if(control.login(puname, ppaswd)){
      
   GUI mainGui =new GUI(control);
   mainGui.setVisible(true);
   dispose();
   
   }
      else 
      {
         JOptionPane.showMessageDialog(null,"Wrong Password / Username");
         txuser.setText("");
         pass.setText("");
         txuser.requestFocus();
      }
}
catch (HeadlessException e)
{
   // TODO Auto-generated catch block
   e.printStackTrace();
}
catch (ClassNotFoundException e)
{
   // TODO Auto-generated catch block
   e.printStackTrace();
}
catch (RemoteException e)
{
   // TODO Auto-generated catch block
   e.printStackTrace();
}
catch (SQLException e)
{
   // TODO Auto-generated catch block
   e.printStackTrace();
}

}
});
}
}
