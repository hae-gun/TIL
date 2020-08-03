# Java Day02

## 변수

### 종류

1. Field 변수
   * int 를 field로 선언하면 자동으로 0으로 초기화된다.
   * 데이터 타입별로 초기화 되는 값이 정해져 있다.
2. Local 변수
   * 로컬 변수는 메소드 안에서 선언하는 변수이다.
   * 로컬 변수는 초기화 해야 사용이 가능하다.



* `scope` : 변수 사용 범위

## 자료형

### 기본형

* number type

  * 정수타입 : byte, char(문자형), short, int, long
  * byte 수  :   1    /     2          /            2   /   4   /  8

  > byte 란? 
  >
  >  1byte = 8bit
  >
  > bit 란?
  >
  >  0 or 1 을 담을 수 있는 공간(메모리에 담는 최소단위)
  >
  >  1 byte : 0000 0000 (2) -> 2^8 = 256가지 => -128~127 까지 숫자 가능.
  >
  >  첫 번째 bit를 부호비트 라고 한다. 0 : 양수 1 : 음수

  * 각 타입별 범위
    * byte(8bit) : -128 ~ 127
    * int(32bit) : -2^31~ 2^31-1
    * long(64bit) : -2^63~ 2^63-1   -> 숫자뒤에 `l or L`을 표시해줌

> 데이터 타입의 범위는 중요하다. 의도치 않은 자료가 나올 수 있다.

* 실수 타입

  * `float / double` : 소숫점 있는 숫자
  * byte 수 : float - 4 / double - 8
  * float 타입은 숫자뒤에 `f or F` 를 표시해준다.

  ```java
  	float var7 = 3.14f;
  	float var8 = 3e6f; // 3000000.0f
  	double var9 = 3e6; // 3000000.0
  		
  	double var10 = 2e-3; // 0.002
  		
  	System.out.println(var7);
  	System.out.println(var8);
  	System.out.println(var9);
  	System.out.println(var10);
  ```

### 문자형

* `char` : 사실상 `char`도 알고보면 정수형이지만 그 정수는 바로 아스키(ASCII) 코드이다!

  ```java
  char c1 = 'A';
  		char c2 = 65;
  		char c3 = '\u0041';
  		
  		System.out.println("c1: " + c1);
  		System.out.println("c2: " + c2);
  		System.out.println("c3: " + c3);
  		
  		// ASCII code 0A0D : 개행문자 \n
  		
  		int ic = c1; // char 타입의 변수값을 int 타입으로 형변환 - 자동형변환 : 크기가 작은 타입에서 큰 타입으로 형변환됨.
  		System.out.println(ic);
  		
  		char c4 = '가';
  		System.out.println(c4);
  		
  		ic = c4;
  		System.out.println(ic); // 한글은 유니코드값으로 저장됨 가 -> 44032
  		
  		char c5 = 44033;
  		System.out.println(c5);
  ```

###  Boolean Type

* 1 byte 로 표현되는 논리타입이다.

* 값은 True, False 밖에 없다.

  ```java
  public class Dt03 {
  	public static void main(String[] args) {
  		boolean stop = false;
  		
  		if(stop) {
  			System.out.println("Stop!!");
  		}else{
  			System.out.println("Go!!");
  		}
  	}
  }
  
  ```

## 문자열

* `String` 으로 문자열 형태의 변수를 사용할 수 있다.

* String은 참조변수 이다. 그러나 기본 데이터 타입처럼 사용이 가능하다.

* 문자열 저장은 쌍 따옴표 `""`로 초기화가 가능하다.

  ```java
  public class Dt04 {
  	public static void main(String[] args) {
  		
  		String str = "홍길동";
  		System.out.println(str);
  		
  		System.out.println(str.charAt(0));
  	}
  }
  ```

  ![image-20200721132612535](JavaDay02.assets/image-20200721132612535.png)

​	

## 형변환 (type conversion)

* data type을 바꿈

* 자동형변환 (작은타입 -> 큰타입)

