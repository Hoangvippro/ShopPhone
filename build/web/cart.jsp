<%@page import="model.CartItem"%>
<%@page import="model.Product"%>
<%@page import="java.util.List"%>
<%@page import="model.ProductDAO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    List<CartItem> a = (List<CartItem>) session.getAttribute("cart");
%>
<html>
    <head>
        <title>Shopping cart</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <style>
            html {
                background: #bbc3c6;
                font: 62.5%/1.5em "Trebuchet Ms", helvetica;
            }

            * {
                box-sizing: border-box;
                -webkit-font-smoothing: antialiased;
                font-smoothing: antialiased;
            }

            @font-face {
                font-family: 'Shopper';
                src: url('http://www.shopperfont.com/font/Shopper-Std.ttf');
            }

            .shopper {
                text-transform: lowercase;
                font: 2em 'Shopper', sans-serif;
                line-height: 0.5em;
                display: inline-block;
            }



            h1 {
                text-transform: uppercase;
                font-weight: bold;
                font-size: 2.5em;
            }

            p {
                font-size: 1.5em;
                color: #8a8a8a;
            }

            input {
                border: 0.3em solid #bbc3c6;
                padding: 0.5em 0.3em; 
                font-size: 1.4em;
                color: #8a8a8a;
                text-align: center;
            }

            img {
                max-width: 9em;
                width: 100%;
                overflow: hidden; 
                margin-right: 1em;
            }

            a {
                text-decoration: none;
            }

            .container {
                max-width: 75em;
                width: 95%;
                margin: 40px auto;  
                overflow: hidden;
                position: relative;

                border-radius: 0.6em;
                background: #ecf0f1;
                box-shadow: 0 0.5em 0 rgba(138, 148, 152, 0.2);
            }

            .heading {
                padding: 1em;
                position: relative;
                z-index: 1;
                color: #f7f7f7;
                background: #f34d35;
            }

            .cart {
                margin: 2.5em;
                overflow: hidden;
            }

            .cart.is-closed {
                height: 0;
                margin-top: -2.5em;
            }

            .table {
                background: #ffffff;
                border-radius: 0.6em;
                overflow: hidden;
                clear: both;
                margin-bottom: 1.8em;
            }


            .layout-inline > * {
                display: inline-block;
            }

            .align-center {
                text-align: center;
            }

            .th {
                background: #f34d35;
                color: #fff;
                text-transform: uppercase;
                font-weight: bold;
                font-size: 1.5em;
            }

            .tf {
                background: #f34d35;
                text-transform: uppercase;
                text-align: right;
                font-size: 1.2em;  
            }

            .tf p {
                color: #fff;
                font-weight: bold;
            }

            .col {
                padding: 1em;
                width: 12%;
            }

            .col-pro {
                width: 44%;
            }

            .col-pro > * {
                vertical-align: middle;
            }

            .col-qty {
                text-align: center;
                width: 17%;
                display: inline;
            }

            .col-numeric p {
                font: bold 1.8em helvetica;
            }

            .col-total p {
                color: #12c8b1;
            }

            .tf .col {
                width: 20%;
            }

            .row > div {
                vertical-align: middle;
            }

            .row-bg2 {
                background: #f7f7f7;
            }

            .visibility-cart {
                position: absolute;
                color: #fff;
                top: 0.5em;
                right: 0.5em;
                font:  bold 2em arial;
                border: 0.16em solid #fff;
                border-radius: 2.5em;
                padding: 0 0.22em 0 0.25em ;
            }

            .col-qty > * {
                vertical-align: middle; 
            }

            .col-qty > input {
                max-width: 2.6em;
            }


            a.qty {
                width: 1em;
                line-height: 1em;
                border-radius: 2em;
                font-size: 2.5em;
                font-weight: bold;
                text-align: center;
                background: #43ace3;  
                color: #fff;
            }

            a.qty:hover {
                background: #3b9ac6;
            }

            .btn {
                padding: 10px 30px;
                border-radius: 0.3em;
                font-size: 1.4em;
                font-weight: bold;
                background: #43ace3;
                color: #fff;
                box-shadow: 0 3px 0 rgba(59,154,198, 1)
            }

            .btn:hover {
                box-shadow: 0 3px 0 rgba(59,154,198, 0)
            }

            .btn-update {
                float: right;
                margin: 0 0 1.5em 0;
            }

            .transition {
                transition: all 0.3s ease-in-out;
            }

            @media screen and ( max-width: 755px) {
                .container {
                    width: 98%;
                }

                .col-pro {
                    width: 35%;
                }

                .col-qty {
                    width: 22%;
                }

                img {
                    max-width: 100%;
                    margin-bottom: 1em;
                }
            }

            @media screen and ( max-width: 591px) {

            }
        </style>
    </head>
    <body>
        <div class="container">
            <div class="heading">
                <h1>
                    <span class="shopper">s</span> Shopping Cart
                </h1>

                   
            </div>

            <div class="cart transition is-open">

                <a href="bill.jsp" class="btn btn-update">Checkout</a>


                <div class="table">

                    <div class="layout-inline row th">
                        <div class="col col-pro">Product</div>
                        <div class="col col-price align-center "> 
                            Price
                        </div>
                        <div class="col col-qty align-center">Quantity</div>
                        <div class="col">Total</div>
                    </div>
                    <%
                        for (CartItem o : a) {
                     %>
                    <div class="layout-inline row">

                        <div class="col col-pro layout-inline">
                            <img src="<%= o.getPimage() %>" width="30%" height="30%" />
                            <p><%= o.getPname() %></p>
                        </div>

                        <div class="col col-price col-numeric align-center ">
                            <p><%= o.getPprice() %></p>
                        </div>
                        <form action="checkcart" method="POST">
                            <div class="col col-qty layout-inline">
                                <input type="submit" value="-" name="check" class="qty qty-minus"/>
                                <input type="hidden" value="<%= o.getPid() %>" name="id"/>
                                <input type="text" value="<%= o.getQuantity() %>" name="quantity"/>
                                <input type="submit" value="+" name="check" class="qty qty-plus"/>
                                
                            </div>
                        </form>
                        <div class="col col-total col-numeric">               
                            <p>$<%= o.getPprice() * o.getQuantity() %></p>
                        </div>
                    </div>
                            <%
                                }
                            %>

                    
                    <div class="tf">
                        <div class="row layout-inline">
                            <div class="col">
                                <p>VAT</p>
                            </div>
                            <div class="col">10%</div>
                        </div>
                        <div class="row layout-inline">
                            <div class="col">
                                <p>Shipping</p>
                            </div>
                            <div class="col">$0</div>
                        </div>
                        <div class="row layout-inline">
                            <div class="col">
                                <p>Total</p>
                            </div>
                            <%
                                double total = 0;
                                for(int i = 0; i < a.size(); i++ ){
                                    total+= a.get(i).getPprice() * a.get(i).getQuantity() + 0.1*total;
                                }
                             %>
                            <div class="col"><%= total %></div>
                                   
                        </div>
                    </div> 
                </div>

                <a href="homecontrol" class="btn btn-update">Continue shopping</a>

            </div>
    </body>
</html>
