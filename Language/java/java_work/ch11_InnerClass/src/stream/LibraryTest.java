package stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

class Book {

	private String name;
	private int price;

	public Book(String name, int price) {
		super();
		this.name = name;
		this.price = price;
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

	
	
}

public class LibraryTest {
	public static void main(String[] args) {
		List<Book> bookList = new ArrayList<>();
		bookList.add(new Book("자바",25000));
		bookList.add(new Book("파이썬",15000));
		bookList.add(new Book("안드로이드",30000));
		
		Stream<Book> stream = bookList.stream();
		
		System.out.println(stream
							.mapToInt(s->s.getPrice())
							.sum());
		
		Stream<Book> stream2 = bookList.stream();
		stream2.filter(c->c.getPrice()>20000)
				.map(c->c.getName())
				.sorted()
				.forEach(s->System.out.println(s));
								 
	}
}
