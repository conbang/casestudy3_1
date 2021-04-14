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
<body onload="getItemCost()">
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
            <div class="col-md-12 col-lg-9 col-xl-9">
                <h2>Danh sach san pham</h2>
                <c:forEach items="${requestScope['listCartItem']}" var="Item">
                    <div class="item row" id="${Item.product.productId}"
                         style="border-bottom:1px solid #0C1015;margin-bottom:30px">
                        <div class="col-md-4 col-lg-3 col-xl-4" style="border-rigt:1px solid #0C1015">
                            <input type="checkbox" data-id="${Item.product.productId}"
                                   data-price="${Item.product.getPrice()}" onclick="chooseItem(this)">
                            <img class="img-fluid w-50"
                                 src=${Item.product.image} alt="Sample">
                        </div>
                        <div class="col-md-8 col-lg-9 col-xl-8" style="border-rigt:1px solid #0C1015">
                            <div class="d-flex justify-content-between">
                                <div>
                                    <h4>Mo ta</h4>
                                    <h3 class="mb-3 text-muted text-uppercase">${Item.product.type}</h3>
                                    <p class="card-price mb-2 text-muted">${Item.product.getPrice()} d</p>
                                </div>
                                <div>
                                    <h4>So luong</h4>
                                    <div class="def-number-input number-input safari_only mb-0 w-100"
                                         data-price="${Item.product.getPrice()}"
                                         data-id="${Item.product.productId}">
                                        <button onclick="decrItem(this)"
                                                class="minus">-
                                        </button>
                                        <input class="quantity" min="1" name="quantity" value="${Item.quantity}"
                                               type="number"
                                               style="width: 50px;">
                                        <button onclick="addItems(this)"
                                                class="plus">+
                                        </button>
                                    </div>
                                </div>
                            </div>
                            <div class="d-flex justify-content-between align-items-center">
                                <div onclick="remove(this)" data-id=${Item.product.productId}>
                                    <p type="button" class="card-link-secondary small text-uppercase mr-3"><i
                                            class="fas fa-trash-alt mr-1" onclick="remove(this)"></i> Remove item </p>
                                </div>
                                <p class="mb-0"><span class="card-price"><strong
                                        class=${Item.product.productId}>${Item.product.getPrice()*Item.quantity} d</strong></span>
                                </p>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
            <div class="col-lg-3 col-xl-3">
                <h3 class="mb-3">Tong tien</h3>
                <ul class="list-group list-group-flush">
                    <li class="list-group-item d-flex justify-content-between align-items-center border-0 px-0 pb-0"
                        style="background-color: #19212B;">
                        So du vi:
                        <span><c:out value="${requestScope['user'].wallet}"></c:out></span>
                    </li>
                    <li class="list-group-item d-flex justify-content-between align-items-center px-0"
                        style="background-color: #19212B;">
                        Tong tien:
                        <span id="cost">0 d</span>
                    </li>
                    <li class="list-group-item d-flex justify-content-between align-items-center border-0 px-0 mb-3"
                        style="background-color: #19212B;">
                        <div>
                            <strong>Con du:</strong>
                            <strong>
                                <p class="mb-0">(including VAT)</p>
                            </strong>
                        </div>
                        <span><strong id="overbalance">${requestScope['user'].wallet}</strong></span>
                    </li>
                </ul>
                <button type="button" class="checkout btn btn-primary btn-block" onclick="checkout()">go to checkout</button>
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
