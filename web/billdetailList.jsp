<%@page import="model.BillDetail"%>
<%@page import="java.util.List"%>
<%@page import="model.BillDetailDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    BillDetailDAO u = new BillDetailDAO();
    List<BillDetail> lst = u.getBillDetailList();
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
                <td> Product ID </td>
                <td> Order ID </td>
                <td> Quantity </td>
                <td> Price </td>
                <td> Total </td>
            </tr>
            <% for (BillDetail x : lst) {%>
            <tr>
                <td><%= x.getPid()%></td>
                <td><%= x.getOid()%></td>
                <td> <%= x.getQuantity()%></td>
                <td> <%= x.getPrice()%></td>
                <td> <%= x.getTotal()%></td>
            </tr>
            <%}%>
        </table>     
        <p><button onclick='window.history.go(-1);'>Back to previous page</button>
        <p><a href="index.html">Back to homepage</a>
    </body>
</html>
