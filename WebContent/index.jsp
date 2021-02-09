<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
		    pageEncoding="ISO-8859-1"%>
  <%@ page import="logic.*"%>
  <%@ page import="java.sql.*" %>
  <%@page import="sQL_con.Connection_sql"%>
		<!DOCTYPE html>
		<html>
		<head>
		<meta charset="ISO-8859-1">
		<title>Fadomindo</title>

		<meta name="viewport" content="width=device-width, initial-scale=1"/>
		<link rel="stylesheet"   href="css/style1.css"></link>
		</head>
		<body>
						<div class="same">
				            <div  class="top-nav">
				                <div class="tops">
					            	<span></span>
					            	<span></span>
					            	<span></span>
				            	</div>
						        
						              <img alt="icon" class="search"  src="Resources/Searching.png">
									 <a href="index.jsp">
									  <h4  alt="Fedomindo logo" class="logo" >Fedomindo</h4>
									</a>
							</div>
							
							<div   class="nav_review"  id="slider2a">
							<div  class="sli">
							<%
							int a=Integer.parseInt(new User().home()),b,e;
							for(b=0; b<a; b++) 
							   	{
								%>
							
							<%if(a!=0){ %>
								<div  id="<%=b%>"  class="all">
										<a  href="
										<%if(b==0) {%>
											index.jsp
										
										<%}
										else{
										%>
								       	recent.jsp?id=<%=b%>
									<%
										}
									%>
										"class="h6">
									    	<%=new User().nav_list()[b] %>
										</a>
								</div>
								
					
								
								<script type="text/javascript">
								
									var c=<%=b%>
									
									for(let d=0; d<=c; d++)
											iterate(d)
 									function iterate(x) {	
											let color1 = ["#5ADE0F","#EEEFEA"];
											let div1=document.getElementById(<%=b%>);
											div1.style.backgroundColor=color1[x];
										}
							
								</script>
											<%  } }	%>
								
							  </div>
							  </div>
							  
							  <br/> <br/> <br/>
							   <br/> <br/> <br/>
							    <br/> <br/> <br/>
							     <br/> <br/> <br/>
							      
								<div   class="banner "    id="slider">
										<div  class="slide">
										
										 <%
									//End Point
									String url="https://fedobucket.s3.eu-west-3.amazonaws.com/",xe,xr;
								
									Connection c2 = null;
									PreparedStatement s2 = null;
									ResultSet r1 = null;
									
									try{
									c2= new Connection_sql().getConnection(); //where cats like '%Top display%' 
									s2=c2.prepareStatement("select * from  Home_views where cats like '%Top display%'  order by id desc");
									r1 = s2.executeQuery();
									while(r1.next()){
							
									%>
										<a    href="
										<%
												xr=r1.getString(6);    xe=r1.getString(2);
												
											int r,u=0;
										 for(r=0; r<new User().nav_list().length; r++)
											 if(xr.equalsIgnoreCase(new User().nav_list()[r]))
													 u=r;
										 if(xe.substring(xe.indexOf('.')+1).equals("png")){
										   %>
										view.jsp?id=<%=u%>&p=<%=(r1.getString(1))%>
										<%}else{%>
											video.jsp?id=<%=u%>&p=<%=(r1.getString(1))%>
										<%}%>
											">
											
											
									<div class="inner1">	
										
										<%
										if(xe.substring(xe.indexOf('.')+1).equals("png")){
										%>
										<img alt=""   src="<%=url.concat(r1.getString(2))%>"   class="top_display"/>
									
									   <%
										}else
										{
								    	%>
									  <video   autoplay   loop="loop" muted    class="top_display"  controls="controls"  >    
							            <SOURCE src="<%=url.concat(r1.getString(2))%>"    type="video/mp4"  />
							            </video>
									   <%}
										%>
	
													<div class="h5"   id="style-1"> 
													User: <%=r1.getString(3)%>
													</div>
												</div>
											</a>
											
								<% 
							
									}
									} catch
									(Exception es) {es.printStackTrace();
									}
									finally{ 
										try{ 
											c2.close(); 
											}
										catch(Exception  es)
										{es.printStackTrace();
									}} 
								%>
										</div>
								</div>
									
									
									
							 <br/> 
							<div  class="container"   id="style-1">
						
							 <%
				
							Connection c1 = null;
							PreparedStatement s1 = null;
							ResultSet rs = null;
							
							
						   
					
							
							try{
							c1 = new Connection_sql().getConnection(); //where cats like '%Main display%' 
							s1=c1.prepareStatement("select * from  Home_views where cats like '%Main display%'    order by id desc");
							rs = s1.executeQuery();
							int s=0,p=0;
							while(rs.next()){
							%>
							      <%
							      s++;
									if(s==1)	p=390;
									else if(s==2) p=370;	
										else if(s==3)	p=300;	
										else if(s==4){ p=350;	
													s=0;	}
									%>
			
					<a href="
									<%
										String e1=rs.getString(6); 
										String		xs=rs.getString(2);    
										int e2,e3=0;
										
						for(e2=0; e2<new User().nav_list().length; e2++)	
						if(e1.equalsIgnoreCase(new User().nav_list()[e2]))
						e3=e2;
						if(xs.substring(xs.indexOf('.')+1).equals("png")){
						%>
						view.jsp?id=<%=e3%>&p=<%=(rs.getString(1))%>
					    <%}else{%>
						video.jsp?id=<%=e3%>&p=<%=(rs.getString(1))%>
						<%}%>
						">
						<div  
						
													style="box-shadow: 0px 20px 30px 
													 rgba(0,0,0,0.2);
						 							height: 300px;width:<%=p%>px;
						 							margin: 10px;
						 							display: inline-flex;
						 							 background:#fff">
						
										
						<%	
						if(xs.substring(xs.indexOf('.')+1).equals("png")){
						%>
						<img alt=""   src="<%=url.concat(xs)%>"  class="top_display"/>
					
					   <%}else{%>
									  <video      autoplay   loop="loop" muted    class="top_display" >    
							            <SOURCE src="<%=url.concat(rs.getString(2))%>"    type="video/mp4"/>
							            </video>
						<%}%>

										<div class="h5"  id="style-1">
												<%=rs.getString(3) %>
										</div>
										
						</div>
					</a>

								<% 
									}
									} catch
									(Exception es) {es.printStackTrace();
									}
									finally{ 
										try{ 
											c1.close(); 
											}
										catch(Exception  es)
										{es.printStackTrace();
									}} 
								%>	 
						
					
							</div> 
				           
				           </div>
				     

		</body>
		
			<div  class="footer">

			</div>
	
	
		</html>

