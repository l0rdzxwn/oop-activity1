package models;
import java.util.ArrayList;
import java.util.List;

public class Receipt {
	
	List<Item> list = new ArrayList<>();
	
	public void addItem(Item item) {
		list.add(item);
	}
	
	public double calculateTotalDue(){
		double sum = 0.00;
		for(Item item : list) {
			sum += (item.getPrice() * item.getQuantity()); 
		}
		return sum;
	}
	
	public double calculateVAT() {
		return (calculateTotalDue()/(1+0.12));
	}
	
	public void printReceipt(double cash){
		
		int totalItems = 0;
		
		System.out.println("OFFICIAL RECEIPT");
		System.out.println("-----------------------");
		
		for(Item item : list) {
			System.out.printf("%-10s: P %6.2f%n",item.getName(), (item.getPrice()*item.getQuantity()));
			totalItems += item.getQuantity();
		}
		System.out.println("-----------------------");
		System.out.println("Total     : " + "P   " + calculateTotalDue());
		System.out.println("Cash      : " + "P   " +  cash);
		System.out.println("Change    : " + "P   " + (cash - calculateTotalDue()));
		System.out.println("");
		System.out.println("No. of Items :      "+ totalItems);
		System.out.println("");
		System.out.printf("Price before VAT     : " + "P    %.2f\n", calculateVAT());
		System.out.printf("VAT                  : " + "P    %.2f\n", (calculateTotalDue()*0.12));
	}
	
	public void printInvoice(double cash) {
	    int totalItems = 0;

	    System.out.println("*** INTERNATIONAL BOOKSTORE ***");
	    System.out.println("         Sales Invoice         ");
	    System.out.println("--------------------------------");

	    for (Item item : list) {
	        double itemTotal = item.getPrice() * item.getQuantity();
	        System.out.printf("%2d %-10s @ %6.2f   : P %6.2f%n", 
	            item.getQuantity(), 
	            item.getName(), 
	            item.getPrice(), 
	            itemTotal
	        );
	        totalItems += item.getQuantity();
	    }

	    System.out.println("--------------------------------");
	    System.out.printf("%-20s : P %6.2f%n", "TOTAL", calculateTotalDue());
	    System.out.printf("%-20s : P %6.2f%n", "Cash", cash);
	    System.out.printf("%-20s : P %6.2f%n", "Change", cash - calculateTotalDue());
	    System.out.println();
	    System.out.printf("%-20s : P %6.2f%n", "Price before VAT", calculateVAT());
	    System.out.printf("%-20s : P %6.2f%n", "VAT (12%%)", calculateTotalDue()*0.12);
	    System.out.printf("%-20s : %4d%n", "Total Number of Items", totalItems);
	}
}
