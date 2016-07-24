/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Order;

import Business.Vaccine.Vaccine;

/**
 *
 * @author Vinay Limbare
 */
public class OrderItem {

    private Vaccine vaccine;
    private int quantity;
    private float salesPrice;

    public Vaccine getVaccine() {
        return vaccine;
    }

    public void setProduct(Vaccine vaccine) {
        this.vaccine = vaccine;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getSalesPrice() {
        return salesPrice;
    }

    public void setSalesPrice(float salesPrice) {
        this.salesPrice = salesPrice;
    }

    @Override
    public String toString() {
        return vaccine.getVaccineName();
    }
}
