# Spring Web layer

1. Web Layer
   * 흔히 사용하는 컨트롤러(`@Controller`)와 JSP/Freemarker 등의 뷰 템플릿 영역이다.
   * 이외에도 필터(`@Filter`), 인터셉터, 컨트롤러 어드바이스(`@ControllerAdvice`)등 외부 요청과 응답에 대한 전반적인 영역을 이야기한다.
2. Service Layer
   * `@Service`에 사용되는 서비스 영역이다.
   * 일반적으로 `Contoller` 와 `Dao` 의 중간 영역에서 사용된다.
   * `@Transactional` 이 사용되어야 하는 영역이다.
3. Repository Layer
   * Database와 같이 데이터 저장소에 접근하는 영역이다.
   * 기존의 Dao 영역으로 이해하면 편함.
4. Dtos
   * Dto(Data Transfer Object)는 계층 간에 데이터 교환을 위한 객체를 이야기하며 Dtos는 이들의 영역을 얘기함.
   * 뷰 템플릿 엔진에서 사용될 객체나 Repository Layer 에서 결과로 넘겨준 객체 등이 이들을 이야기한다.
5. Domain Model
   * 도메인이라 불리는 개발 대상을 모든 사람이 동일한 관점에서 이해할 수 있고 공유할수 있도록 단순화시킨 것을 도메인 모델이라고 한다.
   * @Entity가 사용된 영역 역시 도메인 모델이라고 할 수 있다.
   * 무조건 데이터베이스의 테이블과 관계 있어야 하는 것은 아님.
   * VO처럼 값 객체들도 이 영역에 해당함.