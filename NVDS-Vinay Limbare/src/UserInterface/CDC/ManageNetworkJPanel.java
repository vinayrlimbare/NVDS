/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.CDC;

import Business.Ecosystem;
import Business.Network.Network;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Vinay Limbare
 */
public class ManageNetworkJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private Ecosystem system;

    /**
     *
     * Creates new form ManageNetworkJPanel
     */
    public ManageNetworkJPanel(JPanel userProcessContainer, Ecosystem system) {
        initComponents();

        this.userProcessContainer = userProcessContainer;
        this.system = system;

        populateNetworkTable();
    }

    private void populateNetworkTable() {
        DefaultTableModel model = (DefaultTableModel) networkJTable.getModel();

        model.setRowCount(0);
        for (Network network : system.getNetworkDirectory().getNetworkList()) {
            Object[] row = new Object[2];
            row[0] = network.getName();
            row[1] = network.getPopulation();
            model.addRow(row);
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
        networkJTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        submitJButton = new javax.swing.JButton();
        nameJTextField = new javax.swing.JTextField();
        backJButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        populationJTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        networkJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Network", "Population"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(networkJTable);
        if (networkJTable.getColumnModel().getColumnCount() > 0) {
            networkJTable.getColumnModel().getColumn(0).setResizable(false);
            networkJTable.getColumnModel().getColumn(1).setResizable(false);
        }

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, 400, 150));

        jLabel1.setText("Name");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 310, -1, -1));

        submitJButton.setText("Submit");
        submitJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitJButtonActionPerformed(evt);
            }
        });
        add(submitJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 400, -1, -1));
        add(nameJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 310, 93, -1));

        backJButton.setText("<< Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        add(backJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, -1, -1));

        jLabel4.setText("Population");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 350, 60, -1));

        populationJTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                populationJTextFieldActionPerformed(evt);
            }
        });
        add(populationJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 350, 90, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("Manage Network");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void submitJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitJButtonActionPerformed

        String name = nameJTextField.getText();
        if(name.isEmpty()){
            JOptionPane.showMessageDialog(null, "Name cannot be empty !!!");
            return;
        }
        Network network = system.getNetworkDirectory().createAndAddNetwork(name);
        network.setPopulation(Integer.valueOf(populationJTextField.getText()));

        populateNetworkTable();
    }//GEN-LAST:event_submitJButtonActionPerformed

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void populationJTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_populationJTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_populationJTextFieldActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nameJTextField;
    private javax.swing.JTable networkJTable;
    private javax.swing.JTextField populationJTextField;
    private javax.swing.JButton submitJButton;
    // End of variables declaration//GEN-END:variables
}
