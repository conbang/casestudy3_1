package controller;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "PaymentServlet", value = "/payment")
public class PaymentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        JsonObject list = new Gson().fromJson(req.getReader(),JsonObject.class);
        JsonArray listJsonId = list.get("id").getAsJsonArray();
        ArrayList<Integer> listId = new ArrayList<>();
        if (listJsonId != null) {
            int len = listJsonId.size();
            for (int i=0;i<len;i++){
                listId.add(listJsonId.get(i).getAsInt());
            }
        }

    }
}
