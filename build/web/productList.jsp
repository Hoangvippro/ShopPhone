<%@page import="model.Product"%>
<%@page import="java.util.List"%>
<%@page import="model.ProductDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    ProductDAO u = new ProductDAO();
    List<Product> lst = u.getProductList();
%>  
<html>
    <head>
       <html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Product</title>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link href="css/manager.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="table-wrapper">
        <h2> List of products </h2>
        <div class ="tableProduct">
        <table class="table table-striped table-hover">
            <tr>
                <td> Product's ID </td>
                <td> Category ID </td>
                <td> Name </td>
                <td> Quantity </td>
                <td> Price </td>
                <td> Image </td>
                <td> Status </td>
            </tr>
            <% for (Product x : lst) {%>
            <tr>
                <td><%= x.getPid() %></td>
                <td><%= x.getCateID()%></td>
                <td> <%= x.getPname() %></td>
                <td><%= x.getQuantity()%></td>
                <td><%= x.getPrice()%></td>
                <!--<td width="250px"><%= x.getImage()%></td>-->
                <td width="250px"><img src="<%= x.getImage()%>" width="30%" height="30%" /></td>
                <td><%= x.getStatus()%></td>
                <td> <a href="deletepro?pid=<%= x.getPid() %>"> Delete  </td>
                <td> <a href="updatepro?pid=<%= x.getPid() %>"> Update  </td>
               <!--<td> <a href="delete?id=<%= x.getPid() %>"> Delete  </td>-->  
               <!--<td> <a href="updateCar.jsp?id=<%= x.getPid() %>"> Update  </td>-->  
            </tr>
            <%}%>
        </table>  
        </div>
        </div>
        <p><a href="insertpro.jsp">Insert new Product</a>
        <p><button onclick='window.history.go(-1);'>Back to previous page</button>
        <p><a href="index.jsp">Back to homepage</a>
    </body>
</html>
