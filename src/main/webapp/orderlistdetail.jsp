<%@ page import="view.Library" %>
<%@ page import="model.User" %>
<%@ page import="view.Body" %><%--
  Created by IntelliJ IDEA.
  User: hien
  Date: 15/04/2021
  Time: 16:09
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%
        String info = Library.getInfoHead("Login");
        String csslibray = Library.getCssLibrary();
        out.println(info);
        out.println(csslibray);
    %>
    <style>
        body{
            background-color: #19212B;
            padding-top: 30px;
            margin: 0 auto;
            color:#fff;
        }
    </style></head>
</head>
<body>
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
        out.println(Body.getNavbar("<li class='nav-item'><a href='/account?action=key' class='nav-link'>NHAN KEY</a></li>"));
    }
%>
<div align="center">
    <table border="1" cellpadding="5">
        <tr>
            <th>Key</th>
        </tr>
        <c:forEach var="order" items="${orderdetail}">
            <tr>
                <td><c:out value="${order.key}"/></td>
            </tr>
        </c:forEach>
    </table>
</div>
<%
    out.println(Body.getFooter());
    out.println(Library.getJsLibrary());
%>
</body>
</html>
