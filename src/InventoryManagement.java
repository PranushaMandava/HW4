import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class InventoryManagement {
	public static ArrayList<Product> products = new ArrayList<Product>();
	public static ArrayList<Inventory> inventory = new ArrayList<Inventory>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String [] prodDetails = {"1","Galaxy","A21","Samsung", "399.9", "10", "60613", "MobilePhone"};
		String [] prodDetails1 = {"2","GalaxyNote","20","Samsung", "699.9", "10", "60613", "MobilePhone"};
		String [] prodDetails2 = {"3","Apple12","Pro","Apple", "1199.9", "10", "60613", "MobilePhone"};
		String [] prodDetails3 = {"4","Airpods","Pods","Apple", "199.9", "10", "60613", "EarPhones"};
		String [] prodDetails4 = {"5","AppleWatch","Series6","Apple", "399.9", "10", "60613", "SmartWatch"};
		String [] prodDetails5 = {"6","Charger","USBC","Apple", "19.9", "10", "60613", "Accessories"};
		
		String [] inventory1 = {"MobilePhone","StoreChi01", "5"};
		String [] inventory2 = {"EarPhones","StoreNaperville01", "5"};
		String [] inventory3 = {"Accessories","StoreRiverLake01", "5"};
		String [] inventory4 = {"SmartWatch","StoreChi01","5"};
		//Add records into inventory list
		Inventory inv = new Inventory(inventory1);
		inventory.add(inv);
		inv = new Inventory(inventory2);
		inventory.add(inv);
		inv = new Inventory(inventory3);
		inventory.add(inv);
		inv = new Inventory(inventory4);
		inventory.add(inv);
	

		//Add Products to the Products list
		Product P1 = new Product(prodDetails);
		addNewRecord(P1);
		P1 = new Product(prodDetails1);
		addNewRecord(P1);
		P1 = new Product(prodDetails2);
		addNewRecord(P1);
		P1 = new Product(prodDetails3);
		addNewRecord(P1);
		P1 = new Product(prodDetails4);
		addNewRecord(P1);
		P1 = new Product(prodDetails5);
		addNewRecord(P1);
		
		System.out.println("Hello! Choose among the below options\n");
		System.out.println("1. Display complete Inventory\n 1.a Display products by Manufacturer\n2. Add a new Product\n3. Update a product price\n4. Delete a product\n");
		Scanner scan = new Scanner (System.in);
		String getMainMenu= scan.next().trim();
		switch(getMainMenu)
		{
		//Case 1: Displays all the products and the inventory count
		case "1": 
			displayAllProducts(); 
			displayInventory();
			break;
		case "1.a":
			getManufacturerList();
			System.out.println("Enter the Manufacturer with which the products have to be sorted");
			scan =  new Scanner (System.in);
			String Manufacturer = scan.nextLine();
			displayBasedonManufacturer(Manufacturer);
			break;
		//case 2: Adds new products into the products inventory, the details to be entered in right format
		case "2": 
			System.out.println("Enter the product details with a comma in between in the below order:");
			System.out.println("ProductID ProductName ProductModel Manufacturer Price Quantity Location ProductType");
			System.out.println("Example - 6,Charger,USBC,Apple,19.9,10,60613,Accessories");
			scan =  new Scanner (System.in);
			String details = scan.nextLine();
			String[] newProdDetails = details.split(",");
			P1 = new Product(newProdDetails);
			//Inventory before adding the product
			System.out.println("Inventory before adding the product:");
			displayInventory();
			addNewRecord(P1);
			System.out.println("New product is added into the products list");
			//inventory after adding the product
			System.out.println("Inventory after adding the product:");
			displayAllProducts();
			displayInventory(); 
			break;
		//Update a Product's price details
		case "3": 
			System.out.println("Provide the Product ID and Price to be updated with a comma in between\n");
			scan =  new Scanner (System.in);
			String update = scan.nextLine();
			String[] updateDetails = update.split(",");
			updateProdPrice(Integer.parseInt(updateDetails[0]), Double.valueOf(updateDetails[1]));
			System.out.println("Product list after updating the price:");
			displayAllProducts();
			break;
		//Case 4: Delete a product of given ID.
		case "4": 			
			//Inventory before delete the product
			System.out.println("Inventory before deleting the product");
			displayInventory();
			displayAllProducts();
			System.out.println("Choose a Product ID from above Products list to be deleted.");
			System.out.println("Enter the ProductID to be deleted.");
			scan =  new Scanner (System.in);
			int pID = scan.nextInt();
			deleteRecord(pID);
			System.out.println("The product has been deleted from the products list");
			//Inventory after deleting the product
			System.out.println("Inventory after deleting the product");
			displayAllProducts();
			displayInventory();
			break;
		}
	}


	//This methods deletes the record of the given Product ID in the Products table
	public static void deleteRecord(int prodID) {
		String getProductType = null;
		for (int i = 0; i< products.size();i++) {			
			if (products.get(i).getProductID()== prodID)
			{	
				getProductType = products.get(i).getProductType();	
				products.remove(i);					
			}
		}
		//Reduce the count of the product(quantity) from inventory table of the particular product
		for(int i= 0; i< inventory.size();i++) {
			if(getProductType.equalsIgnoreCase(inventory.get(i).getProductType())){
				inventory.get(i).setQuantity(inventory.get(i).getQuantity()  - 1);
			}
		}
		System.out.println("The product has been removed from the inventory!");
		//displayAllProducts();
	}
	//This method updates the Price of a given product
	public static void updateProdPrice(int id, Double price ) {
		int getIndex =0;
		for (int i = 0; i<products.size();i++) {			
			if (products.get(i).getProductID()== id)
			{		
				getIndex = i;
				products.get(i).setProductPrice(price);
			}
		}
		System.out.println("Product with ID "+id+ " is updated with the latest price. Updated Product details are below:");
		System.out.println("Product -"+products.get(getIndex).getProductName()+", updated price is "+products.get(getIndex).getProductPrice());
	}
	//The below method adds a new record into the Product inventory
	public static void addNewRecord(Product prod) {
		String getProductType = prod.getProductType();
		products.add(prod);
		//Update the count of the product in the inventory table
		for(int i= 0; i< inventory.size();i++) {
			if(getProductType.equalsIgnoreCase(inventory.get(i).getProductType())){
				inventory.get(i).setQuantity(inventory.get(i).getQuantity()  + 1); 
			}
		}
	}
	//Method to display all the products available in the products list along with the details
	public static void displayAllProducts()
	{
		System.out.println("The Products available are:");
		
		System.out.printf("%10s %15s %15s %15s %5s %5s %7s %15s","ProductID",  "ProductName",  "ProductModel",  "Manufacturer",  "Price",  "Quantity",  "Location",  "ProductType\n");
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------");
		for (int i =0 ; i< products.size();i++) {
			System.out.format( "%10d %15s %15s %15s %10.2f %5d %7d %15s", products.get(i).getProductID(), products.get(i).getProductName(), products.get(i).getProductModel() , products.get(i).getProductManufacturer(), products.get(i).getProductPrice(),products.get(i).getProductQuant(),products.get(i).getProductLocation(),products.get(i).getProductType());
			System.out.println("");
		}
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------");
		
	}
	//This method displays the Products details based on the Manufacturer
	public static void displayBasedonManufacturer(String manufacturer) {
		System.out.println("Products available from  "+manufacturer+" are:");
		System.out.printf("%10s %15s %15s %15s %5s %5s %7s %15s","ProductID",  "ProductName",  "ProductModel",  "Manufacturer",  "Price",  "Quantity",  "Location",  "ProductType\n");
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------");
		for (int i = 0; i<products.size();i++) {			
			if (products.get(i).getProductManufacturer().equalsIgnoreCase(manufacturer) )
			{		
				System.out.format( "%10d %15s %15s %15s %10.2f %5d %7d %15s", products.get(i).getProductID(), products.get(i).getProductName(), products.get(i).getProductModel() , products.get(i).getProductManufacturer(), products.get(i).getProductPrice(),products.get(i).getProductQuant(),products.get(i).getProductLocation(),products.get(i).getProductType());
				System.out.println("");
			}
		}
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------");
	}

	//This method displays the entire inventory with the products count
	public static void displayInventory()
	{
		System.out.println("The inventory details are:");
		System.out.printf("%20s %20s %15s", "ProductType",  "StoreID " , " Quantity\n");
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------");
		for (int i =0 ; i< inventory.size();i++) {
			System.out.format( "%20s %20s %5d", inventory.get(i).getProductType() ,inventory.get(i).getStoreID(),inventory.get(i).getQuantity());
			System.out.println("");
		}
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------");		
	}
	//Method to display all Manufacturers available in the inventory
	public static void getManufacturerList() {
		Set<String> uniqManufacturers = new HashSet<String>();
		System.out.println("Manufacturers available are:");
		for (int i =0 ; i< products.size();i++) {
			uniqManufacturers.add(products.get(i).getProductManufacturer());
		}
		System.out.println(uniqManufacturers);
	}
}
