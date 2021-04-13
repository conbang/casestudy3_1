<%@ page import="view.Library" %>
<%@ page import="view.Body" %>
<%@ page import="model.User" %><%--
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
    out.println(Body.getHeader(0));
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
<%
    String action = (String) request.getAttribute("action");
    if(action.equals("login")){
        out.println(Body.getLoginForm());
    }else if(action.equals("register")){
        String msg = (String) request.getAttribute("msg");
        if(msg == null){
            msg = "";
        }
        out.println(Body.getRegisterForm(msg));
    }

%>
</div>
<%
    out.println(Body.getFooter());
    out.println(Library.getJsLibrary());
%>
</body>

</html>