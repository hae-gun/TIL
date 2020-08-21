package newMarket.vo;

public class Product {
	private String nsn;
	private int type_no;
	private String name;
	private int price;
	private int amount;

	public Product() {
		
	}

	public Product(String nsn, int type_no, String name, int price, int amount) {
		this.nsn = nsn;
		this.type_no = type_no;
		this.name = name;
		this.price = price;
		this.amount = amount;
	}

	public String getNsn() {
		return nsn;
	}

	public void setNsn(String nsn) {
		this.nsn = nsn;
	}

	public int getType_no() {
		return type_no;
	}

	public void setType_no(int type_no) {
		this.type_no = type_no;
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

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Product [nsn=" + nsn + ", type_no=" + type_no + ", name=" + name + ", price=" + price + ", amount="
				+ amount + "]";
	}
	
	

}
