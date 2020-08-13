select 24 * 60 from dual;
select 24 * 60 from dept; -- 행수만큼 출력함

desc dual;

select sysdate from dual;

insert into emp(empno,ename,hiredate) values(1111,'tom',sysdate);
commit;

-- 숫자함수
-- abs : 절대값
select -10,abs(-10) from dual;
select 3.14159, floor(3.14159) from dual;

select round(3.14159,2) from dual; -- 반올림   
select round(12345.678,-1) from dual;
select trunc(1234567.89),trunc(1234567.89,1), trunc(1234567.89,-3) from dual; -- 특정위치에서 내림



select mod(27,2),mod(77,3), mod(99,6) from dual;
select * from emp where trunc(sal,-3) = 2000;

select * from emp where mod(empno,2) = 1;

-- 문자처리 함수
-- upper: 대문자로

select upper('welcome to oracle') result from dual;
-- 이름에 a가 들어가는 직원의 이름과 급여 대문자로 조회.

select ename, sal from emp where ename like upper('%a%');
select lower(ename) 이름 from emp order by ename desc;


commit;
-- initcap: 첫를자만 대문자로

select initcap(ename) from emp;

select length(ename) from emp;

select lengthb('abcd'), lengthb('한글') from dual; -- 바이트수로  .. 한글 3 - utf-8기준

-- substr/substrb 문자열 잘라내 (문자열, 시작위치, 개수)

select substr('I love you',3,4) from dual;

-- 오늘은 장맛비 오는 날 - 장마비 출력
select substrb('오늘은 장맛비 오는 날',11,9) from dual;

-- instr: 특정 문자의 위치를 구함 ( 문자열, 문자 ) - 해당 문자의 첫 번째 위치 반환
select instr('good day to die', 'd') from dual;

--(문자열, 문자, 시작위치, 몇 번째)
select instr('good day to die', 'd',1,3) from dual;

select substr('good day to die',instr('good day to die', 'd',1,3),3) result from dual;
-- 이름의 3번째 자리가 R인 사원의 이름과 급여 조회

select * from emp where substr(ename,3,1) like 'R';

select * from emp where ename like '__R%';

select * from emp where instr(ename,'R',1,1) = 3;
commit;
-- lpad, rpad : 자리 표시 삽입해서 문자열 길이 맞추기
select lpad('oracle', 20,'#') from dual;
select rpad('oracle', 20,'#') from dual;

select ename, rpad(substr(hiredate,1,2),20,'#') as password from emp;

-- ltrim, rtrim: 빈 칸 지우기 str.trim()

select length(ltrim('   aaa'))aa , length(rtrim('aaa    '))bb, length(trim('   aaa   '))cc from dual;

-- 특정 문자 잘라내기

select trim('a' from 'aaaaaaaaaaaaaaaOracleaaaaaaaaaaaaa') result from dual;
select hiredate from emp;
select ename, round(sysdate-hiredate) 근무일수 from emp;


-- 16일을 기준으로 달을 반올림하여 표시
select ename, hiredate, round(hiredate,'mon') from emp;
-- 달 아래를 내림
select ename, trunc(hiredate,'mon') from emp;

-- months_between: 특정 시점 간의 개월수 (입사 후 근무 개월수)
select ename, round(months_between(sysdate,hiredate)) as 근속월수 from emp;
-- 올림
select ename, round(months_between(sysdate, hiredate)) round, ceil(months_between(sysdate,hiredate)) ceil from emp;

-- add_months(date,number): 특정 시점에 해당 개월 추가해서 반환.
select add_months(sysdate,4) from dual;


select ename as 이름, round(months_between(sysdate,hiredate)) as 근무개월수, 'you''re fired!' as 메시지
from emp
where round(months_between(add_months(sysdate,4),hiredate)) >= 470;

