package controller;

import model.User;
import service.AdminService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/admin-edit")
public class EditWalletServlet extends HttpServlet {
   AdminService adminService = new AdminService();
    private void showEditForm(HttpServletRequest request, HttpServletResponse response){
        int id = Integer.parseInt(request.getParameter("id"));
        User existingUser = adminService.selectUser(id);
        RequestDispatcher rd = request.getRequestDispatcher("editwallet.jsp");
        request.setAttribute("user",existingUser);
        try {
            rd.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void updateUser(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int wallet = Integer.parseInt(request.getParameter("wallet"));
        User user = new User(id,wallet);
        adminService.updateWalletcustomer(user);
        RequestDispatcher rd = request.getRequestDispatcher("editwallet.jsp");
        rd.forward(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        showEditForm(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        updateUser(req,resp);
        }
}
