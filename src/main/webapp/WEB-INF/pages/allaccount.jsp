<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

<title>Banking Application</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">Banking Application</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarText">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="/">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="allaccount">All Accounts</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/xyz">Show Balance</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/withdraw">Withdraw</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/deposit">Deposit</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/add">Create A/c</a>
        </li>
      </ul>
      
    </div>
  </div>
</nav>
<br><br>
<center><h1>List Of All Accounts</h1></center>
<br>

<div class="mx-auto" style="width: 800px;">
<table class="table">
  <thead class="thead-dark">
    <tr>
      <th scope="col">Account No</th>
      <th scope="col">Balance </th>
      <th scope="col">Pin </th>
      <th scope="col">Account Holder</th>
    </tr>
 
	<c:forEach items="${list}" var="e">
		<tr>
			<td>${e.acctId}</td>
			<td>${e.balance}</td>
			<td>${e.pin}</td>
			<td>${e.accHolder}</td>
		</tr>
	</c:forEach>
	</thead>
</table>

</div>

		<div class="fixed-bottom" style="background-color:black; color:white;"><center><h3>Copyright @2022 </h3>
		 <p>Made by Nitil Singh with <span style="color:red;">&hearts; <span></p>
		</center>
		<br>

		</div>
</body>
</html>