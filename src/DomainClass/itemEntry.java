package DomainClass;

public class itemEntry {
    private String itemID;
    private String itemName;
    private String supplierID;
    private String category;
    private int quantityInStock;
    private double unitPrice;
    
    public itemEntry (String itemID, String itemName, String supplierID, String category,int quantityInStock,double unitPrice){
        this.itemID= itemID;
        this.itemName= itemName;
        this.supplierID= supplierID;
        this.category= category;
        this.quantityInStock= quantityInStock;
        this.unitPrice= unitPrice;
    }

    public String getItemID() {
        return itemID;
    }
    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    public String getItemName() {
        return itemName;}
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getSupplierID() {
        return supplierID;
    }
    public void setSupplierID(String supplierID) {
        this.supplierID = supplierID;
    }

    public String getCategory() {
        return category;}
    public void setCategory(String category) {
        this.category = category;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }
    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public double getUnitPrice() {
        return unitPrice;
    }
    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }
}
