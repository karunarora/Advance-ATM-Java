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
import java.util.Date;

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

class CashDeposit extends JFrame implements ActionListener
{
	JPanel jpanel;
	JButton jbutton;
	JTextField jtextfield;
	CashDeposit()
	{
		jpanel = new JPanel();
		JLabel label = new JLabel(new ImageIcon("atm1.jpg"));
		label.setBounds(0,0,600,600);
		
		jpanel = new JPanel(new FlowLayout());
		JLabel jlabel = new JLabel("Enter the amount you want to Deposit:-");
		jpanel.add(jlabel);
		jtextfield = new JTextField(10);
		jpanel.add(jtextfield);
		jbutton = new JButton("ENTER");
		jpanel.add(jbutton);
		add(jpanel,BorderLayout.NORTH);
		
		add(label);
		
		jbutton.addActionListener(this);
		
		setSize(600,600);
		setVisible(true);
		setTitle("CASH DEPOSIT");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);

	}
	int a;
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==jbutton)
		{
			String current = jtextfield.getText();
			a=Integer.parseInt(current);
			if(a<=25000)
			{
				verifyUser();
				//new WelcomeFrame();
                                new LastFrame();
				dispose();
			}
			else
			{
				JOptionPane.showMessageDialog(this,"You can Deposit only 25000 at one time");
			}
			jtextfield.setText(null);
		}
	}
	public Connection connect()
	{
		Connection con = null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			
                        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "abcd", "admin");
		}
		catch(Exception ex)
		{
			System.err.println(ex);
		}
		return con;
	}
	int b1;
	public boolean verifyUser()
	{
		boolean flag = false;
		try
		{
			Connection con = connect();
			Statement st = con.createStatement();
			ResultSet rst = st.executeQuery("select Total_Balance from atm.atm_users where Card_Number='"+CardNumber.cardvalue+"'");			
			if(rst.next())
				b1=rst.getInt("Total_Balance");
			
			ResultSet rst2=st.executeQuery("select Trans_1,Trans_2,Trans_3 from atm.atm_users where Card_Number='"+CardNumber.cardvalue+"'");
			if(rst2.next())
			{
				String trans1,trans2,trans3;
				trans1=rst2.getString("Trans_1");
				trans2=rst2.getString("Trans_2");
				trans3=rst2.getString("Trans_3");
				
				String temp;
				temp=trans2;
				trans1=trans2;
				trans2=trans3;
				Date date=new Date();
				trans3=("Money Deposit Rs."+a+"on"+date.toString());
				int i=st.executeUpdate("update atm.atm_users set Trans_1=\""+trans1+"\",Trans_2=\""+trans2+"\",Trans_3=\""+trans3+"\" where Card_Number='"+CardNumber.cardvalue+"'");
			}
			
			int temp=b1+a;
			if(temp>10000)
			{
				int b = st.executeUpdate("update atm.atm_users set Total_Balance='"+temp+"'where Card_Number='"+CardNumber.cardvalue+"'");
				if(b==1)
				{
					JOptionPane.showMessageDialog(this,"Amount Deposit Successfully");
				}
				else
				{
					JOptionPane.showMessageDialog(this,"Transaction Failed.Please try again");
				}
			}
		}
		catch(Exception ex)
		{
			System.err.println(ex);
		}
		return flag;
	}
	public static void main(String ar[])
	{
		new CashDeposit();
	}
}