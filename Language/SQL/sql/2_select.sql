conn SCOTT/TIGER

select * from emp;
select * from dept;
select * from salgrade;

desc emp;

select ename,sal,deptno			-- emp테이블에서 추출하고 싶은 컬럼
from emp;						-- 추출하고자 하는 테이블 명

-- 사원이름과 입사일
select ename,hiredate
from emp;

-- 부서번호와 부서이름
select deptno,dname
from dept;

-- 중복제거하는 키워드 distinct가 없으면 중복되는 값호출됨
select distinct job
from emp;

-- 테이블에 없는값도 키워드를 넣어서 호출가능(12개월 급여, 세금 등)
select ename,sal,sal*12,sal*0.09 
from emp;

-- 컬럼명 변경, 오라클에서 더블쿼테이션을 쓰는곳은 여기밖에 없음, 다른곳은 문자열 사용시 싱글쿼테이션 사용
-- 오라클에서 as를 생략해도 되지만 MySQL에서는 에러발생
select ename,sal,sal*12 as "년봉" 
from emp;

select ename,job,sal, comm
from emp;

-- null로 연산을하면 결괏값도 null, nvl(comm,-1) = comm이 null일경우 -1로 바꿔라
select ename,job,sal, comm, sal+nvl(comm,0) as "총급여"
from emp;

-- 오라클의 형변환 함수 : to_number, to_date, to_char
select empno,ename,nvl(to_char(mgr),'<<CEO>>') as "manager code"
from emp;

-- pipe기호 = 문자열 연산자 = ||
select ename||job
from emp;

select ename||' '||job
from emp;

-- 연산 키워드를 넣으면 row숫자만큼 같은 결괏값이 출력된다. emp대신 dual을 쓰면 가상의 테이블로 1개 값만 출력된다.
select 20*20*4
from dual;

select sysdate
from dual;

select user
from dual;

-- row 제한을 걸때 where 절, = 비교연산자로 사용
select ename,job,deptno
from emp
where deptno = 10;

select ename,job,deptno
from emp
where job = 'MANAGER';

select ename,job,deptno
from emp
where upper(job) = upper('manager');

select sysdate
from dual;

select ename,hiredate
from emp
where hiredate > '82/01/01';

select ename,hiredate
from emp
where hiredate = '81/05/01';

-- <> : not equal, Oracle, MySQL모두 똑같이 사용, 오라클은 != 이걸로도 사용
select ename,hiredate
from emp
where hiredate != '81/05/01';

select ename,hiredate
from emp
where hiredate <> '81/05/01';

-- between and
select ename,job,sal
from emp
where sal > 2000;

select ename,job,sal
from emp
where sal>= 2450 and sal <=3000;

-- between and함수, 이상,이하로 같은값 포함, 작은값이 반드시 앞에 와야함
select ename,job,sal
from emp
where sal between 2450 and 3000;

-- X
select ename,job,sal
from emp
where sal between 50000 and 3000;

-- in연산자
select ename, job, deptno
from emp
where deptno = 10 or deptno = 20;

select ename, job, deptno
from emp
where deptno in(10,20);

select *
from dept;

-- deptno가 10이면서 NEW YORK이고 20이면서 DALLAS인 결괏값 추출
-- (deptno,loc) = and, ((10, 'NEW YORK'),(20,'DALLAS')) = or
select *
from dept
where (deptno,loc) in((10, 'NEW YORK'),(20,'DALLAS'));


-- like 연산자, 이름이 A로 시작하는 사람 검색, %=모든 글자 가능
select *
from emp
where ename like 'A%';

-- 이름중에 A가 포함된 사람
select *
from emp
where upper(ename) like upper('%a%');

-- 이름중에 A뒤에 2글자가 포함된 사람
select *
from emp
where ename like '%A__';

-- 81년도에 입사한 사원 목록
select *
from emp
where hiredate like '81%';

--where 절 NULL처리
select *
from emp
where mgr is null;

select *
from emp
where mgr is not null;

select ename,sal,comm,sal+nvl(comm,0) as "총급여" 
from emp
where sal+nvl(comm,0) >= 2000;
--nvl -> null 이면 ,뒤에로 처리해서 계산., where 절에서는 별칭사용 불가능하다.

--정렬
select
from
where
order by

select ename,sal,comm,sal+nvl(comm,0) as "총급여" 
from emp
order by sal; -- 기본은 오름차순 asc 는 생략됨.

select ename,sal,comm,sal+nvl(comm,0) as "총급여" 
from emp
order by sal desc;  --desc 이용 내림차순.

--2차 기준

select ename,sal,comm,sal+nvl(comm,0) as "총급여" 
from emp
order by sal asc , comm desc;

select ename,sal,sal+nvl(comm,0) as "총급여" 
from emp
order by sal asc , comm desc;

select ename,sal,sal+nvl(comm,0) as "총급여" 
from emp
where sal+nvl(comm,0) >= 2000
order by "총급여"; -- order절은 별칭사용가능.

select ename,sal,sal+nvl(comm,0) as "총급여" 
from emp
where sal+nvl(comm,0) >= 2000
order by 3; --위치 index 사용가능. but 권장x


conn hr/hr
select * from employees;


conn SCOTT/TIGER
-- 단일행 함수.


select dname,lower(dname) ,loc, lower(loc)
from dept;


select round(44.55),round(44.55,1),trunc(44.55)
from dual; 


select sal, trunc(sal*0.03) as "TAX"
from emp;


select ename, hiredate, substr(hiredate,4,2) as 입사월
from emp;


-- 사원의 입사 월이 12인 정보 추출
select ename, hiredate, substr(hiredate,4,2) as 입사월
from emp
where substr(hiredate,4,2) = '12';

select sysdate ,sysdate+30 from dual;

select sysdate ,substr(sysdate,4,2) from dual;

select sysdate ,to_char(sysdate,'YY') from dual;
select sysdate ,to_char(sysdate,'YYYY') from dual;
select sysdate ,to_char(sysdate,'day') from dual;
select sysdate ,to_char(sysdate,'mm') from dual;
select sysdate ,to_char(sysdate,'dd') from dual;

-- emp에서 사원 들의 입사월,요일 정보를 출력하세요.
select ename as 이름, to_char(hiredate,'mm') as "입사월", 
					 to_char(hiredate,'dd') as "입사일", 
					 to_char(hiredate, 'day') as "입사요일"
from emp
order by "입사월";


select sysdate, to_date('2019-12-24') from dual;
select sysdate, to_date('2019/12/24') from dual;
select sysdate, to_date('2019 12 24') from dual;
select sysdate, to_date('19/12/24') from dual;

select sysdate, to_date('12/24/19','mm/dd/yy') from dual;

-- decode 함수

select ename, sal, deptno,decode(deptno, 10 ,sal*1.2,
										 20 ,sal*0.7,
											sal										 
										) as "보너스"
from emp
order by deptno;








