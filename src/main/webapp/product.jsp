<%@ page import="model.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.LinkedList" %>
<%@ page import="view.Header" %>
<%@ page import="view.Body" %><%--
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
        String info = Header.getInfoHead("Login");
        String csslibray = Header.getCssLibrary();
        out.println(info);
        out.println(csslibray);
    %>
</head>

<body>
<%---------------header----------------%>
<%
    HttpSession httpSession = request.getSession(false);
    String s = (String) httpSession.getAttribute("name");
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
        out.println(Body.getNavbar("<li class='nav-item'><a href='/account?action=key' class='nav-link'>NHAN KEY</a></li>"));
    }
%>
<div class="body">
    <div class="container">
        <div class="row">
        <c:forEach items="${requestScope['list']}" var="list">
            <div class="card col-lg-3">
                <img class="card-img-top" src="${list.getImage()}" alt="Card image">
                <div class="card-body">
                    <h5 class="card-title"><c:out
                            value="${list.getType()} ${list.getValue()} ${list.getCurrency()}"></c:out></h5>
                    <p class="card-text"><c:out value="${list.getPrice()}"></c:out> d</p>
                    <a href="#" class="btn btn-primary">Add to cart</a>
            </div>
            </div>
        </c:forEach>
    </div>
</div>
</div>
<%
    out.println(Body.getFooter());
    out.println(Header.getJsLibrary());
%>
</body>
</html>
