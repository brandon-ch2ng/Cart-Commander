import java.util.ArrayList;

public class ShoppingCart{
   
   private String customerName;
   private String currentDate;
   private ArrayList<ItemToPurchase> cartItems = new ArrayList<ItemToPurchase>();

   public ShoppingCart(){
      customerName = "none";
      currentDate = "January 1, 2016";
      cartItems = new ArrayList<>();
   }
      
   public ShoppingCart(String customerName, String currentDate){
      this.customerName = customerName;
      this.currentDate = currentDate;
      cartItems = new ArrayList<>();
   }
   
   public void setCustomerName(String customerName){
      this.customerName = customerName;
   }
   public void setDate(String currentDate){
      this.currentDate = currentDate;
   }
   
   public String getCustomerName(){
      return customerName;
   }
   public String getDate(){
      return currentDate;
   }
   
   public void addItem(ItemToPurchase itemToPurchase){
      cartItems.add(itemToPurchase);
   }
   
   public void removeItem(String itemName){
      int count = 0;
      for (int i=0; i<cartItems.size(); ++i){
               if (cartItems.get(i).getName().equals(itemName)) {
                   cartItems.remove(i);
                   System.out.println();
                   count++;
               }
      }
      if (count == 0){
            System.out.println("Item not found in cart. Nothing removed.");
            System.out.println();
      }
   }
   
   public void modifyItem(ItemToPurchase itemToPurchaseToPurchase){
      boolean itemFound = false;
      for (int i=0; i<cartItems.size(); ++i) {
            if (cartItems.get(i).getName().equals(itemToPurchaseToPurchase.getName())) {
                  itemFound = true;
                  if (!itemToPurchaseToPurchase.getDescription().equals("none")) {
                      cartItems.get(i).setDescription(itemToPurchaseToPurchase.getDescription());
                  }
                  if (itemToPurchaseToPurchase.getQuantity() != 0) {
                      cartItems.get(i).setQuantity(itemToPurchaseToPurchase.getQuantity());
                  } 
                  if (itemToPurchaseToPurchase.getPrice() != 0) {
                      cartItems.get(i).setPrice(itemToPurchaseToPurchase.getPrice());
                  }
            }
         }
         if (itemFound != true) {
            System.out.println("Item not found in cart. Nothing modified.");
            System.out.println();
         }
   }
   
   public int getNumItemsInCart(){ 
      int items = 0;
      for (int i=0; i<cartItems.size(); ++i){
         items += cartItems.get(i).getQuantity();
      }
      return items;
   }
   
   public int getCostOfCart(){
      int cost = 0;
      for (int i=0; i<cartItems.size(); ++i){
         cost += (cartItems.get(i).getPrice() * cartItems.get(i).getQuantity());
      }
      return cost;
   }
   
   public void printTotal(){
      System.out.println(customerName + "\'s" + " Shopping Cart - " + currentDate);
      System.out.println("Number of Items: " + getNumItemsInCart());
      System.out.println();
      
      if (getNumItemsInCart() == 0){
         System.out.println("SHOPPING CART IS EMPTY");
         System.out.println();
      }
      else{
         for (int i=0; i<cartItems.size(); ++i){
            System.out.println(cartItems.get(i).printItemCost());
         }
         System.out.println();
      }
      System.out.println("Total: $" + getCostOfCart());
      System.out.println();
   }
   
   public void printDescriptions(){
      System.out.println(customerName + "\'s" + " Shopping Cart - " + currentDate);
      System.out.println();
      System.out.println("Item Descriptions");
      for (int i=0; i<cartItems.size(); ++i){
         System.out.println(cartItems.get(i).printItemDescription());
      }
      System.out.println();
   }
}