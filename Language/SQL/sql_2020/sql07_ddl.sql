

-- drop : 테이블 날림
-- truncate : 구조는 냅두고 데이터 날림


select rowid,rownum,empno,ename from emp order by ename;


create table sam01(
year01 interval year(5) to month
);


desc sam01;


insert into sam01 values(interval '200' month);
insert into sam01 values(interval '38' month);
insert into sam01 values(interval '44' month);


select * from sam01;
delete from sam01;
rollback;
drop table sam01;


-- 사진저장 BLOB 사실 db에 넣지 않음.

set autocommit off;


-- emp01 테이블 생성: empno 숫자 4자리, ename 글자 20, sal 숫자(총 7자리, 소수점 이하 2자리)
create table emp01(
    empno number(4),
    ename varchar2(20),
    sal number(7,2)
);

desc emp01;

-- table 복제 -> subQuery 이용.

create table emp02
as select * from emp;

desc emp02;

select * from emp02;

--> 특정 컬럼으로 복제 테이블 생성
create table emp03
as
select empno, ename, deptno from emp;

desc emp03;
select * from emp03;

create table emp04
as
select * from emp
where ename like '%A%';

DESC EMP04;

SELECT * FROM EMP04;

-- table 구조만 복제.
create table emp05
as
select * from emp
where 1=0;

select * from emp05;
desc emp05;

-- 테이블 구조 변경 alter
-- add column_name / modify column_name / drop column_name
-- alter table tble_name add (column_name data_type expr);
desc emp03;
alter table emp03 add(job varchar2(20));
select * from emp03;

alter table emp03 modify(job varchar2(30));


desc emp03;


alter table emp03 add(salary number(5));
alter table emp03 modify(salary number(8,2));
alter table emp03 drop(salary);

select * from emp02;
alter table emp02 set UNUSED (hiredate);
alter table emp02 set unused (comm);

select * from user_unused_col_tabs;
select * from all_unused_col_tabs;

alter table emp02 drop unused columns; -- rollback 불가능.
select * from emp02;
rollback; -- ddl 하는 순간 앞에 진행된 dml 모두 commit 진행됨.

-- drop table: 테이블의 데이터는 물론 구조까지 완전 삭제
-- 만약 해당 테이블의 기본키나 고유키를 다른 테이블에서 참조할 경우
-- 우선 참조 테이블을 삭제해야 해당 테이블을 삭제할 수 있다.

-- emp05 삭제
drop table emp05;
desc emp05;
TRUNCATE table emp04;
desc emp04;
select * from emp04;
rollback;

-- rename: 테이블명 변경
rename emp04 to emp05;


desc user_tables;

select * from user_tables;

-- 관리자 차원
select * from dba_data_files;


-- dml
-- commit 하지 않으면 영구 반영되지 않는다. -> rollback 이 가능함. 단 ddl 사용후에는 자동 commit 이 된다.

desc emp05;

create table dept01
as select * from dept
where 0=1;

desc dept01;

-- insert into table_name(column_name...) values( 값...)
-- 행 전체를 입력할 경우엔 컬럼 이름 생략 가능.

-- 10, 'sales', 'seoul' 추가
insert into dept01(deptno,dname,loc) values(10,'sales','seoul');
select * from dept01;

alter table dept01 add(dPhone varchar2(20));
desc dept01;

insert into dept01(deptno, dname,dPhone) values(60,'finance','101-1111-0000');

select * from dept01;

-- 'ace', 'aceTown' 추가
insert into dept01(dname,loc) values('ace', 'aceTown');
-- 테이블 구조 복사는 제약조건은 복사되지 않는다.
insert into dept(dname,loc) values('ace', 'aceTown');

insert into dept values(50,'service','berlin');
insert into dept01 values(50,'service','berlin'); -- 전체 컬럼 입력이 아니라서 에러. 
insert into dept01 values(50,'service','berlin',null);
insert into dept01 values(20,'kill','roma','');


create table emp_hire
as
select empno, ename, hiredate from emp
where 1=0;

create table emp_mgr
as
select empno, ename, mgr from emp
where 1=0;

insert all
into emp_hire values(empno, ename, hiredate)
into emp_mgr values(empno, ename, mgr)
select empno, ename,hiredate,mgr from emp;

select * from emp_hire;
select * from emp;

-- update: 데이터 수정 - where 생략 시 모든 컬럼에 적용
-- update tble_name set column_name = value where condition.

select * from dept01;
update dept01 set dPhone = '1111-2222';
update dept01 set dPhone = '7777-3333' where dname = 'ace';

commit;
rollback;

select * from emp02;
-- 모든 사원 월급 10% 인상
update emp02 set sal = round(sal*1.1);
-- 월급 3000이상이면 5% 감봉
update emp02 set sal = round(sal*0.95) where sal >= 3000;

insert into emp02 values(1111,'김지언','president',7839,3000,20);
update emp02 set job = 'PRESIDENT' where ename = '김지언';

desc emp02;
alter table emp02 add(dname varchar2(20), loc varchar2(20));

select * from emp02;

-- dept 의 dname과 loc의 data를 emp02의 해당 컬럼에 서브쿼리 이용하여 넣기.
select * from dept;
update emp02
set (dname,loc) = (select dname,loc from dept where emp02.deptno = dept.deptno);
commit;
-- delete

-- delete from table_name where condition
-- where 절이 없다면 모든 행이 삭제됨.

delete from emp02;
rollback;


drop table emp03;
create table emp03 as select * from emp;

select * from emp03;

delete from emp03;

-- 81/07/01 이전 입사한 직원 삭제.
delete from emp03 where hiredate < '81/07/01';

-- 부서명이 'SALES'인 직원들 삭제.
delete from emp03 where deptno = (select deptno from dept where dname = 'SALES');

-- merge: 병합.
-- 복제된 테이블에서 변경된 데이터를 본 테이블에 반영 등등.

--merge into emp02
--using emp05
--on (emp02.empno = emp05.empno)
--when matched then
--    update set
--    ~~~~~~~
--when not matched the
--    insert value ~~~~~
    
    





