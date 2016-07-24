/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Order;

import Business.Vaccine.Vaccine;
import java.util.ArrayList;

/**
 *
 * @author Vinay Limbare
 */
public class Order {

    private ArrayList<OrderItem> orderItemList;
    private int orderNumber;
    private String orderStatus;

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Order() {
        orderItemList = new ArrayList<>();
    }

    public ArrayList<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(ArrayList<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public OrderItem addOrderItem(Vaccine v, int quantity) {
        OrderItem orderItem = new OrderItem();
        orderItem.setProduct(v);
        orderItem.setQuantity(quantity);
        orderItemList.add(orderItem);
        return orderItem;
    }

    public void removeOrderItem(OrderItem orderItem) {
        orderItemList.remove(orderItem);
    }

}
