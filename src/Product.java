
public class Product {

	int productID;
	String product_Name;
	String product_Model;
	String product_Manufacturer;
	Double product_Price;
	int quantity;
	int location;
	String product_Type;
	public Product(String [] product) {
		try {
		productID = Integer.parseInt(product[0]);
		product_Name = product[1];
		product_Model = product[2];
		product_Manufacturer = product[3];
		product_Price = Double.valueOf(product[4]);
		quantity = Integer.parseInt(product[5]);
		location = Integer.parseInt(product[6]);
		product_Type = product[7]; 
		}
		catch(Exception ex) {
			System.out.println("The product details have Invalid format! Please check!");
		}
	}
	//Getter and setter methods for Product details
	public int getProductID() {
		return productID;
	}
	public void setProductID(int ID) {
		productID = ID;
	}
	public String getProductName() {
		return product_Name;
	}
	public void setProductName(String prodName) {
		product_Name = prodName;
	}
	public String getProductModel() {
		return product_Model;
	}
	public void setProductModel(String prodModel) {
		product_Model = prodModel;
	}
	public String getProductManufacturer() {
		return product_Manufacturer;
	}
	public void setProductManufacturer(String prodManufacturer) {
		product_Manufacturer = prodManufacturer;
	}
	public Double getProductPrice() {
		return product_Price;
	}
	public void setProductPrice(Double prodPrice) {
		product_Price = prodPrice;
	}
	public int getProductQuant() {
		return quantity;
	}
	public void setProductQuat(int prodQuant) {
		quantity = prodQuant;
	}
	public int getProductLocation() {
		return location;
	}
	public void setProductLocation(int prodLoca) {
		location = prodLoca;
	}
	public String getProductType() {
		return product_Type;
	}
	public void setProductType(String prodType) {
		product_Type = prodType;
	}
}
