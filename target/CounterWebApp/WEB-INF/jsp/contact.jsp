<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Spring 3 MVC Series - Contact Manager | viralpatel.net</title>
</head>
<body>
 
<h2>Contact Manager</h2>
 
<form:form method="post" action="add.html" commandName="userAddress">
 
    <table>
    <tr>
        <td><form:label path="name"><spring:message code="label.name"/></form:label></td>
        <td><form:input path="name" /></td> 
    </tr>
    <tr>
        <td><form:label path="password"><spring:message code="label.password"/></form:label></td>
        <td><form:input path="password" /></td>
    </tr>
    <tr>
        <td><form:label path="confirm"><spring:message code="label.confirm"/></form:label></td>
        <td><form:input path="confirm" /></td>
    </tr>
    <tr>
        <td><form:label path="email"><spring:message code="label.email"/></form:label></td>
        <td><form:input path="email" /></td>
    </tr>
    <tr>
        <td><form:label path="street1"><spring:message code="label.street1"/></form:label></td>
        <td><form:input path="street1" /></td> 
    </tr>
    <tr>
        <td><form:label path="street2"><spring:message code="label.street2"/></form:label></td>
        <td><form:input path="street2" /></td>
    </tr>
    <tr>
        <td><form:label path="city"><spring:message code="label.city"/></form:label></td>
        <td><form:input path="city" /></td>
    </tr>
    <tr>
        <td><form:label path="state"><spring:message code="label.state"/></form:label></td>
        <td><form:input path="state" /></td>
    </tr>
    <tr>
        <td><form:label path="country"><spring:message code="label.country"/></form:label></td>
        <td><form:input path="country" /></td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit" value="<spring:message code="label.addcontact"/>"/>
        </td>
    </tr>
</table>  
</form:form>
 
     
<h3>Contacts</h3>
<c:if  test="${!empty contactList}">
<table class="data">
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
 
</body>
</html>