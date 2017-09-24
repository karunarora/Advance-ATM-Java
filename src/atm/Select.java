/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;

import java.awt.BorderLayout;
import java.awt.Font;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Gourav
 */
public class Select extends JFrame implements ActionListener
{
    JLabel j1,j2;
    JButton b1,b2;
    
    Select()
    {
        setContentPane(new JLabel(new ImageIcon("atm1.jpg")));
        setVisible(true);
        //setExtendedState(MAXIMIZED_BOTH);                       //For Maximised JFrame Window.
        //setLayout(null);
        setSize(500,500);
        //setLocationRelativeTo(null);

        //JLabel j1,j2;
        j1=new JLabel("Select Your choice");
        j1.setBounds(100, 10, 300 , 100);
        j1.setFont(new Font("Courier New", Font.BOLD, 20));
        add(j1);
        
        
        b1=new JButton("Use Adhar Card");
        b1.setBounds(100, 220, 200, 50);
        add(b1);
        b2=new JButton("Use Card");
        b2.setBounds(100,330, 200, 50);
        add(b2);
        setResizable(false);
        b2.addActionListener(this);
        b1.addActionListener(this);
        
        //add(BorderLayout.SOUTH);
        
    }
           

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if(e.getSource()==b2)
        {
           
            new CardNumber();
         
            dispose();
        }
        if(e.getSource()==b1)
        {
            new Adhaar();
            dispose();
        }
    }
    public static void main(String []args)
    {
        Select obj=new Select();
    }
    
}
