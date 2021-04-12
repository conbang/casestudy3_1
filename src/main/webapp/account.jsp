<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 07/04/2021
  Time: 5:12 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css"
          integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
    <link rel="stylesheet" href="resource/base.css">
    <link rel="stylesheet" href="resource/main.css">
</head>

<body>
<div class="top">
    <div class="container">
        <div class="row">
            <div class="currency col-3 ">
                <button type="button" class="btn dropdown-toggle" data-toggle="dropdown">
                    VND
                </button>
                <div class="dropdown-menu">
                    <a href="#" class="dropdown-item">VND</a>
                </div>
            </div>
            <div class="col-9 right__top">
                <a href="#"><i class="far fa-check-square"></i>Checkout</a>
                <%
                    HttpSession httpSession = request.getSession(false);
                    String s = (String) httpSession.getAttribute("name");
                    if(s==null){
                        out.print("<a href=\"/login.jsp\"><i class=\"fas fa-user-circle\"></i>Sign in</a>");
                    }else{
                        out.print("<a href=\"/account.jsp\"><i class=\"fas fa-user-circle\"></i>My account</a>");
                    }
                %>
            </div>
        </div>
    </div>
</div>
<header>
    <div class="container">
        <div class="row">
            <div class="col-lg-3">
                <a href="/index.jsp">
                    <img src="resource/logo.jpg" alt="logo">
                </a>
            </div>
            <div class="col-lg-4">
                <div class="input-group mb-3">
                    <input type="text" class="form-control" placeholder="Enter keyword here"
                           aria-label="Enter keyword here" aria-describedby="button-addon2">
                    <button class="btn btn-search" type="button" id="button-addon2"><i
                            class="fas fa-search"></i></button>
                </div>
            </div>
            <div class="shopping__cart col-lg-2">
                <i class="shopping__cart-img fas fa-shopping-cart"></i>
                <ul>
                    <li>
                        <h4>Gio hang</h4>
                    </li>
                    <li>
                        <span class="shopping__cart-items">0 items</span>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</header>
<nav class="navigation">
    <div class="container">
        <ul class="nav">
            <li class="nav-item"><a href="/index.jsp" class="nav-link">HOME</a></li>
            <li><a class="nav-link dropdown-toggle" data-toggle="dropdown" href="" role="button" aria-haspopup="true" aria-expanded="false">THE GOOGLE</a>
                <div class="dropdown-menu">
                    <a class="dropdown-item" href="/product?type=Google Play Card&cur=USD">THẺ GOOGLE USD</a>
                    <a class="dropdown-item" href="/product?type=Google Play Card&cur=VND">THẺ GOOGLE VND</a>
                    <a class="dropdown-item" href="/product?type=Google Play Card&cur=HKD">THẺ GOOGLE HKD</a>
                    <a class="dropdown-item" href="/product?type=Google Play Card&cur=EUR">THẺ GOOGLE EUR</a>
                    <a class="dropdown-item" href="/product?type=Google Play Card&cur=JP">THẺ GOOGLE JP</a>
                </div>
            </li>
            <li><a class="nav-link dropdown-toggle" data-toggle="dropdown" href="" role="button" aria-haspopup="true" aria-expanded="false">THẺ ĐIỆN THOẠI</a>
                <div class="dropdown-menu">
                    <a class="dropdown-item" href="/product?type=Viettel&cur=VND">THẺ VIETTEL</a>
                    <a class="dropdown-item" href="/product?type=Mobile phone Card&cur=VND">THẺ MOBBILE</a>
                    <a class="dropdown-item" href="/product?type=Vinaphone Card&cur=VND">THẺ VINAPHONE</a>
                </div>
            </li>
            <li><a class="nav-link dropdown-toggle" data-toggle="dropdown" href="" role="button" aria-haspopup="true" aria-expanded="false">THE STEAM</a>
                <div class="dropdown-menu">
                    <a class="dropdown-item" href="/product?type=Steam Card&cur=USD">THẺ STEAM USD</a>
                    <a class="dropdown-item" href="/product?type=Steam Card&cur=VND">THẺ STEAM VND</a>
                    <a class="dropdown-item" href="/product?type=Steam Card&cur=HKD">THẺ STEAM HKD</a>
                    <a class="dropdown-item" href="/product?type=Steam Card&cur=EUR">THẺ STEAM EUR</a>
                </div>
            </li>
            <li><a class="nav-link dropdown-toggle" data-toggle="dropdown" href="" role="button" aria-haspopup="true" aria-expanded="false">THẺ ITUNE</a>
                <div class="dropdown-menu">
                    <a class="dropdown-item" href="/product?type=Itunes Card&cur=USD">THẺ ITUNE USD</a>
                    <a class="dropdown-item" href="/product?type=Itunes Card&cur=EUR">THẺ ITUNE EUR</a>
                    <a class="dropdown-item" href="/product?type=Itunes Card&cur=HKD">THẺ ITUNE HKD</a>
                    <a class="dropdown-item" href="/product?type=Itunes Card&cur=GBP">THẺ ITUNE GBP</a>
                    <a class="dropdown-item" href="/product?type=Itunes Card&cur=VND">THẺ ITUNE VND</a>
                    <a class="dropdown-item" href="/product?type=Itunes Card&cur=JP">THẺ ITUNE JP</a>
                </div>
            </li>
            <%
                if(s==null){
                    out.print("<li class=\"nav-item\"><a href=\"/login.jsp\" class=\"nav-link\">NHAN KEY</a></li>");
                }else{
                    out.print("<li class=\"nav-item\"><a href=\"/account?action=key\" class=\"nav-link\">NHAN KEY</a></li>");
                }
            %>
        </ul>
    </div>
