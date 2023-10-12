public class ItemToPurchase {
    private String itemName;
    private int itemPrice;
    private int itemQuantity;
    private String itemDescription;
    
    // default constructor
    public ItemToPurchase() {
       itemDescription = "none";
       itemName = "none";
       itemPrice = 0;
       itemQuantity = 0;
    }
    
    public ItemToPurchase(String itemName, String itemDescription, int itemPrice, int itemQuantity){
       this.itemName = itemName;
       this.itemDescription = itemDescription;
       this.itemPrice = itemPrice;
       this.itemQuantity = itemQuantity;
    }
    
    public void setName(String itemName){
       this.itemName = itemName;
    }
    public void setDescription(String itemDescription){
       this.itemDescription = itemDescription;
    }
    public void setPrice(int itemPrice){
       this.itemPrice = itemPrice;
    }
    public void setQuantity(int itemQuantity) {
       this.itemQuantity = itemQuantity;
    }
    
    public String getName(){
       return itemName;
    }
    public String getDescription(){
       return itemDescription;
    }
    public int getPrice(){
       return itemPrice;
    }
    public int getQuantity(){
       return itemQuantity;
    }
    
    public String printItemCost(){
       int totalCost = itemQuantity * itemPrice;
       String priceWords = (itemName + " " + itemQuantity + " @ $" + itemPrice + " = $" + totalCost);
       return priceWords;
    }
    public String printItemDescription(){
       String description = (itemName + ": " + itemDescription);
       return description;
    }
 
 }
