package onbloodbank;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class adminlog {
	public void admn() throws SQLException, ClassNotFoundException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		java.sql.Connection con=null;
		int f=0;
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineblood","root","Krishna@99");
		Scanner s=new Scanner(System.in);
		int n;
		System.out.println("Enter User name:");
		String username=s.next();
		System.out.println("Enter your password:");
		String password=s.next();
		Statement smt=con.createStatement();
		ResultSet rr = smt.executeQuery("Select * from admin");
		while(rr.next()) {
			if(username.equals(rr.getString(1))&&password.equals(rr.getString(2))) {
				f=1;
			}
		}
		if(f==1) {
			System.out.println("Successfully verified!");
			do{
				System.out.println("DONATE BLOOD SAVE LIFE.......");
				System.out.println("__________________________________________________________");
				System.out.println("1.view blood stock 2.Add new member 3.Remove a member 4.Logout");
				System.out.println("Please enter your choice to continue:");
				 n=s.nextInt();
				  switch(n) {
				  case 1:
					  Statement smtx=(Statement) con.createStatement();
					  ResultSet rsx=((java.sql.Statement) smtx).executeQuery("Select * from bloodstck");
					  while(rsx.next()) {
							 System.out.println("sampleno:"+rsx.getInt(1)+"\tbloodgroup:="+rsx.getString(2)+"\tavailablepouches:="+rsx.getInt(3));
							 System.out.println("________________________________________________________________________________________________________________Blood Stock");
						 }
					  break;
				  case 2:
					  System.out.println("Choose y");
					  
				  }
			}
			while(n!=0);
		}
	}

}
