/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Hospital.Clinic;

import UserInterface.Hospital.OrderRole.*;
import Business.Ecosystem;
import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.Enterprise.StatePHDEnterprise;
import Business.Network.Network;
import Business.Order.Order;
import Business.Order.OrderItem;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.Vaccine.Vaccine;
import Business.WorkQueue.OrderProcessingRequest;
import java.awt.CardLayout;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Vinay Limbare
 */
public class BrowseVaccineJPanel extends javax.swing.JPanel {

    /**
     * Creates new form BrowseVaccineJPanel
     */
    private JPanel upc;
    private UserAccount ua;
    private Organization organization;
    private Enterprise enterprise;
    private Ecosystem system;
    private Order order;
    private boolean isCheckedOut = false;

    public BrowseVaccineJPanel(JPanel upc, UserAccount ua, Organization organization, Enterprise enterprise, Ecosystem system) {
        initComponents();
        this.upc = upc;
        this.ua = ua;
        this.organization = organization;
        this.enterprise = enterprise;
        this.system = system;
        if (isCheckedOut == false) {
            order = new Order();
        }

        populateVaccineDetailsTable();
    }

    private void populateVaccineDetailsTable() {
        DefaultTableModel dtm = (DefaultTableModel) vaccineDetailsTable.getModel();
        dtm.setRowCount(0);
        for (Vaccine vaccine : system.getVaccineDirectory().getVaccineList()) {
            Object row[] = new Object[3];
            row[0] = vaccine;
            row[1] = vaccine.getVaccineId();
            row[2] = vaccine.getDiseaseName();
            dtm.addRow(row);
        }
    }

