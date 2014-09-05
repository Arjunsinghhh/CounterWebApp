<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Contacts</title>
    <script type="text/javascript" src="./WEB-INF/app.js"></script>
     <script type="text/javascript" src="./WEB-INF/AuthenticationController.js"></script>
      <script type="text/javascript" src="/WEb-INF/AuthenticationForm.js"></script>
       <script type="text/javascript" src="/WEb-INF/Viewport.js"></script>
       <style>
.error {
    color: #ff0000;
    font-style: italic;
    font-weight: bold;
}
</style>
</head>
<body>
 <center>
<h2>Contact Manager</h2>
 
<form:form method="post" action="add.html" commandName="userAddress">
 
    <table>
    <tr>
        <td><form:label path="name"><spring:message code="label.name"/></form:label></td>
        <td><form:input path="name" /></td> 
        <td><form:errors path="name" cssClass="error"></form:errors></td>
    </tr>
    <tr>
        <td><form:label path="password"><spring:message code="label.password"/></form:label></td>
        <td><form:input path="password" /></td>
        <td><form:errors path="password" cssClass="error"></form:errors></td>
    </tr>
    <tr>
        <td><form:label path="confirm"><spring:message code="label.confirm"/></form:label></td>
        <td><form:input path="confirm" /></td>
        <td><form:errors path="confirm" cssClass="error"></form:errors></td>
    </tr>
    <tr>
        <td><form:label path="email"><spring:message code="label.email"/></form:label></td>
        <td><form:input path="email" /></td>
        <td><form:errors path="email" cssClass="error"></form:errors></td>
    </tr>
    <tr>
        <td><form:label path="street1"><spring:message code="label.street1"/></form:label></td>
        <td><form:input path="street1" /></td> 
        <td><form:errors path="street1" cssClass="error"></form:errors></td>
    </tr>
    <tr>
        <td><form:label path="street2"><spring:message code="label.street2"/></form:label></td>
        <td><form:input path="street2" /></td>
        <td><form:errors path="street2" cssClass="error"></form:errors></td>
    </tr>
    <tr>
        <td><form:label path="city"><spring:message code="label.city"/></form:label></td>
        <td><form:input path="city" /></td>
        <td><form:errors path="city" cssClass="error"></form:errors></td>
    </tr>
    <tr>
        <td><form:label path="state"><spring:message code="label.state"/></form:label></td>
        <td><form:input path="state" /></td>
        <td><form:errors path="state" cssClass="error"></form:errors></td>
    </tr>
    <tr>
        <td><form:label path="country"><spring:message code="label.country"/></form:label></td>
        <td><form:input path="country" /></td>
        <td><form:errors path="country" cssClass="error"></form:errors></td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit" value="<spring:message code="label.addcontact"/>"/>
        </td>
    </tr>
</table>  
</form:form>
 
</center>
 
</body>
</html>