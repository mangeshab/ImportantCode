import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Mobileimp implements MobileI{
	static Statement smt;
	static Connection con;
	Mobile m=new Mobile();
	Scanner sc=new Scanner(System.in);
	public Statement connect()
	{try{
		Class.forName("com.mysql.jdbc.Driver");
		
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
		
		smt=con.createStatement();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
		return smt;
	}
	@Override
	public void create() {
		smt=connect();
		try
		{
			
			String query="create table Mobile(mfgyr int,name varchar(15),price double)";
			
			smt.execute(query);
			System.out.println("Success");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
	}

	@Override
	public void insert() {
		try {
			smt=connect();
			
			System.out.println("Enter mfgyr year");
			int mfy=sc.nextInt();
			m.setMfgyr(mfy);
			
			System.out.println("Enter name");
			String nm=sc.next();
			m.setName(nm);
			System.out.println("Enter price");
			double pr=sc.nextDouble();
			m.setPrice(pr);
			String query="insert into mobile(mfgyr,name,price)values("+mfy+",'"+nm+"',"+pr+")";
			
			smt.execute(query);
			System.out.println("Successful");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
	}

	@Override
	public void update() {
		smt=connect();
		try
		{
		System.out.println("Enter 1 to update price");
		System.out.println("Enter 2 to update mfgyr");
		int ch=sc.nextInt();
		if(ch==1)
		{
			System.out.println("Enter name");
			String nm=sc.next();
			System.out.println("Enter price to update");
			double pr=sc.nextDouble();
			String query="update mobile set price="+pr+" where name='"+nm+"'";
			
			smt.execute(query);
			System.out.println("price updated");
		}
		else if(ch==2)
		{
			System.out.println("Enter name");
			String nm=sc.next();
			System.out.println("Enter mfgyr to update");
			int mgy=sc.nextInt();
		String query="update mobile set mfgyr="+mgy+" where name='"+nm+"'";
		smt.execute(query);
		System.out.println("mfgyr updated");
		}
	}
	catch(SQLException e)
		{
		e.printStackTrace();
		}
	}

	@Override
	public void delete() {
		smt=connect();
		
		try
		{
			System.out.println("Enter name to delete");
			String nm=sc.next();
			
			String query="delete from mobile where name='"+nm+"'";
			
			smt.execute(query);
			
			System.out.println("Deleted");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
	}
	public void show()
	{
		smt=connect();
		try
		{
			String query="select * from mobile";
			
			ResultSet rs=smt.executeQuery(query);
			
			while(rs.next())
			{
				System.out.println("Manufacturinrg Year is : "+rs.getInt(1));
				System.out.println("Name is                : "+rs.getString(2));
				System.out.println("Price is               : "+rs.getDouble(3));
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
}