    private void populateOrderDetailsTable(Order order) {
        DefaultTableModel dtm = (DefaultTableModel) orderItemTable.getModel();
        dtm.setRowCount(0);
        if (order != null) {
            for (OrderItem orderItem : order.getOrderItemList()) {
                Object row[] = new Object[2];
                row[0] = orderItem;
                row[1] = orderItem.getQuantity();
                dtm.addRow(row);
            }
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        vaccineDetailsTable = new javax.swing.JTable();
        addToCartButton = new javax.swing.JButton();
        quantityLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        orderItemTable = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        viewOrderDetailsButton = new javax.swing.JButton();
        removeItemButton = new javax.swing.JButton();
        modifyQuantityButton = new javax.swing.JButton();
        modifyQuantityText = new javax.swing.JTextField();
        backButton = new javax.swing.JButton();
        checkOutButton = new javax.swing.JButton();
        qtyJSpinner = new javax.swing.JSpinner();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Browse Vaccine");

        vaccineDetailsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Vaccine Name", "Vaccine ID", "Disease Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(vaccineDetailsTable);

        addToCartButton.setText("ADD TO CART");
        addToCartButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addToCartButtonActionPerformed(evt);
            }
        });

        quantityLabel.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N

        jLabel2.setText("Quantity");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel3.setText("Vaccine List");

        orderItemTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Vaccine Name", "Quantity"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(orderItemTable);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel4.setText("Cart");

        viewOrderDetailsButton.setText("View Order Details");
        viewOrderDetailsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewOrderDetailsButtonActionPerformed(evt);
            }
        });

        removeItemButton.setText("Remove Item");
        removeItemButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeItemButtonActionPerformed(evt);
            }
        });

        modifyQuantityButton.setText("Modify Quantity");
        modifyQuantityButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyQuantityButtonActionPerformed(evt);
            }
        });

        backButton.setText("<< Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        checkOutButton.setText("CheckOut");
        checkOutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkOutButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(backButton)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(55, 55, 55)
                                        .addComponent(jLabel2)
                                        .addGap(10, 10, 10)
                                        .addComponent(qtyJSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(addToCartButton)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(quantityLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(81, 81, 81)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                    .addComponent(jLabel4)
                                                    .addGap(258, 258, 258))
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                    .addComponent(modifyQuantityText, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(modifyQuantityButton))
                                                .addComponent(removeItemButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(viewOrderDetailsButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(391, 391, 391)
                        .addComponent(checkOutButton)))
                .addContainerGap(162, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(quantityLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(modifyQuantityButton)
                            .addComponent(modifyQuantityText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(removeItemButton)
                        .addGap(18, 18, 18)
                        .addComponent(viewOrderDetailsButton))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(backButton)
                        .addGap(28, 28, 28)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(addToCartButton)
                            .addComponent(qtyJSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(61, 61, 61)
                .addComponent(checkOutButton)
                .addGap(84, 84, 84))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addToCartButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addToCartButtonActionPerformed
        // TODO add your handling code here:
        int selectedRow = vaccineDetailsTable.getSelectedRow();
        int selectedRowCount = vaccineDetailsTable.getSelectedRowCount();
        boolean flag = true;
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please Select a vaccine");
            return;
        }
        if (selectedRowCount > 1) {
            JOptionPane.showMessageDialog(null, "Please select only one vaccine");
            return;
        }

        Vaccine vaccine = (Vaccine) vaccineDetailsTable.getValueAt(selectedRow, 0);

        int quantity=(int)qtyJSpinner.getValue();
        if(quantity <=0){
            JOptionPane.showMessageDialog(null,"Invalid quantity");
            return;
        }
        if (order == null) {
            order = new Order();
        } else {
            ArrayList<OrderItem> oi = order.getOrderItemList();
            for (OrderItem orderItem : oi) {
                if (orderItem.getVaccine().equals(vaccine)) {
                    orderItem.setQuantity(quantity);
                    orderItem.setSalesPrice(vaccine.getVaccinePrice());
                    flag = false;
                }
            }
        }
        if (flag == true) {
            OrderItem oItem = order.addOrderItem(vaccine, quantity);
            oItem.setSalesPrice(vaccine.getVaccinePrice());
        }

        String message = String.valueOf(quantity) + " " + vaccine.getVaccineName() + " is added to the cart";
        JOptionPane.showMessageDialog(null, message);
        populateVaccineDetailsTable();
        populateOrderDetailsTable(order);
    }//GEN-LAST:event_addToCartButtonActionPerformed

    private void viewOrderDetailsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewOrderDetailsButtonActionPerformed
        // TODO add your handling code here:
        int selectedRow = orderItemTable.getSelectedRow();
        int selectedRowCount = orderItemTable.getSelectedRowCount();

        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please Select a order to view the details");
            return;
        }
        if (selectedRowCount > 1) {
            JOptionPane.showMessageDialog(null, "Please select only one order");
            return;
        }

        OrderItem orderItem = (OrderItem) orderItemTable.getValueAt(selectedRow, 0);
        ViewOrderItemDetailsJPanel view = new ViewOrderItemDetailsJPanel(upc, orderItem);
        upc.add("ViewOrderItemDetailsJPanel", view);
        CardLayout layout = (CardLayout) upc.getLayout();
        layout.next(upc);
    }//GEN-LAST:event_viewOrderDetailsButtonActionPerformed

    private void removeItemButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeItemButtonActionPerformed
        // TODO add your handling code here:
        int selectedRow = orderItemTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a row");
            return;
        }
        int selectedRowCount = orderItemTable.getSelectedRowCount();
        if (selectedRowCount > 1) {
            JOptionPane.showMessageDialog(null, "Please select only one order");
            return;
        }

        OrderItem orderItem = (OrderItem) orderItemTable.getValueAt(selectedRow, 0);
        order.removeOrderItem(orderItem);

        populateVaccineDetailsTable();
        populateOrderDetailsTable(order);
    }//GEN-LAST:event_removeItemButtonActionPerformed

    private void modifyQuantityButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifyQuantityButtonActionPerformed
        // TODO add your handling code here:
        int selectedRow = orderItemTable.getSelectedRow();
        int modifiedQuantity = 0;
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please Select a product to modify the quantity");
            return;
        }

        OrderItem orderItem = (OrderItem) orderItemTable.getValueAt(selectedRow, 0);
        try {
            modifiedQuantity = Integer.parseInt(modifyQuantityText.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Enter a quantity to modify");
            return;
        }

        if (modifiedQuantity <= 0) {
            JOptionPane.showMessageDialog(null, "Quantity is not appropriate");
            modifyQuantityText.setText(null);
            return;
        }

        orderItem.setQuantity(modifiedQuantity);

        populateVaccineDetailsTable();
        populateOrderDetailsTable(order);
    }//GEN-LAST:event_modifyQuantityButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        upc.remove(this);
        CardLayout layout = (CardLayout) upc.getLayout();
        layout.previous(upc);
    }//GEN-LAST:event_backButtonActionPerformed

    private void checkOutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkOutButtonActionPerformed
        // TODO add your handling code here:
        if (orderItemTable.getRowCount() != 0) {
            Employee employee = ua.getEmployee();
            Order addedOrder = employee.getMasterOrderCatalog().addOrder(order);

            if (addedOrder != null) {
                int ordQty=system.getOrderId();
                ordQty++;
                order.setOrderNumber(ordQty);
                order.setOrderStatus("Processing");

                order = new Order();

                OrderProcessingRequest request = new OrderProcessingRequest();
                request.setStatus("Processing");
                request.setOrderProcessingStatus("Processing");
                request.setSender(ua);
                request.setOrderProcessId(ordQty);
                Organization org = null;
                Enterprise e1 = null;
                Network n = null;
                for (Network network : system.getNetworkDirectory().getNetworkList()) {
                    for (Enterprise e : network.getEnterpriseDirectory().getEnterpriseList()) {
                        if (e == enterprise) {
                            n = network;
                            break;
                        }
                    }
                }
                for (Enterprise e : n.getEnterpriseDirectory().getEnterpriseList()) {
                    if (e instanceof StatePHDEnterprise) {
                        e1 = e;
                    }
                }
                if (e1 != null) {
                    e1.getWorkQueue().getWorkRequestList().add(request);
                    ua.getWorkQueue().getWorkRequestList().add(request);
                }
                JOptionPane.showMessageDialog(null, "Your Order has been checked out! Thanks!");

            } else {
                return;
            }
            isCheckedOut = true;
            populateVaccineDetailsTable();
            populateOrderDetailsTable(order);
        } else {
            JOptionPane.showMessageDialog(null, "There is no items to checkout");
        }
    }//GEN-LAST:event_checkOutButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addToCartButton;
    private javax.swing.JButton backButton;
    private javax.swing.JButton checkOutButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton modifyQuantityButton;
    private javax.swing.JTextField modifyQuantityText;
    private javax.swing.JTable orderItemTable;
    private javax.swing.JSpinner qtyJSpinner;
    private javax.swing.JLabel quantityLabel;
    private javax.swing.JButton removeItemButton;
    private javax.swing.JTable vaccineDetailsTable;
    private javax.swing.JButton viewOrderDetailsButton;
    // End of variables declaration//GEN-END:variables
}