* 강제형변환 => `()` 안에 바꿔줄 타입을 명시해 줌.

  * 데이터 손실을 감소 할 수 밖에 없다.

  ```java
  public class Dt05 {
  
  	public static void main(String[] args) {
  		
  		int num1 = 200;
  		System.out.println(num1);
  		
  		double num2 = num1; // int type의 값을 double type 변수에 대입 - 자동형변환 (작은타입 -> 큰타입)
  		System.out.println(num2);
  		
  //		int num3 = num2; - Type mismatch: cannot convert from double to int
  		int num3 = (int)num2; // 강제 형변환 - 데이터 손실을 감소 할 수 밖에 없다.
  	}
  }
  ```

* 연산에 의한 형변환

  * 자동형변환 : int + double -> double
  * 변수를 정수와 연산하면 int값으로 반환된다. 따라서 (char)를 해줘야 함
  * char는 빈 문자로 초기화 할 수 없다.
  * int 보다 작은 타입을 연산하면 자동으로 int로 형변환된다.

  ```java
  public class Dt06 {
  
  	// field (전역변수)
  	String name; // 자동 초기화
  
  	public static void main(String[] args) {
  		int intV = 10;
  		double doubleV = 5.5;
  
  		double result1 = intV + doubleV; // 자동형변환 : int + double -> double
  		int result2 = (int) (intV + doubleV); // 강제형변환
  		int result3 = intV + (int) doubleV; // 강제형변환
  
  		System.out.println(result1 + " : " + result2 + " : " + result3);
  
  		char a = 'A';
  		char b = 'A' + 1; // 'B'
  		System.out.println(a + " : " + b);
  
  		int c = a + 1;// => 65 + 1
  
  		char d = (char) (a + 1); // 변수를 정수와 연산하면 int값으로 반환된다. 따라서 (char)를 해줘야 함
  
  		System.out.println(c + " : " + d);
  
  		// 필드 변수 자동 초기화 값
  		String str = ""; // 빈 문자열로 초기화
  		int num = 0;
  		float fl = 0.0f;
  //		char e = ''; // char는 빈 문자로 초기화 할 수 없다.
  
  		byte b1 = 10;
  		byte b2 = 20;
  		byte result = (byte) (b1 + b2); // int 보다 작은 타입을 연산하면 자동으로 int로 형변환된다.
  		System.out.println(result);
  
  	}
  
  }
  ```

## 타입 지정 및 이스케이프 문자

* 타입 지정

  * `%c` - char
  * `%s` - String
  * `%d` - Integer
  * `%f` - 실수
  * `%b` - boolean

  ```java
  public class Printf {
  	public static void main(String[] args) {
  		
  		// printf : 출력 타입 지정하고 뒤에 순서대로 붙여줌
  		/*
  		 * 타입 지정 : %c - char/ %s - String/ %d - Integer
  		 * 			%f - 실수 / %b - boolean
  		 *  \(이스케이프 문자) : \n - 줄바꿈 (enter키)
  		 *  				 \t - tab
  		 *  				 \\ -  백슬레시
  		 */
  		System.out.println("문자" + 'A'+" 의 유니코드 값은 "+(int)'A');
  		System.out.printf("문자%c 의 유니코드 값은 %d\n",'A',(int)'A');
  		System.out.printf("문자%c 의 유니코드 값은 %d\n",'글',(int)'글');
  		
  		System.out.printf("3자리 숫자: %d는 %s다 => %b\n",379,"짝수",false);
  		System.out.printf("열 자리에 3자리 숫자 %10d를 오른쪽 정렬\n",379);
  		System.out.printf("열 자리에 3자리 숫자 %-10d를 왼쪽 정렬\n",379);
  		System.out.printf("열 자리에 3자리 숫자 %010d를 오른쪽 정렬 빈자리 0\n",379);
  		System.out.printf("%f를 소숫점 2째자리까지 반올림 하면 %.2f 가 됩니다.\n",3.14512,3.14);
  		System.out.printf("%f를 정수 다섯자리, 소숫점 2째자리까지 반올림하면 &7.2f가 됩니다.\n",3423.1415920,3423.1415920);
  	}
  }
  ```

