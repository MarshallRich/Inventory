import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by MacLap on 2/8/16.
 */
public class Inventory {
    public static void main(String[] args) throws Exception {
        ArrayList<InventoryItem> inv = new ArrayList<>();
        Scanner scanner= new Scanner(System.in);



        while (true) {

            int i = 1;
            for (InventoryItem item : inv) {
                System.out.printf("%d. [%d] %s (%s)\n", i, item.itemQuantity, item.itemName, item.itemCategory);
                i++;
            }

            System.out.println("Options:");
            System.out.println("1. Add a new item to your inventory");
            System.out.println("2. Remove an item from your inventory");
            System.out.println("3. Change the quantity of an item in your inventory");

            String option = scanner.nextLine();

            if (option.equals("1")) {
                System.out.println("Enter your new item name.");
                String text = scanner.nextLine();

                System.out.println("Enter the quantity.");
                int num =Integer.valueOf(scanner.nextLine());

                System.out.println("Enter the item category.");
                String category = scanner.nextLine();

                InventoryItem item = createItem(text, num, category);
                inv.add(item);
            }

            else if (option.equals("2")){
                System.out.println("Please enter the number of the item you would like to delete.");
                int itemNum = Integer.valueOf(scanner.nextLine());

                inv.remove(itemNum - 1);
                System.out.println("Item removed.");
            }

            else if (option.equals("3")){
                System.out.println("Please enter the number of the item you wish to adjust the quantity of.");
                int itemNum = Integer.valueOf(scanner.nextLine());

                InventoryItem item = inv.get(itemNum - 1);

                System.out.println("Please enter the new quantity of the item.");
                int itemQuant = Integer.valueOf(scanner.nextLine());
                item.itemQuantity = itemQuant;
            }

            else{
                System.out.println("Invalid Option.");
            }
        }
    }

    public static InventoryItem createItem(String iName, int iQuant, String iCategory) throws Exception {


        if(iCategory.equalsIgnoreCase("Consumable")){
           return new Consumable(iName, iQuant);
        }

        else if(iCategory.equalsIgnoreCase("Hat")){
            return new Hat(iName, iQuant);
        }

        else if(iCategory.equalsIgnoreCase("Chest")){
            return new Chest(iName, iQuant);
        }

        else if(iCategory.equalsIgnoreCase("Pants")){
            return new Pants(iName, iQuant);
        }

        else if(iCategory.equalsIgnoreCase("shoe")){
            return new Shoe(iName, iQuant);
        }

        else{
            throw new Exception("Invalid Category");
        }
    }
}
