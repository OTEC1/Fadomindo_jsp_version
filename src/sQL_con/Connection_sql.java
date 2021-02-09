package sQL_con;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Connection_sql {

	
	

	
	
	public   Connection getConnection() {
		
		Connection  con=null;
		
	
		try {
			Class.forName(Credens.driverName);
			con=DriverManager.getConnection(Credens.connectionUrl, Credens.userId, Credens.password);
			 
			 //System.out.println("Connected ! ");
			 
			}
		catch (Exception e) {
			System.out.println(e);
		}
		return  con;
	}
}
