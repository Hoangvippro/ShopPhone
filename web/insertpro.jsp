<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>
<%@page import = "model.*" %>
<%@page import = "java.util.List" %>
<%@page import = "java.util.ArrayList" %>
<!DOCTYPE html>
<%
    ProductDAO u = new ProductDAO();
    List<Product> lst = u.getProductList();
%>  
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert new Product</title>
    </head>
    <body>
        <h3>Insert new Product</h3>
        <form action="insertpro" method="POST">
            <p>Product's ID: <input type="text" name="pid"/>

            <p>Product's name: <input type="text" name="pname"/>

            <p>Image's source: <input type="text" name="image"/>
                
            <p>Quantity: <input type="text" name="quantity"/>
                
            <p>Price: <input type="text" name="price"/>
                
            <p>Status: <input type="text" name="status"/>
                
            <p>Category's ID: <input type="text" name="cateID"/>    

            <p><input type="submit" value="Insert" /> 
        </form>  
    </body>
</html>
