<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="./issue.css" rel="stylesheet" type="text/css">
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
					<li class="active"><a href="./authentication.jsp">Issue Book</a></li>
					<li><a href="../student/issuedBooks">Return Book</a></li>
					<li><a href="../main/logout">Log Out</a></li>
				</ul>
			</div>
			</div>
			</div>
			
	<h1>Issue</h1>

	<form action="../student/issue" method="POST">
		<label for="author">Student Name :</label> 
		<input type="text"  value="${sName} " readonly> <br>
		<label for="author">Author Name :</label> 
		<input type="text" name="author" id="name" value="${param.author}"> <br> 
		<label for="title">Title Name :</label> 
		<input	type="text" name="title" id="rollNo" value="${param.title}"><br> 
		<label for="Category">Category Name :</label> 
		<input type="text" name="category" id="class" value="${param.category}">
		<br>
		<label> Librarian Name
		
		<select name="lid" style="width: 170px; text-align: center;">
							<c:forEach items="${librarian}" var="lib">
								<option value="${lib.lid}">${lib.name}</option>
							</c:forEach>
						</select>
		 </label>
		
						<br>
		<input type="submit" value="Issue Book">
		
	

	</form>
</body>
</html>