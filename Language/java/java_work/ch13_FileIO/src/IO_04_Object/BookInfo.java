package IO_04_Object;

import java.io.Serializable;
// Serializable 은 부모가 구현 되었으면 자동으로 구현된다.
// 자식만 구현되어 있을때 ReadObject, WriteObject를 구현하여 부모것을 직렬화 하는 방식이 있다.
// 유의점 : 접근자는 private	
public class BookInfo extends Product implements Serializable{

	String Author;
	int page;

	public BookInfo() {
		super();
	}

	public BookInfo(String code, int price, String name, String number, int page) {
		super(code, price, name);
		this.Author = number;
		this.page = page;
	}
	
	
	
	

	public String getAuthor() {
		return Author;
	}

	public void setAuthor(String author) {
		Author = author;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	@Override
	public String toString() {
		return "BookInfo [Author=" + Author + ", page=" + page + ", code=" + code + ", price=" + price + ", name="
				+ name + "]";
	}
	


}
