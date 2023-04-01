<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.List"%>
<%@ page import="com.ineuron.dto.Book"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Books</title>
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
					<li ><a href="../stu/Library.jsp">Home</a></li>
					<li class="active" ><a href="../main/allBooks">Books</a></li>
					<li><a href="../main/allStudents">Students</a></li>
					<li><a href="#">Settings</a></li>
				</ul>
			</div>
		</div>
	</nav>


<br/>

	<h1 class="hrlineone" style="text-align: center;">
		Books Available in Library
	</h1>


	<br>
	<br>
	<table border="1" cellspacing="2" cellpadding="2"
		style='margin-left: auto; margin-right: auto';>

		<tr>
			<th>Book ID</th>
			<th>Author Name</th>
			<th>Title</th>
			<th>Category</th>
			<th>Total Books</th>
			<th>Present Books</th>
			<th>Delete</th>
		</tr>
		<%
			// Use an iterator to loop through the ArrayList
		List<Book> bookAll = (List<Book>) request.getAttribute("allBook");
		java.util.Iterator<Book> iterator = bookAll.iterator();
		while (iterator.hasNext()) {
			Book currBook = iterator.next();
		%>

		<tr>
			<td><%=currBook.getBid()%></td>
			<td><%=currBook.getAuthor()%></td>
			<td><%=currBook.getTitle()%></td>
			<td><%=currBook.getCategory()%></td>
			<td><%=currBook.getTotalBooks()%></td>
			<td><%=currBook.getPresentBooks()%></td>
			<td><a href="../main/deleteBookServlet?bid=<%=currBook.getBid()%>&bname=<%=currBook.getAuthor()%>">Delete</a></td>
		</tr>
		<%
			}
		%>
		
		
	
</body>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js">
	
</script>

<script type="text/javascript">
	window.onload = function() {
		  window.onpageshow = function(event) {
		    if (event.persisted) {
		      location.reload(true);
		    }
		  };
		};

	</script>

</html>