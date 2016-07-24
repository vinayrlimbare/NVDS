/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Provider;

import Business.Ecosystem;
import Business.Enterprise.Enterprise;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author Vinay Limbare
 */
public class ProviderAdminWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ProviderAdminWorkAreaJPanel
     */
    JPanel userProcessContainer;
    Ecosystem system;
    Enterprise enterprise;

    public ProviderAdminWorkAreaJPanel(JPanel userProcessContainer, Enterprise enterprise, Ecosystem system) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.system = system;
        this.enterprise = enterprise;
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
        manageProviderJButton = new javax.swing.JButton();
        manageProviderAdminJButton = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Provider Admin Work Area");

        manageProviderJButton.setText("Manage Provider");
        manageProviderJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageProviderJButtonActionPerformed(evt);
            }
        });

        manageProviderAdminJButton.setText("Manage Provider Admin");
        manageProviderAdminJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageProviderAdminJButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(207, 207, 207)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(manageProviderJButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(manageProviderAdminJButton, javax.swing.GroupLayout.Alignment.LEADING))))
                .addContainerGap(187, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel1)
                .addGap(72, 72, 72)
                .addComponent(manageProviderJButton)
                .addGap(45, 45, 45)
                .addComponent(manageProviderAdminJButton)
                .addContainerGap(238, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void manageProviderJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageProviderJButtonActionPerformed
        // TODO add your handling code here:
        ManageProviderJPanel manageProviderJPanel = new ManageProviderJPanel(userProcessContainer, enterprise, system);
        userProcessContainer.add("manageEnterpriseJPanel", manageProviderJPanel);

        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_manageProviderJButtonActionPerformed

    private void manageProviderAdminJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageProviderAdminJButtonActionPerformed
        // TODO add your handling code here:
        ManageProviderAdminJPanel manageProviderAdminJPanel = new ManageProviderAdminJPanel(userProcessContainer, enterprise, system);
        userProcessContainer.add("manageEnterpriseJPanel", manageProviderAdminJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_manageProviderAdminJButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton manageProviderAdminJButton;
    private javax.swing.JButton manageProviderJButton;
    // End of variables declaration//GEN-END:variables
}