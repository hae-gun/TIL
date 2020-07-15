# Hadoop Day03

* 사용하는 Hadoop 버전 : 2.9.2버전 이용

* `Apache site` 에서 Hadoop 을 다운로드

* 먼저 `namenode` 에서 Hadoop을 압축해제하여 설치.

  * `tar zxvf hadoop~~~~.tar.gz`

* 압축 해제된 폴더를 `/usr/local/hadoop` 으로 이동

  * `mv hadoop-2.9.2 /usr/local/hadoop`

* Hadoop 에서 사용할 디렉토리를 생성.

  ![image-20200521092805343](C:\Users\student\Desktop\Study\Study\md_img\image-20200521092805343.png)

## **환경설정파일을 수정**(중요)

  * 위치: `/usr/local/hedoop/etc/hadoop`

  * 제공된 설정 파일을 해당폴더에 overwrite 해준다.

    ![image-20200521093734822](C:\Users\student\Desktop\Study\Study\md_img\image-20200521093734822.png)

  * hadoop-env.sh

    ![image-20200521093942984](C:\Users\student\Desktop\Study\Study\md_img\image-20200521093942984.png)

    ![image-20200521093958618](C:\Users\student\Desktop\Study\Study\md_img\image-20200521093958618.png)

  * `masters` : `seceondary namenode`설정해 주는 파일.

    ![image-20200521094130256](C:\Users\student\Desktop\Study\Study\md_img\image-20200521094130256.png)

  * `slaves` : `datanode`로 사용할 유저들

     ![image-20200521094318059](C:\Users\student\Desktop\Study\Study\md_img\image-20200521094318059.png)

  * `core-site.xml` : 폴더경로 mapping, hive설정

    ![image-20200521094421048](C:\Users\student\Desktop\Study\Study\md_img\image-20200521094421048.png)

  * `hdfs-site.xml` : 폴더 경로지정, `Port`설정

    ![image-20200521094628090](C:\Users\student\Desktop\Study\Study\md_img\image-20200521094628090.png)

  * 기타 등등.... 설정



* 설정이 끝난후 `scp`를 이용하여 다른 node에게 Hadoop을 복사해준다.

  * `scp -r /usr/local/hadoop root@datanode01:/usr/local`

* 설치 확인

  * `scp /etc/profile root@datanode01:/etc/profile`
  * 각 유저에서 `java -version , hadoop version`으로 설치가 되었나 확인가능.

  ![image-20200521102935340](C:\Users\student\Desktop\Study\Study\md_img\image-20200521102935340.png)

* 하둡실행

  * `namenode` 에서 진행
  * `파일 시스템 포멧` : `hadoop namenode -format`
  * 포멧 후 하둡 실행 : `start-all.sh` 종료 `stop-all.sh`

  ![image-20200521103413116](C:\Users\student\Desktop\Study\Study\md_img\image-20200521103413116.png)

  * 각 노드에서 jps를 실행하여 확인.

    * namenode

    ![image-20200521103507618](C:\Users\student\Desktop\Study\Study\md_img\image-20200521103507618.png)

    * secondary node

    ![image-20200521103540383](C:\Users\student\Desktop\Study\Study\md_img\image-20200521103540383.png)

    

    * 나머지

      ![image-20200521103605836](C:\Users\student\Desktop\Study\Study\md_img\image-20200521103605836.png)



## 명령어

* 하둡시스템에 디렉토리 (폴더)생성

  * `hadoop fs -mkdir /test`

* 디렉토리(폴더) listing

  * `hadoop fs -ls /`

* 하둡시스템에 파일 저장

  * `hadoop fs -put hello.txt /test`

  ![image-20200521115115859](C:\Users\student\Desktop\Study\Study\md_img\image-20200521115115859.png)

* `Java Program`으로 `Hadoop`에 데이터 저장. => `file system`에 직접 접근해서 처리할 예정.

  * 이경우 `Java Program`이 가상머신 안에 있어야 한다. 



