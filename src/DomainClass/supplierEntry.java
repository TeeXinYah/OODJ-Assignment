package DomainClass;


public class supplierEntry {
    private String supplierID;
    private String supplierName;
    private String contactNo;
    private String email;
    private String address;
    
    //constructor
    public supplierEntry (String supplierID,String supplierName,String contactNo,String email,String address){
        this.supplierID= supplierID;
        this.supplierName= supplierName;
        this.contactNo= contactNo;
        this.email= email;
        this.address= address;
    }

    public String getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(String supplierID) {
        this.supplierID = supplierID;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
