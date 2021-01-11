# TDD 스터디

## 1. TDD란?

테스트 코드 작성??? 놉!

테스트를 먼저 작성하라!

최초에는 테스트 우선 개발로 불렸다.

Test First Develop

# 2. TDD가 필요한 이유

잘 동작하는 깔끔한 코드가 필요하기 때문이다.

Clean code that works : 미래의 고통을 현재로 가져온다.

결함은 일찍 찾을 수록 고치는 비용이 적게 든다.

# 3. TDD 진행과정

1. 질문 (실패)
2. 응답 (성공)
3. 리팩토링
4. 반복





# 2 JUnit

3개의 패키지로 되어있다.

1. Junit Platform
2. Junit Jupiter -> 엔진으로 넘어가서 축소됨.
3. Junit Vintage



자바 1.8이상 사용하기. (람다식을 사용하기 때문)



JUnit4 파일 JUnit5 로 실행가능.

Spring-boot-starter-test

Boot 2.22.0 이상부터 사용가능하다.



Run tests 환경을 Intellij 환경으로 설정해야 실행이 빠르다.

환경

@beforeAll

@before

...



assertEquals -> null null도 테스트가 성공함.

파라미터 3개로 오차범위 설정이 가능하다.

assertTrue :같냐 다르냐 테스트 설정.

assertNull : null 확인

assertSame : 두 객체가 같냐 확인. 인스턴스 비교. (==으로 비교한다.)

assertArrayEquals : 배열의 개수 및 정렬 순서도 맞아야 True이다.

assertThrows : 강제로 예외를 발생시켜 예외가 발생했을때 어떤 예외를 만드는지 확인.

assertAll : 여러 테스트를 모아서 할수있다. 함수형 인터페이스로 되어있어 람다표현식으로 사용이 가능하다. 

실행하는 인터페이스는 Executable??(Expectable)로 실행되서 중간에 실패해도 계속 진행한다. 



어노테이션

@Disabled : 테스트 사용안함.(빌드시 사용 안됨.) JUnit4 : @Ignored

@DisplayName : 테스트가 어디서 사용됬는지 명시하기 위함.

@Order : 테스트 순서를 정함. 값은 Integer값으로 비교하게 된다. 

@Nested :  중첩 테스트를 사용하면 상황이나 실행 부분을 별도 클래스로 분리해서 구현할 수 있다. 테스트 코드 구조를 관리하는데 도움된다.

@Tag :원하는 테스트를 그룹을 지워주어 사용할 수 있다. : 사용할 테그 이름을 gradle에서 설정이 가능하다.

@Hamcrest : assertEquals, assertThat 의 차이를 볼수 있다.



## Hamcrest

쓸때마다 Docs에서 찾아봐.......

그나마 쓸만한것

TypeSafeMatcher<T>

재정의 메소드 2개

matchesSafely 

describeTo

...

assertAll과는 달리 assertThat 은 중간에 실패해도 진행

assertThat에서는 allOf/anyOf로 설정이 가능함.





추후 다시 정리..

.....