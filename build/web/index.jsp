<%@page import="model.ProductDAO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="UTF-8">

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>HoangNguyenSmartPhone</title>

        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="css/stylehome.css">
        <link href="css/font-awesome.css" rel="stylesheet">
        <link href="css/font-awesome.min.css" rel="stylesheet">
        <script src="js/Jquery.js"></script>
        <link href="css/styleindex.css" rel="stylesheet">
        


    </head>

    <!--Body starts here-->

    <body>
        <div class="container">

            <!--Logo starts here-->
            <div class="row forlogo">
                <div class="col-md-4 register">
                    <ul>
                        <li><a href="register.jsp">Register</a></li>
                            <c:choose>
                                <c:when test="${sessionScope.acc == null && sessionScope.admin == null}">
                                <li><a href="login.jsp">Login</a></li>
                                <br />
                            </c:when>    
                            <c:otherwise>
                                <li><a href="logout">Logout</a></li> 
                                <br />
                            </c:otherwise>
                        </c:choose>
                    </ul>
                </div>
                <div class="col-md-4">
                    <img src="img/LogoDT.jpg" class="img-responsive img-center logo" />
                </div>
                <div class="col-md-4 search1">
                    <form class="navbar-form navbar-right" role="search">
                        <div class="form-group">
                            <input type="text" class="form-control" placeholder="Search...">
                        </div>
                        <button type="TÃ¬m Sáº£n Pháº©m" class="btn btn-green glyphicon glyphicon-search"></button>
                    </form>
                </div>
            </div>


            <!--Menu starts here-->
            <nav class="nav navbar" role="navigation">
                <div class="container-fluid">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar" style="background: #99CC33"></span>
                            <span class="icon-bar" style="background: #99CC33"></span>
                            <span class="icon-bar" style="background: #99CC33"></span>
                        </button>
                    </div>
                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                        <ul class="nav navbar-nav">
                            <li class="active"><a href="index.html">HOMEPAGE</a></li>
                                <c:if test="${sessionScope.admin != null}">
                                <li><a href="productList.jsp">PRODUCTS</a></li>
                                </c:if>
                                <c:if test="${sessionScope.admin != null}">
                                <li><a href="categoryList.jsp">CATEGORY</a></li>
                                </c:if>
                                <c:if test="${sessionScope.admin != null}">
                                <li><a href="customerList.jsp">CUSTOMERS</a></li>
                                </c:if>
                            <li><a href="billList.jsp">BILLS</a></li>
                            <li><a href="billdetailList.jsp">BILLDETAILS</a></li>

                        </ul>


                    </div>
                    <!-- /.navbar-collapse -->
                </div>
            </nav>

            <!--Slide starts here-->
            <div class="row">
                <div class="col-md-12 nopadding">
                    
                    <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
                        
                        <ol class="carousel-indicators">
                            <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                            <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                            <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                            <li data-target="#carousel-example-generic" data-slide-to="3"></li>
                        </ol>

                        <!-- Wrapper for slides -->
                        <div class="carousel-inner" role="listbox">
                            <div class="item active">
                                <a href="about.html"><img src="img/Slide1.jpg" alt="HoangNguyenSmartPhone"></a>

                            </div>
                            <div class="item">
                                <a href="product.html"><img src="img/Slide2.jpg" alt="HoangNguyenSmartPhone"></a>

                            </div>
                            <div class="item">
                                <a href="contact.html"><img src="img/Slide3.jpg" alt="HoangNguyenSmartPhone"></a>

                            </div>
                            <div class="item">
                                <a href="gallery.html"><img src="img/Slide4.jpg" alt="HoangNguyenSmartPhone"></a>
                            </div>

                        <!-- Controls -->
                        <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
                            <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                            <span class="sr-only">Previous</span>
                        </a>
                        <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
                            <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                            <span class="sr-only">Next</span>
                        </a>
                    </div>
                </div>
            </div>


            <div class="row feast">
                <div>
                    <img src="img/Logo2.jpg" class="img-center img-responsive" />
                </div>
            </div>


            <div class="row four-img para1">
                <c:forEach items="${listP}" var="o">
                    <div class="col-md-2 pr">
                        <img src="${o.image}" class="img-responsive img-center" />
                        <h2 class="flowername">${o.pname}</h2>
                        <p class="price">${o.price} $</p>
                        <form action="productList.jsp">
                            <button type="submit" class="btn btn-default btnbuy"><span class="fa fa-shopping-basket"></span>ADD</button>
                        </form>
                        <div class="clearfix"></div>
                    </div>
                </c:forEach>


            </div>  
            


            <!--Footer starts here-->
            <div class="row">
                <div class="col-md-8">
                    <div>
                        <img src="img/location.png" class="img-responsive" />
                    </div>

                    <div>
                        <p>212 Nguyen Dinh Chieu, Dist. 3, HCMC</p>
                        <p>D29 Pham Van Bach, Cau Giay, Ha Noi</p>
                        <p>80 Truc Khe, Dong Da , Ha Noi</p>
                    </div>
                </div>

                <div class="col-md-4">
                    <img src="img/connectwithus.png" class="img-responsive" />
                    <p>1800 1525 | <a href="#">hoangnguyen@info.com</a></p>

                    <div>
                        <img src="img/facebook.png" class="img-responsive" />
                    </div>

                    <div>
                        <img src="img/twitter.png" class="img-responsive" />
                    </div>
                </div>
            </div>

        </div>

        <script src="js/bootstrap.min.js"></script>

    </body>

</html>