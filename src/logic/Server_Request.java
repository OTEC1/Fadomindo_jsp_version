package logic;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.util.IOUtils;

import admin.Admin_user;
import admin.Auth07;
import admin.navigation;

//import com.amazonaws.AmazonServiceException;
//import com.amazonaws.auth.AWSCredentials;
//import com.amazonaws.auth.AWSStaticCredentialsProvider;
//import com.amazonaws.auth.BasicAWSCredentials;
//import com.amazonaws.regions.Regions;
//import com.amazonaws.services.s3.AmazonS3;
//import com.amazonaws.services.s3.AmazonS3ClientBuilder;
//import com.amazonaws.services.s3.model.Bucket;
//import com.amazonaws.services.s3.model.ObjectMetadata;
//import com.amazonaws.services.s3.model.S3Object;
//import com.amazonaws.services.s3.model.S3ObjectInputStream;
//import com.amazonaws.util.IOUtils;

import sQL_con.*;
import sQL_con.Connection_sql;

public class Server_Request {

	
	
	
	   AmazonS3 s3 = null;
			public void Create_BucketS3() {
			
				AWSCredentials   credentials =new
						BasicAWSCredentials(Credens.ACCESS_KEY_ID, Credens.ACCESS_SEC_KEY);
				    s3= AmazonS3ClientBuilder
					.standard()
					.withCredentials(new AWSStaticCredentialsProvider(credentials))
					.withRegion(Regions.EU_WEST_3)
					.build();
					    
					  if(!s3.doesBucketExistV2(Credens.bucket)) {
					  try {
						    s3.createBucket(Credens.bucket);
					  }catch (Exception e) {
						    System.out.println(e);
					}
					  
					  }
				}
	
	
	
			public void List_Bucket() {
		
				 List<Bucket> bucket =s3.listBuckets();
				 
				 for(Bucket  b : bucket) {
					 
				 }
			}
	
	
			public void Upload_file(String bucket, String key_name, InputStream  file_path, ObjectMetadata bs) {
						try {
							Create_BucketS3();
							//	s3.putObject(bucket, key_name,new File(file_path));
								s3.putObject( new PutObjectRequest( bucket, key_name, file_path,bs )
										.withCannedAcl(CannedAccessControlList.PublicRead));
							}catch (Exception  e) {
									System.out.println(e );
					}
				}




			public void delete_single_item(String bucket_name, String object_key) {
					try {		
						Create_BucketS3();
							s3.deleteObject(bucket_name, object_key);
						}catch (AmazonServiceException e) {
							System.out.println(e);
						}
			}
			
			
			public void delete_bucket(String bucket_name) {
				
				try {		
					Create_BucketS3();
						s3.deleteBucket(bucket_name);
					}catch (AmazonServiceException e) {
						System.out.println(e);
					}
			}






	  
	
	public int put_in_blogs(String sources,  String title, String write, String rols, String media, String string, String tables) {

		Connection  cons=null;	
				int a=0;
					try {
						cons=new Connection_sql().getConnection();
						PreparedStatement  ps=cons.prepareStatement("insert into  Home_views(file_path,title,write_up,cats,typeq,stamp,source,engagement)  values(?,?,?,?,?,?,?,?)");
						ps.setString(1,  media);
						ps.setString(2, title);
						ps.setString(3, write);
						ps.setString(4, rols);
						ps.setString(5, string);
						ps.setString(6, time_save());
						ps.setString(7,sources);
						ps.setString(8,"0");
						a=200;
						ps.execute();	
						}
							catch (Exception e) {
								System.out.println("C       "+e);
								a=404;
							}
						finally {
							try {
								cons.close();
							} catch (SQLException e) {
								System.out.println("D       "+e);
							}
						}
				return a;}
	
	
	
	
	
	
	
	
	
	

