package service;

import model.Orders;

import java.util.ArrayList;
import java.util.List;

public interface IGetOrders {
    String sql = "select orders.orderId,orders.status,orders.orderDate from orders where customerId = ?;";
    List<Orders> listOrders = new ArrayList<>();

}
