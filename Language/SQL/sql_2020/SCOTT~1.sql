-- 줄바꿈
select *
from emp;


-- : select: 조회 명령어



select ename,sal,hiredate from emp;

-- 실행 계획과 명령문 통계를 표시합니다. 자동 추적 사용
set autotrace on;
-- 실행 계획과 명령문 통계를 표시합니다. 자동 추적 사용 안함
set autotrace off;


select * from emp;
select * from dept;

select * from emp where sal > 1500;

select ename,job from emp 
where job = 'MANAGER';

-- 산술 연산자 (+, -, *, /)

-- 모든 사원의 이름, 월급, 연봉(월급*12) 를 출력

select ename, sal, sal*12 as yearSal from emp;

-- 성과급 포함 연봉

select ename, sal, sal*12 + comm from emp; -- null 체크를 해야함.

-- null 처리 (nvl)

select ename, sal, sal*12 + nvl(comm,0) as years from emp;

-- alias(별칭) - 컬럼 이름 대신 사용 ------ as 이용

select ename, sal, sal*12 + nvl(comm,0) as 연봉 from emp;
-- as 생략가능
select ename, sal, sal*12 + nvl(comm,0) 연봉 from emp;
select ename, sal, sal*12 + nvl(comm,0) as AnnSal from emp;
select ename, sal, sal*12 + nvl(comm,0) as "Annual Salary" from emp;

select * from dept;

select deptno as 부서번호, dname as 부서명 from dept;

-- concatenation: 문자열 합치기 (각 컬럼값 합치기)

select ename, ' is a ',job from emp;
select ename || ' is a ' ||job from emp;

-- distinct: 중복값이 있으면 한번만 출력

select distinct deptno,job from emp;

-- 비교 연산자 =, >, <, >=, <=, <>(!=,^=): 같지않다.

select * from emp where deptno = 10;
select * from emp where deptno <> 10;


-- 이름이 포드인 사원 조회 (대소문자 구분됨)
select * from emp where ename = 'FORD';

insert into emp (empno, ename) values(1234,'ford');

select * from emp where empno =1234;

select * from emp where hiredate < '81/07/01';

-- 논리 연산자
select * from emp where deptno = 10 and job = 'MANAGER';

select * from emp WHERE sal >=2000 or sal <= 3000;

