package logic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import sQL_con.Connection_sql;

public class User {
	
	
	public String home() {
		return String.valueOf(nav_list().length);
	}
	
	public String recent() {
		String last_visited="5";
		return last_visited;
	}
	
	public   String[]  nav_list() {
		String []string=  {"All","Runway","Fashion","News","Life style"};
		return string;
	}
	
	public String api() {
		return  "8192803cd68641b28ccab9b90f6944a0";
	}
	


	

	
	



}
