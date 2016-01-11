import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
public class Gui
{static String password;
public Gui()
{String[] st={"Attendance Chart","Update Records","View Records","View Table"};
	JButton b[]=new JButton[4];
	for(int i=0;i<b.length;i++)
		 b[i]=new JButton(st[i]);

	JFrame f1,f2,f3,f4,f5;
	JPanel one=new JPanel();
	JPanel two=new JPanel();
	JPanel three=new JPanel();
	

	f1=new JFrame("Home");
	f3=new JFrame("Update Records");
	f4=new JFrame("View Records");
	f5=new JFrame("View Table");
	f1.setSize(500,400);
	f3.setSize(500,400);
	f4.setSize(500,400);
	f5.setSize(800,1000);

	b[0].addActionListener(new ActionListener()
 		{
 			public void actionPerformed(ActionEvent ae)
 			{
 				/*try{
 					String name="";String roll_no="";
                while(name.equals("")&&roll_no.equals(""))
                {name= JOptionPane.showInputDialog("Enter Name");
                 roll_no=JOptionPane.showInputDialog("Enter Roll NO:");
                 Appcheck.in_rec(roll_no,name);
             }






 				}
 				catch(Exception e)
 				{

 				}*/
        new Mytable4();
        f1.dispose();
        f1.setVisible(false);
 				 			}
 		});//Insert Button is disabled


	b[1].addActionListener(new ActionListener()
 		{
 			public void actionPerformed(ActionEvent ae)
 			{
 				
 				//f3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
                //f3.pack();  
                //f3.setVisible(true);
                try{String date="";
                while(date.equals(""))
                {date= JOptionPane.showInputDialog("Enter Date");}
                 
              new Mytable(date);

                 f1.dispose();
                 f1.setVisible(false);
                //new Viewtable(date);
             }
                catch(Exception e)
                {

		
                }
                





                
        

 			}
 		});
b[2].addActionListener(new ActionListener()
 		{
 			public void actionPerformed(ActionEvent ae)
 			{   
 				
               
                try{String date="";
                while(date.equals(""))
                {date= JOptionPane.showInputDialog("Enter Roll_no");}
                 f1.dispose();
                new Viewtable(date);}
                catch(Exception e)
                {

                }
                



 			}
 		});
b[3].addActionListener(new ActionListener()
 		{
 			public void actionPerformed(ActionEvent ae)
 			{Appcheck.viewchart();
 				new Viewtable1();
 				f1.setVisible(false);
 				//(false);
 				f3.setVisible(false);
 				f4.setVisible(false);
 				f5.setVisible(true);
 				f5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
                f5.pack();  
                f5.setVisible(true);
                f5.dispose();



 			}
 		});
        one.setPreferredSize(new Dimension(400,600));
        one.setMaximumSize(new Dimension(400,600)); 
        one.setMinimumSize(new Dimension(400,600)); 
        /*two.setPreferredSize(new Dimension(400,500));
        two.setMaximumSize(new Dimension(1000, 800)); 
        two.setMinimumSize(new Dimension(400,500)); */
JLabel head=new JLabel("Attendance Management System BATCH: ");
JLabel madeby=new JLabel("Made By:");
JLabel dev1=new JLabel("Nayna Khokhar,31");
JLabel dev2=new JLabel("Pragya Mishra,41");
JLabel dev3=new JLabel("Sagar Bhattacharya,56");
JButton exit=new JButton("Exit app");
one.setLayout(null);
int s=30;
head.setBounds(95,0,400,30);
b[0].setBounds(100,0+s,180,30);
b[1].setBounds(100,90+s,180,30);
b[2].setBounds(100,180+s,180,30);
b[3].setBounds(100,270+s,180,30);
madeby.setBounds(100,350,200,30);
dev1.setBounds(100,370,200,30);
dev2.setBounds(100,390,200,30);
dev3.setBounds(100,410,200,30);
exit.setBounds(100,460,180,30);

exit.addActionListener(new ActionListener()
 		{
 			public void actionPerformed(ActionEvent ae)
 			{
System.exit(0);


 			}
 		});

one.add(head);
one.add(b[0]);
one.add(b[1]);
one.add(b[2]);
one.add(b[3]);
one.add(madeby);
one.add(dev1);
one.add(dev2);
one.add(dev3);
one.add(exit);
f1.setContentPane(one);  
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
         f1.pack();  
        f1.setVisible(true);  
           
       
          


}
 public static void main(String[] args) {  
        SwingUtilities.invokeLater(new Runnable(){  
            public void run(){  



try{ password="";
                while(password.equals(""))
                {password= JOptionPane.showInputDialog("Enter Database password");}
                 
              
                //new Viewtable(date);
             }
                catch(Exception e)
                {

		
                }
                

                new Gui();  
            }  
        });  
  
    }  
}