package controller;

import model.User;
import service.FindAllUser;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AdminServLet", value = "/admin")
public class AdminServlet extends HttpServlet {
    FindAllUser findAllUser = new FindAllUser();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User>  userList = findAllUser.findAllUser();
        req.setAttribute("userlist",userList);
        RequestDispatcher rd = req.getRequestDispatcher("listuser.jsp");
        rd.forward(req,resp);
    }
}

