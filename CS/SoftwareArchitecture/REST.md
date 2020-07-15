# REST

## 1. 정의

> REST ( Representational state Transfer)
>
> 월드 와이드 웹과 같은 분산 하이퍼미디어 시스템을 위한 소프트웨어 아키텍처의 한 형식이다.

## 2. 구성요소

1. 자원 (Resource) : `URL`
   * 모든 자원에는 고유한 ID가 존재하고, 이 자원은 Server에 존재한다.
   * 자원을 구별하는 ID는 HTTP URL로 구분하게 된다. `EX) /members/1`
   * Client는 URL을 이용하여 자원을 지정하고 해당 자원에 대한 조작을 Server에 요청한다.
2. 행위 (Verb) : `HTTP Method`
   * Client는 HTTP Method (POST, GET, DELETE, PUT) 를 이용하여 지정한 자원에 대한 조작을 요청한다.
3. 표현 (Representation of Resource)
   * Client 가 Server에 자원에 대한 조작을 요청하면 Server는 이에 대한 적절한 응답(Representaion)을 보낸다.



## 3. 특징

### 1. Uniform(유니폼 인터페이스)

   > Uniform Interface는 Http 표준에만 따른다면 모든 플랫폼에서 사용이 가능하며, URI로 지정한 리소스에 대한 조작을 가능하게 하는 아키텍처 스타일을 말한다.

   Uniform Interface는 Client 가 지정한 리소스에 대한 조작을 통일되고 한정적인 인터페이스로 수행하는 아키텍처 스타일을 의미한다.

   여기서 말하는 한정적인 인터페이스를 예로 들면 일반적인 params를 사용한 URL의 경우 `url.com/exam?auth=admin` 와 같이 사용하지만 한정적인 인터페이스를 사용할 경우 `url.com/exam` 이라는 URL로 간편하게 사용할 수 있다.

| params 를 사용한 URL          | `url.com/exam?auth=admin` |
| ----------------------------- | ------------------------- |
| **한정적인 인터페이스의 URL** | **`url.com/exam`**        |

   params를 이용하여 URL을 구성할 경우, `velog.io/@chk610?auth=admin` 이 URL로 관리자 페이지 resource에는 접근하긴 했는데 얘를 어찌 할 것인지를 또 params로 넘겨주던가 해야 한다.

   이에 반해, 한정적인 인터페이스를 사용하면 HTTPS Method를 사용하면 되니까 관리자 페이지를 조회할 경우에는 `GET velog.io/@chk610/admin`, 수정할 경우에는 `PUT velog.io/@chk610/admin`과 같이 간편하게 나타낼 수 있다.

   **이런 한정적인 인터페이스를 사용하게 되면 URL 길이가 짧아질 뿐만 아니라 하나의 URL을 이용하여 많은 representation을 지정할 수 있는 장점이 있다.**

### 2. Stateless (무상태성)

   > REST는 무상태성 성격을 갖는다. 다시 말해 작업을 위한 상태정보를 따로 저장하고 관리하지 않는다. 세션 정보나 쿠키정보를 별도로 저장하고 관리하지 않기 때문에 API 서버는 들어오는 요청만을 단순히 처리하면 된다. 때문에 서비스의 자유도가 높아지고 서버에서 불필요한 정보를 관리하지 않음으로써 구현이 단순해진다.

### 3. Cacheable (캐시 가능)

   > REST의 가장 큰 특징 중 하나는 HTTP라는 기존 웹표준을 그대로 사용하기 때문에, 웹에서 사용하는 기존 인프라를 그대로 활용이 가능하다. 따라서 HTTP가 가진 캐싱 기능이 적용 가능하다. HTTP 프로토콜 표준에서 사용하는 Last-Modified태그나 E-Tag를 이용하면 캐싱 구현이 가능하다.

### 4. Self-descriptiveness (자체 표현 구조)

   > REST의 또 다른 큰 특징 중 하나는 REST API 메시지만 보고도 이를 쉽게 이해 할 수 있는 자체 표현 구조로 되어 있다는 것이다.