## 입력값 받기

### System.in을 이용한 입력받기

* 기본적으로 System 은 Console을 가르키는 객체로 본다.

* 해당 객체에서 Input스트림인 in에서 read 매서드를 이용하여 1개의 문자를 가져올 수 있다.

* 여기서 입력후 엔터를 치게되면 `\r\n`이란 문자가 같이 들어와 해당 값을 GC를 이용하여 처리 하여준다.

  ```java
  public class SyscCharInput {
  
  	public static void main(String[] args) throws IOException {
  
  		char a = '0';
  		System.out.println(a);
  		System.out.println((int) a);
  
  		System.out.println("2부터 9사이의 숫자를 입력하세요>>> ");
  //		int num = System.in.read() - 48;
  		int num = System.in.read() - '0';
  		System.out.printf("입력한 숫자는 %d입니다. \n", num);
  		
  		// enter 값 발생 : 다음입력을 위해 처리
  		// \r\n : 엔터키 값. 13 10
  		// 두 값을 받아서 변수에 저장하지 않으면 쓰레기 처리반 (garbage collector 가 처리)
  //		System.in.read(); // \r
  //		System.in.read(); // \n
  		
  		System.in.skip(2); // 입력 2개 건너뛰기
  		
  		System.out.println("a~z 사이의 문자 하나를 입력하세요>>> ");
  		char input = (char) System.in.read();
  
  		System.out.printf("입력한 문자는 %c입니다. \n", input);
  
  	}
  
  }
  ```

### Scanner 객체이용

```java
import java.io.IOException;

public class SyscCharInput {

	public static void main(String[] args) throws IOException {

		char a = '0';
		System.out.println(a);
		System.out.println((int) a);

		System.out.println("2부터 9사이의 숫자를 입력하세요>>> ");
//		int num = System.in.read() - 48;
		int num = System.in.read() - '0';
		System.out.printf("입력한 숫자는 %d입니다. \n", num);
		
		// enter 값 발생 : 다음입력을 위해 처리
		// \r\n : 엔터키 값. 13 10
		// 두 값을 받아서 변수에 저장하지 않으면 쓰레기 처리반 (garbage collector 가 처리)
//		System.in.read(); // \r
//		System.in.read(); // \n
		
		System.in.skip(2); // 입력 2개 건너뛰기
		
		System.out.println("a~z 사이의 문자 하나를 입력하세요>>> ");
		char input = (char) System.in.read();

		System.out.printf("입력한 문자는 %c입니다. \n", input);

	}

}
```



#### 예제

* 온도 변화기

```java
import java.util.Scanner;

// 온도 변화기 : 화씨, 섭씨 온도를 입력받아 변환하여 출력
public class TempConverter {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		System.out.println("화씨->섭씨: 1, 섭씨 -> 화씨: 2 선택 >>>");
		String kind = scan.nextLine();
		int select = Integer.parseInt(kind);
		
		if (select == 1) {
		
			System.out.println("화씨 온도를 입력하세요. >>>");
			String tmp = scan.nextLine();
			int ft = Integer.parseInt(tmp);
			float ct = (ft - 32) * 5 / (float)9;
			System.out.printf("화씨 %d도는 섭씨 %.2f입니다.", ft, ct);
		
		} else if (select == 2) {
		
			System.out.println("섭씨 온도를 입력하세요. >>>");
			String tmp = scan.nextLine();
			int ct = Integer.parseInt(tmp);
			float ft = (float)ct*9/5 + 32;
			System.out.printf("섭씨 %d도는 화씨 %.2f입니다.", ct, ft);
		
		}else {
		
			System.out.println("정신 차려라, 1 or 2를 쓰셈 ㅋㅋㅋ");
	
		}

	}
}

```



## 연산자

### 1. 산술 연산자

* `+, -, *, /, %`

