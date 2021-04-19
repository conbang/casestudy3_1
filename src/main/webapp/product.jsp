<%@ page import="model.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.LinkedList" %>
<%@ page import="view.Library" %>
<%@ page import="view.Body" %>
<%@ page import="model.User" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 08/04/2021
  Time: 10:44 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <%
        String info = Library.getInfoHead("Login");
        String csslibray = Library.getCssLibrary();
        out.println(info);
        out.println(csslibray);
    %>
</head>

<body>
<%---------------header----------------%>
<%
    HttpSession httpSession = request.getSession(false);
    User s = (User) httpSession.getAttribute("name");
    if (s == null) {
        out.println(Body.getTopHeader("<a href='/login?action=loginForm'><i class='fas fa-user-circle'></i>Sign in</a>'"));
    } else {
        out.println(Body.getTopHeader("<a href='account.jsp'><i class='fas fa-user-circle'></i>My account</a>"));
    }
    out.println(Body.getHeader(0));
%>
<%--------------nav-bar----------------%>
<%
    if (s == null) {
        out.println(Body.getNavbar("<li class='nav-item'><a href='/login.jsp' class='nav-link'>NHAN KEY</a></li>"));
    } else {
        out.println(Body.getNavbar("<li class='nav-item'><a href='/product?action=key' class='nav-link'>NHAN KEY</a></li>"));
    }
%>
<div class="body">
    <div class="container">
        <div class="row">
        <c:forEach items="${requestScope['list']}" var="list">
            <div class="card col-lg-2">
                <img class="card-img-top img-fluid w-90" src="${list.getImage()}" alt="Card image">
                <div class="card-body">
                    <h5 class="card-title"><c:out
                            value="${list.getType()} ${list.getValue()} ${list.getCurrency()}"></c:out></h5>
                    <p class="card-text"><c:out value="${list.getPrice()}"></c:out> d</p>
                    <button type="button" class="add-cart btn btn-primary" data-toggle="modal"
                            data-target="#addsuccess" data-id="${list.getProductId()}" data-target="#addsuccess" onclick="addcart(this)">Add to cart</button>
            </div>
            </div>
        </c:forEach>
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
