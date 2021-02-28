import java.util.ArrayList;

public class AddUsingStack extends ArrayList<Product>{
	public Product peek() {
		if (super.isEmpty()) {
			return null;
		}
		return (Product) get(size() - 1);
	}

	public Product pop() {
		if (super.isEmpty()) {
			return null;
		}
		Product top = (Product) get(size() - 1);
		remove(size() - 1);
		return top;
	}
	public void push(Product element) {
		add(element);
	}
	public int size() {
		return super.size();
	}
	public boolean isEmpty() {
		return super.isEmpty();
	}
}
