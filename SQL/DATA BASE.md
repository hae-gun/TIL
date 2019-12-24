#### 사용 프로그램

* data base 
  * Oracle Database Express Edition (XE) Release 11.2.0.2.0 (11gR2)

* develope tools
  * SQL developer : Windows 64-bit with JDK 8 included



## DATABASE

---

* ![image-20191223095537559](image-20191223095537559.png)

* Port for 'Oracle Database Listener': 1521 -> 오라클서버. port 1521
* Port for 'Oracle HTTP Listener': 8080





## sqlplus

---

> conn hr/hr
>
> hr/hr 계정으로 로그인.

![image-20191223101455736](image-20191223101455736-1577153524142.png)

![image-20191223101552219](image-20191223101552219-1577153528928.png)

* conn system/1234 -> alter user hr identified by hr account unlock; -> hr/hr 계정 로그인가능.

```sql


sqlplus system/1234  //관리자 로그인.

alter user hr identified by hr account unlock;

conn hr/hr			
sqlplus hr/hr

select * from tab; 
select * from employees; 

```





systen/1234-> select * from employees;  불가능. hr/hr에서 가능

---

## TABLE SPACE



* C:\oraclexe\app\oracle\oradata\XE ->  DBF파일 : 실제 데이터가 들어있는 물리적인 파일.
* USERS.DBF -> hr/hr 파일들 있음.



* table space 관리를 하지 않으면 system영역을 사용하여 문제가 생긴다.



* Table Space 생성.(관리자 계정에서(system/1234))

```sql
sqlplus system/1234

create TABLESPACE mc
datafile 'C:\oraclexe\app\oracle\oradata\XE\mc.dbf'
size 10M
autoextend on next 1M maxsize UNLIMITED;
```

### 계정생성(관리자계정에서)

```sql
create user test01 identified by 1234 -- id test01 pw 1234
default TABLESPACE mc;
```

만든후..

![image-20191223104946460](image-20191223104946460.png)

* 계정은 있지만, 권한이 없어 로그인이 불가능하다.

```sqp

grant connect, resource, dba to test01; --권한부여
```

* test01에게 부여.

```sql
revoke dba from test01; --권한뺏기
```

```sql
drop user test01 cascade; --계정삭제.
```

> cascade : 강제로 명령어 실행.

## SCOTT/TIGER 계정

```sql
create user SCOTT identified by TIGER
default TABLESPACE mc;

@C:\lib/scott.sql; --@는 run. 쓰면 지우고 다시만듬.
```

### select * from emp;

* default UI설정



* C:\oraclexe\app\oracle\product\11.2.0\server\sqlplus\admin 에서 glogin.sql 수정.



```
set linesize 300;  -- dos 에서 환경설정 명령어.
set pagesize 20;

col ename for a10; -- 길이 10byte
col job for a12;
col deptno for 9999; -- 숫자 4자리 
col sal for 9999;
col mgr for 9999;
col comm for 9999;
```





hr/hr -> 스키마 : 사용자 이름이 스키마이다.

system 계정 -> 관리자



## 프로젝트

1. 스키마 설계부터 진행.
2. PK 설정(중복X) Primary key. => null 사용 불가능 (Not Null)
3. FK (Foreign Key) => null 사용 가능  (Null)

> FK는 PK를 Reference. FK 대상키는 반드시PK를 reference 해야한다.



![image-20191223133952838](image-20191223133952838-1577153541150.png)

Field => Row, Column 만나는곳. data가 있음.

Null :  값 없어도됨. 

Not Null : 값 없으면 안됨.

 

#### 정규화 과정

TABLE을 여러개로 쪼개는 과정.

* 역 정규화 과정으로 쪼갠것을 다시 합칠 수 있다.



### 만드는 순서

PK-> FK 지우는건 반대.