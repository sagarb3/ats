import java.io.*;
import java.sql.*;
import java.util.*;
public class Appcheck
{
	static String name,roll_no,date,status;static int p,tot;
	static String vname[],vroll[],names[],roll_nos[],dates[],statuss[],tname[],troll[];static int ps[],tots[];
    static String t_attd,p_attd,per_attd;
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
	public static void in_rec(String roll_no,String name)
	{ 
		try
		{
		Connection con=getConnection();

		PreparedStatement ps=con.prepareStatement("INSERT INTO srecords(roll_no,name) VALUES (?,?)");
                 ps.setString(1,roll_no);
                  ps.setString(2,name);
                  ps.executeUpdate();}
        catch(Exception e)
        {
        	System.out.print("Problem updating causes may be:\n1.Roll_no already exits\n2.Database not connected");
        }
    }

public static void up_rec(String date)
{Scanner sc=new Scanner(System.in);
	names=new String[row_count("srecords")];
	roll_nos=new String[row_count("srecords")];
	
	int j=0;
	try
	{Connection con=getConnection();
	Statement st = con.createStatement();

	ResultSet rs=st.executeQuery("select * from srecords");
		
	while(rs.next())
	{
		String name=rs.getString(2);
		String roll_no=rs.getString(1);               
        status=String.valueOf(Mytable.status[j]);
        //statuss[j]=status;
        PreparedStatement k=con.prepareStatement("insert into records(roll_no,name,date,status) values(?,?,?,?)");
        k.setString(1,roll_no);
        k.setString(2,name);
        k.setString(3,date);
        k.setString(4,status);
        k.executeUpdate();
        //System.out.print("Updating status"+status);
        j++;
	}
}
catch(Exception e)
{
	System.out.print("Upgradation not possible");
}

}

public static void view_rec(String roll_no)
{dates=new String[row_countr()];
statuss=new String[row_countr()];
tname=new String[row_countr()];
troll=new String[row_countr()];
	p=0;t_attd="";p_attd="";per_attd="";
	//System.out.print("date distint="+row_countr()+"\n");
try{
Connection con=getConnection();
Statement st = con.createStatement();
ResultSet rs=st.executeQuery("select * from srecords where roll_no='"+roll_no+"'");

if(rs.next()==true)
{
//System.out.print("name:\t"+rs.getString(2)+"\n");
ResultSet rm=st.executeQuery("select * from records where name='"+rs.getString(2)+"'");
ResultSetMetaData rsmd = rm.getMetaData();
tot=0;int j=0;
while(rm.next())
{tot++;
tname[j]=rm.getString("name");
troll[j]=rm.getString("roll_no");
//System.out.print("date\t"+rm.getString("date")+"\t");
dates[j]=rm.getString("date");
int l=Integer.parseInt(rm.getString("status"));
if(l==1)
{//System.out.print("Present");
p++;
statuss[j]="Present";
//System.out.print("\n");
}
else
{//System.out.print("Abesent");
statuss[j]="abesent";}
//System.out.print("\n");
j++;}
//System.out.print("attendance="+p+" out of "+tot+"\n");
t_attd=String.valueOf(tot);
p_attd=String.valueOf(p);
if(tot>0)
{float per=((float)(p)/tot)*100;per_attd=String.valueOf(per);
//System.out.print("\npercentage attendance="+per+"%\n");
}
p=0;
tot=0;
}

else
{//System.out.print("no such record exists");
}
}
catch(Exception e)
{
//System.out.print("trouble generating view");
}
}

public static void viewchart()
{
	try{
		vname=new String[row_count("")];
		vroll=new String[row_count("")];
		

 Connection con =getConnection();
  Statement st = con.createStatement();
 ResultSet rs=st.executeQuery("select * from srecords ORDER BY name ASC");
 //System.out.print("in viewchart\n");
int j=0;
//System.out.println("");
//System.out.print("roll no\t"+"name\n");
 while(rs.next())
 {//System.out.print(rs.getString(1)+"\t");
vname[j]=rs.getString(2);


 //System.out.print(rs.getString(2)+"\n");
 vroll[j]=rs.getString(1);
j++; 
 
 }
}
catch(Exception e)
{

}
}

public static int row_count(String x)
{int count=0;
	try
	{Connection con=getConnection();
	Statement st = con.createStatement();
    ResultSet rs=st.executeQuery("select * from srecords");
    rs = st.executeQuery("SELECT COUNT(*) FROM srecords");
    rs.next();
    count = rs.getInt(1);
    }
catch(Exception e)
{
	
}
return count;
}
	
	public static boolean duplicate(String date)
	{int count=0;boolean bool=true;
try
{Connection con=getConnection();
Statement st = con.createStatement();
ResultSet rs=st.executeQuery("select * from records where date='"+date+"'");
while(rs.next())
{
	count++;
	if(count>0)
		{bool=false;break;}
}

	
}
catch(Exception e)
{//System.out.print("dds");
}
return bool;
}
public static void update_record(String date)
{Scanner sc=new Scanner(System.in);
	//System.out.println("re-updating records");
try
{
	Connection con=getConnection();
	Statement st = con.createStatement();

	ResultSet rs=st.executeQuery("select * from srecords");
	int j=0;
	while(rs.next())
	{
		String name=rs.getString(2);
        String roll_no=rs.getString(1);
        status=String.valueOf(Mytable.status[j]);;
        Statement sp=con.createStatement();
        sp.executeUpdate("update records set status='"+status+"' where date='"+date+"'and name='"+name+"'");
       j++;
	}
}


catch(Exception e)
{

}

}

public static int row_countr()
{int count=0;
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



	

}


	
	
