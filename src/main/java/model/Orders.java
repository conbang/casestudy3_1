package model;

import java.sql.Date;

public class Orders {
     private int orderId;
     private String status;
     private Date orderDate;
     private String key;
     private Float priceUnit;

    public Orders(String key, Float priceUnit) {
        this.key = key;
        this.priceUnit = priceUnit;
    }

    public Orders(int orderId, String status, Date orderDate) {
        this.orderId = orderId;
        this.status = status;
        this.orderDate = orderDate;
    }

    public Orders() {
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Float getPriceUnit() {
        return priceUnit;
    }

    public void setPriceUnit(Float priceUnit) {
        this.priceUnit = priceUnit;
    }
}
