<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login To Database</title>
<style>
	h1{
		text-align: center;
	}
	form{
		box-shadow: 0 5px 15px #666;
		border: 1px solid #ddd;
		border-radius: 6px;
		padding: 10px 10px 10px;
		background-color: #fff;
		margin: 0 auto;
		width: 500px;
	}
	input{
		width: 100%;
	    padding: 12px 20px;
	    margin: 8px 0;
	    display: inline-block;
	    border: 1px solid #ccc;
	    border-radius: 4px;
	    box-sizing: border-box;
	}
	button[type=submit]{
		width: 100%;
		padding:10px;
	}

</style>
</head>
<body>
	<form action="DatabaseServlet">
		<h1>Java Enterprise - Assignment 1</h1>
		<fieldset>
			<label for="user">Username: </label> 
			<input type="text" id="user" name="user" placeholder="Your Username" value=${user} > <br>
			<label for="pass">Password: </label> 
			<input type="text" id="pass" name="pass" placeholder="Your Password" value =${pass}>
		</fieldset>
		<fieldset>
			<button type="submit">Login</button>
		</fieldset>
		<ul>${errorMessage}</ul>
	</form>
</body>
</html>