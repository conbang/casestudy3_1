package model;

public interface ICart {
    boolean addNewProduct(int customerId, int productId,int total);
    boolean addQuantity(int customerId,int productId,int total);
}