* `Maven Repository`에서 필요한 Library를 다운로드. [Hadoop core](https://mvnrepository.com/artifact/org.apache.hadoop/hadoop-core)

## Java를 이용한 Hadoop 실행

1. Java 코드

   ```java
   package javaHadoop;
   
   import org.apache.hadoop.conf.Configuration;
   import org.apache.hadoop.fs.FSDataInputStream;
   import org.apache.hadoop.fs.FSDataOutputStream;
   import org.apache.hadoop.fs.FileSystem;
   import org.apache.hadoop.fs.Path;
   
   public class Exam01_SimpleFileReadWrite {
   
   	public static void main(String[] args) {
   
   		// 1. Hadoop의 실행환경을 알아와야 한다.
   		Configuration conf = new Configuration();
   		try {
   			//Configuration 으로부터 FileSystem을 얻어온다.
   			FileSystem hdfs = FileSystem.get(conf); 
   			String fileName = "test.txt";
   			String contents = "소리없는 아우성!";
   			//경로객체를 설정.
   			Path path = new Path(fileName);
   			
   			// Hadoop file이 있는지 확인 (root 디렉토리에)
   			if(hdfs.exists(path)) {
   				// 똑같은 경로 및 파일이 존재하면 삭제.
   				hdfs.delete(path,true); // true: 물어보지 않고 바로 삭제
   			}
   			// 파일을 생성하고 OutputStream을 리턴받는다.
   			FSDataOutputStream out = hdfs.create(path);
   			out.writeUTF(contents);
   			out.close();
   			
   			// 만들어진 파일에서 데이터를 읽어보기.
   			FSDataInputStream in = hdfs.open(path);
   			String data = in.readUTF();
   			in.close();
   			
   			System.out.println("읽은 내용: " + data);
   			
   		} catch (Exception e) {
   			System.out.println(e);
   		}
   	}
   
   }
   
   ```

   

   

2. 작성한 코드를 Export를 이용하여 Java jar파일로 만들어 Linux에 넣기.

3. `jar`를 실행시키기 위한 `Linux`의 작업 실행 모듈 `yarn` 이용.

   * 작업들을 실행시켜 줄 수 있는 Module.
   * `yarn jar HadoopTest.jar javaHadoop.Exam01_SimpleFileReadWrite`
   * `yarn (실행타입) (실행시킬 파일) (실행시킬 class명(풀패키지명))`

   ![image-20200521140530912](C:\Users\student\Desktop\Study\Study\md_img\image-20200521140530912.png)





## 외부에서 (Host PC-windows) Hadoop에 접근

* `Hive`를 이용. => `mysql`을 가상머신에 설치해야한다.
* `Java Program (JDBC)` 와 같은 개념.
* `Java Program: Hive QL(sql)  ->  Hive: metaStore(DB형식)  ->  Hadoop: MetaData(FileSystem구조)`
* 따라서 Hive는 DB 형태를 갖고 있어야한다.( MySQL 이용)

### Linux에 MySQL 설치

* rpm 파일을 등록하여 설치.

  * `rpm -ivh mysql-community-release-el7-5.noarch.rpm `

* yum 을 이용하여 설치

  * `yum install mysql-server`

* 설치후 MySQL 기동

  * `systemctl start mysqld`

* `Demon` 동작 확인.

  * `systemctl status mysqld`

  ![image-20200521142510704](../../Study/Study/md_img/image-20200521142510704.png)

* 부팅할 때 마다 mysql 이 실행되도록 설정

  * `systemctl enable mysqld`

* 설정이 완료되면 MySQL 에 접속하여 사용자 계정을 생성. `(ID)hive/(PW)hive` 로 계정을 만듬.

  * `mysql -u root`

    ![image-20200521142830692](../../Study/Study/md_img/image-20200521142830692.png)

* 계정생성

  * `create user hive identified by "hive";`
  * `create user hive@localhost identified by "hive";`

  ![image-20200521143057517](../../Study/Study/md_img/image-20200521143057517.png)

* DB생성

  * `create database hivedb;`

    ![image-20200521143123653](../../Study/Study/md_img/image-20200521143123653.png)

* 사용자 권한부여

  * `grant all privileges on hivedb.* to hive;`

  * `grant all privileges on hivedb.* to hive@localhost;`

    ![image-20200521143438971](../../Study/Study/md_img/image-20200521143438971.png)

* 권한 재설정

  * `flush privileges;`

    ![image-20200521143506318](../../Study/Study/md_img/image-20200521143506318.png)

### Hive 설치

* hive tar 파일을 리눅스에 가져와 압축을 해제.

> Hive 설치시 버전이 잘 맞지 않으면 Dependancy 가 잘 안맞을 수 있다.
>
> 또한 Hadoop 이 동작해야 Hive가 동작이 가능하다.
>
> 설치시 Hadoop을 실행하고 설치하자.

* hive 압축 해제
  * `tar zxvf apache-~~~~~~`
* 압축 푼 파일을 이동 
  * `mv apache-hive~~~` /usr/local/hive

* 환경설정.

  * `vi /etc/profile`

    ![image-20200521144415015](../../Study/Study/md_img/image-20200521144415015.png)

  * 설정 후 source로 환경설정 적용.

    ![image-20200521144603428](../../Study/Study/md_img/image-20200521144603428.png)

### Java 프로그램이 MySQL에 연동

* `Java` 프로그램이 `MySQL`에 연동하기 위한 `JDBC Driver jar` 파일을 Hive에 복사

  * `cp mysql-connector-java-commercial-5.1.7-bin.jar /usr/local/hive/lib/`

* `Hive`가 `Hadoop` 내에서 사용할 디렉토리(폴더)를 생성.

  * `hadoop fs -mkdir /tmp`
  * `hadoop fs -mkdir -p /user/hive/warehouse`

  ![image-20200521150828876](../../Study/Study/md_img/image-20200521150828876.png)

* 권한주기

  * `hadoop fs -chmod g+w /tmp`
  * `hadoop fs -chmod g+w /user/hive/warehouse`

* 환경설정 파일 2개를 이동.

  * `hive-env.sh, hive-site.xml` >> `/usr/local/hive/conf` 에 복사

  ![image-20200521151749324](../../Study/Study/md_img/image-20200521151749324.png)

  * hadoop01(namenode) 의 ip로 변경.

## Hive 사용하기

* Hive2.1 부터는 다음의 코드를 한번 수행시켜줘야 한다.

  * `schematool -dbType mysql -initSchema`

  ![image-20200521152130092](../../Study/Study/md_img/image-20200521152130092.png)

* `Hive` 실행하기

  * 경로 설정이 되어있으면 `hive` 를 치면 `hive` 가 실행됨

    ![image-20200521152422194](../../Study/Study/md_img/image-20200521152422194.png)

  * 테이블 생성. 

    ![image-20200521152536624](../../Study/Study/md_img/image-20200521152536624.png)

  * 집계함수 사용

    ![image-20200521152634190](../../Study/Study/md_img/image-20200521152634190.png)

  * 정상동작 확인.



## Host PC(Window) 에서 Hive로 접속

* Host PC(Window) 에서 Eclipse Java 프로그램을 이요해 Hive를 연결하고 Hadoop 에 연결되도록 처리.

* 1단계) VMWare network 설정

  * Edit -> Virtual Network Editor 에서 setting

  ![image-20200521153332039](../../Study/Study/md_img/image-20200521153332039.png)

  * 체크 되어 있어야 함
  * 아래와 같이 보이면 연결성공

  ![image-20200521153355171](../../Study/Study/md_img/image-20200521153355171.png)

  

  

