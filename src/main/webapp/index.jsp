 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Dashboard</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #eaf4f4;
            margin: 0;
            padding: 0;
        }

        .navbar {
            background-color: #800000;
            color: white;
            padding: 14px 20px;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        .navbar .left {
            font-size: 18px;
            font-weight: bold;
        }

        .navbar .right a {
            color: white;
            text-decoration: none;
            margin-left: 20px;
        }

        .logout-btn {
            background-color: red;
            color: white;
            border: none;
            padding: 8px 14px;
            cursor: pointer;
            border-radius: 4px;
        }

        .container {
            padding: 30px;
        }

        h1 {
            text-align: center;
            margin-bottom: 40px;
        }

        h2 {
            margin-top: 40px;
        }

        .search-box {
            display: flex;
            align-items: center;
            margin-top: 10px;
        }

        .search-box label {
            margin-right: 10px;
            font-weight: bold;
        }

        .search-box input {
            padding: 8px;
            width: 300px;
            margin-right: 10px;
        }

        .search-box button {
            padding: 8px 16px;
            background-color: #007bff;
            color: white;
            border: none;
            cursor: pointer;
            border-radius: 4px;
        }

        table {
            border-collapse: collapse;
            width: 100%;
            margin-top: 20px;
            background-color: #fff;
        }

        th, td {
            padding: 10px;
            border: 1px solid #ccc;
            text-align: left;
        }

    </style>
</head>
<body>
    <div class="navbar">
        <div class="left">StudentApp</div>
        <div class="right">
            <a href="home.jsp">Home</a>
            <a href="about.jsp">About</a>
            <a href="contact.jsp">Contact</a>
            <form action="logout.jsp" method="post" style="display: inline;">
                <button class="logout-btn">Logout</button>
            </form>
        </div>
    </div>

    <div class="container">
        <h1>Dashboard</h1>

        <h2>View Your Data</h2>
        <table>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Phone</th>
                <th>Mail ID</th>
                <th>Branch</th>
                <th>Location</th>
            </tr>
        </table>

        <h2>Search user</h2>
        <form method="post" action="searchUser.jsp" class="search-box">
            <label for="searchTerm">Enter the name of the student:</label>
            <input type="text" name="searchTerm" id="searchTerm" placeholder="e.g., Chandan">
            <button type="submit">Search</button>
        </form>

        <table>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Branch</th>
                <th>Location</th>
            </tr>
            
        </table>
    </div>

</body>
</html>