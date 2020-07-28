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

  