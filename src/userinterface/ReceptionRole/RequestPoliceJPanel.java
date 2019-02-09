/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.ReceptionRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.Organization.PoliceHelpDeskOrganization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.PoliceWorkRequest;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Sarthak
 */
public class RequestPoliceJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private Enterprise enterprise;
    private UserAccount userAccount;
    private EcoSystem business;
    /**
     * Creates new form RequestLabTestJPanel
     */
    public RequestPoliceJPanel(JPanel userProcessContainer, UserAccount account, Enterprise enterprise,EcoSystem business) {
        initComponents();
        
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        this.userAccount = account;
        this.business = business;
        messageJTextField.setEditable(false);
        populateCombo();
//        valueLabel.setText(enterprise.getName());
    }

    private void populateCombo(){
        incidentComboBox.removeAllItems();
        priorityjComboBox.removeAllItems();
        
        incidentComboBox.addItem("Select");
        incidentComboBox.addItem("Criminal");
        incidentComboBox.addItem("Accident");
        incidentComboBox.addItem("Suicide");
        incidentComboBox.addItem("Other");
        
        priorityjComboBox.addItem("Select");
        priorityjComboBox.addItem("High");
        priorityjComboBox.addItem("Moderate");
        priorityjComboBox.addItem("Low");
        
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        requestTestJButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        messageJTextField = new javax.swing.JTextField();
        backJButton = new javax.swing.JButton();
        valueLabel = new javax.swing.JLabel();
        enterpriseLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        priorityjComboBox = new javax.swing.JComboBox();
        incidentComboBox = new javax.swing.JComboBox();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        requestTestJButton.setText("Request");
        requestTestJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requestTestJButtonActionPerformed(evt);
            }
        });
        add(requestTestJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 140, -1, -1));

        jLabel1.setText("Incident");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(96, 40, -1, -1));

        messageJTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                messageJTextFieldActionPerformed(evt);
            }
        });
        add(messageJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 40, 89, -1));

        backJButton.setText("<<Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        add(backJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 138, -1, -1));

        valueLabel.setText("<value>");
        add(valueLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 130, -1));

        enterpriseLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        enterpriseLabel.setText("Enterprise :");
        add(enterpriseLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 120, 30));

        jLabel2.setText("Priority");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, -1, -1));

        priorityjComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(priorityjComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 70, 90, -1));

        incidentComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        incidentComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                incidentComboBoxActionPerformed(evt);
            }
        });
        add(incidentComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 40, 90, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void requestTestJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_requestTestJButtonActionPerformed
        
        try{
        PoliceWorkRequest request = new PoliceWorkRequest();
        if(incidentComboBox.getSelectedItem().toString().equalsIgnoreCase("Select")){
             JOptionPane.showMessageDialog(null, "Please select one item!");
            return;
        }
        if(!incidentComboBox.getSelectedItem().toString().equalsIgnoreCase("Others")){
        request.setIncident(incidentComboBox.getSelectedItem().toString());
        }else{
            if(!messageJTextField.getText().isEmpty()){
            request.setIncident(messageJTextField.getText());
            }else{
             JOptionPane.showMessageDialog(null, "Fields cannot be left blank!");
            return;
        }
            
        }      
        request.setPriority(priorityjComboBox.getSelectedItem().toString());
        
        request.setSender(userAccount);
        request.setStatus("Sent");
        
        Organization org = null;
        for(Enterprise enterprise : business.getNetworkList().get(0).getEnterpriseDirectory().getEnterpriseList()){
            for(Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()){
                if (organization instanceof PoliceHelpDeskOrganization){
                org = organization;
                break;
            }
            }
        }
        
        if (org!=null){
            org.getWorkQueue().getWorkRequestList().add(request);
            userAccount.getWorkQueue().getWorkRequestList().add(request);
            JOptionPane.showMessageDialog(null, "Request added Successfully");
        }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Something went wrong. Please try again!");
        }
        
    }//GEN-LAST:event_requestTestJButtonActionPerformed

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
        
        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        ReceptionPoliceWorkAreaJPanel dwjp = (ReceptionPoliceWorkAreaJPanel) component;
        dwjp.populateTable();
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
        
    }//GEN-LAST:event_backJButtonActionPerformed

    private void messageJTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_messageJTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_messageJTextFieldActionPerformed

    private void incidentComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_incidentComboBoxActionPerformed
        // TODO add your handling code here:
        if(incidentComboBox.getSelectedItem() != null){
        if("Other".equals(incidentComboBox.getSelectedItem().toString())){
        messageJTextField.setEditable(true);
        }
        }
    }//GEN-LAST:event_incidentComboBoxActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton;
    private javax.swing.JLabel enterpriseLabel;
    private javax.swing.JComboBox incidentComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField messageJTextField;
    private javax.swing.JComboBox priorityjComboBox;
    private javax.swing.JButton requestTestJButton;
    private javax.swing.JLabel valueLabel;
    // End of variables declaration//GEN-END:variables
}
