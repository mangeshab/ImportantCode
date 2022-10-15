package com.braindata.bankmanagement.serviceImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.braindata.bankmanagement.model.Account;
import com.braindata.bankmanagement.service.RBI;

public class SBI implements RBI {

	Scanner sc=new Scanner(System.in);
	Account a=new Account();
	public void create()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bms prepared","root","root");
			
		String query="Create table Bank(accNo bigint primary key,name varchar(30),mobno varchar(10),adharNo varchar(12),gender varchar(7),age int,balance double)";
		
		System.out.println("Table created Successfully....!!!");
		PreparedStatement smt=con.prepareStatement(query);
		
		smt.executeUpdate();
		
		
	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void createAccount() {
	
		try
		{
		Class.forName("com.mysql.jdbc.Driver");
			
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bms prepared","root","root");
			
		System.out.println("Enter account number");
		long ac=sc.nextLong();
		a.setAccNo(ac);
		System.out.println("Enter acc holder name");
		String nm=sc.next();
		a.setName(nm);
		System.out.println("Enter mob no");
		String mb=sc.next();
		a.setMobNo(mb);
		System.out.println("Enter adhar no");
		String ad=sc.next();
		a.setAdharNo(ad);
		System.out.println("Enter gender");
		String g=sc.next();
		a.setGender(g);
		System.out.println("Enter age");
		int ag=sc.nextInt();
		a.setAge(ag);
		System.out.println("Enter balance");
		double bal=sc.nextDouble();
		a.setBalance(bal);
		
		String query="insert into bank(accNo,name,mobno,adharNo,gender,age,balance)values(?,?,?,?,?,?,?)";
		
		PreparedStatement ps=con.prepareStatement(query);
		ps.setLong(1,ac);
		ps.setString(2,nm);
		ps.setString(3,mb);
		ps.setString(4,ad);
		ps.setString(5,g);
		ps.setInt(6,ag);
		ps.setDouble(7,bal);
		ps.execute();
		System.out.println("Account created Successfully...!!");
	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void displayAllDetails() {
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bms prepared","root","root");
			
			String query="select * from bank where accNo=?";
			
			System.out.println("Enter acc no to display details");
			long ac=sc.nextLong();
			a.setAccNo(ac);
			
			PreparedStatement ps=con.prepareStatement(query);
			ps.setLong(1,ac);
		    	ResultSet rs=ps.executeQuery();
		    	while(rs.next())
		    	{
				System.out.println("***************");
				System.out.println(" ");
				System.out.println("Account no     : "+rs.getLong(1));
				System.out.println("Account holder : "+rs.getString(2));
				System.out.println("Mobile no      : "+rs.getString(3));
				System.out.println("Adhar no       : "+rs.getString(4));
				System.out.println("Gender         : "+rs.getString(5));
				System.out.println("Age            : "+rs.getInt(6));
				System.out.println("Balance        : "+rs.getDouble(7));
				System.out.println(" ");
				System.out.println("***************");
		    	}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	@Override
	public void depositeMoney() {
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bms prepared","root","root");
			
			
			System.out.println("Enter acc no to deposit");
			long ac=sc.nextLong();
			a.setAccNo(ac);
			System.out.println("Enter amount to deposit");
			double bl=sc.nextDouble();
			a.setBalance(bl);
		
			String query="update bank set balance=?+balance where accNo=?";
			
			PreparedStatement ps=con.prepareStatement(query);
			ps.setLong(2,ac);
			ps.setDouble(1,bl);
			ps.execute();
			
			System.out.println("Deposit Successfull...!!");	
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void withdrawal() {
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bms prepared","root","root");
			System.out.println("Enter acc no to withdrawal");
			long ac=sc.nextLong();
			System.out.println("Enter amount to withdrawal");
			double bl=sc.nextDouble();
			
			String query="update bank set balance=balance-? where accNo=?";
					
			PreparedStatement ps=con.prepareStatement(query);
				ps.setLong(2, ac);
				ps.setDouble(1, bl);
				ps.executeUpdate();
				
			System.out.println("Withdrawal successfull...!!");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void balanceCheck() {
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bms prepared","root","root");
			System.out.println("Enter acc no to check balance");
			long ac=sc.nextLong();
			a.setAccNo(ac);
			String query="select * from bank where accNo=? ";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setLong(1, ac);
			ps.execute();
			
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				System.out.println("Balance in account : "+rs.getDouble(7));
			}
			
	}
		catch(Exception e)
		{
			e.printStackTrace();
		}

}
	public void update()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bms prepared","root","root");
			
		System.out.println("Enter 1 to update name");
		System.out.println("Enter 2 to update mobile number");
		System.out.println("Enter 3 to update Age");
		int ch=sc.nextInt();
		if(ch==1)
		{
			System.out.println("Enter acc no");
			long ac=sc.nextLong();
			
			System.out.println("Enter name to update");
			String nm=sc.next();
		
			String query="update bank set name=? where accNo=?";
			
			PreparedStatement  ps=con.prepareStatement(query);
			ps.setString(1,nm);
		    ps.setLong(2, ac);
		    ps.executeUpdate();
		    
			System.out.println("Name updated successfully..!!");
		}
		else if(ch==2)
		{
			System.out.println("Enter acc no");
			long ac=sc.nextLong();
			
			System.out.println("Enter mobile no to update");
			String mb=sc.next();
			
			String query="update bank set mobno=? where accNo=?";
			
			PreparedStatement  ps=con.prepareStatement(query);
			ps.setString(1,mb);
		    ps.setLong(2, ac);
		    ps.executeUpdate();
		    
			System.out.println("mobile no updated successfully..!!");
		}
		else if(ch==3)
		{
			System.out.println("Enter acc no");
			long ac=sc.nextLong();
			
			System.out.println("Enter age to update");
			int ag=sc.nextInt();
			
			String query="update bank set age=? where accNo=?";
			
			PreparedStatement  ps=con.prepareStatement(query);
			ps.setInt(1,ag);
		    ps.setLong(2, ac);
		    ps.executeUpdate();
		    
			System.out.println("Age updated successfully..!!");
		}

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void delete()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bms prepared","root","root");
			System.out.println("Enter acc no to delete");
			long ac=sc.nextLong();
			
			String query="delete from bank where accNo=?";
			
			PreparedStatement ps=con.prepareStatement(query);
			ps.setLong(1,ac);
			ps.execute();
		
			
			System.out.println("Information deleted");
	}
		catch(Exception e)
		{
			e.printStackTrace();
		}
}
}