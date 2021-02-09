<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ page import="logic.*"%>
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
							
							
				<div  class="nav_review2" id="slider2c">
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
								
				
					
				<div  class="container">
				
					
				
				
				
					
				
				</div>
				
</body>
</html>