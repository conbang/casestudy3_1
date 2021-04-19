package controller;

import model.Orders;
import service.getOrderDetails;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/Orderdetail")
public class OrderDetailServlet extends HttpServlet {
    getOrderDetails getOrderDetails = new getOrderDetails();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        List<Orders> orderdetail = getOrderDetails.getOrderdetaiList(id);
        req.setAttribute("orderdetail",orderdetail);
        RequestDispatcher rd = req.getRequestDispatcher("/orderlistdetail.jsp");
        rd.forward(req,resp);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
