<%@page import="model.Category"%>
<%@page import="java.util.List"%>
<%@page import="model.CategoryDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    CategoryDAO u = new CategoryDAO();
    List<Category> lst = u.getCategoryList();
%>  
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List of category</title>
        <style type="text/css">
            a {text-decoration:none;} 
        </style>
    </head>
    <body>
        <h2> List of category </h2>
        <table border="1">
            <tr>
                <td> Category's ID </td>
                <td> Category Name </td>
                <td> Status </td>
            </tr>
            <% for (Category x : lst) {%>
            <tr>
                <td><%= x.getCateID()%></td>
                <td><%= x.getCateName()%></td>
                <td> <%= x.getStatus()%></td>
            </tr>
            <%}%>
        </table>     
        <p><button onclick='window.history.go(-1);'>Back to previous page</button>
        <p><a href="index.html">Back to homepage</a>
    </body>
</html>