```java
public class Op01 {

	public static void main(String[] args) {
		// 산술 연산자
		// +, -, *, /, %
		
		int n1 = 33;
		int n2 = 10;
		int result;
		
		result = n1+n2;
		System.out.printf("%d %c %d = %d \n",n1,'+',n2,result);
		result = n1-n2;
		System.out.printf("%d %c %d = %d \n",n1,'-',n2,result);
		result = n1*n2;
		System.out.printf("%d %c %d = %d \n",n1,'*',n2,result);
		result = n1/n2;
		System.out.printf("%d %c %d = %d \n",n1,'/',n2,result); // '/' 는 몫만 반환
		result = n1%n2;
		System.out.printf("%d %c %d = %d \n",n1,'%',n2,result); // '%' 는 나머지를 반환
	}

}
```

### 2. 비교 연산자

* 결과값을 `boolean type( true, false )`로 반환한다.

  ```java
  public class Op02 {
  	public static void main(String[] args) {
  		// 비교 연산자 : 결과값을 boolean type(true, false)로 반환한다.
  		// <, >, <=, >=, ==, !=
  		int n1 = 33;
  		int n2 = 10;
  		boolean result;
  		
  		result = n1>n2;
  		System.out.printf("%d %c %d = %b \n",n1,'>',n2,result);
  		result = n1<n2;
  		System.out.printf("%d %c %d = %b \n",n1,'<',n2,result);
  		result = n1>=n2;
  		System.out.printf("%d %s %d = %b \n",n1,">=",n2,result);
  		result = n1<=n2;
  		System.out.printf("%d %s %d = %b \n",n1,"<=",n2,result);
  		result = n1==n2;
  		System.out.printf("%d %s %d = %b \n",n1,"==",n2,result);
  		result = n1!=n2;
  		System.out.printf("%d %s %d = %b \n",n1,"!=",n2,result);
  	}
  }
  ```

### 3. 논리 연산자

* 좌항 우항을 비교하여 논리값(boolean)반환.

* `&& (and), || (or), ! (not), ^ (xor)`

  ```java
  public class Op03 {
  	public static void main(String[] args) {
  		
  		// 논리 연산자: boolean 반환
  		// &&(and), ||(or), !(not), ^(xor)
  		
  		int n1 = 10, n2 = 4, n3 = 7, n4 = 15;
  		// && 연산자
  		
  		// &&: 좌항, 우항이 모두 참일 경우에만 참
  		// ||: 좌항, 우항 중 어느 한쪽이라도 참이면 참
  		
  		// &&는 회로상 직렬회로.
  		System.out.println(n1 > n2 && n3 < n4); // true && true => true
  		System.out.println(n1 > n2 && n3 > n4); // true && false => false
  		System.out.println(n1 < n2 && n3 < n4); // false && true => false
  		System.out.println(n1 < n2 && n3 > n4); // false && false => false
  		System.out.println("------------------------");
  		
  		// ||는 회로상 병렬회로
  		System.out.println(n1 > n2 || n3 < n4); // true || true => true
  		System.out.println(n1 > n2 || n3 > n4); // true || false => true
  		System.out.println(n1 < n2 || n3 < n4); // false || true => true
  		System.out.println(n1 < n2 || n3 > n4); // false || false => false
  		System.out.println("------------------------");
  		
  		// ^ : 좌항 우항의 값이 같으면 flase 다르면 true
  		System.out.println(n1 > n2 ^ n3 < n4); // true ^ true => false
  		System.out.println(n1 > n2 ^ n3 > n4); // true ^ false => true
  		System.out.println(n1 < n2 ^ n3 < n4); // false ^ true => true
  		System.out.println(n1 < n2 ^ n3 > n4); // false ^ false => false
  		System.out.println("------------------------");
  		
  		// ! : 우항의 반대값(boolean) 반환
  		System.out.printf("!%b = %b\n",true,!true);
  		System.out.printf("!%b = %b\n",false,!false);
  		
  		// 작성할 때 먼저 확인하고 싶은것이 앞에 나와야 한다.
  		// && 연산은 좌항값이 false 이면 뒤값을 보지 않는다.
  		// || 연산은 좌항값이 true 이면 뒤값을 보지 않는다.
  	}
  }
  ```



### 4. 증감 연산자

* `++, --` : 해당 변수를 1 증가(++)/감소(--) 시킨다.

