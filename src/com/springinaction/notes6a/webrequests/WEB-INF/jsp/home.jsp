<%@ page contentType="text/html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<html>
  <head><title>Rantz</title></head>
  <body>
    <h2>Welcome to RoadRantz!</h2>
    <h3>Recent rantz:</h3>
    <ul>
    <c:forEach items="${rants}" var="rant">
    <li><c:out value="${rant.vehicle.state}"/> /
        <c:out value="${rant.vehicle.plateNumber}"/> --
        <c:out value="${rant.rantText}"/> 
    </li>
    </c:forEach>
    </ul>
  </body>
</html>