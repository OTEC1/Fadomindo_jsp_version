package admin;


import org.springframework.security.crypto.bcrypt.*;

public class Auth07 {


	
	public  String encrypt(String pass) {
		return(BCrypt.hashpw(pass, BCrypt.gensalt(12)));
		
	}
		 
	public  boolean decrypt(String orignial, String pass) {	
		return  (BCrypt.checkpw(orignial, pass));
		
	}
		    
	
		

	
}
