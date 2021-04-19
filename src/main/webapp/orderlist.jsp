<%@ page import="model.User" %>
<%@ page import="view.Library" %>
<%@ page import="view.Body" %><%--
  Created by IntelliJ IDEA.
  User: hien
  Date: 15/04/2021
  Time: 14:25
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <%
        String info = Library.getInfoHead("ListUser");
        String csslibray = Library.getCssLibrary();
        out.println(info);
        out.println(csslibray);
        HttpSession httpSession = request.getSession(false);
        User s = (User) httpSession.getAttribute("name");
    %>
    <style>
        body{
            background-color: #19212B;
            padding-top: 30px;
            margin: 0 auto;
            color:#fff;
        }
    </style></head>
<body>
<div align="center">
    <table border="1" cellpadding="5">
        <tr>
            <th>ID</th>
            <th>Status</th>
            <th>Date</th>
            <th></th>
        </tr>
        <c:forEach var="order" items="${orderlist}">
            <tr>
                <td><c:out value="${order.orderId}"/></td>
                <td><c:out value="${order.status}"/></td>
                <td><c:out value="${order.orderDate}"/></td>
                <td>
                        <a href="/Orderdetail?id=<%out.print(s.getUserId());%>">OrderDetail</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>
