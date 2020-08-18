-- sequence

-- nextval
-- currval

create sequence dragon_player_id;


--문법
--CREATE SEQUENCE [시퀀스명]
--INCREMENT BY [증감숫자] --증감숫자가 양수면 증가 음수면 감소 디폴트는 1
--START WITH [시작숫자] -- 시작숫자의 디폴트값은 증가일때 MINVALUE 감소일때 MAXVALUE
--NOMINVALUE OR MINVALUE [최솟값] -- NOMINVALUE : 디폴트값 설정, 증가일때 1, 감소일때 -1028 
                               -- MINVALUE : 최소값 설정, 시작숫자와 작거나 같아야하고 MAXVALUE보다 작아야함
--NOMAXVALUE OR MAXVALUE [최대값] -- NOMAXVALUE : 디폴트값 설정, 증가일때 1027, 감소일때 -1
                               -- MAXVALUE : 최대값 설정, 시작숫자와 같거나 커야하고 MINVALUE보다 커야함
--CYCLE OR NOCYCLE --CYCLE 설정시 최대값에 도달하면 최소값부터 다시 시작 NOCYCLE 설정시 최대값 생성 시 시퀀스 생성중지
--CACHE OR NOCACHE --CACHE 설정시 메모리에 시퀀스 값을 미리 할당하고 NOCACHE 설정시 시퀀스값을 메로리에 할당하지 않음

-- index(색인): 빠른 검색을위해 사용
-- tree 형식으로 생성되므로 생성에 시간도 필요하고 추가 공간도 필요
-- 새로 행을 입력, 삭제할 때 인덱스로 사용된 컬럼이 변경되면 인덱스도 수정이 필요하다
-- DML 작업이 빈번한 컬럼에 인덱스를 생성하면 오히려 성능이 더 떨어진다.

-- 기본키, unique는 데이터 무결성을 확인하기 위해 수시로 데이터를 검색하므로 인덱스 자동 생성
-- 자동 생성되는 인덱스는 constaint name(pk, unique 제약조건의 이름)을 사용한다.

--select index_name, table_name, column_name from user_ind_columns;
--where table_name in ('EMP','EMP_COPY','DEPT','CAR');

create table emp_index
as
select * from emp;

-- emp_index 데이터 1000배 늘리기.

insert into emp_index select * from emp_index;

select count(*) from emp_index;


insert into emp_index(empno,ename) values(9999,'tom');

-- index 생성
create index emp_index_ename_idx on emp_index(ename);
SELECT  file_name, bytes
       FROM  dba_data_files
      WHERE  tablespace_name = 'RBS';
select value from v$parameter where name = 'db_block_size';
select bytes/1024/1024 as mb_size,
       maxbytes/1024/1024 as maxsize_set,
       x.*
from   dba_data_files x;

alter database datafile '/u01/app/oracle/oradata/XE/undotbs1.dbf' autoextend on maxsize unlimited;
alter tablespace system add datafile '/u01/app/oracle/oradata/XE/users.dbf' size 10m autoextend on maxsize unlimited;

ALTER DATABASE TEMPFILE '/oradata/temp02.dbf' DROP INCLUDING DATAFILES;
ALTER TABLESPACE TEMP ADD TEMPFILE '/u01/app/oracle/oradata/XE/temp03.dbf' SIZE 100M;
select value from v$parameter where name = 'db_block_size';

select bytes/1024/1024 as mb_size,
       maxbytes/1024/1024 as maxsize_set,
       x.*
from   dba_data_files x;
alter database datafile '/u01/app/oracle/oradata/XE/system.dbf'autoextend on maxsize unlimited;

alter tablespace system add datafile '/u01/app/oracle/oradata/XE/users.dbf' size 10m autoextend on maxsize unlimited;

ALTER USER COTT TEMPORARY TABLESPACE TEMP;





-- 객체 권한
-- select, update, insert, delete
-- index, alter, execute,references
-- 권한을 부여받은 사람(scott)이 부여 해당 권한을 다른 사용자에게 부여할 수 있는 명령
-- with grant option/ with admin option



show user;
create user rex identified by color;