URL의 구성만 보고도 해당하는 것이 어디에 속한 것인지 알 수 있다!

`velog.io/@chk610/prodct/food/salad`의 경우 salad가 food 이고 product에 속한 것을 알 수 있다.

### 5. Client - Server 구조

   > REST 서버는 API 제공, 클라이언트는 사용자 인증이나 컨텍스트(세션, 로그인 정보)등을 직접 관리하는 구조로 각각의 역할이 확실히 구분되기 때문에 클라이언트와 서버에서 개발해야 할 내용이 명확해지고 서로간 의존성이 줄어들게 된다.

### 6. 계층형 구조

   > REST 서버는 다중 계층으로 구성될 수 있으며 보안, 로드 밸런싱, 암호화 계층을 추가해 구조상의 유연성을 둘 수 있고 PROXY, 게이트웨이 같은 네트워크 기반의 중간매체를 사용할 수 있게 한다.

## 4. REST API

* REST 기반으로 서비스 API를 구현한 것.
* OpenAPI(누구나 사용할 수 있또록 공개된 API: 구글맵, 공공 데이터 등), 마이크로 서비스(하나의 큰 애플리케이션을 여러 개의 작은 애플리케이션으로 쪼개어 변경과 조합이 가능하도록 만든 아키텍처) 등을 제공하는 업체 대부분은 REST API 를 제공한다.

### 특징

* 사내 시스템들도 REST 기반으로 시스템을 분산해 확장성과 재사용성을 높여 유지보수 및 운용을 편리하게 할 수 있다.
* REST HTTP 표준을 기반으로 구현하므로, HTTP를 지원하는 프로그램 언어로 클라이언트, 서버를 구현할 수 있다.
* REST API를 제작하면 델파이 클라이언트 뿐 아니라, 자바, C#, 웹 등을 이용해 클라이언트를 제작할 수 있다.

### REST API 디자인 가이드

* 설계 시 중요한 항목 2가지!

  1. URI 는 정보의 자원을 표현해야 한다.
  2. 자원에 대한 행위는 HTTP Method (GET,POST,PUT,DELETE)로 표현한다.

  이 두가지는 꼭 기억하는 것이 좋다!

#### REST API 설계 기본 규칙

1. URI는 정보의 자원을 표현해야 한다. (리소스명은 동사보다는 명사를 사용하기!)

   `GET /members/delete/1`

   위와 같은 방식은 REST를 제대로 적용하지 않은 URI이다. URI는 자원을 표현하는데 중점을 두어야한다. delete와 같은 행위에 대한 표현이 들어가서는 안된다.

2. 자원에 대한 행위는 HTTP Method (GET, POST, PUT, DELETE 등)로 표현한다.

   위의 잘못된 URI를 HTTP Method를 통해 수정해보면 아래와 같다.

   `DELETE /members/1`

   위와 같이 회원정보를 가져올 때는 GET, 회원 추가시의 행위를 표현하고자 할 때는 POST Method를 사용하여 표현한다.

   > 회원정보 가져오는 URI
   >
   > * `GET /members/show/1` (x)
   > * `GET /members/1` (o)
   >
   > 회원을 추가할 때
   >
   > * `GET /members/insert/2` (x)
   > * `POST /members/2` (o)

   > HTTP Method
   >
   > | METHOD |                             역할                             |
   > | :----: | :----------------------------------------------------------: |
   > |  POST  |     POST를 통해 해당 URI를 요청하면 리소스를 생성합니다.     |
   > |  GET   | GET를 통해 해당 리소스를 조회합니다. 리소스를 조회하고 해당 도큐먼트에 대한 자세한 정보를 가져온다. |
   > |  PUT   |             PUT를 통해 해당 리소스를 수정합니다.             |
   > | DELETE |              DELETE를 통해 리소스를 삭제합니다.              |

#### URI 설계 시 주의할 점

1. 슬래시 구분자 `(/)` 는 계층 관계를 나타내는데 사용한다.

   ```
   http://restapi.example.com/houses/apartments
   http://restapi.example.com/animals/mammals/whales
   ```

   

