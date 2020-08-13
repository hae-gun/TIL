-- TCL Transaction Control Language
-- commit / rollback / savepoint


-- Transaction: DB의 데이터 추가, 변경, 삭제, 생성 등의 요청을 하는 것
-- 데이터 무결성, 일관성: -- all or nothing(처리 or 취소) 데이터 일관성 유지 및 안정적 복구
-- 영구적 변경 전에 데이터 변경사항 확인
-- 논리적으로 연결된 작업을 그룹화( 프로시저, 함수, 트리거 등)


-- 특징 ACID
-- 원자성 Automicity 트랜잭션에 포함된 오퍼레이션 들을 모두 수행되거나, 아니면 전혀 수행되지 않아야 한다.
-- 일관성 Consistency 트랜잭션이 성공적인 경우에는 일관성이 있는 상테에 있어야 한다.
-- 고립성 Isolation 각 트랜잭션을 다른 트랜잭션과 독립적으로 수행되는 것처럼 보여야 한다.
-- 지속성 Durability 성공적으로 수행된 트랜잭션의 결과는 지속성이 있어야 한다.

-- commit:
-- DML 작업 내용을 실제 DB에 저장
-- 모든 사용자가 변경된 데이터 결과를 볼 수 있다.

-- sqlplus 의경우 정상 종료시 commit, 비정상 종료시 rollback.
drop table emp10;
create table emp10 as select * from emp;

select * from emp10;
delete from emp10 where deptno = 20;

rollback;
select * from emp10;

delete from emp10;
select * from emp10;

delete from emp10 where sal >= 3500;
commit;
delete from emp10 where ename like '%A%';

--savepoint;

update emp10 set sal = sal*2 where job = 'SALESMAN';

select * from emp10 order by job desc;
alter table emp10 add(dname varchar2(20)); -- ddl 진행시 이전까지의 dml이 전부 commit
rollback;

update emp10 set sal = sal/2 where job = 'SALESMAN';
truncate table emp09; -- ddl 이 에러가 나도 자동 commit 진행됨.
select * from emp10 order by job desc;

-- savepoint

select * from emp10;
delete from emp10 where deptno = 10;
SAVEPOINT d1;
delete from emp10 where deptno = 20;
SAVEPOINT d2;



