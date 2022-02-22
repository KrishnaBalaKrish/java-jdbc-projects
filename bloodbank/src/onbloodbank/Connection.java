package onbloodbank;

import java.sql.DriverManager;
import java.sql.SQLException;

//import onbloodbank.Connection;

public class Connection {
	public Connection getConnection() throws SQLException,ClassNotFoundException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		java.sql.Connection con=null;
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineblood","root","Krishna@99");
		if(con!=null) {
			return (Connection) con;
		}
		else
		{
			return null;
		}

		}
		
	}