2. URI 마지막 분자로 슬래시`(/)`를 포함하지 않는다.

   URI에 포함되는 모든 문자는 리소스의 유일한 식별자로 사용되어야 하며, URI가 다르다는 것은 리소스가 다르다는 의미이다. 역으로 리소스가 다르면 URI도 달라져야 한다. REST API는 분명한 URI를 만들어 통신을 해야 하기 때문에 혼동을 주지 않도록 URI 경로의 마지막에는 `/`를 사용하지 않는다.

   ```
   http://restapi.example.com/houses/apartments/ (X)
   http://restapi.example.com/houses/apartments  (0)
   ```

3. 하이픈(`-`)은 URI 가독성을 높이는데 사용한다.

   URI를 쉽게 읽고 해석하기 위해, 불가피하게 긴 URI경로를 사용하게 되면 하이픈을 사용해 가독성을 높일 수 있다.

4. 밑줄 (`_`)은 URI에 사용하지 않는다.

   글꼴에 따라 다르긴 하나 밑줄은 보기 어렵거나 밑줄 때문에 문자가 가려지기도 한다. 이런 문제를 피하기 위해 밑줄 대신 하이픈(`-`)을 사용하는 것이 좋다. (가독성)

5. URI 경로에는 소문자가 적합하다.

   URI 경로에 대문자 사용은 피하도록 하자. 대소문자에 따라 다른 리소스로 인식하게 되기 때문이다. `3986(URI 문법 형식)`은 URI 스키마와 호스트를 제외하고는 대소문자를 구별하도록 규정되어있기 때문이다.

   ```
   RFC 3986 is the URI (Unified Resource Identifier) Syntax document
   ```

6. 파일 확장자는 URI에 포함시키지 않는다.

   ```
   http://restapi.example.com/members/soccer/345/photo.jpg (X)
   ```

   REST API에서는 메세지 바디 내용의 포맷을 나타내기 위한 파일 확장자를 URI안에 포함시키지 않는다. Accept header 를 사용하도록 하자.

   ```
   GET / members/soccer/345/photo HTTP/1.1 Host: restapi.example.com Accept: image/jpg
   ```

#### 리소스 간의 관계를 표현하는 방법

* REST 리소스간에는 연간 관계가 있을 수 있고, 이런 경우 다음과 같은 방법으로 표현한다.

``` 
	/리소스명/리소스ID/관계가 있는 다른 리소스명
	ex) GET : /users/{userid}/devices (일반적으로 소유 'has'의 관계를 표현할 때)
```

#### 자원을 표현하는 Collection과 Document

* Collection 과 Document 에 대해 알면 URI 설계가 한층 쉬워진다. Document는 단순히 문서로 이해해도 되고, 한 객체로 이해해도 된다. Collection은 문서들의 집합, 객체들의 집합이라고 생각하면 편하다. Collection 과 Document 모두 리소스라고 표현할 수 있으며 URI에 표현된다.

  ```
  http:// restapi.example.com/sports/soccer
  ```

  위 URI를 보면 sports라는 Collection과 soccer라는 Document로 표현되고 있다고 생각하면 된다. 더 자세한 예시를 보자

  ```
  http:// restapi.example.com/sports/soccer/players/13
  ```

  위는 sports, players Collection과 soccer, 13(13번 선수)를 의미하는 Document로 URI가 이루어지게 된다. 여기서 중요한 점은 **Collection은 복수**로 사용하고 있다는 점이다. 좀 더 직관적으로 REST API를 위해서는 Collection 과 Document를 사용할 때 단수 복수도 지켜준다면 좀 더 이해하기 쉬운 URI를 설계할 수 있다.

## 5. RESTful

* RESTful은 일반적으로 REST라는 아키텍처를 구현하는 웹 서비스를 나타내기 위해 사용되는 용어이다.

  REST API를 제공하는 웹 서비스를 RESTful하다고 할 수 있다.

