  package admin;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.primefaces.context.RequestContext;
import org.primefaces.model.UploadedFile;

import com.amazonaws.services.s3.model.ObjectMetadata;

import logic.Server_Request;
import admin.navigation;
import sQL_con.Credens;


@ManagedBean
@SessionScoped
public class Admin_user {

	
	String id,title,paths,write_up,titles,write,verifys,
	create_p="",user="",pass="",current="",source="";
	 UploadedFile  uploadedFile,uploadedFile2;
		
	List<Admin_user> lis;
	 static String rols,
				a0="Select Category",
				a1="Top display ",
				a2="Main display";
	        static int a=1;
	 
	

	
	
	
	


	
	
	
	public void read() {
		if(rols.equals(a0)) {
			message("Pls Select a Drop");
			a=1;
		}else
			if(rols.equals(a1)) {
			setRols(a1);
			a=2;
		}else 
			if(rols.equals(a2)) {
				setRols(a2);
				a=2;
				
			}

		
	}
	
	
	
	
	public String  send_in() throws IOException {
		 FacesContext  context=FacesContext.getCurrentInstance();
			
		HttpSession  session=(HttpSession) context.getExternalContext().getSession(false);
		System.out.println(session.getAttribute("opo1"));
		String x="";
		   x=context.getExternalContext().getRequestParameterMap().get("vi");
		if(read_cre().trim().length()==0)
			message("Pls Sign in");
			else
		if(title.trim().length()==0 | write.trim().length()==0 & (a!=1))
			message("Pls Fill both Fields ! ");
		else
			if(x.trim().length()==0)
				message("Pls Select a Page View");
		else
			if (uploadedFile.getSize()==0)
						message("Pls add a File");
			else
				 if(a==1)
					 message("Pls Select Drop down ! ");
				else 	
			        check_type(uploadedFile.getContentType(), name());	
				
		
		
		return  null;
	}
	
	

private String read_cre() {
	  FacesContext  context=FacesContext.getCurrentInstance();
	 HttpSession  session=(HttpSession) context.getExternalContext().getSession(false);
	 return (String) session.getAttribute("opo1");
    
	}




private String check_type(String contentType, String x) throws IOException {
	

	 System.out.println(contentType+"  AAAA");
	 
	 int n=contentType.lastIndexOf(File.separator);
	 String	 string=contentType.substring(n+1);
		String a=null; 
	
		  
		 		if(string.endsWith("mp4") | string.endsWith("mkv")) {
		 		
		 			if(uploadedFile.getSize()>0 && uploadedFile2.getSize()>0) {
		 				a=x.concat(".mp4");
		 						TYPE(a,"Vid",uploadedFile);
		 			
		 			a=x.concat(".png");
		 			  title=	title.toLowerCase();
		 			    TYPE(a,"Pics",uploadedFile2);
		 			    	title=""; write="";
		 			    	
		 		     	System.out.println("Video File "+string);
		 			}
		 			else
		 				message("Pls upload both a video and tumbnail ");
		 		}
		 		else
			 		 if(string.endsWith("png") | string.endsWith("jpg") | string.endsWith("jpeg") 
			 				 | string.endsWith("webp") | string.endsWith("svg") ) {
			 		 	a=x.concat(".png");
			 		 	TYPE(a,"Pics",uploadedFile);
			 		 	title=""; write="";
			 	   System.out.println("Pictute  file "+string);
			 		 }
		 		else 
		 			message("Invalid file format Selected ! ");
		 			
		 
		 
		 return a;
}


	private void TYPE(String a3, String string, UploadedFile nuploadedFile) {
		try {
			new Server_Request().Upload_file(Credens.bucket,a3,nuploadedFile.getInputstream(),meta(nuploadedFile));
				based_on(new Server_Request().put_in_blogs(source,title,write,getRols(),a3,	(String)new navigation().session().getAttribute("st"),string));	
					System.out.println("Key= "+a3);
						} catch (IOException e) {
							System.out.println(e); 
							  message("Error Occured Pls  try again aws");
						}
					}


		private void based_on(int z) {
			if(z==200)
			message("Upload Successfully ! ");
			else
				message("Error Occured Pls  try again");
		}



	public ObjectMetadata meta( UploadedFile  kuploadedFile) {
	ObjectMetadata  metadata=new ObjectMetadata();
		metadata.setContentLength(kuploadedFile.getSize());
		metadata.setContentType(kuploadedFile.getContentType());
		return metadata;
	}
	
	
	public String name() {
	 long  time=System.currentTimeMillis();
	 long date=System.nanoTime();
	return	String.valueOf(time).concat(String.valueOf(date));
	}



	
	
	public String run_way() {
		
		if(read_cre().trim().length()==0)
			message("Pls Sign in");
			else {
				Admin_user  user=new Admin_user();
				user.setCurrent("runway");
				starting().put("stat", user);
				new navigation().session().setAttribute("st", "runway");
			}
		return  null;
	}

	

		public String fashion() {
			if(read_cre().trim().length()==0)
			message("Pls Sign in");
			else {
				Admin_user  user=new Admin_user();
				user.setCurrent("fashion");
				starting().put("stat", user);
				new navigation().session().setAttribute("st", "fashion");
				
			}
				return  null;
			}
	
		public String news() {
			if(read_cre().trim().length()==0)
				message("Pls Sign in");
			else {
				Admin_user  user=new Admin_user();
				user.setCurrent("news");
				starting().put("stat", user);
				new navigation().session().setAttribute("st", "news");
			}
			return  null;
			}
		
		public String life_style() {
			if(read_cre().trim().length()==0)
				message("Pls Sign in");
			else {
				Admin_user  user=new Admin_user();
				user.setCurrent("lifestyle");
				starting().put("stat", user);
				new navigation().session().setAttribute("st", "lifestyle");
			}
			return  null;
		}





