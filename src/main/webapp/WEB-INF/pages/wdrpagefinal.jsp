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
<h1> withdraws final page </h1>

<table border="1">
	<tr>
			<th>Account No: </th>
			<th> Balance : </th>
			<th> Type : </th>
	</tr>
	<c:forEach items="${final}" var="e">
		<tr>
			<td>${final.acctId}</td>
			<td>${final.balance}</td>
			<td>${final.acctStatus}</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>