* RESTful은 REST를 REST 답게 쓰기 위한 방법으로, 누군가가 공식적으로 발표한 것은 아니다.

  즉, REST 원리를 따르는 시스템은 RESTful이란 용어로 지칭된다.

### 목적

* 이하기 쉽고 사용하기 쉬운 REST API를 만드는 것!
* RESTful 한 API를 구현하는 근본적인 목적은 성능 향상에 있는 것이 아니라 일관적인 컨벤션을 통한 API의 이해도 및 호환성을 높이는 것이 주 동기이기 때문에, 성능이 중요한 상황에서는 굳이 RESTful 한 API를 구현할 필요는 없다.

### RESTful 하지 못한 경우 (예시)

* CRUD 기능을 모두 POST로만 처리하는 API
* route에 resource, id외의 정보가 들어가는 경우 `(/studentsupdateName)`



## 6. HTTP 응답 상태 코드

* 마지막으로 REST에서 사용되기도 하는 HTTP 응답 상태코드를 간단히 살펴보자. 
* 잘 설계된 REST API는 URI만 잘 설계된 것이 아닌 그 리소스에 대한 응답을 잘 내어주는 것까지 포함되어야 한다. 
* 정확한 응답의 상태코드만으로도 많은 정보를 전달할 수가 있기 때문에 응답의 상태코드 값을 명확히 돌려주는 것은 생각보다 중요한 일이 될 수 있다.

| 코드    | 의미                 |
| ------- | -------------------- |
| 100번때 | 정보응답             |
| 200번때 | 성공응답             |
| 300번때 | 리다이렉션 메시지    |
| 400번때 | 클라이언트 에러 응답 |
| 500번때 | 서버 에러 응답       |



| 상태코드 |                                                              |
| -------- | ------------------------------------------------------------ |
| 200      | 클라이언트의 요청을 정상적으로 수행함                        |
| 201      | 클라이언트가 어떠한 리소스 생성을 요청, 해당 리소스가 성공적으로 생성됨(POST를 통한 리소스 생성 작업 시) |
| 400      | 클라이언트의 요청이 부적절한 경우 사용하는 응답 코드         |
| 401      | 클라이언트가 인증되지 않은 상태에서 보호된 리소스를 요청했을 때 사용하는 응답 코드 |
|          | (로그인 하지 않은 유저가 로그인 했을 때에만 요청 가능한 리소스를 요청했을 때) |
| 403      | 유저 인증상태와 관계 없이 응답하고 싶지 않은 리소스를 클라이언트가 요청했을 때 사용하는 응답 코드 |
|          | (403 보다는 400이나 404를 사용할 것을 권고. 403 자체가 리소스가 존재한다는 뜻을 내포하기 때문임) |
| 405      | 클라이언트가 요청한 리소스에서는 사용 불가능한 Method를 이용했을 경우 사용하는 응답 코드 |
| 301      | 클라이언트가 요청한 리소스에 대한 URL이 변경됐을 때 사용하는 응답 코드 |
|          | (응답 시 Location header에 변경된 URL을 적어 줘야 함)        |
| 500      | 서버에 문제가 있을 경우 사용하는 응답 코드                   |

[추가적인 HTTP 응답 Reference site](https://developer.mozilla.org/ko/docs/Web/HTTP/Status)

---

### Reference

[https://medium.com/](https://medium.com/@hckcksrl/rest란-c602c3324196)

https://gmlwjd9405.github.io/2018/09/21

https://meetup.toast.com/posts/92

[https://velog.io/@kjh107704/REST-REST-API](https://velog.io/@kjh107704/REST-서버-REST-API란)

[https://velog.io/@wlsdud2194/HTTP-REST-API](https://velog.io/@wlsdud2194/HTTP-REST-API-란)

[http://blog.wishket.com/soap-api-vs-rest-api](http://blog.wishket.com/soap-api-vs-rest-api-두-방식의-가장-큰-차이점은/)

[https://developer.mozilla.org/ko/docs/Web/HTTP/Status](https://developer.mozilla.org/ko/docs/Web/HTTP/Status)