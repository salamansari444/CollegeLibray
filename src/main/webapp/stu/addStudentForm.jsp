<html>
<head>
<title>Student Form</title>
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
					<li><a href="./authentication.jsp">Issue Book</a></li>
					<li class="active"><a href="addStudentForm.jsp">Add Student</a></li>
					<li><a href="./searchStudent.jsp">Search Student</a></li>
					<li><a href="../main/logout">Log Out</a></li>
				</ul>
			</div>
			</div>
			</div>


	<h1>Student Form</h1>
	<form method="post" action="../main/addStudent">
		<label for="name">Name:</label> <input type="text" name="name"
			id="name" required><br> <label for="rollNo">Roll No:</label> <input
			type="text" name="rollNo" id="rollNo" required><br> <label
			for="class">Class:</label> <input type="text" name="class" id="class" required><br>
		<input type="submit" value="Add Student">
	</form>
</body>
</html>
