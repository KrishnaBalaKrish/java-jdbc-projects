package jdbcpro;


import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


public class AdminLogin {

	
		

	public void Admin() throws SQLException, ClassNotFoundException{
//		 Class.forName("com.mysql.cj.jdbc.Driver"); //register a driver //Class.forName()
	Class.forName("com.mysql.Jdbc.Driver");

	java.sql.Connection con=null;//Connection object
		int f=0;
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shopping","root","Krishna@99");
		Scanner s=new Scanner(System.in);
		int m;
		System.out.println("Enter User name:");
		String username=s.next();
		System.out.println("Enter your password:");
		String password=s.next();
		Statement smt=(Statement) con.createStatement();
		ResultSet rr = ((java.sql.Statement) smt).executeQuery("Select * from adminLogin");
		while(rr.next()) {
			if(username.equals(rr.getString(1))&&password.equals(rr.getString(2))) {
				
				f=1;
			}
			
		}
		if(f==1) {
			System.out.println("Successfully verified!");
			do
			{
				System.out.println("1.Add product\n2.Display\n3.Remove product\n4.Update product\n5.logout");
				System.out.println("Enter your choice:");
				m=s.nextInt();
				
				switch(m) {
				case 1:
					System.out.println("Enter your productid:");
					int pid=s.nextInt();
					System.out.println("Enter your product Name:");
					String pname=s.next();
					System.out.println("Enter your minsellquantity:");
					int min=s.nextInt();
					System.out.println("Enter your price:");
					double price=s.nextDouble();
					PreparedStatement ps=con.prepareStatement("insert into product(id,productname,quantity,price  values(????)");
					ps.setInt(1,pid);
					ps.setString(2, pname);
					ps.setInt(3, min);
					ps.setDouble(4, price);
					ps.executeUpdate();
					System.out.println("Product add successfully");
					break;
					case 2:
						Statement smt1=(Statement) con.createStatement();
					       ResultSet rs=((java.sql.Statement) smt1).executeQuery("select * from product");
					       System.out.println("**********************************************");
					       while(rs.next())
					       {
					System.out.println("id ->"+rs.getInt(1)+"\n"+"product namr->"+rs.getString(2)+"\n"+"Quantity->"+"\n"+rs.getInt(3)+"price\n"+rs.getInt(4));
					break;
				}
					case 3:
						Statement smt2=(Statement)con.createStatement();
						ResultSet rs2=smt2.executeQuery("select*from product");
						System.out.println("**********************************************************");
						while(rs2.next()) {
							System.out.println("id->"+rs2.getInt(1)+"\n"+"productname->"+rs2.getString(2));
						}
						System.out.println("************************************************************");
						System.out.println("Enter product detals:");
						int id=s.nextInt();
						PreparedStatement pp= con.prepareStatement("delete from product where id=?;");
						pp.setInt(1, id);
						pp.executeUpdate();
						System.out.println("Successfully removed");
						break;
					case 4:
						Statement smt3=(Statement)con.createStatement();
						ResultSet rs3=((java.sql.Statement) smt3).executeQuery("select * from product");
						while(rs3.next()) {
							System.out.println("******************************************");
							System.out.println("id->"+rs3.getInt(1)+"\n"+"productname->"+rs3.getString(2));
							System.out.println("*******************************************");
							
						}
						int qua=0;
						System.out.println("Enter the product id:");
						int proid=s.nextInt();
						System.out.println("Enter new minsell quantity:");
						int promin=s.nextInt();
						Statement smt4=(Statement) con.createStatement();
						ResultSet rs4=((java.sql.Statement) smt4).executeQuery("Select * from product");
						while(rs4.next())
						{
							int idd=rs4.getInt(1);
							if(idd==proid) {
								int q=rs4.getInt(3);
								qua=q+promin;
							}
						}
						PreparedStatement pss=con.prepareStatement("Update product set quantity=?where product id=?");
						pss.setInt(1,qua);
						pss.setInt(2,proid);
						pss.executeUpdate();
						System.out.println("Successfully updated...........");
						break;
						case 5:
							return;
							default:
								System.out.println("sdfghj");
						
			}
			}while(m!=0);

		}
				else {
					System.out.println("Incorrect username and password");
				}

		}
	}



