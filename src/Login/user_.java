package Login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.amazonaws.metrics.RequestMetricType;

import admin.Admin_user;
import admin.Auth07;
import logic.Server_Request;

/**
 * Servlet implementation class user_
 */
@WebServlet("/sendu")
public class user_ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public user_() {
        super();
          }
    
    
    
    String create_p, user, pass, url;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 create_p=request.getParameter("create_pass");
		 user=request.getParameter("user_email");
		 pass=request.getParameter("pass");
		 
	   url=authenticate_admin(user, pass, create_p, request, response);
	
	 
		 request.getRequestDispatcher(url).forward(request, response);
	}

	
	
	
	public String authenticate_admin(String user, String pass, String create_p, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(user+"  "+pass+  ""  + create_p);
	
	 if(!create_p.isEmpty() && !user.isEmpty() 
			 && !pass.isEmpty()) {
			alert(request, "Don't fill all fields ! ","admin_sign_in.jsp",0);
			
	 }
	  else
		if(!user.trim().isEmpty()  && !pass.trim().isEmpty()
				&& create_p.trim().isEmpty()) {
			
		 int c=   new Server_Request().user_verify(user,pass);
		   url=	error_class(c, request);
		   
		}
		else
			if(!create_p.trim().isEmpty() && !user.trim().isEmpty()) {
	  int c= new Server_Request()
			  .add_amin(user, new Auth07().encrypt(create_p));
				 url=	error_class(c, request);
		}else 
			alert(request, "Pls fill out Fields ! ","admin_sign_in.jsp",0);
		
	
	
	return  url;}
	
	
	private String alert(HttpServletRequest request, String data, String string, int x) {
		
		request.setAttribute("er",data);
		System.out.println(x +  "   X");
		if(x==200) {
			HttpSession  session=request.getSession();
			session.setAttribute("opo1", user);
		}
		
		return string;
		
	}




	public String  error_class(int x, HttpServletRequest request) {
		//System.out.println(x);
		
		user=""; pass=""; create_p="";
			switch (x) {   
			
			case 0:
				url=alert(request, "Dead Request !  ","admin_sign_in.jsp",x);
				
				break;
				
			case 500:
				url=alert(request, "Internal Server Error  Sign in Failed !","admin_sign_in.jsp",x);
				
				break;
				
			case  200:
				
				url=alert(request, "Successfully Sign in","container.jsp",x);
				break;
				
			case  406:
				url=alert(request, "Password not Correct","admin_sign_in.jsp",x);
				break;
				
			case 400:
	
				url=alert(request, "Exception Occured Pls try again","admin_sign_in.jsp",x);
				break;
				
			case 401:
				url=alert(request, "Unauthoriazed  Access","admin_sign_in.jsp",x);
				break;
				
			case  201:
				url=alert(request, "Updated Admin Credentails","admin_sign_in.jsp",x);
				break;
				
			case  300:
				url=alert(request, "Connection Refused !","admin_sign_in.jsp",x);
				
				break;
				
			case 405:		
	        	alert(request, "Error Could'nt Update admin Creden !","admin_sign_in.jsp",x);	
					break;
					
			case 404:
				url=alert(request, "Cound'nt add admin Right","admin_sign_in.jsp",x);
				
				break;
				
				case 407:
					url=alert(request, "Error While Updating Admin","admin_sign_in.jsp",x);
					
					break;
					
				case 501:
					url=alert(request, "Email's  Incorrect","admin_sign_in.jsp",x);	
					break;
					
			default:
				url=alert(request, "Failed Contact Support !","admin_sign_in.jsp",x);
				
				break;
			}
		
			return url;
	
			}





	
}
