package dto;

import java.io.Serializable;

public class Product implements Serializable{

	private int nsn;
	private String type;
	private String name;
	private int price;

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

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return this.nsn;
	}

	@Override
	public boolean equals(Object obj) {
		Product product = (Product) obj;
		
		if (product.getNsn() == this.getNsn()) {
			if(product.getName().equals(this.getName()))
				return true;
		}
		
		return false;
	}

	@Override
	public String toString() {
		return "제품명: "+name+", 타입: "+type;
	}
	
}
