package dto;

import java.io.Serializable;

public class Product implements Serializable {

	private int nsn;
	private String type;
	private String name;
	private int price;
	private int count = 0;

	public Product(int nsn, String type, String name, int price) {
		super();
		this.nsn = nsn;
		this.type = type;
		this.name = name;
		this.price = price;
	}

	public int getNsn() {
		return nsn;
	}

	public void setNsn(int nsn) {
		this.nsn = nsn;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		if (count > 0) {
			this.count += count;
		}
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return this.nsn;
	}

	@Override
	public boolean equals(Object obj) {
		Product product = (Product) obj;

		if (product.getNsn() == this.getNsn()) {
			if (product.getName().equals(this.getName()))
				return true;
		}

		return false;
	}

	@Override
	public String toString() {
		return "Product [nsn=" + nsn + ", type=" + type + ", name=" + name + ", price=" + price + "]";
	}

}
