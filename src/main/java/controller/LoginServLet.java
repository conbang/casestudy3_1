package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name="LoginServLet",value = "/login")
public class LoginServLet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name=req.getParameter("email");
        String psw=req.getParameter("psw");
        if(name.equals("admin@gmail.com")&&psw.equals("admin")){
            HttpSession session = req.getSession();
            session.setAttribute("name",name);
            resp.sendRedirect("/index.jsp");
        }else{
           resp.sendRedirect("/login.jsp");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
