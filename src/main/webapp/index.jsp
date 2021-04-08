<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 07/04/2021
  Time: 5:10 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
            <div class="col-3 dropdown currency">
                <button type="button" class="btn dropdown-toggle" data-toggle="dropdown">
                    VND
                </button>
                <div class="dropdown-menu">
                    <a href="#" class="dropdown-item">VND</a>
                </div>
            </div>
            <div class="col-9 right__top">
                <a href="#"><i class="far fa-check-square"></i>Checkout</a>
                <a href="#"><i class="fas fa-user-circle"></i>
                    <%
                        HttpSession session1 = request.getSession(false);
                    %>
                    <c:choose>
                        <c:when test="${session1==null}">Sign in</c:when>
                        <c:when test="${session1!=null}">
                            My account
                        </c:when>
                    </c:choose>
                </a>
            </div>
        </div>
    </div>
</div>
<header>
    <div class="container">
        <div class="row">
            <div class="col-lg-3">
                <img src="resource/logo.jpg" alt="">
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
            <li class="nav-item"><a href="#" class="nav-link">HOME</a></li>
            <li class="nav-item"><a href="" class="nav-link">GAME</a></li>
            <li class="nav-item"><a href="" class="nav-link">THE GOOGLE</a></li>
            <li class="nav-item"><a href="" class="nav-link">THE DT</a></li>
            <li class="nav-item"><a href="" class="nav-link">THE XBOX</a></li>
            <li class="nav-item"><a href="" class="nav-link">THE STEAM</a></li>
            <li class="nav-item"><a href="" class="nav-link">THE ITUNE</a></li>
            <li class="nav-item"><a href="" class="nav-link">NHAN KEY</a></li>
        </ul>

    </div>