* 증감 연산자에서는 전위,후위 증감이 중요하다.

  * 후위증감 연산자는 대입연산자 보다 연산 순위가 낮기 때문에 대입 후에 해당 연산이 진행된다.

  ```java
  public class Op04 {
  	
  	public static void main(String[] args) {
  		// 전위증감, 후위증감 : 연산 우선순위 차이
  		// 후위증감 : 대입 연산자보다 순위가 낮다.
  		int num2 = 10;
  		int num3 = num2++;
  		System.out.printf("num2:%d, num3:%d",num2,num3);
          int tmp = 10;
  		System.out.printf("%d %d %d %d %d\n",tmp++,++tmp,tmp--,++tmp,tmp++);
  		System.out.println(tmp);
  	}
  }
  ```

  ![image-20200722111637843](JavaDay02.assets/image-20200722111637843.png)

  ![image-20200722112528722](JavaDay02.assets/image-20200722112528722.png)

### 5. 대입 연산자

* 우황의 결과를 좌항에 대입

* 종류 : `=, +=, -=, *=, /=, %=`

  ```java
  public class Op05 {
  
  	public static void main(String[] args) {
  		// 대입연산자 : 우항의 결과를 좌항에 대입
  		// =, +=, -=, *=, /=, %=
  		int n1 = 10;
  		
  		n1 *= 3; // n1 = n1 * 3
  		System.out.println(n1);
  		
  		n1 /= 4;
  		System.out.println(n1);
  		
  		n1 %= 2;
  		System.out.println(n1);
  		
  	}
  
  }
  ```

  ![image-20200722113414266](JavaDay02.assets/image-20200722113414266.png)

### 6. 비트 연산자

* 두 변수를 비트로 변환하여 연산.

  ```java
  
  public class Op06 {
  	public static void main(String[] args) {
  		//비트 연산자
  		// &, |, ^, !
  		
  		int n1 = 10;
  		int n2 = 5;
  		int result = n1 & n2;
  		System.out.println(result);
  		
  //		10 : 0000 1010
  //		 5 : 0000 0101
  //	    ---------------
  //	   &연산: 0000 0000
  		
  		result = n1 | n2;
  		System.out.println(result);
  		
  //		10 : 0000 1010
  //		 5 : 0000 0101
  //	    ---------------
  //	   |연산: 0000 1111
  		
  		result = n1 ^ n2;
  		System.out.println(result);
  		
  //		10 : 0000 1010
  //		 5 : 0000 0101
  //	    ---------------
  //	   ^연산: 0000 1111
  		
  	}
  }
  
  ```

  ![image-20200722113716945](JavaDay02.assets/image-20200722113716945.png)

### 7. 쉬프트(Shift) 연산자

* `<<, >>` : 해당 변수의비트를 이동시킴.

* `<<`(left 연산자) : 좌항 변수값에 2의 n승을 곱한 결과

* `>>`(right 연산자) : 좌항 변수값에 2의 n승을 나눈 결과

  ```java
  public class Op07 {
  
  	public static void main(String[] args) {
  		// shift 연산자
  		// <<: left 연산자
  		// >>: right 연산자
  		int n1 = 5;
  		
  		System.out.println(n1<<1);
  //		 5 : 0000 0101
  //		<<1: 0000 1010
  //		빈 칸에는 0이 들어온다.
  //		left 연산자: 좌항 변수값에 2의 n승을 곱한 결과
  		
  		System.out.println(n1>>2);
  //		right 연산자: 좌항 변수값에 2의 n승을 나눈 결과
  //		 5 : 0000 0101
  //		>>2: 0000 0001
  		
  	}
  
  }
  ```

  ![image-20200722114427499](JavaDay02.assets/image-20200722114427499.png)

### 8. 3항 조건식

* 문법 : `조건식 ? true일 때의 실행문 : false일 때의 실행문`

#### 예제

> 주민등록번호를 입력받아 8번째 자리 문자를 뽑아내어 홀수이면 남자, 짝수이면 여자를 출력하기.

