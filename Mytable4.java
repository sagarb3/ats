import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.*;
class Mytable4 extends JFrame
{static Object o1[][];
    //o1[][]=new Object[rowc()][1];
	static JTable jt;
    //static int status[]=new int[Appcheck.row_count("")];
	
public static void putsize()
{
    o1=new Object[rowc()][1];
}
	public static int rowc()
    {
//o1=new Object[rowc()][1];
    int count=0;
try
    {
        Connection con=getConnection();
        Statement st = con.createStatement();
        ResultSet rs=st.executeQuery("select DISTINCT date from records");
        while(rs.next())
            count++;

       






    }
    catch(Exception e)
    {
        System.out.print("in trouble");
    }
    return count;



    }













    public static Connection getConnection()
	{Connection con=null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver"); 
           con = DriverManager.getConnection("jdbc:mysql://localhost:3306/collegeproject","root",Gui.password);
		   
		}
		catch(Exception e)
		{
			System.out.print("can't establish connection");
			System.exit(0);
			
		}
	return con;
	}
public static void query()
{
try{
	Connection con=getConnection();
	Statement st = con.createStatement();
	ResultSet rs=st.executeQuery("select DISTINCT date from records");
	int i=0;
	//boolean status[]=new boolean[60];
while(rs.next())
{//status[i]=false;
	  //o1[i][0]=rs.getString(2);
    o1[i][0]=rs.getString(1);
    //o1[i][2]=rs.getString(4);
    /*if(rs.getString(5).equals("1"))
    {o1[i][3]="PRESENT";}
else
{
    o1[i][3]="ABSENT";
}
*/
  
  
 i++;
}
}
catch(Exception e)
{

}
}

public Mytable4()
{
super("attendance list dates");
String date="";
putsize();

 query();
 //String date="";

 JTable table;
String head[]={"Date"};

DefaultTableModel model = new DefaultTableModel(o1, head);
      table = new JTable(model) {

            private static final long serialVersionUID = 1L;

           
            public Class getColumnClass(int column) {
                switch (column) {
                    default:
                        return String.class;
                    /*case 1:
                        return String.class;
                    case 2:
                        return String.class;
                    
                    default:
                        return String.class;*/
                }
            }
        };

        table.setPreferredScrollableViewportSize(table.getPreferredSize());
        
JButton b1,b2;
	     b1=new JButton("Refresh");
	     b2=new JButton("Home");



JFrame frame = new JFrame();

JPanel topPanel=new JPanel();

topPanel.setLayout(null);

getContentPane().add(topPanel);

JScrollPane scrollPane=new JScrollPane(table);

scrollPane.setSize(1000,650);
scrollPane.setBounds(0,0,1000,650);
JScrollPane scrollPane1=new JScrollPane(b1);
JScrollPane scrollPanel1=new JScrollPane(b2);
//JScrollPane scrollPane3=new JScrollPane(new JLabel("Total Students="+mtotal+" "+"Present= "+mpresent));
scrollPane1.setSize(90,30);
scrollPanel1.setSize(90,30);
scrollPane1.setBounds(450,680,150,30);
scrollPanel1.setBounds(600,680,150,30);
//scrollPane3.setBounds(0,680,300,30);

topPanel.add(scrollPane);       

topPanel.add(scrollPane1);
topPanel.add(scrollPanel1);
//topPanel.add(scrollPane3);
setSize(1000,800);
setVisible(true);
try{
while(date.equals(""))
                {
                    date= JOptionPane.showInputDialog("Enter Date");
                    if(!(date.equals("")))
                    {new Mytable3(date);}
                }
   }
catch(Exception e)
{

}
//new Mytable3(date);



b1.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                
setVisible(false);
frame.dispose();
rowc();
query();
new Mytable4();
               


            }
        });

b2.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                
setVisible(false);
frame.dispose();              
new Gui();



       





            }
        });





}

public static void main(String[] args)
{//query();
	//disp();
//new Mytable();
    new Mytable4();
}
}