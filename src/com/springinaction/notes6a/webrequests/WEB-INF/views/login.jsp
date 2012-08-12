<%@ page contentType="text/html" %>
<html>
  <head><title>Admin Console</title></head>
  <body>
    <h2>Welcome to Admin Console</h2>
    <h3>Login:</h3>
	<form id="loginform" action="/spring3/login/authenticate" method="POST">
      <table>
  		   <!-- <tr>
  		   	   <td> First name:</td>
  		   	   <td> <input type="text" name="firstname"></input></td>
  		   </tr>
		   <tr>
		   	   <td> Last name:</td>
  		   	   <td> <input type="text" name="lastname"></input></td>
  		   </tr>-->
  		   <tr>
  		   	   <td> User name:</td>
  		   	   <td> <input type="text" name="username"></input></td>
  		   </tr>
  		   <tr>
  		   	   <td> Password:</td>
  		   	   <td> <input type="password" name="password"></input></td>
  		   </tr>
		   <!--<tr>
  		   	   <td> email:</td>
  		   	   <td> <input type="text" name="email"></input></td>
  		   </tr>-->
  		   <tr>
  		   	    <td> <input type="submit" id="LoginButton" value="Login"></input></td>
  		   </tr>
  	</table>
	</form>
  </body>
</html>