# Function

## 함수이용

* 반환값은 변수에 담아서 사용.

* 반환값이 없을때는 바로 호출해서 사용.

* 입력값이 없는 함수는 매개변수 없이 사용.

  ```kotlin
  fun main(){
  
      var squareResult = square(30)
      println("30의 제곱근은 $squareResult 입니다.")
  
      printSum(3,5)
  
      var PI = getPi()
      println("PI 값은 $PI 입니다.")
  }
  
  fun getPi(): Any {
      return Math.PI
  }
  ```

  ![image-20200805230226205](/Users/choehyegeun/Library/Application Support/typora-user-images/image-20200805230226205.png)

