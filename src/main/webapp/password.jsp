<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Reset Password - Pentagon Space</title>
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
        	width: 450px; 
        	border-radius: 8px; 
        	box-shadow: 0 0 10px #ccc; 
        }
        label { 
        	display: block; 
        	text-align: left; 
        	margin-bottom: 5px; 
        	font-size: 18px; 
        }
        input { 
        	width: 100%; 
        	padding: 10px;
        	margin-bottom: 15px; 
        	border: 1px solid #ccc; 
        	border-radius: 5px; 
        }
        .btn { 
        	display: flex; 
        	justify-content: space-between; 
        }
        input[type="submit"], button { 
        	background: green; 
        	color: white; 
        	padding: 10px; 
        	border: none; 
        	width: 48%; 
        	font-size: 18px; 
        	border-radius: 5px; 
        	cursor: pointer; 
        }
        input[type="submit"]:hover { 
        	background: darkgreen; 
        }
        button { 
        	background: blue; 
        }
        button:hover { 
        	background: darkblue; 
        }
        .failure{
        	color:red;
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
    <form action="password" method="post">
        <h2>Reset your password here</h2>
        <label>Enter the Phone number:</label>
        <input type="text" name="phone" required>
        <label>Enter the Mail ID:</label>
        <input type="email" name="mail" required>
        <label>Enter the Password:</label>
        <input type="password" name="password" required>
        <label>Confirm the Password:</label>
        <input type="password" name="confirm" required>
        <div class="btn">
            <input type="submit" value="Reset Password">
            <button type="button" onclick="window.location.href='login.jsp'">Back</button>
        </div>
    </form>
</body>
</html>
    