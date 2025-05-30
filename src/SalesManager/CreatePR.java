package SalesManager;

import SalesManager.SMDashboard;
import DomainClass.createPR;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;


public class CreatePR extends javax.swing.JFrame {
    // List to hold item data (in-memory)
    private List<CreatePR> createPR = new ArrayList<>();
  
    // Define the file path for item data persistence
    private static final String filePath = "src/dataset/PR.txt";
    
    
    public CreatePR() {
        initComponents();
        
        //when add data successful will auto show in table
        PRTable.setModel(new DefaultTableModel(new Object [][] {},new String [] 
        {"PR_ID", "Item_ID", "Item_Name", "Request_Quantity", "Request_Date", "SM_ID", "Status"} ));
        
        //load the item data from txt file
        loadPRData("src/dataset/PR.txt");
        
        //auto show the status is pending
        StatusTextField.setText("Pending");
        
        // when click edit button automatically show selected row data in fields
        PRTable.addMouseListener(new java.awt.event.MouseAdapter() {
        @Override
        public void mouseClicked(java.awt.event.MouseEvent evt) {
        int selectedRow = PRTable.getSelectedRow();
        if (selectedRow >= 0) {
            DefaultTableModel model = (DefaultTableModel) PRTable.getModel();

            PRIDTextField.setText(model.getValueAt(selectedRow, 0).toString());
            ItemIDTextField.setText(model.getValueAt(selectedRow, 1).toString());
            ItemNameTextField.setText(model.getValueAt(selectedRow, 2).toString());
            QuantityTextField.setText(model.getValueAt(selectedRow, 3).toString());
            RequestDateTextField.setText(model.getValueAt(selectedRow, 4).toString());
            SMIDComboBox.setSelectedItem(model.getValueAt(selectedRow, 5).toString());
            StatusTextField.setText(model.getValueAt(selectedRow, 6).toString());
        }}   
        }); //end of automatically show selected row data in fields
            
    }

    private void clearFields() {
        PRIDTextField.setText("");
        ItemIDTextField.setText("");
        ItemNameTextField.setText("");
        QuantityTextField.setText("");
        RequestDateTextField.setText("");
        SMIDComboBox.setSelectedIndex(0);
        StatusTextField.setText("Pending");
    }
    
