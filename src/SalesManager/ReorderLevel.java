package SalesManager;

import SalesManager.SMDashboard;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class ReorderLevel extends javax.swing.JFrame {

    // List to hold item data (in-memory)
    private List<ReorderLevel> reorderLevel = new ArrayList<>();
  
    // Define the file path for item data persistence
    private static final String filePath = "src/dataset/Reorder.txt";
    
    
    public ReorderLevel() {
        initComponents();
        
         //when add data successful will auto show in table
        ReorderTable.setModel(new DefaultTableModel(new Object [][] {},new String [] {
        "Reorder_ID","Item_ID", "Item_Name", "Supplier_ID", "Current_Stock", "Reorder_Level", "Stock_Status", "Unit_Price"} ));
        
        //load the item data from txt file
        loadReorderLevelData("src/dataset/ReorderLevel.txt");
        
        //auto show the status is pending
        StockStatusTextField.setText("Low Stock");
        
        // automatically show selected row data in fields
        ReorderTable.addMouseListener(new java.awt.event.MouseAdapter() {
        @Override
        public void mouseClicked(java.awt.event.MouseEvent evt) {
        int selectedRow = ReorderTable.getSelectedRow();
        if (selectedRow >= 0) {
            DefaultTableModel model = (DefaultTableModel) ReorderTable.getModel();

            ReorderIDTextField.setText(model.getValueAt(selectedRow, 0).toString());
            ItemIDTextField.setText(model.getValueAt(selectedRow, 1).toString());
            ItemNameTextField.setText(model.getValueAt(selectedRow, 2).toString());
            SupplierIDTextField.setText(model.getValueAt(selectedRow, 3).toString());
            CurrentStockTextField.setText(model.getValueAt(selectedRow, 4).toString());
            ReorderLevelTextField.setText(model.getValueAt(selectedRow, 5).toString());
            StockStatusTextField.setText(model.getValueAt(selectedRow, 6).toString());
            UnitPriceTextField.setText(model.getValueAt(selectedRow, 7).toString());}}
        }); //end of automatically show selected row data in fields
    }

    //clear all fields
    private void clearFields() {
        ReorderIDTextField.setText("");
        ItemIDTextField.setText("");
        ItemNameTextField.setText("");
        SupplierIDTextField.setText("");
        CurrentStockTextField.setText("");
        ReorderLevelTextField.setText("");
        StockStatusTextField.setText("Low Stock");
        UnitPriceTextField.setText("");
    }
    
    // load data method
    private void loadReorderLevelData(String filePath) {
        DefaultTableModel model = (DefaultTableModel) ReorderTable.getModel();
        model.setRowCount(0); // Clear the table

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line; br.readLine(); // Read and skip the first line (header)

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 8) {
                    try {
                        String reorderID = data[0];
                        String itemID = data[1];
                        String itemName = data[2];
                        String supplierID = data[3];
                        int currentStock = Integer.parseInt(data[4].trim());
                        String reorderlevel = data[5];
                        String stockStatus = data[6];
                        double unitPrice = Double.parseDouble(data[7].trim());

                        model.addRow(new Object[]{reorderID, itemID, itemName, supplierID, currentStock, reorderlevel, stockStatus, unitPrice});
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
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        ReorderLevel4Label = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ReorderTable = new javax.swing.JTable();
        DeleteButton = new javax.swing.JButton();
        SaveButton = new javax.swing.JButton();
        AddButton = new javax.swing.JButton();
        BackButton = new javax.swing.JButton();
        EditButton = new javax.swing.JButton();
        SupplierIDLabel = new javax.swing.JLabel();
        ItemNameLabel = new javax.swing.JLabel();
        ItemIDTextField = new javax.swing.JTextField();
        ReorderLevelTextField = new javax.swing.JTextField();
        ContactNoLabel = new javax.swing.JLabel();
        SupplierIDTextField = new javax.swing.JTextField();
        EmailLabel = new javax.swing.JLabel();
        ItemIDLabel = new javax.swing.JLabel();
        CurrentStockLabel = new javax.swing.JLabel();
        CurrentStockTextField = new javax.swing.JTextField();
        ItemNameTextField = new javax.swing.JTextField();
        EmailLabel1 = new javax.swing.JLabel();
        UnitPriceTextField = new javax.swing.JTextField();
        ReorderIDLabel = new javax.swing.JLabel();
        ReorderIDTextField = new javax.swing.JTextField();
        StockStatusTextField = new javax.swing.JTextField();

        jPanel2.setBackground(new java.awt.Color(16, 63, 105));

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Create Purchase Requisition");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(205, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(170, 170, 170))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(16, 63, 105));

        ReorderLevel4Label.setFont(new java.awt.Font("Trebuchet MS", 1, 36)); // NOI18N
        ReorderLevel4Label.setForeground(new java.awt.Color(255, 255, 255));
        ReorderLevel4Label.setText("Reorder Level Item");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(253, 253, 253)
                .addComponent(ReorderLevel4Label)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addComponent(ReorderLevel4Label, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        jPanel4.setBackground(new java.awt.Color(221, 239, 255));

        ReorderTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Reorder_ID", "Item_ID", "Item_Name", "Supplier_ID", "Current_Stock", "Reorder_Level", "Stock_Status", "Unit_Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, false, true, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(ReorderTable);

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

        BackButton.setFont(new java.awt.Font("Tempus Sans ITC", 1, 12)); // NOI18N
        BackButton.setText("Back");
        BackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackButtonActionPerformed(evt);
            }
        });

        EditButton.setFont(new java.awt.Font("Tempus Sans ITC", 1, 12)); // NOI18N
        EditButton.setText("Edit");
        EditButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditButtonActionPerformed(evt);
            }
        });

        SupplierIDLabel.setText("Supplier_ID");

        ItemNameLabel.setText("Item_Name");

        ContactNoLabel.setText("Reorder_Level");

        EmailLabel.setText("Stock_Status");

        ItemIDLabel.setText("Item_ID");

        CurrentStockLabel.setText("Current_Stock");

        EmailLabel1.setText("Unit_Price");

        ReorderIDLabel.setText("Reorder_ID");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(AddButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SaveButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DeleteButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(EditButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BackButton))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(ReorderLevelTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(EmailLabel1)
                        .addGap(16, 16, 16)
                        .addComponent(UnitPriceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(ReorderIDLabel)
                        .addGap(18, 18, 18)
                        .addComponent(ReorderIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                        .addComponent(SupplierIDLabel)
                        .addGap(18, 18, 18)
                        .addComponent(SupplierIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(ItemIDLabel)
                        .addGap(18, 18, 18)
                        .addComponent(ItemIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ItemNameLabel)
                        .addGap(18, 18, 18)
                        .addComponent(ItemNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ContactNoLabel)
                    .addComponent(CurrentStockLabel))
                .addGap(18, 18, 18)
                .addComponent(CurrentStockTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(EmailLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(StockStatusTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SupplierIDLabel)
                    .addComponent(SupplierIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ContactNoLabel)
                    .addComponent(ReorderLevelTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EmailLabel1)
                    .addComponent(UnitPriceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ReorderIDLabel)
                    .addComponent(ReorderIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(EmailLabel)
                            .addComponent(StockStatusTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CurrentStockLabel)
                            .addComponent(ItemNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ItemNameLabel)
                            .addComponent(CurrentStockTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ItemIDLabel)
                            .addComponent(ItemIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AddButton)
                    .addComponent(BackButton)
                    .addComponent(EditButton)
                    .addComponent(DeleteButton)
                    .addComponent(SaveButton))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void DeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteButtonActionPerformed
        int selectedRow = ReorderTable.getSelectedRow();

    if (selectedRow >= 0) {
        int confirm = JOptionPane.showConfirmDialog(
            this,
            "Are you sure you want to delete this item row?",
            "Confirm Delete",
            JOptionPane.YES_NO_OPTION
        );
        if (confirm == JOptionPane.YES_OPTION) {
            DefaultTableModel model = (DefaultTableModel) ReorderTable.getModel();
            model.removeRow(selectedRow);
            JOptionPane.showMessageDialog(this, "Reorder item row deleted successfully.");
        }
    } else {
        JOptionPane.showMessageDialog(this, "Please select a row to delete.");
    }
    }//GEN-LAST:event_DeleteButtonActionPerformed

    private void SaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveButtonActionPerformed
      // after editing updates edited data in the table
    int selectedRow = ReorderTable.getSelectedRow();

    if (selectedRow >= 0) {
        DefaultTableModel model = (DefaultTableModel) ReorderTable.getModel();
        
        String reorderID = ReorderIDTextField.getText().trim();
        String itemID = ItemIDTextField.getText().trim();
        String itemName = ItemNameTextField.getText().trim();
        String supplierID = SupplierIDTextField.getText().trim();
        String currentStockStr = CurrentStockTextField.getText().trim();
        String reorderlevel = ReorderLevelTextField.getText().trim();
        String stockStatus = StockStatusTextField.getText().trim();
        String unitPriceStr = UnitPriceTextField.getText().trim();

        // Input validation
        if (reorderID.isEmpty() || itemID.isEmpty() || itemName.isEmpty() ||
            supplierID.isEmpty() || currentStockStr.isEmpty()|| reorderlevel.isEmpty()
            || stockStatus.equals("Select Stock Status") || unitPriceStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.");
            return;}

        try {
            int currentStock = Integer.parseInt(currentStockStr);
            double unitPrice = Double.parseDouble(unitPriceStr);

            if (currentStock < 0 || unitPrice < 0) {
                JOptionPane.showMessageDialog(this, "Quantity and Unit Price cannot be negative.", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;}

            // Update table row
            model.setValueAt(reorderID, selectedRow, 0);
            model.setValueAt(itemID, selectedRow, 1);
            model.setValueAt(itemName, selectedRow, 2);
            model.setValueAt(supplierID, selectedRow, 3);
            model.setValueAt(currentStock, selectedRow, 4);
            model.setValueAt(reorderlevel, selectedRow, 5);
            model.setValueAt(stockStatus, selectedRow, 6);
            model.setValueAt(unitPrice, selectedRow, 7);

            JOptionPane.showMessageDialog(this, "Reorder item edited save.");
            clearFields();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Quantity and Unit Price must be valid numbers.", "Input Error", JOptionPane.ERROR_MESSAGE);}} 
    
        // Save the data change and update the txt file 
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("src/dataset/ReorderLevel.txt"))) {
            bw.write("Reorder_ID,Item_ID,Item_Name,Supplier_ID,Current_Stock,Reorder_Level,Stock_Status,Unit_Price");
            bw.newLine(); 
        DefaultTableModel model = (DefaultTableModel) ReorderTable.getModel();
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

    private void AddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddButtonActionPerformed
      DefaultTableModel model = (DefaultTableModel) ReorderTable.getModel();
    
    String reorderID = ReorderIDTextField.getText();  
    String itemID = ItemIDTextField.getText();
    String itemName = ItemNameTextField.getText();
    String supplierID = SupplierIDTextField.getText();
    String currentStock = CurrentStockTextField.getText();
    String reorderlevel = ReorderLevelTextField.getText();
    String stockStatus = StockStatusTextField.getText();
    String unitPrice = UnitPriceTextField.getText();

    // Validate input fields
    if (reorderID.isEmpty() || itemID.isEmpty() || itemName.isEmpty() ||
        supplierID.isEmpty() || currentStock.isEmpty() ||reorderlevel.isEmpty()
        || stockStatus.equals("Select Stock Status") || unitPrice.isEmpty()) {
        
        JOptionPane.showMessageDialog(this, "Please fill in all fields.");
        return;}

    // Validate numeric inputs
    int parsedquantity;
    double parsedunitPrice;
    try {
        parsedquantity = Integer.parseInt(currentStock);
        parsedunitPrice = Double.parseDouble(unitPrice);

        if (parsedquantity < 0 || parsedunitPrice < 0) {
            JOptionPane.showMessageDialog(this, "Quantity and Unit Price cannot be negative.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;}
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Quantity and Unit Price must be valid numbers.", "Input Error", JOptionPane.ERROR_MESSAGE);
        return;}
    
    // Check if ItemID already exists in the table
    for (int i = 0; i < model.getRowCount(); i++) {
        String existingItemID = model.getValueAt(i, 0).toString();
        if (existingItemID.equals(itemID)) {
            JOptionPane.showMessageDialog(this, "Item ID already exists. Please enter a unique Item ID.", "Duplicate ID Error", JOptionPane.ERROR_MESSAGE);
            return;}
    }

    // Add the new row
    model.addRow(new Object[]{reorderID,itemID,itemName,supplierID,currentStock,reorderlevel,stockStatus,unitPrice});
    JOptionPane.showMessageDialog(this, "Reorder item added successfully!");

    clearFields();
    }//GEN-LAST:event_AddButtonActionPerformed

    private void BackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackButtonActionPerformed
        this.dispose();
        new SMDashboard().setVisible(true);
    }//GEN-LAST:event_BackButtonActionPerformed

    private void EditButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditButtonActionPerformed
        int selectedRow = ReorderTable.getSelectedRow();
    if (selectedRow >= 0) {
        DefaultTableModel model = (DefaultTableModel) ReorderTable.getModel();

        model.setValueAt(ReorderIDTextField.getText(), selectedRow, 0);
        model.setValueAt(ItemIDTextField.getText(), selectedRow, 1);
        model.setValueAt(ItemNameTextField.getText(), selectedRow, 2);
        model.setValueAt(SupplierIDTextField.getText(), selectedRow, 3);
        model.setValueAt(CurrentStockTextField.getText(), selectedRow, 4);
        model.setValueAt(ReorderLevelTextField.getText(), selectedRow, 5);
        model.setValueAt(StockStatusTextField.getText(), selectedRow, 6);
        model.setValueAt(UnitPriceTextField.getText(), selectedRow, 7);
        
        JOptionPane.showMessageDialog(this, "Reorder level item updated successfully!");
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
            java.util.logging.Logger.getLogger(ReorderLevel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReorderLevel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReorderLevel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReorderLevel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReorderLevel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddButton;
    private javax.swing.JButton BackButton;
    private javax.swing.JLabel ContactNoLabel;
    private javax.swing.JLabel CurrentStockLabel;
    private javax.swing.JTextField CurrentStockTextField;
    private javax.swing.JButton DeleteButton;
    private javax.swing.JButton EditButton;
    private javax.swing.JLabel EmailLabel;
    private javax.swing.JLabel EmailLabel1;
    private javax.swing.JLabel ItemIDLabel;
    private javax.swing.JTextField ItemIDTextField;
    private javax.swing.JLabel ItemNameLabel;
    private javax.swing.JTextField ItemNameTextField;
    private javax.swing.JLabel ReorderIDLabel;
    private javax.swing.JTextField ReorderIDTextField;
    private javax.swing.JLabel ReorderLevel4Label;
    private javax.swing.JTextField ReorderLevelTextField;
    private javax.swing.JTable ReorderTable;
    private javax.swing.JButton SaveButton;
    private javax.swing.JTextField StockStatusTextField;
    private javax.swing.JLabel SupplierIDLabel;
    private javax.swing.JTextField SupplierIDTextField;
    private javax.swing.JTextField UnitPriceTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
