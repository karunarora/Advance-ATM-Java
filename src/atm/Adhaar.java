
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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

class Adhaar extends JFrame implements ActionListener, MouseListener 
{
	public static JTextField jtextfield;
	JButton jbutton_one,jbutton_two,jbutton_three,jbutton_four,jbutton_five,jbutton_six,jbutton_seven,jbutton_eight,jbutton_nine,jbutton_zero,jbutton_clear,jbutton_enter;
	JPanel cardnumber_panel;
	JPanel cardnumber_panel1;
	JLabel jlabel;
	
	Adhaar()
	{
		setLayout(new BorderLayout());
		jlabel = new JLabel();
		jlabel.setIcon(new ImageIcon("atm3.jpg"));
		
		cardnumber_panel = new JPanel(new FlowLayout());
                
		JLabel jlabel_center = new JLabel("Please Enter your Adhaar Card no");
                
               jlabel_center.setBounds(10, 20, 500, 500);
		cardnumber_panel.add(jlabel_center);
               
		jlabel_center.setFont(new Font("Calibri Black",Font.BOLD,15));
		jtextfield = new JTextField(30);
		cardnumber_panel.add(jtextfield);
		add(cardnumber_panel,BorderLayout.NORTH);
                
		 
		cardnumber_panel1 = new JPanel(new GridLayout(4,4,10,10));
		jbutton_one = new JButton( "1" );
		jbutton_two = new JButton( "2" );
		jbutton_three = new JButton( "3" );
		jbutton_four = new JButton( "4" );
		jbutton_five = new JButton( "5" );
		jbutton_six = new JButton( "6" );
		jbutton_seven = new JButton( "7" );
		jbutton_eight = new JButton( "8" );
		jbutton_nine = new JButton( "9" );
		jbutton_zero = new JButton( "0" );
		jbutton_enter = new JButton( "ENTER" );
		jbutton_clear = new JButton( "CLEAR" );
		
		cardnumber_panel1.add(jbutton_nine);
		cardnumber_panel1.add(jbutton_eight);
		cardnumber_panel1.add(jbutton_seven);
		cardnumber_panel1.add(jbutton_six);
		cardnumber_panel1.add(jbutton_five);
		cardnumber_panel1.add(jbutton_four);
		cardnumber_panel1.add(jbutton_three);
		cardnumber_panel1.add(jbutton_two);
		cardnumber_panel1.add(jbutton_one);
		cardnumber_panel1.add(jbutton_clear);
		cardnumber_panel1.add(jbutton_zero);
		cardnumber_panel1.add(jbutton_enter);
		
		add(cardnumber_panel1,BorderLayout.EAST);
		jtextfield.addActionListener(this);
		jbutton_one.addActionListener(this);
		jbutton_two.addActionListener(this);
		jbutton_three.addActionListener(this);
		jbutton_four.addActionListener(this);
		jbutton_five.addActionListener(this);
		jbutton_six.addActionListener(this);
		jbutton_seven.addActionListener(this);
		jbutton_eight.addActionListener(this);
		jbutton_nine.addActionListener(this);
		jbutton_zero.addActionListener(this);
		jbutton_clear.addActionListener(this);
		jbutton_enter.addActionListener(this);

		add(jlabel);
		setSize(600,600);
		setTitle("CardNumber");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(true);
	}
	public static String cardvalue;
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==jbutton_one)
		{
			jtextfield.setText(jtextfield.getText().concat("1"));
		}
		else if(ae.getSource()==jbutton_two)
		{
			jtextfield.setText(jtextfield.getText().concat("2"));
		}
		else if(ae.getSource()==jbutton_three)
		{
			jtextfield.setText(jtextfield.getText().concat("3"));
		}
		else if(ae.getSource()==jbutton_four)
		{
			jtextfield.setText(jtextfield.getText().concat("4"));
		}
		else if(ae.getSource()==jbutton_five)
		{
			jtextfield.setText(jtextfield.getText().concat("5"));
		}
		else if(ae.getSource()==jbutton_six)
		{
			jtextfield.setText(jtextfield.getText().concat("6"));
		}
		else if(ae.getSource()==jbutton_seven)
		{
			jtextfield.setText(jtextfield.getText().concat("7"));
		}
		else if(ae.getSource()==jbutton_eight)
		{
			jtextfield.setText(jtextfield.getText().concat("8"));
		}
		else if(ae.getSource()==jbutton_nine)
		{
			jtextfield.setText(jtextfield.getText().concat("9"));
		}
		else if(ae.getSource()==jbutton_zero)
		{
			jtextfield.setText(jtextfield.getText().concat("0"));
		}
		else if(ae.getSource()==jbutton_clear)
		{
			jtextfield.setText(" ");
		}
		else if(ae.getSource()==jbutton_enter || ae.getSource()==jtextfield)
		{
				cardvalue = jtextfield.getText();
				long a=Long.parseLong(cardvalue);
				if(verifyUser(a))
				{
					cardnumber_panel.setVisible(false);
					cardnumber_panel1.setVisible(false);
					jlabel.setVisible(false);
					PinNumber pinnumber = new PinNumber(this);
                                        pinnumber.msg=a;
                                        pinnumber.opt=1;
					add(pinnumber,BorderLayout.NORTH);
				}		
				else
				{
					JOptionPane.showMessageDialog(this,"Invalid AdhaarCard.Please try again");
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
	public boolean verifyUser(long cardvalue)
	{
		boolean flag = false;
		try
		{
			Connection con = connect();
			Statement st = con.createStatement();
			ResultSet rst = st.executeQuery("select * from atm.atm_users where AdhaarCard = '"+cardvalue+"'");			
			if(rst.next())
				flag = true;
		}
		catch(Exception ex)
		{
			System.err.println(ex);
		}
		return flag;
	}
	public static void main(String ar[])
	{
		new Adhaar();
	}

    @Override
    public void mouseClicked(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

