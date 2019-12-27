

drop table Users;

create table Users(
	id VARCHAR2(30) CONSTRAINT PK_ID primary key,
	pw VARCHAR2(30)
); --테이블 구조 생성.

insert into Users (id,pw) values ('chlgprms0','123456');

select * from Users where id = 'chlgprms0' and pw = '123456';