</nav>
<div class="body">
    <div class="container">
        <div class="row">
            <div class="side__bar col-3">
                <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
                    <div class="carousel-inner">
                        <div class="carousel-item active">
                            <div class="card" style="width: 18rem;">
                                <img class="card-img-top" src="resource/game.jpg" alt="Card image cap">
                                <div class="card-body">
                                    <h5 class="card-title">Card title</h5>
                                    <p class="card-text">950.000</p>
                                    <a href="#" class="btn btn-primary">Add to cart</a>
                                </div>
                            </div>
                            <div class="card" style="width: 18rem;">
                                <img class="card-img-top" src="resource/game.jpg" alt="Card image cap">
                                <div class="card-body">
                                    <h5 class="card-title">Card title</h5>
                                    <p class="card-text">950.000</p>
                                    <a href="#" class="btn btn-primary">Add to cart</a>
                                </div>
                            </div>
                            <div class="card" style="width: 18rem;">
                                <img class="card-img-top" src="resource/game.jpg" alt="Card image cap">
                                <div class="card-body">
                                    <h5 class="card-title">Card title</h5>
                                    <p class="card-text">950.000</p>
                                    <a href="#" class="btn btn-primary">Add to cart</a>
                                </div>
                            </div>
                        </div>
                        <div class="carousel-item">
                            <div class="card" style="width: 18rem;">
                                <img class="card-img-top" src="resource/game.jpg" alt="Card image cap">
                                <div class="card-body">
                                    <h5 class="card-title">Card title</h5>
                                    <p class="card-text">950.000</p>
                                    <a href="#" class="btn btn-primary">Add to cart</a>
                                </div>
                            </div>
                            <div class="card" style="width: 18rem;">
                                <img class="card-img-top" src="resource/game.jpg" alt="Card image cap">
                                <div class="card-body">
                                    <h5 class="card-title">Card title</h5>
                                    <p class="card-text">950.000</p>
                                    <a href="#" class="btn btn-primary">Add to cart</a>
                                </div>
                            </div>
                            <div class="card" style="width: 18rem;">
                                <img class="card-img-top" src="resource/game.jpg" alt="Card image cap">
                                <div class="card-body">
                                    <h5 class="card-title">Card title</h5>
                                    <p class="card-text">950.000</p>
                                    <a href="#" class="btn btn-primary">Add to cart</a>
                                </div>
                            </div>
                        </div>
                        <div class="carousel-item">
                            <div class="card" style="width: 18rem;">
                                <img class="card-img-top" src="resource/game.jpg" alt="Card image cap">
                                <div class="card-body">
                                    <h5 class="card-title">Card title</h5>
                                    <p class="card-text">950.000</p>
                                    <a href="#" class="btn btn-primary">Add to cart</a>
                                </div>
                            </div>
                            <div class="card" style="width: 18rem;">
                                <img class="card-img-top" src="resource/game.jpg" alt="Card image cap">
                                <div class="card-body">
                                    <h5 class="card-title">Card title</h5>
                                    <p class="card-text">950.000</p>
                                    <a href="#" class="btn btn-primary">Add to cart</a>
                                </div>
                            </div>
                            <div class="card" style="width: 18rem;">
                                <img class="card-img-top" src="resource/game.jpg" alt="Card image cap">
                                <div class="card-body">
                                    <h5 class="card-title">Card title</h5>
                                    <p class="card-text">950.000</p>
                                    <a href="#" class="btn btn-primary">Add to cart</a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button"
                       data-slide="prev">
                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                        <span class="sr-only">Previous</span>
                    </a>
                    <a class="carousel-control-next" href="#carouselExampleIndicators" role="button"
                       data-slide="next">
                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                        <span class="sr-only">Next</span>
                    </a>
                </div>
            </div>
            <div class="content col-lg-9">
                <div class=row>
                    <nav>
                        <div class="nav nav-tabs" id="nav-tab" role="tablist">
                            <a class="nav-item nav-link active" id="nav-home-tab" data-toggle="tab" href="#nav-home"
                               role="tab"
                               aria-controls="nav-home" aria-selected="true">Best Seller</a>
                            <a class="nav-item nav-link" id="nav-profile-tab" data-toggle="tab" href="#nav-profile"
                               role="tab"
                               aria-controls="nav-profile" aria-selected="false">On Sale</a>
                            <a class="nav-item nav-link" id="nav-contact-tab" data-toggle="tab" href="#nav-contact"
                               role="tab"
                               aria-controls="nav-contact" aria-selected="false">New Releases</a>
                        </div>
                    </nav>
                    <div class="tab-content" id="nav-tabContent">
                        <div class="tab-pane fade show active" id="nav-home" role="tabpanel"
                             aria-labelledby="nav-home-tab">
                            <div class="bestseller">
                                <div class="row">
                                    <div class="card" style="width: 18rem;">
                                        <img class="card-img-top" src="resource/game.jpg" alt="Card image cap">
                                        <div class="card-body">
                                            <h5 class="card-title">Card title</h5>
                                            <p class="card-text">950.000</p>
                                            <a href="#" class="btn btn-primary">Add to cart</a>
                                        </div>
                                    </div>
                                    <div class="card" style="width: 18rem;">
                                        <img class="card-img-top" src="resource/game.jpg" alt="Card image cap">
                                        <div class="card-body">
                                            <h5 class="card-title">Card title</h5>
                                            <p class="card-text">950.000</p>
                                            <a href="#" class="btn btn-primary">Add to cart</a>
                                        </div>
                                    </div>
                                    <div class="card" style="width: 18rem;">
                                        <img class="card-img-top" src="resource/game.jpg" alt="Card image cap">
                                        <div class="card-body">
                                            <h5 class="card-title">Card title</h5>
                                            <p class="card-text">950.000</p>
                                            <a href="#" class="btn btn-primary">Add to cart</a>
                                        </div>
                                    </div>
                                    <div class="card" style="width: 18rem;">
                                        <img class="card-img-top" src="resource/game.jpg" alt="Card image cap">
                                        <div class="card-body">
                                            <h5 class="card-title">Card title</h5>
                                            <p class="card-text">950.000</p>
                                            <a href="#" class="btn btn-primary">Add to cart</a>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="card" style="width: 18rem;">
                                        <img class="card-img-top" src="resource/game.jpg" alt="Card image cap">
                                        <div class="card-body">
                                            <h5 class="card-title">Card title</h5>
                                            <p class="card-text">950.000</p>
                                            <a href="#" class="btn btn-primary">Add to cart</a>
                                        </div>
                                    </div>
                                    <div class="card" style="width: 18rem;">
                                        <img class="card-img-top" src="resource/game.jpg" alt="Card image cap">
                                        <div class="card-body">
                                            <h5 class="card-title">Card title</h5>
                                            <p class="card-text">950.000</p>
                                            <a href="#" class="btn btn-primary">Add to cart</a>
                                        </div>
                                    </div>
                                    <div class="card" style="width: 18rem;">
                                        <img class="card-img-top" src="resource/game.jpg" alt="Card image cap">
                                        <div class="card-body">
                                            <h5 class="card-title">Card title</h5>
                                            <p class="card-text">950.000</p>
                                            <a href="#" class="btn btn-primary">Add to cart</a>
                                        </div>
                                    </div>
                                    <div class="card" style="width: 18rem;">
                                        <img class="card-img-top" src="resource/game.jpg" alt="Card image cap">
                                        <div class="card-body">
                                            <h5 class="card-title">Card title</h5>
                                            <p class="card-text">950.000</p>
                                            <a href="#" class="btn btn-primary">Add to cart</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="tab-pane fade" id="nav-profile" role="tabpanel" aria-labelledby="nav-profile-tab">
                            <div class="onsale">
                                <div class="row">
                                    <div class="card" style="width: 18rem;">
                                        <img class="card-img-top" src="resource/game.jpg" alt="Card image cap">
                                        <div class="card-body">
                                            <h5 class="card-title">Card title</h5>
                                            <p class="card-text">950.000</p>
                                            <a href="#" class="btn btn-primary">Add to cart</a>
                                        </div>
                                    </div>
                                    <div class="card" style="width: 18rem;">
                                        <img class="card-img-top" src="resource/game.jpg" alt="Card image cap">
                                        <div class="card-body">
                                            <h5 class="card-title">Card title</h5>
                                            <p class="card-text">950.000</p>
                                            <a href="#" class="btn btn-primary">Add to cart</a>
                                        </div>
                                    </div>
                                    <div class="card" style="width: 18rem;">
                                        <img class="card-img-top" src="resource/game.jpg" alt="Card image cap">
                                        <div class="card-body">
                                            <h5 class="card-title">Card title</h5>
                                            <p class="card-text">950.000</p>
                                            <a href="#" class="btn btn-primary">Add to cart</a>
                                        </div>
                                    </div>
                                    <div class="card" style="width: 18rem;">
                                        <img class="card-img-top" src="resource/game.jpg" alt="Card image cap">
                                        <div class="card-body">
                                            <h5 class="card-title">Card title</h5>
                                            <p class="card-text">950.000</p>
                                            <a href="#" class="btn btn-primary">Add to cart</a>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="card" style="width: 18rem;">
                                        <img class="card-img-top" src="resource/game.jpg" alt="Card image cap">
                                        <div class="card-body">
                                            <h5 class="card-title">Card title</h5>
                                            <p class="card-text">950.000</p>
                                            <a href="#" class="btn btn-primary">Add to cart</a>
                                        </div>
                                    </div>
                                    <div class="card" style="width: 18rem;">
                                        <img class="card-img-top" src="resource/game.jpg" alt="Card image cap">
                                        <div class="card-body">
                                            <h5 class="card-title">Card title</h5>
                                            <p class="card-text">950.000</p>
                                            <a href="#" class="btn btn-primary">Add to cart</a>
                                        </div>
                                    </div>
                                    <div class="card" style="width: 18rem;">
                                        <img class="card-img-top" src="resource/game.jpg" alt="Card image cap">
                                        <div class="card-body">
                                            <h5 class="card-title">Card title</h5>
                                            <p class="card-text">950.000</p>
                                            <a href="#" class="btn btn-primary">Add to cart</a>
                                        </div>
                                    </div>
                                    <div class="card" style="width: 18rem;">
                                        <img class="card-img-top" src="resource/game.jpg" alt="Card image cap">
                                        <div class="card-body">
                                            <h5 class="card-title">Card title</h5>
                                            <p class="card-text">950.000</p>
                                            <a href="#" class="btn btn-primary">Add to cart</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="tab-pane fade" id="nav-contact" role="tabpanel" aria-labelledby="nav-contact-tab">
                            ...
                        </div>
                    </div>
                </div>


            </div>
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
