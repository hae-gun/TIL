package IO_04_Object;

import java.io.Serializable;

public class Product implements Serializable{
	
	// static,transient 으로 선언하면 Serializable 에서 제외된다.
	static String code;
	transient int price;
	String name;
	
	public Product() {

	}
	
	public Product(String code, int price, String name) {
		this.code = code;
		this.price = price;
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Product [code=" + code + ", price=" + price + ", name=" + name + "]";
	}
	
	
	
	
	
}
