package model;

import java.util.Locale;

public class Product {
    private int productId;
    private String type;
    private Float value;
    private int rate;
    private String currency;
    private String image;
    private String key;

    public Product(int productId,String type, float value,int rate, String currency, String image) {
        this.productId = productId;
        this.type = type;
        this.value = value;
        this.rate=rate;
        this.currency = currency;
        this.image = image;
    }

    public int getProductId() {
        return productId;
    }

    public String getType() {
        return type;
    }

    public Float getValue() {
        return value;
    }

    public String getCurrency() {
        return currency;
    }

    public String getImage() {
        return image;
    }

    public String getKey() {
        return key;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setValue(Float value) {
        this.value = value;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public double getPrice() {
        return rate * value;
    }
}
