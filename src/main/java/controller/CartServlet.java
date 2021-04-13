package controller;

import model.Cart;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "CartServlet", value = "/cart")
public class CartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int productId = Integer.parseInt(req.getParameter("id"));
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        Map<Integer,Integer> listproduct = null;
        HttpSession session = req.getSession(false);
        User user = (User) session.getAttribute("name");
        if (user == null) {

            listproduct = new HashMap<>();
            listproduct.put(productId,quantity);
        }else{
            if (listproduct != null) {

                listproduct = null;
            }else{
                int id = user.getUserId();
                Cart cart = new Cart();
                cart.addNewProduct(id,productId,1);
            }

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
