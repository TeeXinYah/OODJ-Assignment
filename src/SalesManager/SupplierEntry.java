package SalesManager;

import SalesManager.SMDashboard;
import DomainClass.supplierEntry;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;


public class SupplierEntry extends javax.swing.JFrame {

    // List to hold item data (in-memory)
    private List<SupplierEntry> supplierEntry = new ArrayList<>();
  
    // Define the file path for item data persistence
    private static final String filePath = "src/dataset/Supplier.txt";
    
    
    //clear all fields
    private void clearFields() {
    SupplierIDTextField.setText("");
    SupplierNameTextField.setText("");
    ContactNoTextField.setText("");
    EmailTextField.setText("");
    AddressTextField.setText("");
}

    public SupplierEntry() {
        initComponents();
        
        //when add data successful will auto show in table
        SupplierTable.setModel(new DefaultTableModel(new Object [][] {},new String [] {
        "Supplier_ID", "Supplier_Name", "Contact_No", "Email", "Address"} ));
        
        //load the item data from txt file
        loadSupplierData("src/dataset/Supplier.txt");
        
        // automatically show selected row data in fields
        SupplierTable.addMouseListener(new java.awt.event.MouseAdapter() {
        @Override
        public void mouseClicked(java.awt.event.MouseEvent evt) {
        int selectedRow = SupplierTable.getSelectedRow();
        if (selectedRow >= 0) {
            DefaultTableModel model = (DefaultTableModel) SupplierTable.getModel();

            SupplierIDTextField.setText(model.getValueAt(selectedRow, 0).toString());
            SupplierNameTextField.setText(model.getValueAt(selectedRow, 1).toString());
            ContactNoTextField.setText(model.getValueAt(selectedRow, 2).toString());
            EmailTextField.setText(model.getValueAt(selectedRow, 3).toString());
            AddressTextField.setText(model.getValueAt(selectedRow, 4).toString());}}
        });                
    }

