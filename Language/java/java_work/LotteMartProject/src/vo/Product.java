package vo;

import java.io.Serializable;

public class Product implements Serializable{
	
	private String nsn;
	private ProductType type;
	private String name;
	private int price;
	private int amount;
	
	public Product() {
	
	}

	public Product(String nsn, ProductType type, String name,int price, int amount) {
		this.nsn = nsn;
		this.type = type;
		this.name = name;
		this.price = price;
		this.amount = amount;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
			this.amount = amount;
	}

	public String getNsn() {
		return nsn;
	}

	public ProductType getType() {
		return type;
	}
	
	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return "[name=" + name + ", type=" + type + ", price=" + price + ", amount=" + amount + "]";
	}
	
	
	
	
	
	
}
