
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class Viewtable extends JFrame
{
String[] headings={"Roll NO","NAME","DATE","Status"};

String[][] items=new String[Appcheck.row_countr()][4];


public Viewtable(String roll_no)
{
super("attendance list");
Appcheck.view_rec(roll_no);
JTable jt;
for(int i=0;i<Appcheck.row_countr();i++)
{
	items[i][0]=Appcheck.troll[i];
	items[i][1]=Appcheck.tname[i];
	items[i][2]=Appcheck.dates[i];
	items[i][3]=Appcheck.statuss[i];
	
}
  




jt = new JTable(items,headings);
JScrollPane jp=new JScrollPane(jt);
JPanel topPanel=new JPanel();
JFrame frame = new JFrame();
JButton b2;
	     
	     b2=new JButton("Home");

topPanel.setLayout(null);

getContentPane().add(topPanel);

JScrollPane scrollPane=new JScrollPane(jt);

scrollPane.setSize(1000,650);

JScrollPane scrollPane1=new JScrollPane(b2);
JScrollPane scrollPane2=new JScrollPane(new JLabel("Name:"+Appcheck.tname[0]+"    "+"Attendance= "+Appcheck.p_attd+" out of" +Appcheck.t_attd+"  "+"Percentage Attendance=      "+Appcheck.per_attd+"%"));
scrollPane1.setSize(90,30);
scrollPane2.setSize(90,190);
scrollPane1.setBounds(600,680,150,30);
scrollPane2.setBounds(10,680,600,30);


topPanel.add(scrollPane);       

topPanel.add(scrollPane1);
topPanel.add(scrollPane2);

setSize(1000,800);
setVisible(true);
b2.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                

            
setVisible(false);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
frame.dispose();  
new Gui();



       





            }
        });






    /*jt = new JTable(items,headings);
JScrollPane jp=new JScrollPane(jt);
add(jp);
setSize(500,500);
setVisible(true);*/
}
/*public static void main(String[] args)
{
    new Viewtable("date");
}*/
}