package model;

public interface Login {
    String query = "Select customerId,name,email,wallet from customer where email=? and password=?";
    User login(String email,String psw);
}
