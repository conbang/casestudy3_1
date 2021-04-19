<%@ page import="view.Library" %>
<%@ page import="model.User" %>
<%@ page import="view.Body" %>
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
    </style></head>
<body>

    <h1 style="text-align: center;">User Management</h1>

<div align="center">
    <form  method="post">
        <table border="1" cellpadding="5">
            <c:if test="${user != null}">
                <input type="hidden" name="id" value="<c:out value='${user.userId}' />"/>
            </c:if>
            <tr>
                <th>Wallet:</th>
                <td>
                    <input type="text" name="wallet" size="15"
                           value="<c:out value='${user.wallet}' />"
                    />
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save"/>
                    <h2>
                        <a href="/admin">Back</a>
                    </h2>
                </td>
            </tr>

        </table>
    </form>
</div>

</body>
</html>
