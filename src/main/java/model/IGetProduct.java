package model;

import java.util.List;

public interface GetProduct {
    String query ="select type,value,currency,image from product where type=? and currency=?";
    List<Product> getListProduct(String type,String currency);
}