</nav>
<div class="body">
    <div class="container">
        <h3>TÀI KHOẢN CỦA BẠN</h3>
        <div class="row">
            <a href="#" class="col-lg-3 account-info">
                <i class="fas fa-user"></i>
                <span>THÔNG TIN</span>
            </a>
            <a href="#" class="col-lg-3 account-info">
                <i class="fas fa-calendar-alt"></i>
                <span>LỊCH SỬ CHI TIẾT ĐƠN HÀNG</span>
            </a>
            <a href="#" class="col-lg-3 account-info">
                <i class="fas fa-key"></i>
                <span>KEYS</span>
            </a>
        </div>
        <div class="row">
            <a href="/login?action=logout" class="account-logout"><span>Đăng xuất</span></a>
        </div>

    </div>
</div>
<footer>
    <div class="container">
        <div class="row">
            <div class="about_us col-lg-3">
                <ul>
                    <h4>VỀ CHÚNG TÔI</h4>
                    <li>Khách hàng đánh giá</li>
                    <li>Liên hệ hỗ trợ</li>
                    <li>Site map</li>
                </ul>
            </div>
            <div class="about_us col-lg-3">
                <ul>
                    <h4>ĐIỀU KHOẢN DỊCH VỤ</h4>
                    <li>Điều khoản đổi trả</li>
                    <li>Điều khoản bảo mật</li>
                    <li>Điều khoản mua hàng</li>
                    <li>Dịch vụ khách hàng</li>
                </ul>
            </div>
            <div class="about_us col-lg-3">
                <ul>
                    <h4>HƯỚNG DẪN</h4>
                    <li>Cách kích hoạt Steam game</li>
                    <li>Cách kích hoạt gift card</li>
                    <li>Cách mua hàng</li>
                </ul>
            </div>
            <div class="about_us col-lg-3">
                <ul>
                    <h4>CONTACT US</h4>
                    <li><i class="fas fa-envelope-square"></i>pass: bạnahoàn</li>
                    <li><i class="fas fa-phone"></i>    </i>phone: 096699696</li>
                    <li><i class="fas fa-map-marker-alt"></i>c1220g1</li>
                </ul>
            </div>
        </div>
    </div>
</footer>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="index.js" charset="utf-8"></script>
</body>

</html>
