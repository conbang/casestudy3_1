package controller;

import model.Login;
import model.LoginService;
import model.Register;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginServLet", value = "/login")
public class LoginServLet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "login":
                login(req, resp);
                break;
            case "register":
                register(req, resp);
                break;
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "logout":
                logout(req, resp);
                break;
            case "loginForm":
                loginForm(req, resp);
                break;
            case "registerForm":
                registerForm(req, resp);
                break;
        }

    }

    private void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String psw = req.getParameter("psw");
        Register register = new Register();
        if (register.register(name, email, psw) == 0) {
            req.setAttribute("msg","email da ton tai!");
            req.setAttribute("action","register");
            RequestDispatcher dispatcher = req.getRequestDispatcher("/login.jsp");
            try{
                dispatcher.forward(req,resp);
            }catch (ServletException | IOException e){
                e.printStackTrace();
            }
        }else{
            HttpSession session = req.getSession();
            session.setAttribute("name", email);
            session.setMaxInactiveInterval(5);
            resp.sendRedirect("/index.jsp");
        }

    }

    private void loginForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("action", "login");
        RequestDispatcher dispatcher = req.getRequestDispatcher("/login.jsp");
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void registerForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("action", "register");
        RequestDispatcher dispatcher = req.getRequestDispatcher("/login.jsp");
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("email");
        String psw = req.getParameter("psw");
        Login login = new LoginService();
        if (login.login(name, psw)) {
            HttpSession session = req.getSession();
            session.setAttribute("name", name);
            session.setMaxInactiveInterval(5);
            resp.sendRedirect("/index.jsp");
        } else {
            resp.sendRedirect("/login.jsp");
        }
    }

    private void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.invalidate();
        resp.sendRedirect("/login.jsp");
    }
}
