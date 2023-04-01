<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Authentication</title>

<link rel="stylesheet" href="addStudentForm.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">



<link rel="stylesheet" type="text/css" href="lib.css">


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
				<a class="navbar-brand" href="#">Library Admin Dashboard</a>
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
					<li ><a href="../stu/Library.jsp">Overview</a></li>
					<li ><a href="./addBook.jsp">New Books</a></li>
					<li class="active"><a href="./authentication.jsp">Issue Book</a></li>
					<li><a href="addStudentForm.jsp">Add Student</a></li>
					<li ><a href="./searchStudent.jsp">Search Student</a></li>
					<li><a href="../main/logout">Log Out</a></li>
				</ul>
			</div>
			</div>
			</div>
<h1>Authenticate Student First</h1>
	<form action="../student" method="POST">

		
	
		<label for="author">Enter Name :</label> 
		<input type="text" name="sName" id="name"><br> 
		<label for="title">Enter Roll No :</label> 
		<input	type="text" name="sRollNo" id="rollNo"><br> 
		<label for="Category">Enter Class :</label> 
		<input type="text" name="sClass" id="class">
		<br>
		
		<input type="submit" value="Validate Student">


	</form>
</body>
</html>