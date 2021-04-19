<%@ page import="view.Library" %>
<%@ page import="view.Body" %>
<%@ page import="service.DatabaseConnection" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="model.User" %>
<%@ page import="model.Product" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 07/04/2021
  Time: 5:10 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <%
        String info = Library.getInfoHead("Home");
        String csslibray = Library.getCssLibrary();
        out.println(info);
        out.println(csslibray);
    %>
</head>

<body>
<%----------------header---------------%>
<%
    HttpSession httpSession = request.getSession(false);
    User s = (User) httpSession.getAttribute("name");
    if (s == null) {
        out.println(Body.getTopHeader("<a href='/login?action=loginForm'><i class='fas fa-user-circle'></i>Sign in</a>'"));
    } else {
        System.out.println(s.getUserId());
        out.println(Body.getTopHeader("<a href='account.jsp'><i class='fas fa-user-circle'></i>" + s.getName() + "</a>"));
    }
    out.println(Body.getHeader(0));
%>
<%-------------------nav bar-------------------------%>
<%
    if (s == null) {
        out.println(Body.getNavbar("<li class='nav-item'><a href='/login.jsp' class='nav-link'>NHAN KEY</a></li>"));
    } else {
        out.println(Body.getNavbar("<li class='nav-item'><a href='/product?action=key' class='nav-link'>NHAN KEY</a></li>"));
    }
%>
<%-----------------------content-------------------------------%>
<div class="body">
    <div class="container">
        <div class="row">
            <div class="side__bar col-3">
                <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel" >
                    <div class="carousel-inner">
                        <div class="carousel-item active">
                            <c:forEach items="${requestScope['listProduct']}" var="item" varStatus="count">
                                <c:if test="${count.count>10 && count.count <14}">
                                    <div class="card" style="width: 18rem;">
                                        <img class="card-img-top" src="${item.image}" alt="Card image cap">
                                        <div class="card-body">
                                            <h5 class="card-title">${item.type} ${item.value} ${item.currency}</h5>
                                            <p class="card-text shopping__cart-price">${item.getPrice()}</p>
                                        </div>
                                    </div>
                                </c:if>
                            </c:forEach>

                        </div>
                        <div class="carousel-item">
                            <c:forEach items="${requestScope['listProduct']}" var="item" varStatus="count">
                                <c:if test="${count.count>25 && count.count <29}">
                                    <div class="card" style="width: 18rem;">
                                        <img class="card-img-top" src="${item.image}" alt="Card image cap">
                                        <div class="card-body">
                                            <h5 class="card-title">${item.type} ${item.value} ${item.currency}</h5>
                                            <p class="card-text shopping__cart-price">${item.getPrice()}</p>
                                        </div>
                                    </div>
                                </c:if>
                            </c:forEach>
                        </div>
                        <div class="carousel-item">
                            <c:forEach items="${requestScope['listProduct']}" var="item" varStatus="count">
                                <c:if test="${count.count>30 && count.count <34}">
                                    <div class="card" style="width: 18rem;">
                                        <img class="card-img-top" src="${item.image}" alt="Card image cap">
                                        <div class="card-body">
                                            <h5 class="card-title">${item.type} ${item.value} ${item.currency}</h5>
                                            <p class="card-text shopping__cart-price">${item.getPrice()}</p>
                                        </div>
                                    </div>
                                </c:if>
                            </c:forEach>
                        </div>
                    </div>
                        <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button"
                           data-slide="prev">
                            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                            <span class="sr-only">Previous</span>
                        </a>
                        <a class="carousel-control-next" href="#carouselExampleIndicators" role="button"
                           data-slide="next">
                            <span class="carousel-control-next-icon" aria-hidden="true"></span>
                            <span class="sr-only">Next</span>
                        </a>
                </div>
            </div>
            <div class="content col-lg-9">
                <div class=row>
                    <nav>
                        <div class="nav nav-tabs" id="nav-tab" role="tablist">
                            <a class="nav-item nav-link active" id="nav-home-tab" data-toggle="tab" href="#nav-home"
                               role="tab"
                               aria-controls="nav-home" aria-selected="true">Best Seller</a>
                            <a class="nav-item nav-link" id="nav-profile-tab" data-toggle="tab" href="#nav-profile"
                               role="tab"
                               aria-controls="nav-profile" aria-selected="false">On Sale</a>
                        </div>
                    </nav>
                    <div class="tab-content" id="nav-tabContent">
                        <div class="tab-pane fade show active" id="nav-home" role="tabpanel"
                             aria-labelledby="nav-home-tab">
                            <div class="bestseller">
                                <div class="row">
                                    <c:forEach items="${requestScope['listBestSeller']}" var="item">
                                        <div class="card" style="width: 18rem;" >
                                            <img class="card-img-top " src="${item.image}" alt="Card image cap">
                                            <div class="card-body">
                                                <h5 class="card-title shopping__cart-items">${item.type} ${item.value} ${item.currency}</h5>
                                                <p class="card-text shopping__cart-price">${item.getPrice()}</p>
                                                <button type="button" onclick="addcart(this)" data-id="${item.productId}" class="btn btn-primary shopping__cart-button" data-toggle="modal" data-target="#addsuccess">Add to cart</button>
                                            </div>
                                        </div>
                                    </c:forEach>
                                </div>
                            </div>
                        </div>
                        <div class="tab-pane fade" id="nav-profile" role="tabpanel" aria-labelledby="nav-profile-tab">
                            <div class="onsale">
                                <div class="row">
                                    <c:forEach items="${requestScope['listProduct']}" var="item" varStatus="theCount">
                                        <c:if test="${theCount.count<9}">
                                            <div class="card" style="width: 18rem;">
                                                <img class="card-img-top" src="${item.image}" alt="Card image cap">
                                                <div class="card-body">
                                                    <h5 class="card-title">${item.type} ${item.value} ${item.currency}</h5>
                                                    <p class="card-text">${item.getPrice()}</p>
                                                    <button type="button" onclick="addcart(this)" data-id="${item.productId}" class="btn btn-primary" data-toggle="modal" data-target="#addsuccess">Add to cart</button>
                                                </div>
                                            </div>
                                        </c:if>
                                    </c:forEach>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="addsuccess" tabindex="-1" role="dialog" aria-labelledby="addsuccess" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Da them gio hang thanh cong</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>them vao gio hang thanh cong!</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Tiep tuc mua hang</button>
                <button type="button" class="btn btn-primary"><a href="cart?action=checkout">Den gio hang</a></button>
            </div>
        </div>
    </div>
</div>
<%
    out.println(Body.getFooter());
    out.println(Library.getJsLibrary());
%>
</body>

</html>
