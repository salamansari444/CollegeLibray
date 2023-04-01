<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Issued</title>
<!-- jQuery -->
	<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js">
	</script>
<!-- Bootstrap CSS -->



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
<body class="container">
	<table class="center">
		<tr style="font-style: italic;">
			<th><h1>Author</h1></th>
			<th><h1>Title</h1></th>
			<th><h1>Category</h1></th>
			<th><h1>Issued Date</h1></th>
			<th><h1>Return</h1></th>
		</tr>
		<c:forEach var="books" items="${issuedBooks}">

			<c:url var="returnBook" value="../student/return">
		
				<c:param name="author" value="${books.author}" />
				<c:param name="title" value="${books.title}" />
				<c:param name="category" value="${books.category}" />
				<c:param name="issue_date" value="${books.issue_date}" />
			</c:url>
			<tr>
				<td><h1>${books.author}</h1></td>
				<td><h1>${books.title}</h1></td>
				<td><h1>${books.category}</h1></td>
				<td><h1>${books.issue_date}</h1></td>
				<td><h1>
						click<a href="${returnBook}" style="color: maroon;">here</a>
					</h1></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>