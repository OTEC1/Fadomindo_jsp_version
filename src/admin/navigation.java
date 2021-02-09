package admin;


import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import javax.servlet.http.HttpSession;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import logic.Server_Request;
import sQL_con.Credens;


@ManagedBean
@SessionScoped
public class navigation {
	
	
	


	
	
	
	
	List<navigation> list2,list_search;
	StreamedContent  stream;
	String id,title,paths,write_up,current,contents;
	 String titles,write,newq,funnyq,gistq,searchs="";



			public void message( String h) {
					FacesContext context=FacesContext.getCurrentInstance();
					FacesMessage  message =new FacesMessage(FacesMessage.SEVERITY_INFO,"",h);
				context.addMessage(null, message);
				
				
				}	
		
				public HttpSession  session() {
					FacesContext  context=FacesContext
							.getCurrentInstance();
					HttpSession  session=(HttpSession)
							context.getExternalContext().getSession(false);
					return  session;
				}
		




		
				
				
						
		public String getSearchs() {
			return searchs;
		}
		
		public void setSearchs(String searchs) {
			this.searchs = searchs;
		}
		
		
		
		public String getNewq() {
			return newq;
		}
		
		
		public void setNewq(String newq) {
			this.newq = newq;
		}


public String getFunnyq() {
	return funnyq;
}


public void setFunnyq(String funnyq) {
	this.funnyq = funnyq;
}


public String getGistq() {
	return gistq;
}


public void setGistq(String gistq) {
	this.gistq = gistq;
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


	public String getCurrent() {
		return current;
	}


	public void setCurrent(String current) {
		this.current = current;
	}





	public String getContents() {
		return contents;
	}





	public void setContents(String contents) {
		this.contents = contents;
	}
	
	

	



	int o=0;
		public  String onload() {
			
		
			     if( o==0){
					 String address=read_ip(1);
					 System.out.println("load"+address) ;
					 new Server_Request().push_in_visitor_ip(address,1);
					   o++;
					  System.out.println(o+" Counts");
					 }
			     
			   
		return null;
		}




public String read_ip(int d) {
	
String x=null;
    switch(d){
    
    case 1:
           x="http://checkip.amazonaws.com";
           break;                  
      case 2:
           x="http://ipv4.icanhazip.com/";
           break;
     case 3:
           x="http://myexternalip.com.raw";
           break;
     case 4:
           x="http://ipecho.net/plain";
           break;
      case 5:
           x="http://bot.whatismyipaddress.com";
           break;
       case 6:
           x="http://www.trackip.net/ip";
           break;  
}
	String s="";
	BufferedReader reader=null;
	try {
	URL url=new URL(x);
			  reader=new BufferedReader(new  InputStreamReader(url.openStream()));
			s=reader.readLine();
	}catch (Exception e) {
		System.out.println(e);
	}
			return s;
}


	
	

	
	
	
//	public String pathing() throws IOException {
//	String p= String.valueOf(new File("testers").getCanonicalPath());
//		int  x=p.indexOf(File.separator);
//	return  p.substring(0, x);
// 
//
//}





//private String 	video_write(UploadedFile uploadedFile2) throws IOException{
//	
//	String dir=("Videos_bucket");
//
//  File  file= new File(dir).getCanonicalFile().getParentFile();
//  try {
//	  if(!file.exists())
//	file.createNewFile();
//	System.out.println(file.exists()+"  AB "+file.getCanonicalFile().getParentFile().getName().getAbsolutePath());
//} catch (IOException e) {
//	// TODO Auto-generated catch block
//	e.printStackTrace();
//}  

//String s=null;
//String dir=null;
//FileOutputStream  fos=null;
//try {
//dir=string.concat(File.separator.concat("Videos_bucket"));
//File  file= new File(dir);
//  new File(file,dir).createNewFile();  
//
//long  time=System.currentTimeMillis();
//long date=System.nanoTime();
//s=String.valueOf(time).concat(String.valueOf(date)).concat(".mp4");
//
//File  fs=new File(dir,s);
//fos=new FileOutputStream(fs);
//fos.write((int) (uploadedFile2.getInputstream()).transferTo(fos));
//fos.close();
//System.out.println("Uploaded  to Videos ");
//}
//catch (Exception e) {
//System.out.println(e);
//}
//


}
