<!DOCTYPE html>
<html>
<head>
	<title>Invalid Request</title>
	<style>
		body {
			background-color: #f5f5f5;
			font-family: Arial, sans-serif;
			font-size: 16px;
			line-height: 1.6;
			color: #333;
			margin: 0;
			padding: 0;
		}
		.container {
			max-width: 800px;
			margin: 50px auto;
			padding: 20px;
			background-color: #fff;
			border-radius: 10px;
			box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
		}
		h1 {
			font-size: 28px;
			font-weight: bold;
			margin-top: 0;
			margin-bottom: 20px;
			text-align: center;
		}
		p {
			margin-bottom: 20px;
			text-align: center;
		}
		button {
			display: block;
			margin: 0 auto;
			padding: 10px 20px;
			background-color: #4CAF50;
			color: #fff;
			border: none;
			border-radius: 5px;
			font-size: 16px;
			font-weight: bold;
			cursor: pointer;
			transition: background-color 0.2s;
		}
		button:hover {
			background-color: #3e8e41;
		}
	</style>
</head>
<body>
	<div class="container">
		<h1>Invalid Request</h1>
		<p>${output} </p>
		<button onclick="goBack()">Go Back</button>
	</div>
	
	<script>
		function goBack() {
			console.log("inside popup jsp");
			
			window.history.back();
			
						
			             
			
			
		}
	</script>
</body>
</html>
