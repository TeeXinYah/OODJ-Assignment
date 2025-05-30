package SalesManager;

import SalesManager.SMDashboard;
import DomainClass.dailySales;
import DomainClass.itemEntry;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class DailySales extends javax.swing.JFrame {

    // List to hold item data (in-memory)
    private List<dailySales> dailySales = new ArrayList<>();
    private List<itemEntry> itemEntry = new ArrayList<>();
    // Define the file path for item data persistence
    private static final String dailySalesFilePath = "src/dataset/DailySales.txt";
    private static final String itemFilePath = "src/dataset/Item.txt";
    
    
    public DailySales() {
        initComponents();
        
        //when add data successful will auto show in table
        DailySalesTable.setModel(new DefaultTableModel(new Object [][] {},new String [] {
        "Invoice_No", "Sales_Date", "Supplier_ID", "Item_ID", "Quantity", "Total_Amount", "Payment_Method"} ));
        
        //load the item data from txt file
        loadDailySalesData();
        
        
        DailySalesTable.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int selectedRow = DailySalesTable.getSelectedRow();
                if (selectedRow >= 0) {
                    DefaultTableModel model = (DefaultTableModel) DailySalesTable.getModel();

                   // InvoiceNoTextField.setText(model.getValueAt(selectedRow, 0).toString());
                    SalesDateTextField.setText(model.getValueAt(selectedRow, 1).toString());
                    SupplierIDComboBox.setSelectedItem(model.getValueAt(selectedRow, 2).toString());
                    ItemIDComboBox.setSelectedItem(model.getValueAt(selectedRow, 3).toString());
                    QuantityTextField.setText(model.getValueAt(selectedRow, 4).toString());
                    //totalAmountTextField.setText(model.getValueAt(selectedRow, 5).toString());
                    paymentMethodComboBox.setSelectedItem(model.getValueAt(selectedRow, 6).toString());

                }
            }
        });
    }
    
    // load data method
    private void loadDailySalesData() {
        DefaultTableModel model = (DefaultTableModel) DailySalesTable.getModel();
        model.setRowCount(0);
        
        try (BufferedReader br = new BufferedReader(new FileReader(itemFilePath))) {
             String line; br.readLine(); 

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 6) {
                    try {
                        itemEntry newItemEntry = new itemEntry(
                                data[0], 
                                data[1], 
                                data[2], 
                                data[3], 
                                Integer.parseInt(data[4].trim()),
                                Double.parseDouble(data[5].trim())
                        );
                        
                        itemEntry.add(newItemEntry);
                    } catch (NumberFormatException ex) {
                        System.out.println("Skipping invalid number format: " + line);}
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error loading item data: " + e.getMessage());
        }
        
        try (BufferedReader br = new BufferedReader(new FileReader(dailySalesFilePath))) {
            String line; br.readLine(); 

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 7) {
                    try {
                        dailySales newSale = new dailySales(
                                data[0],
                                data[1],
                                data[2],
                                data[3],
                                Integer.parseInt(data[4].trim()),
                                Double.parseDouble(data[5].trim()),
                                data[6]
                        );
                        dailySales.add(newSale);
                        model.addRow(new Object[]{newSale.getInvoiceNo(), newSale.getSalesDate(), newSale.getSupplierID(), 
                            newSale.getItemID(), newSale.getQuantity(), newSale.getTotalAmount(), newSale.getPaymentMethod()});
                        
                    } catch (NumberFormatException ex) {
                        System.out.println("Skipping invalid number format: " + line);}
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error loading item data: " + e.getMessage());
        }
        
        Set<String> supplierIds = new LinkedHashSet<>();
        Set<String> itemIds = new LinkedHashSet<>();
        for (itemEntry item : itemEntry){
            supplierIds.add(item.getSupplierID());
            itemIds.add(item.getItemID());
        }
        SupplierIDComboBox.removeAllItems();
        for (String sup : supplierIds) {
            SupplierIDComboBox.addItem(sup);
        }
        ItemIDComboBox.removeAllItems();
        for (String itemId : itemIds) {
            ItemIDComboBox.addItem(itemId);
        }
    } // end of load data method code

    private void clearFields() {
        SalesDateTextField.setText("");
        SupplierIDComboBox.setSelectedIndex(-1);
        ItemIDComboBox.setSelectedIndex(-1);
        QuantityTextField.setText("");
        paymentMethodComboBox.setSelectedIndex(0);
    }
    
    private String getNewInvoiceID() {
        int max = 0;

        for (dailySales sale : dailySales) {
            String invoiceNo = sale.getInvoiceNo();
            if (invoiceNo != null && invoiceNo.startsWith("INV")) {
                try {
                    int number = Integer.parseInt(invoiceNo.substring(3));
                    if (number > max) {
                        max = number;
                    }
                } catch (NumberFormatException e) {
                    
                }
            }
        }

        int nextNumber = max + 1;
        return String.format("INV%03d", nextNumber);
    }
    
    private double calculateTotalAmount(String itemID, String supplierID, int quantity){
        
        for (itemEntry item : itemEntry){
            if(item.getItemID().equals(itemID) && item.getSupplierID().equals(supplierID)){
                //matched item and supplier, start calculate: quantity * unit price
                return item.getUnitPrice() * quantity;
            }
        }
        
        return 0;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        BackButton1 = new javax.swing.JButton();
        AddButton = new javax.swing.JButton();
        DailysalesScrollTable = new javax.swing.JScrollPane();
        DailySalesTable = new javax.swing.JTable();
        SalesDateLabel = new javax.swing.JLabel();
        SalesDateTextField = new javax.swing.JTextField();
        ItemIDLabel = new javax.swing.JLabel();
        QuantityLabel = new javax.swing.JLabel();
        QuantityTextField = new javax.swing.JTextField();
        TotalAmountLabel = new javax.swing.JLabel();
        PaymentMethodLabel = new javax.swing.JLabel();
        paymentMethodComboBox = new javax.swing.JComboBox<>();
        DeleteButton = new javax.swing.JButton();
        EditButton = new javax.swing.JButton();
        ItemIDComboBox = new javax.swing.JComboBox<>();
        SupplierIDComboBox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(16, 63, 105));

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Create Daily Sales");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(265, 265, 265))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        jPanel2.setBackground(new java.awt.Color(221, 239, 255));

        BackButton1.setFont(new java.awt.Font("Tempus Sans ITC", 1, 12)); // NOI18N
        BackButton1.setText("Back");
        BackButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackButton1ActionPerformed(evt);
            }
        });

        AddButton.setFont(new java.awt.Font("Tempus Sans ITC", 1, 12)); // NOI18N
        AddButton.setText("Add");
        AddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddButtonActionPerformed(evt);
            }
        });

        DailySalesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Invoice_No.", "Sales_Date", "Item_ID", "Supplier_ID", "Sales_Quantity", "Total_Amount", "Payment_Method"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class, java.lang.String.class
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
        DailysalesScrollTable.setViewportView(DailySalesTable);

        SalesDateLabel.setText("Sales_Date");

        ItemIDLabel.setText("Item_ID");

        QuantityLabel.setText("Sales_Quantity");

        QuantityTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QuantityTextFieldActionPerformed(evt);
            }
        });

        TotalAmountLabel.setText("Supplier ID");

        PaymentMethodLabel.setText("Payment_Method");

        paymentMethodComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select PaymentMethod", "Online Banking", "E-wallet", "Credit/Debit Card", "Cash on Delivery" }));

        DeleteButton.setFont(new java.awt.Font("Tempus Sans ITC", 1, 12)); // NOI18N
        DeleteButton.setText("Delete");
        DeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteButtonActionPerformed(evt);
            }
        });

        EditButton.setFont(new java.awt.Font("Tempus Sans ITC", 1, 12)); // NOI18N
        EditButton.setText("Edit");
        EditButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(DailysalesScrollTable)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(AddButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(EditButton)
                        .addGap(18, 18, 18)
                        .addComponent(DeleteButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BackButton1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(PaymentMethodLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(paymentMethodComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(SalesDateLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(SalesDateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(ItemIDLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ItemIDComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(TotalAmountLabel)
                                .addGap(18, 18, 18)
                                .addComponent(SupplierIDComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(QuantityLabel)
                                .addGap(18, 18, 18)
                                .addComponent(QuantityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 406, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(DailysalesScrollTable, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SalesDateLabel)
                    .addComponent(SalesDateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ItemIDLabel)
                    .addComponent(TotalAmountLabel)
                    .addComponent(ItemIDComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SupplierIDComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(QuantityLabel)
                    .addComponent(QuantityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PaymentMethodLabel)
                    .addComponent(paymentMethodComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BackButton1)
                    .addComponent(EditButton)
                    .addComponent(DeleteButton)
                    .addComponent(AddButton))
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

    private void BackButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackButton1ActionPerformed
        this.dispose();
        new SMDashboard().setVisible(true);
    }//GEN-LAST:event_BackButton1ActionPerformed

    private void AddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddButtonActionPerformed
        DefaultTableModel model = (DefaultTableModel) DailySalesTable.getModel();

        String salesDate = SalesDateTextField.getText();
        String supplierID = SupplierIDComboBox.getSelectedItem().toString();
        String itemID = ItemIDComboBox.getSelectedItem().toString();
        String quantity = QuantityTextField.getText();
        String paymentMethod = paymentMethodComboBox.getSelectedItem().toString();
        String invoiceNo = getNewInvoiceID();
        double totalAmount = 0; 
        // Validate input fields
        if (salesDate.isEmpty() ||itemID.isEmpty() || quantity.isEmpty() || paymentMethod.equals("Select PaymentMethod")) {

            JOptionPane.showMessageDialog(this, "Please fill in all fields.");
            return;
        }

        // Validate numeric inputs
        int parsedquantity;
        try {
            parsedquantity = Integer.parseInt(quantity);

            if (parsedquantity < 0) {
                JOptionPane.showMessageDialog(this, "Quantity and Total Amount cannot be negative.", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Quantity and Total AMount must be valid numbers.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        totalAmount = calculateTotalAmount(itemID, supplierID, parsedquantity);
        
        dailySales newSale = new dailySales(
            invoiceNo,
            salesDate,
            supplierID,
            itemID,
            parsedquantity,
            totalAmount,
            paymentMethod
        );

        model.addRow(new Object[]{newSale.getInvoiceNo(), newSale.getSalesDate(), newSale.getSupplierID(), 
            newSale.getItemID(), newSale.getQuantity(), newSale.getTotalAmount(), newSale.getPaymentMethod()});
        
         //write new row to txt
        String newLine = invoiceNo + "," + salesDate + "," + supplierID + "," + itemID + "," + parsedquantity + "," + totalAmount + "," + paymentMethod;
        try (FileWriter writer = new FileWriter(dailySalesFilePath, true)) {
            writer.write(System.lineSeparator() + newLine);
            JOptionPane.showMessageDialog(this, "Daily Sales added successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }

        clearFields();
        loadDailySalesData();
    }//GEN-LAST:event_AddButtonActionPerformed

    private void DeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteButtonActionPerformed
        int selectedRow = DailySalesTable.getSelectedRow();

        if (selectedRow >= 0) {
            int confirm = JOptionPane.showConfirmDialog(
                this,
                "Are you sure you want to delete this item row?",
                "Confirm Delete",
                JOptionPane.YES_NO_OPTION
            );
            if (confirm == JOptionPane.YES_OPTION) {
                DefaultTableModel model = (DefaultTableModel) DailySalesTable.getModel();
                model.removeRow(selectedRow);
                JOptionPane.showMessageDialog(this, "Daily sales data deleted successfully.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a row to delete.");
        }
    }//GEN-LAST:event_DeleteButtonActionPerformed

    private void EditButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditButtonActionPerformed
        int selectedRow = DailySalesTable.getSelectedRow();
        
        if (selectedRow >= 0) {
            DefaultTableModel model = (DefaultTableModel) DailySalesTable.getModel();
            String salesDate = SalesDateTextField.getText().trim();
            String supplierID = SupplierIDComboBox.getSelectedItem().toString();
            String itemID = ItemIDComboBox.getSelectedItem().toString();
            String quantityStr = QuantityTextField.getText().trim();
            String paymentMethod = paymentMethodComboBox.getSelectedItem().toString();

            // Input validation
            if (salesDate.isEmpty()|| supplierID.isEmpty() || itemID.isEmpty() || quantityStr.isEmpty()
                || paymentMethod.equals("Select PaymentMetohd") ) {
                JOptionPane.showMessageDialog(this, "Please fill in all fields.");
                return;
            }

            try {
                int quantity = Integer.parseInt(quantityStr);
                double totalAMount = calculateTotalAmount(itemID, supplierID, quantity);

                if (quantity < 0) {
                    JOptionPane.showMessageDialog(this, "Quantity and Total Amount cannot be negative.", "Input Error", JOptionPane.ERROR_MESSAGE);
                    return;}

                // Update table row
                model.setValueAt(salesDate, selectedRow, 1);
                model.setValueAt(supplierID, selectedRow, 2);
                model.setValueAt(itemID, selectedRow, 3);
                model.setValueAt(quantity, selectedRow, 4);
                model.setValueAt(totalAMount, selectedRow, 5);
                model.setValueAt(paymentMethod, selectedRow, 6);
                
                //Update daily Sales file
                try (BufferedWriter bw = new BufferedWriter(new FileWriter("src/dataset/DailySales.txt"))) {
                    bw.write("Invoice_No,Sales_Date,Supplier_ID,Item_ID,Quantity,Total_Amount,Payment_Method");
                    bw.newLine();
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
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Quantity and Unit Price must be valid numbers.", "Input Error", JOptionPane.ERROR_MESSAGE);}
            } 
    }//GEN-LAST:event_EditButtonActionPerformed

    private void QuantityTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QuantityTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_QuantityTextFieldActionPerformed

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
            java.util.logging.Logger.getLogger(DailySales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DailySales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DailySales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DailySales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DailySales().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddButton;
    private javax.swing.JButton BackButton1;
    private javax.swing.JTable DailySalesTable;
    private javax.swing.JScrollPane DailysalesScrollTable;
    private javax.swing.JButton DeleteButton;
    private javax.swing.JButton EditButton;
    private javax.swing.JComboBox<String> ItemIDComboBox;
    private javax.swing.JLabel ItemIDLabel;
    private javax.swing.JLabel PaymentMethodLabel;
    private javax.swing.JLabel QuantityLabel;
    private javax.swing.JTextField QuantityTextField;
    private javax.swing.JLabel SalesDateLabel;
    private javax.swing.JTextField SalesDateTextField;
    private javax.swing.JComboBox<String> SupplierIDComboBox;
    private javax.swing.JLabel TotalAmountLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JComboBox<String> paymentMethodComboBox;
    // End of variables declaration//GEN-END:variables
}
