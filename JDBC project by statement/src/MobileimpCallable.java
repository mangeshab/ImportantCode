import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.Scanner;

public class MobileimpCallable implements MobileI{
	Mobile m=new Mobile();
	Scanner sc=new Scanner(System.in);
	
	@Override
	public void create() {
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
		
			CallableStatement cs=con.prepareCall("{call createTablemobile(?,?,?)}");
			cs.setInt(1,1);
			cs.setString(2,"ab");
			cs.setDouble(3,4.0);
			
			
			cs.executeUpdate();
			System.out.println("Success");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

	@Override
	public void insert() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
		
			System.out.println("Enter mfgyr year");
			int mfy=sc.nextInt();
			m.setMfgyr(mfy);
			
			System.out.println("Enter name");
			String nm=sc.next();
			m.setName(nm);
			System.out.println("Enter price");
			double pr=sc.nextDouble();
			m.setPrice(pr);
			CallableStatement cs=con.prepareCall("{call insertmobile2(?,?,?)}");
			cs.setInt(1,mfy);
			cs.setString(2, nm);
			cs.setDouble(3, pr);
			cs.executeUpdate();
			System.out.println("Successful");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

	@Override
	public void update() {
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
	
		System.out.println("Enter 1 to update price");
		System.out.println("Enter 2 to update mfgyr");
		int ch=sc.nextInt();
		if(ch==1)
		{
			System.out.println("Enter name");
			String nm=sc.next();
			m.setName(nm);
			System.out.println("Enter price to update");
			double pr=sc.nextDouble();
			m.setPrice(pr);
			CallableStatement cs=con.prepareCall("{call updatemobile2(?,?)}");
			cs.setDouble(1,pr);
			cs.setString(2, nm);
			cs.executeUpdate();
			
			
			System.out.println("price updated");
		}
		
		  else if(ch==2)
		  {
			  System.out.println("Enter name"); 
			  String nm=sc.next();
			  System.out.println("Enter mfgyr to update");
			  int mgy=sc.nextInt();
			  
			CallableStatement cs=con.prepareCall("{call updatemobile2(?,?)}");
			
			cs.setInt(1, mgy);
			
			cs.setString(2,nm);
			cs.executeUpdate();
		  System.out.println("mfgyr updated"); }
		 
	}
	catch(Exception e)
		{
		e.printStackTrace();
		}
	}

	@Override
	public void delete() {
		
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
		

			System.out.println("Enter name to delete");
			String nm=sc.next();
			m.setName(nm);
			CallableStatement cs=con.prepareCall("{call deletemobile2(?)}");
			cs.setString(1, nm);
			cs.executeUpdate();
			
			System.out.println("Deleted");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	public void show()
	{
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
		

			CallableStatement cs=con.prepareCall("{call showmobile2(?,?,?)}");
			cs.registerOutParameter(1,Types.INTEGER);
			cs.registerOutParameter(2,Types.VARCHAR);
			cs.registerOutParameter(3,Types.DOUBLE);
			ResultSet rs=cs.executeQuery();
			while(rs.next())
			{
				System.out.println("Manufacturinrg Year is : "+rs.getInt(1));
				System.out.println("Name is                : "+rs.getString(2));
				System.out.println("Price is               : "+rs.getDouble(3));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
