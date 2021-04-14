package controller;

import model.CartItem;
import service.CartService;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "CartServlet", value = "/cart")
public class CartServlet extends HttpServlet {
    List<CartItem> listproduct=null;
    int productId;
    int quantity;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession(false);
        User user = (User) httpSession.getAttribute("name");
        CartService cartService = new CartService();
        listproduct = cartService.getListCartItem(user.getUserId());
        String action = req.getParameter("action");
        if(action==null){
            action="";
        }
        switch (action){
            case "checkout":
                redirectCartPage(req,resp);
                break;
            case "additem":
                addItem(req,resp);
                break;
            case "updateQuantity":
                updateQuantity(req,resp);
                break;
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
    private void addItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        productId = Integer.parseInt(req.getParameter("id"));
        quantity = Integer.parseInt(req.getParameter("quantity"));
        int sumItem=0;
        int sumPrice=0;
        boolean isItemExist = false;
        for (int i = 0; i < listproduct.size(); i++) {
            if(listproduct.get(i).getProduct().getProductId() == productId){
                updateQuantity(req,resp);
                isItemExist = true;
            }
            sumItem+=listproduct.get(i).getQuantity();
            sumPrice+=listproduct.get(i).getProduct().getPrice();
        }
        resp.setContentType("text/plain");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter io = resp.getWriter();
        io.write(String.valueOf(sumItem+quantity));
        if (isItemExist){
            return;
        }
        HttpSession httpSession = req.getSession(false);
        User user = (User) httpSession.getAttribute("name");
        int id = user.getUserId();
        CartService cartService = new CartService();
        cartService.addNewItem(id, productId);
    }

    private void updateQuantity(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        productId = Integer.parseInt(req.getParameter("id"));
        quantity = Integer.parseInt(req.getParameter("quantity"));
        HttpSession httpSession = req.getSession(false);
        User user = (User) httpSession.getAttribute("name");
        CartService cartService = new CartService();
        int id = user.getUserId();
        if (quantity !=0){
            cartService.addQuantity(id,productId,quantity);
        }else{
            cartService.deleteItem(id,productId);
        }
    }
    private void redirectCartPage(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("listCartItem",listproduct);
        req.getRequestDispatcher("/cart.jsp").forward(req,resp);
    }

}