        // load data method
        private void loadSupplierData(String filePath) {
        DefaultTableModel model = (DefaultTableModel) SupplierTable.getModel();
        model.setRowCount(0); // Clear the table

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line; br.readLine(); // Read and skip the first line (header)

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 5) {
                    try {
                        String supplierID = data[0];
                        String supplierName = data[1];
                        String ContactNo = data[2];
                        String email = data[3];
                        String address = data[4];

                        model.addRow(new Object[]{supplierID, supplierName, ContactNo, email, address});
                    } catch (NumberFormatException ex) {
                        System.out.println("Skipping invalid number format: " + line);}
                }
            }
        } catch (IOException e) {
        JOptionPane.showMessageDialog(this, "Error loading item data: " + e.getMessage());
        }
    } // end of load data method code
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        SupplierTable = new javax.swing.JTable();
        DeleteSupplier = new javax.swing.JButton();
        SaveSupplier = new javax.swing.JButton();
        AddSupplier = new javax.swing.JButton();
        BackButton4 = new javax.swing.JButton();
        EditSupplier = new javax.swing.JButton();
        SupplierIDLabel = new javax.swing.JLabel();
        SupplierNameLabel = new javax.swing.JLabel();
        SupplierIDTextField = new javax.swing.JTextField();
        ContactNoTextField = new javax.swing.JTextField();
        ContactNoLabel = new javax.swing.JLabel();
        SupplierNameTextField = new javax.swing.JTextField();
        EmailLabel = new javax.swing.JLabel();
        EmailTextField = new javax.swing.JTextField();
        AddressLabel = new javax.swing.JLabel();
        AddressTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(15, 64, 108));

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Create Supplier Entry");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(251, 251, 251)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(225, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(221, 239, 255));

        SupplierTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Supplier_ID", "Supplier_Name", "Contact No.", "Email", "Address"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(SupplierTable);

        DeleteSupplier.setFont(new java.awt.Font("Tempus Sans ITC", 1, 12)); // NOI18N
        DeleteSupplier.setText("Delete");
        DeleteSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteSupplierActionPerformed(evt);
            }
        });

        SaveSupplier.setFont(new java.awt.Font("Tempus Sans ITC", 1, 12)); // NOI18N
        SaveSupplier.setText("Save");
        SaveSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveSupplierActionPerformed(evt);
            }
        });

        AddSupplier.setFont(new java.awt.Font("Tempus Sans ITC", 1, 12)); // NOI18N
        AddSupplier.setText("Add");
        AddSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddSupplierActionPerformed(evt);
            }
        });

        BackButton4.setFont(new java.awt.Font("Tempus Sans ITC", 1, 12)); // NOI18N
        BackButton4.setText("Back");
        BackButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackButton4ActionPerformed(evt);
            }
        });

        EditSupplier.setFont(new java.awt.Font("Tempus Sans ITC", 1, 12)); // NOI18N
        EditSupplier.setText("Edit");
        EditSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditSupplierActionPerformed(evt);
            }
        });

        SupplierIDLabel.setText("Supplier_ID");

        SupplierNameLabel.setText("Supplier_Name");

        ContactNoLabel.setText("Contact No.");

        EmailLabel.setText("Email");

        AddressLabel.setText("Address");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 850, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(AddSupplier)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SaveSupplier)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DeleteSupplier)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(EditSupplier)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BackButton4)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(AddressLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(AddressTextField))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(SupplierIDLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SupplierIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(SupplierNameLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SupplierNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(ContactNoLabel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ContactNoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(EmailLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(EmailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SupplierIDLabel)
                    .addComponent(SupplierIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SupplierNameLabel)
                    .addComponent(ContactNoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ContactNoLabel)
                    .addComponent(SupplierNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EmailLabel)
                    .addComponent(EmailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AddressLabel)
                    .addComponent(AddressTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AddSupplier)
                    .addComponent(BackButton4)
                    .addComponent(EditSupplier)
                    .addComponent(DeleteSupplier)
                    .addComponent(SaveSupplier))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BackButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackButton4ActionPerformed
        this.dispose();
        new SMDashboard().setVisible(true);
    }//GEN-LAST:event_BackButton4ActionPerformed

    private void AddSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddSupplierActionPerformed
        DefaultTableModel model = (DefaultTableModel) SupplierTable.getModel();
    
    String supplierID = SupplierIDTextField.getText();
    String supplierName = SupplierNameTextField.getText();
    String contactNo = ContactNoTextField.getText();
    String email = EmailTextField.getText();
    String address = AddressTextField.getText();

    // Validate input fields
    if (supplierID.isEmpty() || supplierName.isEmpty() || contactNo.isEmpty() || 
            email.isEmpty() || address.isEmpty()) {
        
        JOptionPane.showMessageDialog(this, "Please fill in all fields.");
        return;}
    
    // Check if ItemID already exists in the table
    for (int i = 0; i < model.getRowCount(); i++) {
        String existingItemID = model.getValueAt(i, 0).toString();
        if (existingItemID.equals(supplierID)) {
            JOptionPane.showMessageDialog(this, "Item ID already exists. Please enter a unique Item ID.", "Duplicate ID Error", JOptionPane.ERROR_MESSAGE);
            return;}
    }

    // Add the new row
    model.addRow(new Object[]{supplierID,supplierName, contactNo, email, address});
    JOptionPane.showMessageDialog(this, "Item added successfully!");

    clearFields();
    }//GEN-LAST:event_AddSupplierActionPerformed

    private void SaveSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveSupplierActionPerformed
        // after editing updates edited data in the table
    int selectedRow = SupplierTable.getSelectedRow();

    if (selectedRow >= 0) {
        DefaultTableModel model = (DefaultTableModel) SupplierTable.getModel();
        String supplierID = SupplierIDTextField.getText().trim();
        String supplierName = SupplierNameTextField.getText().trim();
        String contactNo = ContactNoTextField.getText().trim();
        String email = EmailTextField.getText().trim();
        String address = AddressTextField.getText().trim();

        // Input validation
        if (supplierID.isEmpty() || supplierName.isEmpty() || contactNo.isEmpty() || email.isEmpty() || address.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.");
            return;}

            // Update table row
            model.setValueAt(supplierID, selectedRow, 0);
            model.setValueAt(supplierName, selectedRow, 1);
            model.setValueAt(contactNo, selectedRow, 2);
            model.setValueAt(email, selectedRow, 3);
            model.setValueAt(address, selectedRow, 4);

            JOptionPane.showMessageDialog(this, "Item edited save.");
            clearFields();
        }
    
        // Save the data change and update the txt file 
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("src/dataset/Supplier.txt"))) {
            bw.write("Supplier_ID,Supplier_Name,Contact No.,Email,Address");
            bw.newLine();
            
        DefaultTableModel model = (DefaultTableModel) SupplierTable.getModel();
        for (int i = 0; i < model.getRowCount(); i++) {
            for (int j = 0; j < model.getColumnCount(); j++) {
                bw.write(model.getValueAt(i, j).toString());
                if (j < model.getColumnCount() - 1) bw.write(",");}
            bw.newLine();}
        JOptionPane.showMessageDialog(this, "Data saved successfully!");
    }
    catch (IOException ex) {
        JOptionPane.showMessageDialog(this, "Error saving data: " + ex.getMessage());
    }
    }//GEN-LAST:event_SaveSupplierActionPerformed

    private void DeleteSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteSupplierActionPerformed
        int selectedRow = SupplierTable.getSelectedRow();

    if (selectedRow >= 0) {
        int confirm = JOptionPane.showConfirmDialog(
            null,
            "Are you sure you want to delete this item row?",
            "Confirm Delete",
            JOptionPane.YES_NO_OPTION
        );
        if (confirm == JOptionPane.YES_OPTION) {
            DefaultTableModel model = (DefaultTableModel) SupplierTable.getModel();
            model.removeRow(selectedRow);
            JOptionPane.showMessageDialog(this, "Item deleted successfully.");
        }
    } else {
        JOptionPane.showMessageDialog(this, "Please select a row to delete.");
    }
    }//GEN-LAST:event_DeleteSupplierActionPerformed

    private void EditSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditSupplierActionPerformed
        int selectedRow = SupplierTable.getSelectedRow();
    if (selectedRow >= 0) {
        DefaultTableModel model = (DefaultTableModel) SupplierTable.getModel();

        model.setValueAt(SupplierIDTextField.getText(), selectedRow, 0);
        model.setValueAt(SupplierNameTextField.getText(), selectedRow, 1);
        model.setValueAt(ContactNoTextField.getText(), selectedRow, 2);
        model.setValueAt(EmailTextField.getText(), selectedRow, 3);
        model.setValueAt(AddressTextField.getText(), selectedRow, 4);
        
        JOptionPane.showMessageDialog(this, "Item updated successfully!");
        clearFields();
    }
        else {
            JOptionPane.showMessageDialog(this, "Please select a row to edit.");
        }
    }//GEN-LAST:event_EditSupplierActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SupplierEntry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SupplierEntry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SupplierEntry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SupplierEntry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SupplierEntry().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddSupplier;
    private javax.swing.JLabel AddressLabel;
    private javax.swing.JTextField AddressTextField;
    private javax.swing.JButton BackButton4;
    private javax.swing.JLabel ContactNoLabel;
    private javax.swing.JTextField ContactNoTextField;
    private javax.swing.JButton DeleteSupplier;
    private javax.swing.JButton EditSupplier;
    private javax.swing.JLabel EmailLabel;
    private javax.swing.JTextField EmailTextField;
    private javax.swing.JButton SaveSupplier;
    private javax.swing.JLabel SupplierIDLabel;
    private javax.swing.JTextField SupplierIDTextField;
    private javax.swing.JLabel SupplierNameLabel;
    private javax.swing.JTextField SupplierNameTextField;
    private javax.swing.JTable SupplierTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
