<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form action = "${pageContext.request.contextPath}/singleaccount" modelAttribute="e">
	Enter user-Name: <form:input path="accId"/><br/>
	<button type = "submit">Save</button>
 	</form:form>
</body>
</html>