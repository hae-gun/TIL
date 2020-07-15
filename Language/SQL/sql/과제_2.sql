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

select to_char(e.hire_date,'mm') 월, count(employee_id) 입사자수
from employees e group by to_char(e.hire_date,'mm')
order by 월;