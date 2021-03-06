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
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Vinay Limbare
 */
public class ReportJPanel extends javax.swing.JPanel {

    /**
     * Creates new form Report
     */
    private JPanel userProcessContainer;
    private UserAccount userAccount;
    private Ecosystem system;

    public ReportJPanel(JPanel userProcessContainer, Ecosystem system) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.system = system;
        populateVaccineComboBox();
        populateTable();
    }

    public void populateVaccineComboBox() {
        vaccineJComboBox.removeAllItems();
        for (Vaccine vaccine : system.getVaccineDirectory().getVaccineList()) {
            vaccineJComboBox.addItem(vaccine);
        }
    }

    public void populateTable() {

        Vaccine vac = (Vaccine) vaccineJComboBox.getSelectedItem();

        DefaultTableModel dtm = (DefaultTableModel) reportJTable.getModel();
        dtm.setRowCount(0);

        Network n = null;
        InventoryDirectory invDir = new InventoryDirectory();

        for (Network network : system.getNetworkDirectory().getNetworkList()) {
            for (Vaccine vaccine : system.getVaccineDirectory().getVaccineList()) {
                if (vaccine.equals(vac)) {
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
        }
        for (InventoryItem inventoryItem : invDir.getInventoryList()) {
            Object row[] = new Object[2];
            row[0] = inventoryItem.getNetwork();
            row[1] = inventoryItem.getQuantity();
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

        jLabel1 = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();
        vaccineJComboBox = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        reportJTable = new javax.swing.JTable();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Business Intelligence");

        backButton.setText("<< Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        vaccineJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vaccineJComboBoxActionPerformed(evt);
            }
        });

        jLabel2.setText("Vaccine");

        reportJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Network", "Quantity"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(reportJTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(backButton)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(vaccineJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(290, 290, 290)
                        .addComponent(jLabel1)))
                .addContainerGap(448, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(backButton)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(vaccineJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(32, 32, 32)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(112, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backButtonActionPerformed

    private void vaccineJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vaccineJComboBoxActionPerformed
        // TODO add your handling code here:
        populateTable();
    }//GEN-LAST:event_vaccineJComboBoxActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable reportJTable;
    private javax.swing.JComboBox vaccineJComboBox;
    // End of variables declaration//GEN-END:variables
}
