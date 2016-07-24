/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.MasterOrder;

import Business.Order.Order;
import java.util.ArrayList;

/**
 *
 * @author Vinay Limbare
 */
public class MasterOrderCatalog {

    private ArrayList<Order> orderCatalog;

    public MasterOrderCatalog() {
        orderCatalog = new ArrayList<>();
    }

    public ArrayList<Order> getOrderCatalog() {
        return orderCatalog;
    }

    public void setOrderCatalog(ArrayList<Order> orderCatalog) {
        this.orderCatalog = orderCatalog;
    }

    public Order addOrder(Order order) {
        orderCatalog.add(order);
        return order;
    }
}
