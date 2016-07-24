/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Employee.Employee;

/**
 *
 * @author Vinay Limbare
 */
public class OrderProcessingRequest extends WorkRequest {

    private String orderProcessingStatus;
    private int orderProcessId;
    private Employee employee;
    private boolean invoice = false;
    private String paymentStatus = "Not Defined";

    public OrderProcessingRequest() {
        employee = new Employee();
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public int getOrderProcessId() {
        return orderProcessId;
    }

    public void setOrderProcessId(int orderProcessId) {
        this.orderProcessId = orderProcessId;
    }

    public String getOrderProcessingStatus() {
        return orderProcessingStatus;
    }

    public void setOrderProcessingStatus(String orderProcessingStatus) {
        this.orderProcessingStatus = orderProcessingStatus;
    }

    public boolean isInvoice() {
        return invoice;
    }

    public void setInvoice(boolean invoice) {
        this.invoice = invoice;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}
