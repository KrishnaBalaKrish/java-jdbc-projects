package jdbcpro;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AgentLogin {



	
		public void Login() throws SQLException,ClassNotFoundException{
			 java.sql.Connection con=null;
			 int f=0;
			 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shopping","root","Krishna@99");
			 Scanner s= new Scanner(System.in);
			 int m;
			 System.out.println("Enter your user name:");
			 String username=s.next();
			 System.out.println("Enter your password:");
			 String password=s.next();
			 Statement smt=(Statement) con.createStatement();
			 ResultSet rr=((java.sql.Statement) smt).executeQuery("Select*from agent");
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
					 System.out.println("1.Buysell\n2.View product\nLogout");
					 System.out.println("Enter the choice:");
					 m=s.nextInt();
					 
					
					 switch(m)
					 {
					 case 1:
						 System.out.println("Enter productId");
						 int pid=s.nextInt();
						 System.out.println("Enter Quantity:");
						 int qnty=s.nextInt();
						 
						 double price=0;
						 int flag=0;
						 Statement smt2=(Statement) con.createStatement();
						 ResultSet rr2=((java.sql.Statement) smt2).executeQuery("Select*from product");
						 while(rr2.next()) {
							 if(pid==rr2.getInt(1)) {
								 price=rr2.getDouble(4);
								 int quantity=rr2.getInt(3);
								 if(qnty<=quantity) {
									 double sum=price*qnty;
									 System.out.println("cost is ->"+sum);
									 flag=1;
								 }
								 else {
									 System.out.println("Stack overflow");
									 flag=0;
								 }
							 }
						 }
						 if(flag==1) {
							 Statement smt4=(Statement) con.createStatement();
							 ResultSet rs4=((java.sql.Statement) smt4).executeQuery("select*from product");
							 int qua=0;
							 while(rs4.next()) {
								 int idd=rs4.getInt(1);
								 if(idd==pid) {
									 int q=rs4.getInt(3);
									 qua=q-qnty;
								 }
							 }
							 PreparedStatement pss=con.prepareStatement("update product set quantity=? where id=?");
							 pss.setInt(1, qua);
							 pss.setInt(2, pid);
							 pss.executeUpdate();
						 }
						 break;
					 case 2:
						 
						 Statement smt1=(Statement) con.createStatement();
						 ResultSet rs=((java.sql.Statement) smt1).executeQuery("Select * from product");
						 System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~LIST OF PRODUCTS~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
						 System.out.println("****************************************************************************");
						 while(rs.next()) {
							 System.out.println("product id->"+rs.getInt(1)+"\n"+"product name->"+rs.getString(2)+"\n"+"Quantity->"+rs.getInt(3)+"\n"+"price->"+rs.getDouble(4));
						 }
						 System.out.println("*************************************************************************************");
						 break;
					 case 3:
						 return;
						 
					 }
					 
				 }while(m!=0);
			 }
			 else {
				 System.out.println("Incorrect username or password....................");
			 }
		}

	}
