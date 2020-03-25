# Kotlin

> Kotlin은 기본적으로 문장 끝에 `;`를 작성하지 않아도 됨.
>
> 목차
>
> 1. [변수선언](#변수선언)
>
> 
>
> 





## 1.변수선언

1. var : 변경가능.
2. val : 변경불가능.
   1. Property : 클래스에 선언
   2. Local Vaiable : 스코프 내에 선언

* 코틀린은 기본변수에 null을 허용하지 않음.
* 변수에 값을 할당하지 않은채로 사용하면 문법 오류를 표시하여 컴파일을 차단함.
* `'?' 를 이용하면 null 부여 가능.:nullable 변수 주의해서 사용.`

```kotlin
val a: Int? = null
```

## 2.기본 자료형

1. 자바와 동일.
2. 10,16,2진수로 표현
   * 10진수가 기본형
   * Long타입은 숫자뒤에 L붙임
   * 16진수 : 0x 숫자앞에 붙이기
   * 2진수 : 0b 숫자앞에붙이기.
   * 8진수는 지원 안함
3. 실수는 기본이 Double형.
   * .숫자 또는 지수표기법 e10
4. float형은 숫자뒤 f
5. Char 형 : 기본 UTF-16BE
   * 문자하나 작은 따음표 `''`로 
   * 특수문자 지원
6. Boolean값 : true, false 직접 표기.
7. 문자열 : val 변수명 = "문자열"
   * 여러줄 문자열 사용시 `"""`큰 따음표 3개 표시로 줄바꿈 특수문자까지 그대로 문자열로 사용가능하다.

## 2. 형변환과 배열

1. 형변환 : 하나의 변수에 지정된 자료형을 호환되는 다른 자료형으로 변경하는 기능.

   1. 논리형은 변환할 수 없음.

   2. 기본 자료형들 형변환 함수가 존재함.

   3. to자료형()

   4. 명시적 형변환

      ```kotlin
      val a: Int = 123
      val c: long = a.toLong()
      ```

   5. 암시적 형변환은 지원하지 않는다. (자동 형변환)

2. 배열:내부적 Array<T> 로 지원

   1. 기본적인 배열은 `arrayOf()`로 지원

   2. 비어있는 배열 생성시 `arrayOfNulls<>()` 로 지원가능.

      1. `<>` 안에는 배열에 넣을 자료형을 넣는다. `제너릭`

      ```kotlin
      val intArr = arrayOf(1,2,3,4)
      var nullArr = arrayOfNull<Int>(5)
      ```

      

   3. 배열 이름뒤 대괄호를 넣어 참조할 인덱스를 넣으면 참조가능.

   4. 전체크기 변경 불가능함

   5. 다른 자료구조보다 빠른 입출력이 가능하다.

## 3. 타입 추론과 함수

1. 타입추론 

   * 변수나 함수들을 선언할 때나 연산이 이뤄질때 자료형을 부여 하지 않아도 자동으로 부여해주는 기능.

   * 자료형을 생략하고 작성해 주어도 변수가 선언될때 부여된 값의 형태로 해당 변수가 어떤 자료형을 가지는지 추론이 가능하기 때문이다.
   * 기본 자료형들도 선언시 값만 할당하면 자료형 명시할 필요가 없다.

   > 일반 정수형 : Int
   >
   > 숫자뒤L 표시 : Long
   >
   > 일반실수 : Double
   >
   > f붙은 실수형 : Float
   >
   > 0x : 16진수
   >
   > 0b : 2진수
   >
   > Boolean과 Char 형도 자료형 없이 추론 가능하다.

2. 함수

   1. 특정한 동작을 하거나 원하는 결과값을 연산하는데 사용.
   2. `fun` 으로 시작하여 선언.
   3. `()` 안에 받을 파라미터를 값의 자료형을 함께 표시
   4. 괄호를 닫고 `:` 뒤에 반환하는 값의 자료형을 써준다.
   5. return 을 통해 반환값을 지정.

   ```kotlin
   fun add(a:Int,b:Int,c:Int):Int{
       return a+b+c
   }
   ```

   5. 단일표현식 함수

      * 변수에 값을 할당하듯 함수를 표현할수 있다.
      * 반환형의 타입추론이 가능하여 작성하지 않아도 됨.
      * 자료형이 결정된 변수라는 개념으로 접근이 가능하다.

      ```kotlin
      fun add(a:Int,b:Int,c:Int) = a+b+c
      ```

## 4. 조건문과 비교연산자

1. 조건문 : if문

   * 구조

   ```kotlin
   fun main(){
       var a = 7
       if(a>10){
           println("10보다 크다.")
       }else{
           println("10보다 작다.")
       }
   }
   ```

   * 비교연산자
     * 부등호 : `< , <= , > , >=`
     * 등호 : `==`
     * 자료형체크 : `is, !is`
       * is 연산자는 자료형 체크와 동시에 자동으로 형변환도 이루어 진다. (???)

2. 다주오건문 : when

   * 구조

   ```kotlin
   fun main(){
       doWhen(1)
       doWhen("test")
       doWhen(1123L)
       doWhen(123)
       doWhen("true")
   
   }
   fun doWhen(a: Any){
       when(a){
           1 -> println("정수 1입니다.")
           "test" -> println("test문자열 입니다.")
           is Long -> println("Long 타입입니다.")
           !is String -> println("String 타입이 아닙니다.")
           else -> println("어떤 조건도 맞지 않습니다.")
       }
   }
   ```

   * 결과

     ![image-20200307200909065](C:\Users\newch\AppData\Roaming\Typora\typora-user-images\image-20200307200909065.png)

   * 등호나 부등호는 사용이 불가능 하다.

   * 여러개의 조건이 맞을 경우 먼저 부합하는 조건이 실행된다.

   * 표현식으로 나타내기

     ```kotlin
     fun main(){
         doWhen(1)
         doWhen("test")
         doWhen(1123L)
         doWhen(123)
         doWhen("true")
     
     }
     fun doWhen(a: Any){
         var result = when(a){
             1 -> "정수 1입니다."
             "test" -> "test문자열 입니다."
             is Long -> "Long 타입입니다."
             !is String -> "String 타입이 아닙니다."
             else -> "어떤 조건도 맞지 않습니다."
         }
         println(result)
     }
     ```

     

## 5.

