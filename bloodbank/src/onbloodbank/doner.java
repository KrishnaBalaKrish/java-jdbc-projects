package onbloodbank;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class doner {
	public void donin() throws SQLException, ClassNotFoundException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		java.sql.Connection con=null;
		int f=0;
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineblood","root","Krishna@99");
		Scanner s=new Scanner(System.in);
		int m;
		System.out.println("Enter User name:");
		String username=s.next();
		System.out.println("Enter your password:");
		String password=s.next();
		Statement smt=con.createStatement();
		ResultSet rr = smt.executeQuery("Select * from doner");
		
			while(rr.next()) {
			
				if(username.equals(rr.getString(1))&&password.equals(rr.getString(2))) {
					
					f=1;
				}
			}
			if(f==1) {
				System.out.println("Successfully verified!");
				do{
					System.out.println("DONATE BLOOD SAVE LIFE.......");
					System.out.println("_________________________________________________________");
					System.out.println("1.To donate\n2.Logout");
					System.out.println("*********************************************************");
					System.out.println("Please enter your choice to continue:");
					 m=s.nextInt();
					 switch(m) {
					 case 1:
						 System.out.println("choose your bloode group\n1.A+\n2.A-\n3.B+\n4.B-\n5.AB+\n6.AB-\n7.O+\n8.O-\n?:");
						 String grp=s.next();
						        Statement smt1=con.createStatement();
						        ResultSet rr1=((java.sql.Statement) smt1).executeQuery("Select*from bloodstck ");
//						        String grp1=rr1.getString(2);
						        int po=0;
						        while(rr1.next()) {
						        	String grp1=rr1.getString(2);
						        	if(grp1.equals(grp)) {
						        	int	p=rr1.getInt(3);
						        		po=p+1;
						        		 PreparedStatement psg=con.prepareStatement("update bloodstck set availablepouches=? where bloodgroup=?");
						        		 psg.setInt(1,po);
						        		 psg.setString(2, grp1);
						        		 psg.executeUpdate();
						        		 System.out.println("Accepted");
						        		 break;
						        	}
						        	
						        	else {
//						        		 PreparedStatement ps=con.prepareStatement("insert into bloodstck(bloodgroup varchar(20) value(?)" );
//						        		 ps.executeUpdate();
						        		System.out.println("try next time");
						        		
						        	}
						        }
						    System.out.println("Your donation is accepted");
						
						 break;
					 case 2:
						 Statement smt5=(Statement) con.createStatement();
						 ResultSet rs=((java.sql.Statement) smt5).executeQuery("Select * from bloodstck");
						 while(rs.next()) {
							 System.out.println("----------------------------------------------------------------------------------Blood Stock");
							 System.out.println("sampleno:"+rs.getInt(1)+"________________bloodgroup:="+rs.getString(2)+"__________________availablepouches:="+rs.getInt(3));
						 }
					 } 
					 
		}while(m!=0);
			}
		else {
			System.out.println("Incorrect username and password");
		}
		
	}
}

	
//}
//}