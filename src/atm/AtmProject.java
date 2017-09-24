/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AtmProject extends JFrame implements ActionListener
{
	JButton jbutton_start;
	JPanel jpanel_north;
	AtmProject()
	{
		setLayout(new BorderLayout());
		
		/*jpanel_north = new JPanel();
		ImageIcon image = new ImageIcon("atm.jpg");
		JButton jlabel_north = new JButton(image);
		jlabel_north.setBounds(10,10,200,250);*/
		
		//jpanel_north.add(jlabel_north);
		//jpanel_north.setBounds(100,100,100,100);
	//	add(jpanel_north);
                    
		jpanel_north = new JPanel();
		ImageIcon image1 = new ImageIcon("atm1.jpg");
		JLabel jlabel_center = new JLabel(image1);
		//jpanel_north.add(jlabel_center);
		jlabel_center.setBounds(0,0,500,500);
		
		jpanel_north = new JPanel(new FlowLayout());
		JLabel jlabel_south = new JLabel("Press Start to Continue");
		jbutton_start = new JButton("START");
		jpanel_north.add(jlabel_south);
		jpanel_north.add(jbutton_start);
		add(jpanel_north,BorderLayout.SOUTH);
		jbutton_start.addActionListener(this);
		
		//add(jlabel_north);
		add(jlabel_center);
		
		setSize(500,500);
		setVisible(true);
		setTitle("ATM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==jbutton_start)
		{
			/*jpanel_north.setVisible(false);
			CardNumber cardnumber = new CardNumber();
			add(cardnumber,BorderLayout.SOUTH);*/
			new Select();
			dispose();
		}
	}
	public static void main(String ar[])
	{
		new AtmProject();
	}
}

