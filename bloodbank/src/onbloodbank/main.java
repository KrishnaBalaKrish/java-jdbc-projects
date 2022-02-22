package onbloodbank;

import java.util.Scanner;

import java.sql.SQLException;
import java.util.Scanner;

public class main {
	public static void main(String[] args) throws Exception{
		 int n;
			Scanner s=new Scanner(System.in);
			System.out.println("************************ONLINE BLOOD BANK**************************");
			System.out.println("_____________________________________________________________________");
			System.out.println("######################Donate Blood Save live....#####################");
			do {
				System.out.println("1.DONER  2.Recipient 3.Admin 4.Exit");
				System.out.println("*_*_*_*_*_*_*_*_*_*__*_*_*_*");
				System.out.println("Enter the choice:");
				n=s.nextInt();
				switch(n)
				{
				case 1:
					doner obj1=new doner();
					obj1.donin(); 
					break;
				case 2:
					recipient obj2=new recipient();
					obj2.recins();
					break;
				case 3:
					adminlog obj3=new adminlog();
					obj3.admn();
				case 4:
					return;
				}
	}while(n!=0);	
}
}
