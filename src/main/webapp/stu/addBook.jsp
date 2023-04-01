<html>
<head>
<title>Book Form</title>
<link rel="stylesheet" href="addStudentForm.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">



<link rel="stylesheet" type="text/css" href="lib.css">


</head>
<body>
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
					<li><a href="../stu/Library.jsp">Overview</a></li>
					<li class="active"><a href="./addBook.jsp">New Books</a></li>
					<li><a href="./authentication.jsp">Issue Book</a></li>
					<li><a href="addStudentForm.jsp">Add Student</a></li>
					<li><a href="./searchStudent.jsp">Search Student</a></li>
					<li><a href="../main/logout">Log Out</a></li>
				</ul>
			</div>
		</div>
	</div>






	<h1>Book Form</h1>
	<form method="post" action="../main/addBook">
		<label for="author">Author Name :</label> 
		<input type="text"
			name="author" id="name" required><br> <label for="title">Title
			:</label> <input type="text" name="title" id="rollNo" required><br> <label
			for="Category">Category :</label> <input type="text" name="category"
			id="class" required> <br> <label for="quantity">Quantity
			of Book :</label> <input type="text" name="quantity" id="class" required> <br>
		<input type="submit" value="Add Book">
	</form>
</body>
</html>