```java
public class Op09 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		String str = "";
		int gender = 0;
		
		System.out.println("주민번호 입력(123456-1234567)>>>");
		String idNo = scan.nextLine();
		
		gender = idNo.charAt(7)-'0';
		
		str = gender%2 == 0 ? "여자" : "남자"; 
		
		System.out.println(str);
	}
}
```

![image-20200722131655209](JavaDay02.assets/image-20200722131655209.png)

![image-20200722131713610](JavaDay02.assets/image-20200722131713610.png)



### 9. 문자열 연산

* 문자열 연산은 + 연산이 가능하다.

* +한 두 문자열을 붙인다.

* 숫자 + 문자열 연산시 문자열로 반환된다.

  ```java
  public class Op12 {
  	public static void main(String[] args) {
  		// String 연산 - 덧셈만 가능
  		String a = "I ";
  		String b = "love ";
  		String c = "you";
  		System.out.println(a+b+c);
  		
  		// 문자열 + 숫자 => 문자열
  		String e = "JAVA";
  		
  		System.out.println(e + 8.0);
  		
  		// String 의 내용 비교는 equals 메소드 사용
  		String str1 = "today";
  		String str2 = "today";
  		
  		
  		if(str1 == "today") {
  			System.out.println("yes");
  		}else {
  			System.out.println("no");
  		}
  	
  		if(str1 == str2) {
  			System.out.println("yes");
  		}else {
  			System.out.println("no");
  		}
  		
  		String str3 = new String("today");
  		
  		System.out.println("str3: " + str3);
  		
  		if(str1.equals(str3)) {
  			System.out.println("yes");
  		}else {
  			System.out.println("no");
  		}
  		// `==`은 메모리 주소를 비교하라는 부호이다.
  	}
  }
  ```

### 10. Infinity / NaN

* 정수를 0 으로 나누면 이론상 무한대 이지만 자바는 Exception 이 나타남.

* 그러나 여기서 0.0(double) 로 나누게 되면 다음과 같이 나타난다.

  ```java
  public class Op13 {
  	public static void main(String[] args) {
  		// NaN - Infinity
  		int a = 5;
  		int b = 0;
  
  		double c = 0.0;
  
  		System.out.println(b / a);
  
  		try {
  			System.out.println(a / b);
  		} catch (ArithmeticException e) {
  			e.printStackTrace();
  		}
  		
  		System.out.println(a / c); // Infinity
  		System.out.println(a % c); // NaN
  	}
  }
  ```

  ![image-20200722144100345](JavaDay02.assets/image-20200722144100345.png)

* 0.0 으로 나누면 Infinity가 나오게 되고, 나머지를 구하면 NaN(Not a number) 가 나오게 된다.

* Infinity 와 NaN 은 Double객체가 갖고있다.

  ```java
  double d = 5* a/c;
  		System.out.println(d);
  		
  		System.out.println(Double.isInfinite(d));
  		
  		if(Double.isFinite(d)) {
  			System.out.println(5*a/c);
  		}else {
  			System.out.println("무한대가 입력되어 처리할 수 없습니다.");
  		}
  ```

  ![image-20200722144523384](JavaDay02.assets/image-20200722144523384.png)











> 유용한 기능
>
> File Search
>
> Ctrl + h 를 누르면 프로젝트 내에서 찾고 싶은 단어를 찾아낼 수 있다.
>
> ![image-20200722133454859](JavaDay02.assets/image-20200722133454859.png)
>
> //TODO -> 할일을 기록 남기는 것. 
>
> Tasks 에서 확인 가능하다.
>
> ![image-20200722133418933](JavaDay02.assets/image-20200722133418933.png)
>
> ![image-20200722133438286](JavaDay02.assets/image-20200722133438286.png)



