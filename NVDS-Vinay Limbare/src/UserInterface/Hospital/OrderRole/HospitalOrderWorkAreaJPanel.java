/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Hospital.OrderRole;

import Business.Ecosystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.HospitalEnterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Vinay Limbare
 */
public class HospitalOrderWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form HospitalOrderWorkAreaJPanel
     */
    JPanel userProcessContainer;
    UserAccount account;
    Enterprise enterprise;
    Ecosystem system;
    Organization organization;

    public HospitalOrderWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, Ecosystem system) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.account = account;
        this.enterprise = enterprise;
        this.system = system;
        this.organization = organization;
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
        browseVaccineJButton = new javax.swing.JButton();
        viewOrderJButton = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Order Work Area");

        browseVaccineJButton.setText("Browse Vaccines");
        browseVaccineJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseVaccineJButtonActionPerformed(evt);
            }
        });

        viewOrderJButton.setText("View Order");
        viewOrderJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewOrderJButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(267, 267, 267)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(browseVaccineJButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(viewOrderJButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(249, 249, 249)
                        .addComponent(jLabel1)))
                .addContainerGap(274, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel1)
                .addGap(63, 63, 63)
                .addComponent(browseVaccineJButton)
                .addGap(45, 45, 45)
                .addComponent(viewOrderJButton)
                .addContainerGap(209, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void browseVaccineJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseVaccineJButtonActionPerformed
        // TODO add your handling code here:
        Network n = null;
        for (Network network : system.getNetworkDirectory().getNetworkList()) {
            for (Enterprise e : network.getEnterpriseDirectory().getEnterpriseList()) {
                if (e == enterprise) {
                    n = network;
                    break;
                }
            }
        }
        HospitalEnterprise e1 = null;
        for (Enterprise e : n.getEnterpriseDirectory().getEnterpriseList()) {
            if (e instanceof HospitalEnterprise) {
                e1 = (HospitalEnterprise) e;
            }
        }
        if (e1.getRegistrationStatus().equals("Approved")) {
            BrowseVaccineJPanel browseVaccineJPanel = new BrowseVaccineJPanel(userProcessContainer, account, organization, e1, system);
            userProcessContainer.add("manageNetworkJPanel", browseVaccineJPanel);
            CardLayout layout = (CardLayout) userProcessContainer.getLayout();
            layout.next(userProcessContainer);
        } else {
            JOptionPane.showMessageDialog(null, "Hospital is either Rejected or still not Approved");
            return;
        }
    }//GEN-LAST:event_browseVaccineJButtonActionPerformed

    private void viewOrderJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewOrderJButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_viewOrderJButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton browseVaccineJButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton viewOrderJButton;
    // End of variables declaration//GEN-END:variables
}
