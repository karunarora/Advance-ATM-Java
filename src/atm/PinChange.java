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
import javax.swing.JPasswordField;

class PinChange extends JFrame implements ActionListener
{
	JPanel jpanel,jpanel1;
	JPasswordField jtextfield,jtextfield1,jtextfield2;
	JButton jbutton_cancel,jbutton_clear,jbutton_enter;
	PinChange()
	{
		setLayout(new BorderLayout());
		
		jpanel = new JPanel();
		JLabel label_image = new JLabel(new ImageIcon("atm1.jpg"));
		label_image.setBounds(0,0,600,600);
			
		jpanel = new JPanel(new GridLayout(3,1));
		JLabel jlabel = new JLabel("Enter your old PIN :-");
		jpanel.add(jlabel);
		jtextfield = new JPasswordField(10);
		jpanel.add(jtextfield);
		JLabel jlabel1 = new JLabel("Enter your new PIN :-");
		jpanel.add(jlabel1);
		jtextfield1 = new JPasswordField(10);
		jpanel.add(jtextfield1);
		JLabel jlabel2 = new JLabel("Re-Enter your PIN :-");
		jpanel.add(jlabel2);
		jtextfield2 = new JPasswordField(10);
		jpanel.add(jtextfield2);
		jlabel.setFont(new Font("Calibri Black",Font.BOLD,10));
		jlabel1.setFont(new Font("Calibri Black",Font.BOLD,10));
		jlabel2.setFont(new Font("Calibri Black",Font.BOLD,10));

		add(jpanel,BorderLayout.NORTH);
		
		jpanel1 = new JPanel(new GridLayout(1,3,10,10));
		jbutton_enter = new JButton("ENTER");
		jbutton_cancel = new JButton("CANCEL");
		jbutton_clear = new JButton("CLEAR");
		
		jpanel1.add(jbutton_cancel);
		jpanel1.add(jbutton_enter);
		jpanel1.add(jbutton_clear);
		add(jpanel1,BorderLayout.SOUTH);

		add(label_image);

		jbutton_cancel.addActionListener(this);
		jbutton_enter.addActionListener(this);
		jbutton_clear.addActionListener(this);
		
		setSize(600,600);
		setVisible(true);
		setTitle("BALANCE DETAILS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
	}
	int a,b;
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==jbutton_enter)
		{
			String pin = jtextfield.getText();
			String newpin = jtextfield1.getText();
			String confirmpin = jtextfield2.getText();
			a=Integer.parseInt(newpin);
			b=Integer.parseInt(confirmpin);
			if(pin.length()==4)
			{
				if( a==b && !newpin.isEmpty())
				{
					verifyUser();
					new LastFrame();
					dispose();
				}
				else
				{
					JOptionPane.showMessageDialog(this,"Please Confirm Your PIN");
				}
				jtextfield.setText(null);
				jtextfield1.setText(null);
				jtextfield2.setText(null);
			}
			else if ( !newpin.isEmpty() || !confirmpin.isEmpty())
			{
				JOptionPane.showMessageDialog(this,"Pin should be of 4 digits");
				jtextfield.setText(null);
				jtextfield1.setText(null);
				jtextfield2.setText(null);
			}
			
		}
		else if(ae.getSource()==jbutton_clear)
		{
			jtextfield.setText(null);
			jtextfield1.setText(null);
			jtextfield2.setText(null);
		}
		else if(ae.getSource()==jbutton_cancel)
		{
			new WelcomeFrame();
			dispose();
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
	public boolean verifyUser()
	{
		boolean flag = false;
		try
		{
			Connection con = connect();
			Statement st = con.createStatement();
			int rst = st.executeUpdate("update atm.atm_users set Pin='"+a+"'where Card_Number='"+CardNumber.cardvalue+"'");			
			if(rst==1)
			{
				JOptionPane.showMessageDialog(this,"You have successfully changed your Pin");
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
		new PinChange();
	}
}