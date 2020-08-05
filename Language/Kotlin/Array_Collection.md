# Kotlin

## Array & Collection

### Array

```kotlin
fun main(){
  var students = IntArray(10)
  var longArray = LongArray(10)
  
  var CharArray = CharArray(10)

   for(i in CharArray.indices){
       CharArray[i] = 'a'+i
   }
    println(CharArray)
}
```

![스크린샷 2020-08-05 오후 9.47.50](Array_Collection.assets/스크린샷 2020-08-05 오후 9.47.50.png)

* 문자 배열에 빈 공간 할당하기

  ```kotlin
  var stringArray = Array(10, {item->""})
  ```

* 문자 배열에 같은문자로 배열 초기화

  ```kotlin
  var stringArray = Array(10, {item->"a"})
      for(x in stringArray.indices){
          println(stringArray[x])
      }
  ```

  ![스크린샷 2020-08-05 오후 9.59.03](Array_Collection.assets/스크린샷 2020-08-05 오후 9.59.03.png)

* 배열에 값넣기
  * 배열명 [ 인덱스 ] = 값
  * 배열명.set ( 인덱스 , 값)
* 배열 값 가져오기
  * 배열명 [ 인덱스 ]
  * 배열명.get( 인덱스 )



### Collection

#### List

```kotlin
var list = mutableListOf("mon","tue",'wed')
```

* 중복값 입력 가능.
* 동적 리스트(컬랙션) 이용시 mutable 접두어 붙은 함수 사용.



* 리스트에 값 넣기 : 변수.add(값)
* 리스트 값 가져오기 : 변수.get(인덱스)
* 리스트 값 수정하기 : 변수.set(인덱스, 값)
* 리스트 값 제거 : 변수.removeAt(인덱스)

```kotlin
    var mutableList = mutableListOf("MON","TUE","WED","FRI")
    println(mutableList)

    mutableList.add("SUN")
    println(mutableList)

    println("가져온 값: ${mutableList.get(0)}")

    mutableList.set(1,"TTT")
    println(mutableList)

    mutableList.removeAt(mutableList.size-1)
    println(mutableList)
```

![image-20200805221257940](Array_Collection.assets/image-20200805221257940.png)