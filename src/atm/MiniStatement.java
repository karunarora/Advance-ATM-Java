
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

class MiniStatement extends JFrame implements ActionListener
{
	JPanel panel;
	JButton jbutton;
	String t1,t2,t3;
	MiniStatement()
	{
		setLayout(new BorderLayout());
	
		panel = new JPanel();
		//JLabel label = new JLabel(new ImageIcon("statement.jpg"));
		//label.setBounds(0,0,500,500);
		
		jbutton = new JButton("OK");
		panel.add(jbutton);
		add(panel,BorderLayout.EAST);
		
		JPanel jpanel1 = new JPanel();
		JLabel jlabel = new JLabel("Your Last three Transactions are:-");
		jlabel.setFont(new Font("Calibri Black",Font.BOLD,20));
		jpanel1.add(jlabel);
		add(jpanel1,BorderLayout.CENTER);
		
		verifyUser();
		JLabel jlabel1=new JLabel("1. "+t3);
		JLabel jlabel2=new JLabel("2. "+t2);
		JLabel jlabel3=new JLabel("3. "+t1);
		jlabel1.setFont(new Font("Calibri Black",Font.BOLD,16));
		jpanel1.add(jlabel1);
		jlabel2.setFont(new Font("Calibri Black",Font.BOLD,20));
		jpanel1.add(jlabel2);
		jlabel3.setFont(new Font("Calibri Black",Font.BOLD,20));
		jpanel1.add(jlabel3);
		add(jpanel1,BorderLayout.CENTER);
		
		//add(label);
		
		jbutton.addActionListener(this);
		
		setSize(500,500);
		setVisible(true);
		setTitle("MINI STATEMENT");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                setExtendedState(MAXIMIZED_BOTH);
		setResizable(true);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==jbutton)
		{
			new LastFrame();
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
			ResultSet rst = st.executeQuery("select Trans_1,Trans_2,Trans_3 from atm.atm_users where Card_Number='"+CardNumber.cardvalue+"'");			
			if(rst.next())
			{
				flag=true;
				t1=rst.getString("Trans_1");
				t2=rst.getString("Trans_2");
				t3=rst.getString("Trans_3");
				
				if(t3.equals("1"))
				{
					t1="You didnot have any transaction";
					t2=t3="";
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
		new MiniStatement();
	}
}