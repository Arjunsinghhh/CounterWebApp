<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Contacts Success</title>
    <script type="text/javascript" src="./WEB-INF/app.js"></script>
     <script type="text/javascript" src="./WEB-INF/AuthenticationController.js"></script>
      <script type="text/javascript" src="/WEb-INF/AuthenticationForm.js"></script>
       <script type="text/javascript" src="/WEb-INF/Viewport.js"></script>
</head>
<body>
<center>
     
<h3>Contacts</h3>
<c:if  test="${!empty contactList}">
<table border=1 class="data">
<tr>
    <th>Name</th>
    <th>Email</th>
    <th>Telephone</th>
    <th>&nbsp;</th>
</tr>
<c:forEach items="${contactList}" var="userAddress">
    <tr>
        <td>${userAddress.name}, ${userAddress.password} </td>
        <td>${userAddress.email}</td>
        <c:forEach items="${userAddress.address}" var="addr">
           <tr><td>${addr.street1}</td></tr>
         </c:forEach>
       
        <td><a href="delete/${contact.id}">delete</a></td>
    </tr>
</c:forEach>
</table>
</c:if>
</center>
</body>
</html>