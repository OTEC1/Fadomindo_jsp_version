<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ page import="logic.*"%>
         <%@page import="sQL_con.Connection_sql"%>
         <%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1"/>
<link rel="stylesheet"   href="css/style1.css"></link>

<title>Fadomindo</title>

</head>
<body>


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
			
				<div  class="nav_review1">
					
							
							
					<%
					int id=Integer.valueOf(request.getParameter("id"));	
					int d=	Integer.parseInt(new User().recent());
						if(d!=0){
							%>
							
						<div    class="view1">
									<a    href="
									
									<%if(id==0){%>
										index.jsp

										<%}else {%>
										recent.jsp?id=<%=id%>
									 <%} %>
									 "class="h7">
									      <%=new User().nav_list()[id]%>  
									      
									</a >
						</div>
					
							
						</div>	
							
							
				<div  class="nav_review2" id="slider2a">
					<div  class="sli">
					

							<%
							int x;
							for( x=0; x<d; x++){%>
							
							<div  id="<%=x%>"  class="all1">
									<a  href="
										<%if(x==0){%>
										index.jsp
										<%}else {%>
									  recent.jsp?id=<%=x%>
									 <%} %>
									
									     "class="h8">
									      <%=new User().nav_list()[x]%>
									</a>
							</div>

								<%}}%>
								</div>
					  </div>
								
				
					
				<div  class="container"     id="style-1" >
				
				
				<br/>	<br/>	<br/>	<br/>
					<br/>	<br/>	<br/>	<br/>
				<div  class="ad_space">
					Ad Space
				</div>
				
				<div  class="widget_player">
				
				
					 <%
					 		int page1=Integer.valueOf(request.getParameter("p"));	
							Connection c1 = null;
							PreparedStatement s1 = null;
							ResultSet rs = null;
							try{
							c1 = new Connection_sql().getConnection();
							//where cats like '%Main display%' and id>=9 
							s1=c1.prepareStatement("select  file_path from  home_views    where id="+page1);
							rs = s1.executeQuery();
							while(rs.next()){
							%>
					
					  <video  controls  autoplay   loop="loop"     class="video_display"   >    
							            <SOURCE src="Resources/<%=rs.getString("file_path")%>"   type="video/mp4"/>
			          </video>
				
				
						
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