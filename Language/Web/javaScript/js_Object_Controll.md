# Javascript

## 반복문

* 여러 종류의 for 문

  ```javascript
   var city = ['서울','대구','대전','부산'];
          
          for( var i in city){
              console.log(i); // index 출력
          }
          console.log('-------------')
          for (var i of city){
               console.log(i); // 값을 출력 
          }
          console.log('-------------')
          city.forEach(function(v,i,a){
              console.log(v);// value 출력 
              console.log(i);// index  출력
              console.log(a);// array 출력
              
          });
              
  ```

  ![스크린샷 2020-09-07 오전 10.42.16](js_Object_Controll.assets/스크린샷 2020-09-07 오전 10.42.16.png)

## map

* 값들을 확인해서 반환. (숫자타입 or 문자 등)

  ```javascript
  var data = ['javascript',20,30,'jquery'];
  var num = data.filter(function(v){
              return typeof v === 'number';
          });
  console.log(num);
  ```

  ![스크린샷 2020-09-07 오전 11.01.58](js_Object_Controll.assets/스크린샷 2020-09-07 오전 11.01.58.png)





# Event

* click
* mouseOver = hover



## keyEvent

* keydown
* keyup
* focus
* blur : 포커스 아웃
* change : 값이 변경되었을 때
* submit: form에 기입된 내용을 전송

## Load event

* window.load
* window.reSize
* scroll : 무한 스크롤



이벤트 연결

* 인라인 이벤트 : 이벤트 앞에 on붙임.
* 기본 이벤트 



# 함수

* 이벤트함수에 함수를 넣어줄때 괄호를 넣지 않는다.
* 괄호를 넣게 되면 이벤트가 한번은 자동으로 실행된다. (즉시실행함수)





 