import java.util.Scanner;

public class ShoppingCartManager {
   public static Scanner scnr = new Scanner(System.in);
   public static void main(String[] args) {
      boolean isValidOption = false;
      
      System.out.println("Enter Customer's Name:");
      String name = scnr.nextLine();
      System.out.println("Enter Today's Date:");
      String date = scnr.nextLine();
      System.out.println("");
      ShoppingCart sho = new ShoppingCart(name, date);
      System.out.println("Customer Name: " + name);
      System.out.println("Today's Date: " + date);
      System.out.println();
      printMenu();
      
      do{
         System.out.println("Choose an option:");
         String option = scnr.next();
         if(option.equals("a") || option.equals("d") || option.equals("c") || option.equals("i") || option.equals("o")){
            executeMenu(option.charAt(0), sho, scnr);
            isValidOption = false;
            printMenu();
            continue;
         }
         else if(option.equals("q")){
            isValidOption = true;
            break;
         }
         else{
            scnr.nextLine();
         }
      } while(!isValidOption);
   }
            
      
      public static void printMenu(){
         System.out.printf("MENU\n" + "a - Add item to cart\n" + "d - Remove item from cart\n" + "c - Change item quantity\n" +
         "i - Output items' descriptions\n" + "o - Output shopping cart\n" + "q - Quit\n");
         System.out.println("");
         
      }
      
      public static void executeMenu(char c, ShoppingCart sho, Scanner scnr){
         if (c =='a'){
            System.out.println("ADD ITEM TO CART");
            System.out.println("Enter the item name:");
            scnr.nextLine();
            String newName = scnr.nextLine();
            System.out.println("Enter the item description:");
            String newDescription = scnr.nextLine();
            System.out.println("Enter the item price:");
            int newPrice = scnr.nextInt();
            System.out.println("Enter the item quantity:");
            int newQuantity = scnr.nextInt();
            ItemToPurchase newItemToPurchase = new ItemToPurchase(newName, newDescription, newPrice, newQuantity);
            sho.addItem(newItemToPurchase);
            System.out.println("");
         }
            
         if (c == 'o'){
            System.out.println("OUTPUT SHOPPING CART");
            sho.printTotal();
         }
         
         if (c == 'i'){
            System.out.println("OUTPUT ITEMS' DESCRIPTIONS");
            sho.printDescriptions();
         }
         
         if (c == 'd'){
            System.out.println("REMOVE ITEM FROM CART");
            System.out.println("Enter name of item to remove:");
            scnr.nextLine();
            String itemToRemove = scnr.nextLine();
            
            sho.removeItem(itemToRemove);
         }
         
         if (c == 'c'){
            System.out.println("CHANGE ITEM QUANTITY");
            System.out.println("Enter the item name:");
            scnr.nextLine();
            String itemName = scnr.nextLine();
            System.out.println("Enter the new quantity:");
            int itemQty = scnr.nextInt();
            ItemToPurchase item = new ItemToPurchase(itemName, "none", 0, itemQty);
            sho.modifyItem(item);
         }   
      }
}

