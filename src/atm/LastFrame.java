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

class LastFrame extends JFrame implements ActionListener
{
	JButton jbutton,jbutton1;
	LastFrame()
	{
		setLayout(new BorderLayout());
		
		JPanel panel=new JPanel();
		JLabel label = new JLabel(new ImageIcon("atm1.jpg"));
		label.setBounds(0,0,600,600);
		
		JLabel jlabel = new JLabel("Thanks for you kind visit");
		panel.add(jlabel);
		jlabel.setFont(new Font("Calibri Black",Font.BOLD,30));
		add(panel,BorderLayout.NORTH);
		
		JPanel jpanel = new JPanel();
		JLabel jlabel1=new JLabel("Do you wany another Transaction");
		jpanel.add(jlabel1);
		jlabel1.setFont(new Font("Calibri Black",Font.BOLD,30));
		add(jpanel,BorderLayout.SOUTH);
		
		JPanel jpanel2= new JPanel();
		jbutton = new JButton("YES");
		jbutton1 = new JButton("NO");
		jpanel2.add(jbutton);
		jpanel2.add(jbutton1);
		add(jpanel2,BorderLayout.EAST);
		
		add(label);
		
		jbutton.addActionListener(this);
		jbutton1.addActionListener(this);
		
		setSize(600,600);
		setVisible(true);
		setTitle("LAST FRAME");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==jbutton)
		{
			new CardNumber();
			dispose();
		}
		else if(ae.getSource()==jbutton1)
		{
			dispose();
		}
	}
	public static void main(String ar[])
	{
		new LastFrame();
	}
}