	@SuppressWarnings("resource")
	public void push_in_visitor_ip(String address, int i) {
		Connection  cons=null;	
		PreparedStatement ps=null;
			try {
				String time="0:0";
						int cou = 0;
				cons=new Connection_sql().getConnection();
				
				  ps=cons.prepareStatement("select  * from  Visit_counts_fedo  order by id desc");
				ResultSet  rs=ps.executeQuery();
				if (rs.next()) {
					
					time=rs.getString(4);
					cou=Integer.valueOf(rs.getString(3));
				}
				
				
				
				if(time.equals(date_save())) 
				{
					  cou=cou+1;
					  ps=cons.prepareStatement("update   Visit_counts_fedo  set counts="+cou+"  where dates= '"+time+"'");
					  ps.execute();
					  
					  ps=cons.prepareStatement("insert into  Member_visit_fedo(ips,counts,dates)  values(?,?,?) ");
						ps.setString(1, address);
						ps.setInt(2, i);
						ps.setString(3, time_save());
						ps.execute();
				}
				else {
				  ps=cons.prepareStatement("insert into  Visit_counts_fedo(ips,counts,dates)  values(?,?,?) ");
					ps.setString(1, address);
					ps.setInt(2, i);
					ps.setString(3, date_save());
					ps.execute();	
				
				
				
				  ps=cons.prepareStatement("insert into  Member_visit_fedo(ips,counts,dates)  values(?,?,?) ");
					ps.setString(1, String.valueOf(address));
					ps.setInt(2, i);
					ps.setString(3, time_save());
					ps.execute();
					
				}
			
			}
					catch (Exception e) {
						System.out.println("F      "+e);
					}
				finally {
					try {
						cons.close();
					} catch (SQLException e) {
						System.out.println("G       "+e);
					}
				}
	}

	

    
    



	
	//Pics and video Home Page
	public List<navigation> look(String searchs) {
		List<navigation>  packing=new ArrayList<>();
		Connection  cons=null;
		
	
			
		try {
			cons=new Connection_sql().getConnection();
			PreparedStatement  ps=cons.prepareStatement("select * from  Home_views  where title   like '%"+searchs+"%' order by id desc ");
			ResultSet  rs=ps.executeQuery();
				while (rs.next()) {
					
					navigation  nav=new navigation();
					nav.setId(rs.getString(1));
					nav.setPaths(rs.getString(2));
					nav.setTitle(rs.getString(3));
					nav.setWrite_up(rs.getString(4));
					nav.setCurrent(rs.getString(5));
					nav.setContents(rs.getString(6));
					packing.add(nav);
				
				}
		}catch (Exception e) {
			System.out.println("H       "+e);
		}
		finally {
			try {
				cons.close();
			} catch (SQLException e) {
				System.out.println("I      "+e);
			}
		}
		return packing;
	}



	
	
	

	public List<Admin_user> pick_table(String current) {
		
		List<Admin_user>  packing=new ArrayList<>();
		Connection  cons=null;

			try {
				cons=new Connection_sql().getConnection();
				PreparedStatement  ps=cons.prepareStatement("select   *   from Home_views where typeq like '%"+current+"%'   order by id desc ");
				ResultSet  rs=ps.executeQuery();
				
				if(current.equals("Visit_counts")) {
					while (rs.next()) {
					    	Admin_user  nav=new Admin_user();
					    	nav.setId(rs.getString(1));
							nav.setPaths(rs.getString(2));
							nav.setTitle("User  visit: "+rs.getString(3));
							nav.setWrite_up("Date: "+rs.getString(4));
							packing.add(nav);
						}	
				}
				else {
				
				
				while (rs.next()) {	
					    Admin_user  nav=new Admin_user();
						nav.setId("Post ID: "+rs.getString(1));
						nav.setPaths(rs.getString(2));
						nav.setTitle("Title:  "+rs.getString(3));
						nav.setWrite_up("Cat: "+rs.getString(6));
						packing.add(nav);
					}
				}
			}catch (Exception e) {
				
				System.out.println("L       "+e);
			}
		finally {
			try {
				cons.close();
			} catch (SQLException e) {
				
				System.out.println("M       "+e);
			}
		}
		return packing;
	}



	
	
	public int delete_from_table_sql( String x) {
		Connection  cons=null;
		int xs=0;
		try {
			cons=new Connection_sql().getConnection();
			PreparedStatement  ps=cons.prepareStatement("delete from Home_views  where file_path='"+x+"'");
			xs=200;	
			ps.execute();
		}
		catch (Exception e) {
			
			System.out.println("N1      "+e);
			xs=400;
		}
		finally {
			try {
				cons.close();
			} catch (SQLException e) {
				
				System.out.println("O1       "+e);
			}
		}
		return xs;
	}
	
	
	
	
	


