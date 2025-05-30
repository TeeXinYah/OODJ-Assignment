package DomainClass;


public class createPR {
    private String prID;
    private String itemID;
    private String itemName;
    private int requestQuantity;
    private String requestDate;
    private String smID;
    private String status;
    
    //constructor
    public createPR (String prID,String itemID, String itemName,int requestQuantity,String requestDate,String smID,String status){
        this.prID= prID;
        this.itemID= itemID;
        this.itemID= itemName;
        this.requestQuantity= requestQuantity;
        this.requestDate= requestDate;
        this.smID= smID;
        this.status= status;
    }

    public String getPrID() {
        return prID;
    }
    public void setPrID(String prID) {
        this.prID = prID;
    }

    public String getItemID() {
        return itemID;
    }
    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    public String getItemName() {
        return itemName;
    }
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getRequestQuantity() {
        return requestQuantity;
    }
    public void setRequestQuantity(int requestQuantity) {
        this.requestQuantity = requestQuantity;
    }

    public String getRequestDate() {
        return requestDate;
    }
    public void setRequestDate(String requestDate) {
        this.requestDate = requestDate;
    }

    public String getSmID() {
        return smID;
    }
    public void setSmID(String smID) {
        this.smID = smID;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
}
