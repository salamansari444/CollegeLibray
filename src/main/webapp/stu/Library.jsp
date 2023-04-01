<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>Library Page</title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">



<link rel="stylesheet" type="text/css" href="lib.css">

<style>
body {
	
}
</style>

</head>
<body>
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
					<li class="active"><a href="#">Home</a></li>
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
					<li class="active"><a href="../stu/Library.jsp">Overview</a></li>
					<li><a href="./addBook.jsp">New Books</a></li>
					<li><a href="./authentication.jsp">Issue Book</a></li>
					<li><a href="addStudentForm.jsp">Add Student</a></li>
					<li><a href="./searchStudent.jsp">Search Student</a></li>
					<li><a href="../main/logout">Log Out</a></li>
				</ul>
			</div>
			</div>
			</div>
	<c:set var="students" value="${totalStudent}" />
			<!-- main content area -->
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<h1 class="page-header">Dashboard</h1>
				<div class="row placeholders">
					<div class="col-xs-6 col-sm-3 placeholder">
						<h4>Total Books</h4>
						<span class="text-muted">500</span>
					</div>
					<div class="col-xs-6 col-sm-3 placeholder">
						<h4>New Books</h4>
						<span class="text-muted">20</span>
					</div>
					<div class="col-xs-6 col-sm-3 placeholder">
						<h4>Total Students</h4>
						<span class="text-muted">200</span>
					</div>
					<div class="col-xs-6 col-sm-3 placeholder">
						<h4>User</h4>
						<span class="text-muted">200</span>
					</div>
				</div>
				</div>

				
</body>
</html>