package service;

import model.Product;

import java.util.List;

public interface IGetProduct {
    String query ="select valueproduct.id,typeproduct.rate,typeproduct.type,valueproduct.value,typeproduct.currency,valueproduct.image from " +
            "valueproduct inner join typeproduct on valueproduct.typeId=typeproduct.id " ;
    List<Product> getListProduct();
}
