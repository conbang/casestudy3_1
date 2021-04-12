package model;

public class User {
    int userId;
    String name;
    String email;
    int wallet;

    public User(String name, int userId, String email,int balance) {
        this.name = name;
        this.userId = userId;
        this.email = email;
        this.wallet = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getWallet() {
        return wallet;
    }

    public void setWallet(int wallet) {
        this.wallet = wallet;
    }
}
