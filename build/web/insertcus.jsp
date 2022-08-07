<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>
<%@page import = "model.*" %>
<%@page import = "java.util.List" %>
<%@page import = "java.util.ArrayList" %>
<!DOCTYPE html>
<%
    CustomerDAO u = new CustomerDAO();
    List<Customer> lst = u.getCustomerList();
%>  
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert new Customer</title>
    </head>
    <body>
        <h3>Insert new Customer</h3>
        <form action="insertcus" method="POST">
            <p>Customer's name: <input type="text" name="cname"/>

            <p>Customer's phone number: <input type="text" name="cphone"/>
                
            <p>Customer's address: <input type="text" name="cAddress"/>
                
            <p>Username: <input type="text" name="username"/>
                
            <p>Password: <input type="text" name="password" placeholder="must be more than 8 digit"/>
                
            <p>Status: <input type="text" name="status"/>    

            <p><input type="submit" value="Insert" /> 
        </form>  
    </body>
</html>
