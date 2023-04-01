<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@ page import="com.ineuron.dto.Student"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Students</title>

	<!-- jQuery -->
	<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js">
	</script>
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
					<li class="active" ><a href="../main/allStudents">Students</a></li>
					<li><a href="#">Settings</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<br>
	<h1 class="hrlineone" style="text-align: center;">
		<u>Student List</u>
	</h1>


	<br>
	<br>
	<table border="1" cellspacing="2" cellpadding="2"
		style='margin-left: auto; margin-right: auto';>

		<tr>
			<th>Student ID</th>
			<th>Student Name</th>
			<th>Class</th>
			<th>Book Issued Count</th>
			<th>Roll No</th>
			<th>Delete</th>
		</tr>

		<%
			// Use an iterator to loop through the ArrayList
		List<Student> StudentAll = (List<Student>) request.getAttribute("allStudent");
		java.util.Iterator<Student> iterator = StudentAll.iterator();
		while (iterator.hasNext()) {
			Student currStudent = iterator.next();
		%>
		<tr>
			<td><%=currStudent.getsId()%></td>
			<td><%=currStudent.getsName()%></td>
			<td><%=currStudent.getsClass()%></td>
			<td><%=currStudent.getBookIssued()%></td>
			<td><%=currStudent.getsRollNo()%></td>
			<td><a href="../main/deleteStudentServlet?sid=<%=currStudent.getsId()%>&sname=<%=currStudent.getsName()%>">Delete</a></td>
		</tr>
		<%
			}
		%>
	</table>

	<br>
	<br>

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

</body>
</html>