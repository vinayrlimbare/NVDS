/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Pharmacy;

import Business.Ecosystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.StatePHDEnterprise;
import Business.Network.Network;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.ProviderRegistrationWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Vinay Limbare
 */
public class PharmacyRegisterJPanel extends javax.swing.JPanel {

    /**
     * Creates new form HospitalRegisterJPanel
     */
    JPanel userProcessContainer;
    UserAccount account;
    Enterprise enterprise;
    Ecosystem system;

    public PharmacyRegisterJPanel(JPanel userProcessContainer, UserAccount account, Enterprise enterprise, Ecosystem system) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.account = account;
        this.enterprise = enterprise;
        this.system = system;
        populateTable();
    }

    private void populateTable() {
        DefaultTableModel dtm = (DefaultTableModel) registerJTable.getModel();
        dtm.setRowCount(0);
        for (WorkRequest request : account.getWorkQueue().getWorkRequestList()) {
            Object[] row = new Object[3];
            row[0] = request.getSender();
            row[1] = request.getReceiver() == null ? "Unassigned" : request.getReceiver();
            ProviderRegistrationWorkRequest req = (ProviderRegistrationWorkRequest) request;
            row[2] = req.getStatus() == null ? "Waiting" : req.getStatus();
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
        registerJButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        registerJTable = new javax.swing.JTable();
        backJButton1 = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Pharmacy Registration");

        registerJButton.setText("Register");
        registerJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerJButtonActionPerformed(evt);
            }
        });

        registerJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Hospital", "Approver", "Registration Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(registerJTable);
        if (registerJTable.getColumnModel().getColumnCount() > 0) {
            registerJTable.getColumnModel().getColumn(0).setResizable(false);
            registerJTable.getColumnModel().getColumn(1).setResizable(false);
            registerJTable.getColumnModel().getColumn(2).setResizable(false);
        }

        backJButton1.setText("<< Back");
        backJButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(backJButton1)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(262, 262, 262)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(330, 330, 330)
                        .addComponent(registerJButton)))
                .addContainerGap(255, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel1)
                .addGap(37, 37, 37)
                .addComponent(backJButton1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(registerJButton)
                .addContainerGap(184, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void registerJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerJButtonActionPerformed
        // TODO add your handling code here:
        for(WorkRequest workRequest :account.getWorkQueue().getWorkRequestList()){
            if(workRequest instanceof ProviderRegistrationWorkRequest){
                JOptionPane.showMessageDialog(null, "Request is already made for this Hospital");
                return;
            }
        }
        ProviderRegistrationWorkRequest request = new ProviderRegistrationWorkRequest();
        request.setStatus("Registration Requested");
        request.setRegistrationStatus("Disabled");
        request.setSender(account);
        request.setProviderType("Pharmacy");
        Enterprise enterprise = null;
        for (Network network : system.getNetworkDirectory().getNetworkList()) {
            for (Enterprise e : network.getEnterpriseDirectory().getEnterpriseList()) {
                if (e instanceof StatePHDEnterprise) {
                    enterprise = e;
                    break;
                }
            }
        }
        if (enterprise != null) {
            enterprise.getWorkQueue().getWorkRequestList().add(request);
            account.getWorkQueue().getWorkRequestList().add(request);
        }
        populateTable();
    }//GEN-LAST:event_registerJButtonActionPerformed

    private void backJButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButton1ActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton registerJButton;
    private javax.swing.JTable registerJTable;
    // End of variables declaration//GEN-END:variables
}
