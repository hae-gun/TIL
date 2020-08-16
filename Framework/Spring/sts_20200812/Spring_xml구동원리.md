# 스프링 Day02

## 스프링 구동시 프로젝트의 로딩 구조

### 1. web.xml

* 스프링 프로젝트가 정상적으로 실행되었다면 서버의 구동 시 약간의 로그가 기록된다.
* 해당 로그를 이용해 어떤 과정을 통해서 프로젝트가 실행되는지 엿볼 수 있다.
* 가장 먼저 프로젝트의 구동은 web.xml에서 시작한다.
* xml 의 경우 web.xml에서 Context Listener로 등록된 부분이 실행되면서 root-context.xml 의 경로를 찾고 해당 컨텍스트를 읽어드린다.
* Java configuration으로 진행한 경우 WebConfiguration.class 가 동작하면서 getRootConfigClasses() 매서드를 실행하여 해당 매서드의 반환값인 RootConfig.class의 위치를 반환하게 된다.

```console
INFO: 1 Spring WebApplicationInitializers detected on classpath
8월 15, 2020 10:23:37 오후 org.apache.catalina.core.ApplicationContext log
INFO: Initializing Spring root WebApplicationContext
INFO : org.springframework.web.context.ContextLoader - Root WebApplicationContext: initialization started
INFO : org.springframework.web.context.support.AnnotationConfigWebApplicationContext - Refreshing Root WebApplicationContext: startup date [Sat Aug 15 22:23:37 KST 2020]; root of context hierarchy
INFO : org.springframework.web.context.support.AnnotationConfigWebApplicationContext - Registering annotated classes: [class org.zerock.config.RootConfig]
```



### 2. root-context.xml

* web.xml 을 통해 root-context.xml 이 처리되면서 파일에 있는 빈(Bean) 설정들이 동작한다.
* xml에 정의된 객체들은 스프링의 영역(context) 안에 생성되고 객체들 간의 의존성이 처리된다.
* root-context.xml 이 처리된 후에는 스프링 MVC에서 사용하는 DispatcherServlet이라는 서블릿 관련 설정이 동작한다.

```console
INFO : org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor - JSR-330 'javax.inject.Inject' annotation found and supported for autowiring
INFO : org.springframework.web.context.ContextLoader - Root WebApplicationContext: initialization completed in 546 ms
```



### 3. DispatcherServlet

* 해당 클래스는 스프링 MVC 구조에서 가장 핵심적인 역할을 하는 클래스이다.
* 내부적으로 웹 관련 처리의 준비작업을 진행하는데 이때 사용하는 파일이 servlet-context.xml 파일이다.
* DispatcherServlet에서 XmlWebApplicationContext를 이용해서 servlet-context.xml을 로딩하고 해석하게 된다.
* 이 과정에서 등록된 객체(Bean)들은 앞에 만들어진 객체들과 같이 연동되게 된다.

```console
INFO: Initializing Spring FrameworkServlet 'dispatcher'
INFO : org.springframework.web.servlet.DispatcherServlet - FrameworkServlet 'dispatcher': initialization started
INFO : org.springframework.web.context.support.AnnotationConfigWebApplicationContext - Refreshing WebApplicationContext for namespace 'dispatcher-servlet': startup date [Sat Aug 15 22:23:37 KST 2020]; parent: Root WebApplicationContext
INFO : org.springframework.web.context.support.AnnotationConfigWebApplicationContext - Registering annotated classes: [class org.zerock.config.ServletConfig]
INFO : org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor - JSR-330 'javax.inject.Inject' annotation found and supported for autowiring
INFO : org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping - Mapped "{[/],methods=[GET]}" onto public java.lang.String org.zerock.controller.HomeController.home(java.util.Locale,org.springframework.ui.Model)
INFO : org.springframework.web.servlet.handler.SimpleUrlHandlerMapping - Mapped URL path [/resources/**] onto handler of type [class org.springframework.web.servlet.resource.ResourceHttpRequestHandler]
INFO : org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter - Looking for @ControllerAdvice: WebApplicationContext for namespace 'dispatcher-servlet': startup date [Sat Aug 15 22:23:37 KST 2020]; parent: Root WebApplicationContext
INFO : org.springframework.web.servlet.DispatcherServlet - FrameworkServlet 'dispatcher': initialization completed in 768 ms
8월 15, 2020 10:23:38 오후 org.apache.coyote.AbstractProtocol start
```



