-- join 조건있어야함 조건의 갯수 = from 갯수 -1개

select * from dept;
select * from emp;

select ename, dname,loc
from emp,dept
where dept.deptno = emp.deptno ;-- emp.deptno = FK, dept.deptno = PK

select ename,deptno, dname,loc
from emp,dept
where  emp.deptno = dept.deptno;

select ename,dept.deptno, dname,loc
from emp,dept
where  emp.deptno = dept.deptno;

select ename,d.deptno, dname,loc
from emp e,dept d
where  e.deptno = d.deptno;

--sal 2000보다 크면서 dept no가 20번 부서에 근무하는 사원의 이름, sal, loc정보 출력.


select ename,sal,loc
from emp e,dept d
where  e.deptno = d.deptno and sal>2000;


******************************************************************
		--Ansi join (표준) : , =>join, join에서의 where => on
******************************************************************

--inner join

select ename, d.deptno, dname, loc
from emp e inner join dept d
on  e.deptno = d.deptno;
		

select ename,sal,loc
from emp e join dept d
on e.deptno = d.deptno
where sal > 2000;

--outer join
--null 쪽에 + 마킹

select ename,d.deptno, dname,loc
from emp e,dept d
where  e.deptno(+) = d.deptno;




select ename,d.deptno, dname,loc
from emp e,dept d
where  e.deptno = d.deptno(+);

-- Ansi join : outer join
-- right 쪽의 테이블이 마스터 테이블이 됨.

select ename,d.deptno, dname,loc
from emp e right outer join dept d
on  e.deptno = d.deptno;

***********************
-- non equi join
***********************

select * from salgrade;
-- oracle join
select ename, sal, grade
from emp,salgrade
where sal between losal and hisal; 


--Ansi join
select ename, sal, grade
from emp join salgrade
on sal between losal and hisal; 

****************************
-- n개의 테이블 join
****************************
-- 사원명, sal, 부서이름, salgrade 출력

-- oracle join
select ename,sal, dname, grade
from emp e, dept d, salgrade s
where e.deptno = d.deptno and sal between losal and hisal and sal >= 1500;

--Ansi join
select ename,sal, dname, grade
from emp join dept on emp.deptno = dept.deptno
		 join salgrade on sal between losal and hisal
		 where sal >=1500;


-- self join
-- 같은 table 2개 가져와서 각각 별칭쓰면 여러개 사용가능.
select e.ename "사원명",nvl(m.ename,'사장') "상사이름" 
from emp e, emp m
where e.mgr = m.empno(+);

select e.ename "사원명",nvl(m.ename,'X') "상사이름"
from emp e left join emp m 
on e.mgr = m.empno;
			
--상사보다 급여 많이 받는사람.

select e.ename "사원명",e.sal,nvl(m.ename,'사장') "상사이름" ,m.sal
from emp e, emp m
where e.mgr = m.empno(+) and e.sal >= m.sal;

select e.ename "사원명",e.sal,nvl(m.ename,'사장') "상사이름" ,m.sal
from emp e left join emp m 
on e.mgr = m.empno
where e.sal >= m.sal;


--집계함수
select ename, round(sal) from emp;

select round(avg(sal))||'원' 전체평균급여 from emp; -- multi row 함수

select deptno,round(avg(sal)) 전체평균급여 from emp group by deptno;



--1.
select e.employee_id "사번", e.first_name "사원이름", d.department_name "부서명",nvl( m.first_name,'x') "상사이름"  
from employees e, employees m, departments d
where e.manager_id = m.employee_id(+) and e.department_id = d.department_id;


--2.

select e.last_name, e.salary
from employees e, employees m
where e.manager_id = m.employee_id and e.salary > m.salary;

--3.

select e.first_name, e.last_name, e.salary
from employees e, jobs j
where e.job_id = j.job_id and j.job_title = 'Sales Representative' and e.salary between 9000 and 10000;

--4.

select e.employee_id, e.last_name, e.hire_date
from employees e, employees m
where e.manager_id = m.employee_id(+) and e.hire_date < m.hire_date;


--5.

select e.first_name, e.hire_date, e.manager_id "MANAGER_ID", m.first_name "MANAGER_NAME"
from employees e, employees m
where e.manager_id = m.employee_id(+) and to_char(e.hire_date,'YY')=08;

--6.

select e.first_name, e.salary, d.department_name
from employees e, departments d
where e.department_id(+)=d.department_id and d.department_name = 'Sales';

--7.

select to_char(e.hire_date,'mm') 월, count(*) 입사자수
from employees e group by to_char(e.hire_date,'mm')
order by to_char(e.hire_date,'mm');


