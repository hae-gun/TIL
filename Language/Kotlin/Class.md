# Class

## 기본구조

```kotlin
class 클래스명{
  var 변수
  fun 함수(){
    //코드
  }
}
```





## 프라이머리 생성자

* 클래스명 옆 함수의 파라미터처럼 사용하여 생성자를 정의할 수 있다.

  ```kotlin
  class myClass(name:String, age:Int){
    
  }
  ```

* 해당 파라미터를 필드변수에 저장하고 싶으면 아래와 같이 작성한다.

  ```kotlin
  class myClass(name:String, age:Int){
    var name = name
    var age = age
  }
  ```



## data Class

* data class 는 자동으로 getter/setter 와 toString() 매서드를 갖는 형태로 클래스를 만들어 준다.

  ```kotlin
  data class myDataClass(var name:String,var age:Int ){
      override fun toString(): String {
          return "이름은 $name 이요 나이는 $age 올시다."
      }
  }
  ```

  