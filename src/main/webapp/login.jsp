<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Login - Pentagon Space</title>
    <style>
        body { 
        	font-family: Arial, sans-serif;
        	text-align: center; 
        	background: #f9f9f9; 
        	}
        header { 
        	font-size: 36px; 
        	color: #4B4BFF; 
        	margin-top: 40px; 
        }
        form { 
        	background: white; 
        	padding: 30px; 
        	margin: 50px auto; 
        	width: 400px; 
        	border-radius: 8px; 
        	box-shadow: 0 0 10px #ccc; 
        }
        label { 
        	display: block; 
        	text-align: left; 
        	margin-bottom: 5px; 
        	font-size: 18px; 
        }
        input[type="email"], input[type="password"] { 
        	width: 100%; 
        	padding: 10px; 
        	margin-bottom: 15px; 
        	border: 1px solid #ccc; 
        	border-radius: 5px; 
        }
        input[type="submit"] { 
        	background: green; 
        	color: white; 
        	padding: 10px; 
        	border: none; 
        	width: 100%; 
        	font-size: 18px; 
        	border-radius: 5px; 
        	cursor: pointer; 
        }
        input[type="submit"]:hover { 
        	background: darkgreen; 
        }
        .links { 
        	margin-top: 10px; 
        }
        a { 
        	text-decoration: none; 
        	color: blue; 
        }
        .success{
        color:green;
        }
    </style>
</head>
<body>
    <header>Pentagon Space</header>
    <%if(request.getAttribute("success")!=null){%>
    <h3 class="success"><%=request.getAttribute("success")%></h3>
    <%}%>
    <%if(request.getAttribute("error")!=null){%>
    <h3 class="failure"><%=request.getAttribute("error")%></h3>
    <%}%>
    <form action="login" method="post">
        <h2>Login</h2>
        <label>Enter your mail ID:</label>
        <input type="email" name="username" required>
        <label>Enter the password:</label>
        <input type="password" name="password" required>
        <input type="submit" value="Login">
        <div class="links">
            <a href="password.jsp">Forgot password?</a><br>
            Don't have an account? <a href="signup.jsp">Signup</a>
        </div>
    </form>
</body>
</html>
