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

class BalanceEnquiry extends JFrame implements ActionListener
{
        JButton cont;
        
	JPanel jpanel;
	BalanceEnquiry()
	{
			setLayout(new BorderLayout());
			
			jpanel = new JPanel();
			JLabel label_image = new JLabel(new ImageIcon("atm1.jpg"));
			label_image.setBounds(0,0,600,600);
			
			jpanel = new JPanel(new FlowLayout());
			JLabel jlabel = new JLabel("Your Account Balance is- " + PinNumber.user1);
			jpanel.add(jlabel);
			jlabel.setFont(new Font("Calibri Black",Font.BOLD,30));
			add(jpanel,BorderLayout.NORTH);
			
			add(label_image);
			
                        cont=new JButton("Continue");
                        add(cont,BorderLayout.SOUTH);
                        cont.addActionListener(this);
                        
			setSize(600,600);
			setVisible(true);
			setTitle("BALANCE DETAILS");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setResizable(false);

	}
	public static void main(String ar[])
	{
		new BalanceEnquiry();
	}

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource()==cont)
        {
            
            new LastFrame();
            dispose();
        }
    }
}