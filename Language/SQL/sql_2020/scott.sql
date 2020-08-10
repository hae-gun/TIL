select * from tab;
show user;

-- 주석

/*
    블럭주석

*/


-- 단축키
-- 한줄 삭제: ctrl + x
-- 한줄 복사 : ctrl + shift + d
-- comment: ctrl + /


create user tom identified by test;
GRANT create session, connect to tom;

conn tom/test;
show user;

select * from tab;
desc emp;

select * from emp;
desc emp;
select * from dept;
desc dept;

select * from salgrade;


