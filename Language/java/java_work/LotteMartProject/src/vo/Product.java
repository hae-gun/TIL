package vo;

import java.io.Serializable;

public class Product implements Serializable{
	
	private String nsn; // 물품번호
	private ProductType type; // 물건타입
	private String name; // 물건명
	private int price; // 물건가격
	private int amount; // 물건갯수
	
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nsn == null) ? 0 : nsn.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (nsn == null) {
			if (other.nsn != null)
				return false;
		} else if (!nsn.equals(other.nsn))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "[name=" + name + ", type=" + type + ", price=" + price + ", amount=" + amount + "]";
	}
	
	
	
	
	
	
}
