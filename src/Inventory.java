
public class Inventory {
	//int productID;	
	//String manufacturer;
	String productType;
	String storeID;
	int quantity;

	public Inventory(String [] inventoryDetails) {
		try {
			productType = inventoryDetails[0];
			storeID = inventoryDetails[1];		
			quantity = Integer.parseInt(inventoryDetails[2]);
		}
		catch(Exception ex) {
			System.out.println("Invalid Inventory details format");
		}
	}

	//Getter and setter methods
	public String getProductType() {
		return productType;
	}
	public void setProductType(String prodType) {
		productType = prodType;
	}

	public String getStoreID() {
		return storeID;
	}
	public void setStoreID(String strID) {
		storeID = strID;
	}
	public int getQuantity(){
		return quantity;
	}
	public void setQuantity(int quan) {
		quantity = quan;
	}
}


