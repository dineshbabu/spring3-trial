<%@ page contentType="text/html" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<html>
  <head><title>Admin Console</title></head>
  <body>
    <h2>Welcome to Admin Console Home</h2>
    <h3>Home:</h3>
    <sf:form method="POST" modelAttribute="user" action="/spring3/login/register" enctype="multipart/form-data">
	
      <table>
  		   <tr>
  		   	   <td> First name:</td>
  		   	   <td> <input type="text" id="firstName"></input>
  		   	   <sf:errors path="firstName" cssClass="error" />
  		   	   </td>
  		   </tr>
		   <tr>
		   	   <td> Last name:</td>
  		   	   <td> <input type="text" id="lastName"></input>
  		   	   <sf:errors path="lastName" cssClass="error" />
  		   	   </td>
  		   </tr>
  		   <tr>
  		   	   <td> User name:</td>
  		   	   <td> <input type="text" id="userName"></input>
  		   	   <sf:errors path="userName" cssClass="error" />
  		   	   </td>
  		   </tr>
		   <tr>
  		   	   <td> email:</td>
  		   	   <td> <input type="text" id="email"></input>
  		   	   <sf:errors path="email" cssClass="error" />
  		   	   </td>
  		   </tr>
  		   <tr>
  		   	    <td> <input type="submit" id="LoginButton" value="Register"></input></td>
  		   </tr>
  	</table>
	
	</sf:form>
  </body>
</html>

<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<!--<div>
<h2>Create a free Spitter account</h2>

<sf:form method="POST" modelAttribute="user" action="/spring3/login/register"  enctype="multipart/form-data">         
   <fieldset> 
   <table cellspacing="0">
      <tr>
         <th><sf:label path="firstName">Full name:</sf:label></th>
         <td><sf:input path="firstName" size="15" /><br/>
             <sf:errors path="firstName" cssClass="error" />
         </td>
      </tr>
      <tr>
         <th><sf:label path="userName">Username:</sf:label></th>
         <td><sf:input path="userName" size="15" maxlength="15" />
              <small id="username_msg">No spaces, please.</small><br/>
             <sf:errors path="userName" cssClass="error" />

            </td>
      </tr>
      <tr>
         <th><sf:label path="lastName">Last Name:</sf:label></th>
         <td><sf:password path="lastName" size="30" 
                            showPassword="true"/> 
             <small>6 characters or more (be tricky!)</small><br/>
             <sf:errors path="lastName" cssClass="error" />
            </td>
      </tr>

      <tr>
         <th><sf:label path="email">Email Address:</sf:label></th>

         <td><sf:input path="email" size="30"/> 
             <small>In case you forget something</small><br/>
             <sf:errors path="email" cssClass="error" />
            </td>
      </tr>
      <tr>
  		   	    <td> <input type="submit" id="LoginButton" value="Register"></input></td>
  		   </tr>
   </table>
</fieldset>
</sf:form>
</div>-->
