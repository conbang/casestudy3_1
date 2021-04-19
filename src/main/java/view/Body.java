package view;

public class Body {
    public static String getTopHeader(String link) {
        String topHeader = "<div class='top'>" +
                "    <div class='container'>" +
                "        <div class='row'>" +
                "            <div class='currency col-3 '>" +
                "                <button type='button' class='btn dropdown-toggle' data-toggle='dropdown'>" +
                "                    VND" +
                "                </button>" +
                "                <div class='dropdown-menu'>" +
                "                    <a href='#' class='dropdown-item'>VND</a>" +
                "                </div>" +
                "            </div>" +
                "            <div class='col-9 right__top'>" +
                "                <a href='/cart?action=checkout'><i class='far fa-check-square'></i>Checkout</a>" + link +
                "            </div>" +
                "        </div>" +
                "    </div>" +
                "</div>";
        return topHeader;
    }

    public static String getHeader(int item) {
        String header = "<header>" +
                "    <div class='container'>" +
                "        <div class='row'>" +
                "            <div class='col-lg-3'>" +
                "                <a href='/product?action='>" +
                "                    <img src='resource/logo.jpg' alt='logo'>" +
                "                </a>" +
                "            </div>" +
                "            <div class='col-lg-4'>" +
                "                <div class='input-group mb-3'>" +
                "                    <input type='text' class='form-control' placeholder='Enter keyword here'" +
                "                           aria-label='Enter keyword here' aria-describedby='button-addon2'>" +
                "                    <button class='btn btn-search' type='button' id='button-addon2'><i" +
                "                            class='fas fa-search'></i></button>" +
                "                </div>" +
                "            </div>" +
                "            <div class='shopping__cart col-lg-2'>" +
                "                <ul class='cart-title'>" +
                "                    <li>" +
                "                        <h4>Gio hang</h4>" +
                "                    </li>" +
                "                    <li>" +
                "                        <span class='shopping__cart-items'>" + item + " items</span>" +
                "                    </li>" +
                "                </ul>" +
                "            </div>" +
                "        </div>" +
                "    </div>" +
                "</header>";
        return header;
    }

    public static String getNavbar(String linkkey) {
        String navbar = "<nav class='navigation'>" +
                "    <div class='container'>" +
                "        <ul class='nav'>" +
                "            <li class='nav-item'><a href='/index.jsp' class='nav-link'>HOME</a></li>" +
                "<li>" +
                "<div class='dropdown'>" +
                "<a class='dropbtn nav-link' data-toggle='dropdown' role='button' aria-haspopup='true' +" +
                "               aria-expanded='false'>THE GOOGLE</a>" +
                "<div class='dropdown-content'>" +
                "                    <a class='dropdown-item' href='/product?action=category&type=Google Play Card&cur=USD'>THE GOOGLE USD</a>" +
                "                    <a class='dropdown-item' href='/product?action=category&type=Google Play Card&cur=VND'>THE GOOGLE VND</a>" +
                "                    <a class='dropdown-item' href='/product?action=category&type=Google Play Card&cur=HKD'>THE GOOGLE HKD</a>" +
                "                    <a class='dropdown-item' href='/product?action=category&type=Google Play Card&cur=EUR'>THE GOOGLE EUR</a>" +
                "                    <a class='dropdown-item' href='/product?action=category&type=Google Play Card&cur=JP'>THE GOOGLE JP</a>" +
                "</div>" +
                "<li>"+
                "<div class='dropdown'>" +
                "<a class='dropbtn nav-link' data-toggle='dropdown' role='button' aria-haspopup='true' +" +
                "               aria-expanded='false'>THE DIEN THOAI</a>" +
                "  <div class='dropdown-content'>" +
                "                    <a class='dropdown-item' href='/product?action=category&type=Viettel Card&cur=VND'>THE VIETTEL</a>" +
                "                    <a class='dropdown-item' href='/product?action=category&type=Mobile phone Card&cur=VND'>THE MOBBILE</a>" +
                "                    <a class='dropdown-item' href='/product?action=category&type=Vinaphone Card&cur=VND'>THE VINAPHONE</a>" +
                "  </div>" +
                "</div>" +
                "</li>" +
                "<li>"+
                "<div class='dropdown'>"+
                "<a class='dropbtn nav-link' data-toggle='dropdown' role='button' aria-haspopup='true' +" +
                "               aria-expanded='false'>THE STEAM</a>" +
                "    <div class='dropdown-content'>" +
                "                    <a class='dropdown-item' href='/product?action=category&type=Steam Card&cur=USD'>THE STEAM USD</a>" +
                "                    <a class='dropdown-item' href='/product?action=category&type=Steam Card&cur=VND'>THE STEAM VND</a>" +
                "                    <a class='dropdown-item' href='/product?action=category&type=Steam Card&cur=HKD'>THE STEAM HKD</a>" +
                "                    <a class='dropdown-item' href='/product?action=category&type=Steam Card&cur=EUR'>THE STEAM EUR</a>" +
                "    </div>" +
                "</div>"+
                "</li>" +
                "<li>"+
                "<div class='dropdown'>"+
                "<a class='dropbtn nav-link' data-toggle='dropdown' role='button' aria-haspopup='true' +" +
                "aria-expanded='false'>THE ITUNE</a>" +
                "<div class='dropdown-content'>" +
                "                    <a class='dropdown-item' href='/product?action=category&type=Itunes Card&cur=USD'>THE ITUNE USD</a>" +
                "                    <a class='dropdown-item' href='/product?action=category&type=Itunes Card&cur=EUR'>THE ITUNE EUR</a>" +
                "                    <a class='dropdown-item' href='/product?action=category&type=Itunes Card&cur=HKD'>THE ITUNE HKD</a>" +
                "                    <a class='dropdown-item' href='/product?action=category&type=Itunes Card&cur=GBP'>THE ITUNE GBP</a>" +
                "                    <a class='dropdown-item' href='/product?action=category&type=Itunes Card&cur=VND'>THE ITUNE VND</a>" +
                "                    <a class='dropdown-item' href='/product?action=category&type=Itunes Card&cur=JP'>THE ITUNE JP</a>" +
                "</div>" +
                "</div>"+
                "</li>" + linkkey +
                "        </ul>" +
                "    </div>" +
                "</nav>";
        return navbar;
    }

