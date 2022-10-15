	import java.sql.Connection;
	import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.util.Scanner;
public class MobileimpPrepared  implements MobileI
{
		Mobile m=new Mobile();
		Scanner sc=new Scanner(System.in);
		
		@Override
		public void create() {
			
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
			
				String query="create table Mobile1(mfgyr int,name varchar(15),price double)";
				PreparedStatement ps=con.prepareStatement(query);
				ps.execute();
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
				String query="insert into mobile1(mfgyr,name,price)values(?,?,?)";
				
				PreparedStatement ps=con.prepareStatement(query);
				ps.setInt(1, mfy);
				ps.setString(2,nm);
				ps.setDouble(3,pr);
				ps.execute();
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
				String query="update mobile1 set price=? where name=?";
				
				PreparedStatement ps=con.prepareStatement(query);
				ps.setDouble(1,pr);
				ps.setString(2,nm);
				ps.execute();
				
				System.out.println("price updated");
			}
			else if(ch==2)
			{
				System.out.println("Enter name");
				String nm=sc.next();
				System.out.println("Enter mfgyr to update");
				int mgy=sc.nextInt();
			String query="update mobile1 set mfgyr=? where name=?";
			PreparedStatement ps =con.prepareStatement(query);
			ps.setInt(1, mgy);
			ps.setString(2,nm);
			
			ps.execute();
			System.out.println("mfgyr updated");
			}
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
				String query="delete from mobile1 where name=?";
				PreparedStatement ps=con.prepareStatement(query);
				ps.setString(1,nm);
				ps.execute();
				
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
			

				String query="select * from mobile1";
				PreparedStatement ps=con.prepareStatement(query);
				
				ResultSet rs=ps.executeQuery(query);
				
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
