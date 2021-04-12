package model;

public interface Login {
    String query = "Select name from customer where email=? and password=?";
    boolean login(String email,String psw);
}
