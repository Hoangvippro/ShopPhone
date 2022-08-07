<%@page import="model.Customer"%>
<%@page import="java.util.List"%>
<%@page import="model.CustomerDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    CustomerDAO u = new CustomerDAO();
    List<Customer> lst = u.getCustomerList();
%>  
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List of customer</title>
        <style type="text/css">
            a {text-decoration:none;} 
        </style>
    </head>
    <body>
        <h2> List of customer </h2>
        <table border="1">
            <tr>
                <td> Customer's ID </td>
                <td> Customer Name </td>
                <td> Customer's phone number </td>
                <td> Customer's address </td>
                <td> Username </td>
                <td> Password </td>
                <td> Status </td>
            </tr>
            <% for (Customer x : lst) {%>
            <tr>
                <td><%= x.getCid() %></td>
                <td><%= x.getCname() %></td>
                <td> <%= x.getCphone() %></td>
                <td> <%= x.getcAddress() %></td>
                <td> <%= x.getUsername() %></td>
                <td> <%= x.getPassword() %></td>
                <td> <%= x.getStatus()%></td>
                <td> <a href="deletecus?cid=<%= x.getCid() %>"> Delete  </td>
                <td> <a href="updatecus?cid=<%= x.getCid() %>"> Update  </td>
            </tr>
            <%}%>
        </table> 
<!--        <p><a href="insertcus.jsp">Insert new Customer</a>-->
        <p><button onclick='window.history.go(-1);'>Back to previous page</button>
        <p><a href="index.html">Back to homepage</a>
    </body>
</html>

