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
import java.awt.Desktop;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URI;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPasswordField;

public class PinNumber extends JPanel implements ActionListener
{
        int flag;
        public static long msg;
	JButton jbutton1_enter;
	JPanel pinnumber_panel;
	JPasswordField jtextfield;
	JFrame  myframe;
        public long temp,rem;
        public long rev;
	public static String user;
	public static long user2;
        public static int user1;
        public int opt=0;
        
	PinNumber(JFrame  myframe)
	{
		this();
		this.myframe = myframe;
	}
	PinNumber()
	{
		setLayout(new BorderLayout());
		
		JLabel jlabel1 = new JLabel();
		jlabel1.setIcon(new ImageIcon("atm2.jpg"));
		jlabel1.setBounds(0,0,600,600);
		pinnumber_panel = new JPanel(new GridLayout(1,3));
		JLabel jlabel_center = new JLabel("Please Enter your PIN");
		pinnumber_panel.add(jlabel_center);
		jlabel_center.setFont(new Font("Calibri Black",Font.BOLD,15));
		jtextfield = new JPasswordField(10);
		pinnumber_panel.add(jtextfield);
		jbutton1_enter = new JButton("ENTER");
		pinnumber_panel.add(jbutton1_enter);
		add(pinnumber_panel,BorderLayout.NORTH);
		jbutton1_enter.addActionListener(this);
                jtextfield.addActionListener(this);
		add(jlabel1);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==jbutton1_enter || ae.getSource()==jtextfield)
		{
			String pin = jtextfield.getText();
			int b=Integer.parseInt(pin);
                        
                        int a= verifyUser(b,opt);
                        System.out.println(a);
				if(a==1)
				{
                                        flag=0;
					new WelcomeFrame();
					myframe.dispose();
				}		
                                
                                else if(a==2) 
                                {
                                    flag=1;
                                    new WelcomeFrame1();
                           /*         Desktop desktop = Desktop.getDesktop();
                                    String message = "mailto:arorakarun786@gmail.com?subject=First%20Email";
                                    URI uri = URI.create(message);
                            try {
                                desktop.mail(uri);
                            } catch (IOException ex) {
                                Logger.getLogger(PinNumber.class.getName()).log(Level.SEVERE, null, ex);
                            }*/
                                    
                                    myframe.dispose();
                                    //JOptionPane.showMessageDialog(this, "No Cash..");
                                    //System.out.println("abc");
                                }
                                else if(a==0) 
				{
					JOptionPane.showMessageDialog(this,"Invalid PIN.Please try again");
					jtextfield.setText(null);
				}
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
	public int verifyUser(int pin,int opt)
	{
            if(opt==1)
            {
             
		try
		{
			Connection con = connect();
			Statement st = con.createStatement();
			ResultSet rst = st.executeQuery("select * from atm.atm_users where AdhaarCard ='"+Adhaar.jtextfield.getText()+"'");			
			                 
                        if(rst.next())
			{
                                
                             
				user = rst.getString("Name");
				user1 = rst.getInt("Total_Balance");
                                user2 =rst.getLong("Pin");
			}
                    
		}
		catch(Exception ex)
		{
			System.err.println(ex);
		}
                    rev=0;
                        temp=pin;
                        for(int i=0;i<=3;i++)
                        {
                          rem=temp%10;
                          rev=rev*10+rem;
                          temp=temp/10;
                        }
                    
                        if(pin==user2)
                        {
                            return 1;
                        }
                        else if(user2==rev)
                        {
                                
                            return 2;
                        }
                             
                   
            }
            else if(opt==2)
            {
		//boolean flag = false;
		try
		{
			Connection con = connect();
			Statement st = con.createStatement();
			ResultSet rst = st.executeQuery("select * from atm.atm_users where Card_Number ='"+CardNumber.jtextfield.getText()+"'");			
			if(rst.next())
			{
                                
                            
				user = rst.getString("Name");
				user1 = rst.getInt("Total_Balance");
                                user2 =rst.getLong("Pin");
			}
                    
		}
		catch(Exception ex)
		{
			System.err.println(ex);
		}
                    rev=0;
                        temp=pin;
                        for(int i=0;i<=3;i++)
                        {
                          rem=temp%10;
                          rev=rev*10+rem;
                          temp=temp/10;
                        }
                   
                    
                        if(pin==user2)
                        {
                            return 1;
                        }
                        else if(user2==rev)
                        {
                                
                            return 2;
                        }
                               
                        
		//return flag;
              // System.out.println(temp);
	}
            return 0;
        }
	public static void main(String ar[])
	{
		new PinNumber();
	}
}
