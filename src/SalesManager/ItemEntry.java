package SalesManager;

import java.awt.event.ActionEvent;
import java.io.File; //import the file class
import java.io.IOException; //import java.util.ArrayList;
import java.util.ArrayList;
import java.io.*;
import java.awt.event.*;
import java.util.Locale.Category;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import DomainClass.itemEntry;
import SalesManager.SMDashboard;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.swing.JComboBox;

public class ItemEntry extends javax.swing.JFrame {
    // List to hold item data (in-memory)
    private List<itemEntry> itemEntry = new ArrayList<>();
    
    //combo box
    private Set<String> supplierIds = new LinkedHashSet<>();
    private Set<String> categories = new LinkedHashSet<>();
    private String newItemId;
    private Set<String> itemIds = new LinkedHashSet<>();
            
    // Define the file path for item data persistence
    private static final String filePath = "src/dataset/Item.txt";
    
    //clear all fields
    private void clearFields() {
        ItemIDComboBox.setSelectedIndex(0);
        ItemNameTextField.setText("");
        SupplierIDComboBox.setSelectedIndex(0);
        CategoryComboBox.setSelectedIndex(0);
        QuantityInStockTextField.setText("");
        UnitPriceTextField.setText("");
    }
    
    private void addNewRowToTable(itemEntry newItemEntry){
        DefaultTableModel model = (DefaultTableModel) itemTable.getModel();
        model.addRow(new Object[]{ 
            newItemEntry.getItemID(), 
            newItemEntry.getItemName(),
            newItemEntry.getSupplierID(), 
            newItemEntry.getCategory(), 
            newItemEntry.getQuantityInStock(), 
            newItemEntry.getUnitPrice()
        });
    }
    
    public ItemEntry() {
        initComponents();
        //when add data successful will auto show in table
        //itemTable.setModel(new DefaultTableModel(new Object [][] {},new String [] {
        //"Item_ID", "Item_Name", "Supplier_ID", "Category", "Quantity", "Unit_Price"} ));
        
        //load the item data from txt file
        loadItemData(filePath);
        
        // automatically show selected row data in fields
        itemTable.addMouseListener(new java.awt.event.MouseAdapter() {
        @Override
        public void mouseClicked(java.awt.event.MouseEvent evt) {
        int selectedRow = itemTable.getSelectedRow();
        if (selectedRow >= 0) {
            DefaultTableModel model = (DefaultTableModel) itemTable.getModel();

            ItemIDComboBox.setSelectedItem(model.getValueAt(selectedRow, 0).toString());
            ItemNameTextField.setText(model.getValueAt(selectedRow, 1).toString());
            SupplierIDComboBox.setSelectedItem(model.getValueAt(selectedRow, 2).toString());
            CategoryComboBox.setSelectedItem(model.getValueAt(selectedRow, 3).toString());
            QuantityInStockTextField.setText(model.getValueAt(selectedRow, 4).toString());
            UnitPriceTextField.setText(model.getValueAt(selectedRow, 5).toString());}}
        });
        
    }
    
    // load data method
    private void loadItemData(String filePath) {
        DefaultTableModel model = (DefaultTableModel) itemTable.getModel();
        model.setRowCount(0); 
        int index = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line; br.readLine(); // Read and skip the first line (header)
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
                        addNewRowToTable(newItemEntry);
                        
                        //add combo box
                        supplierIds.add(newItemEntry.getSupplierID());
                        categories.add(newItemEntry.getCategory());
                        itemIds.add(newItemEntry.getItemID());
                        
                    } catch (NumberFormatException ex) {
                        System.out.println("Skipping invalid number format: " + line);
                    }
                    
