# JavaDay10

## 제네릭

* 클래스 정의하기

  ```java
  pubic class GenericPrinter<T>{
      private T material;
  
  
    public void setMaterial(T material){
      this.material = material;
    }
  
    public T getMaterial(){
      return material;
    }
  }
  ```

* 다이아몬드 연산자 `<>`

  * 선언된 자료형을 보고 생략된 부분을 알아서 컴파일러가 유추해낸다.
  * 

