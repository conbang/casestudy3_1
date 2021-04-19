package controller;

import model.Orders;
import service.getOrders;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name="OrdersServlet", value = "/Order")
public class OrdersServlet extends HttpServlet {
    getOrders getOrders = new getOrders();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id =Integer.parseInt(req.getParameter("id"));
        List<Orders > ordersList = getOrders.getListOrders(id);
        req.setAttribute("orderlist",ordersList);
        RequestDispatcher rd = req.getRequestDispatcher("/orderlist.jsp");
        rd.forward(req,resp);
    }
}
