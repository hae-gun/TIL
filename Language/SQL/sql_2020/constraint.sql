-- 제약조건 (constraint)
-- integrity(무결성) : 여러 형태의 제약조건을 이용해서 데이터 왜곡을 사전에 방지!

/*

제약조건의 종류
not null: null을 허용하지 않는다. 중복은 관계 없음.
unique: 중복값 허용 안 함
primary key: not null + unique: 행을 유일한 객체로 구분하기 위해서
foreign key: 참조 테이블의 컬럼 값이 있을 때만 허용
check: 저장 가능한 값의 범위, 조건 지정.

*/
create table emp222(
    EMPNO	NUMBER(4,0) primary key,
    ENAME	VARCHAR2(10 BYTE),
    JOB	VARCHAR2(9 BYTE),
    MGR	NUMBER(4,0),
    HIREDATE	DATE,
    SAL	NUMBER(7,2),
    COMM	NUMBER(7,2),
    DEPTNO	NUMBER(2,0) references dept(deptno)
);

insert into emp222 select * from emp;


insert into emp222(empno,ename,deptno) values(3333,'jane',70);
insert into dept(deptno,dname) values(70,'killer');

select * from emp222;


desc emp222;

select OWNER, CONSTRAINT_NAME, CONSTRAINT_TYPE,TABLE_NAME from user_constraints;

-- 제약조건 유형
-- p: primary key/ r: f key/ u: uniqui / c:check, not null
-- table 복제로 생성해도 제약조건은 복사되지 않는다.



create table car(
    car_id number(2) CONSTRAINT pk_car primary key,
    model varchar2(20) CONSTRAINT u_model unique,
    type varchar2(1) CONSTRAINT check_type check(type in ('t','s','w'))
);

desc car;


select OWNER, CONSTRAINT_NAME, CONSTRAINT_TYPE,TABLE_NAME from user_constraints;


insert into car values(11,'p10','sedan'); --"SCOTT"."CAR"."TYPE" (actual: 5, maximum: 1)"SCOTT"."CAR"."TYPE" (actual: 5, maximum: 1)
insert into car values(null,'p10','s'); -- NULL into ("SCOTT"."CAR"."CAR_ID")
insert into car values(11,'p10','s');

insert into car values(11,'p20','w'); -- unique constraint (SCOTT.PK_CAR) violated
insert into car values(22,'p20','w');
insert into car values(33,'p20','t'); -- unique constraint (SCOTT.U_MODEL) violated
insert into car values(33,null,'w'); -- unique 는 null 허용.



alter table car add (price number(4));
-- 제약조건 변경
desc car;
select * from car;

-- not nul 추가
alter table car modify price constraint nn_price not null;
update car set price = 5000;
-- 제약조건추가
alter table car drop constraint U_MODEL;
desc car;
alter table car add constraint U_MODEL unique(model);

delete from car where model is null;
