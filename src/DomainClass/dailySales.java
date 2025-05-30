package DomainClass;

public class dailySales {
    private String invoiceNo;
    private String salesDate;
    private String supplierID;
    private String itemID;
    private int quantity;
    private double totalAmount;
    private String paymentMethod;
    
    //constructor
    public dailySales (String invoiceNo,String salesDate,String supplierID,String itemID,int quantity,double totalAmount,String paymentMethod){
        this.invoiceNo= invoiceNo;
        this.salesDate= salesDate;
        this.supplierID= supplierID;
        this.itemID= itemID;
        this.quantity= quantity;
        this.totalAmount= totalAmount;
        this.paymentMethod= paymentMethod;
    }

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }
    
    public String getSalesDate() {
        return salesDate;
    }

    public void setSalesDate(String salesDate) {
        this.salesDate = salesDate;
    }

    public String getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(String supplierID) {
        this.supplierID = supplierID;
    }

    public String getItemID() {
        return itemID;
    }

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
