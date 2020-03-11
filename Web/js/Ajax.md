# Ajax

---

- fetch API
  - asdf



* 예제

  ```html
  <!DOCTYPE html>
  <html lang="en">
  <head>
      <meta charset="UTF-8">
      <title>Title</title>
  </head>
  <body>
  <article>
  
  </article>
  <input type="button" value="fetch" onclick="
      fetch('html').then(function(response){
          response.text().then(function(text){
               document.querySelector('article').innerHTML=text;
              })
          })
      ">
  </body>
  </html>
  ```

* 결과

  * 클릭전

    ![image-20200311171121662](C:%5CUsers%5Cstudent%5CAppData%5CRoaming%5CTypora%5Ctypora-user-images%5Cimage-20200311171121662.png)

  * 클릭후

    ![image-20200311171135778](C:%5CUsers%5Cstudent%5CAppData%5CRoaming%5CTypora%5Ctypora-user-images%5Cimage-20200311171135778.png)

* `fetch()` : 인자로 받은 데이터를 서버에게 요청하는 파일.
* `then()` : 서버가 적당한 데이터를 받아서 응답해 줘야 하는데 많은 시간이 걸릴경우 응답까지 기다리지 않게 해주는 기능. 응답이 끝나면 `()` 안에 javaScript 문장을 수행하게 됨. 