> 참고
>
> 부동소 수점 오류
>
> 다음 코드를 실행해보자.
>
> ```java
> 		int apple = 1; // 사과 1개
> 		double pieceUnit = 0.1; // 사과를 10개로 쪼갠 조각 중 1개
> 		
> 		int num = 7;
> 		double result = apple - pieceUnit*num;
> 		System.out.println(result);
> ```
>
> 사람이라면 단순에 1 - 0.1*7 로 계산하여 0.3이 나오는 것을 알 수 있으나 프로그램을 실행하게 되면..
>
> ![image-20200722133002005](JavaDay02.assets/image-20200722133002005.png)
>
> 같이 나온다..
>
> 그 이유는 **실수 변수는 절대 정확한 값을 가지고 있지 않다**는 것이다.
>
> 
>
> 모든 실수를 8byte, 혹은 12~16byte의 변수에 모두 담을 수 있다고 생각하시는 분은 없겠죠.
>
> 변수에 실수를 저장할 때는 어느 정도의 정보 손실이 일어날 수밖에 없습니다.
>
> 절대 잊어서는 안되는 것은, 실수 변수는 절대 정확한 값을 가지고 있지 않다는 것입니다.
>
> ## 1) 문제를 풀 때는 float보다는 double형 변수를 쓰는게 좋습니다.
>
> double형 변수까지는 하드웨어로 계산되기 때문에 많이 느려지지 않지만, 정확도가 엄청나게 높아지기 때문입니다.
>
> (float의 상대오차는 약 10^-7 정도이고, double의 상대 오차는 약 10^-15 정도입니다)
>
> long double (12bit 혹은 16bit)는 소프트웨어의 도움을 받기 때문에 꽤 많이 느려지기 때문에 쓴다고 꼭 좋은 것은 아닙니다.
>
> 
>
> ## 2) 정수가 들어있는 실수형 변수를 정수로 바로 캐스팅하면 안됩니다.
>
> 1을 double 변수에 대입하면 0.9999... 같은 이상한 숫자가 됩니다. 이 변수를 그대로 정수로 캐스팅한다면 0이 되겠죠.
>
> 보통의 경우에는 1e-6 ~ 1e-9 정도를 더해서 캐스팅을 하거나,
>
> 정수형 변수만을 사용하여 연산을 하기도 합니다.
>
> ( scanf("%d.%d")으로 입력을 받고, printf("%d.%02d", a/100, a%100)으로 출력하는 식으로.
>
> 반올림이 필요하다면 나머지 연산을 사용해야 합니다.)
>
> 
>
> ## 3) 비교 연산을 할 때는 등호를 사용하시면 안됩니다.
>
> 실수형 변수는 오차가 있기 때문에 같은 값을 가져야만 하는 상황에서도 다른 값일 때가 매우 많습니다.
>
> 보통의 경우에는 abs(A-B) < EPS, EPS는 1e-6~1e-9 정도로 정합니다.
>
> 
>
> ## 4) 큰 수를 다룰 때, 매우 작은 상수값을 사용하는 것은 위험할 수 있습니다.
>
> double형의 상대 오차는 10^-15입니다. 즉, 10^15를 double형 변수에 대입하면 오차가 1의 자리에서 발생할 수 있습니다.
>
> 즉, 조건문으로 (A-B) < 1e-6 을 사용했는데, A, B가 10^11 크기 정도라면,
>
> (A-B) < 1e-6과 A == B는 똑같은 결과를 만들게 됩니다.
>
> double형 변수를 가지고 넓은 범위의 이진탐색을 돌릴 때 자주 발생하는 문제이고,
>
> 100~200번 정도만 반복한다던가, 상대오차가 몇 이하일 때 반복문을 빠져나오는 식으로 해결합니다.
>
> 
>
> ## 5) 큰 수에 작은 수를 더할 때 조심해야 합니다.
>
> 예를 들어, 10^20 정도 되는 double형 변수에 1을 10^20번 더해도 값이 변하지 않습니다.
>
> 또는, 큰 수에 작은 수를 더할 때 작은 수의 정밀한 부분이 사라지기 때문에 오차가 커질 수 있습니다.
>
> 보통은 작은 수끼리 더한 뒤에 큰 수에 더하는 방법으로 해결이 가능하나,
>
> 이런 것 때문에 틀리는 문제는 극히 드뭅니다.
>
> 
>
> [출처-블로그](https://www.acmicpc.net/blog/view/37)

