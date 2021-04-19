<%@ page import="view.Library" %>
<%@ page import="model.User" %>
<%@ page import="view.Body" %><%--
  Created by IntelliJ IDEA.
  User: hien
  Date: 15/04/2021
  Time: 17:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <%
        String info = Library.getInfoHead("ListUser");
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
    </style>
</head>
<body>
<div align="center">
    <caption><h1>List of Users</h1></caption>
    <table border="1" cellpadding="5" style="border-collapse: collapse;text-decoration: none;">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Country</th>
            <th></th>
        </tr>
        <c:forEach var="user" items="${userlist}">
            <tr>
                <td><c:out value="${user.userId}"/></td>
                <td><c:out value="${user.name}"/></td>
                <td><c:out value="${user.email}"/></td>
                <td><c:out value="${user.wallet}"/></td>
                <td>
                    <a href="/admin-edit?id=${user.userId}">Edit</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <h2><a href="admin.jsp">Back</a></h2>
</div>

</body>
</html>
