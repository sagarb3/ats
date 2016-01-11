
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class Viewtable1 extends JFrame
{
String[] headings={"Roll NO","Name"};
String[][] items=new String[Appcheck.row_count("")][2];

public Viewtable1()
{super("attendance list");
JTable jt;
	for(int i=0;i<Appcheck.row_count("");i++)
	{
		items[i][0]=Appcheck.vroll[i];
		items[i][1]=Appcheck.vname[i];
	}

    jt = new JTable(items,headings);



JFrame frame = new JFrame();

JPanel topPanel=new JPanel();

JButton b2;
	     
	     b2=new JButton("Home");

topPanel.setLayout(null);

getContentPane().add(topPanel);
JScrollPane scrollPane=new JScrollPane(jt);

scrollPane.setSize(1000,650);
JScrollPane scrollPanel1=new JScrollPane(b2);
scrollPanel1.setSize(90,30);
scrollPanel1.setBounds(600,680,150,30);

topPanel.add(scrollPane);       

topPanel.add(scrollPanel1);
setSize(1000,800);
setVisible(true);
b2.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                

            
setVisible(false);
frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
frame.dispose();  
new Gui();



       





            }
        });

/*add(jp);
setSize(500,500);
setVisible(true);*/
}
/*public static void main(String[] args)
{
    new Viewtable1();
}*/
}