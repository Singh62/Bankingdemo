<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1> List of All Accounts</h1>
<br><br>
<a href="/">Home</a>
<table border="1">
	<tr>
			<th>Account No: </th>
			<th> Balance : </th>
			<th> Pin :</th>
			<th> Account Holder : </th>
	</tr>
	
	<c:forEach items="${list}" var="e">
		<tr>
			<td>${e.acctId}</td>
			<td>${e.balance}</td>
			<td>${e.pin}</td>
			<td>${e.accHolder}</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>