# Kotlin

## 맨땅에 해딩하기.

## Day 01

참고 문헌 - [Kotlin_docs](https://kotlinlang.org/docs/reference/basic-syntax.html)

* 기본적으로 kotlin은 세미콜론 (`;`)을 작성하지 않는다.

* Kotlin에서의 메인문 `(Program entry point)`

  * fun 을 이용하여 함수를 구현

  * 콘솔 디버깅을 위해 사용하는 함수

    ```kotlin
    fun main(){
      // java에서의 main thread 와 같은 문맥
      // Debug 시 해당 블록을 실행한다.
    }
    ```

* Hello world!

  ```kotlin
  fun main(){
    println("Hello, World!")
  }
  ```

  ![image-20200728215730260](/Users/choehyegeun/Library/Application Support/typora-user-images/image-20200728215730260.png)

### 함수 구현

* Kotlin 에서 함수는 다음과 같은 포멧으로 선언이 가능하다

* `fun 함수명(변수:타입, 변수:타입,....):함수반환타입{...}`

* Ex) Int 형 변수 두개를 받아 더하는 값을 반환하는 함수

  ```kotlin
  fun sum(a:Int, b:Int):Int{
    return a+b
  }
  ```

* 함수를 구현과 동시에 선언가능. 

  * 대입연산자(`=`) 를 이용. 이때 함수의 리턴타입은 생략!

  ```kotlin
  fun sum(a:Int,b:Int) = a+b
  ```

* 반환 타입이 없을때!

  1. 반환 타입을 Unit 으로 작성

  ```kotlin
  fun printSum(a: Int, b: Int): Unit {
      println("sum of $a and $b is ${a + b}")
  }
  // 문자열 에서 변수를 사용할때 &변수 로 사용. 함수는 ${함수} 로 사용가능!
  ```

  2. 또는 그냥 생략!

  ```kotlin
  fun printSum(a:Int,b:Int){
    println("sum of $a and $b is ${a + b}")
  }
  ```

### 변수

* 변수는 기본적으로 val 와 var가 있다



1. val : 로컬변수, 처음 선언한 후 변경이 불가능하다. (자바에서 final 과 같은 의미)

   >  docs 에서의 val 정의 : Read-only local variables are defined using the keyword val. They can be assigned a value only once.

   

   ```kotlin
   val a: Int = 1  // immediate assignment
   val b = 2   // `Int` type is inferred
   val c: Int  // Type required when no initializer is provided
   c = 3       // deferred assignment
   ```

   ![스크린샷 2020-07-28 오후 10.32.25](KotlinDay01.assets/스크린샷 2020-07-28 오후 10.32.25.png)

   

2. var : 일반적인 변수.

   > Variables that can be reassigned use the `var` keyword

   

   ```kotlin
   var x = 5 // `Int` type is inferred
   x += 1
   ```

### 조건문

* Java 와 동일하게 if, else, else if를 사용!

  ```kotlin
  fun maxOf(a: Int, b: Int): Int {
      if (a > b) {
          return a
      }else if(a==b){
          return 0
      }else{
          return b
      }
  }
  ```

* 위의 함수를 한줄로 선언 가능!

  ```kotlin
  fun maxOf(a:Int,b:Int) = if(a>b) a else if(a<b) b else 0
  ```

  