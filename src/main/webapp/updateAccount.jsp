<%@page import="in.pentagon.studentapp.dto.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update - Pentagon Space</title>
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
        .btn{
        	display:flex;
        	padding:20px;
        	gap:100px;
        }
        input[type="submit"] { 
        	background: green; 
        	color: white; 
        	padding: 10px; 
        	border: none; 
        	width: 50%; 
        	font-size: 18px; 
        	border-radius: 5px; 
        	cursor: pointer; 
        	display:flex;
        	justify-content:left;
        }
        button{
        	background:blue;
        	color:white;
        	border:none;
        	padding:10px;
        	width:20%;
        	height:40px;
        	font-size:18px;
        	border-radius:5px;
        	cursor:pointer;
        	
        	
        }
        .links { 
        	margin-top: 10px; 
        }
        a { 
        	text-decoration: none; 
        	color: blue; 
        }
        </style>
</head>
<body>
<% if (session.getAttribute("student") != null) {%>
       <%  Student s = (Student)session.getAttribute("student");%>

	<header>Pentagon Space</header>
	  <%if(request.getAttribute("error")!=null){ %>
    <h3 class="failure"><%=request.getAttribute("error") %></h3>
    <%} %>
    <form action="update" method="post">
    <h2>Update your account</h2>
    <label>Enter your Name:</label>
        <input type="text" name="name" value="<%=s.getName() %>" required>
        <label>Enter the Phone number:</label>
        <input type="tel" name="phone" value="<%=s.getPhone() %>"required>
        <label>Enter the Mail ID:</label>
        <input type="email" name="mail" value="<%=s.getMail() %>" required>
        <label>Enter the Branch:</label>
        <input type="text" name="branch" value="<%=s.getBranch() %>" required>
        <label>Enter the Location:</label>
        <input type="text" name="loc" value="<%=s.getLoc() %>" required>
        <div class="btn">
            <input type="submit" value="Update account">
            <button type="button" onclick="window.location.href='login.jsp'">Back</button>
        </div>
     </form>
     <%
    } else {
        request.setAttribute("error", "session expired");
        RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
        rd.forward(request, response);
    }
%>
</body>
</html>