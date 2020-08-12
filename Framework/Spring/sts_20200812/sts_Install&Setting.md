# Spring Tool Suite 설정

참고자료 - 코드로 배우는 스프링 웹 프로젝트 - 이하 `코배웹`

## macOS tomcat 설치

* `Homebrew` 를 이용하여 터미널에서 tomcat을 설치 할 수 있다.

* 먼저 brew 를 최신버전으로 업데이트 해준다

  ![스크린샷 2020-08-12 오후 9.03.04](sts_Install.assets/스크린샷 2020-08-12 오후 9.03.04.png)

  

* 업데이트가 완료되면 tomcat을 search 한다.

  ![image-20200812210436747](sts_Install&Setting.assets/image-20200812210436747.png)
  
* tomcat 9 버전 사용을 위해 tomcaat을 install 시킨다

  ![image-20200812210659309](sts_Install&Setting.assets/image-20200812210659309.png)

* 설치완료

  ![image-20200812211120827](sts_Install&Setting.assets/image-20200812211120827.png)

> tomcat 설치경로
>
> /usr/local/Cellar/
>
> 폴더에 tomcat 이름으로 설치됨.
>
> ![image-20200812211310830](sts_Install&Setting.assets/image-20200812211310830.png)

## tomcat 실행방법

* 아래 해당 경로로 들어간다

  ![image-20200812211433355](sts_Install&Setting.assets/image-20200812211433355.png)

* `./catalina start` 명령어를 이용하여 톰캣을 실행할 수 있다.

  ![image-20200812211532640](sts_Install&Setting.assets/image-20200812211532640.png)

* 실행후 웹에서 `http://localhost:8080` 을 접속하여 확인이가능하다.

  ![image-20200812211631453](sts_Install&Setting.assets/image-20200812211631453.png)

* 종료는 당연히 `./catalina stop` 명령어로 종료가 가능하다.

  ![스크린샷 2020-08-12 오후 9.17.26](sts_Install&Setting.assets/스크린샷 2020-08-12 오후 9.17.26.png)



* 톰캣 설치 완료!!

## Legacy Project 생성하기

* STS 를 실행한 상태에서 Spring Legacy 프로젝트를 생성한다.

  ![image-20200812212100706](sts_Install&Setting.assets/image-20200812212100706.png)

* Spring legacy Project는 maven 기반으로 스프링 프로젝트를 생성할 수 있다.

  ![image-20200812212154083](sts_Install&Setting.assets/image-20200812212154083.png)

* 위에서 Spring MVC Project 로 프로잭트를 생성한다.

* 패키지 명은 꼭 3 Level로 생성한다.

  ![image-20200812212312234](sts_Install&Setting.assets/image-20200812212312234.png)

### porm.xml 설정 변경

* 스프링의 사용은 버전별로 약간씩 상이한 것이 있다.

* 해당 설정은 프로젝트 파일에 있는 porm.xml 파일을 통해 변경이 가능하다.

  ![image-20200812213909216](sts_Install&Setting.assets/image-20200812213909216.png)

* 책의 예제를 따라가기 위해 먼저 스프링 프레임워크의 버전을 3.1.1 에서 5.0.7로 변경해 준다.

  ![image-20200812214011271](sts_Install&Setting.assets/image-20200812214011271.png)

* 또한 첫 project 생성시 JRE의 버전은 1.6으로 생성이 된다. 스프링 5.x 버전을 이용하고 싶다면 1.8을 사용하는것이 가장 좋다고 한다. 해당설정을 1.8 버전으로 변경해 준다. 

  ![image-20200812214202854](sts_Install&Setting.assets/image-20200812214202854.png)

  ![image-20200812214347899](sts_Install&Setting.assets/image-20200812214347899.png)

* 설정후 해당 xml을 저장하면 sts가 알아서 building을 진행해 준다.

  ![image-20200812214448019](sts_Install&Setting.assets/image-20200812214448019.png)

* 혹여나 업데이트가 안된다면 프로젝트 오른쪽 클릭후 maven-Update Project 를 통해 업데이트 해준다

  ![image-20200812214634126](sts_Install&Setting.assets/image-20200812214634126.png)



## tomcat 을 이용하여 프로젝트 실행하기

* 프로젝트를 오른쪽 클릭한 후 아래 목록으로 이동

  ![image-20200812220253623](sts_Install&Setting.assets/image-20200812220253623.png)

* 아래 창에서 위에서 설치한 tomcat 의 버전을 선택.

  ![image-20200812220606142](sts_Install&Setting.assets/image-20200812220606142.png)

* 설정후 next를 하게되면 톰켓의 경로를 설정해야하는데 아래와 같이 경로를 지정한다.(톰켓 파일의 libexec 폴더로 지정)

  ![image-20200812220539594](sts_Install&Setting.assets/image-20200812220539594.png)

