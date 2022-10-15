package com.braindata.bankmanagement.client;

import java.util.Scanner;

import com.braindata.bankmanagement.service.RBI;
import com.braindata.bankmanagement.serviceImpl.SBI;

public class Test {

	public static void main(String[] args) {
		RBI bank=new SBI();
		Scanner sc=new Scanner(System.in);
	
		while(true)
		{
		System.out.println("Enter 1 to createAccount");
		System.out.println("Enter 2 to display all details");
		System.out.println("Enter 3 to deposit money");
		System.out.println("Enter 4 to withrdrawal money");
		System.out.println("Enter 5 to balance check");
		System.out.println("Enter 6 to update info");
		System.out.println("Enter 7 to delete info");
		System.out.println("Enter 8 to exit");
		System.out.println(" ");
		System.out.println("************************");
		System.out.println(" ");
		
		int ch=sc.nextInt();
		
		switch(ch)
		{
		case 1 : bank.createAccount();
		break;
		
		case 2 : bank.displayAllDetails();
		break;
		
		case 3 : bank.depositeMoney();
		break;
		
		case 4 : bank.withdrawal();
		break;
		
		case 5 : bank.balanceCheck();
		break;
		
		case 6 : bank.update();
		break;
		
		case 7 : bank.delete();
		break;
		
		case 8 : System.exit(0);
		break;
		
		default : System.out.println("Enter valid choice");
		break;
		}
		}
	}

}
