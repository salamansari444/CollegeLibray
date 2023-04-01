<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Menu</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js">
	</script>


<style type="text/css">
table {
	border-collapse: collapse;
	width: 100%;
	font-size: 16px;
	font-family: Arial, sans-serif;
}

th, td {
	padding: 12px;
	text-align: left;
}

tr:nth-child(even) {
	background-color: #f2f2f2;
}

th {
	background-color: #a98838;
	color: white;
}

td.highlight {
	font-weight: bold;
}

td.warning {
	color: red;
}

.hrlineone {
    display: block;
    margin: auto;
    width: 440px;
    padding: 1px 0px;
    border: none;

}

h1{
text-align: center;
    font-size: 30px;
    font-family: 'Baloo Bhaina 2', cursive;

}


</style>
</head>

<body>
	<c:set var="sName" value="${sessionScope.sName}" />

	<!-- Navbar -->
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#myNavbar">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="../stu/Library.jsp">Library Admin Dashboard</a>
			</div>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav">
					<li class="active"><a href="../stu/Library.jsp">Home</a></li>
					<li><a href="../main/allBooks">Books</a></li>
					<li><a class="active" href="../main/allStudents">Students</a></li>
					<li><a href="#">Settings</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<!-- main content -->
	<div class="container-fluid">
		<div class="row">
			<!-- side navbar -->
			<div class="col-sm-3 col-md-2 sidebar">
				<ul class="nav nav-sidebar">
					<li><a href="../stu/Library.jsp">Overview</a></li>
					<li class="active"><a href="./stu/issue.jsp?sName=${sName }">Issue Book</a></li>
					<li><a href="./student/issuedBooks">Return Book</a></li>
					<li><a href="../main/logout">Log Out</a></li>
				</ul>
			</div>
		</div>
	</div>
	
         
	<h1 class="hrlineone">Books World , ${sName}</h1>
	
</body>
</html>