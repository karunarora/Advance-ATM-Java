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

class Withdrawl extends JFrame implements ActionListener
{
	JPanel jpanel;
	JButton jbutton1,jbutton2;
	Withdrawl()
	{
		setLayout(new BorderLayout());
		
		jpanel = new JPanel();
		JLabel label = new JLabel(new ImageIcon("atm1.jpg"));
		//label.setBounds(0,0,600,600);
		
		jpanel = new JPanel(new GridLayout(2,1,10,10));
		jbutton1 = new JButton("CURRENT");
		jbutton2 = new JButton("SAVINGS");
		jpanel.add(jbutton1);
		jpanel.add(jbutton2);
		add(jpanel,BorderLayout.EAST);
		
		add(label);
		
		jbutton1.addActionListener(this);
		jbutton2.addActionListener(this);
		
		setSize(600,600);
		setVisible(true);
		setTitle("CASH WITHDRAWL");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==jbutton1)
		{
			new Current();
			dispose();
		}
		else if(ae.getSource()==jbutton2)
		{
			new Saving();
			dispose();
		}
	}
	public static void main(String ar[])
	{
		new Withdrawl();
	}
}