* 2단계)  `hiveserver2` 로 접속을 대기. hive가 서버형태로 기동.

  ![image-20200521153500513](../../Study/Study/md_img/image-20200521153500513.png)

* 3단계) `Java Program` 을 작성하여 `Hive`에 접속.

  * `Java Program` 은 `Maven Project`를 이용.

  ![image-20200521153721636](../../Study/Study/md_img/image-20200521153721636.png)

  * `Group id, Artifact Id 설정`

    ![image-20200521153813510](../../Study/Study/md_img/image-20200521153813510.png)

  * `dependancy 설정` -> `porm.xml`

    ```xml
    		<dependency>
    			<groupId>org.apache.hive</groupId>
    			<artifactId>hive-jdbc</artifactId>
    			<version>0.12.0</version>
    		</dependency>
    		<dependency>
    			<groupId>jdk.tools</groupId>
    			<artifactId>jdk.tools</artifactId>
    			<version>1.8.0_231</version>
    			<scope>system</scope>
    			<systemPath>C:/Program Files/Java/jdk1.8.0_231/lib/tools.jar</systemPath>
    		</dependency>
    		<dependency>
    			<groupId>org.apache.hadoop</groupId>
    			<artifactId>hadoop-common</artifactId>
    			<version>3.2.0</version>
    		</dependency>
    ```

  

* java 코드로 접속

  * JDBC 이용

  ```java
  package test.com.abcde;
  
  import java.sql.Connection;
  import java.sql.DriverManager;
  import java.sql.ResultSet;
  import java.sql.Statement;
  
  /**
   * Hello world!
   *
   */
  public class App {
  	public static void main(String[] args) {
  		Connection conn = null;
  		ResultSet rs = null;
  		try {
  			// 1. Driver Loading
  			String driver = "org.apache.hive.jdbc.HiveDriver";
  			Class.forName(driver);
  
  			// 2. DataBase 접속
  			String url = "jdbc:hive2://192.168.111.128:10000/hivedb"; // default PortNumber -> 10000
  			String id = "hive";
  			String pw = "hive";
  
  			conn = DriverManager.getConnection(url, id, pw);
  
  			// 3. Statement 생성
  			String sql = "select count(*) from mytlb";
  			Statement stmt = conn.createStatement();
  
  			// 4. Query 실행
  			rs = stmt.executeQuery(sql);
  
  			// 5. 결과처리
  			rs.next();
  			int count = rs.getInt(1); // count(*) 값을 가져옴. 결과는 0
  			System.out.println("얻어온 데이터 수: " + count);
  
  			// 6. resource 해제
  			rs.close();
  			stmt.close();
  			conn.close();
  
  		} catch (Exception e) {
  			System.out.println(e);
  		}
  	}
  }
  
  ```

* 결과

  ![image-20200521161707421](../../Study/Study/md_img/image-20200521161707421.png)



