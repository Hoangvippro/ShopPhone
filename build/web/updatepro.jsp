<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update form</title>
    </head>
    <body>
        <%
            Product x = (Product) request.getAttribute("x");
            if (x == null) {
                return;
            }
        %>    
        <h2> Update a product </h2>
        <form action="updatepro" method="POST">
            <p><input type="text" name="pid" value="<%= x.getPid()%>" readonly /> 
            <p><input type="text" name="image" value="<%= x.getImage()%>"/> 
            <p><input type="text" name="pname" value="<%= x.getPname()%>"/>
            <p><input type="text" name="quantity" value="<%= x.getQuantity()%>"/> 
            <p><input type="text" name="price" value="<%= x.getPrice()%>"/>
            <p><input type="text" name="status" value="<%= x.getStatus()%>"/>
            <p><input type="text" name="cateID" value="<%= x.getCateID()%>"/>    
            <p><input type="submit" value="Update"> 
        </form>  
    </body>
</html>