                    index++;
                }
            }
            
        } catch (IOException e) { 
        JOptionPane.showMessageDialog(this, "Error loading item data: " + e.getMessage());
        }
        
        newItemId = String.format("I%03d", index + 1);
        itemIds.add(newItemId);
        
        SupplierIDComboBox.removeAllItems();
        for (String sup : supplierIds) {
            SupplierIDComboBox.addItem(sup);
        }
        CategoryComboBox.removeAllItems();
        for (String cat : categories) {
            CategoryComboBox.addItem(cat);
        }
        ItemIDComboBox.removeAllItems();
        for (String itemId : itemIds) {
            ItemIDComboBox.addItem(itemId);
        }
    } // end of load data method code
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        ItemScrollPane = new javax.swing.JScrollPane();
        itemTable = new javax.swing.JTable();
        BackButton = new javax.swing.JButton();
        EditButton = new javax.swing.JButton();
        DeleteButton = new javax.swing.JButton();
        AddButton = new javax.swing.JButton();
        ItemIDLabel = new javax.swing.JLabel();
        ItemNameLabel = new javax.swing.JLabel();
        CategoryLabel = new javax.swing.JLabel();
        QuantityInStockLabel = new javax.swing.JLabel();
        CategoryComboBox = new javax.swing.JComboBox<>();
        UnitPriceLabel = new javax.swing.JLabel();
        ItemNameTextField = new javax.swing.JTextField();
        UnitPriceLabel1 = new javax.swing.JLabel();
        QuantityInStockTextField = new javax.swing.JTextField();
        SupplierIDComboBox = new javax.swing.JComboBox<>();
        ItemIDComboBox = new javax.swing.JComboBox<>();
        UnitPriceTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(16, 63, 105));

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Create Item Entry");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(240, 240, 240)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(28, 28, 28))
        );

        jPanel2.setBackground(new java.awt.Color(221, 239, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(850, 434));

        itemTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Item_ID", "Item_Name", "Supplier_ID", "Category", "Quantity_In_Stock", "Unit_Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        ItemScrollPane.setViewportView(itemTable);

        BackButton.setFont(new java.awt.Font("Tempus Sans ITC", 1, 12)); // NOI18N
        BackButton.setText("Back");
        BackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackButtonActionPerformed(evt);
            }
        });

        EditButton.setFont(new java.awt.Font("Tempus Sans ITC", 1, 12)); // NOI18N
        EditButton.setText("Update");
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

        AddButton.setFont(new java.awt.Font("Tempus Sans ITC", 1, 12)); // NOI18N
        AddButton.setText("Add");
        AddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddButtonActionPerformed(evt);
            }
        });

        ItemIDLabel.setText("Item_ID");

        ItemNameLabel.setText("Item_Name");

        CategoryLabel.setText("Category");

        QuantityInStockLabel.setText("Quaintity_In_Stock");

        UnitPriceLabel.setText("Unit_Price");

        ItemNameTextField.setEditable(false);
        ItemNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemNameTextFieldActionPerformed(evt);
            }
        });

        UnitPriceLabel1.setText("Supplier_ID");

        QuantityInStockTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QuantityInStockTextFieldActionPerformed(evt);
            }
        });

        ItemIDComboBox.setEditable(true);
        ItemIDComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ItemIDComboBoxItemStateChanged(evt);
            }
        });

        UnitPriceTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UnitPriceTextFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ItemScrollPane)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(ItemIDLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(ItemIDComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(ItemNameLabel)
                        .addGap(18, 18, 18)
                        .addComponent(ItemNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(37, 37, 37)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CategoryLabel)
                    .addComponent(UnitPriceLabel1))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(AddButton, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(EditButton, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(DeleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(CategoryComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(SupplierIDComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(67, 67, 67)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(UnitPriceLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(UnitPriceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(QuantityInStockLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(QuantityInStockTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 238, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ItemScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ItemIDLabel)
                            .addComponent(UnitPriceLabel1)
                            .addComponent(QuantityInStockLabel)
                            .addComponent(QuantityInStockTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SupplierIDComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ItemIDComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ItemNameLabel)
                            .addComponent(CategoryLabel)
                            .addComponent(CategoryComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(UnitPriceLabel)
                            .addComponent(ItemNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(UnitPriceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(68, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BackButton)
                            .addComponent(EditButton)
                            .addComponent(DeleteButton)
                            .addComponent(AddButton))
                        .addContainerGap())))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void ItemNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemNameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ItemNameTextFieldActionPerformed

    private void BackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackButtonActionPerformed
        this.dispose();
        new SMDashboard().setVisible(true);
    }//GEN-LAST:event_BackButtonActionPerformed

    private void DeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteButtonActionPerformed
        int selectedRow = itemTable.getSelectedRow();

    if (selectedRow >= 0) {
        int confirm = JOptionPane.showConfirmDialog(
            this,
            "Are you sure you want to delete this item row?",
            "Confirm Delete",
            JOptionPane.YES_NO_OPTION
        );
        if (confirm == JOptionPane.YES_OPTION) {
            DefaultTableModel model = (DefaultTableModel) itemTable.getModel();
            model.removeRow(selectedRow);
            JOptionPane.showMessageDialog(this, "Item deleted successfully.");
        }
    } else {
        JOptionPane.showMessageDialog(this, "Please select a row to delete.");
    }
    }//GEN-LAST:event_DeleteButtonActionPerformed

    private void AddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddButtonActionPerformed
        String itemID = ItemIDComboBox.getSelectedItem().toString();
        String itemName = ItemNameTextField.getText();
        String supplierID = SupplierIDComboBox.getSelectedItem().toString();
        String category = CategoryComboBox.getSelectedItem().toString();
        String quantity = QuantityInStockTextField.getText();
        String unitPrice = UnitPriceTextField.getText();

        // Validate input fields
        if (itemID.isEmpty() || itemName.isEmpty() || supplierID.equals("Select SupplierID") ||
            category.equals("Select Category") || quantity.isEmpty() || unitPrice.isEmpty()) {

            JOptionPane.showMessageDialog(this, "Please fill in all fields.");
            return;
        }

        // Validate numeric inputs
        int parsedquantity;
        double parsedunitPrice;
        try {
            parsedquantity = Integer.parseInt(quantity);
            parsedunitPrice = Double.parseDouble(unitPrice);

            if (parsedquantity < 0 || parsedunitPrice < 0) {
                JOptionPane.showMessageDialog(this, "Quantity and Unit Price cannot be negative.", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;}
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Quantity and Unit Price must be valid numbers.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;}
        // Add the new row
        itemEntry newItemEntry = new itemEntry(itemID, itemName, supplierID, category, parsedquantity, parsedunitPrice);
        itemEntry.add(newItemEntry);
        addNewRowToTable(newItemEntry);
        

        //write new row to txt
        String newLine = itemID + "," + itemName + "," + supplierID + "," + category + "," + quantity + "," + unitPrice;
        try (FileWriter writer = new FileWriter(filePath, true)) { // 'true' enables append mode
            writer.write(System.lineSeparator() + newLine);
            JOptionPane.showMessageDialog(this, "Item added successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
        clearFields();
        loadItemData(filePath);
    }//GEN-LAST:event_AddButtonActionPerformed

    private void EditButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditButtonActionPerformed
        int selectedRow = itemTable.getSelectedRow();
        
        if (selectedRow >= 0) {
            DefaultTableModel model = (DefaultTableModel) itemTable.getModel();
            
            String itemID = ItemIDComboBox.getSelectedItem().toString();
            String itemName = ItemNameTextField.getText().trim();
            String supplierID = SupplierIDComboBox.getSelectedItem().toString();
            String category = CategoryComboBox.getSelectedItem().toString();
            String quantityStr = QuantityInStockTextField.getText().trim();
            String priceStr = UnitPriceTextField.getText().trim();

            if (itemID.isEmpty() || itemName.isEmpty() || supplierID.equals("Select SupplierID") ||
                category.equals("Select Category") || quantityStr.isEmpty() || priceStr.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill in all fields.");
                return;
            }

            try {
                int quantity = Integer.parseInt(quantityStr);
                double price = Double.parseDouble(priceStr);

                if (quantity < 0 || price < 0) {
                    JOptionPane.showMessageDialog(this, "Quantity and Unit Price cannot be negative.", "Input Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                // Update table row
                model.setValueAt(itemID, selectedRow, 0);
                model.setValueAt(itemName, selectedRow, 1);
                model.setValueAt(supplierID, selectedRow, 2);
                model.setValueAt(category, selectedRow, 3);
                model.setValueAt(quantity, selectedRow, 4);
                model.setValueAt(price, selectedRow, 5);
                
                // update txt file 
                try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
                    bw.write("Item_ID,Item_Name,Supplier_ID,Category,Quantity,Unit_Price");
                    bw.newLine();
                    
                    for (int i = 0; i < model.getRowCount(); i++) {
                        for (int j = 0; j < model.getColumnCount(); j++) {
                            bw.write(model.getValueAt(i, j).toString());
                            if (j < model.getColumnCount() - 1) bw.write(",");
                        }
                        bw.newLine();
                    }
                    JOptionPane.showMessageDialog(null, "Data saved successfully!");
                }
                catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Error saving data: " + ex.getMessage());
                }
                
                JOptionPane.showMessageDialog(this, "Item edited save.");
                clearFields();
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Quantity and Unit Price must be valid numbers.", "Input Error", JOptionPane.ERROR_MESSAGE);
            }
            
            loadItemData(filePath);
        }
    }//GEN-LAST:event_EditButtonActionPerformed

    private void QuantityInStockTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QuantityInStockTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_QuantityInStockTextFieldActionPerformed

    private void CategoryComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CategoryComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CategoryComboBoxActionPerformed

    private void SupplierIDComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SupplierIDComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SupplierIDComboBoxActionPerformed

    private void RefreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefreshButtonActionPerformed

    }//GEN-LAST:event_RefreshButtonActionPerformed

    private void UnitPriceTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UnitPriceTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UnitPriceTextFieldActionPerformed

    private void ItemIDComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ItemIDComboBoxItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            String selectedItemId = (String) evt.getItem();
            if (newItemId.equals(selectedItemId)) {
                ItemNameTextField.setEditable(true);
                ItemNameTextField.setText("");
            } else {
                ItemNameTextField.setEditable(false);
                for (itemEntry entry : itemEntry) {
                    if (entry.getItemID().equals(selectedItemId)) {
                        ItemNameTextField.setText(entry.getItemName());
                        break;
                    }
                }
            }
        }
    }//GEN-LAST:event_ItemIDComboBoxItemStateChanged

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
            java.util.logging.Logger.getLogger(ItemEntry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ItemEntry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ItemEntry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ItemEntry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ItemEntry().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddButton;
    private javax.swing.JButton BackButton;
    private javax.swing.JComboBox<String> CategoryComboBox;
    private javax.swing.JLabel CategoryLabel;
    private javax.swing.JButton DeleteButton;
    private javax.swing.JButton EditButton;
    private javax.swing.JComboBox<String> ItemIDComboBox;
    private javax.swing.JLabel ItemIDLabel;
    private javax.swing.JLabel ItemNameLabel;
    private javax.swing.JTextField ItemNameTextField;
    private javax.swing.JScrollPane ItemScrollPane;
    private javax.swing.JLabel QuantityInStockLabel;
    private javax.swing.JTextField QuantityInStockTextField;
    private javax.swing.JComboBox<String> SupplierIDComboBox;
    private javax.swing.JLabel UnitPriceLabel;
    private javax.swing.JLabel UnitPriceLabel1;
    private javax.swing.JTextField UnitPriceTextField;
    private javax.swing.JTable itemTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
