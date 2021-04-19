package controller;

import model.User;
import service.AdminService;
import service.ChangeIFAService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/User-if")
public class UserIFServlet extends HttpServlet {
    AdminService adminService = new AdminService();
    ChangeIFAService changeIFAService = new ChangeIFAService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));
         User user = AdminService.selectUserChange(id);
          req.setAttribute("user",user);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/UserInformation.jsp");
        dispatcher.forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String password = req.getParameter("password");
        changeIFAService.changeInformationAcc(id,password);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/UserInformation.jsp");
        dispatcher.forward(req,resp);

    }
}
