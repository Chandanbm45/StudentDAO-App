<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Signup - Pentagon Space</title>
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
        input, select { 
        	width: 100%; 
        	padding: 10px; 
        	margin-bottom: 15px; 
        	border: 1px solid #ccc; 
        	border-radius: 5px; 
        }
        input[type="submit"] { 
        	background: blue; 
        	color: white; 
        	padding: 10px; 
        	border: none; 
        	width: 100%; 
        	font-size: 18px; 
        	border-radius: 5px; 
        	cursor: pointer; 
        }
        input[type="submit"]:hover { 
        	background: darkblue; 
        }
        .links { 
        	margin-top: 10px; 
        }
        a { 
        	text-decoration: none; 
        	color: blue; 
        }
        .failure{
        color:red;
        }
    </style>
</head>
<body>
    <header>Pentagon Space</header>
    <%if(request.getAttribute("error")!=null){%>
    <h3 class="failure"><%=request.getAttribute("error")%></h3>
    <%}%>
    <form action="signup" method="post">
        <h2>Application Form</h2>
        <label>Enter your Name:</label>
        <input type="text" name="name" required>
        <label>Enter the Phone number:</label>
        <input type="tel" name="phone" required>
        <label>Enter the Mail ID:</label>
        <input type="email" name="mail" required>
        <label>Enter the Branch:</label>
        <select name="branch">
            <option value="CSE">CSE</option>
            <option value="ISE">ISE</option>
            <option value="ECE">ECE</option>
            <option value="AIML">AIML</option>
            <option value="Mech">Mech</option>
            <option value="Civil">Civil</option>
        </select>
        <label>Enter the Location:</label>
        <input type="text" name="loc" required>
        <label>Enter the Password:</label>
        <input type="password" name="password" required>
        <label>Confirm the Password:</label>
        <input type="password" name="confirm" required>
        <input type="submit" value="Create Account">
        <div class="links">
            Already have an account? <a href="login.jsp">Login</a>
        </div>
    </form>
</body>
</html>
    