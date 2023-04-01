<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false" import="com.ineuron.dto.Student" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student</title>

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<link rel="stylesheet" type="text/css" href="lib.css">

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
<!-- nav bar -->
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
					<li><a href="../stu/Library.jsp">Home</a></li>
					<li><a href="../main/allBooks">Books</a></li>
					<li ><a href="../main/allStudents">Students</a></li>
					<li><a href="#">Settings</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<h1 class="hrlineone"></h1>
	<table class="center">
		<tr style="font-style: italic;">
			<th><h1>Student ID</h1></th>
			<th><h1>Student Name</h1></th>
			<th><h1>Student Class</h1></th>
			<th><h1>Roll No</h1></th>
						<th><h1>Book Issued</h1></th>
			
		</tr>
		<tr>


			
		
			<td> <c:out value="${student.sId}" /></td>
			<td> <c:out value="${student.sName}" /></td>
			<td> <c:out value="${student.sClass}" /></td>
			<td> <c:out value="${student.sRollNo}" /></td>
			<td> <c:out value="${student.bookIssued}" /></td>


		</tr>
		
		
		
	</table>
	
	
</body>
</html>