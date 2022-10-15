package com.braindata.bankmanagement.serviceImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;
import java.util.regex.Pattern;

import com.braindata.bankmanagement.model.Account;
import com.braindata.bankmanagement.service.RBI;

public class SBI implements RBI {
	CallableStatement cs;
	double bal;
	Scanner sc=new Scanner(System.in);
	Account a=new Account();

	
	@Override
	public void createAccount() {
	
		try
		{
		Class.forName("com.mysql.jdbc.Driver");
			
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank management system","root","root");
			
		System.out.println("Enter account number");
		long ac=sc.nextLong();
		a.setAccNo(ac);
		System.out.println("Enter acc holder name");
		String nm=sc.next();
		boolean match=Pattern.matches("[A-Z]{1}[a-z]{1,45}", nm);
		if(match)
		{
		a.setName(nm);
		}
		else
		{
			System.out.println("Enter valid Syntax");
			createAccount();
		}
		System.out.println("Enter mob no");
		String mb=sc.next();
		boolean b=Pattern.matches("[7-9]{1}[0-9]{2,9}", mb);
		if(b)
		{
		a.setMobNo(mb);
		}
		else
		{
			System.out.println("Enter valid number serial 7,8,9");
			createAccount();
		}
		System.out.println("Enter adhar no");
		String ad=sc.next();
		a.setAdharNo(ad);
		System.out.println("Enter gender");
		String g=sc.next();
		a.setGender(g);
		System.out.println("Enter age");
		int ag=sc.nextInt();
		if(ag>18)
		{
			if(ag<=60)
			{
				a.setAge(ag);
			}
		
			else
			{
				System.out.println("Age above 60");
				createAccount();
			}
		}
		else
		{
			System.out.println("Minor");
			createAccount();
		}
		
		System.out.println("Enter balance");
		double bal=sc.nextDouble();
		if(bal>=500)
		{
		a.setBalance(bal);
		}
		else
		{
			System.out.println("Enter minimum balance");
			createAccount();
		}
		cs=con.prepareCall("{call createAccount(?,?,?,?,?,?,?)}");
		cs.setLong(1,a.getAccNo());
		cs.setString(2,a.getName());
		cs.setString(3,a.getMobNo());
		cs.setString(4,a.getAdharNo());
		cs.setString(5,a.getGender());
		cs.setInt(6,a.getAge());
		cs.setDouble(7,a.getBalance());
		cs.executeUpdate();
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
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank management system","root","root");
				
			cs=con.prepareCall("{call displayAllDetails(?,?,?,?,?,?,?)}");
			System.out.println("Enter acc no");
			long acc=sc.nextLong();
			cs.setLong(1, acc);
			cs.registerOutParameter(2,Types.VARCHAR);
			cs.registerOutParameter(3,Types.VARCHAR);
			cs.registerOutParameter(4,Types.VARCHAR);
			cs.registerOutParameter(5,Types.VARCHAR);
			cs.registerOutParameter(6,Types.INTEGER);
			cs.registerOutParameter(7,Types.DOUBLE);
				
					cs.executeUpdate();
		
				System.out.println("***************");
				System.out.println(" ");
				System.out.println("Account holder : "+cs.getString(2));
				System.out.println("Mobile no      : "+cs.getString(3));
				System.out.println("Adhar no       : "+cs.getString(4));
				System.out.println("Gender         : "+cs.getString(5));
				System.out.println("Age            : "+cs.getInt(6));
				System.out.println("Balance        : "+cs.getDouble(7));
				System.out.println(" ");
				System.out.println("***************");
		
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
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank management system","root","root");
			
			cs=con.prepareCall("{call depositeMoney(?,?)}");
			System.out.println("Enter acc no to deposit");
			long ac=sc.nextLong();
			cs.setLong(1,ac);
			
			System.out.println("Enter amount to deposit");
			double bl=sc.nextDouble();
				cs.setDouble(2,bl);
				cs.executeUpdate();
				System.out.println("Deposit Successfull..!!");
		
			
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
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank management system","root","root");
			System.out.println("Enter acc no to withdrawal");
			long ac=sc.nextLong();
			System.out.println("Enter amount to withdrawal");
			double bl=sc.nextDouble();
			
			cs=con.prepareCall("{call withdrawalMoney(?,?)}");
			cs.setLong(1,ac);
			cs.setDouble(2,bl);
			cs.executeUpdate();
			
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
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank management system","root","root");
			System.out.println("Enter acc no to check balance");
			long ac=sc.nextLong();
			
			cs=con.prepareCall("{call balanceCheck(?,?)}");
			cs.setLong(1,ac);
			cs.registerOutParameter(2,Types.DOUBLE);
			cs.executeUpdate();
			System.out.println("Balance is : "+cs.getDouble("bl"));
			
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
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank management system","root","root");
			
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
			cs=con.prepareCall("{call updateAccount(?,?,?,?)}");
			cs.setLong(1,ac);
			cs.setString(2, nm);
			cs.setString(3,a.getMobNo());
			cs.setInt(4,a.getAge());
		    cs.executeUpdate();
		    
			System.out.println("Name updated successfully..!!");
		}
		else if(ch==2)
		{
			System.out.println("Enter acc no");
			long ac=sc.nextLong();
			
			System.out.println("Enter mobile no to update");
			String mb=sc.next();
			cs=con.prepareCall("{call updateAccount(?,?,?,?)}");
			cs.setLong(1,ac);
			cs.setString(2,null);
			cs.setString(3,mb);
			cs.setInt(4,4);
		    cs.executeUpdate();
		    
			System.out.println("mobile no updated successfully..!!");
		}
		else if(ch==3)
		{
			System.out.println("Enter acc no");
			long ac=sc.nextLong();
			
			System.out.println("Enter age to update");
			int ag=sc.nextInt();
			cs=con.prepareCall("{call updateAccount(?,?,?,?)}");
			cs.setLong(1,ac);
			cs.setString(2,null);
			cs.setString(3,null);
			cs.setInt(4,ag);
		    cs.executeUpdate();
		    
			System.out.println("mobile no updated successfully..!!");
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
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank management system","root","root");
			System.out.println("Enter acc no to delete");
			long ac=sc.nextLong();
		
			cs=con.prepareCall("{call deleteAccount(?)}");
			cs.setLong(1, ac);
			cs.executeUpdate();
			System.out.println("Information deleted");
	}
		catch(Exception e)
		{
			e.printStackTrace();
		}
}
}