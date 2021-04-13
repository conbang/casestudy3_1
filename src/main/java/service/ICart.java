package service;

import model.CartItem;

import java.util.List;

public interface ICart {
    String GETLISTITEMQUERY = "select id,type," +
            "value,rate," +
            "currency,image, quantity from product where customerId=?";
    String UPDATEQUANTITYQUERY = "UPDATE cart SET quantity = ? WHERE (customerId = ?) and (productId = ?)";
    String DELETEITEMQUERY ="DELETE FROM cart WHERE (customerId = ?) and (productId = ?)";
    boolean addNewItem(int customerId, int productId);

    boolean addQuantity(int customerId, int productId, int total);

    boolean deleteItem(int customerId, int productId);

    List<CartItem> getListCartItem(int customerId);


}
