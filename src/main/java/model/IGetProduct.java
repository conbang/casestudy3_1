package model;

import java.util.List;

public interface IGetProduct {
    String query ="select typeproduct.rate,typeproduct.type,valueproduct.value,typeproduct.currency,valueproduct.image from " +
            "valueproduct inner join typeproduct on valueproduct.typeId=typeproduct.id " +
            "where typeproduct.type=? and typeproduct.currency=?";
    List<Product> getListProduct(String type,String currency);
}
