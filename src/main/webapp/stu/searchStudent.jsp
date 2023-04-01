<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="addStudentForm.css">
<meta charset="ISO-8859-1">
<title>Search Student</title>


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
					<li ><a href="../stu/Library.jsp">Overview</a></li>
					<li ><a href="./addBook.jsp">New Books</a></li>
					<li><a href="./authentication.jsp">Issue Book</a></li>
					<li><a href="addStudentForm.jsp">Add Student</a></li>
					<li class="active"><a href="./searchStudent.jsp">Search Student</a></li>
					<li><a href="../main/logout">Log Out</a></li>
				</ul>
			</div>
			</div>
			</div>


	<form method="post" action="../main/searchStudent">
	
		<label for="name">Enter Student ID : </label> 
		<input type="text" name="sid" id="name" required="required">
	
		<br><br>
		<input type="submit" value="Get Student Details">
	</form>
</body>
</html>