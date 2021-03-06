/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.NationalDistributor;

import Business.Ecosystem;
import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.Enterprise.HospitalEnterprise;
import Business.Enterprise.ManufacturerEnterprise;
import Business.Enterprise.PharmacyEnterprise;
import Business.Inventory.InventoryItem;
import Business.Network.Network;
import Business.Order.Order;
import Business.Order.OrderItem;
import Business.Organization.FinanceOrganization;
import Business.Organization.OrderOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.InvoiceWorkRequest;
import Business.WorkQueue.ManufacturerWorkRequest;
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
public class ManageOrdersJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManageOrders
     */
    private JPanel userProcessContainer;
    private UserAccount userAccount;
    private Enterprise enterprise;
    private Ecosystem system;
    boolean finalflag;

    public ManageOrdersJPanel(JPanel userProcessContainer, UserAccount userAccount, Enterprise enterprise, Ecosystem system) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.userAccount = userAccount;
        this.enterprise = enterprise;
        this.system = system;

        populateTable();
        populateStateComboBox();
    }

    private void populateTable() {

        DefaultTableModel dtm = (DefaultTableModel) ordersTable.getModel();
        dtm.setRowCount(0);
        for (WorkRequest request : system.getNationalDistributorEnterprise().getWorkQueue().getWorkRequestList()) {

            if (request instanceof OrderProcessingRequest) {
                OrderProcessingRequest req = (OrderProcessingRequest) request;
                Object[] row = new Object[5];
                row[0] = req.getOrderProcessId();
                row[1] = req.getSender().getEmployee();
                row[2] = req.getReceiver() == null ? null : req.getReceiver().getEmployee().getName();
                row[3] = req;
                row[4] = req.getPaymentStatus();
                dtm.addRow(row);
            }
        }
    }

    public void populateStateComboBox() {
        stateComboBox.removeAllItems();
        for (Network network : system.getNetworkDirectory().getNetworkList()) {
            stateComboBox.addItem(network);
        }
    }

    public void populateInventoryTable(Network network) {
        DefaultTableModel dtm = (DefaultTableModel) inventoryDetailsTable.getModel();
        dtm.setRowCount(0);
        for (InventoryItem inventoryItem : network.getInventoryDirectory().getInventoryList()) {
            Object[] row = new Object[7];
            row[0] = inventoryItem.getVaccine();
            row[1] = inventoryItem.getVaccine().getVaccineId();
            row[2] = inventoryItem.getVaccine().getDiseaseName();
            row[3] = inventoryItem.getVaccine().getManufactureDate();
            row[4] = inventoryItem.getVaccine().getExpiryDate();
            row[5] = inventoryItem.getQuantity();
            row[6] = inventoryItem.getVaccine().getVaccinePrice();
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
        assignToMeButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        approveOrder = new javax.swing.JButton();
        rejectOrder = new javax.swing.JButton();
        orderDetailsButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        vaccineCatalog = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        stateComboBox = new javax.swing.JComboBox();
        jScrollPane3 = new javax.swing.JScrollPane();
        inventoryDetailsTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        billJButton = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ordersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Order ID", "Requester Name", "Approver Name", "Order Status", "Payment"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(ordersTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 430, 710, 200));

        assignToMeButton.setText("Assign To Me");
        assignToMeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assignToMeButtonActionPerformed(evt);
            }
        });
        add(assignToMeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 650, -1, -1));

        backButton.setText("<< Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, -1, -1));

        approveOrder.setText("Approve Order");
        approveOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                approveOrderActionPerformed(evt);
            }
        });
        add(approveOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 650, -1, -1));

        rejectOrder.setText("Reject Order");
        rejectOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rejectOrderActionPerformed(evt);
            }
        });
        add(rejectOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 650, -1, -1));

        orderDetailsButton.setText("View Order Details");
        orderDetailsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderDetailsButtonActionPerformed(evt);
            }
        });
        add(orderDetailsButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 650, -1, -1));

        vaccineCatalog.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "ID", "Quantity"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(vaccineCatalog);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 430, 310, 200));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Manage Vaccine Distribution Orders");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 70, -1, -1));

        stateComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stateComboBoxActionPerformed(evt);
            }
        });
        add(stateComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 160, 140, -1));

        inventoryDetailsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Vaccine Name", "Vaccine ID", "Disease Name", "Manufacture Date", "Expiry Date", "Quantity", "Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(inventoryDetailsTable);
        if (inventoryDetailsTable.getColumnModel().getColumnCount() > 0) {
            inventoryDetailsTable.getColumnModel().getColumn(0).setResizable(false);
            inventoryDetailsTable.getColumnModel().getColumn(1).setResizable(false);
            inventoryDetailsTable.getColumnModel().getColumn(2).setResizable(false);
            inventoryDetailsTable.getColumnModel().getColumn(3).setResizable(false);
            inventoryDetailsTable.getColumnModel().getColumn(4).setResizable(false);
            inventoryDetailsTable.getColumnModel().getColumn(5).setResizable(false);
            inventoryDetailsTable.getColumnModel().getColumn(6).setResizable(false);
        }

        add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 210, 1070, 180));

        jLabel2.setText("Network");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 160, 60, 20));

        billJButton.setText("Generate Bill");
        billJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                billJButtonActionPerformed(evt);
            }
        });
        add(billJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 650, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void assignToMeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assignToMeButtonActionPerformed
        // TODO add your handling code here:
        int selectedRow = ordersTable.getSelectedRow();

        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a row");
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
            request.setOrderProcessingStatus("Pending for approval with " + userAccount.getEmployee().getName());
            populateTable();
        } else {
            JOptionPane.showMessageDialog(null, "Request has been assigned already");
        }
    }//GEN-LAST:event_assignToMeButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backButtonActionPerformed

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

        if (!request.isInvoice()) {
            JOptionPane.showMessageDialog(null, "Bill has not been generated!!");
            return;

        }

        if (request.getPaymentStatus() != "Paid") {
            JOptionPane.showMessageDialog(null, "Order is not paid!!");
            return;
        }
        //Employee employee = (Employee) request.getEmployee();
        UserAccount user = request.getSender();
        Employee employee = user.getEmployee();

        Network n = null;
        Enterprise e = null;
        for (Network network : system.getNetworkDirectory().getNetworkList()) {
            for (Enterprise e1 : network.getEnterpriseDirectory().getEnterpriseList()) {
                for (Organization org : e1.getOrganizationDirectory().getOrganizationList()) {
                    for (Employee emp : org.getEmployeeDirectory().getEmployeeList()) {
                        if (emp.getId() == employee.getId()) {
                            n = network;
                            break;
                        }
                    }
                }
            }
        }

        Order ord = null;
        boolean orderFlag = false;

        for (Order order : employee.getMasterOrderCatalog().getOrderCatalog()) {
            if (request.getOrderProcessId() == order.getOrderNumber()) {
                ord = order;
                break;
            }
        }

        boolean flag = true;
        for (InventoryItem inventoryItem : n.getInventoryDirectory().getInventoryList()) {
            for (OrderItem oi : ord.getOrderItemList()) {
                if (inventoryItem.getVaccine() == oi.getVaccine()) {
                    if (inventoryItem.getQuantity() >= oi.getQuantity()) {
                        JOptionPane.showMessageDialog(null, oi.getVaccine().getVaccineName() + " exits in the inventory");
                    } else {
                        flag = false;
                        JOptionPane.showMessageDialog(null, "Not enough " + oi.getVaccine().getVaccineName() + "!!! Order has been placed to the manufacturer");

                        ManufacturerWorkRequest manufactureRequest = new ManufacturerWorkRequest();
                        manufactureRequest.setStatus("Processing");
                        manufactureRequest.setVaccineId(inventoryItem.getVaccine().getVaccineId());
                        manufactureRequest.setQuantity(oi.getQuantity() - inventoryItem.getQuantity());
                        manufactureRequest.setSender(userAccount);
                        manufactureRequest.setStatus("Processing");
                        manufactureRequest.setPaymentStatus("Unpaid");

                        for (Network network1 : system.getNetworkDirectory().getNetworkList()) {
                            for (Enterprise e1 : network1.getEnterpriseDirectory().getEnterpriseList()) {
                                for (Organization org : e1.getOrganizationDirectory().getOrganizationList()) {
                                    for (Employee emp : org.getEmployeeDirectory().getEmployeeList()) {
                                        if (emp.getId() == employee.getId()) {
                                            n = network1;
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                        Enterprise enterprise1 = null;
                        for (Enterprise e1 : n.getEnterpriseDirectory().getEnterpriseList()) {
                            if (e1 instanceof ManufacturerEnterprise) {
                                enterprise1 = e1;
                            }
                        }

                        if (enterprise1 != null) {
                            enterprise1.getWorkQueue().getWorkRequestList().add(manufactureRequest);
                        }
                    }
                }
            }
        }
        if (!flag) {
            request.setOrderProcessingStatus("Approved");
            request.setStatus("Pending with Manufacturer");
        } else {
            request.setOrderProcessingStatus("Approved");
            request.setStatus("Approved");
            for (Order order : employee.getMasterOrderCatalog().getOrderCatalog()) {
                if (order.getOrderNumber() == request.getOrderProcessId()) {
                    order.setOrderStatus("Approved & Shipped");
                }
            }
            JOptionPane.showMessageDialog(null, "Request processed");

            Enterprise eee = null;
            for (Network network : system.getNetworkDirectory().getNetworkList()) {
                for (Enterprise e1 : network.getEnterpriseDirectory().getEnterpriseList()) {
                    if (e1 instanceof HospitalEnterprise || e1 instanceof PharmacyEnterprise) {
                        for (Organization orgg : e1.getOrganizationDirectory().getOrganizationList()) {
                            if (orgg instanceof OrderOrganization) {
                                for (UserAccount ua : orgg.getUserAccountDirectory().getUserAccountList()) {
                                    if (ua.getUsername().equals(user.getUsername())) {
                                        eee = e1;
                                    }
                                }
                            }
                        }
                    }
                }
            }

            if (eee instanceof HospitalEnterprise) {
                HospitalEnterprise he = (HospitalEnterprise) eee;
                for (InventoryItem inventoryItem : n.getInventoryDirectory().getInventoryList()) {
                    for (OrderItem oi : ord.getOrderItemList()) {
                        if (inventoryItem.getVaccine() == oi.getVaccine()) {
                            if (inventoryItem.getQuantity() >= oi.getQuantity()) {
                                inventoryItem.setQuantity(inventoryItem.getQuantity() - oi.getQuantity());
                                InventoryItem itm = he.getInventoryDirectory().addAndUpdate(oi.getVaccine(), oi.getQuantity());
                            }
                        }
                    }
                }
            }
            if (eee instanceof PharmacyEnterprise) {
                PharmacyEnterprise he = (PharmacyEnterprise) eee;
                for (InventoryItem inventoryItem : n.getInventoryDirectory().getInventoryList()) {
                    for (OrderItem oi : ord.getOrderItemList()) {
                        if (inventoryItem.getVaccine() == oi.getVaccine()) {
                            if (inventoryItem.getQuantity() >= oi.getQuantity()) {
                                inventoryItem.setQuantity(inventoryItem.getQuantity() - oi.getQuantity());
                                InventoryItem itm = he.getInventoryDirectory().addAndUpdate(oi.getVaccine(), oi.getQuantity());
                            }
                        }
                    }
                }
            }

            populateTable();
            populateInventoryTable(n);

        }
    }//GEN-LAST:event_approveOrderActionPerformed

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
        UserAccount ua = request.getSender();
        Employee employee = (Employee) request.getEmployee();
        JOptionPane.showMessageDialog(null, employee.getName());

        for (Order order : employee.getMasterOrderCatalog().getOrderCatalog()) {
            if (request.getOrderProcessId() == order.getOrderNumber()) {
                ord = order;
                break;
            }
        }
        for (OrderItem oi : ord.getOrderItemList()) {
            Object row[] = new Object[3];
            row[0] = oi;
            row[1] = oi.getVaccine().getVaccineId();
            row[2] = oi.getQuantity();
            dtm.addRow(row);
        }
    }//GEN-LAST:event_orderDetailsButtonActionPerformed

    private void stateComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stateComboBoxActionPerformed
        Network network = (Network) stateComboBox.getSelectedItem();
        if (network != null) {
            populateInventoryTable(network);
        }
    }//GEN-LAST:event_stateComboBoxActionPerformed

    private void billJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_billJButtonActionPerformed
        // TODO add your handling code here:
        int selectedRow = ordersTable.getSelectedRow();

        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a order to Generate Bill!!!");
            return;
        }

        OrderProcessingRequest request = (OrderProcessingRequest) ordersTable.getValueAt(selectedRow, 3);

        if (request.isInvoice()) {
            JOptionPane.showMessageDialog(null, "Bill already generated!!!");
            return;
        }

        request.setInvoice(true);
        InvoiceWorkRequest invWrq = new InvoiceWorkRequest();

        Order ord = null;
        UserAccount ua = request.getSender();
        Employee employee = (Employee) request.getEmployee();
        JOptionPane.showMessageDialog(null, employee.getName());

        for (Order order : employee.getMasterOrderCatalog().getOrderCatalog()) {
            if (request.getOrderProcessId() == order.getOrderNumber()) {
                ord = order;
                break;
            }
        }

        float price = 0;
        for (OrderItem oi : ord.getOrderItemList()) {
            JOptionPane.showMessageDialog(null, oi.getQuantity());
            price = (price + (oi.getQuantity() * oi.getSalesPrice()));
        }

        invWrq.setOrderId(request.getOrderProcessId());
        invWrq.setTotalPrice(price);
        invWrq.setSender(userAccount);
        invWrq.setStatus("Bill sent to Provider");
        invWrq.setPaymentStatus("Unpaid");

        Network net = null;
        Organization org = null;
        Enterprise e = null;

        for (Network network : system.getNetworkDirectory().getNetworkList()) {
            for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {
                for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
                    for (UserAccount userAccount : organization.getUserAccountDirectory().getUserAccountList()) {
                        if (userAccount.getUsername().equals(ua.getUsername())) {
                            e = enterprise;
                            break;
                        }
                    }
                }
            }
        }

        for (Organization organization : e.getOrganizationDirectory().getOrganizationList()) {
            if (organization instanceof FinanceOrganization) {
                org = organization;
            }
        }

        if (org != null) {
            org.getWorkQueue().getWorkRequestList().add(invWrq);
            //enterprise.getWorkQueue().getWorkRequestList().add(invWrq);
            system.getNationalDistributorEnterprise().getWorkQueue().getWorkRequestList().add(invWrq);
        }
    }//GEN-LAST:event_billJButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton approveOrder;
    private javax.swing.JButton assignToMeButton;
    private javax.swing.JButton backButton;
    private javax.swing.JButton billJButton;
    private javax.swing.JTable inventoryDetailsTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton orderDetailsButton;
    private javax.swing.JTable ordersTable;
    private javax.swing.JButton rejectOrder;
    private javax.swing.JComboBox stateComboBox;
    private javax.swing.JTable vaccineCatalog;
    // End of variables declaration//GEN-END:variables
}
