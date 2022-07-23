<%-- 
    Document   : users
    Author     : parveen Kaur
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>USERS</title>
    </head>
    <body>
        <h1>User Information</h1>
        <main>
        <label>Email:</label>
        <input type ="text" value="email" name="">
        <br>
        <label>Active Status:</label>
        <input type="checkbox" value="active" name="YES">
        <br>
        <input type="checkbox" value="active" name="NO">
        <br>
        <label>First Name:</label>
        <input type="text" value="fname" name="">
        <br>
        <label>Last Name:</label>
        <input type="text" value="lname" name="">
        <br>
        <label>Password:</label>
        <input type="password" value="password" name="">
        <div>
            <select name="role" id="role">
                <option value="admin">Admin</option>
                <option value="companyAdmin">Company Admin</option>
                <option value="regularUser">Regular User</option>
            </select>
                
                
            </select>
        </div>
        </main>
    </body>
</html>
