/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.CDC;

import Business.Ecosystem;
import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.Enterprise.HospitalEnterprise;
import Business.Enterprise.NationalDistributorEnterprise;
import Business.Enterprise.PharmacyEnterprise;
import Business.Inventory.InventoryDirectory;
import Business.Inventory.InventoryItem;
import Business.Network.Network;
import Business.Order.Order;
import Business.Order.OrderItem;
import Business.Organization.OrderOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.Vaccine.Vaccine;
import Business.WorkQueue.OrderProcessingRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Vinay Limbare
 */
public class ManageVaccineOrdersJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManageOrders
     */
    private JPanel userProcessContainer;
    private UserAccount userAccount;
    private Ecosystem system;
    private InventoryDirectory invDir;

    public ManageVaccineOrdersJPanel(JPanel userProcessContainer, Ecosystem system) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        for (UserAccount ua : system.getUserAccountDirectory().getUserAccountList()) {
            if (ua.getUsername().equals("sys")) {
                this.userAccount = ua;
            }
        }
        this.system = system;
        populateTable();
        populateNetworkTable();
    }

    private void populateTable() {

        DefaultTableModel dtm = (DefaultTableModel) ordersTable.getModel();
        dtm.setRowCount(0);
        Enterprise e1 = null;

        for (WorkRequest request : system.getWorkQueue().getWorkRequestList()) {
            if (request instanceof OrderProcessingRequest) {
                OrderProcessingRequest req = (OrderProcessingRequest) request;
                Object[] row = new Object[4];
                row[0] = req.getOrderProcessId();
                row[1] = req.getSender().getEmployee().getName();
                row[2] = req.getReceiver() == null ? null : req.getReceiver().getEmployee().getName();
                row[3] = req;
                dtm.addRow(row);

            }
        }
    }

    private void populateNetworkTable() {

        DefaultTableModel dtm = (DefaultTableModel) networkDetails.getModel();
        dtm.setRowCount(0);
        Network n = null;
        invDir = new InventoryDirectory();
        for (Network network : system.getNetworkDirectory().getNetworkList()) {
            for (Vaccine vaccine : system.getVaccineDirectory().getVaccineList()) {
                int quantity = 0;
                for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {
                    if (enterprise instanceof HospitalEnterprise || enterprise instanceof PharmacyEnterprise) {
                        for (Organization org : enterprise.getOrganizationDirectory().getOrganizationList()) {
                            if (org instanceof OrderOrganization) {
                                for (Employee emp : org.getEmployeeDirectory().getEmployeeList()) {
                                    for (Order order : emp.getMasterOrderCatalog().getOrderCatalog()) {
                                        if (order.getOrderStatus().equalsIgnoreCase("Approved & Shipped")) {
                                            for (OrderItem oi : order.getOrderItemList()) {
                                                if (vaccine.getVaccineId() == oi.getVaccine().getVaccineId()) {
                                                    n = network;
                                                    quantity = quantity + oi.getQuantity();
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                invDir.addInventory(network, vaccine, quantity);
            }
        }
        for (InventoryItem inventoryItem : invDir.getInventoryList()) {
            Object row[] = new Object[5];
            row[0] = inventoryItem.getNetwork();
            row[1] = inventoryItem.getVaccine().getVaccineName();
            row[2] = inventoryItem.getQuantity();
            row[3] = inventoryItem.getNetwork().getPopulation() * 0.4;
            row[4] = inventoryItem.getAvailability();
            dtm.addRow(row);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        ordersTable = new javax.swing.JTable();
        assignToMeJButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        approveOrder = new javax.swing.JButton();
        rejectOrder = new javax.swing.JButton();
        orderDetailsButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        vaccineCatalog = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        networkDetails = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ordersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Order ID", "Sender Name", "Approver Name", "Order Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(ordersTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 200, 505, 180));

        assignToMeJButton.setText("Assign To Me");
        assignToMeJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assignToMeJButtonActionPerformed(evt);
            }
        });
        add(assignToMeJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 400, -1, -1));

        backButton.setText("<< Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 150, -1, -1));

        approveOrder.setText("Approve Order");
        approveOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                approveOrderActionPerformed(evt);
            }
        });
        add(approveOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 400, -1, -1));

        rejectOrder.setText("Reject Order");
        rejectOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rejectOrderActionPerformed(evt);
            }
        });
        add(rejectOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 400, -1, -1));

        orderDetailsButton.setText("View Order Details");
        orderDetailsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderDetailsButtonActionPerformed(evt);
            }
        });
        add(orderDetailsButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 400, -1, -1));

        vaccineCatalog.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "ID", "Price", "Quantity", "Total Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(vaccineCatalog);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 200, 375, 180));

        networkDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Network Name", "Vaccine Name", "Total Order Quantity", "Max Quantity", "Remaining Quantity"
            }
        ));
        jScrollPane3.setViewportView(networkDetails);
        if (networkDetails.getColumnModel().getColumnCount() > 0) {
            networkDetails.getColumnModel().getColumn(0).setResizable(false);
            networkDetails.getColumnModel().getColumn(1).setResizable(false);
            networkDetails.getColumnModel().getColumn(2).setResizable(false);
            networkDetails.getColumnModel().getColumn(3).setResizable(false);
            networkDetails.getColumnModel().getColumn(4).setResizable(false);
        }

        add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 500, 890, 210));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Manage Vaccine Orders");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 50, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void orderDetailsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderDetailsButtonActionPerformed
        // TODO add your handling code here:
        int selectedRow = ordersTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select an order to view");
            return;
        }
        DefaultTableModel dtm = (DefaultTableModel) vaccineCatalog.getModel();
        dtm.setRowCount(0);
        OrderProcessingRequest request = (OrderProcessingRequest) ordersTable.getValueAt(selectedRow, 3);
        Order ord = null;

        Employee employee = request.getEmployee();
        for (Order order : employee.getMasterOrderCatalog().getOrderCatalog()) {
            if (request.getOrderProcessId() == order.getOrderNumber()) {
                ord = order;
                break;
            }
        }
        for (OrderItem oi : ord.getOrderItemList()) {
            Object row[] = new Object[5];
            row[0] = oi;
            row[1] = oi.getVaccine().getVaccineId();
            row[2] = oi.getVaccine().getVaccinePrice();
            row[3] = oi.getQuantity();
            row[4] = oi.getVaccine().getVaccinePrice() * oi.getQuantity();
            dtm.addRow(row);
        }
    }//GEN-LAST:event_orderDetailsButtonActionPerformed

    private void rejectOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rejectOrderActionPerformed
        // TODO add your handling code here:
        int selectedRow = ordersTable.getSelectedRow();
        int quantity = 0;
        int orginalQuantity = 0;

        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a order to approve");
            return;
        }
        OrderProcessingRequest request = (OrderProcessingRequest) ordersTable.getValueAt(selectedRow, 3);
        if (request.getStatus().equals("Approved") || request.getStatus().equals("Rejected")) {
            JOptionPane.showMessageDialog(null, "Enrollment Request already processed");
            return;
        }
        if (request.getReceiver() == null) {
            JOptionPane.showMessageDialog(null, "Request has to be assigned first");
            return;
        }
        if (!(request.getReceiver() == userAccount)) {
            JOptionPane.showMessageDialog(null, "Request has been assigned to another sales rep");
            return;
        }
        request.setOrderProcessingStatus("Rejected");
        request.setStatus("Rejected");
        UserAccount ua = request.getSender();
        Employee employee = (Employee) request.getEmployee();
        for (Order order : employee.getMasterOrderCatalog().getOrderCatalog()) {
            if (order.getOrderNumber() == request.getOrderProcessId()) {
                order.setOrderStatus("Rejected");
            }
        }
        JOptionPane.showMessageDialog(null, "Request processed");
        populateTable();
    }//GEN-LAST:event_rejectOrderActionPerformed

    private void approveOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_approveOrderActionPerformed
        // TODO add your handling code here:
        int selectedRow = ordersTable.getSelectedRow();

        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a order to approve");
            return;
        }
        OrderProcessingRequest request = (OrderProcessingRequest) ordersTable.getValueAt(selectedRow, 3);
        if (request.getStatus().equals("Approved") || request.getStatus().equals("Rejected")) {
            JOptionPane.showMessageDialog(null, "Order Request already processed");
            return;
        }
        if (request.getReceiver() == null) {
            JOptionPane.showMessageDialog(null, "Request has to be assigned first");
            return;
        }
        if (!(request.getReceiver() == userAccount)) {
            JOptionPane.showMessageDialog(null, "Request has been assigned to another sales rep");
            return;
        }
        UserAccount ua = request.getSender();
        Employee employee = (Employee) request.getEmployee();

        Network net = null;
        for (Network network : system.getNetworkDirectory().getNetworkList()) {
            for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {
                for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
                    for (Employee employee1 : organization.getEmployeeDirectory().getEmployeeList()) {
                        if (request.getEmployee().getId() == employee1.getId()) {
                            net = network;
                        }
                    }
                }
            }
        }
        Order ord = null;
        for (Order order : employee.getMasterOrderCatalog().getOrderCatalog()) {
            if (request.getOrderProcessId() == order.getOrderNumber()) {
                ord = order;
                break;
            }
        }

        for (OrderItem oi : ord.getOrderItemList()) {
            for (InventoryItem item : invDir.getInventoryList()) {
                if (item.getVaccine().getVaccineId() == oi.getVaccine().getVaccineId()) {
                    if (net == item.getNetwork()) {
                        if (oi.getQuantity() > item.getAvailability()) {
                            JOptionPane.showMessageDialog(null, "Vaccine limit is crossed for the network. Request is rejected.");
                            request.setOrderProcessingStatus("Rejected");
                            request.setStatus("Rejected");
                            UserAccount ua1 = request.getSender();
                            Employee employee1 = (Employee) request.getEmployee();
                            for (Order order : employee1.getMasterOrderCatalog().getOrderCatalog()) {
                                if (order.getOrderNumber() == request.getOrderProcessId()) {
                                    order.setOrderStatus("Rejected");
                                }
                            }
                            return;
                        }
                    }
                }
            }
        }

        request.setOrderProcessingStatus("Approved");
        request.setStatus("Approved");

        for (Order order : employee.getMasterOrderCatalog().getOrderCatalog()) {
            if (order.getOrderNumber() == request.getOrderProcessId()) {
                order.setOrderStatus("Approved");
            }
        }
        JOptionPane.showMessageDialog(null, "Request processed");
        populateTable();

        OrderProcessingRequest shippingRequest = new OrderProcessingRequest();
        shippingRequest.setStatus("Approved waiting to be shipped");
        shippingRequest.setOrderProcessingStatus("Approved waiting to be shipped");

        for (Order order : employee.getMasterOrderCatalog().getOrderCatalog()) {
            if (order.getOrderNumber() == request.getOrderProcessId()) {
                order.setOrderStatus("Approved waiting to be shipped");
            }
        }
        shippingRequest.setSender(request.getSender());
        shippingRequest.setOrderProcessId(request.getOrderProcessId());
        shippingRequest.setEmployee(employee);
        NationalDistributorEnterprise e1 = system.getNationalDistributorEnterprise();
        JOptionPane.showMessageDialog(null, e1.getName());
        if (e1 != null) {
            e1.getWorkQueue().getWorkRequestList().add(shippingRequest);
            ua.getWorkQueue().getWorkRequestList().add(shippingRequest);
        }
    }//GEN-LAST:event_approveOrderActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backButtonActionPerformed

    private void assignToMeJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assignToMeJButtonActionPerformed
        // TODO add your handling code here:
        int selectedRow = ordersTable.getSelectedRow();

        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a row !!!");
            return;
        }
        OrderProcessingRequest request = (OrderProcessingRequest) ordersTable.getValueAt(selectedRow, 3);

        if (ordersTable.getValueAt(selectedRow, 2) == null) {
            request.setReceiver(userAccount);
            request.setStatus("Pending for approval");
            JOptionPane.showMessageDialog(null, "Request has been assigned");
            Employee employee = (Employee) request.getEmployee();
            for (Order order : employee.getMasterOrderCatalog().getOrderCatalog()) {
                if (order.getOrderNumber() == request.getOrderProcessId()) {
                    order.setOrderStatus("Pending for Approval");
                }
            }
            request.setOrderProcessingStatus("Pending for approval");
            populateTable();
        } else {
            JOptionPane.showMessageDialog(null, "Request has been assigned already");
        }
    }//GEN-LAST:event_assignToMeJButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton approveOrder;
    private javax.swing.JButton assignToMeJButton;
    private javax.swing.JButton backButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable networkDetails;
    private javax.swing.JButton orderDetailsButton;
    private javax.swing.JTable ordersTable;
    private javax.swing.JButton rejectOrder;
    private javax.swing.JTable vaccineCatalog;
    // End of variables declaration//GEN-END:variables
}
