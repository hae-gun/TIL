# 자바 Collection Framework 정렬하기



## 객체에 Comparable 인터페이스 상속받아 정렬

* 사용자가 정의한 객체에서 Comparable<클래스명> 인터페이스를 상속받 compareTo 메서드를 구현함으로써 사용자가 정의하는 정렬 기준을 정할 수 있다.

* 사용할 객체

  ```java
  
  class myObject implements Comparable<myObject>{
  	String name;
  	int number1;
  	int number2;
  
  	public myObject(String name, int number1, int number2) {
  		this.name = name;
  		this.number1 = number1;
  		this.number2 = number2;
  	}
  
  	@Override
  	public int compareTo(myObject o) {
  		
  		if(this.number1 < o.number1) {
  			return -1;
  		}else if(this.number1 == o.number1 && this.number2<o.number1) {
  			return -1;
  		}else if(this.number1 > o.number1) {
  			return 1;
  		}
  		
  		return 0;
  	}
  
  	@Override
  	public String toString() {
  		return "["+this.name+","+this.number1+","+this.number2+"]";
  	}
  }
  ```

* 테스트

  ```java
  package java_logic;
  
  import java.util.ArrayList;
  import java.util.Collections;
  
  public class CollectionSort {
  	public static void main(String[] args) {
  		ArrayList<myObject> list = new ArrayList<myObject>();
  		
  		list.add(new myObject("A", 2, 2));
  		list.add(new myObject("A", 1, 1));
  		list.add(new myObject("A", 2, 1));
  		list.add(new myObject("A", 1, 2));
  		
  		System.out.println("before sorting:"+list);
  		Collections.sort(list);
  		
  		System.out.println("after sorting:"+list);
  		
  	}
  }
  ```

* 결과

  ![스크린샷 2020-09-17 오후 9.53.52](Collection_CustomSorting.assets/스크린샷 2020-09-17 오후 9.53.52.png)

## Comparator 인터페이스의 compare 메소드를 오버라이딩 하여 정렬

* 위와 유사하지만 다른 인터페이스인 Comparator를 이용하여 커스텀 정렬이 가능하다.

* Comparable 인터페이스의 경우 사용하는 객체에 상속함으로 사용했지만 Comparator 인터페이스는 정렬하는 객체와는 별개로 구현한다.

* Comparator 인터페이스를 상속받는 객체를 정의해 주거나 이너클래스형태로 작성이 가능함.

* 상속하여 객체 정의 할 경우

  ```java
  class myComparator implements Comparator<myObject2>{
  
  	@Override
  	public int compare(myObject2 o1, myObject2 o2) {
  
  		if (o1.number1 < o2.number1) {
  			return -1;
  		} else if (o1.number1 == o2.number1 && o1.number2 < o2.number1) {
  			return -1;
  		} else if (o1.number1 > o2.number1) {
  			return 1;
  		}
  
  		return 0;
  	}
  }
  ```

  * 객체에 Comparator 인터페이스를 직접 상속할 시에도 제네릭은 정렬할 객체로 지정해 주어야 사용이 가능하다!

* 이너 클래스로 사용할 경우

  * 정렬할 클래스 정의

  ```java
  class myObject2 {
  	String name;
  	int number1;
  	int number2;
  
  	public myObject2(String name, int number1, int number2) {
  		this.name = name;
  		this.number1 = number1;
  		this.number2 = number2;
  	}
  
  	@Override
  	public String toString() {
  		return "[" + this.name + "," + this.number1 + "," + this.number2 + "]";
  	}
  
  }
  ```

  * 이너클래스로 정렬

  ```java
  public class Sort_Comparator {
  	public static void main(String[] args) {
  		ArrayList<myObject2> list = new ArrayList<myObject2>();
  
  		list.add(new myObject2("A", 2, 2));
  		list.add(new myObject2("A", 1, 1));
  		list.add(new myObject2("A", 2, 1));
  		list.add(new myObject2("A", 1, 2));
  
  		System.out.println("before sorting:" + list);
  		Collections.sort(list, new Comparator<myObject2>() {
  
  			@Override
  			public int compare(myObject2 o1, myObject2 o2) {
  				if (o1.number1 < o2.number1) {
  					return -1;
  				} else if (o1.number1 == o2.number1 && o1.number2 < o2.number1) {
  					return -1;
  				} else if (o1.number1 > o2.number1) {
  					return 1;
  				}
  
  				return 0;
  			}
  
  		});
  
  		System.out.println("after sorting:" + list);
  	}
  }
  ```

* 결과

  ![스크린샷 2020-09-17 오후 11.56.14](Collection_CustomSorting.assets/스크린샷 2020-09-17 오후 11.56.14.png)

