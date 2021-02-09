 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="logic.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign in</title>
<meta name="viewport" content="width=device-width, initial-scale=1"/>


	
<style>
		*{
			padding:0px;
			margin:0px;
		}
		
	 .base{
		background:#2554FF;
		height: auto;
		width: 100%;
		padding-bottom: 20px;
		
		}

		.tops{
		height: 80px;
		width: 100%;
		background: #fff;
		box-shadow: 0px 4px 8px 0 rgba(0,0,0,0.3);  
		}
		
		.bot{
		height: 80px;
		width: 18%;
		background: #fff;
		float: right;
		
		}
		
			
		
		.out{
		font-family:sans-serif;
		font-size: 1.5em;
		color:#fff;
		float: left;
		margin-left: 20px;
		margin-top: 200px;
		max-width: 300px;
		width: 300px;
		
		
		}
	
		.Sign_in{
			display: inline-block;
			border: 2px solid #2554FF;
			border-radius: 5px;
			background: #fff;
			margin: 5px;
			text-align: center;
			font-family: sans-serif;
			font-size: 1.5em;
			font-weight: 300;
			color:#2554FF;
		
		}
		
			h4{
		font-family:sans-serif;
		font-size: 1.5em;
		font-weight: 200;
		text-align: center;
		}
		
		
			.Sign_up{
			display: inline-block;
			border-radius: 5px;
			background: #fff;
			margin: 5px;
			text-align: center;
			font-family: sans-serif;
			font-size: 1.5em;
			font-weight: 300;
			color:#2554FF;
		
		}
		
		
    	.login_form{
		margin-left: auto;
		margin-right: auto;
		height: auto;
		width: 40%;
		padding:20px;
		background: #fff;
		margin-top: 50px;
		border-radius: 7px;
		box-shadow: 0px 4px 8px 0 rgba(0,0,0,0.3);  
		
		}
		
		
		
		a:hover {
			text-decoration: none;
		}


		a{
		text-decoration: none;
		}
		
		
		#up{
		padding: 5px;
		}
		
		
		table{
		
		margin-left: auto;
		margin-right: auto;
		width: 70%;
		}
		
		h5{
		
		font-family: sans-serif;
		margin: 5px;
		float: left;
		}
		
		
		.ins{
			border-radius: 5px;
			padding: 10px;
			border: 2px solid #707070;
			width: 100%;
			height: 20px;
		}
		
		
		#btns{
				background: #343A41;
				border-radius: 5px;
				padding: 10px;
				width: 107%;
				font-family:sans-serif;
				color:#fff;
				cursor: pointer;
		}
		
			#forgot{
				border-radius: 5px;
				padding: 5px;
				width: 35%;
				font-family:sans-serif;
				color:#2554FF;
				cursor: pointer;
				float: right;
				margin-right: -40px;

		}
		
		
	
		
  		@media(max-width:980px){
  		
  		
  			
		.base{
		width: 100%;
		overflow-x: hidden;
		height: 750px;
		}
		
    	.tops{
		height: 60px;  
		}
		
 	   .login_form{
		width: 80%;
		margin-top: 80px;
		
		}
		
		table{

		margin-right: 17%;
		}
  		
  		.bot{
		height: 60px;
		width: 40%;
		
		}
		
				
	  .Sign_up{
			font-size: 1em;
			}
		
		
		
		.Sign_in{
			font-size: 1em;
		
		}
		
			.out{
		font-family:sans-serif;
		font-size: 1.5em;
		color:#fff;
		float: none;
		margin-left: auto;
		margin-right:auto;
		margin-top: 20px;
		width: 100%;
		text-align: center;
		
		
		}
		

		
  		}
		
		
		
		
</style>
</head>
<body>


	       <div  class="base">
			<div  class="tops">
			
			
			
			
			
			
			
		   <div  class="bot">
				<a  id="up" href=""  class="Sign_up"> Sign in</a>
				<a  id="up"  href=""  class="Sign_in"> Sign up</a>
				</div>
			</div>
	
	
	          <form   method="post"  action="sendu">
	
				 <h5 class="out">${er}</h5>
				  <div  class="login_form">
				
					<br/><br/><br/><br/>
					<table>
					<tr>
					<td>
					<h4>Sign In</h4>
					<br/>
					</td>
					</tr>
					
				    <tr>
					<td>
					  <h5>Create Password</h5>
					</td>
					</tr>
					<tr>
					<td>
					<input  name="create_pass"  class="ins">
					
					</td>
					</tr>
					
					<tr>
					<td>
					<br/><br/>
					  <h5>Email address</h5>
					</td>
					</tr>
					<tr>
					<td>
					<input  name="user_email"  class="ins">
					
					</td>
					</tr>
					
					
					<tr>
					<td>
					<br/><br/>
					  <h5>Password</h5>
					</td>
					</tr>
					<tr>
					<td>
					<input  name="pass" class="ins">
					</td>
					</tr>
					
					
					<tr>
					<td>
					<br/><br/>
					<button  id="btns">Sign in</button>
					</td>
					</tr>
					
					
					
					<tr>
					<td>
					<br/><br/>
					<a  id="forgot">Forgot Password</a>
					</td>
					</tr>
					</table>
				
				</div>
	</form>
	</div>
	
	<script>
	$.getJSON('https://api.ipify.org?format=json&callback=?', function(data){
		let s= JSON.stringify(data, null, 2);
		console.log(s);
		var ls= <%=new User().api()%>
		
		$.getJSON('https://api.ipgeolocation.io/ipgeo?apiKey='+ls,
				function(data){
			let c= JSON.stringify(data, null, 2);
			console.log(c);
		
		
	});

</script>
	
</body>
</html>