	public int user_verify(String user, String pass) {
		Connection  cons=null;
		int c=0;
		try {
			cons=new Connection_sql().getConnection();
			PreparedStatement  ps=cons.prepareStatement("select * from  Fedo_admin where email='"+user+"'");
			ResultSet  rs=ps.executeQuery();
			if(rs.next())
				c=pass_Auth(pass);
			else
				c=501;
		
		}
		catch (Exception e) {
			
			System.out.println("P       "+e);
			c=500;
		}
		finally {
			try {
				cons.close();
			} catch (SQLException e) {
				 
				System.out.println("R       "+e);
				c=300;
			}
		}
		
		return c;
	}



	private int  pass_Auth(String pass) {
	Connection  cons=null;
		int x=0;
		try {
			cons=new Connection_sql().getConnection();
			PreparedStatement  ps=cons.prepareStatement("select * from  Fedo_admin ");
			ResultSet  rs=ps.executeQuery();
			if(rs.next()) {
				
				String  xi=rs.getString(3);
				
				  if(new Auth07().decrypt(pass,xi)) {
						new Admin_user().Pass_out(xi);  x=200;
				   }else x=406;
			}
		   }
		catch (Exception e) {
		 
			System.out.println("S       "+e);
			x=400;
		}
		finally {
			try {
				cons.close();
			} catch (SQLException e) {
				
				System.out.println("T       "+e);
				x=300;
			}
		
		}
		
		return  x;
		}



	public int add_amin(String user, String create_p) {
		
		Connection  cons=null;
		int x=0;
		try {
			cons=new Connection_sql().getConnection();
			PreparedStatement  ps=cons.prepareStatement("select * from  Fedo_admin ");
			ResultSet  rs=ps.executeQuery();
			if(rs.next()) {
				user=""; create_p="";
				x=401;
				
			}else {
			int c=	Update_admin(user,create_p);
			if(c==200)
		    	x=201;
			else
				x=405;
			}
		}
			catch (Exception e) {
			
				System.out.println("U      "+e);
			x=404;
			}
			finally {
				try {
					cons.close();
				} catch (SQLException e) {
					
					System.out.println("V       "+e);
					x=300;
				}
			}
		return x;
	
   }



	private int Update_admin(String user, String create_p) {
		Connection  con=null;
		int c=0;
		
		try {
		con=new Connection_sql().getConnection();
		PreparedStatement  ps=con.prepareStatement("insert into   Fedo_admin(email,pass,time_stamp)  values (?,?,?)");
		ps.setString(1, user);
		ps.setString(2, create_p);
		ps.setString(3, time_save());
		c=200;
		ps.execute();
		
		}catch (Exception e) {
			
			System.out.println("W       "+e);
			c=407;
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
			
				System.out.println("X       "+e);
			c=300;
			}
		}
		return  c;
	
	}
	
	
	
	
    public  String time_save(){
        String o=null;
     ZonedDateTime z= ZonedDateTime.now();
     LocalTime time= LocalTime.now();
     int g=z.toString().indexOf("[");
     int c=z.toString().indexOf("]");
     int d=z.toString().indexOf("T");
     String q=z.toString().substring(g+1, c);
     for(String h : ZoneId.getAvailableZoneIds()){ 
       if(h.equals(q)){        
            o=(z.toString().substring(0,d).concat("     "+time.toString().substring(0, 5)));
             break; 
       }  }
 return  o;}
		

    public  String date_save(){
        String o=null;
     ZonedDateTime z= ZonedDateTime.now();
     int g=z.toString().indexOf("[");
     int c=z.toString().indexOf("]");
     int d=z.toString().indexOf("T");
     String q=z.toString().substring(g+1, c);
     for(String h : ZoneId.getAvailableZoneIds()){ 
       if(h.equals(q)){        
            o=(z.toString().substring(0,d));
             break; 
       } 
     }
 return  o;
 }





    
}
