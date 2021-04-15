package controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
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
    List<CartItem> listproduct = null;
    int productId;
    int quantity;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession(false);
        User user = (User) httpSession.getAttribute("name");
        CartService cartService = new CartService();
        listproduct = cartService.getListCartItem(user.getUserId());
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "checkout":
                redirectCartPage(req, resp);
                break;
            case "loadcart":
                getListCartItem(req,resp);
                break;
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession(false);
        User user = (User) httpSession.getAttribute("name");
        CartService cartService = new CartService();
        listproduct = cartService.getListCartItem(user.getUserId());
        JsonObject data = new Gson().fromJson(req.getReader(), JsonObject.class);
        String action = data.get("action").getAsString();
        switch (action) {
            case "updateQuantity":
                productId = data.get("id").getAsInt();
                quantity = data.get("quantity").getAsInt();
                updateQuantity(req, resp);
                break;
            case "additem":
                productId = data.get("id").getAsInt();
                quantity = data.get("quantity").getAsInt();
                addItem(req, resp);
                break;
        }
    }

    private void addItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int sumItem = 0;
        boolean isItemExist = false;
        for (int i = 0; i < listproduct.size(); i++) {
            if (listproduct.get(i).getProduct().getProductId() == productId) {
                quantity = listproduct.get(i).getQuantity() + 1;
                sumItem += 1;
                updateQuantity(req, resp);
                isItemExist = true;
                continue;
            }
            sumItem += listproduct.get(i).getQuantity();
        }
        resp.setContentType("text/plain");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter io = resp.getWriter();
        io.write(String.valueOf(sumItem));
        if (isItemExist) {
            return;
        }
        HttpSession httpSession = req.getSession(false);
        User user = (User) httpSession.getAttribute("name");
        int id = user.getUserId();
        CartService cartService = new CartService();
        cartService.addNewItem(id, productId);
    }

    private void updateQuantity(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession(false);
        User user = (User) httpSession.getAttribute("name");
        CartService cartService = new CartService();
        int id = user.getUserId();
        if (quantity != 0) {
            cartService.addQuantity(id, productId, quantity);

        } else {
            cartService.deleteItem(id, productId);
        }
    }
    private void getListCartItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(new Gson().toJson(listproduct));
    }

    private void redirectCartPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession(false);
        User user = (User) httpSession.getAttribute("name");
        req.setAttribute("listCartItem", listproduct);
        req.setAttribute("user", user);
        req.getRequestDispatcher("/cart.jsp").forward(req, resp);
    }

}