    // load data method
    private void loadPRData(String filePath) {
        DefaultTableModel model = (DefaultTableModel) PRTable.getModel();
        model.setRowCount(0); // Clear the table

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line; br.readLine(); // Read and skip the first line (header)

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 7) {
                    try {
                        String prID = data[0];
                        String itemID = data[1];
                        String itemName = data[2];
                        int requestQuantity = Integer.parseInt(data[3].trim());
                        String requestDate = data[4];
                        String smID = data[5];
                        String status = data[6];

                        model.addRow(new Object[]{prID,itemID, itemName, requestQuantity, 
                            requestDate, smID, status});
                    } catch (NumberFormatException ex) {
                        System.out.println("Skipping invalid number format: " + line);}
                }
            }
        } catch (IOException e) {
        JOptionPane.showMessageDialog(this, "Error loading PR data: " + e.getMessage());
        }
    } // end of load data method code
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        PRTable = new javax.swing.JTable();
        BackButton1 = new javax.swing.JButton();
        EditButton = new javax.swing.JButton();
        DeleteButton = new javax.swing.JButton();
        SaveButton = new javax.swing.JButton();
        AddButton = new javax.swing.JButton();
        PRIDLabel = new javax.swing.JLabel();
        ItemIDLabel = new javax.swing.JLabel();
        PRIDTextField = new javax.swing.JTextField();
        ItemIDTextField = new javax.swing.JTextField();
        QuantityTextField = new javax.swing.JTextField();
        QuantityLabel = new javax.swing.JLabel();
        RequestDateLabel = new javax.swing.JLabel();
        RequestDateTextField = new javax.swing.JTextField();
        smIDLabel = new javax.swing.JLabel();
        StatusLabel = new javax.swing.JLabel();
        ItemNameLabel = new javax.swing.JLabel();
        ItemNameTextField = new javax.swing.JTextField();
        StatusTextField = new javax.swing.JTextField();
        SMIDComboBox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(16, 63, 105));

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Create Purchase Requisition");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(177, 177, 177))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(221, 239, 255));

        PRTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "PR_ID", "Item_ID", "Item_Name", "Request_Quantity", "Request_Date", "SM_ID", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(PRTable);

        BackButton1.setFont(new java.awt.Font("Tempus Sans ITC", 1, 12)); // NOI18N
        BackButton1.setText("Back");
        BackButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackButton1ActionPerformed(evt);
            }
        });

        EditButton.setFont(new java.awt.Font("Tempus Sans ITC", 1, 12)); // NOI18N
        EditButton.setText("Edit");
        EditButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditButtonActionPerformed(evt);
            }
        });

        DeleteButton.setFont(new java.awt.Font("Tempus Sans ITC", 1, 12)); // NOI18N
        DeleteButton.setText("Delete");
        DeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteButtonActionPerformed(evt);
            }
        });

        SaveButton.setFont(new java.awt.Font("Tempus Sans ITC", 1, 12)); // NOI18N
        SaveButton.setText("Save");
        SaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveButtonActionPerformed(evt);
            }
        });

        AddButton.setFont(new java.awt.Font("Tempus Sans ITC", 1, 12)); // NOI18N
        AddButton.setText("Add");
        AddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddButtonActionPerformed(evt);
            }
        });

        PRIDLabel.setText("PR_ID");

        ItemIDLabel.setText("Item_ID");

        QuantityLabel.setText("Quantity");

        RequestDateLabel.setText("Request_Date");

        smIDLabel.setText("SM_ID");

        StatusLabel.setText("Status");

        ItemNameLabel.setText("Item_Name");

        SMIDComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select SMID", "SM001", "SM002", "SM003" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 850, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(PRIDLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PRIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(ItemIDLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ItemIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(AddButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SaveButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(StatusLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(StatusTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(DeleteButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(EditButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BackButton1))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(QuantityLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(QuantityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(smIDLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(SMIDComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(ItemNameLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ItemNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(RequestDateLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(RequestDateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PRIDLabel)
                    .addComponent(PRIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(RequestDateLabel)
                    .addComponent(RequestDateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ItemNameLabel)
                    .addComponent(ItemNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ItemIDLabel)
                            .addComponent(ItemIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(QuantityLabel)
                            .addComponent(QuantityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(smIDLabel)
                            .addComponent(SMIDComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(StatusLabel)
                            .addComponent(StatusTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 78, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BackButton1)
                            .addComponent(EditButton)
                            .addComponent(DeleteButton)
                            .addComponent(SaveButton)
                            .addComponent(AddButton))
                        .addContainerGap())))
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

    private void BackButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackButton1ActionPerformed
        this.dispose();
        new SMDashboard().setVisible(true);
    }//GEN-LAST:event_BackButton1ActionPerformed

    private void AddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddButtonActionPerformed
        DefaultTableModel model = (DefaultTableModel) PRTable.getModel();
    
    String prID = PRIDTextField.getText();
    String itemID = ItemIDTextField.getText();
    String itemName = ItemNameTextField.getText();
    String requestQuantity = QuantityTextField.getText();
    String requestDate = RequestDateTextField.getText();
    String smID = SMIDComboBox.getSelectedItem().toString();
    String status = StatusTextField.getText();

    // Validate input fields
    if (prID.isEmpty() || itemID.isEmpty() || itemName.isEmpty() || requestQuantity.isEmpty() ||
         requestDate.isEmpty() || smID.equals("Select SMID") || status.isEmpty()) {
        
        JOptionPane.showMessageDialog(this, "Please fill in all fields.");
        return;}
    
    // Check if PR_ID already exists in the table
    for (int i = 0; i < model.getRowCount(); i++) {
        String existingItemID = model.getValueAt(i, 0).toString();
        if (existingItemID.equals(prID)) {
            JOptionPane.showMessageDialog(this, "PR_ID already exists. Please enter a unique Item ID.", "Duplicate ID Error", JOptionPane.ERROR_MESSAGE);
            return;}
    }

    // Add the new row
    model.addRow(new Object[]{prID,itemID,itemName,requestQuantity,requestDate,smID,status});
    JOptionPane.showMessageDialog(this, "Purchases Requisition added successfully!");

    clearFields();
    }//GEN-LAST:event_AddButtonActionPerformed

    private void SaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveButtonActionPerformed
        // after editing updates edited data in the table
    int selectedRow = PRTable.getSelectedRow();

    if (selectedRow >= 0) {
        DefaultTableModel model = (DefaultTableModel) PRTable.getModel();
        String prID = PRIDTextField.getText().trim();
        String itemID = ItemIDTextField.getText().trim();
        String itemName = ItemNameTextField.getText().trim();
        String requestQuantity = QuantityTextField.getText().trim();
        String requestDate = RequestDateTextField.getText().trim();
        String smID = SMIDComboBox.getSelectedItem().toString();
        String status = StatusTextField.getText().trim();

        // Input validation
        if (prID.isEmpty() || itemID.isEmpty() || itemName.isEmpty() || requestQuantity.isEmpty() 
         || requestDate.isEmpty() || smID.equals("Select SMID") || status.isEmpty()) {
        
        JOptionPane.showMessageDialog(this, "Please fill in all fields.");
        return;}

        try {
            int quantity = Integer.parseInt(requestQuantity);

            if (quantity < 0) {
                JOptionPane.showMessageDialog(this, "Quantity cannot be negative.", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;}

            // Update table row
            model.setValueAt(prID, selectedRow, 0);
            model.setValueAt(itemID, selectedRow, 1);
            model.setValueAt(itemName, selectedRow, 2);
            model.setValueAt(quantity, selectedRow, 3);
            model.setValueAt(requestDate, selectedRow, 4);
            model.setValueAt(smID, selectedRow, 5);
            model.setValueAt(status, selectedRow, 6);

            JOptionPane.showMessageDialog(this, "Purchase Requisition edited save.");
            clearFields();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Quantity must be valid numbers.", "Input Error", JOptionPane.ERROR_MESSAGE);}} 
    
        // Save the data change and update the txt file 
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("src/dataset/PR.txt"))) {
            bw.write("PR ID,Item ID,Item Name,Request Quantity,Request Date,SM ID,Status");
            bw.newLine();
        DefaultTableModel model = (DefaultTableModel) PRTable.getModel();
        for (int i = 0; i < model.getRowCount(); i++) {
            for (int j = 0; j < model.getColumnCount(); j++) {
                bw.write(model.getValueAt(i, j).toString());
                if (j < model.getColumnCount() - 1) bw.write(",");}
            bw.newLine();}
        JOptionPane.showMessageDialog(null, "Data saved successfully!");
    }
    catch (IOException ex) {
        JOptionPane.showMessageDialog(null, "Error saving data: " + ex.getMessage());
    }
    }//GEN-LAST:event_SaveButtonActionPerformed

    private void DeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteButtonActionPerformed
       int selectedRow = PRTable.getSelectedRow();

    if (selectedRow >= 0) {
        int confirm = JOptionPane.showConfirmDialog(
            this,
            "Are you sure you want to delete this item row?",
            "Confirm Delete",
            JOptionPane.YES_NO_OPTION
        );
        if (confirm == JOptionPane.YES_OPTION) {
            DefaultTableModel model = (DefaultTableModel) PRTable.getModel();
            model.removeRow(selectedRow);
            JOptionPane.showMessageDialog(this, "Purchase Requisition deleted successfully.");
        }
    } else {
        JOptionPane.showMessageDialog(this, "Please select a row to delete.");
    }
    }//GEN-LAST:event_DeleteButtonActionPerformed

    private void EditButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditButtonActionPerformed
        int selectedRow = PRTable.getSelectedRow();
    if (selectedRow >= 0) {
        DefaultTableModel model = (DefaultTableModel) PRTable.getModel();

        model.setValueAt(PRIDTextField.getText(), selectedRow, 0);
        model.setValueAt(ItemIDTextField.getText(), selectedRow, 1);
        model.setValueAt(ItemNameTextField.getText(), selectedRow, 2);
        model.setValueAt(QuantityTextField.getText(), selectedRow, 3);
        model.setValueAt(RequestDateTextField.getText(), selectedRow, 4);
        model.setValueAt(SMIDComboBox.getSelectedItem().toString(), selectedRow, 5);
        model.setValueAt(StatusTextField.getText(), selectedRow, 6);
        
        JOptionPane.showMessageDialog(this, "Purchase Requisition Item updated successfully!");
        clearFields();
    }
        else {
            JOptionPane.showMessageDialog(null, "Please select a row to edit.");
        }
    }//GEN-LAST:event_EditButtonActionPerformed

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
            java.util.logging.Logger.getLogger(CreatePR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreatePR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreatePR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreatePR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreatePR().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddButton;
    private javax.swing.JButton BackButton1;
    private javax.swing.JButton DeleteButton;
    private javax.swing.JButton EditButton;
    private javax.swing.JLabel ItemIDLabel;
    private javax.swing.JTextField ItemIDTextField;
    private javax.swing.JLabel ItemNameLabel;
    private javax.swing.JTextField ItemNameTextField;
    private javax.swing.JLabel PRIDLabel;
    private javax.swing.JTextField PRIDTextField;
    private javax.swing.JTable PRTable;
    private javax.swing.JLabel QuantityLabel;
    private javax.swing.JTextField QuantityTextField;
    private javax.swing.JLabel RequestDateLabel;
    private javax.swing.JTextField RequestDateTextField;
    private javax.swing.JComboBox<String> SMIDComboBox;
    private javax.swing.JButton SaveButton;
    private javax.swing.JLabel StatusLabel;
    private javax.swing.JTextField StatusTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel smIDLabel;
    // End of variables declaration//GEN-END:variables
}
