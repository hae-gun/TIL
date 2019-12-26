

sqlplus system/1234

alter user hr identified by hr account unlock;		//hr계정 lock해제		

conn hr/hr
sqlplus hr/hr

select * from tab;
select * from employees;

******************************
* TABLESPACE / 관리자만 생성가능 *
******************************
create TABLESPACE mc
datafile 'C:\oraclexe\app\oracle\oradata\XE\mc.dbf'
size 10M
autoextend on next 1M maxsize UNLIMITED;

drop TABLESPACE mc INCLUDING CONTENTS AND Datafiles;

******************************
	계정 생성 , 권한부여, 계정삭제
******************************

create user test01 identified by 1234		//신규계정생성, id : test01, pw: 1234
default TABLESPACE mc;						//기본 TABLESPACE : mc

grant connect,resource,dba to test01;		//연결,자원,dba권한을 test01에게 부여, 관리자 계정으로부여

sqlplus test01/1234

revoke dba from test01;						//test01의 dba권한 회수
revoke connect from test01;					//test01의 접속권한 회수

drop user test01 cascade;					//test01계정 삭제, cascade = 강제

******************************
	SCOTT/TIGER계정 생성
******************************
create user SCOTT identified by TIGER
default TABLESPACE mc;

select * from tab;

@c:\lib\scott.sql;

select * from tab;

set linesize 300;							//table의 행간격 조정, set명령어는 환경세팅 명령어로 cmd창이 끝나면 초기화된다.
set pagesize 20;							//glogin.sql에 저장하면 계속 사용가능(C:\oraclexe\app\oracle\product\11.2.0\server\sqlplus\admin)

select * from emp;							//emp테이블에 있는 컬럼 모두 호출