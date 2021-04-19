package controller;

import model.User;
import service.GetListProduct;
import model.Product;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

@WebServlet(name = "ProductServlet", value = "/product")
public class ProductServlet extends HttpServlet {
    private static List<Product> list = null;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        GetListProduct listProduct = new GetListProduct();
        list = listProduct.getListProduct();
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "category":
                showListTypeProduct(req, resp);
                break;
            case "product":
                showProduct(req, resp);
                break;
            case "":
                homepage(req, resp);
                break;
            case "key":
                showKey(req,resp);
                break;
        }
    }
    private void homepage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> ListBestSeller = new GetListProduct().getListBestSeller();
        req.setAttribute("listBestSeller", ListBestSeller);
        req.setAttribute("listProduct",list);
        req.getRequestDispatcher("/index.jsp").forward(req,resp);
    }
    private void showKey(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        User user = (User) session.getAttribute("name");

        req.getRequestDispatcher("/Order?id="+user.getUserId()).forward(req,resp);

    }

    private void showListTypeProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String type = req.getParameter("type");
        String currency = req.getParameter("cur");
        List<Product> ListTypeProduct = new LinkedList<>();
        for (int i = 0; i < list.size(); i++) {
            if (type.equals(list.get(i).getType()) && currency.equals(list.get(i).getCurrency())) {
                ListTypeProduct.add(list.get(i));
            }
        }
        req.setAttribute("list", ListTypeProduct);
        req.getRequestDispatcher("/product.jsp").forward(req,resp);
    }

    private void showProduct(HttpServletRequest req, HttpServletResponse resp) {
        int productId = Integer.parseInt(req.getParameter("id"));
        for (int i = 0; i < list.size(); i++) {
            if (productId == list.get(i).getProductId()) {

            }
        }
    }
}