    public static String getLoginForm() {
        String sideBar = "    <div class='container'>" +
                "        <div class='row'>" +
                "            <div class='login_form col-lg-7'>" +
                "                <h1>Dang nhap vao tai khoan cua ban</h1>" +
                "                <form action='/login?action=login' method='post'>" +
                "                    <div class='form-group'>" +
                "                        <label for='exampleInputEmail1'>Email address</label>" +
                "                        <input type='email' class='form-control' id='exampleInputEmail1'" +
                "                               aria-describedby='emailHelp' name='email' required/>" +
                "                    </div>" +
                "                    <div class='form-group'>" +
                "                        <label for='exampleInputPassword1'>Password</label>" +
                "                        <input type='password' class='form-control' id='exampleInputPassword1'" +
                "                          name='psw' pattern='[a-zA-Z0-9]{6,}' required>" +
                "                    </div>" +
                "                    <button type='submit' class='btn btn btn-secondary'>Dang nhap</button>" +
                "                    <a href='/register.jsp'>Khong co tai khoan? Tao tai khoan o day</a>" +
                "                </form>" +
                "            </div>" +
                "" +
                "        </div>" +
                "    </div>";
        return sideBar;
    }

    public static String getFooter() {
        String footer = "<footer>" +
                "    <div class='container'>" +
                "        <div class='row'>" +
                "            <div class='about_us col-lg-3'>" +
                "                <ul>" +
                "                    <h4>VE CHUNG TOI</h4>" +
                "                    <li>Khach hang danh gia</li>" +
                "                    <li>Lien he ho tro</li>" +
                "                    <li>Site map</li>" +
                "                </ul>" +
                "            </div>" +
                "            <div class='about_us col-lg-3'>" +
                "                <ul>" +
                "                    <h4>DIEU KHOAN DICH VU</h4>" +
                "                    <li>Dieu khoan doi tra</li>" +
                "                    <li>Dieu khoan bao mat</li>" +
                "                    <li>Dieu khoan mua hang</li>" +
                "                    <li>Dich vu mua hang</li>" +
                "                </ul>" +
                "            </div>" +
                "            <div class='about_us col-lg-3'>" +
                "                <ul>" +
                "                    <h4>HUONG DAN</h4>" +
                "                    <li>Cach kich hoat Steam game</li>" +
                "                    <li>Cach kich hoat gift card</li>" +
                "                    <li>Cach mua hang</li>" +
                "                </ul>" +
                "            </div>" +
                "            <div class='about_us col-lg-3'>" +
                "                <ul>" +
                "                    <h4>CONTACT US</h4>" +
                "                    <li><i class='fas fa-envelope-square'></i>email: vitaminc@gmail.com</li>" +
                "                    <li><i class='fas fa-phone'></i>    </i>phone: 096699696</li>" +
                "                    <li><i class='fas fa-map-marker-alt'></i>c1220g1</li>" +
                "                </ul>" +
                "            </div>" +
                "        </div>" +
                "    </div>" +
                "</footer>";
        return footer;
    }

    public static String getRegisterForm(String msg) {
        String registerForm = "<div class='container'>" +
                "            <div class='row'>" +
                "                <div class='login_form col-lg-7'>" +
                "                    <h1>Tao tai khoan moi</h1>" +
                "                    <form method='POST' action='/login?action=register'>" +
                "                        <div class='form-group'>" +
                "                            <label for='name'>Ho va ten</label>" +
                "                           <input class='form-control form-control-lg' type='text' name='name'  placeholder='Ho va ten' required>" +
                "                        </div>" +
                "                        <div class='form-group'>" +
                "                            <label for='exampleInputEmail1'>Email</label>" +
                "                            <input type='email' class='form-control' id='exampleInputEmail1'" +
                "                                aria-describedby='emailHelp' placeholder='email' name='email' required/>" +
                "                        </div>" +
                "                        <div class='form-group'>" +
                "                            <label for='exampleInputPassword1'>Mat khau</label>" +
                "                            <input type='password' class='form-control' id='exampleInputPassword1'" +
                "                                placeholder='Password' name='psw' pattern='[a-zA-Z0-9]{6,}' required>" +
                "                        </div>" +
                "                        <div class='form-group form-check'>" +
                "                            <input type='checkbox' class='form-check-input' id='exampleCheck1'>" +
                "                            <label class='form-check-label' for='exampleCheck1'>Dang ky nhan thu thong bao</label>" +
                "                        </div><p><span class='errMsg'>" + msg + "</span></p>" +
                "                        <button type='submit' class='btn btn btn-secondary'>Dang ky</button>" +
                "                    </form>" +
                "                </div>" +
                "            </div>" +
                "        </div>";
        return registerForm;
    }
}
