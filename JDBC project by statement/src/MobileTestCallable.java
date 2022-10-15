import java.util.Scanner;

public class MobileTestCallable {
	public static void main(String[] args) {
		MobileimpCallable mi=new MobileimpCallable();
		Scanner sc=new Scanner(System.in);
		while(true)
		{
		System.out.println("Enter 1 to create table");
		System.out.println("Enter 2 to insert data");
		System.out.println("Enter 3 to update data");
		System.out.println("Enter 4 to delete data");
		System.out.println("Enter 5 to show data");
		int ch=sc.nextInt();
		switch(ch)
		{
		case 1 : mi.create();
		break;
		case 2 : mi.insert();
		break;
		case 3 : mi.update();
		break;
		case 4 : mi.delete();
		break;
		case 5 : mi.show();
		break;
		case 6 : System.exit(0);
		break;
		default : System.out.println("Enter valid choice");
		}

	}
	
}
}
