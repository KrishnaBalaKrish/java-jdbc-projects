package onbloodbank;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class recipient {
	public void recins() throws SQLException,ClassNotFoundException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		 java.sql.Connection con=null;
		 int f=0;

		 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineblood","root","Krishna@99");
		 Scanner s= new Scanner(System.in);
		 int m;
		 System.out.println("Enter your user name:");
		 String username=s.next();
		 System.out.println("Enter your password:");
		 String password=s.next();
		 Statement smt=(Statement) con.createStatement();
		 ResultSet rr=((java.sql.Statement) smt).executeQuery("Select * from recipient");
		 while(rr.next())
		 {
			 if(username.equals(rr.getString(1))&&password.equals(rr.getString(2)))
			 {
				 f=1;
			 }
		 }
		 if(f==1) {
			 System.out.println("Successfully verified!");
			 do {
				 System.out.println("1.recieve blood \n2.View blood stock \n3.Logout");
				 System.out.println("Enter the choice:");
				 m=s.nextInt();
				 switch(m)
				 {
				 case 1:
					 System.out.println("Enter Blood group");
					 String gp =s.next();				 
					 Statement smt2=(Statement) con.createStatement();
					 ResultSet rr2=((java.sql.Statement) smt2).executeQuery("Select*from bloodstck ");
					 int a=0;
					 int p=0;
					 int pou=0;
		
					 while(rr2.next()) {
						 String gp1=rr2.getString(2);
						 if(gp1.equals(gp)) {
							  p=rr2.getInt(3);
							   pou=p-1;
//								  System.out.println(pou);
//								  System.out.println(p);

							 PreparedStatement psr=con.prepareStatement("update bloodstck set availablepouches=? where bloodgroup=?");
//							 
							 psr.setInt(1, pou);
							 psr.setString(2, gp1);
							 psr.executeUpdate();
							 System.out.println("Selection Updated");
							 f=1;
							 System.out.println("Blood availeble");
							 break;
							 
						 
						 }
						 else {
							f=0;
							 System.out.println("Blood not availeble");
						 }
						 }
					
					 
					 
					 
					
//					 System.out.println("Your selecion is saved");
					 
					 
			break;
					 
				 case 2:
					 Statement smt1=(Statement) con.createStatement();
					 ResultSet rs=((java.sql.Statement) smt1).executeQuery("Select * from bloodstck");
					 while(rs.next()) {
						 System.out.println("----------------------------------------------------------------------------------Blood Stock");
						 System.out.println("sampleno:"+rs.getInt(1)+"________________bloodgroup:="+rs.getString(2)+"__________________availablepouches:="+rs.getInt(3));
					 }
					 
//		   System.out.println("Carefully choose your bllood group from the choices(A+,A-,B+,B-,AB+,AB-,O+,O-:");
//		 String blg=s.next();
			 
		   break;
		   
				 case 3:
				 return;
				 		 
}} while(m!=0);
		 }
			 else {
				 System.out.println("Incorrect username or password....................");
			 }

}
}