* 실행할 프로젝트를 선택후 Finish를 누르면 서버가 켜지면서 웹페이지가 두둥등장!

  ![image-20200812220708192](sts_Install&Setting.assets/image-20200812220708192.png)

  ![image-20200812220751786](sts_Install&Setting.assets/image-20200812220751786.png)

  ![image-20200812220806789](sts_Install&Setting.assets/image-20200812220806789.png)

* 톰켓 설정 완료!!!!

## Lombok 라이브러리 설치

* Lombok 라이브러리를 이용하면 Java 개발 시 자주 사용하는 getter/setter, toString(), 생성자 등을 자동으로 생성해 주므로 약간의 코드만으로도 필요한 클래스를 설계할 수 있다고 한다. (`코배웹` 참고)

* Lombok 은 다른 jar파일들과 달리 Eclipse 에디터 내에서 사용되야 하기 때문에 maven으로 설치할 수 없다.

* [Lombok](https://projectlombok.org/download) 에 들어가 jar파일을 직접 다운로드 받는다. (2020.08.12 기준 버전 - 1.18.12)

  ![image-20200812221354948](sts_Install&Setting.assets/image-20200812221354948.png)

* 다운로드 후 cmd에서 lombok을 실행

  ![image-20200812221836022](sts_Install&Setting.assets/image-20200812221836022.png)

  ![image-20200812222346598](sts_Install&Setting.assets/image-20200812222346598.png)

  ![스크린샷 2020-08-12 오후 10.23.42](sts_Install&Setting.assets/스크린샷 2020-08-12 오후 10.23.42.png)

## Java Configuration

* 예전 스프링에서는 web.xml, context.xml등등 여러 xml 파일로 설정을 하였으나, 최근에는 xml과 별개로 Java를 이용하는 설정이 점점 증가하고 있다.

* 실제 스프링 레거시 Java Configuration을 위해 다음과 같은 작업이 진행한다.

  * `web.xml` 의 파일 사제 및 스프링 관련 파일 삭제

    * `web.xml, servlet-context.xml, root-context.xml` 3개 모두 삭제!

  * `porm.xml` 의 수정 및 스프링 버전 변경

    * 위 3개의 xml을 삭제하면 porm.xml에서 오류가 생김

    * 먼저 plugins 맨 하단에 아래 내용 추가

      ```xml
            <plugin>
      				<groupId>org.apache.maven.plugins</groupId>
      				<artifactId>maven-war-plugin</artifactId>
      				<version>3.2.0</version>
      				<configuration>
      					<failOnMissingWebXml>false</failOnMissingWebXml>
      				</configuration>
      			</plugin>
      ```

    * 이후 작성된 내용들 중 Java, Spring version 변경

      ```xml
      	<properties>
      		<java-version>1.8</java-version>
      		<org.springframework-version>5.0.7.RELEASE</org.springframework-version>
      ```

      ```xml
            <plugin>
      				<groupId>org.apache.maven.plugins</groupId>
      				<artifactId>maven-compiler-plugin</artifactId>
      				<version>2.5.1</version>
      				<configuration>
      					<source>1.8</source>
      					<target>1.8</target>
      					<compilerArgument>-Xlint:all</compilerArgument>
      					<showWarnings>true</showWarnings>
      					<showDeprecation>true</showDeprecation>
      				</configuration>
      			</plugin>
      ```

      

  * `Java` 설정 관련 패키지 생성

    * `@Configuration` 어노테이션을 이용하여 해당 클래스의 인스턴스를 이용해여 설정 파일을 대신함.

    * `src/main/java` 폴더에서 `org.zerock.config` 패키지 안에 `RootConfig.java` 생성.

      ```java
      package org.zerock.config;
      
      import org.springframework.context.annotation.Configuration;
      
      @Configuration
      public class RootConfig {
      	
      }
      
      ```

    * 그후 `web.xml` 을 대신하는 클래스로 `WebConfig.java` 클래스를 하나 생성한다. 해당 클래스는 `AbstractAnnotationConfigDispatcherServletInitializer` 를 상속받는다.

      ```java
      package org.zerock.config;
      
      import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
      
      public class WebConfig extends AbstractAnnotationConfigDispatcherServletInitializer{
      
      	@Override
      	protected Class<?>[] getRootConfigClasses() {
      		// 이전에 작성한 RootConfig.java 파일을 Root로 사용하여 해당 클래스로 값을 반환.
      		return new Class[] {RootConfig.class};
      	}
      
      	@Override
      	protected Class<?>[] getServletConfigClasses() {
      		// TODO Auto-generated method stub
      		return null;
      	}
      
      	@Override
      	protected String[] getServletMappings() {
      		// TODO Auto-generated method stub
      		return null;
      	}
      
      }
      
      ```

      

