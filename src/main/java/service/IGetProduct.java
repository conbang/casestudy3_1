package service;

import model.Product;

import java.util.List;

public interface IGetProduct {
    String QUERY = "select valueproduct.id,typeproduct.rate,typeproduct.type,valueproduct.value,typeproduct.currency,valueproduct.image from " +
            "valueproduct inner join typeproduct on valueproduct.typeId=typeproduct.id";
    String  GETIDLISTBESTSELLER = "select productId from orderdetail group by productId order by count(orderId) desc limit 8";
    String  GETLISTBESTSELLER = "select id,rate,type,value,currency,image from allproduct where id =? or id =? or id =? or id =? or id =? or id =? or id =? or id =?";
    List<Product> getListProduct();
}
