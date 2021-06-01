# Docker 에 Jar 빌드하기.



[스프링 부트 도커 레퍼런스](https://spring.io/guides/gs/spring-boot-docker/)

* Dockerfile 작성하기.
* 패키지 최상위 루트 아래 `Dockerfile` 이름으로 file 형태로 생성한후 아래 코드를 작성

`Dockerfile`

```dockerfile
FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
```



* 작성후 아래 커맨드를 터미널에서 실행.

```cmd
# gradle
docker build --build-arg JAR_FILE=build/libs/\*.jar -t '내도커허브아이디/내도커허브Repository이름' .
# maven
docker build -t springio/gs-spring-boot-docker .
```

> ERROR [2/2] COPY build/libs/*.jar app.jar 에러 발생시
>
> -> 해당 프로젝트의 jar파일이 존재하지 않아 발생하는 에러임.
>
> gradle 또는 maven을 이용하여 먼저 해당 프로젝트를 build하여 jar파일을 생성한 후 다시 위의 커맨드를 실행하자.

![image-20210601230842247](무제.assets/image-20210601230842247.png)

* 위와 같은 결과가 나온다면 지정한 이름으로 도커 이미지 build가 완료됨.
* 아래 커맨드를 이용하여 로컬에서 실행 가능하다.

```cmd
docker run -p 8080:8080 '내도커허브아이디/내도커허브Repository이름'
```



## 도커허브에 업로드하기.

```cmd
docker push '내도커허브아이디/내도커허브Repository이름'
```

* 위 커맨드를 통해 도커허브에 업로드 가능하다.
* push중 에러가 나면 docker Hub 에 로그인을 해줘야 함.
* `docker login` 커맨드를 입력하여 로그인을 진행해 준다.







## gcp(cloud)에서 도커 실행 (centos7 기준)

1. 도커 설치 

``sudo yum install docker``

2. 도커 실행

`sudo systemctl start docker`

3. 도커허브 명령어 실행

`sudo docker pull '내도커허브아이디/내도커허브Repository이름'`

4. 이미지 실행

`sudo docker run -p 도커내부포트:gcp외부포트 '내도커허브아이디/내도커허브Repository이름'`



* 실행 후 해당 gcp외부 ip로 내가 올린 프로젝트에 설정한 url로 접속 확인해보기.

> 접속이 안될시, 프로젝트가 올라간 포트번호의 방화벽을 열어줘야함.
>
> 방화벽 규칙 설정에 들어가 해당 포트의 방화벽을 아래와 같이 작성하여 열어준다.
>
> <img src="무제.assets/image-20210601233003772.png" alt="image-20210601233003772" style="zoom:50%;" /> 

* 접속 성공! (아직 아무 서비스없이 h2만 설정한 상황이라 h2 접속으로 확인함.)

<img src="무제.assets/image-20210601233141644.png" alt="image-20210601233141644" style="zoom:50%;" />