-- next_day : date 이후 특정 요일의 일시: (date, 요일(일(1), 화(3), sun, mon, tue))
-- 현재 이후 다음 주 수요일의 일시 (수, 4, wed)
select sysdate, next_day(sysdate,4) from dual;
select sysdate, next_day(sysdate,'수') from dual;
select sysdate, next_day(sysdate,'WED') from dual;


-- 날짜 설정변경 session ( 오라클 기본 설정 조회 및 수정)
select sys_context('USERENV','LANGUAGE') as "NLS SET" from dual;
select * from nls_session_parameters;
alter session set NLS_DATE_LANGUAGE = 'american';
alter session set NLS_DATE_LANGUAGE = 'korean';

-- 형변환
-- to_char(날짜형, 숫자형 -> 문자형)
-- 날짜 => 문자(format)
select sysdate,to_char(sysdate,'YYYY-MM-DD') from dual;

-- YYYY: 년도 네 자리 / YY: 년도 두 자리
-- MM: 월을 숫자로 / MON: 월을 문(월), 알파벳(영어)으로
-- DAY: 요일 / DY: 요일을 약어로
-- HH: 시간 / HH24: 24시간 단위
-- MI: 분 / SS: 초

select to_char(sysdate,'YYYY-MON-DD DAY HH-MI-SS') from dual;
select to_char(sysdate,'YYYY-MON-DD DAY HH-MI-SS','NLS_DATE_LANGUAGE=English') result from dual;

select ename as 이름, to_char(hiredate, 'YYYY/MM/DD DAY') as Hiredate from emp;

-- 숫자를 문자로 출력
-- 0: 자릿수가 부족할 경우 0으로 채운다.
-- 9: 자릿수, 안 채운다.
-- L: 각 지역별 통화 기호를 앞에 표시
-- .: 소숫점 / , :천단위 구분

-- 이름, 급여(W과 천단위 기호 표시) 출력
select ename, to_char(sal, 'L999,999') salary from emp;
select ename, to_char(sal, 'L999,999','NLS_CURRENCY=$') salary from emp;

-- to_date: 문자열을 오라클 기본 날짜 타입으로 형변환 ('문자','format')

select round(sysdate - '19810501') from dual;
select round(sysdate - to_date('19810501','YY/MM/DD')) from dual;

-- to_number : 숫자형으로 변환
select '20000'-'10000' from dual;
select '20,000'-'10,000' from dual;
select to_number('20,000','99,999') - to_number('10,000','99,999') from dual;

-- nvl: null을 특정 값을 대체
-- mgr이 null 인 사원의 사원번호, 이름, mgr출력(null이면 CEO로)
select empno, ename, nvl(mgr,'CEO') from emp where mgr is null;
desc emp;

select empno, ename, 'CEO' from emp where mgr is null;


select empno, ename, nvl(to_char(mgr),'CEO') as mgr from emp;
select empno, ename, nvl(to_char(mgr),lpad('CEO',4,' ')) as mgr from emp;

-- nvl2(col,a,b): col이 null이 아니면 a, null 이면 b
select empno, ename, nvl2(mgr,to_char(mgr),'CEO') as mgr from emp;

select empno, ename, nvl2(comm, comm, 100) as comm from emp;
select empno, ename, nvl(comm,100) as comm from emp;

-- decode: switch 코드를 값으로 대체하여 출력
select * from emp;
select * from dept;

select empno,deptno,decode(deptno,10,'ACCOUNTING',
                                  20,'RESEARCH',
                                  30,'SALES',
                                  40,'OPERATIONS') as 부서 from emp;

-- job 이 analyst -5% salesman - 10% clerk -20% 인상
--  ename,job,sal, 인상된 급여(default는 그냥 sal)

select ename,job,sal,decode(job,'ANALYST',sal*1.05,
                                'SALESMAN',sal*1.10,
                                'CLERK',sal*1.20,
                                sal) as 급여인상 from emp;
                                