				public String run_drop() {
					if(read_cre().trim().length()==0)
						message("Pls Sign in");
						else
					new navigation().session().setAttribute("tables", "runway");
				return null;
				}
				
				
			public String Fashion_drop() {
				if(read_cre().trim().length()==0)
					message("Pls Sign in");
					else
				new navigation().session().setAttribute("tables", "fashion");
				return null;
				}
			
			
			public String  News_drop() {
				if(read_cre().trim().length()==0)
					message("Pls Sign in");
					else
				new navigation().session().setAttribute("tables", "news");
				return null;
			}
			
			
			public String  Life_style_drop() {
				if(read_cre().trim().length()==0)
					message("Pls Sign in");
					else
				new navigation().session().setAttribute("tables", "lifestyle");
				return null;
			}

			
			public String visit() {
				
				return null;
			}
			
			
			
			
			
	public String delete() {
		
		FacesContext  context=FacesContext.getCurrentInstance();
			String key=context.getExternalContext().getRequestParameterMap().get("pat");
				int z=   checker(key);
				
				     if(z==200) 
						message1("deleted");
			    	else
			    		message1("Error Occurred ! ");
   
		return  null;
	}















	public List<Admin_user> getLis() {
		if(!starting().isEmpty())
		return new Server_Request()
				.pick_table((String)new navigation()
						.session().getAttribute("tables"));
	return null;
}
	
	
	
	
	public void setLis(List<Admin_user> lis) {
		this.lis = lis;
	}



	
	public String  sign_out() {
		Pass_out("");
		new navigation()
		.session()
		.setAttribute("tables","0000");
		Admin_user  user=new Admin_user();
		user.setCurrent("");
		starting().put("stat", user);
	return null;}
	
	




	
	
	

	
	
	
	
	@SuppressWarnings("deprecation")
	public void message1( String h) {
		 RequestContext context2=RequestContext.getCurrentInstance();
		 context2.execute("swal('"+h+"')");
	}	
	
	public void message( String h) {
		FacesContext context=FacesContext.getCurrentInstance();
		FacesMessage  message =new FacesMessage(FacesMessage.SEVERITY_INFO,"",h);
	context.addMessage(null, message);
	}	
		

	public void Pass_out(String v) {	
		if(v.trim().length()==0)
			message("Sign Out");

		/*Admin_user usr=new Admin_user();
		usr.setVerifys(v);
		starting().put("passed", usr);
		*/
		
	}

	public Map<String, Object> starting() {
		FacesContext context=FacesContext.getCurrentInstance();
		Map<String, Object>  obj=context.getExternalContext().getSessionMap();
		return  obj;
	}
	
	
	
	
	public String  sub(String v, String z) {
		int c=v.indexOf(".");
		String x=v.substring(0,c);
		return	x=	x.concat(z);		 
	}
	
	
	
	
	private int checker(String x) {
		 String t;
		t=sub(x, ".png");
	   	new Server_Request().delete_single_item(Credens.bucket, t);	
	   	t="";
		t=sub(x, ".mp4");
		new Server_Request().delete_single_item(Credens.bucket, t);	
	   	t="";	
	   	return  labs(x);
	}
	
	
	
	private int labs(String x) {
				int k; String t;
				t=		sub(x, ".png");
			   	k=new Server_Request().delete_from_table_sql(t);
			   	t="";
				t=sub(x, ".mp4");
			   	k=new Server_Request().delete_from_table_sql(t);	
			   	t="";
			   	
		return k;
	}




	public UploadedFile getUploadedFile2() {
		return uploadedFile2;
	}
	
	
	public void setUploadedFile2(UploadedFile uploadedFile2) {
		this.uploadedFile2 = uploadedFile2;
	}
	
	
	public UploadedFile getUploadedFile() {
		return uploadedFile;
	}
	
	
	public void setUploadedFile(UploadedFile uploadedFile) {
		this.uploadedFile = uploadedFile;
	}
	
	
	public String getRols() {
		return rols;
	}

	public void setRols(String rols) {
		this.rols = rols;
	}


	public String getA1() {
		return a1;
	}

	public void setA1(String a1) {
		this.a1 = a1;
	}

	public String getA2() {
		return a2;
	}

	public void setA2(String a2) {
		this.a2 = a2;
	}

	
	public String getA0() {
		return a0;
	}

	public void setA0(String a0) {
		this.a0 = a0;
	}
	
	
	 
	public String getCurrent() {
	return current;
}


public void setCurrent(String current) {
	this.current = current;
}





public String getId() {
	return id;
}


public void setId(String id) {
	this.id = id;
}


public String getTitle() {
	return title;
}


public void setTitle(String title) {
	this.title = title;
}


public String getPaths() {
	return paths;
}


public void setPaths(String paths) {
	this.paths = paths;
}


public String getWrite_up() {
	return write_up;
}


public void setWrite_up(String write_up) {
	this.write_up = write_up;
}


public String getTitles() {
	return titles;
}


public void setTitles(String titles) {
	this.titles = titles;
}


public String getWrite() {
	return write;
}


public void setWrite(String write) {
	this.write = write;
}



public String getUser() {
	return user;
}


public void setUser(String user) {
	this.user = user;
}


public String getPass() {
	return pass;
}

public void setPass(String pass) {
	this.pass = pass;
}




public String getVerifys() {
	return verifys;
}




public void setVerifys(String verifys) {
	this.verifys = verifys;
}




public String getCreate_p() {
	return create_p;
}


public void setCreate_p(String create_p) {
	this.create_p = create_p;
}




public String getSource() {
	return source;
}




public void setSource(String source) {
	this.source = source;
}






	
}
