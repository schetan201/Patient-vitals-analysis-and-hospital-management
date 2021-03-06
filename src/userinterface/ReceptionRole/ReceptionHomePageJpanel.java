/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.ReceptionRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.AccountsOrganization;
import Business.Organization.ReceptionOrganization;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JPanel;
import userinterface.ReceptionRole.ReceptionInventoryWorkAreaJPanel;
import userinterface.ReceptionRole.ReceptionPoliceWorkAreaJPanel;


/**
 *
 * @author Dhairyasheel
 */


public class ReceptionHomePageJpanel extends javax.swing.JPanel {

    /**
     * Creates new form DoctorHomePageJpanel
     */
    private JPanel userProcessContainer;
    private ReceptionOrganization organization;
    private Enterprise enterprise;
    private UserAccount userAccount;
    private EcoSystem business;
    private AccountsOrganization accorg;
    
    
    
    public ReceptionHomePageJpanel(JPanel userProcessContainer, UserAccount account, ReceptionOrganization organization, Enterprise enterprise,  EcoSystem business) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.organization = organization;
        this.enterprise = enterprise;
        this.userAccount = account;
        this.business = business;
       
        valueLabel.setText(account.getUsername());
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
        enterpriseLabel = new javax.swing.JLabel();
        valueLabel = new javax.swing.JLabel();
        policeRequest = new javax.swing.JButton();
        inventoryRequestJButton = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("My Work Area - Reception Role");

        enterpriseLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        enterpriseLabel.setText("Enterprise :");

        valueLabel.setText("<value>");

        policeRequest.setText("Police Requests");
        policeRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                policeRequestActionPerformed(evt);
            }
        });

        inventoryRequestJButton.setText("Inventory Request");
        inventoryRequestJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inventoryRequestJButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(enterpriseLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(valueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(inventoryRequestJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(policeRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(144, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jLabel1)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(valueLabel)
                    .addComponent(enterpriseLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(inventoryRequestJButton)
                .addGap(11, 11, 11)
                .addComponent(policeRequest)
                .addContainerGap(291, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
/**/
    
    private void policeRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_policeRequestActionPerformed
        // TODO add your handling code here:
        ReceptionPoliceWorkAreaJPanel receptionPoliceWorkAreaJPanel = new ReceptionPoliceWorkAreaJPanel(userProcessContainer, userAccount, organization,enterprise , business);
        userProcessContainer.add("receptionPoliceWorkAreaJPanel", receptionPoliceWorkAreaJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
        
    }//GEN-LAST:event_policeRequestActionPerformed

    private void inventoryRequestJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inventoryRequestJButtonActionPerformed
        // TODO add your handling code here:
        ReceptionInventoryWorkAreaJPanel receptionInventoryWorkAreaJPanel = new ReceptionInventoryWorkAreaJPanel(userProcessContainer, userAccount, organization, enterprise, business);
        userProcessContainer.add("receptionInventoryWorkAreaJPanel", receptionInventoryWorkAreaJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_inventoryRequestJButtonActionPerformed
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel enterpriseLabel;
    private javax.swing.JButton inventoryRequestJButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton policeRequest;
    private javax.swing.JLabel valueLabel;
    // End of variables declaration//GEN-END:variables
}