-- case: if ~ else if ~ else : paging, partition 분할시 많이 사용 
                                
                                
select ename, deptno,
    case when deptno=10 then 'ACCOUNTING'
         when deptno=20 then 'RESEARCH'
         when deptno=30 then 'SALES'
         when deptno=40 then 'OPERATIONS'
         
    end as dname
from emp;
delete from emp where ename='tom';
commit;
-- sal 이 1000 미만 -20%, 1000 이상 2000 미만 - 10%, 2000~3000 - 5% 급여인상
-- 이름 직무 급여 인상된급여
select ename, job, sal, case when sal<1000 then round(sal*1.2)
                            when sal>=1000 and sal < 2000 then round(sal*1.1)
                            when sal>=2000 and sal < 3000 then round(sal*1.05)
                            else sal
                        end as 인상된급여
                            from emp;
        
        
-- 단일행 함수 : 원래의 행수만큼 출력 테이블의 각 행에 적용되는 경우

-- 다중 행 함수 (그룹 함수) - 통계 분석에 사용(sum,avg,std)

select job, sum(sal) from emp group by rollup(job);

-- 그룹함수는 null빼고 계산함.

select job,round(avg(sal)) as 평균 from emp group by job;

select count(empno) from emp; -- DB에는 항상 PK가 한개 이상 있어야 한다.

select count(deptno) from emp;
select count(*) from emp; -- 테이블에 존재하는 전체 개체수.
select count(comm) from emp; -- null은 안 센다.

select round(sum(sal)/count(*),2) as 평균급여 from emp;
select round(avg(sal),2) as 평균급여 from emp;

-- 최대 최소,
select max(sal) as max,min(sal) as min from emp;

-- 표준편차
select round(stddev(sal),2) as 표준편차 from emp;

-- 분산
select round(variance(sal),2) as 분산 from emp;

select ename,max(sal) from emp; -- 그룹함수와 단순 컬럼 함계 사용 불가.

select ename,sal from emp where sal = (select max(sal) from emp); -- 서브쿼리

-- job의 갯수를 구하기

select count(job) from emp;
select job from emp order by job;
select count(distinct job) from emp;
select count(distinct(job)) from emp;



-- 가장 최근에 입사한 사원과 가장 오래된 사윈의 입사일 출력
select max(hiredate),min(hiredate) from emp;

-- 30번 부서 사원 중에서 보너스 받는 사원의 수
select count(*) from emp where comm is not null;

select count(comm) from emp where deptno=30;

select * from emp where comm is not null order by comm;

select * from emp where deptno = 30;


--select *
--from emp
--group by 그룹화
--having 그룹조건
--where sal > 3000
--order by sal;

-- group by : 그룹별로 다중행 함수 적용. 컬럼 별칭은 사용할 수 없다.

select deptno from emp group by deptno; -- 그룹별로 묶음.

select distinct deptno from emp; -- 중복값 출력 안함.

select deptno,sum(sal) from emp group by deptno;

-- 부서별 급여 평균: 부서번호, 급여평균 2째자리 반올림
select deptno,count(*),round(avg(sal),2) as 평균 from emp group by deptno order by deptno;

-- having : group by 의 조건을 넣어줌 (group by 의 결과의 조건)
-- 부서별 평균 급여가 2000이 넘는 부서의 번호와 평균 급여 출력

select deptno,round(avg(sal),2) from emp 
group by deptno -- 그룹화
having avg(sal) > 2000; -- 그룹조건

-- 평균 급여가 2000 이상인 부서별, 직무별 그룹에서 급여 3000이상 직원의 부서번호, 직무, 평균급여 출력
-- 정렬 : 부서번호, 직무 오름차순

select deptno, job, avg(sal) from emp 
where sal >=1000
group by deptno,job 
having avg(sal) >= 2000 
order by deptno;

select deptno,job,count(*) from emp
group by deptno, rollup(job);

select deptno,job,count(*) from emp
group by cube(job,deptno);