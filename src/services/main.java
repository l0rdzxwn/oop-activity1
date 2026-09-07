package services;
import java.util.Scanner;
import models.Item;
import models.Receipt;

public class main {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Receipt rec = new Receipt();
		Item[] items = {
			new Item("Paper"),
		    new Item("Pencil"),
		    new Item("Scissors"),
		    new Item("Eraser")
		};
		
        // MATERIALS
        System.out.println("MATERIALS");
        System.out.println("------------");
        System.out.println("Enter the Cost of the following:");
        for(Item item : items) {
        	System.out.print(item.getName()+ ": ");
        	item.setPrice(scanner.nextDouble());       
        }


        // PURCHASE
        System.out.println("\nPURCHASE");
        System.out.println("---------");
        System.out.println("How many items of the following did you buy?");
        for(Item item : items) {
        	System.out.print(item.getName()+ ": ");
        	item.setQuantity(scanner.nextInt());       
        }
        
        for(int i = 0; i < items.length; i++) {
        	rec.addItem(items[i]);
        }
        System.out.println("");
        System.out.print("THE TOTAL PRICE IS  : P " + rec.calculateTotalDue());
        // CASH INPUT
        System.out.print("\nEnter Cash  : P ");
        double cash = scanner.nextDouble();
        
        rec.printReceipt(cash);
	}
}
