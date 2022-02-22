package jdbcpro;


	//import java.sql.Connection;
	//import java.sql.DriverManager;
	import java.sql.SQLException;
	import java.util.Scanner;

	public class main {
		public static void main(String[] args) throws Exception{
						 int n;
					Scanner s=new Scanner(System.in);
					do {
						System.out.println("1.Admin Login\n2.Agent Login\n3.Exit");
						System.out.println("Enter the choice:");
						n=s.nextInt();
						switch(n)
						{
						case 1:
							AdminLogin obj1=new AdminLogin();
							obj1.Admin(); 
							break;
						case 2:
							AgentLogin obj2=new AgentLogin();
							obj2.Login();
							break;
						case 3:
							return;
						}
					
					}while(n!=0);			 }
		}




