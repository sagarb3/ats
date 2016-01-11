import javax.swing.*;
import javax.swing.event.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
public class Insertgui
{JButton in=new JButton("Insert Record");
	public Insertgui()
	{
		
		in.addActionListener(new ActionListener()
 		{
 			public void actionPerformed(ActionEvent ae)
 			{
 				try{
 					String name="";String roll_no="";
                while(name.equals("")&&roll_no.equals(""))
                {name= JOptionPane.showInputDialog("Enter Name");
                 roll_no=JOptionPane.showInputDialog("Enter Roll NO:");
                 Appcheck.in_rec(roll_no,name);
             }






 				}
 				catch(Exception e)
 				{

 				}
 			}

 				 			
 		});
 		JFrame jf=new JFrame();
 		JPanel one=new JPanel();
 		one.add(in);
 		jf.setContentPane(one);  
 		jf.setSize(200,200);
 		jf.setVisible(true);
	}
	public static void main(String...args)
	{
		new Insertgui();
	}
}