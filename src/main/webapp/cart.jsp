<%@ page import="view.Library" %>
<%@ page import="view.Body" %>
<%@ page import="model.User" %>
<%@ page import="model.CartItem" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 07/04/2021
  Time: 5:12 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<%------------------- css libray------------------------%>
<head>
    <%
        String info = Library.getInfoHead("Login");
        String csslibray = Library.getCssLibrary();
        out.println(info);
        out.println(csslibray);
    %>
</head>
<body>
<%---------------header-------------------------%>
<%
    HttpSession httpSession = request.getSession(false);
    User s = (User) httpSession.getAttribute("name");
    if (s == null) {
        out.println(Body.getTopHeader("<a href='/login?action=loginForm'><i class='fas fa-user-circle'></i>Sign in</a>'"));
    } else {
        out.println(Body.getTopHeader("<a href='account.jsp'><i class='fas fa-user-circle'></i>My account</a>"));
    }
    List<CartItem> listItem = (List<CartItem>) request.getAttribute("listCartItem");

    out.println(Body.getHeader(listItem.size()));
%>
<%-----------------nav bar------------------%>
<%
    if (s == null) {
        out.println(Body.getNavbar("<li class='nav-item'><a href='/login.jsp' class='nav-link'>NHAN KEY</a></li>"));
    } else {
        out.println(Body.getNavbar("<li class='nav-item'><a href='/account?action=key' class='nav-link'>NHAN KEY</a></li>"));
    }
%>
<%------------------------login/register --------------------------%>
<div class="body">
    <div class="container">
        <div class="row">
            <h2>Danh sach san pham</h2>
        </div>
    </div>



</div>
<%
    out.println(Body.getFooter());
    out.println(Library.getJsLibrary());
%>
</body>

</html>
