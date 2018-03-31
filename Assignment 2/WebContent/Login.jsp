<!-- 
	Login JSP
	2/9/18
 -->

<%@ page language="java" contentType="text/html; charset=UTF8"
	pageEncoding="ISO-8859-1"%>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Login To Database</title>

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>

    <body>
        <div class="panel panel-primary">
            <div class="panel-heading">
                <h1>Java Enterprise - Assignment 2</h1></div>
            <div class="panel-body">

                <form action="LoginServlet" method="POST">
                    <div class="form-group">
                        <label for="username">Email address</label>
                        <input class="form-control" type="text" id="username" name="username" placeholder="Username" value=${username}>
                    </div>
                    <div class="form-group">
                        <label for="password">Password</label>
                        <input type="password" class="form-control" id="password" placeholder="Password" name="password" value=${password}>
                    </div>

                    <button type="submit" class="btn btn-default">Login</button>
                </form>
            </div>
            <div class="panel-footer">
                <ul>${errorMessage}</ul>
            </div>
        </div>
    </body>

    </html>