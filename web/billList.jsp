<%@page import="model.Bill"%>
<%@page import="java.util.List"%>
<%@page import="model.BillDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    BillDAO u = new BillDAO();
    List<Bill> lst = u.getBillList();
%>  
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List of bill</title>
        <style type="text/css">
            a {text-decoration:none;} 
        </style>
    </head>
    <body>
        <h2> List of bill </h2>
        <table border="1">
            <tr>
                <td> Bill's ID </td>
                <td> DateCreate </td>
                <td> Customer's name </td>
                <td> Customer's phone </td>
                <td> Customer's address </td>
                <td> Total </td>
                <td> Status </td>
                <td> Customer's ID </td>
            </tr>
            <% for (Bill x : lst) {%>
            <tr>
                <td><%= x.getOid()%></td>
                <td><%= x.getDatecreate()%></td>
                <td> <%= x.getCname()%></td>
                <td> <%= x.getCphone()%></td>
                <td> <%= x.getcAddress()%></td>
                <td> <%= x.getTotal()%></td>
                <td> <%= x.getStatus()%></td>
                <td> <%= x.getCid()%></td>
            </tr>
            <%}%>
        </table>     
        <p><button onclick='window.history.go(-1);'>Back to previous page</button>
        <p><a href="index.html">Back to homepage</a>
    </body>
</html>
