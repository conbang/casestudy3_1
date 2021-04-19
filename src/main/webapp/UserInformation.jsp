<%--
  Created by IntelliJ IDEA.
  User: hien
  Date: 16/04/2021
  Time: 14:12
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>Information</h2>
            </caption>
            <c:if test="${user != null}">
                <input type="hidden" name="id" id="id" value="<c:out value='${user.userId}' />"/>
            </c:if>
            <tr>
                <th>User Name:</th>

                <td><c:out value="${user.name}"/></td>

            </tr>
            <tr>
                <th>User Email:</th>

                <td><c:out value="${user.email}"/></td>
            </tr>
            <tr>
                <th>Password</th>
                <td>
                    <input type="text" name="password" id="password" size="15"/>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
