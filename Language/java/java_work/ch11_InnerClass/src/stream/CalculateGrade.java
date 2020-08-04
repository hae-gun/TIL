package stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class CalculateGrade {

	public static void main(String[] args) {
		Student std1 = new Student("tom", 90, 80, 70);
		Student std2 = new Student("som", 70, 90, 30);
		Student std3 = new Student("aom", 50, 100, 80);
		Student std4 = new Student("pom", 40, 80, 100);
		
		List<Student> list = new ArrayList<>();
		
		list.add(std1);
		list.add(std2);
		list.add(std3);
		list.add(std4);
		
		Stream<Student> stream = list.stream();
		
		System.out.println("------국어평균-------");
		System.out.println(stream
							.mapToInt(c->c.getKor())
							.average()
							);
		
	
	}

}
