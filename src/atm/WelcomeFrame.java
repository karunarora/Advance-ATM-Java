/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ImageIcon;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WelcomeFrame extends JFrame implements ActionListener
{
	JButton jbutton1,jbutton2,jbutton3,jbutton4,jbutton5;
	JPanel jpanel,jpanel1;
	JLabel jlabel;
	
	WelcomeFrame()
	{
		setLayout(new BorderLayout());
		
		jpanel1 = new JPanel();
		JLabel label = new JLabel(new ImageIcon("atm1.jpg"));
		label.setBounds(0,0,600,600);
		jlabel = new JLabel(" Welcome " +PinNumber.user + " .Please proceed further. ");
		jpanel1.add(jlabel);
		add(jpanel1,BorderLayout.NORTH);
		
		jpanel = new JPanel(new GridLayout(5,1,10,10));
		jbutton1 = new JButton("Balance Enquiry");
		jbutton2 = new JButton("Cash Withdrawl");
		jbutton3 = new JButton("Cash Deposit");
		jbutton4 = new JButton("Mini Statement");
		jbutton5 = new JButton("Pin Change");
		jpanel.add(jbutton1);
		jpanel.add(jbutton2);
		jpanel.add(jbutton3);
		jpanel.add(jbutton4);
		jpanel.add(jbutton5);
		add(jpanel,BorderLayout.EAST);
		
		add(label);
		
		jbutton1.addActionListener(this);
		jbutton2.addActionListener(this);
		jbutton3.addActionListener(this);
		jbutton4.addActionListener(this);
		jbutton5.addActionListener(this);
		 
		setSize(600,600);
		setTitle("WELCOME");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==jbutton1)
		{
			new BalanceEnquiry();
			dispose();
		}
		else if (ae.getSource()==jbutton2)
		{
			new Withdrawl();
			dispose();
		}
		else if (ae.getSource()==jbutton3)
		{
			new CashDeposit();
			dispose();
		}
		else if (ae.getSource()==jbutton4)
		{
			new MiniStatement();
			dispose();
		}
		else if (ae.getSource()==jbutton5)
		{
			new PinChange();
			dispose();
		}
	}
	public static void main(String ar[])
	{
		new WelcomeFrame();
	}
}
