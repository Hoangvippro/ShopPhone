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
            Customer x = (Customer) request.getAttribute("x");
            if (x == null) {
                return;
            }
        %>    
        <h2> Update a customer </h2>
        <form action="updatecus" method="POST">
            <p><input type="text" name="cid" value="<%= x.getCid() %>" readonly /> 
            <p><input type="text" name="cname" value="<%= x.getCname() %>"/> 
            <p><input type="text" name="cphone" value="<%= x.getCphone() %>"/>
            <p><input type="text" name="cAddress" value="<%= x.getcAddress() %>"/> 
            <p><input type="text" name="username" value="<%= x.getUsername() %>"/>
            <p><input type="text" name="password" value="<%= x.getPassword() %>"/>
            <p><input type="text" name="status" value="<%= x.getStatus() %>"/>    
            <p><input type="submit" value="Update"> 
        </form>  
    </body>
</html>
